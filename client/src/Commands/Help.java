/**
 * Класс команды Help
 * @author SaintLaurentPrince and Mariec
 * @version 1.0
 */

package Commands;

import Controller.CommandWithoutArg;

import java.net.Socket;

public class Help implements CommandWithoutArg {
    @Override
    public String execute(Object o, Socket socket, String user) {
        return("help : вывести справку по доступным командам\n" +
                "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
                "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                "add name {element} : добавить новый элемент в коллекцию\n" +
                "update id {element} : обновить значение элемента коллекции, id которого равен заданному\n" +
                "remove_by_id id : удалить элемент из коллекции по его id\n" +
                "clear : очистить коллекцию\n" +
                "save : сохранить коллекцию в файл\n" +
                "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
                "exit : завершить программу (без сохранения в файл)\n" +
                "remove_first : удалить первый элемент из коллекции\n" +
                "add_if_min {element} : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции\n" +
                "sort : отсортировать коллекцию в естественном порядке\n" +
                "min_by_id : вывести любой объект из коллекции, значение поля id которого является минимальным\n" +
                "filter_less_than_distance distance : вывести элементы, значение поля distance которых меньше заданного\n"+
                "filter_contains_name name : вывести элементы, значение поля name которых равно заданному");

    }

    @Override
    public String getName() {
        return "help";
    }
}
