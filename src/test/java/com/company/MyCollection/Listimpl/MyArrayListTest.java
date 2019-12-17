package com.company.MyCollection.Listimpl;

import com.company.Person.AbstractPerson;
import com.company.Person.ConcretePerson;
import com.company.Person.PersonComparator.PersonNameComparator;
import com.company.Person.PersonComparator.PersonSurnameComparator;
import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import ru.vsu.lab.entities.enums.Gender;

import java.util.Comparator;
import java.util.Optional;

class MyArrayListTest {

    @Test
    void find() {
        MyArrayList<Integer> arr=new MyArrayList<Integer>();
        for (int i=0 ;i<=9;i++){
            arr.add((Integer) i);
        }
        Optional<Integer> x=arr.find(7);
        Integer x1=7;
        Assert.assertEquals(x.get(), x1);
    }

    @Test
    void remove() {
        MyArrayList<Integer> arr=new MyArrayList<Integer>();
        for (int i=0 ;i<=9;i++){
            arr.add(i);
        }
        Optional<Integer> x=arr.remove(7);
        Integer x1=7;
        Assert.assertEquals(x.get(), x1);
    }

    @Test
    void findByComparator() throws Exception {
        MyArrayList<AbstractPerson> arr=new MyArrayList<>();
        arr.add(new ConcretePerson("abc","ccc", Gender.MALE,new LocalDate(),null));
        arr.add(new ConcretePerson("bc","ccc", Gender.MALE,new LocalDate(),null));
        arr.add(new ConcretePerson("c","ccc", Gender.MALE,new LocalDate(),null));
        arr.add(new ConcretePerson("dc","ccc", Gender.MALE,new LocalDate(),null));
        Comparator<AbstractPerson> comparator=new PersonNameComparator<>()::compare;
        Comparator<AbstractPerson> comparator1=new PersonSurnameComparator()::compare;
        var x=arr.findByComparator(new ConcretePerson("c","ccc", Gender.MALE,new LocalDate(),null),comparator).get();
        var x1=arr.findByComparator(new ConcretePerson("c","ccc", Gender.MALE,new LocalDate(),null),comparator1).get();

        Assert.assertEquals(arr.get(2), x);
        Assert.assertEquals(arr.get(2).getFirstName(), x1.getLastName());
    }

    @Test
    void searchBy() {
    }
}