package datastructs.adt;

import utils.*;

public class BinaryTree<E> extends Tree<E> {


    /**
     * Constructor
     */
    public BinaryTree(ITreeInsertStrategy insertStrategy){
        super(insertStrategy);
    }


    /**
     * Push a new element in the ADT
     */
    public  void push(E element){

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




    /**
     * Recursively add the element at the first null entry that is
     * found. TODO We should specify how the search for inserting is done
     */
    /*protected void addRecursive(E element){

        TreeSearch search = new TreeSearch();
        TreeNode<E> parentNode = null;
        TreeNode<E> node = search.dfs(super.root_, parentNode, new IPredicate<TreeNode<E>>() {
            @Override
            public boolean satisfies(TreeNode<E> data) {
                return (data == null);
            }
        });

        node = new TreeNode<E>(element, parentNode, parentNode.getLevel()+1, 2 );
    }*/

}
