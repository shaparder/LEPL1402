// public class Mistakes{
// 	public static void main(String[] args){
// 		int[] a = {1, 2 , 3};
// 		System.out.println(a[4]);
// 	}
// }

// public class Mistakes{
//     public static void main(String[] args) {
// 		String var = null;
// 		var.length();
// 	}
// }

import java.util.Arrays;
import java.util.List;

public class Mistakes{
    public static void main(String[] args) {
		List<Integer> integers = Arrays.asList(1, 2, 3);
		for (Integer i : integers) {
			integers.remove(1);
		}
    }
}
