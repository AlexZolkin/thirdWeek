package thirdTask;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Алексей on 10.03.2017.
 */
/*
* MyLinkedList
* Contains realisation of MyList interface and nested class Node for
* elements of the list
* saves head and size for future usage
* */
public class MyLinkedList<T> implements MyList<T> {
    private Node<T> head;
    private int listSize;

    /*
    * Constructor
    * initialises head of hte list
    * */
    public MyLinkedList(){
        head = new Node<>();
        listSize = 1;
    }

    /*
    * Function for private usage
    * returns element of thr list with index given
    * */
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

    /*
    * Getter
    * returns value of the element with index given
    * */
    @Override
    public T get(int index) {
        Node<T> node = getNode(index);
        return node == null ? null : node.getValue();
    }

    /*
    * Getter
    * returns value of the last element
    * */
    @Override
    public T get() {
        return get(listSize -1);
    }

    /*
    * Setter
    * set value of the last element with item
    * */
    @Override
    public boolean set(T item) {
        return set(item, listSize - 1);
    }

    /*
    * Setter
    * set value of the element with index given
    * with item
    * */
    @Override
    public boolean set(T item, int index) {
        Node<T> node = getNode(index);
        if(node != null) {
            node.setValue(item);
            return true;
        }
        return false;
    }

    /*
    * Adds new element
    * adds new element with item value to the end
    * of the list
    * */
    @Override
    public boolean add(T item) {
        return add(item, listSize);
    }

    /*
    * Adds new element
    * inserts new element in the position given,
    * value parameter is equal to item
    * */
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

    /*
    * Adds new elements
    * takes every element from the collection given
    * inserts them to the end
    * order is saved
    * */
    @Override
    public boolean addAll(Collection<T> array) {
        Iterator<T> iterator = array.iterator();
        while (iterator.hasNext()){
            add(iterator.next());
        }
        return true;
    }

    /*
    * Delete
    * deletes all the elements with the value equals with item
    * */
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

    /*
    * Delete
    * deletes element with index given if
    * is's value equals with the item
    * */
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

    /*
    * Delete
    * deletes element with the index given
    * */
    @Override
    public boolean deleteByInd(int index) {
        return delete(getNode(index).getValue(), index);
    }

    /*
    * Delete
    * deletes numerous element between two indexes
    * beg - starting index
    * end - final index
    * */
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

    /*
    * Delete
    * deletes all the elements in list, which values array contains
    * */
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

    /*
    * Contains
    * checks, doe's list have elements with same value with item
    * */
    @Override
    public boolean contains(T item) {
        for(int i=0;i<listSize;i++)
            if(getNode(i).getValue().equals(item))
                return true;
        return false;
    }

    /*
    * Size
    * returns size of a list
    * */
    @Override
    public int size() {
        return listSize;
    }

    /*
    * Nested class
    * contains ref's for next end previous nodes, value field
    * Type parameter is used
    * Functionality - discrete element of the list
    * */
    public class Node<T>{
        private Node<T> next, prev;
        private T value;

        /*
        * Empty constructor
        * */
        public Node(){
            next = null;
            prev = null;
            value = null;
        }

        /*
        * Constructor
        * Initialises new node with data from old one
        * */
        public Node(Node<T> node){
            next = node.getNext();
            prev = node.getPrev();
            value = node.getValue();
        }

        /*
        * Constructor
        * initialises every field during creating
        * */
        public Node(Node<T> prev, Node<T> next, T value){
            this.prev = prev;
            this.next = next;
            this.value = value;
        }

        /*
        * Getter
        * returns value
        * */
        public T getValue(){
            return value;
        }

        /*
        * Checks if there is at least one more element
        * forward in the list
        * */
        public boolean hasNext(){
            return next == null ? true : false;
        }

        /*
        * Checks if there is at least one more element
        * behind in the list
        * */
        public boolean hasPrev(){
            return prev == null ? true : false;
        }

        /*
        * Setter
        * set's value with item
        * */
        public boolean setValue(T value){
            if(value == null)
                return false;
            this.value = value;
            return true;
        }

        /*
        * Getter
        * returns ref to the next element
        * */
        public Node<T> getNext(){
            return next;
        }

        /*
        * Getter
        * returns ref to the previous element
        * */
        public Node<T> getPrev(){
            return prev;
        }

        /*
        * Setter
        * set's ref to the next element to the item
        * */
        public boolean setNext(Node<T> item){
            try{
                next = item;
                return true;
            }catch (Exception e){
                next = null;
                return false;
            }
        }

        /*
        * Setter
        * set's ref to the previous element to the item
        * */
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
