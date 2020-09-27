/**
 * Класс команды Remove_by_id
 * @author SaintLaurentPrince and Mariec
 * @version 1.0
 */

package Commands;

import Controller.Commandable;
import Controller.RouteCollection;
import RouteObject.Route;
import Utilities.DBworking;

import java.net.Socket;
import java.sql.SQLException;
import java.util.Iterator;

public class Remove_by_id implements Commandable {
    RouteCollection collection = new RouteCollection();

    @Override
    public String execute(Object o, Socket socket, String user) {
        DBworking dBworking = new DBworking();
        try {
            dBworking.loadAllRoutes();

        if (collection.getSize() == 0) return ("Коллекция пустая.");
        else {
            boolean isRemoved = false;
            int id = 0;
            try {
                id = Integer.parseInt((String) o);
            } catch (NumberFormatException exp) {
            }
            Iterator<Route> it = (Iterator<Route>) collection.getCollection().iterator();
            while (it.hasNext()) {
                Route route = (Route) it.next();
                int humanId = (int) route.getId();
                if (id == humanId  && route.getUser().equals(user)) {
                    it.remove();
                    isRemoved = true;
                    dBworking.uploadAllRoute();
                    return ("Трасса успешно удалена.");
                }
            }
            if (!isRemoved) return ("Элемента с таким id не существует или он не принадлежит вам.");
        }
        } catch (SQLException e) {
        return "Ошибка подключения к базе";
    }
        return null;
    }

    @Override
    public String getName() {
        return "remove_by_id";
    }
}
