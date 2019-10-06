import java.lang.Integer;

public class Calculator {

	public static int add(String[] args) {
		int count = args.length;
		int result = 0;
		while(count != 0) {
			count--;
			result += Integer.parseInt(args[count]);
		}
		return(result);
	}

	public static void main(String[] args) {
		try {
			int result = add(args);
			System.out.println(result);
		} catch(Exception e) {
			throw new IllegalArgumentException("wrong command line arguments");
		}
	}
}
