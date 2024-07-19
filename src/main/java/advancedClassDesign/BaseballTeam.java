package advancedClassDesign;

public class BaseballTeam {

	private String city, mascot;
	private int noOfPlayers;

	public BaseballTeam(String city, String mascot, int noOfPlayers) {
		if (city == null || mascot == null || noOfPlayers == 0)
			throw new IllegalArgumentException();

		this.city = city;
		this.mascot = mascot;
		this.noOfPlayers = noOfPlayers;

	}

	public boolean equals(Object obj) {
		if (!(obj instanceof BaseballTeam))
			return false;

		BaseballTeam other = (BaseballTeam) obj;
		return (this.city == other.city || this.mascot == other.mascot);
	}

	public int hashcode() {
		return noOfPlayers;
	}

	
	public static void main(String[] args) {
		

	}

}
