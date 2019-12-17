package com.company.MyCollection;

import com.company.Patterns.SortStrategy.ContextStrategy;
import ru.vsu.lab.repository.IRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Предоставляет интерфейс
 * для работы со списками.
 * @param <T> обобщенный тип
 */
public interface MyList<T>  extends IRepository<T> {

    /**
     * Добавление элемента в список.
     *
     * @param object добавляемый объект
     */
    void add(T object);

    /**
     * Возвращает объект
     * из списка по индексу index.
     *
     * @param index Индекс элемента
     * @return Объект списка
     */
    T get(int index) ;

    /**
     * Очистить список.
     */
    void clear();

    /**
     * Проверка на пустоту списка.
     *
     * @return Пустой?
     */
    boolean isEmpty();

    /**
     * Поиск объекта в списке.
     *
     * @param object Искомый объект
     * @return Искомый объект
     */
    Optional<T> find(T object);

    /**
     * Удалить из списка.
     *
     * @param index Индекс элемента
     * @return Удаляемый объект
     */
    Optional<T> remove(int index);

    /**
     * @return Кол-во элементов списка
     */
    int getSize();

    /**
     * Возвращает индекс первого
     * вхождения объекта object в список.
     * Если объект не найден,
     * то возвращается -1.
     *
     * @param object объект коллекции
     * @return индекс объекта
     */
    int indexOf(T object);

    /**
     * Присваивает значение
     * объекта object элементу,
     * который находится по индексу index.
     *
     * @param index  Индекс
     * @param object Объект
     */
    T set(int index, T object);

    Optional<T> findByComparator(T object,Comparator<T> comparator);

   // public MyList<T> searchBy(Predicate<T> condition);

   //public void sortBy(ContextStrategy<T> comp) throws Exception;

    public List<T> toList();
}
