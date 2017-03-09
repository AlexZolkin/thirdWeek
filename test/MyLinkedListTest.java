import firstTask.A;
import firstTask.ListUtils;
import firstTask.MyLinkedList;
import org.junit.*;

import static org.junit.Assert.assertSame;

/**
 * Created by Алексей on 07.03.2017.
 */
public class MyLinkedListTest {
    MyLinkedList list;
    @Before
    public void setUp(){
        list = new MyLinkedList();
    }

    @Test
    public void testReversion(){

        A<Object> expected = list.seventh;
        A<Object> actual = ListUtils.reversion(list.head);
        assertSame(expected, actual);

        expected = list.sixth;
        actual = actual.getNext();
        assertSame(expected, actual);

        expected = list.fifth;
        actual = actual.getNext();
        assertSame(expected, actual);

        expected = list.fourth;
        actual = actual.getNext();
        assertSame(expected, actual);

        expected = list.third;
        actual = actual.getNext();
        assertSame(expected, actual);

        expected = list.second;
        actual = actual.getNext();
        assertSame(expected, actual);

        expected = list.head;
        actual = actual.getNext();
        assertSame(expected, actual);
    }
}
