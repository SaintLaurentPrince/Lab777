/**
 * Класс Commands, через который происходит выполнение комманд
 * @author SaintLaurentPrince and Mariec
 * @version 1.0
 */
package Controller;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Commands {
    private static Map<String, Commandable> commands = new TreeMap<>();
    private static ArrayList<String> history = new ArrayList<>();
    public static ArrayList<String> getHistory() {
        return history;
    }

    public Commandable getCommand(String commandname) {
        return commands.get(commandname);
    }

    public static void setCommands(Map<String, Commandable> commands) {
        Commands.commands = commands;
    }

    public void regist(Commandable... commands) {
        for (Commandable command : commands)
            Commands.commands.put(command.getName(), command);
    }
    public void addToHistory(String commandName){
        if (commandName.equals("history") == false)
            history.add(commandName);
    }

    /**
     * @param commandName имя комманды
     */
    public String executeCommand(String commandName, Socket socket,String user) {
        String[] nameAndArgument = commandName.split(" ");
        commandName = commandName.replace(" ", "");
        if (!commandName.equals("")) {
            if (commands.get(nameAndArgument[0]) == null) {
                return ("Такой команды не существует, введите \"help\", чтобы ознакомиться со всем перечнем команд.");
            } else {
                try {
                    CommandWithoutArg commandWithoutArg = (CommandWithoutArg) commands.get(nameAndArgument[0]);
                    try {
                        String s = nameAndArgument[1];
                        return ("Неверный формат команды, введите \"help\", чтобы ознакомиться с форматами команд.");
                    } catch (Exception e) {

                         return commands.get(nameAndArgument[0]).execute(null,socket,user)+"\n";
                    }
                } catch (Exception e) {
                    try {
                        String s = nameAndArgument[2];
                        return ("Неверный формат команды, введите \"help\", чтобы ознакомиться с форматами команд.");
                    } catch (IndexOutOfBoundsException e1) {
                        try {

                           return commands.get(nameAndArgument[0]).execute(nameAndArgument[1],socket,user)+"\n";
                        } catch (IndexOutOfBoundsException | FileNotFoundException e2) {
                            return ("Неверный формат команды, введите \"help\", чтобы ознакомиться с форматами команд.");
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }
}