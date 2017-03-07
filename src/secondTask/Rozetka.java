package secondTask;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Алексей on 07.03.2017.
 */
public class Rozetka implements Iterator<Product> {
    private List<Product> products;
    private int curPos = 0;

    public Rozetka(List<Product> products){
        this.products = products;
    }

    @Override
    public boolean hasNext() {
        return curPos < (products.size() - 1);
    }

    @Override
    public Product next() {
        return curPos < (products.size() - 1) ? products.get(curPos++) : null;
    }
}
