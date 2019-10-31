import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<Item> implements Iterable<Item> {

	private Object[] list;
	private int size;

	public MyArrayList(int initSize) {
		if (initSize < 0)
			throw new IndexOutOfBoundsException();
		list = new Object[initSize];
		this.size = 0;
	}

	/*
	 * Checks if 'list' needs to be resized then add the element at the end of the
	 * list.
	 */
	public void enqueue(Item item) {
		if (size == list.length) {
			Object[] tmp = new Object[size];
			for (int i = 0; i < size; i++) {
				tmp[i] = list[i];
			} 
			list = new Object[size + (size >> 1)];
			for (int j = 0; j < size; j++) {
				list[j] = tmp[j];
			}
		}
		list[size] = item;
		size++;
	}

	/*
	 * Removes the element at the specified position in this list. Returns the
	 * element that was removed from the list. You dont need to resize when removing
	 * an element.
	 */
	public Item remove(int index) {
		if (index < 0 || index > size - 1)
			throw new IndexOutOfBoundsException();
		Item item = (Item) list[index];
		for (int i = index + 1; i < size; i++) {
			list[i - 1] = list [i];
		}
		list[size - 1] = null;

		size--;
		return item;
	}

	public int size() {
		return this.size;
	}

	@Override
	public Iterator<Item> iterator() {
		return new MyArrayListIterator();
	}

	private class MyArrayListIterator implements Iterator<Item> {
		private int count = 0;
		private final int sizeInit = size;

		private boolean failFastCheck() {
			if (size != sizeInit)
				throw new ConcurrentModificationException();
			return true;
		}

		@Override
		public boolean hasNext() {
			return failFastCheck() && count < size;
		}

		@Override
		public Item next() {
			failFastCheck();
			if (!hasNext())
				throw new NoSuchElementException();
			
			return (Item) list[count++];
		}
	}

}