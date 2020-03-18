
package com.company;

import com.company.Serviec.PersonApi;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.PropertyConfigurator;

import javax.xml.ws.Endpoint;


/**
 * Класс содержащий точку входа.
 */
public final class Main {
    /**
     * Приватный конструктор.
     */
    private Main() {
    }

    /**
     * точка входа.
     *
     * @param args параметры.
     */
    public static void main(final String[] args) throws Exception {
//        AbstractPerson.setComparator(new PersonNameComparator<>());
//        MyList<AbstractPerson> arr;
//        IReadCommand reader = new ConsoleReader();
//        IPrintCommand printer = new JFramePrinter();
//        arr = reader.read();
//        printer.print(arr);
//        ArrayList<Integer> p;
        PropertyConfigurator.configure("C:\\Users\\Ilyashnya\\IdeaProjects\\Lab2\\src\\main\\resources\\logging.log");
        BasicConfigurator.configure();
        Endpoint.publish("http://localhost:9999/ws/hello", new PersonApi());

    }
}
