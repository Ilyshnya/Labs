package com.company.Patterns.Command.Reader.Readerimpl;

import com.company.MyCollection.Listimpl.MyArrayList;
import com.company.MyCollection.MyList;
import com.company.Patterns.FactoryMethodStrategy.QuickSortCreator;
import com.company.Patterns.PersonBilder.Builder;
import com.company.Patterns.PersonBilder.Director;
import com.company.Patterns.SortStrategy.ContextStrategy;
import com.company.Person.AbstractPerson;
import com.company.Patterns.Command.Printer.IPrintCommand;
import com.company.Patterns.Command.Printer.Printerimpl.ConsolePrinter;
import com.company.Patterns.Command.Reader.IReadCommand;
import org.joda.time.LocalDate;

import java.util.Scanner;

import static java.lang.System.out;

/**
 * Класс ввода информации о
 * людях в консоль.
 */
public final class ConsoleReader implements IReadCommand {

    @Override
    public MyList<AbstractPerson> read() throws Exception {
        MyList<AbstractPerson> persons = new MyArrayList<>();
        IPrintCommand p = new ConsolePrinter();
        Scanner in = new Scanner(System.in);

        ContextStrategy<AbstractPerson> context =
                new ContextStrategy<>(new QuickSortCreator<AbstractPerson>());
        while (true) {
            out.println("Добавить человека введите"
                    + " Add:");
            out.println("Удалить человека введите"
                    + " Delete:");
            out.println("Вывести на консоль "
                    + "Cprint:");
            out.println("Редактировать человека"
                    + " введите Edit:");
            out.println("Таблица с данными введите"
                    + " JPprint:");
            out.println("Сортировка данных введите"
                    + " Sort:");
            var op = Operation.valueOf(in.nextLine().toUpperCase());
            switch (op) {
                case ADD:
                    persons.add(add());
                    break;
                case DELETE:
                    out.println("Введите Id удаляемого:");
                    int id = in.nextInt();
                    persons.remove(id);
                    break;
                case CPRINT:
                    p.print(persons);
                    break;
                case EDIT:
                    out.println("Id редактируемого:");
                    id = in.nextInt();
                    persons.set(id, add());
                    break;
                case JPRINT:
                    return persons;
                case SORT:
                    context.doStrategy(persons);
                    p.print(persons);
                    break;
                default:
                    return persons;
            }
        }
    }


    /**
     * Добавление пользователя в коллецию.
     *
     * @return Объект класса-
     * наследника AbstrsctPerson.
     */
    private AbstractPerson add() {
        return reader();
    }

    /**
     * Ввод и считывание информации
     * с консоли.
     *
     * @return Объект класса-
     * наследника AbstrsctPerson.
     */
    private AbstractPerson reader() {
        Builder builder=null;
        Director director = new Director();
        Scanner in = new Scanner(System.in);
        out.print("Name: ");
        String name = in.nextLine();
        out.print("Surname: ");
        String surname = in.nextLine();
        out.print("Gender: ");
        String gender = in.nextLine();
        out.print("Birthday в формате Year-Month-Day: ");
        LocalDate date = LocalDate.parse(in.nextLine());
//        builder = new PersonBuilder(name, surname,
//                Gender.enumCompare(gender),
//                date,null);
        return director.constructPersonDoctor(builder);//(builder);

    }

}
