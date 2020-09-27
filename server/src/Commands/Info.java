/**
 * Класс команды Info
 * @author SaintLaurentPrince and Mariec
 * @version 1.0
 */

package Commands;

import Controller.CommandWithoutArg;
import Controller.RouteCollection;

import java.net.Socket;


public class Info implements CommandWithoutArg {
    RouteCollection collection = new RouteCollection();

    @Override
    public String execute(Object o, Socket socket, String user) {
        return(collection.getInfo());
    }

    @Override
    public String getName() {
        return "info";
    }
}