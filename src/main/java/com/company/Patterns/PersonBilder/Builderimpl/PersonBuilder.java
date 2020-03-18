package com.company.Patterns.PersonBilder.Builderimpl;

import com.company.IdGenerator.IIdGenerator;
import com.company.Patterns.PersonBilder.Builder;
import com.company.Person.AbstractPerson;
import com.company.Person.ConcretePerson;

import com.company.Person.Division.Divisionimpl;
import org.joda.time.LocalDate;
import ru.vsu.lab.entities.IDivision;
import ru.vsu.lab.entities.enums.Gender;

import java.math.BigDecimal;

/**
 * Реализация конкретного строителя.
 */
public final class PersonBuilder implements Builder {
    /**
     * объект реализующий
     * интерфейс IIdGenerator.
     */
    private IIdGenerator idGenerator;
    /**
     * Имя.
     */
    private String name;
    /**
     * Фамилия.
     */
    private String surname;
    /**
     * Пол.
     */
    private Gender myGender;
    /**
     * День рождения.
     */
    private LocalDate birthday;
    /**
     * Название работы.
     */
    private String workName;

    private Divisionimpl division;

    private BigDecimal salary;
    /**
     * Конструктор.
     *
     * @param namePerson     имя
     * @param surnamePerson  фамилия
     * @param myGenderPerson   пол
     * @param birthdayPerson день рождения
     */
    public PersonBuilder(final String namePerson,
                         final String surnamePerson,
                         final Gender myGenderPerson,
                         final LocalDate birthdayPerson,
                         BigDecimal salary) {
        this.name = namePerson;
        this.surname = surnamePerson;
        this.birthday = birthdayPerson;
        this.myGender = myGenderPerson;
        this.salary=salary;
    }

    @Override
    public void setIdGenerator(final IIdGenerator idGeneratorPerson) {
        this.idGenerator = idGeneratorPerson;
    }

    @Override
    public AbstractPerson getResult() {
        ConcretePerson p = new ConcretePerson(name, surname, myGender, birthday,salary);
        p.setWorkName(workName);
        p.setDivision(division);
        return p;
    }

    @Override
    public void setWorkName(final String workNamePerson) {
        this.workName = workNamePerson;
    }

    public IDivision getDivision() {
        return division;
    }

    public void setDivision(Divisionimpl division) {
        this.division = division;
    }
}
