package com.company.Patterns.Factory;

import com.company.MyCollection.Listimpl.MyArrayList;
import com.company.Person.AbstractPerson;
import com.company.Person.ConcretePerson;
import org.junit.jupiter.api.Test;
import ru.vsu.lab.factory.ILabFactory;
import ru.vsu.lab.repository.IRepository;

import static org.junit.jupiter.api.Assertions.*;

class FactoryConcretePersonTest {

    @Test
    void createRepository() {
        IRepository<ConcretePerson> pe = new FactoryConcretePerson().createRepository(MyArrayList.class);
        pe.add(new ConcretePerson());
        MyArrayList<ConcretePerson> P = new MyArrayList<ConcretePerson>();
        P.add(new ConcretePerson());
    }
}