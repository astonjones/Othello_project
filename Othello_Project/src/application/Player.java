package application;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;

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
	private static String path = Paths.get("").toAbsolutePath().toString().concat("\\data\\");

	/**
	 * Construct a new player or load the existing player
	 */
	public Player (String name, String pass, boolean isAdmin) throws PasswordException{

        // if player exists then load it
		if (isAdmin) {
			if (!(name.equals("admin") & pass.equals("admin"))) {
				throw new PasswordException("Incorrect Admin Password");
			}
		} else if (isSavedPlayer(name)) {

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
	* Provide an array list of all players and their win/loss record
	* @return	ArrayList<String> a list of player data
	*/
   public static ArrayList<String> getPlayerRecords(){
	   ArrayList<String> records = new ArrayList<>();
	   File dir = new File(path);
	   File[] fileList = dir.listFiles();

	   // for every file in data/, retreive each playername, wins, losses, write to arraylist
	   for (int i = 0; i < fileList.length; i++) {
		   if (fileList[i].isFile()) {
			   try {
				   FileInputStream playerFile = new FileInputStream(fileList[i]);
				   ObjectInputStream playerObj = new ObjectInputStream(playerFile);
	   
				   // create a temporary player to hold the loaded data
				   Player temp = (Player) playerObj.readObject();
				   String tempRecord = temp.getName() + ": " + temp.getWins() + ", " + temp.getLosses();
				   System.out.println(tempRecord);
				   records.add(tempRecord);
	   
				   playerObj.close();
				   playerFile.close();
				   
				   
			   } catch (IOException e){
				   e.printStackTrace();
			   } catch (ClassNotFoundException c) {
				   c.printStackTrace();
			   }
		   }
	   }
	   
	   return records;
   }

    /**
     * Is the player new or returning
     * args     name    the players name
     * @return  boolean true if the player data exists, false otherwise
     */
	public boolean isSavedPlayer (String name) {

        // check if file equal to name.ser exists
        File check = new File(path + name + ".ser");
        return check.exists();

	}

    /**
     * Load an existing player via derserialization
     * args     name    the players name
     * args     pass    the players password for verificaiton
     * throws   PasswordException
     */
    private void loadPlayer (String name, String pass) throws PasswordException {

        try {
            FileInputStream playerFile = new FileInputStream(path + name + ".ser");
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
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }

    }

    
    /**
     * Serialize the Player object
     */
	private void savePlayer() {
		try {
            String fileName = path + this.getName() + ".ser";
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
	
	/**
     * Add 1 win or 1 lose to a player's record
     * args     boolean    true if player won, false otherwise
     */
	public void updateRecord(boolean didWin) {
        if (didWin) {
            this.wins++;
        } else {
            this.losses++;
        }
        savePlayer();
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