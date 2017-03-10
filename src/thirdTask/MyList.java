package thirdTask;

import java.util.Collection;

/**
 * Created by Алексей on 10.03.2017.
 */
/*
* Interface for LinkedList
* Main idea: code most commonly used functionality of LinkedList,
* so it can be used lice other collections.
* */
public interface MyList<T> {
    /*
    * Getters
    * T get(int index) -> getting by index
    * T get() -> getting the last one
    * */
    T get(int index);
    T get();

    /*
    * Setters
    * boolean set(T item) -> setting by index
    * boolean set(T item, int index) -> setting the last one
    * */
    boolean set(T item);
    boolean set(T item, int index);

    /*
    * Adding new elements
    * boolean add(T item) -> adding to the end
    * boolean add(T item, int index) -> inserting into the list
    * boolean addAll(Collection<T> array) -> adding collection of items to the end
    * */
    boolean add(T item);
    boolean add(T item, int index);
    boolean addAll(Collection<T> array);

    /*
    * Deleting elements from the list
    * boolean delete(T item) -> deletes all the items with value, equal to the parameter
    * boolean delete(T item, int index) -> deletes item by index if it is equal to the first parameter
    * boolean deleteByInd(int index) -> deletes element by index
    * boolean deleteAll(int beg, int end) -> deletes group of elements, from-to
    * boolean deleteAll(Collection<T> array) -> deletes all the elements in the list with equal values to elements in array
    * */
    boolean delete(T item);
    boolean delete(T item, int index);
    boolean deleteByInd(int index);
    boolean deleteAll(int beg, int end);
    boolean deleteAll(Collection<T> array);

    /*
    * boolean contains(T item) -> checks if list has item inside itself
    * */
    boolean contains(T item);

    /*
    * int size() -> returns size of the list
    * */
    int size();
}
