/**
 * Класс команды Sort
 *
 * @author SaintLaurentPrince and Mariec
 * @version 1.0
 */

package Commands;

import Controller.CommandWithoutArg;

import java.net.Socket;


public class Sort implements CommandWithoutArg {

    @Override
    public String execute(Object o, Socket socket, String user) {
//        DBworking dBworking = new DBworking();
//        try {
//            dBworking.loadAllRoutes();
//
//        RouteCollection collection = new RouteCollection();
//        if (collection.getSize() != 0) {
//            collection.toSortArray();
//            long i=0;
//            long amount= RouteCollection.getFreeId();
//            for (Route route: collection.getCollection()){
//                if (route.getId() < amount){
//                    i++;
//                    route.setId(i);
//                }
//            }
//            dBworking.uploadAllRoute();
//            return ("Коллекция успешно отсортировна.");
//        } else return ("Коллекция пустая.");
//        } catch (SQLException e) {
//         return "Ошибка подключения к базе";
//    }
        return null;
    }

    @Override
    public String getName() {
        return "sort";
    }
}