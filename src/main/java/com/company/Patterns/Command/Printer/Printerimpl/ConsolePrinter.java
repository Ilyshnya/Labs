package com.company.Patterns.Command.Printer.Printerimpl;

import com.company.MyCollection.MyList;
import com.company.Person.AbstractPerson;
import com.company.Patterns.Command.Printer.IPrintCommand;


/**
 * Выводит информацию
 * на консоль.
 */
public final class ConsolePrinter implements IPrintCommand {

    @Override
    public void print(final MyList<AbstractPerson> person) throws Exception {

        for (int i = 0; i < person.getSize(); i++) {
            System.out.println(person.get(i));
        }
    }

    @Override
    public void execute(MyList<AbstractPerson> myList) throws Exception {
        print(myList);
    }
}
