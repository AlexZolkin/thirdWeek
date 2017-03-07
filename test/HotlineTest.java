import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import secondTask.Hotline;
import secondTask.Product;
import secondTask.Repka;
import secondTask.Rozetka;

import java.util.ArrayList;

/**
 * Created by Алексей on 07.03.2017.
 */
public class HotlineTest {
    Hotline testHotline;
    Rozetka testRozetka;
    Repka testRepka;

    public ArrayList<Product> listCreate(String name){
        ArrayList<Product> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            list.add(new Product("Product(" + name + ")",(i+1) * 100));
        }
        return list;
    }
    public Product[] arrayCreate(String name){
        Product[] array = new Product[10];
        for(int i=0;i<10;i++){
            array[i] = (new Product("Product(" + name + ")",(i+1) * 100));
        }
        return array;
    }

    @Before
    public void setUp(){
        testHotline = new Hotline();
        testRepka = new Repka((arrayCreate("Repka")));
        testRozetka = new Rozetka(listCreate("Rozetka"));
    }
    @Test
    public void addProductsTest(){
        testHotline.addProducts(testRozetka);
        ArrayList<Product> listProducts = (ArrayList<Product>) testHotline.addProducts(testRepka);
        Assert.assertEquals(20, listProducts.size());
    }
}
