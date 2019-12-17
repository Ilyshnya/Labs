package com.company.Patterns.FactoryMethodStrategy;

import com.company.MyCollection.MyList;
import com.company.Patterns.SortStrategy.ISortStrategy;

import com.company.Patterns.SortStrategy.Strategyimpl.QuickSortStrategy;


/**
 * Создает стратегию
 * быстрой сортировки.
 *
 * @param <T> тип который
 *            реализует Comparable
 */
public final class QuickSortCreator<T extends Comparable> extends Creator<T> {

    @Override
    public ISortStrategy createSortStrategy() {

        return new QuickSortStrategy<MyList<T>, T>();
    }
}
