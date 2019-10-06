public class StringUtils {


    /*
     * Split the input string 'str' w.r.t the character 'marker' in an array of String
     * for example split("test-test", '-') => {"test", "test"}
     * Must return null if there is no occurrence of 'marker' in 'str'
     */
    public static String[] split(String str, char marker){
		String[] split;
		int len = str.length();
		int delim_count = 0;
		int index = 0;
		for (int i = 0; i < len; i++){
			if (str.charAt(i) == marker && (i + 1 < len))
				delim_count++;
		}
		if (delim_count == 0)
			return null;
		split = new String[delim_count + 1];
		StringBuilder chunk = new StringBuilder(len - delim_count);
		for (int j = 0; j < len; j++){
			if (str.charAt(j) == marker){
				split[index] = chunk.toString();
				chunk = new StringBuilder(len - j);
				index++;
			} else {
				chunk.append(str.charAt(j));
			}
		}
		if (chunk.length() > 0) {
			split[index] = chunk.toString();
		}
		return split;
	}


	/*
     * Returns the index of the first occurrence of sub in str
     * or -1 if there is no occurrence of sub in str at all.
     * Be careful, we ask you to make CASE SENSITIVE comparison between str and sub.
     */
    public static int indexOf(String str, String sub){
		int	x = 0;
		int	y = 0;
		if (str.length() <= 0 || sub.length() <= 0)
			return -1;
		while (x < str.length())
		{
			if (str.charAt(x) == sub.charAt(y))
				y++;
			else
			{
				x = x - y;
				y = 0;
			}
			if (y >= sub.length())
				return x - y + 1;
			x++;
		}
		return -1;
	}


    // public static String toLowerCase(String str){

    // }


    /*
     * Returns true if the string 'str' is a palindrome (a string that reads the same from
     * left to right AND from right to left).
     */
    // public static boolean palindrome(String str){

    // }

	public static void main(String[] args) {
		// String str = "prout. i. got. it.";
		// char delim = '.';
		// String[] arrtest = split(str, delim);
		// for(String s: arrtest){
		// 	System.out.println(s);
		// }
		System.out.println(indexOf("bitebitebote", "bote"));
	}

}
