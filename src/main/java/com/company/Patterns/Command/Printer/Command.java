package com.company.Patterns.Command.Printer;

import com.company.MyCollection.MyList;
import com.company.Person.AbstractPerson;

public interface Command {
    void execute(MyList<AbstractPerson> myList) throws Exception;
}
