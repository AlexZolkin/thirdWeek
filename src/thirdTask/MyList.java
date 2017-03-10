package thirdTask;

import java.util.Collection;

/**
 * Created by Алексей on 10.03.2017.
 */
/*
* Interface for Linked
* */
public interface MyList<T> {
    T get(int index);
    T get();

    boolean set(T item);
    boolean set(T item, int index);

    boolean add(T item);
    boolean add(T item, int index);
    boolean addAll(Collection<T> array);

    boolean delete(T item);
    boolean delete(T item, int index);
    boolean delete(int index);
    boolean deleteAll(int beg, int end);
    boolean deleteAll(Collection<T> array);

    boolean contents(T item);

    int size();
}
