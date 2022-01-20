// Importing Java utility package
import java.util.*;

/**
 * Slot Machine Task
 * @author Dan Nguyen
 * @course ICS4UC
 * @date 2021-12-01
 **/

// Machine class
class Machine {
  // Attributes
  private int payoutAmount = 0;
  private int timesPlayed = 0;
  private int payoutTime = 0;
  private int machineNumber = 0;

  /** 
  * Constructor
  */
  public Machine(int timesPlayed, int machineNumber) {
    // Set data as attributes
    this.timesPlayed = timesPlayed;
    this.machineNumber = machineNumber;
    
    // Times already played must be 0 or greater
    if (timesPlayed < 0) {
      // Set attribute
      this.timesPlayed = 0;
    }
  }

  // Default Constructor
  public Machine() {
    // Default attributes (taken from machine 1)
    this(35, 1);
  }

  /** 
  * Machine is played
  * @return integer sumValue
  */
  public int isPlayed() {
    
    // Declare sumValue variable
    int sumValue;

    // Add one increment to times played for machine
    this.timesPlayed++;

    // If times played is equal to payout time
    if (this.timesPlayed == this.payoutTime) {
      
      // Assign sumValue as payoutAmount minus the quarter that must be put in first
      sumValue = this.payoutAmount-1;
      
      // Reset machine times played
      this.timesPlayed = 0;
    }
    else {
      
      // Take one quarter
      sumValue = -1;
    }
    return sumValue;
  }

  /** 
  * Check for default machines listed in question and adjust attributes accordingly, randomize for machines that are not default
  */
  public void checkForDefaultMachines() {
    // Check for default machines 1, 2 or 3
    if (this.machineNumber == 1) {
      // Set default attributes for appropriate machine
      this.payoutAmount = 30;
      this.payoutTime = 35;
    }
    else if (this.machineNumber == 2) {
      // Set default attributes for appropriate machine
      this.payoutAmount = 60;
      this.payoutTime = 100;
    }
    else if (this.machineNumber == 3) {
      // Set default attributes for appropriate machine
      this.payoutAmount = 9;
      this.payoutTime = 10;
    }

    // Else create random values for payout amount and payout time
    else {
      // Creating rand object of Random class to access needed functions
      Random rand = new Random();
      
      // Use function to get a number between [1-100]
      int randPayoutAmt = rand.nextInt(100);

      // Add 1 to get appropriate range (starts 0-99)
      randPayoutAmt ++;

      // Use function to get a number between [1-100]
      int randPayoutTime = rand.nextInt(100);

      // Add 1 to get appropriate range (starts 0-99)
      randPayoutTime ++;

      // Set attribute as acquired random integer
      this.payoutAmount = randPayoutAmt;

      // Set attribute as acquired random integer
      this.payoutTime = randPayoutTime;
    }
  }
}