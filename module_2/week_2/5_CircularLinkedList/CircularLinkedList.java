import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class CircularLinkedList<Item> implements Iterable<Item> {

	private int n; // size of the list
	private Node last; // trailer of the list

	// helper linked list class
	private class Node {

		private Item item;
		private Node next;

		private Node(Item item) {
			this.item = item;
			this.next = null;
		}

	}

	public CircularLinkedList() {
		last = null;
		n = 0;
	}

	public boolean isEmpty() {
		return n == 0;
	}

	public int size() {
		return n;
	}

	public Node getLast() {
		return last;
	}

	public Item getItem(Node n) {
		return n.item;
	}

	/**
	 * Append an item at the end of the list
	 * 
	 * @param item the item to append
	 */
	public void enqueue(Item item) {
		Node newNode = new Node(item);
		if (last == null) {
			newNode.next = newNode;
		} else {
			newNode.next = last.next;
			last.next = newNode;
		}
		last = newNode;
		n++;
	}

	/**
	 * Removes the element at the specified position in this list. Shifts any
	 * subsequent elements to the left (subtracts one from their indices). Returns
	 * the element that was removed from the list.
	 */
	public Item remove(int index) {
		if (index < 0 || index > n - 1)
			throw new IndexOutOfBoundsException();

		Node node = last;
		for (int i = 0; i != index; i++) {
			node = node.next;
		}
		Item item = node.next.item;
		node.next = node.next.next;
		if (index == n - 1)
			last = node;
		n--;
		return item;
	}

	/**
	 * Returns an iterator that iterates through the items in FIFO order.
	 * 
	 * @return an iterator that iterates through the items in FIFO order.
	 */
	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	/**
	 * Implementation of an iterator that iterates through the items in FIFO order.
	 *
	 */
	private class ListIterator implements Iterator<Item> {
		private Node fifo = last;
		private final int nInit = n;
		private int count = 0;

		private boolean failFastCheck() {
			if (n != nInit)
				throw new ConcurrentModificationException();
			return true;
		}

		public boolean hasNext() {
			return count < n && failFastCheck();
		}
		
		public Item next() {
			failFastCheck();
			fifo = fifo.next;
			Item item = fifo.item;
			count++;
			return item;
		}
	}

}