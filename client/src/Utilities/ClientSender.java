package Utilities;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * The type Client sender.
 */
public class ClientSender {
    public static Boolean serverisconnected = false;
    public static int port;
    public static String host;
    public static void send(Object o) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(ClientReceiver.sock.getOutputStream());
            objectOutputStream.writeObject(o);

        } catch (IOException e) {
            System.out.println("Произошла некоторая ошибка,необходимо переподключение.");
            ClientSender.serverisconnected = false;
        }
    }
    public static void tryToConnect() throws InterruptedException {

            try {
                Socket socket = new Socket(host, port);
                serverisconnected = true;
                System.out.println("Успешно подключено к серверу.");
                ClientReceiver.sock = socket ;

            }
            catch (IOException e){
                System.out.println("Похоже,что сервер отключен или недоступен,попробуйте позже.");
            }
    }
}
