package com.company.Patterns.Command.Reader;

import com.company.MyCollection.MyList;
import com.company.Patterns.Command.ICommand;
import com.company.Patterns.Command.Printer.Command;
import com.company.Person.AbstractPerson;



/**
 * Предоставляет метод для
 * ввода информации.
 */
public interface IReadCommand extends ICommand {
    /**
     * Ввод и запись информации.
     * @return коллекция объектов-
     * наследников AbstractPerson.
     */
    MyList<AbstractPerson> read() throws Exception;
}
