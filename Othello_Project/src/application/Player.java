package application;
/**
 * 
 */
public class Player
{
	private String playerName;
	private String password;

	/**
	 * Default constructor
	 */
	public Player(String name, String pass) {
		this.playerName = name;
		this.password = pass;
	}

	public boolean isPlayer(String name, String pass) {
		if (playerName == name && password == pass){
			return true;
		} else {
			return false;
		}
	}
	
	public String getName() {
		return playerName;
	}

	public String getPassword() {
		return password;
	}

}