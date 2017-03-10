package thirdTask;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Алексей on 10.03.2017.
 */
public class MyLinkedList<T> implements MyList<T> {
    private Node<T> head;
    private int listSize;

    public MyLinkedList(){
        head = new Node<>();
        head.setNext(null);
        head.setPrev(null);
        listSize = 1;
    }
    private Node<T> getNode(int index){
        if (index >= listSize || index < 0)
            return null;
        if(index == 0)
            return head;
        Node<T> tmp = head.getNext();
        for(int i=1;i<index;i++){
            tmp = tmp.getNext();
        }
        return tmp;
    }
    @Override
    public T get(int index) {
        Node<T> node = getNode(index);
        return node == null ? null : node.getValue();
    }

    @Override
    public T get() {
        return get(listSize -1);
    }

    @Override
    public boolean set(T item) {
        return set(item, listSize - 1);
    }

    @Override
    public boolean set(T item, int index) {
        Node<T> node = getNode(index);
        if(node != null) {
            node.setValue(item);
            return true;
        }
        return false;
    }

    @Override
    public boolean add(T item) {
        return add(item, listSize - 1);
    }

    @Override
    public boolean add(T item, int index) {
        if(item == null || index >= listSize || index < 0)
            return false;
        Node<T> tmpPrev, tmpNext;
        tmpPrev = getNode(index - 1);
        tmpNext = getNode(index + 1);
        Node<T> node = new Node<>(tmpPrev, tmpNext, item);
        if(tmpNext != null)
            tmpNext.setPrev(node);
        if(tmpPrev != null)
            tmpPrev.setNext(node);
        listSize++;
        return true;
    }

    @Override
    public boolean addAll(Collection<T> array) {
        Iterator<T> iterator = array.iterator();
        while (iterator.hasNext()){
            add(iterator.next());
        }
        return true;
    }

    @Override
    public boolean delete(T item) {
        boolean flag, controlFlag = false;
        do {
            Node<T> tmp = head;
            flag = false;
            for(int i=0;i<listSize;i++){
                if(tmp.getValue().equals(item)){
                    if(tmp.getPrev() != null)
                        tmp.setPrev(getNode(i-1));
                    if(tmp.getNext() != null)
                        tmp.setNext(getNode(i+1));
                    flag = true;
                    controlFlag = true;
                }
            }
        }while (flag);
        return controlFlag;
    }

    @Override
    public boolean delete(T item, int index) {
        if(getNode(index).getValue().equals(item)){
            Node<T> tmp = getNode(index);
            if(tmp.getPrev() != null)
                tmp.setPrev(getNode(index-1));
            if(tmp.getNext() != null)
                tmp.setNext(getNode(index+1));
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int index) {
        return delete(getNode(index).getValue(), index);
    }

    @Override
    public boolean deleteAll(int beg, int end) {
        Node<T> nodeBeg, nodeEnd;
        nodeBeg = getNode(beg);
        nodeEnd = getNode(end);
        if(nodeBeg != null && nodeEnd != null){
            nodeBeg.setNext(nodeEnd);
            nodeEnd.setPrev(nodeBeg);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteAll(Collection<T> array) {
        boolean flag = false;
        Iterator<T> iter = array.iterator();
        while (iter.hasNext()){
            if(delete(iter.next())){
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public boolean contents(T item) {
        for(int i=0;i<listSize;i++)
            if(getNode(i).getValue().equals(item))
                return true;
        return false;
    }

    @Override
    public int size() {
        return listSize;
    }


    public class Node<T>{
        private Node<T> next, prev;
        private T value;

        public Node(){
            next = null;
            prev = null;
            value = null;
        }
        public Node(Node<T> node){
            next = node.getNext();
            prev = node.getPrev();
            value = node.getValue();
        }
        public Node(Node<T> prev, Node<T> next, T value){
            this.prev = prev;
            this.next = next;
            this.value = value;
        }

        public T getValue(){
            return value;
        }
        public boolean hasNext(){
            return next == null ? true : false;
        }
        public boolean hasPrev(){
            return prev == null ? true : false;
        }

        public boolean setValue(T value){
            if(value == null)
                return false;
            this.value = value;
            return true;
        }

        public Node<T> getNext(){
            return next;
        }

        public Node<T> getPrev(){
            return prev;
        }

        public boolean setNext(Node<T> item){
            try{
                next = item;
                return true;
            }catch (Exception e){
                next = null;
                return false;
            }
        }
        public boolean setPrev(Node<T> item){
            try{
                prev = item;
                return true;
            }catch (Exception e){
                prev = null;
                return false;
            }
        }
    }

}
