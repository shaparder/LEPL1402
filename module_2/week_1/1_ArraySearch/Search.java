
public class Search {

	/**
	 * the goal of this exercice is to understand the importance of time and space complexity
	 * @param tab is an ascending order ordered array of int.
	 * @return index of elem or -1 if doesnt exist
	 */
	public static int search1(int[] tab, int elem){
		if (tab == null || tab[0] > elem || tab[tab.length - 1] < elem)
			return -1;
		int i  = tab.length/2;
		for (int j = 4; (i < tab.length && i >= 0); j *= 2) {
			if (tab[i] == elem)
				return i;
			else if ( tab[i] < elem)
				i = i + (int) Math.ceil((double)tab.length / j);
			else
				i = i - (int) Math.ceil((double)tab.length / j);
		}
		return -1;
	}

	public static int search2(int[] tab, int elem){
		if (tab == null || tab[0] > elem || tab[tab.length - 1] < elem)
			return -1;
		int start = 0;
		int end   = tab.length - 1;
		int index = 0;
		while( start <= end ) {
			index = ( start + end ) / 2;
			if( tab[ index ] == elem )
				return index;
			if( tab[ index ] < elem )
				start = index + 1;
			else
				end = index - 1;
		}
		return -1;
	}
}
