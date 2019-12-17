package com.company.MyCollection.Listimpl;

import com.company.MyCollection.MyList;
import ru.vsu.lab.repository.IRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class list<T> implements MyList<T> {
    @Override
    public void add(T object) {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T delete(int i) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Optional<T> find(T object) {
        return Optional.empty();
    }

    @Override
    public Optional<T> remove(int index) {
        return Optional.empty();
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public int indexOf(T object) {
        return 0;
    }

    @Override
    public T set(int index, T object) {
        return null;
    }

    @Override
    public void add(int i, T t) {

    }

    @Override
    public Optional<T> findByComparator(T object, Comparator<T> comparator) {
        return Optional.empty();
    }

    @Override
    public List<T> toList() {
        return null;
    }

    @Override
    public void sortBy(Comparator<T> comparator) {

    }

    @Override
    public IRepository<T> searchBy(Predicate<T> predicate) {
        return null;
    }
}
