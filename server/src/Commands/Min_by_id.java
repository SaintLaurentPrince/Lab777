/**
 * Класс команды Min_by_id
 * @author SaintLaurentPrince and Mariec
 * @version 1.0
 */

package Commands;

import Controller.CommandWithoutArg;
import Controller.RouteCollection;
import Utilities.DBworking;

import java.net.Socket;
import java.sql.SQLException;


public class Min_by_id implements CommandWithoutArg {
    @Override
    public String execute(Object o, Socket socket, String user) {
        DBworking dBworking = new DBworking();
        try {
            dBworking.loadAllRoutes();
        } catch (SQLException e) {
            return "Ошибка подключения к базе";
        }
        RouteCollection collection = new RouteCollection();
        if (collection.getSize() != 0) return (collection.getMinById().getInfo());
        else return ("Коллекция пустая.");
    }

    @Override
    public String getName() {
        return "min_by_id";
    }
}
