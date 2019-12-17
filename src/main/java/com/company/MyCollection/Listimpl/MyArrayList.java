package com.company.MyCollection.Listimpl;

import com.company.LabInject;
import com.company.MyCollection.MyList;
import com.company.Patterns.SortStrategy.ContextStrategy;
import com.company.Patterns.SortStrategy.ISortStrategy;
import ru.vsu.lab.repository.IRepository;

import java.util.*;
import java.util.function.Predicate;

/**
 * Динамический массив.
 *
 * @param <T> обобщенный тип
 */
public final class MyArrayList<T> implements MyList<T>, IRepository<T> {
    /**
     * Кол-во элементов коллекции.
     */
    private int size;

    /**
     * массив.
     */
    private T[] array;

    /**
     * Размер массива при инициализации
     * по умолчанию.
     */
    private final int defaultCpacity = 10;
    /**
     * При заполненом массиве
     * он будет расширен на значение
     * extension.
     */
    private final double extension = 1.5;

    /**
     * Конструктор по умолчанию.
     */
    @LabInject
    private ISortStrategy strategy;
    public MyArrayList() {
        array = (T[]) new Object[defaultCpacity];
    }

    /**
     * Конструктор .
     *
     * @param initialCapacity Размер массива.
     */
    public MyArrayList(final int initialCapacity) {
        array = (T[]) new Object[initialCapacity];
    }

    @Override
    public void add(final T object) {
        if (size == array.length && object != null) {
            array = Arrays.copyOf(array, (int) (array.length * extension));
        }

        array[size++] = object;
    }

    @Override
    public T get(final int index) {
        if (index <= size && index >= 0) {
            return array[index];
        }
       return null;
    }

    @Override
    public T delete(int i) {
        return null;
    }

    @Override
    public void clear() {
        array = (T[]) new Object[size];
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Optional<T> find(final T object) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(object)) {
                return Optional.of(array[i]);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<T> remove(final int index) {
        T temp = array[index];
        for (int i = index; i < array.length; i++) {
            array[index] = array[index + 1];
        }
        size--;
        return Optional.of(temp);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int indexOf(final T object) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public T set(final int index, final T object) {

       return array[index] = object;
    }

    @Override
    public void add(int i, T t) {

    }

    @Override
    public Optional<T> findByComparator(T object, Comparator<T> comparator) {

        if (object != null || comparator != null) {
            for (int i = 0; i < size; i++) {
                if (comparator.compare(object, array[i]) == 0) {
                    return Optional.of(array[i]);
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public IRepository<T> searchBy(Predicate<T> condition) {
        var list = new MyArrayList<T>();
        for (int i = 0; i < size; i++) {
            if (condition.test(array[i]))
                list.add(array[i]);
        }
        return list;
    }


    public <T extends Comparable> void sortBy(ContextStrategy<T> comp) throws Exception {
        if(array[0] instanceof Comparable){
        comp.doStrategy((MyList<T>) this);
        }
    }

    @Override
    public List<T> toList() {
        List<T> list =new ArrayList<>();
        for (int i=0;i<size;i++){
            list.add(array[i]);
        }
        return list;
    }

    @Override
    public void sortBy(Comparator<T> comparator) {

    }


}
