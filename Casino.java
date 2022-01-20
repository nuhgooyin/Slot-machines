/**
 * Slot Machine Task
 * @author Dan Nguyen
 * @course ICS4UC
 * @date 2021-12-01
 **/

// Casino class
class Casino {
  // Attributes
  private String casinoName = "";
  private int numberOfPlayers = 0;
  private int totalRevenue = 0;

  /** 
  * Constructor
  */
  public Casino(String casinoName, int numberOfPlayers) {
    // Set data as attributes
    this.numberOfPlayers = numberOfPlayers;
    this.casinoName = casinoName;

    // Number of players must be greater than 0
    if (numberOfPlayers < 0) {
      // Set attribute
      this.numberOfPlayers = 1;
    }
  }

  // Default Constructor
  public Casino() {
    // Default attributes
    this("Default Casino", 1);
  }

  // Setting total revenue of casino
  public void addRevenue(int totalAddedRevenue) {
    this.totalRevenue = this.totalRevenue + totalAddedRevenue;
  }

  /**
  * Display total
  * @return String of revenue and players
  **/
  public String displayTotal() {
      return "Total Revenue of "+this.casinoName+" is "+this.totalRevenue+" quarters with "+this.numberOfPlayers+" player(s).";
  }
}