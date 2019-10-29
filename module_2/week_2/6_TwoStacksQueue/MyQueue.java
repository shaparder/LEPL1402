import java.util.Stack;

public class MyQueue<E> {

	Stack<E> s1;
	Stack<E> s2;

	/*
	 * Constructor
	 */
	public MyQueue() {
		s1 = new Stack<>();
		s2 = new Stack<>();
	}

	/**
	 * Push element x to the end of the queue (remember, a queue is FIFO)
	 */
	public void enqueue(E elem) {
		while (!s1.empty())
			s2.push(s1.pop());
		s1.push(elem);
		while (!s2.empty())
			s1.push(s2.pop());
	}

	/*
	 * Removes the front element of this queue
	 */
	public E dequeue() {
		return s1.pop();
	}

	/*
	 * Get the first element of this list but does not remove it
	 */
	public E peek() {
		return s1.peek();
	}

	/*
	 * Tells if the queue is empty or not.
	 */
	public boolean empty() {
		return s1.empty();
	}

}
