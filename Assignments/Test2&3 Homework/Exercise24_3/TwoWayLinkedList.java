/*
(Implement a doubly linked list) The MyLinkedList class used in Listing 24.6
is a one-way directional linked list that enables one-way traversal of the list.
Modify the Node class to add the new data field name previous to refer to the
previous node in the list, as follows:
public class Node<E> {
E element;
Node<E> next;
Node<E> previous;
public Node(E e) {
element = e;
}
}
Implement a new class named TwoWayLinkedList that uses a doubly
linked list to store elements. The MyLinkedList class in the text
extends MyAbstractList. Define TwoWayLinkedList to extend the
java.util.AbstractSequentialList class. You need to implement all the
methods defined in MyLinkedList as well as the methods listIterator()
Programming Exercises 927
and listIterator(int index). Both return an instance of java.util.
ListIterator<E>. The former sets the cursor to the head of the list and the
latter to the element at the specified index.
*/
/*
This assignment is far from complete. Sorry. Due to poorly worded problems (see above) and code that didn't work on it's own before. (along with a mixture of exams, sleep-deprevation and work) I have failed to even create a file that synthesizes the given code given by the book. And am thereby forced to admit defeat until a later date.
*/



public class TwoWayLinkedList<E> extends java.util.AbstractSequentialList<E> {
  private Node<E> head, tail;
  private int size = 0;


  /** Create a default list */
  public TwoWayLinkedList() {
  }

  /** Create a list from an array of objects */
  public void TwoLinkedList(E[] objects) {
    super(objects);
  }

  /** Return the head element in the list */
  public E getFirst() {
    if (size == 0) {
      return null;
    }
    else {
      return head.element;
    }

  }

  /** Return the last element in the list */
  public E getLast() {
    if (size == 0) {
      return null;
    }
    else {
      return tail.element;
    }
  }

  /** Add an element to the beginning of the list */
  public void addFirst(E e) {
    Node<E> newNode = new Node<E>(e); // Create a new node
    newNode.next = head; // link the new node with the head
    head = newNode; // head points to the new node
    size++; // Increase list size

    if (tail == null) // the new node is the only node in list
      tail = head;
  }

  /** Add an element to the end of the list */
  public void addLast(E e) {
    Node<E> newNode = new Node<E>(e); // Create a new for element e

    if (tail == null) {
      head = tail = newNode; // The new node is the only node in list
    }
    else {
      tail.next = newNode; // Link the new with the last node
      tail = tail.next; // tail now points to the last node
    }

    size++; // Increase size
  }


  @Override /** Add a new element at the specified index
   * in this list. The index of the head element is 0 */
  public void add(int index, E e) {
    if (index == 0) {
      addFirst(e);
    }
    else if (index >= size) {
      addLast(e);
    }
    else {
      Node<E> current = head;
      for (int i = 1; i < index; i++) {
        current = current.next;
      }
      Node<E> temp = current.next;
      current.next = new Node<E>(e);
      (current.next).next = temp;
      size++;
    }
  }

  /** Remove the head node and
   *  return the object that is contained in the removed node. */
  public E removeFirst() {
    if (size == 0) {
      return null;
    }
    else {
      Node<E> temp = head;
      head = head.next;
      size--;
      if (head == null) {
        tail = null;
      }
      return temp.element;
    }
  }

  /** Remove the last node and
   * return the object that is contained in the removed node. */
  public E removeLast() {
    if (size == 0) {
      return null;
    }
    else if (size == 1) {
      Node<E> temp = head;
      head = tail = null;
      size = 0;
      return temp.element;
    }
    else {
      Node<E> current = head;

      for (int i = 0; i < size - 2; i++) {
        current = current.next;
      }

      Node<E> temp = tail;
      tail = current;
      tail.next = null;
      size--;
      return temp.element;
    }
  }

  @Override /** Remove the element at the specified position in this
   *  list. Return the element that was removed from the list. */
  public E remove(int index) {
    if (index < 0 || index >= size) {
      return null;
    }
    else if (index == 0) {
      return removeFirst();
    }
    else if (index == size - 1) {
      return removeLast();
    }
    else {
      Node<E> previous = head;

      for (int i = 1; i < index; i++) {
        previous = previous.next;
      }

      Node<E> current = previous.next;
      previous.next = current.next;
      size--;
      return current.element;
    }
  }

  @Override /** Override toString() to return elements in the list */
  public String toString() {
    StringBuilder result = new StringBuilder("[");

    Node<E> current = head;
    for (int i = 0; i < size; i++) {
      result.append(current.element);
      current = current.next;
      if (current != null) {
        result.append(", "); // Separate two elements with a comma
      }
      else {
        result.append("]"); // Insert the closing ] in the string
      }
    }

    return result.toString();
  }

  @Override /** Clear the list */
  public void clear() {
    size = 0;
    head = tail = null;
  }

  @Override /** Return true if this list contains the element e */
  public boolean contains(E e) {
    System.out.println("Implementation left as an exercise");
    return true;
  }

  @Override /** Return the element at the specified index */
  public E get(int index) {
    System.out.println("Implementation left as an exercise");
    return null;
  }

  @Override /** Return the index of the head matching element in
   *  this list. Return -1 if no match. */
  public int indexOf(E e) {
    System.out.println("Implementation left as an exercise");
    return 0;
  }

  @Override /** Return the index of the last matching element in
   *  this list. Return -1 if no match. */
  public int lastIndexOf(E e) {
    System.out.println("Implementation left as an exercise");
    return 0;
  }

  @Override /** Replace the element at the specified position
   *  in this list with the specified element. */
  public E set(int index, E e) {
    System.out.println("Implementation left as an exercise");
    return null;
  }

  @Override /** Override iterator() defined in Iterable */
  public java.util.Iterator<E> iterator() {
    return new LinkedListIterator();
  }

  private void checkIndex(int index) {
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException
        ("Index: " + index + ", Size: " + size);
  }
}
  class LinkedListIterator implements java.util.Iterator<E> {
    private Node<E> current = head; // Current index

    @Override
    public boolean hasNext() {
      return (current != null);
    }

    @Override
    public E next() {
      E e = current.element;
      current = current.next;
      return e;
    }

    @Override
    public void remove() {
      System.out.println("Implementation left as an exercise");
    }
  }

class Node<E> {
       E element;
       Node<E> next;
       Node<E> previous;
       public Node(E e) {
          element = e;
       }
    }//End Node Class
