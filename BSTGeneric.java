package com.mcgarvey;

import javax.swing.text.Element;
import java.util.LinkedList;

/**
 * Represents a Generic Binary Tree
 *
 * @param <E>
 * @author Connor McGarvey
 * @version 1.0
 */
public class BSTGeneric<E extends Comparable<E>> {
    /**
     * instance of NodeGeneric class called root, this will be used as root of this BST
     */
    private NodeGeneric<E> root;
    /**
     * instance of GenericTreeIterator. This is the iterator that will be used to iterate this tree to output traversals
     */
    private GenericTreeIterator<E> iterator;

    /**
     * public access to the tree iterator associated with this BST
     *
     * @return returns the GenericTreeIterator for this tree
     */
    public GenericTreeIterator iterator() {
        return new GenericTreeIterator(this);
    }

    /**
     * Default Constructor; all values set to null
     */
    public BSTGeneric() {
        setRoot(null);
        iterator = new GenericTreeIterator<E>(this);
    }

    /**
     * BSTGeneric Constructor when passed a root
     *
     * @param root The root element of the tree
     */

    public BSTGeneric(NodeGeneric root) {
        setRoot(root);
    }

    /**
     * public method insert. Has no return. Is used to insert nodes into this tree. Uses compareTo method from Comparable parent class
     * compares nodes to nodes already in tree to determine if it should be placed to right or left child. At most node can have 2 children.
     * If name comes first lexicographically, it will be placed as left child, if name comes second lexicographically it will be placed as right child
     *
     * @param insertNode the node that is being inserted into this tree.
     */
    public void insert(NodeGeneric insertNode) {
        if (root == null) {
            root = insertNode;
            return;
        }
        boolean search = true;
        NodeGeneric current = root;
        NodeGeneric parent;

        while (search) {
            parent = current;
            String name1 = current.center.getElement().toString();
            String name2 = insertNode.center.getElement().toString();
            int difference = name1.compareToIgnoreCase(name2);

            if (difference > 0) {
                current = current.getLeft();
                if (current == null) {
                    parent.setLeft(insertNode);
                    return;
                }
            } else {
                current = current.getRight();
                if (current == null) {
                    parent.setRight(insertNode);
                    return;
                }
            }
        }
    }

    /**
     * Checks to see if this tree is empty or populated with at least one element
     *
     * @return returns true if root is empty so returns true if tree is empty. Returns false if root is populated... tree is populated
     */
    public boolean isEmpty() {
        if (root == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Emptys the tree, by setting  root to null
     */
    public void emptyTree() {
        this.root = null;
    }

    /**
     * Get method for root node, checks if tree is empty or not before returning the root
     *
     * @return the root node for the tree
     */
    public NodeGeneric getRoot() {
        if (this.isEmpty()) {
            return null;
        } else {
            return root;
        }
    }

    /**
     * Sets root node to new element
     *
     * @param setNode
     */
    public void setRoot(NodeGeneric setNode) {
        this.root = setNode;
    }

    /**
     * remove node method. Used to remove a node from a tree. Takes a node as a parameter and traverses the tree
     * searching for another node that contains the same String name. This is compared with compareToIgnoreCase. So
     * the comparison is not case sensitive. The node does not need be identical, simply the same name will result in
     * the node being removed. Uses GetNewNode() helper class defined below.
     *
     * @param removeNode the node being used to search for another node with the same name
     * @return boolean return true if able to remove false if unable to remove node
     */

    public boolean removeNode(E removeNode) {
        NodeGeneric current = root;
        NodeGeneric parent = root;
        boolean isLChild = true;

        while (current.center.getElement().toString().compareToIgnoreCase(removeNode.toString()) != 0) {
            parent = current;
            if (removeNode.toString().compareToIgnoreCase(current.center.getElement().toString()) < 0) {
                isLChild = true;
                current = current.getLeft();
            } else {
                isLChild = false;
                current = current.getRight();
            }
            if (current == null) {
                return false;
            }
        }
        if (current.getLeft() == null && current.getRight() == null) {
            if (current == root) {
                root = null;
            } else if (isLChild) {
                parent.setLeft(null);

            } else {
                parent.setRight(null);

            }
        } else if (current.getRight() == null) {
            if (current == root) {
                root = current.getLeft();
            } else if (isLChild) {
                parent.setLeft(current.getLeft());
            } else {
                parent.setRight(current.getLeft());
            }

        } else if (current.getLeft() == null) {
            if (current == root) {
                root = current.getRight();
            } else if (isLChild) {
                parent.setLeft(current.getRight());
            } else {
                parent.setRight(current.getLeft());
            }
        } else {
            NodeGeneric newNode = getNewNode(current);

            if (current == root) {
                root = newNode;
            } else if (isLChild) {
                parent.setLeft(newNode);
            } else {
                parent.setRight(newNode);
            }
            newNode.setLeft(current.getLeft());
        }
        return true;
    }

    /**
     * helper method for removeNode(). Takes node and returns node.
     *
     * @param oldNode the input node to be replaced
     * @return the new node that will be replacing the old node
     */

    private NodeGeneric getNewNode(NodeGeneric oldNode) {
        NodeGeneric parent = oldNode;
        NodeGeneric replacer = oldNode;
        NodeGeneric current = oldNode.getRight();
        while (current != null) {
            parent = replacer;
            replacer = current;
            current = current.getLeft();
        }
        if (replacer != oldNode.getRight()) {
            parent.setLeft(replacer.getLeft());
            replacer.setRight(oldNode.getRight());
        }
        return replacer;
    }

    /**
     * search method. Used to search this tree to find another node with the same String name. Takes a root node as
     * input as well as a Person object. This persons name is recursively searched and if found, that node will be returned.
     *
     * @param root         root to the tree being searched
     * @param searchPerson the person you are searching for by name
     * @return the node that is returned if a match is found
     */

    public NodeGeneric searchBST(NodeGeneric root, Person searchPerson) {
        if (root == null) return null;
        if (root.getElement().toString().compareTo(searchPerson.getName()) == 0) return root;

        if (searchPerson.getName().compareToIgnoreCase(root.getElement().toString()) < 0) {
            return searchBST(root.getLeft(), searchPerson);
        } else {
            return searchBST(root.getRight(), searchPerson);
        }

    }


}