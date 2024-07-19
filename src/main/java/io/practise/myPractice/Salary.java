package io.practise.myPractice;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Salary {

	@SuppressWarnings("deprecation")
	int howMuch(String[] arrival, String[] departure, int wage) throws ParseException {
		int totalIncentive = 0;
		for (int i = 0; i < arrival.length; i++) {
			SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH);
			Date arr = df.parse(arrival[i]);
			Date dep = df.parse(departure[i]);
			int diffHours;
			double diffMin, diffSec;

			diffHours = dep.getHours() - arr.getHours();
			diffMin = dep.getMinutes() - arr.getMinutes();
			diffSec = dep.getSeconds() - arr.getSeconds();

			if (diffSec < 0) {
				--diffMin;
				diffSec = 60 + diffSec;
			}
			if (diffMin < 0) {
				--diffHours;
				diffMin = 60 + diffMin;
			}

			if (arr.getHours() >= 0 && dep.getHours() < 6) {
				totalIncentive += (diffHours + (diffMin / 60) + (diffSec / 3600)) * wage * 1.5;
				System.out.println("1. " + arr.getHours() + " " + dep.getHours() + " " + diffHours + " " + diffMin + " "
						+ diffSec + " " + totalIncentive);
			} else if (arr.getHours() >= 0 && arr.getHours() < 6 && dep.getHours() < 18) {
				totalIncentive += (6 - arr.getHours()) * wage * 1.5;
				totalIncentive += ((dep.getHours() - 6) + (diffMin / 60) + (diffSec / 3600)) * wage;
				System.out.println("2. " + arr.getHours() + " " + dep.getHours() + " " + diffHours + " " + diffMin + " "
						+ diffSec + " " + totalIncentive);
			} else if (arr.getHours() >= 0 && arr.getHours() < 6 && dep.getHours() <= 23) {
				totalIncentive += (6 - arr.getHours()) * wage * 1.5;
				totalIncentive += 12 * wage;
				totalIncentive += ((dep.getHours() - 18) + (diffMin / 60) + (diffSec / 3600)) * wage * 1.5;
				System.out.println("3. " + arr.getHours() + " " + dep.getHours() + " " + diffHours + " " + diffMin + " "
						+ diffSec + " " + totalIncentive);
			} else if (arr.getHours() >= 6 && dep.getHours() < 18) {
				totalIncentive += (diffHours + (diffMin / 60) + (diffSec / 3600)) * wage;
				System.out.println("4. " + arr.getHours() + " " + dep.getHours() + " " + diffHours + " " + diffMin + " "
						+ diffSec + " " + totalIncentive);
			} else if (arr.getHours() >= 6 && arr.getHours() < 18 && dep.getHours() > 18 && dep.getHours() <= 23) {
				totalIncentive += 12 * wage;
				totalIncentive += ((dep.getHours() - 18) + (diffMin / 60) + (diffSec / 3600)) * wage * 1.5;
				System.out.println("5. " + arr.getHours() + " " + dep.getHours() + " " + diffHours + " " + diffMin + " "
						+ diffSec + " " + totalIncentive);
			} else if (arr.getHours() >= 18 && dep.getHours() <= 23) {
				totalIncentive += (diffHours + (diffMin / 60) + (diffSec / 3600)) * wage * 1.5;
				System.out.println("6. " + arr.getHours() + " " + dep.getHours() + " " + diffHours + " " + diffMin + " "
						+ diffSec + " " + totalIncentive);
			}

			System.out.println("Last " + arr.getHours() + " " + dep.getHours() + " " + diffHours + " " + diffMin + " "
					+ diffSec + " " + totalIncentive);
		}
		return totalIncentive;
	}

	public static void main(String[] args) throws ParseException {

		Salary s = new Salary();
		String[] arrival = { "00:11:13", "02:59:22", "04:42:01", "06:33:45", "08:22:30", "09:21:27", "11:15:50",
				"12:40:14", "13:55:51" };
		String[] departure = { "01:48:51", "03:22:59", "06:33:07", "06:45:47", "08:23:15", "09:34:07", "11:48:51",
				"12:47:18", "16:01:53" };
		System.out.println(s.howMuch(arrival, departure, 9998));

		arrival = new String[] { "01:05:47", "16:48:12" };
		departure = new String[] { "09:27:30", "21:17:59" };
		System.out.println(new Salary().howMuch(arrival, departure, 2000));

		arrival = new String[] { "08:00:00", "13:00:00", "19:27:32" };
		departure = new String[] { "12:00:00", "17:00:00", "20:48:10" };
		System.out.println(new Salary().howMuch(arrival, departure, 1000));

		arrival = new String[] { "00:00:00" };
		departure = new String[] { "23:59:59" };
		System.out.println(new Salary().howMuch(arrival, departure, 10000));

	}

}
