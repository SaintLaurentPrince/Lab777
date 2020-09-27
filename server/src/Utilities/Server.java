package Utilities;

import Controller.Commands;
import Controller.RouteCollection;
import Commands.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.BindException;
import java.net.ServerSocket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Server {
    private static Thread backgroundReaderThread;
    public static ServerSocket server;

    public static void checkForExitCommand() throws IOException {
        backgroundReaderThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
                    while (!Thread.interrupted()) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        if (line.equalsIgnoreCase("exit")) {
                            System.out.println("Отключаюсь");
                            System.exit(0);
                        }
                        ;
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        backgroundReaderThread.start();
    }

    public static void create() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int port = 0;
        boolean flag = false;
        while (!flag) {
        System.out.println("Введите порт");
        System.out.print("~ ");
        String line = bufferedReader.readLine();

            try {
                port = Integer.parseInt(line);
                flag = true;
            } catch (Exception e) {
                System.out.println("Неккоректный ввод порта");
            }
        }
        checkForExitCommand();
        RouteCollection routeCollection = new RouteCollection();
        Commands commands = new Commands();
        commands.regist(new Show(), new Exit(), new Help(), new Info(), new Clear(), new Remove_first(),
                new Execute_script(), new Add(), new Sort(), new Update(), new Remove_by_id(),
                new Filter_less_than_distance(), new Filter_contains_name(), new Add_if_min(), new Min_by_id());
         try {
            server = new ServerSocket(port);
            System.out.println("Сервер запущен,для выхода введите exit.");
        } catch (BindException e) {
            System.out.println("Данный порт уже занят,возможно сервер уже запущен!\n Принудительно завершаю работу.");
            System.exit(0);
        } catch (IOException e) {
            System.out.println("--------");
        }

    }

    public static String PasswordCoder(String st) {
        MessageDigest messageDigest = null;
        byte[] digest = new byte[0];

        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(st.getBytes());
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NullPointerException ignored){

        }

        BigInteger bigInt = new BigInteger(1, digest);
        String md5Hex = bigInt.toString(16);

        while( md5Hex.length() < 32 ){
            md5Hex = "0" + md5Hex;
        }

        return md5Hex;
    }
}
