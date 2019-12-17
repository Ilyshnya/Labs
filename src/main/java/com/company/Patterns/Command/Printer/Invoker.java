package com.company.Patterns.Command.Printer;


import com.company.MyCollection.MyList;
import com.company.Person.AbstractPerson;

public class Invoker implements Command {
    private Command command;
    public  Invoker(Command com){
        command=com;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    @Override
    public void execute(MyList<AbstractPerson> myList) throws Exception {
        command.execute(myList);
    }
}
