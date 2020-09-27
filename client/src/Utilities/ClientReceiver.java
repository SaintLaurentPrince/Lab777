package Utilities;

import RouteObject.Route;
import RouteObject.RouteBuilder;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * The type Client receiver.
 */
public class ClientReceiver {
    ClientSender clientSender;

    /**
     * The constant client.
     */
    public  static Socket sock;
    private static ByteBuffer buffer = ByteBuffer.allocate(10000);
    public static Object receive() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(sock.getInputStream());
        Object obj = objectInputStream.readObject();
        RouteBuilder routeBuilder = new RouteBuilder();
        Map<Object,Integer> answerMap = (Map<Object, Integer>) obj;
        obj = answerMap.entrySet().iterator().next().getKey();
        int a = answerMap.entrySet().iterator().next().getValue();
        if (a == 0) {
            return obj;
        }
        // новый маршрут
        else if (a == 1){
            System.out.println("Необходимо заполнить доп.данные для выполнения команды");
            ClientSender.send(routeBuilder.create());
            obj =receive();
        }
        // апдейт маршрута с номером
        else if (a == 2){
            System.out.println("Необходимо заполнить доп.данные для выполнения команды");
            Route route = (Route)obj;
            RouteBuilder.routeToUpd = route;
            ClientSender.send(routeBuilder.create());
            RouteBuilder.routeToUpd = null;
            obj =receive();
        }
        //заполнить поля необходимые
        else if (a==3){
            System.out.println("Ответ с сервера: "+obj);
            System.out.print("~");
            Scanner reader = new Scanner(System.in);
            String s = reader.nextLine();
            ClientSender.send(s);
            ClientReceiver.receive();

        }

        return obj;
    }
}