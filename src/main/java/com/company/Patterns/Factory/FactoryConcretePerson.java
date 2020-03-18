package com.company.Patterns.Factory;

import com.company.Injector;
import com.company.MyCollection.Listimpl.MyArrayList;
import com.company.MyException;
import com.company.Person.ConcretePerson;
import com.company.Person.Division.Divisionimpl;
import ru.vsu.lab.entities.IDivision;
import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.factory.ILabFactory;
import ru.vsu.lab.repository.IPersonRepository;
import ru.vsu.lab.repository.IRepository;


import java.io.IOException;

public class FactoryConcretePerson<T extends Comparable> implements ILabFactory {

    @Override
    public IPerson createPerson() {
        return  null;
    }

    @Override
    public IDivision createDivision() {
        return new Divisionimpl();
    }

    @Override
    public <T> IRepository<T> createRepository(Class<T> clazz) {

        try {
            return Injector.inject( new MyArrayList<T>());
        } catch (MyException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public IPersonRepository createPersonRepository() {

        return null;
    }


}
