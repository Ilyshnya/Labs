package com.company.Patterns.PersonBilder;

import com.company.Person.AbstractPerson;
import com.company.IdGenerator.IIdGenerator;



/**
 * Интерфейс управляющий
 * созданием объекта.
 */
public interface Builder {

    /**
     * Устанавливает конкретный IIdGenerator.
     * @param idGenerator объект IIdGenerator
     *                    создающий id
     */
    void setIdGenerator(IIdGenerator idGenerator);

    /**
     * Возвращает объект
     * наследник AbstractPerson.
     * @return объект
     *          наследник AbstractPerson
     */
    AbstractPerson getResult();

    /**
     * Устанавливает работу человека.
     * @param workName название работы
     */
    void setWorkName(String workName);

}
