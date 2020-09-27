/**
 * Класс main
 *
 * @author SaintLaurentPrince and Mariec
 * @version 1.0
 */


import Commands.*;
import Controller.Commandable;
import Controller.Commands;
import Utilities.ClientReceiver;
import Utilities.ClientSender;
import Utilities.Console;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.nio.channels.SocketChannel;
import java.util.Map;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        boolean flag = true;
        Scanner in = new Scanner(System.in);
        ClientSender clientSender = null;
        while(!ClientSender.serverisconnected) {
            try {
                System.out.print("Введите хост сервера\n~ ");
                ClientSender.host = in.nextLine();
                System.out.print("Введите порт сервера\n~ ");
                int port = Integer.parseInt(in.nextLine());
                ClientSender.port = port;
                ClientSender.tryToConnect();
            } catch (Exception e) {
                System.out.println("Введены некорректные данные");
            }
        }



        Commands commands = new Commands();
        commands.regist(new Show(), new Exit(), new Help(), new Info(), new Clear(), new Remove_first(),
                new Execute_script(), new Add(), new Sort(), new Update(), new Remove_by_id(),
                new Filter_less_than_distance(), new Filter_contains_name(), new Add_if_min(), new Min_by_id());
        ClientReceiver.receive();
        while (true) {
            try{
            while (ClientSender.serverisconnected) {
                System.out.println("Введите команду для отправки на сервер: ");
                System.out.print("~ ");
                String s = in.nextLine();
                Map<Commandable, String> commandparamMap = commands.executeCommand(s);
                if (commandparamMap != null && ClientSender.serverisconnected) {
                    ClientSender.send(commandparamMap);
                    System.out.println(ClientReceiver.receive());
                }
            }
            ClientSender.tryToConnect();
        } catch (Exception e){
                System.out.println("Произошла ошибка,попробуйте ещё раз");
            }
        }
    }
}
