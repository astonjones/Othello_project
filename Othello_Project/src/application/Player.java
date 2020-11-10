package application;
import java.io.*;

/**
 * Custom player object
 */
public class Player implements java.io.Serializable
{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String playerName;
	private String password;
	private int wins;
	private int losses;
	private boolean isAdmin;

	/**
	 * Construct a new player or load the existing player
	 */
	public Player(String name, String pass) throws PasswordException{

        // if player exists then load it
        if (isSavedPlayer(name)) {

            System.out.println("Existing player detected.");
            loadPlayer(name, pass);

        } else {
            System.out.println("New Player detected.");
            // the player file does not exist, so initialize and serialize the new player
            this.playerName = name;
            this.password = pass;
            this.wins = 0;
            this.losses = 0;
            this.isAdmin = false;
            this.savePlayer();
        }
    
    }
    

    /**
     * Is the player new or returning
     * args     name    the players name
     * returns  boolean true if the player data exists, false otherwise
     */
	public boolean isSavedPlayer(String name) {

        // check if file equal to name.ser exists
        File check = new File("data/" + name + ".ser");
        return check.exists();

	}

    /**
     * Load an existing player via derserialization
     * args     name    the players name
     * args     pass    the players password for verificaiton
     * throws   PasswordException
     */
    private void loadPlayer(String name, String pass) throws PasswordException {

        try {
            FileInputStream playerFile = new FileInputStream("data/" + name + ".ser");
            ObjectInputStream playerObj = new ObjectInputStream(playerFile);

            // create a temporary player to hold the loaded data
            Player temp = null;
            temp = (Player) playerObj.readObject();

			playerObj.close();
			playerFile.close();
			
            // load the old player only if the provided password is correct
            if (pass.equals(temp.getPassword())) {
                this.playerName = temp.getName();
                this.password = temp.getPassword();
                this.wins = temp.getWins();
                this.losses = temp.getLosses();
                this.isAdmin = temp.isAdmin();
			} else { // password was incorrect so throw a PasswordException
                throw new PasswordException("Incorrect Password");
            }
            
        } catch (IOException i){
            System.out.println("IOException");
        } catch (ClassNotFoundException c) {
            System.out.println("Player Class not found.");
        }

    }

    
    /**
     * Serialize a new player object
     */
	private void savePlayer() {
		try {
            String fileName = "data/" + this.getName() + ".ser";
			FileOutputStream fileOut = new FileOutputStream(fileName);
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(this);
			objectOut.close();
			fileOut.close();
			System.out.println("Player saved.");
		} catch (IOException execption) {
			execption.printStackTrace();
		}
    }
	
	public String getName() {
		return playerName;
	}

	public String getPassword() {
		return password;
	}

	public int getWins() {
		return wins;
	}

	public int getLosses() {
		return losses;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

}