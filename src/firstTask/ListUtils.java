package firstTask;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Алексей on 07.03.2017.
 */
public class ListUtils {


    public static<T> A<T> reversion(A<T> head) {
        ArrayList<A<T>> list = new ArrayList<>();

        A<T> iter = head;

        while (iter.getNext() != null) {
            list.add(iter);
            iter = iter.getNext();
        }
        list.add(iter);
        Collections.reverse(list);
        for(int i=0;i<list.size();i++){
            A<T> item = list.get(i);
            if(i < list.size() - 1){
                item.setNext(list.get(i+1));
            }else{
                item.setNext(null);
            }
        }
        return list.get(0);
    }
}
