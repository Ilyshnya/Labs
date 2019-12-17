package com.company.Patterns.Command.Printer.Printerimpl;

import com.company.MyCollection.MyList;
import com.company.Person.AbstractPerson;
import com.company.Person.ConcretePerson;
import com.company.Patterns.Command.Printer.IPrintCommand;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Dimension;


/**
 * Выводит информацию
 * в таблицу.
 */
public final class JFramePrinter extends JFrame implements IPrintCommand {

    /**
     * Создает таблицу.
     *
     * @param person Коллекция-наследник
     *               интерфейса MyList
     */
    private static void createGUI(final MyList<AbstractPerson> person) throws Exception {
        JFrame frame = new JFrame("Persons");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final int width = 655, height = 255;
        String[] columnNames = {
                "Id",
                "Name",
                "Surname",
                "Birthday",
                "Gender",
                "Work",
                "Age"
        };

        final int birthday = 3, gender = 4, work = 5, age = 6, name = 1,
                surname = 2, id = 0;

        String[][] data = new String[person.getSize()][columnNames.length];
        for (int i = 0; i < person.getSize(); i++) {
            data[i][id] = Integer.toString(person.get(i).getId());
            data[i][name] = person.get(i).getFirstName();
            data[i][surname] = person.get(i).getLastName();
            data[i][birthday] = person.get(i).getBirthdate().toString();
            data[i][gender] = person.get(i).getGender().toString();
            if (person.get(i) instanceof ConcretePerson) {
                data[i][work] = ((ConcretePerson) person.get(i)).getWorkName();
            }
            data[i][age] = Integer.toString(person.get(i).getAge());
        }

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.getContentPane().add(scrollPane);
        frame.setPreferredSize(new Dimension(width, height));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    @Override
    public void print(final MyList<AbstractPerson> person) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            JFrame.setDefaultLookAndFeelDecorated(true);
            try {
                JFramePrinter.createGUI(person);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }


    @Override
    public void execute(MyList<AbstractPerson> myList) {
        print(myList);
    }
}
