import java.util.*;
/**
 * NLNode
 * NLNode represents a node in a tree that can have infinite child nodes.
 *
 * @author Jonathan Peters
 * @version 1.0, 06/04/23
 */
public class NLNode<T> {
    private NLNode<T> parent;
    private ListNodes<NLNode<T>> children;
    private T data;

    /**
     * Constructor for NLNode
     * Creating an empty node
     */
    public NLNode() {
        parent = null;
        data = null;
        children = new ListNodes<NLNode<T>>(); //Setting children as an empty ListNode
    }

    /**
     * Constructor for Node given parent and data item
     *
     * @param d data held in the node
     * @param p Parent node
     */
    public NLNode(T d, NLNode<T> p) {
        data = d;
        parent = p;
        children = new ListNodes<NLNode<T>>(); //Initialzing an empty ListNodes
    }

    /**
     * addChild
     * Adds a child to the node
     *
     * @param newChild
     */
    public void addChild(NLNode<T> newChild) {
        children.add(newChild); //Adding the new child
        newChild.setParent(this); //Setting its parent
    }

    /**
     * getChildren
     * Gets the child nodes of the respective node give a sorter
     *
     * @param sorter How to sort the arraylist of children
     * @return iterator of nodes
     */
    public Iterator<NLNode<T>> getChildren(Comparator<NLNode<T>> sorter) {
        Iterator<NLNode<T>> iter = children.sortedList(sorter); //Getting an iterator from the list of ListNodes class using the sorter comparator
        return iter;
    }

    /**
     * getChildren
     * Returning the the children of the node as is, no order
     *
     * @return iterator of nodes
     */
    public Iterator<NLNode<T>> getChildren() {
        Iterator<NLNode<T>> iter = children.getList(); //Getting an iterator from the list of ListNodes class without specifying how to sort it
        return iter;
    }

    /**
     * getParent
     * @return Parent Node
     */
    public NLNode<T> getParent() {
        return parent;
    }

    /**
     * getData
     * @return Return data
     */
    public T getData() {
        return data;
    }

    /**
     * setParent
     * @param p The new parent
     */
    public void setParent(NLNode<T> p) {
        parent = p;
    }

    /**
     * setData
     * @param d Node's new data
     */
    public void setData(T d) {
        data = d;
    }
}
