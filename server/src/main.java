/**
 * Класс main
 * @author SaintLaurentPrince and Mariec
 * @version 1.0
 */


import Controller.*;
import Commands.*;
import Utilities.*;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Map;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException, SQLException {
        Server.create();
        while (!Server.server.isClosed()) {
            Socket socket = Server.server.accept();
            new Thread(new NewClient(socket)).start();
            System.out.println("Новый клиент с адресом "+socket.getLocalAddress()+socket.getPort());
        }

    }


}
