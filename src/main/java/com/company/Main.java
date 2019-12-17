
package com.company;

import com.company.MyCollection.MyList;
import com.company.Person.AbstractPerson;
import com.company.Person.PersonComparator.PersonNameComparator;
import com.company.Patterns.Command.Printer.IPrintCommand;
import com.company.Patterns.Command.Printer.Printerimpl.JFramePrinter;
import com.company.Patterns.Command.Reader.IReadCommand;
import com.company.Patterns.Command.Reader.Readerimpl.ConsoleReader;

import java.util.ArrayList;


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
        AbstractPerson.setComparator(new PersonNameComparator<>());
        MyList<AbstractPerson> arr;
        IReadCommand reader = new ConsoleReader();
        IPrintCommand printer = new JFramePrinter();
        arr = reader.read();
        printer.print(arr);
        ArrayList<Integer> p;


    }
}
