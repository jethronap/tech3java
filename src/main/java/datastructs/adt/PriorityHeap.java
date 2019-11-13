package datastructs.adt;

import datastructs.adt.utils.ITreeInsertStrategy;
import datastructs.adt.utils.TreeNodeCreator;

/**
 * An implementation of Priority Heap represented as an array.
 * @param <E>
 */
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


    /**
     * Create the root element
     * @param element
     */
    protected void createRoot(E element){

        TreeNodeCreator<E> creator = new TreeNodeCreator<>();
        super.root_  = creator.create(element, null, 0, 2);
        super.nNodes_++;
    }


    @Override
    public boolean contains(E data) {
        return false;
    }
}
