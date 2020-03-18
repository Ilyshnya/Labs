package com.company.Patterns.Command.Reader.Readerimpl;

import com.company.MyCollection.Listimpl.MyArrayList;
import com.company.MyCollection.MyList;
import com.company.Patterns.Command.Reader.IReadCommand;
import com.company.Patterns.Factory.FactoryConcretePerson;
import com.company.Patterns.PersonBilder.Builderimpl.PersonBuilder;
import com.company.Person.AbstractPerson;
import com.company.Person.Division.Divisionimpl;

import org.joda.time.LocalDate;
import ru.vsu.lab.entities.IDivision;
import ru.vsu.lab.entities.enums.Gender;
import ru.vsu.lab.repository.IRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;

public class CsvFileReader implements IReadCommand {
    public CsvFileReader(String separator, String connectionString) {
        this.separator = separator;
        this.connectionString = connectionString;
    }

    private String connectionString;
    private String separator;

    @Override
    public MyList<AbstractPerson> read() {
        //HashSet<Divisionimpl> set = new HashSet<>()
        var factory=new FactoryConcretePerson<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(connectionString))) {
            MyList<AbstractPerson> list = new MyArrayList<>();
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] array = line.split(separator);
                PersonBuilder builder = new PersonBuilder(
                                                        array[1],
                                                        null, Gender.MALE,
                                                        //Gender.enumCompare(array[2]),
                                                        LocalDateParse(array[3]),
                                                        BigDecimal.valueOf(Double.parseDouble(array[5])));
                if (Divisionimpl.getList().contains(Divisionimpl.equals(array[4])))
                {
                    builder.setDivision(Divisionimpl.equals(array[4]));
                } else {
                    IDivision divisionimpl=factory.createDivision();
                    divisionimpl.setId(0);
                    divisionimpl.setName(array[4]);//=new Divisionimpl(0,array[4]);
                    Divisionimpl.getList().add(divisionimpl);
                    builder.setDivision((Divisionimpl) divisionimpl);
                }
                list.add(builder.getResult());
            }
            return list;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private LocalDate LocalDateParse(String s) {
        // String[] s1= s.toCharArray();
        return new LocalDate(Integer.parseInt(s.substring(6)),
                Integer.parseInt(s.substring(3, 5)),
                Integer.parseInt(s.substring(0, 2)));

    }

    public IRepository<AbstractPerson> readRep() {
        //HashSet<Divisionimpl> set = new HashSet<>()
        var factory=new FactoryConcretePerson<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(connectionString))) {
            MyList<AbstractPerson> list = new MyArrayList<>();
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] array = line.split(separator);
                PersonBuilder builder = new PersonBuilder(
                        array[1],
                        null, Gender.MALE,
                        //Gender.enumCompare(array[2]),
                        LocalDateParse(array[3]),
                        BigDecimal.valueOf(Double.parseDouble(array[5])));
                if (Divisionimpl.getList().contains(Divisionimpl.equals(array[4])))
                {
                    builder.setDivision(Divisionimpl.equals(array[4]));
                } else {
                    IDivision divisionimpl=factory.createDivision();
                    divisionimpl.setId(0);
                    divisionimpl.setName(array[4]);//=new Divisionimpl(0,array[4]);
                    Divisionimpl.getList().add(divisionimpl);
                    builder.setDivision((Divisionimpl)divisionimpl);
                }
                list.add(builder.getResult());
            }
            return list;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    public String getConnectionString() {
        return connectionString;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

    public void setSeparator(String separator) {
        this.separator = separator;
    }
}
