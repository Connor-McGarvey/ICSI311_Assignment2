package com.mcgarvey;

import java.util.LinkedList;

/**
 * Represents a Generic Tree Iterator
 * Can iterate a tree in preorder inorder postorder
 *
 * @param <E>
 * @author Connor McGarvey
 * @version 1.0
 */

public class GenericTreeIterator<E extends Comparable<E>> implements java.util.Iterator<E> {
    /**
     * The Tree being traversed via iteration
     */
    private BSTGeneric<E> tree;

    /**
     * List containing the nodes in the order they were traversed
     */
    private LinkedList<NodeGeneric<E>> list;

    /**
     * Default Constructor. Sets tree and list to null
     */
    public GenericTreeIterator() {
        this.tree = null;
        this.list = null;
    }

    /**
     * GenericTreeIterator constructor method
     *
     * @param tree The tree to be iterated
     */
    public GenericTreeIterator(BSTGeneric<E> tree) {
        this.tree = tree;
        this.list = new LinkedList<NodeGeneric<E>>();
    }

    /**
     * Returns true if there are more elements to be iterated over
     * Returns true if next() would return an element
     *
     * @return boolean that says if there is a vale to be returned next or not
     */
    public boolean hasNext() {
        return !this.list.isEmpty();
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     */
    public E next() {
        return this.list.remove().getElement();
    }

    public LinkedList<NodeGeneric<E>> list() {
        return list;
    }

//    /**
//     * Removes from the underlying binary tree the last element returned by this iterator (optional operation).
//     * It can be called only once per call to next() method. The behavior of an iterator is unspecified if the underlying
//     * collection is modified while the iteration is in progress in any way other than by calling this method.
//     *
//     * @throws UnsupportedOperationException if the remove operation is not supported by this iterator
//     * @throws IllegalStateException         if the next method has not yet been called, or the remove method has already been
//     *                                       called after the last call to the next method
//     */
//    public void remove() throws UnsupportedOperationException {
//        // Optional means we can implement it or throw an UnsupportedOperationException. This operation is optional because
//        // sometimes we just don't want the iterator's content to be modified. An iterator is normally used for executing.
//        //The default implementation throws an instance of UnsupportedOperationException and performs no other action.
//        throw new UnsupportedOperationException();
//    }

    /**
     * Sets the traversal type to be preorder.
     */
    public void setPreorder() {
        this.list.clear();
        this.preorder(this.tree.getRoot());
    }

    /**
     * Sets the traversal type to be inorder.
     */
    public void setInorder() {
        this.list.clear();
        this.inorder(this.tree.getRoot());
    }

    /**
     * Sets the traversal type to be postorder.
     */
    public void setPostorder() {
        this.list.clear();
        this.postorder(this.tree.getRoot());
    }

    /**
     * Traverses in preorder.
     *
     * @param Node A reference to a tree node
     */
    private void preorder(NodeGeneric<E> Node) {
        if (Node != null) {
            this.list.add(Node);
            preorder(Node.getLeft());
            preorder(Node.getRight());

        }
    }

    /**
     * Traverses in inorder.
     *
     * @param Node A reference to a tree node
     */
    private void inorder(NodeGeneric<E> Node) {
        if (Node != null) {
            inorder(Node.getLeft());
            this.list.add(Node);
            inorder(Node.getRight());

        }
    }

    /**
     * Traverses in postorder.
     *
     * @param Node A reference to a tree node
     */
    private void postorder(NodeGeneric<E> Node) {
        if (Node != null) {
            postorder(Node.getLeft());
            postorder(Node.getRight());
            this.list.add(Node);

        }
    }
}
