package com.company.Patterns.SortStrategy.Strategyimpl;

import com.company.MyCollection.MyList;
import com.company.Patterns.SortStrategy.ISortStrategy;


/**
 * Предоставляет алгоритм
 * быстрой сортировки.
 *
 * @param <T> Коллекция реализующая
 *            интерфейс MyList с объектами
 *            реализующими интерфейс Comparable.
 * @param <S> объекты коллекции
 *            должны реализовывать
 *            Comparable для сравнения.
 */
public final class QuickSortStrategy<T extends MyList<S>, S extends Comparable>
        implements ISortStrategy<T, S> {
    @Override
    public void sort(final T myList) throws Exception {
        if (myList != null) {
            quickSort(myList, 0, myList.getSize() - 1);
        }
    }

    /**
     * @param myList Коллекция
     * @param low    индекс 1го элемента
     * @param high   индекс последнего
     *               элемента
     */
    private void quickSort(final T myList, final int low, final int high) throws Exception {
        if (myList.getSize() == 0) {
            return;
        }
        if (low >= high) {
            return;
        }
        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        var opora = myList.get(middle);
        // разделить на подмассивы,
        // который больше и меньше
        // опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (myList.get(i).compareTo(opora) < 0) {
                i++;
            }

            while (myList.get(j).compareTo(opora) > 0) {
                j--;
            }

            if (i <= j) {
                var temp = myList.get(i);
                myList.set(i, myList.get(j));
                myList.set(j, temp);
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки
        // левой и правой части
        if (low < j) {
            quickSort(myList, low, j);
        }
        if (high > i) {
            quickSort(myList, i, high);
        }
    }

}
