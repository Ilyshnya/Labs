package com.company.Patterns.FactoryMethodStrategy;

import com.company.Patterns.SortStrategy.ISortStrategy;


/**

 *Создатель объявляет
 *фабричный метод, который
 *должен возвращать новые
 *объекты продуктов. Важно,
 *чтобы тип результата совпадал
 *с общим интерфейсом продуктов.
 * @param <T> тип который исользуется
 *           в стратегии.
 */
public abstract class Creator<T> {
   /**
    * @return конкретная стратегия
    * сортировки
    */
   public abstract ISortStrategy createSortStrategy();
}
