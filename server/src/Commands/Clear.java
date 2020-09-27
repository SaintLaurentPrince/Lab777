/**
 * Класс команды Clear
 * @author SaintLaurentPrince and Mariec
 * @version 1.0
 */

package Commands;

import Controller.CommandWithoutArg;
import Controller.RouteCollection;
import RouteObject.Route;
import Utilities.DBworking;

import java.net.Socket;
import java.sql.SQLException;
import java.util.Vector;

public class Clear implements CommandWithoutArg {


	@Override
	public String execute(Object o, Socket socket, String user) {
		Vector<Route> routesToSave = new Vector<>();
		DBworking dBworking = new DBworking();
		try {
			dBworking.loadAllRoutes();

		RouteCollection.getCollection().stream().filter(x->!(x.getUser().equals(user))).forEach(routesToSave::add);
		RouteCollection.setCollection(routesToSave);
		dBworking.uploadAllRoute();
		} catch (SQLException e) {
			return "Ошибка подключения к базе";
	}
		return("Коллекция успешно очищена от ваших трасс.");
	}

	@Override
	public String getName() {
		return "clear";
	}
}