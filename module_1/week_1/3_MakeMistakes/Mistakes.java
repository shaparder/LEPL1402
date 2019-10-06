import java.util.ArrayList;

public class Mistakes{
	public static void outOf(){
		int[] a = {1, 2 , 3};
		System.out.println(a[4]);
	}

	public static void nullPtr() {
		String var = null;
		var.length();
	}

	public static void concur() {
		ArrayList<Integer> integers = new ArrayList();
		integers.add(2);
		integers.forEach( el -> { integers.add( 0 ); } );
	}
}
