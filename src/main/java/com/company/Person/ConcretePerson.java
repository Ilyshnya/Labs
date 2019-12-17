package com.company.Person;

import lombok.Data;
import org.joda.time.LocalDate;
import ru.vsu.lab.entities.enums.Gender;

import java.math.BigDecimal;


/**
 * Класс отвечает за создание
 * объекта Person с именем его работы.
 */
public final class ConcretePerson extends AbstractPerson   {
    /**
     * Название работы.
     */
    private String workName;

    public ConcretePerson(){
        super();
    }
    /**
     * @param name     Имя.
     * @param surname  Фамилия.
     * @param myGender   Пол.
     * @param birthday День рождения.
     */
    public ConcretePerson(final String name,
                          final String surname,
                          final Gender myGender,
                          final LocalDate birthday,
                          BigDecimal salary) {
        super(name, surname, myGender, birthday,salary);
    }

    /**
     * @return Название работы.
     */
    public String getWorkName() {
        return workName;
    }

    /**
     * Устанавливает объекту
     * конкретную работу.
     *
     * @param workNamePerson Название работы
     */
    public void setWorkName(final String workNamePerson) {
        this.workName = workNamePerson;
    }

    @Override
    public Integer getAge() {
        return LocalDate.now().getYear() - this.getBirthdate().getYear();
    }


    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof ConcretePerson) {
            return this.getId() == ((ConcretePerson) obj).getId();
        }
        return false;

    }

    @Override
    public int hashCode() {

        return 0;
    }


    @Override
    public int compareTo(final AbstractPerson o) {
        if (this.getComparator() == null) {
            return this.getId() - o.getId();
        }
        return this.getComparator().compare(this, o);
    }

    @Override
    public String toString() {
        String info = "";
        info += this.getId() + "\t";
        info += this.getFirstName() + "\t";
        info += this.getLastName() + "\t";
        info += this.getBirthdate().toString() + "\t";
        info += this.getGender() + "\t";
        info += workName + "\t";
        info += getAge() + "\n";
        return info;
    }


}
