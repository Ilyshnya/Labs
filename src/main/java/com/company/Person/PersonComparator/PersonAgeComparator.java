package com.company.Person.PersonComparator;

import com.company.Person.AbstractPerson;

import java.util.Comparator;

/**
 * Сравнение по возрасту.
 *
 * @param <T>объект наследник
 *          Abstract person
 */
public final class PersonAgeComparator<T extends AbstractPerson>
        implements Comparator<T> {

    @Override
    public int compare(final T o1, final T o2) {
        if (o1.getAge() > o2.getAge()) {
            return 1;
        } else if (o1.getAge() < o2.getAge()) {
            return -1;
        } else {
            return 0;
        }
    }
}
