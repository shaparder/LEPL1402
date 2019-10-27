import java.util.Stack;

public class TowerOfHanoi {

	/**
	 * we want the tower to be moved from a to b.
	 * The first value n is the size of the stack.
	 */
	public static void towerOfHanoi(int n, Stack<Disk> a, Stack<Disk> b, Stack<Disk> c) {
		if (n == 1) {
			b.push(a.pop());
			return;
		}
		towerOfHanoi(n-1, a, c, b);
		b.push(a.pop());
		towerOfHanoi(n-1, c, b, a);
	}
	/**
	 * 
	 * @param stackSize number of disks on the stack a
	 * @return number of moves needed to move all disks from a stack to another
	 */
	public static int numberOfMoves(int stackSize){
		return (int) Math.pow(2, stackSize) - 1;
	}

}
