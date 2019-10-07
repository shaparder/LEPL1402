import java.util.ArrayList;

public class Decoder {
	/*
	* Forbidden characters are passed as an array of int.
	* Each element of this array correspond to the decimal ASCII code
	* of a forbidden character OR null if there's no forbidden character
	* If you encounter one of these forbidden character
	* you must ignore it when you translate your sentence.
	*
	* the 2D array "sentences" contain a set of decimal ASCII code we want you
	* to translate. Each sub-element of this array is a different sentence.
	* Ex : if we pass this array : [ ["42", "72", "88"], ["98", "99", "111", "47", "55"]]
	* to your decode method, you should return : [ "*HX", "bco/7" ]
	*
	* You should NEVER return null or an array containing null
	*/
	public static String[] decode(int[] forbidden, String[][] sentences){
		ArrayList<String> list = new ArrayList<String>();
		StringBuilder decode;
		boolean forbidden_value;
		int ascii;
		for (String[] sentence: sentences) {
			decode = new StringBuilder(sentence.length);
			for (String str: sentence) {
				forbidden_value = false;
				ascii = Integer.parseInt(str);
				if (forbidden != null) {
					for (int f: forbidden) {
						if (f == ascii) {
							forbidden_value = true;
							break;
						}
					}
				}
				if (!forbidden_value)
					decode.append((char)ascii);
			}
			list.add(decode.toString());
		}
		return list.toArray(new String[list.size()]);
	}

	// public static void main(String[] args) {
		// // String[][] input = new String[][]{{"072" ,"101", "108", "108", "111", "032", "119", "111", "114", "108", "100"}};
		// // String[] res = Decoder.decode(null, input);
		// String [] [] input = new String[][]{{"084", "104", "105", "115", "032", "105", "115", "032"},
		//         {"097", "032", "108", "097", "114", "103", "101", "114"},
		//         {"115", "101", "116", "032", "111", "102", "032", "115", "101", "110",
		//                 "116", "101", "110", "099", "101", "115", "046", "046", "046"}};
		// String [] res = Decoder.decode(new int[]{32, 101}, input);
		// for (String s: res) {
		// 	System.out.println(s);
		// }
	// }
}
