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
        //head.setNext(null);
        //head.setPrev(null);
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
        return add(item, listSize);
    }

    @Override
    public boolean add(T item, int index) {
        if(item == null || index > listSize || index < 0)
            return false;
        if(listSize == 1 && head.getValue() == null){
            head.setValue(item);
            return true;
        }
        if(index == 0){
            Node<T> tmp = new Node<>(null, head, item);
            head.setPrev(tmp);
            head = tmp;
            listSize++;
            return true;
        }
        Node<T> tmpPrev, tmpNext;
        tmpPrev = getNode(index - 1);
        tmpNext = getNode(index);
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
                    tmp.getPrev().setNext(tmp.getNext());
                    tmp.getNext().setPrev(tmp.getPrev());
                    flag = true;
                    controlFlag = true;
                    listSize--;
                    i--;
                }
                tmp = tmp.getNext();
            }
        }while (flag);
        return controlFlag;
    }

    @Override
    public boolean delete(T item, int index) {
        if(getNode(index).getValue().equals(item)){
            Node<T> tmp = getNode(index);
            tmp.getPrev().setNext(tmp.getNext());
            tmp.getNext().setPrev(tmp.getPrev());
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteByInd(int index) {
        return delete(getNode(index).getValue(), index);
    }

    @Override
    public boolean deleteAll(int beg, int end) {
        Node<T> nodeBeg, nodeEnd;
        nodeBeg = getNode(beg - 1);
        nodeEnd = getNode(end);
        if(nodeBeg == null)
            nodeBeg = head;
        if (nodeEnd == null)
            nodeEnd = getNode(listSize-1);
        nodeBeg.setNext(nodeEnd);
        nodeEnd.setPrev(nodeBeg);
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
    public boolean contains(T item) {
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
