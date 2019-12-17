package com.company.Patterns.Command.Printer;

import com.company.MyCollection.MyList;
import com.company.Person.AbstractPerson;

/**
 * Предоставляет различные
 * способы вывода информации.
 */
public interface IPrintCommand extends Command {
    /**
     * Вывод коллекции.
     * @param person объект наследник
     *               AbstractPerson.
     */
    void print(MyList<AbstractPerson> person) throws Exception;
}
