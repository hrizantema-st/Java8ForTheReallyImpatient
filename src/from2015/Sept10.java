package from2015;

public class Sept10 {

	static boolean member(int x, int[] a) {
		if (a.length == 0)
			return false;
		return a[a.length / 2] == x || (a[a.length / 2] < x && member(x, a)) || (a[a.length / 2] > x && member(x, a));
	}

	public static void zad(final int m, final int n, final double[][] matrix) {
		double[][] result = new double[(m + 1) / 2][(n + 1) / 2];
		for (int i = 0; i < (m + 1) / 2; i++) {
			for (int j = 0; j < (n + 1) / 2; j++) {

				double sum = 0;
				int count = 0;

				for (int y = 0; y < m; y++) {
					for (int x = 0; x < n; x++) {
						if (i * 2 <= y && y <= i * 2 + 1 && j * 2 <= x && x <= j * 2 + 1) {
							sum += matrix[y][x];
							count++;
						}
					}
				}
				System.out.println(sum);
				System.out.println(count);
				result[i][j] = sum / (double) count;
			}
		}

		for (int y = 0; y < (m + 1) / 2; y++) {
			for (int x = 0; x < (n + 1) / 2; x++) {
				System.out.print(result[y][x] + "  ");
			}
			System.out.println();
		}
	}

	public static void zad2014(int n, float[] x, float[] y) {
		float maxX = x[0], minX = x[0], maxY = y[0], minY = y[0];
		for (int i = 1; i < n; i++) {
			if (x[i] > maxX) {
				maxX = x[i];
			} else if (x[i] < minX) {
				minX = x[i];
			}
			if (y[i] > maxY) {
				maxY = y[i];
			} else if (x[i] < minY) {
				minY = y[i];
			}

		}
		double xCenter = ((maxX + minX) / (double) 2);
		double yCenter = ((maxY + minY) / (double) 2);
		double size;
		if(Math.abs(maxX) - Math.abs(minX) > Math.abs(maxY) - Math.abs(minY)){
			size = Math.abs(maxX) - Math.abs(minX);
		}
		else {
			size =  Math.abs(maxY) - Math.abs(minY);
		}
		System.out.println(
				"Coords of center: [" + xCenter + ", " + yCenter + "]");
		System.out.println("Length of side: "  + size);
	}

	public static void main(String[] agrs) {
		/*
		 * int a = 0; int b = 15; int result = 1; if (b < 10 && b / a < 10)
		 * result = 0; else result = 1; System.out.println(member(5, new int[] {
		 * 1, 2, 78, 100 }));
		 * 
		 * int[] arr = { 10, 20, 30, 40, 50 }; Arrays.copyOfRange(arr, 0, 2); //
		 * returns {10, 20}
		 */
		double[][] arr = { { 1.0, 2.0, 3.0 }, { 4.5, 6.5, 7.5 } };
		// zad(2, 3, arr);
		float[] xx = { -1, -1, 1, 1 };
		float[] yy = { -1, 1, -1, 3 };
		zad2014(4, xx, yy);

	}

}
