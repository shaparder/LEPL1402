public class Fibonacci {

	/**
	 * recursive implementation, to prove the weakness of its time complexity\
	 * @param index of fibonacci number
	 * @return int containing fibonacci number, overflowing around 42
	 */
	public static int fiboRecursive(int index){
		if (index <= 1) return index;
		else return fiboRecursive(index - 1) + fiboRecursive(index - 2);
	}

	/**
	 * iterative implementation, allowing for better time complexity
	 * @param index of fibinaaci number
	 * @return int, overflowing around 42
	 */
	public static int fiboIterative(int index){
	    if (index <= 1) return index;

		int prevprev = 0, prev = 1, actual = 0;
		for (int i = 2; i <= index; i++) {
			actual = prev + prevprev;
			prevprev = prev;
			prev = actual;
		}
		return actual;
	 }
	 
	 public static void main(String[] args) {
		 int indexTest = 90;
		 System.out.println("iterative : " + fiboIterative(indexTest));
		 System.out.println("recursive : " + fiboRecursive(indexTest));
	 }
}
