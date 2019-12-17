
package com.company.Person.PersonComparator;

import com.company.Person.AbstractPerson;

import java.util.Comparator;

/**
 * Сравнение по фамилии.
 *
 * @param <T> объект наследник
 *           Abstract person.
 *
 *
 */
public final class PersonSurnameComparator<T extends AbstractPerson>
        implements Comparator<T> {

    @Override
    public int compare(final AbstractPerson o1, final AbstractPerson o2) {

        return o1.getLastName().compareToIgnoreCase(o2.getLastName());
    }
}
