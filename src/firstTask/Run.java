package firstTask;

/**
 * Created by Алексей on 07.03.2017.
 */
public class Run {
    public static void main( String[] args ) {
        Node<String> head = (Node<String>)ListUtils.createStringList();
        head.showList();
        head = (Node<String>)ListUtils.reversion(head);
        head.showList();
    }
}
