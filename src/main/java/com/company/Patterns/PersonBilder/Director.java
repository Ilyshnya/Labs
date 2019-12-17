package com.company.Patterns.PersonBilder;

import com.company.Person.AbstractPerson;

/**
 * Класс для управления строителями.
 */
public final class Director {

    /**
     * Создает объект доктор.
     * @param builder кокретный строитель
     * @return объект Person
     */
    public AbstractPerson constructPersonDoctor(final Builder builder) {

       builder.setWorkName("Доктор");
       return builder.getResult();
    }

    /**
     * Создает объект Person.
     * @param builder кокретный строитель
     * @return объект Person
     */
    public AbstractPerson constructPerson(final Builder builder) {

        return builder.getResult();
    }

}
