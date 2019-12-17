package com.company;

import com.company.MyCollection.Listimpl.MyArrayList;
import com.company.Patterns.SortStrategy.ContextStrategy;
import com.company.Person.ConcretePerson;
import org.junit.jupiter.api.Test;
import ru.vsu.lab.repository.IRepository;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class InjectorTest {

    @Test
    void inject() throws Exception {

       IRepository<ConcretePerson> o= Injector.inject(new MyArrayList<>());

    }
}