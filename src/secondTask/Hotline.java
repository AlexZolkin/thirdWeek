package secondTask;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Алексей on 07.03.2017.
 */
public class Hotline {
    private List<Product> products;

    public Hotline(){
        products = new ArrayList<>();
    }

    public List<Product> addProducts(Iterator iterator){
        while (iterator.hasNext()){
            products.add((Product) iterator.next());
        }
        return products;
    }
}
