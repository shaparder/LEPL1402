import Array2DMatrix.Array2DBuilderInterface;

// package S1;

public class MyBuilder implements Array2DBuilderInterface{
	public int[][] buildFrom(String s){
		int nl_count = 0;
		char[] str = s.trim().toCharArray();
		if (str[str.length - 1] != '\n') {
			str = new char[s.trim().length() + 1];
			for (int i = 0; i < s.trim().length(); i++)
				str[i] = s.trim().charAt(i);
			str[s.trim().length()] = '\n';
		}
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

	public int sum(int[][] array){
		int count = 0;
		for (int x = 0; x < array.length; x++) {
			for (int y = 0; y < array[x].length; y++)
			{
				count += array[x][y] ;
			}
		}
		return count;
	}

	public int[][] transpose(int[][] matrix){
		int[][] t = new int[matrix[0].length][matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				t[j][i]= matrix[i][j];
			}
		}
		return t;
	}

	public int[][] product(int[][] matrix1, int[][] matrix2){
		int[][] p = new int[matrix1.length][matrix2[0].length];
		for (int i = 0; i < matrix1.length; i++) {
			for (int j = 0 ; j < matrix2[0].length; j++) {
				for (int k = 0; k < matrix1[0].length; k++) {
					p[i][j] += matrix1[i][k] * matrix2[k][j];
				}
			}
		}
		return p;
	}

	// public static void main(String[] args) {
	// 	int[][] array1 = buildFrom("   0 1 3 0 \n 8 5 0 6 \n 0 0 1 1   ");
	// 	int[][] array2 = buildFrom("0 1 \n 0 0 \n 3 3 \n 9 5 \n");
	// 	int[][] array = product(array1, array2);
	// 	for (int[] x : array) {
	// 		for (int y : x)
	// 		{
	// 			System.out.print(y + " ");
	// 		}
	// 		System.out.println();
	// 	}
	// 	System.out.println("");
	// }
}
