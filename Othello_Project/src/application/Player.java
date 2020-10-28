package application;
/**
 * 
 */
public class Player
{
	private String playerName;
	private int password;

	/**
	 * Default constructor
	 */
	public Player(String name, int pass) {
		this.playerName = name;
		this.password = pass;
	}

	public boolean isPlayer(String name, int pass) {
		if (playerName == name && password == pass){
			return true;
		} else {
			return false;
		}
	}
	
	public String getName() {
		return playerName;
	}

	public int getPassword() {
		return password;
	}

}