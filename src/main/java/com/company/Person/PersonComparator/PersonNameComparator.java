package com.company.Person.PersonComparator;

import com.company.Person.AbstractPerson;

import java.util.Comparator;

/**
 * Сравнение по имени.
 * @param <T> объект наследник
 *           AbstractPerson
 */
public final class PersonNameComparator<T extends AbstractPerson>
        implements Comparator<T> {


    @Override
    public int compare(final T o1, final T o2) {
        return o1.getFirstName().compareToIgnoreCase(o2.getFirstName());
    }
}
