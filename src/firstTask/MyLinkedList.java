package firstTask;

/**
 * Created by Алексей on 08.03.2017.
 */
public class MyLinkedList {
    public A<Object> head;
    public A<Object> second;
    public A<Object> third;
    public A<Object> fourth;
    public A<Object> fifth;
    public A<Object> sixth;
    public A<Object> seventh;
    public Node<Object> node;
    public MyLinkedList(){
        head = new Node<>("A");
        second = new Node<>("B");
        third = new Node<>("C");
        fourth = new Node<>("D");
        fifth = new Node<>("E");
        sixth = new Node<>("F");
        seventh = new Node<>("G");

        node = (Node)head;

        head.setNext(second);
        second.setNext(third);
        third.setNext(fourth);
        fourth.setNext(fifth);
        fifth.setNext(sixth);
        sixth.setNext(seventh);
    }


    public class Node<T> implements A<T> {

        private T value;
        private A<T> next;

        public Node() {
        }

        public Node(T value) {
            this.value = value;
        }

        public void setNext(A<T> next) {
            this.next = next;
        }

        public A<T> getNext() {
            return next;
        }

        public void showValue(){
            System.out.print(value);
        }

        public void showList(){
            firstTask.MyLinkedList.Node<T> iterator = this;
            while (iterator != null){
                System.out.print(iterator.value + " -> ");
                iterator = (firstTask.MyLinkedList.Node<T>)iterator.getNext();
            }
            System.out.print("Tail\n");
        }
    }
}
