// Importing Java utility package
import java.util.*;

/**
 * Slot Machine Task
 * @author Dan Nguyen
 * @course ICS4UC
 * @date 2021-12-01
 **/

// Main program/method
public class Main {
  public static void main(String[] args) {
    
    // Allows to read user input
    Scanner sc = new Scanner(System.in);

    // Prompting for user input for casino name 
    System.out.println("What is the casino name? ");
		String userCasinoName = sc.nextLine();

    // Prompting for user input for number of players
    System.out.println("How many players are in this casino? ");
		int userCasinoPlayers = sc.nextInt();

    // Create casino object with given parameters
    Casino usersCasino = new Casino(userCasinoName , userCasinoPlayers);

    // Loop through allow players
    for (int i = 1; i <= userCasinoPlayers; i++) {

      // Prompting for user input for player name
      System.out.println("What is player "+i+"'s"+" name?");
      String userName = sc.next();
      
      // Prompting for user input for how many quarters
      System.out.println("How many quarters does "+userName+" have in their jar?");
      int userQuarters = sc.nextInt();

      // Add users quarters to casino total revenue value
      usersCasino.addRevenue(userQuarters);

      // Prompting for user input for number of machines player plays
      System.out.println("How many machines is player "+i+" going to play?");
      int userMachines = sc.nextInt();
      
      // Allow player with specific user inputted parameters
      Player allowedPlayer = new Player(userQuarters, userName);

      // Create array of type class Machine abstract data type
      Machine machines[] = new Machine[userMachines];

      // Loop through given number of machines and create instances of them
      for (int j = 0; j < userMachines; j++) {
        // Prompting for user input for number of machines player plays
        System.out.println("How many times has machine "+(j+1)+" been played since the last payout?");
        int userTimesPlayed = sc.nextInt();

        // Create instance of Machine class given user inputted parameters
        Machine usedMachine = new Machine(userTimesPlayed, (j+1));

        // Check for default 1,2,3 machines
        usedMachine.checkForDefaultMachines();

        // Add to array
        machines[j] = usedMachine;
      }

      // While the player is not broke keep going
      while (allowedPlayer.checkBroke() == false) {
        
        // Loop through each element within machines list
        for (int k = 0; k < machines.length && allowedPlayer.checkBroke() == false; k++) {

          // Play the machine
          int calcSumValue = machines[k].isPlayed();

          // Calculate new number of quarters and set attribute accordingly
          allowedPlayer.setNumberOfQuarters(calcSumValue);

          // Add one more to times played
          allowedPlayer.addTimePlayed();          
        }
      }

      // Display how many times given player will play before going broke
      System.out.println(allowedPlayer.timesBeforeBroke(i));
    }

    // Display total casino revenue and number of players
    System.out.println(usersCasino.displayTotal());
  }
}