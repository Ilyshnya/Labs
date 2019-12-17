package com.company.Person.PersonPredicate;

import com.company.Person.AbstractPerson;

import java.util.function.Predicate;

public class AgePredicate<AbstractPerson> implements Predicate<AbstractPerson> {

    @Override
    public boolean test(AbstractPerson abstractPerson) {
        return false;
    }
}
