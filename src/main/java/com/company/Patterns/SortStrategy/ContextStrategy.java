package com.company.Patterns.SortStrategy;

import com.company.LabInject;
import com.company.MyCollection.MyList;
import com.company.Patterns.FactoryMethodStrategy.Creator;
import com.company.Patterns.SortStrategy.Strategyimpl.QuickSortStrategy;

/**
 * Контекст хранит ссылку на объект
 * конкретной стратегии, работая с
 * ним через общий интерфейс стратегий.
 * @param <T> объект
 *           реализующий
 *           Comparable.
 */
public class ContextStrategy<T extends Comparable> {
    /**
     * Объект нтерфейса стратегии
     * сортировок.
     */
    @LabInject
    public ISortStrategy strategy;

    /**
     * Конструктор.
     * @param creator создатель
     *                содерж.
     *                абстр. метод.
     *
     */
    public ContextStrategy(final Creator creator) {
       // this.strategy = creator.createSortStrategy();
    }
    public ContextStrategy(){}

    /**
     * @param list Коллекция содерж.
     *             объекты.
     */
    public void doStrategy(final MyList<T> list) throws Exception {
        strategy.sort(list);
    }
}
