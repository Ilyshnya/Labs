package com.company.Person;

import com.company.IdGenerator.IIdGenerator;
import com.company.IdGenerator.IdGeneratorimpl.MyIdGenerator;
import lombok.Data;
import org.joda.time.LocalDate;
import ru.vsu.lab.entities.IDivision;
import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.entities.enums.Gender;

import java.math.BigDecimal;
import java.util.Comparator;


/**
 * Класс описывающий человека.
 */
@Data
public abstract class AbstractPerson implements Comparable<AbstractPerson>, IPerson {
    /**
     * IdGenerator общий
     * и неизменяемый для всех
     * оюъектов класса.
     */
    private static final IIdGenerator GENERATOR;
    /**
     *Идентификатор.
     */
    private Integer Id;
    /**
     *Имя.
     */
    private String firstName;
    /**
     * Фамилия.
     */
    private String lastName;
    /**
     *Пол.
     */
    private Gender gender;
    /**
     *День рождения.
     */
    private LocalDate birthdate;

    /**
     * Компаратор
     * для сравнеия.
     */
    private IDivision division;

    private BigDecimal salary;

    private static Comparator<AbstractPerson>  comparator;

    static {
        GENERATOR = new MyIdGenerator();
    }

    public AbstractPerson(){}
    /**
     * Конструктор.
     * @param namePerson  Имя.
     * @param surnamePerson Фамилия.
     * @param myGenderPerson Пол.
     * @param birthdayPerson День рождения.
     */
    public AbstractPerson(final String namePerson,
                          final String surnamePerson,
                          final Gender myGenderPerson,
                          final LocalDate birthdayPerson,
                            BigDecimal salary) {
        this.firstName = namePerson;
        this.lastName = surnamePerson;
        this.gender = myGenderPerson;
        this.birthdate = birthdayPerson;
        this.Id = GENERATOR.getId();
        this.salary=salary;
    }

    /**
     * Возвращает Id.
     * @return Id человека
     */
    public Integer getId() {
        return Id;
    }

    /**
     * @return Имя человека.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return Фамилия человека.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return Пол человека.
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * @return День рождения
     * человека.
     */
    public LocalDate getBirthdate() {
        return birthdate;
    }

    /**
     * @return Возраст человека.
     */
    public abstract Integer getAge();

    /**
     * @return объект
     *          реализ. интерфейс
     *          Comparator
     */
    public Comparator<AbstractPerson> getComparator() {
        return comparator;
    }

    /**
     * @param comparator1 устанавливает
     *                    Comparator
     */
    public static void setComparator(final Comparator<AbstractPerson>
                                             comparator1) {
        comparator = comparator1;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public IDivision getDivision() {
        return division;
    }

    public void setDivision(IDivision division) {
        this.division = division;
    }
}
