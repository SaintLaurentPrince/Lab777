/**
 * Класс команды Remove_first
 *
 * @author SaintLaurentPrince and Mariec
 * @version 1.0
 */

package Commands;

import Controller.CommandWithoutArg;

import java.net.Socket;

public class Remove_first implements CommandWithoutArg {
    @Override
    public String execute(Object o, Socket socket, String user) {
//        RouteCollection collection = new RouteCollection();
//        if (collection.getSize() != 0) {
//            int size =  collection.getSize();
//            if (RouteCollection.getCollection().get(0).getUser().equals(user)) RouteCollection.getCollection().remove(0);
//            if (size>collection.getSize()) return "Первый элемент вам не принадлежит";
//            long i=0;
//            int amount= collection.getSize()+2;
//            for (Route route: collection.getCollection()){
//                if (route.getId() < amount){
//                    i++;
//                    route.setId(i);
//                }
//            }
//            return ("Первый элемент успешно удален.");
//
//        }
//        else return ("Коллекция итак пустая");
        return null;
    }

    @Override
    public String getName() {
        return "remove_first";
    }
}
