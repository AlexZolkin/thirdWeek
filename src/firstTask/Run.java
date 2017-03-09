package firstTask;


/**
 * Created by Алексей on 07.03.2017.
 */
public class Run {
    public static void main( String[] args ) {
        MyLinkedList list = new MyLinkedList();
        list.node.showList();
        A<Object> a = ListUtils.reversion(list.node);
        list.node = (MyLinkedList.Node<Object>)a;
        list.node.showList();
    }
}
