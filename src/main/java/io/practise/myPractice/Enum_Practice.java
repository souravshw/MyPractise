package io.practise.myPractice;

enum Candidate {
	Ravi, Sourav, Somraj, Khalisi, JonSnow
};

public class Enum_Practice {
	enum animals {
		Dog, Tiger, Human, Elephant, Sourav, Ravi, Somraj, Khalisi, JonSnow
	}
	enum roll {
		Ravi(23), Sourav(17), Somraj(43), Khalisi(16), JonSnow(54);
		private int r;

		roll(int i) {
			this.r = i;
		}

		int getRoll() {
			return this.r;
		}
	}
	public static void main(String[] args) {
		Candidate can = Candidate.valueOf(args[0]);
		roll r = roll.valueOf(can.toString());
		animals an = animals.valueOf(can.toString());

		switch (can) {
		case Ravi:
			System.out.println(can.Ravi);
			System.out.println(r.getRoll());
			break;
		case Khalisi:
			System.out.println(can.Khalisi);
			System.out.println(r.getRoll());
			break;
		case Sourav:
			System.out.println(can.Sourav);
			System.out.println(r.getRoll());
			break;
		case JonSnow:
			System.out.println(can.JonSnow);
			System.out.println(r.getRoll());
			break;
		default:
			System.out.println("Winter is Coming");
		}

		switch (an) {
		case Sourav:
			System.out.println("Khalisi is beautiful");
			break;
		default:
			System.out.println("Summer is Coming");
		}
	}

}