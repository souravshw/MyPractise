package myPractice;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LocDiff {
	private static double[] x = new double[10000];
	private static double[] y = new double[10000];
	private static int[] time = new int[10000];
	private static String[] dest = new String[10000];

	private static int t = 1;
	static int count = 0;

	public static void main(String[] args) throws FileNotFoundException {

		String line;
		File file = new File("0.0.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		try {
			while ((line = br.readLine()) != null) {
				String[] coord = line.split(",");

				x[count] = Double.parseDouble(coord[0]);
				y[count] = Double.parseDouble(coord[1]);
				time[count] = Integer.parseInt(coord[2]);
				dest[count] = coord[3];
				count++;
			}
			System.out.println(count);
		} catch (IOException e) {
			e.printStackTrace();
		}
		calDiff(x, y);
	}

	public static void calDiff(double[] x, double[] y) {
		int patience_limit = 300;
		int range = 70;
		for (int i = 0; i < count; i++) {
			for (int j = i + 1; (time[j] - time[i]) < patience_limit && j <= count; j++) {
				double a = Math.sqrt((Math.pow(y[i] - y[j], 2) + Math.pow(x[i] - x[j], 2)));
				if (a <= range && a > 0.0 && dest[j].equals(dest[i])) {
					System.out.println(
							t + ")   x:" + x[i] + "," + y[i] + "  y:" + x[j] + "," + y[j] + " " + Integer.toString(i)
									+ " " + Integer.toString(j) + " " + "a:" + a + " time:" + Integer.toString(time[i])
									+ " " + Integer.toString(time[j]) + " dest: " + dest[i] + " " + dest[j]);
					t++;
				}
			}
		}
	}

}
