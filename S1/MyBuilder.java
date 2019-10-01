// package S1;

public class MyBuilder {
	public static int[][] buildFrom(String s){
		int nl_count = 0;
		char[] str = s.toCharArray();
		for (char ch: str) {
			if (ch == '\n')
				nl_count++;
		}
		int[][] array2d = new int[nl_count][];
		int start = 0;
		int i_count, j, x;
		for (int i = 0; i < nl_count; i++){
			i_count = 0;
			x = 0;
			while (str[x + start] != '\n') {
				if (Character.isDigit(str[x + start]) && !Character.isDigit(str[x + start + 1]))
					i_count++;
				x++;
			}
			array2d[i] = new int[i_count];
			j = 0;
			for (int y = 0; str[y + start] != '\n'; y++) {
				if (Character.isDigit(str[y + start]) && !Character.isDigit(str[y + start + 1])) {
					array2d[i][j] = str[y + start] - 48;
					j++;
				} else if (Character.isDigit(str[y + start]) && Character.isDigit(str[y + start + 1])) {
					array2d[i][j] = 0;
					while (Character.isDigit(str[y + start])) {
						array2d[i][j] = (array2d[i][j] * 10) + str[y + start] - 48;
						y++;
					}
					j++;
				}
			}
			start += x + 1;
		}
		return (array2d);
	}

	public static int sum(int[][] array){
		int count = 0;
		for (int x = 0; x < array.length; x++) {
			for (int y = 0; y < array[x].length; y++)
			{
				count += array[x][y] ;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[][] array = buildFrom("3 7 3 \n 4 5 \n 42 67 87 \n");
		for (int[] x : array) {
			for (int y : x)
			{
				System.out.print(y + " ");
			}
			System.out.println();
		}
		System.out.println(sum(array));
	}

	// public int[][] transpose(int[][] matrix){
	//     //TODO
	// }
	// public int[][] product(int[][] matrix1, int[][] matrix2){
	//     //TODO
	// }
}
