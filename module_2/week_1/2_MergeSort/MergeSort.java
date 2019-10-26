public class MergeSort {

	/**
	 * Pre-conditions: a[lo..mid] and a[mid+1..hi] are sorted
	 * Post-conditions: a[lo..hi] is sorted
	 */
	private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
		for (int c = 0; c < a.length; c++) {
			aux[c] = a[c];
		}

		int i, j;

		i = lo;
		j = mid + 1;

		for( int k = lo; k <= hi; ++k ) {
			if( i > mid ) {
				a[ k ] = aux[ j++ ];
			} else if( j > hi ) {
				a[ k ] = aux[ i++ ];
			} else if( aux[ j ] < aux[ i ] ) {
				a[ k ] = aux[ j++ ];
			} else {
				a[ k ] = aux[ i++ ];
			}
		}
	}
	/**
	 * Rearranges the array in achii order, using the natural order
	 */
	public static void sort(int[] a) {
		int len = a.length;
		int[] aux = new int[len];

		for (int size = 1; size <= len - 1; size *= 2) {
			for (int lo = 0; lo < len - 1; lo += 2 * size) {
				int mid = Math.min(lo + size - 1, len - 1);
				int hi = Math.min(lo + 2 * size - 1, len - 1);
				merge(a, aux, lo, mid, hi);
			}
		}
	}

	public static void printArray(int a[]) {
			for (int i = 0; i < a.length; i++) 
				System.out.printf("%d ", a[i]);
			System.out.printf("\n"); 
	}

	public static void main(String[] args) {
		int a[] = {12, 11, 13, 6, 5, 7};

		sort(a);
		printArray(a);
	}

}
