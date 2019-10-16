import java.util.BitSet;
import java.util.Scanner;

// import sun.jvm.hotspot.utilities.Bits;

public class Sieve{

	public static BitSet bits; //You should work on this BitSet

	/**
	 * @param n max number of prime number test (inclusive)
	 * @return numbers of prime numbers between 0 and 100 (0 and 1 arent prime numbers)
	 */
	public static int numberOfPrime(int n){
		if (n < 2)
			return 0;

		bits = new BitSet(n);
		bits.set(2, n, true);

		for (int i = 2; i*i <= n; i++)
			if (bits.get(i))
				for (int j = i*i; j <= n; j += i)
					bits.clear(j);

		return bits.cardinality();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Give the limit number to calculate primer numbers : ");
		int input = Integer.parseInt(scanner.next());
		scanner.close();
		int n = numberOfPrime(input);
		System.out.println("There is " + n + " prime numbers between 0 and " + input);
	}

}
