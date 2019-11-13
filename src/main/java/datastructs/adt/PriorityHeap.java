package datastructs.adt;

import datastructs.adt.utils.ITreeInsertStrategy;

public class PriorityHeap<E> extends Tree<E> {

    /**
     * Constructor
     */
    protected PriorityHeap(ITreeInsertStrategy insertStrategy) {
        super(insertStrategy);
    }

    @Override
    public void push(E element) {

    }

    @Override
    public boolean contains(E data) {
        return false;
    }
}
