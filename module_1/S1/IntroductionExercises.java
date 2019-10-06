public class IntroductionExercises {

	public static int variable = 0;

	public static int[] squares;

	//changes the value of the variable variable to value
	public static void attribute(int value) {
		variable = value;
	}

	// returns the addition of a and b
	public static int add(int a, int b) {
		return (a + b);
	}

	// returns true if a is equal to b
	public static boolean equalsIntegers(int a, int b) {
		return (a == b);
	}

	// returns the middle value between a, b and c, if minimum two value are equals, return -1
	public static int middleValue(int a, int b , int c) {
		if (a == b || b == c || a == c)
			return (-1);
		if ((a < b && b < c) || (a > b && b > c))
			return (b);
		else if ((c < a && a < b) || ((c > a && a > b)))
			return (a);
		else
			return (c);
	}

	// returns the max between a and b using a ternary operation
	public static int max(int a, int b) {
		return ((a > b) ? a : b);
	}

	// return "Good morning, sir!" if str is "Morning" ...
	public static String greetings(String str) {
		switch (str) {
			case "Morning":
				return ("Good morning, sir!");
			case "Evening":
				return ("Good evening, sir!");
			default:
				return ("Hello, sir!");
		}
	}

	public static int[] lastFirstMiddle(int[] a) {
		return new int[] {a[a.length-1], a[0], a[a.length/2]};
	}

	// return the sum of all elements of array using a for loop
	public static int sum(int[] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		return sum;
	}

	// returns the maximum element of array using a while loop
	public static int maxArray(int[] array) {
		int max = array[0];
		int i = 0;
		int l = array.length;
		while (i < l) {
			if (max < array[i])
				max = array[i];
			i++;
		}
		return max;
	}

	public static void main(String... args){
		squares = new int[args.length];
		int l = args.length;
		for (int i = 0; i < l; i++) {
			try {
				squares[i] = Integer.parseInt(args[i]) * Integer.parseInt(args[i]);
			} catch (Exception e) {
				squares[i] = 0;
			}
		}
		// test print
		attribute(1);
		System.out.println(variable);
		System.out.println(add(variable, 2));
		System.out.println(equalsIntegers(variable, 1));
		System.out.println(equalsIntegers(variable, 2));
		System.out.println(middleValue(5, 2, 4));
		System.out.println(max(variable, -1));
		System.out.println(greetings("Evening"));
		System.out.println("square1:");
		for (int i = 0; i < squares.length; i++)
			System.out.print(squares[i] + " ");
		squares = lastFirstMiddle(squares);
		System.out.println("square2:");
		for (int i = 0; i < squares.length; i++)
			System.out.print(squares[i] + " ");
		System.out.println("square3:");
		System.out.println(sum(squares));
		System.out.println(maxArray(squares));
	}
}
