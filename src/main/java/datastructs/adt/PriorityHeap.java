package datastructs.adt;

import datastructs.adt.utils.ITreeInsertStrategy;
import datastructs.adt.utils.TreeNode;
import datastructs.adt.utils.TreeNodeCreator;
import utils.IPredicate;

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

        if(super.root_ == null){

            this.createRoot(element);
        }
        else {

            boolean rslt = super.insertStrategy_.insert(super.root_, null, element, new IPredicate<TreeNode<E>>() {
                @Override
                public boolean satisfies(TreeNode<E> data) {
                    return (data == null);
                }
            });

            if(rslt) {
                super.nNodes_++;
            }
        }
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
