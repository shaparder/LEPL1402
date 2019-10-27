public class Valley {
	/*
	 * Example: [1, 1, 1, -1, -1, -1, -1, -1, 1, 1, 1, 1, 1, 1, -1, -1] Should
	 * return [5, 3]
	 */

	public static int[] valley(int[] array) {
		int highest_mountain = 0;
		int deepest_valley = 0;
		int slope_down = 0;
		int slope_up = 0;
		int len = array.length;
		int i = 0;

		while (i < len) {
			slope_down = 0;
			while (i < len && array[i] == -1) {
				slope_down++;
				i++;
			} 
			highest_mountain = Math.max(highest_mountain, Math.min(slope_down, slope_up));
			slope_up = 0;
			while (i < len && array[i] == 1) {
				slope_up++;
				i++;
			}
			deepest_valley = (int) Math.max(deepest_valley, Math.min(slope_down, slope_up));
		}
		return new int[] {deepest_valley, highest_mountain};
	}

	public static void main(String[] args) {
		int[] array = {1, 1, 1, -1, -1, -1, -1, -1, 1, 1, 1, 1, 1, 1, -1, -1};
		int[] result = valley(array);
		System.out.println("[" + result[0] + ", " + result[1] + "]");
	}
}
