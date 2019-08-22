package datastructs.adt;

/**
 * A simple implementation of unbounded single linked list
 */
public class SingleLinkedList<T> {

    /**
     * Constructs an empty List
     */
    public SingleLinkedList(){
        currentSize_ = 0;
        tail_ = new Node(null, null);
        head_ = new Node(null, tail_);
    }

    /**
     * Returns the current number of items in the lst
     */
    public final int size(){return currentSize_;}

    /**
     * Returns true iff the list is empty
     */
    public final boolean empty(){return (this.size() == 0);}

    /**
     * Retrieve the front element in the list
     * Throws IllegalStateException if the list is empty
     */
    public final Node front(){
        if(this.empty()){
            throw new IllegalStateException("List is empty. Cannot retrieve front element");
        }

        return head_.next;
    }

    /**
     * Removes the front node from the list and
     * returns the data held by it.
     */
    public final Node popFront(){
        if(this.empty()){
            throw new IllegalStateException("List is empty. Cannot retrieve front element");
        }

        Node tmp = head_.next;
        head_.next = tmp.next;
        currentSize_ --;
        return tmp;
    }

    /**
     * Push at the front of the list the given element
     */
    public final void pushFront(T item){

        Node headNext = head_.next;
        Node newHeadNext = new Node(item, headNext);
        head_.next = newHeadNext;
        currentSize_++;
    }

    /**
     * Push at the back of the list
     */
    public final void pushBack(T item){

        if(empty()){
            pushFront(item);
            return;
        }

        Node current = head_.next;
        Node previous = null;
        while(true){

            if(current == null){
                Node newNode = new Node(item, current);
                previous.next = newNode;
                currentSize_++;
                break;
            }

            previous = current;
            current = current.next;
        }
    }

    /**
     * Returns the item at the end
     */
    public final Node back(){

        if(this.empty()){
            throw new IllegalStateException("List is empty. Cannot retrieve back element");
        }

        Node current = head_.next;
        Node previous = null;
        while(current != null){
            previous = current;
            current = current.next;
        }

        return previous;
    }

    /**
     * Returns the item at the end and removes the node containing that item
     */
    public final Node popBack(){

        if(this.empty()){
            throw new IllegalStateException("List is empty. Cannot retrieve back element");
        }

        Node current = head_.next;
        Node previous = null;
        Node previousPrevious = null;
        while(current != null){

            previousPrevious = previous;
            previous = current;
            current = current.next;
        }

        T data = previous.data;
        previousPrevious.next = current;
        currentSize_--;
        return previous;
    }

    /**
     * Insert the new item exaclty after pos i.e pos.next = new Node(data, pos.next)
     * and returns the newly constructed node
     */
    public final Node insertAt(Node pos, T data){

        Node newNode = new Node(data, pos.next);
        pos.next = newNode;

        currentSize_++;
        return newNode;
    }

    public class Node
    {
        T data = null;
        Node next = null;

        Node(T data, Node next){
            this.data = data;
            this.next = next;
        }
    }

    Node head_ = null;
    Node tail_ = null;
    private int currentSize_ = 0;
}
