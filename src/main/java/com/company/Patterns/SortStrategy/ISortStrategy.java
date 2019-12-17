package com.company.Patterns.SortStrategy;

import com.company.MyCollection.MyList;


/**
 * Предоставляет интерфейс
 * стратегии сортировок.
 *
 * @param <T> Коллекция реализующая
 *            интерфейс MyList
 * @param <S> объекты коллекции
 *            должны реализовывать
 *            Comparable для сравнения.
 */
public interface ISortStrategy<T extends MyList<S>, S extends Comparable> {
    /**
     * Сортировка по возрастанию.
     *
     * @param myList Клаасс-наследник MyList
     */
    void sort(T myList) throws Exception;
}
