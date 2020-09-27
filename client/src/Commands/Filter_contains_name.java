/**
 * Класс команды Filter_contains_name
 *
 * @author SaintLaurentPrince and Mariec
 * @version 1.0
 */

package Commands;

import Controller.Commandable;

import java.net.Socket;

public class Filter_contains_name implements Commandable {
    @Override
    public String execute(Object o, Socket socket, String user) {
//        DBworking dBworking = new DBworking();
//        try {
//            dBworking.loadAllRoutes();
//        } catch (SQLException e) {
//            return "Ошибка подключения к базе";
//        }
//        String subSt = (String) o;
//        boolean was = false;
//        RouteCollection collection = new RouteCollection();
//        String result = "";
//        if (collection.getSize() == 0) return ("Коллекция пустая.");
//
//        else {
//            StringBuilder builder = new StringBuilder("");
//            collection.getCollection().stream().filter(x -> x.getName().contains(subSt)).forEach(x -> builder.append(x.getInfo() + "\n"));
//            if (builder.toString().equals("")) return ("Нет таких элементов в коллекции");
//            else return builder.toString();
//        }
        return null;
    }


    @Override
    public String getName() {
        return "filter_contains_name";
    }
}
