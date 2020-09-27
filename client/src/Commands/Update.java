/**
 * Класс команды Update
 *
 * @author SaintLaurentPrince and Mariec
 * @version 1.0
 */

package Commands;

import Controller.Commandable;

import java.net.Socket;

public class Update implements Commandable {

    @Override
    public String execute(Object o, Socket socket, String user) {
//        ServerSender serverSender = new ServerSender();
//        ServerReceiver serverReceiver = new ServerReceiver();
//        DBworking dBworking = new DBworking();
//        RouteCollection collection = new RouteCollection();
//        try {
//            dBworking.loadAllRoutes();
//            if (collection.isIndexBusy(Integer.parseInt((String) o))) {
//                int id = Integer.parseInt((String) o);
//                Route route1 = null;
//                String oldName = "";
//                for (Route route : collection.getCollection()) {
//                    if (route.getId() == id && route.getUser().equals(user)) {
//                        route1 = route;
//                    }
//                }
//                serverSender.send(socket, route1, 2);
//                Route route = (Route) serverReceiver.receive(socket);
//                if (route != null) {
//                    route.setUser(user);
//                    collection.add(route);
//                    int ok = Integer.parseInt((String) o);
//                    collection.update(ok);
//                    dBworking.uploadAllRoute();
//                }
//                return ("Трасса [id:" + o + "] успешно обновлена.");
//            } else return ("Элемента с таким id не существует или он не принадлежит вам.");
//        } catch (SQLException e) {
//            return "Ошибка подключения к базе";
//        } catch (Exception e) {
//            return ("Элемента с таким id не существует.");
//        }
        return null;
    }

    @Override
    public String getName() {
        return "update";
    }
}

