package com.company.Patterns.FactoryMethodStrategy;

import com.company.MyCollection.MyList;
import com.company.Patterns.SortStrategy.ISortStrategy;
import com.company.Patterns.SortStrategy.Strategyimpl.ShellSortStrategy;

/**
 *  Создает стратегию
 *  сортировки Шелла.
 * @param <T> тип который
 *           реализует Comparable
 */
public final class ShellSortCreator<T extends Comparable> extends Creator<T> {
    @Override
    public ISortStrategy createSortStrategy() {
        return new ShellSortStrategy<MyList<T>, T>();
    }
}
