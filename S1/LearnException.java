public class LearnException {

	public static double divide(int i1, int i2) throws ArithmeticException{
		if (i2 == 0)
			throw new ArithmeticException();
		else
			return ((double)i1/(double)i2);
	}

	public static boolean canDivide(int i1, int i2){
	    try {
	        divide(i1, i2);
	        return true;
	    } catch (ArithmeticException e) {
	        return false;
	    }
	}

	public static double betterDivide(int i1, int i2) throws ArithmeticException{
	    if (i2 == 0)
	        throw new ArithmeticException("division by zero");
	    else
	        return ((double)i1/(double)i2);
	}

 	public static String betterCanDivide(int i1, int i2){
		String msg;
		try {
			msg = Double.toString(betterDivide(i1, i2));
		} catch (ArithmeticException e) {
			msg = e.getMessage();
		}
		return msg;
	}

	public static void main(String[] args) {
		System.out.println(betterCanDivide(1, 0));
	}
}
