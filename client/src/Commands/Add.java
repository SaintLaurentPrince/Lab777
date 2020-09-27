/**
 * Класс команды Add
 *
 * @author SaintLaurentPrince and Mariec
 * @version 1.0
 */

package Commands;

import Controller.CommandWithoutArg;
import Controller.Commandable;
import Controller.RouteCollection;

import java.net.Socket;

public class Add implements CommandWithoutArg {
    RouteCollection collection = new RouteCollection();

    /**
     * @param o название трассы
     * @return
     */

    @Override
    public String execute(Object o, Socket socket, String user) {
//        DBworking dBworking = new DBworking();
//        ServerSender serverSender = new ServerSender();
//        ServerReceiver serverReceiver = new ServerReceiver();
//        serverSender.send(socket,"",1);
//       Route r= (Route) serverReceiver.receive(socket);
//        if (r!=null) {
//            try {
//                dBworking.loadAllRoutes();
//
//            r.setId(RouteCollection.getFreeId());
//            r.setUser(user);
//            collection.add(r);
//            dBworking.uploadAllRoute();
//        return ("Трасса успешно добавлена.");
//
//        } catch (SQLException e) {
//        return "Ошибка подключения к базе";
//        }
//        }
        return "Трасса не добавлена";
    }

    @Override
    public String getName() {
        return "add";
    }
}