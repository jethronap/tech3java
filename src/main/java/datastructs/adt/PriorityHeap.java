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


    public void maxHeapify(int[] arr, int i, int nNodes) {


        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        int largest = i;

        if (leftChild <= nNodes && arr[leftChild] > arr[i]) {
            largest = leftChild;
        }

        else {
            largest = i;
        }

        if (rightChild <= nNodes && arr[rightChild] > arr[i]) {
            largest = rightChild;
        }
        if (largest != i) {
            swapNodes(arr[i], arr[largest]);
            maxHeapify(arr, largest, nNodes);
        }
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


    protected void swapNodes(int firstNode, int secondNode) {

        int[] array = null;
        int tmp;
        tmp = array[firstNode];
        array[firstNode] = array[secondNode];
        array[secondNode] = tmp;

    }

    @Override
    public boolean contains(E data) {
        return false;
    }
}
