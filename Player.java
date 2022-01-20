/**
 * Slot Machine Task
 * @author Dan Nguyen
 * @course ICS4UC
 * @date 2021-12-01
 **/

// Player class
class Player {
  // Attributes
  private int numberOfQuarters = 0;
  private int numberOfTimesPlayed = 0;
  private String playerName = "";

  /** 
  * Constructor
  */
  public Player(int numberOfQuarters, String playerName) {
    // Set data as attributes
    this.numberOfQuarters = numberOfQuarters;
    this.numberOfTimesPlayed = 0;
    this.playerName = playerName;
  }

  // Default Constructor
  public Player() {
    // Default attributes (taken from question)
    this(48, "Martha");
  }

  /**
  * Check if broke
  * @return boolean brokeStatus 
  **/
  public boolean checkBroke() {
    boolean brokeStatus = false;

    if (this.numberOfQuarters == 0) {
      brokeStatus = true;
    }
    return brokeStatus;
  }

  // Add to number of times played
  public void addTimePlayed() {
    this.numberOfTimesPlayed++;
  }

  /**
  * Return number of times played as string
  * @return String
  **/
  public String timesBeforeBroke(int playerNumber) {
    return this.playerName+", who is player "+playerNumber+", plays "+numberOfTimesPlayed+" times before going broke.";
  }

  // Getter for player name attribute
  public String getPlayerName() {
    return this.playerName;
  }

  // Calculating and setting number of quarters
  public void setNumberOfQuarters(int sumValue) {
    this.numberOfQuarters = this.numberOfQuarters + sumValue;
  }
}