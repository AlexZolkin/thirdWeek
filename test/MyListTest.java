import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import thirdTask.MyLinkedList;

import java.util.ArrayList;

/**
 * Created by Алексей on 10.03.2017.
 */
public class MyListTest {
    MyLinkedList<Object> myList;

    @Before
    public void setUp(){
        myList = new MyLinkedList<>();

        for(int i=0;i<10;i++){
            if(i % 2 == 0)
                myList.add(i);
            else
                myList.add(Integer.toString(i));
        }
    }

    @Test
    public void testAddToTheEnd(){
        Assert.assertEquals(2, myList.get(2));
        Assert.assertEquals("1", myList.get(1));
    }
    @Test
    public void testAddInside(){
        myList.add(10,2);
        Assert.assertEquals("1",myList.get(1));
        Assert.assertEquals(10, myList.get(2));
        Assert.assertEquals(2, myList.get(3));
    }
    @Test
    public void testAddCollection(){
        ArrayList<Object> arrayList = new ArrayList<>();
        for(int i=10;i<30;i+=10)
            arrayList.add(i);
        myList.addAll(arrayList);
        Assert.assertEquals(20,myList.get());
    }
    @Test
    public void testGetLast(){
        Assert.assertEquals("9",myList.get());
    }
    @Test
    public void testSetLast(){
        myList.set(10);
        Assert.assertEquals(10, myList.get());
    }
    @Test
    public void testSetInside(){
        myList.set("10",2);
        Assert.assertEquals("10", myList.get(2));
    }
    @Test
    public void testDelete(){
        myList.add(11,0);
        myList.add(11);
        myList.add(11,3);

        myList.delete(11);
        Assert.assertNotEquals(11, myList.get(0));
        Assert.assertNotEquals(11, myList.get());
        Assert.assertNotEquals(11, myList.get(3));
    }
    @Test
    public void testDeleteByInd(){
        myList.deleteByInd(5);
        Assert.assertEquals(6, myList.get(5));
    }
    @Test
    public void testDeleteRange(){
        myList.deleteAll(1,5);
        Assert.assertEquals(0,myList.get(0));
        Assert.assertEquals(6,myList.get(2));
    }
    @Test
    public void testDeleteAll(){
        ArrayList<Object> array = new ArrayList<>();
        array.add(1);
        array.add("2");
        array.add(2);
        myList.deleteAll(array);
        Assert.assertEquals("1", myList.get(1));
        Assert.assertEquals("3",myList.get(2));
    }
    @Test
    public void testContains(){
        Assert.assertTrue(myList.contains("1"));
    }

}
