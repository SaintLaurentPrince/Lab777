/**
 * Класс команды Show
 *
 * @author SaintLaurentPrince and Mariec
 * @version 1.0
 */

package Commands;


import Controller.CommandWithoutArg;

import java.net.Socket;

public class Show implements CommandWithoutArg {


    @Override
    public String execute(Object o, Socket socket, String user) {
//        RouteCollection collection = new RouteCollection();
//        DBworking dBworking = new DBworking();
//        try {
//            dBworking.loadAllRoutes();
//        } catch (SQLException e) {
//            return "Ошибка подключения к базе";
//        }
//        String result = "";
//        if (collection.getSize() == 0) return ("Коллекция пустая.");
//        else for (Route route : collection.getCollection()) {
//            result += (route.getInfo()) + "\n";
//        }
//
//        return result;
        return null;
    }

    @Override
    public String getName() {
        return "show";
    }
}
