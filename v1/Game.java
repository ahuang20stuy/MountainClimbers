abstract class Game {
    protected double bet;
    protected boolean isWin;
    protected String name;
    protected double minBet = 20;
    protected double winnings;
    protected double wager;

    /*protected abstract void placeBet(){
	wager = 23.0; //user input wager
	if (minBet >= Character.getBalance()) {
	    bet = Character.getBalance();
	    System.out.println("Your bet was less than the minimum bet.");
	    System.out.println("Your bet was set to $" + bet);
	} else if (wager <= Character.getBalance()) {
	    bet = wager;
	    System.out.println("You bet $" + bet);
	} else {
	    System.out.println("Your bet was higher than your balance!");
	    placeBet();
	}
    }
    */
    protected abstract void playOnce();
    protected abstract boolean outcome();
    
}
