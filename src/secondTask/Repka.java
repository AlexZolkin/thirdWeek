package secondTask;

import java.util.Iterator;

/**
 * Created by Алексей on 07.03.2017.
 */
public class Repka implements Iterator<Product> {
    private Product[] products;
    private int curPos = 0;

    public Repka(Product[] products){
        this.products = products;
    }

    @Override
    public boolean hasNext() {
        return curPos < (products.length - 1);
    }

    @Override
    public Product next() {
        return curPos < (products.length - 1) ? products[curPos++] : null;
    }
}
