/**
 * Класс команды Show
 *
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

public class Show implements CommandWithoutArg {


    @Override
    public String execute(Object o, Socket socket, String user) {
        RouteCollection collection = new RouteCollection();
        DBworking dBworking = new DBworking();
        try {
            dBworking.loadAllRoutes();
        } catch (SQLException e) {
            return "Ошибка подключения к базе";
        }
        String result = "";
        if (collection.getSize() == 0) return ("Коллекция пустая.");
        else for (Route route : collection.getCollection()) {
            result += (route.getInfo()) + "\n---------------------------\n";
        }
        return result;
    }

    @Override
    public String getName() {
        return "show";
    }
}
