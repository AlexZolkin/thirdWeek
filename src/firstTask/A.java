package firstTask;

/**
 * Created by Алексей on 07.03.2017.
 */
public interface A<T> {
    void setNext(A<T> next);
    A<T> getNext();
}
