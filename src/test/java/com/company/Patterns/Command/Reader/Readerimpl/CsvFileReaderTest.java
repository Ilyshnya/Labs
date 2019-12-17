package com.company.Patterns.Command.Reader.Readerimpl;

import com.company.MyCollection.Listimpl.MyArrayList;
import com.company.MyCollection.MyList;
import com.company.Patterns.Command.ICommand;
import com.company.Patterns.Command.Reader.IReadCommand;
import com.company.Person.AbstractPerson;
import com.company.Person.ConcretePerson;
import com.company.Person.Division.Divisionimpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.vsu.lab.entities.IDivision;
import ru.vsu.lab.repository.IRepository;

import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CsvFileReaderTest {

    @Test
    void read() throws Exception {

        List<AbstractPerson> personMyList;

        CsvFileReader reader = new CsvFileReader(
                ";",
                "C:\\Users\\Ilyashnya\\IdeaProjects\\Lab2\\src\\main\\resources\\persons.csv");
        personMyList = reader.readRep().toList();
        Stream<AbstractPerson> stream = personMyList.stream();
        stream.filter(p -> p.getFirstName().substring(0, 1).equals("A")
                        && p.getAge() > 30
                        && p.getSalary().compareTo(BigDecimal.valueOf(5000)) > 0)
                        .forEach(p-> System.out.println(p.getSalary()+" "+p.getFirstName()+" "+p.getAge()));
        stream.close();
        var s=personMyList.stream();
        System.out.println("Space---------");
        System.out.println(s.filter(p -> p.getFirstName().startsWith("aa")).count());
        s.close();
        System.out.println("Space---------");
        var s1=personMyList.stream();
//        Map<IDivision, Integer> phonesByCompany = ( personMyList.stream().collect(
//                Collectors.groupingBy(ConcretePerson::getDivision,Collectors.summingInt(IDivision::getId)));
//
//        for(Map.Entry<String, Integer> item : phonesByCompany.entrySet()){
//
//            System.out.println(item.getKey() + " - " + item.getValue());
//        }
         var q = personMyList.stream().reduce(BigDecimal.valueOf(0),
              (x,y)-> x.add(y.getSalary()),
              (x, y)->x.add(y));
        System.out.println(q);
        System.out.println("space-----");
        Map<Integer,IDivision> h=personMyList.stream().collect(Collectors.toMap(p->p.getId(),person -> person.getDivision()));
        for(var item : h.entrySet()){

            System.out.println(item.getKey() + " - " + item.getValue().getName());
        }
               //reduce(BigDecimal.valueOf(0),
//                        (x,y)-> x.add(y.getSalary()),(x, y)->x.add(y));
       // Assertions.assertEquals(25898, personMyList.size());
    }
}