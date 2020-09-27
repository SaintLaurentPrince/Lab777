/**
 * Класс команды Add_if_min
 *
 * @author SaintLaurentPrince and Mariec
 * @version 1.0
 */

package Commands;

import Controller.Commandable;

import java.net.Socket;

public class Add_if_min implements Commandable {

    /**
     * @param o название трассы
     * @return
     */

    @Override
    public String execute(Object o, Socket socket, String user) {
//        ServerSender serverSender = new ServerSender();
//        DBworking dBworking = new DBworking();
//        ServerReceiver serverReceiver = new ServerReceiver();
//        if ((new RouteCollection().getSize() != 0)) {
//            Vector<Route> collection = RouteCollection.getCollection();
//            Collections.sort(collection);
//            serverSender.send(socket,"",1);
//            Route sample = ((Route) serverReceiver.receive(socket));
//            if (sample.compareTo(collection.get(0)) < 0) {
//                if (sample!=null) {
//                    try {
//                        dBworking.loadAllRoutes();
//
//                    sample.setId(RouteCollection.getFreeId());
//                    sample.setUser(user);
//                    collection.add(sample);
//                    dBworking.uploadAllRoute();
//                    } catch (SQLException e) {
//                        return "Ошибка подключения к базе";
//                }
//                }
//                return ("Трасса успешно добавлена.");
//            } else return ("Элемента меньше не оказалось");
//        } else return ("Коллекция пустая, даже сравнить не с чем(");
        return null;
    }

    @Override
    public String getName() {
        return "add_if_min";
    }
}
