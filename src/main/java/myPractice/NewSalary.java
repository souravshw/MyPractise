package myPractice;
import java.text.ParseException;

public class NewSalary {
	static boolean debugging = false;

	void exit(int code) {
		if (debugging)
			System.exit(code);
	}

	public int howMuch(String[] arrival, String[] departure, int wage) {
		int i, j, k, l, m, n, count;
		int ans;
		String[] arg;

		int h, s, at, dt;

		long rt, ovt;
		n = arrival.length;
		rt = ovt = 0;

		for (i = 0; i < n; i++) {
			h = (arrival[i].charAt(0) - '0') * 10 + arrival[i].charAt(1) - '0';
			m = (arrival[i].charAt(3) - '0') * 10 + arrival[i].charAt(4) - '0';
			s = (arrival[i].charAt(6) - '0') * 10 + arrival[i].charAt(7) - '0';
			at = h * 60 * 60 + m * 60 + s;

			h = (departure[i].charAt(0) - '0') * 10 + departure[i].charAt(1) - '0';
			m = (departure[i].charAt(3) - '0') * 10 + departure[i].charAt(4) - '0';
			s = (departure[i].charAt(6) - '0') * 10 + departure[i].charAt(7) - '0';
			dt = h * 60 * 60 + m * 60 + s;

			if (at < 6 * 60 * 60)
				ovt += Math.min(dt, 6 * 60 * 60) - at;
			if (dt > 18 * 60 * 60)
				ovt += dt - Math.max(at, 18 * 60 * 60);
			rt += dt - at;
			// System.out.println(rt+" "+ovt+" "+at+" "+dt);
		}
		// rt = rt+rt+ovt ;
		// System.out.println("Remaining "+rt);

		// return (int)((rt * wage) / 60 / 60 / 2 ) ;
		return (int) ((((rt - ovt) + (1.5 * ovt)) * wage) / 3600);
	}

	public static void main(String[] args) throws ParseException {

		NewSalary s = new NewSalary();
		String[] arrival = { "00:11:13", "02:59:22", "04:42:01", "06:33:45", "08:22:30", "09:21:27", "11:15:50",
				"12:40:14", "13:55:51" };
		String[] departure = { "01:48:51", "03:22:59", "06:33:07", "06:45:47", "08:23:15", "09:34:07", "11:48:51",
				"12:47:18", "16:01:53" };
		System.out.println(s.howMuch(arrival, departure, 9998));

		arrival = new String[] { "01:05:47", "16:48:12" };
		departure = new String[] { "09:27:30", "21:17:59" };
		System.out.println(new NewSalary().howMuch(arrival, departure, 2000));

		arrival = new String[] { "08:00:00", "13:00:00", "19:27:32" };
		departure = new String[] { "12:00:00", "17:00:00", "20:48:10" };
		System.out.println(new NewSalary().howMuch(arrival, departure, 1000));

		arrival = new String[] { "00:00:00" };
		departure = new String[] { "23:59:59" };
		System.out.println(new NewSalary().howMuch(arrival, departure, 10000));

	}
}