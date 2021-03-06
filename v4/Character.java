import java.util.ArrayList;
import java.util.Arrays;
import cs1.Keyboard;

public class Character {
    //instance vars
    private String username;
    private String password;
    private double balance;
    private double bet;
    private double minBet = 20.0;
    public ArrayList<String> shop;
    public ArrayList<String> inventory;
    public ArrayList<Double> shopPrice;

    
    
    public Character(){
	username = "guest";
	password = "password";
	balance = 1000;
	shop = new ArrayList<String>(Arrays.asList("ring", "table", "box", "car")); 
	inventory = new ArrayList<String>();
	shopPrice = new ArrayList<Double>(Arrays.asList(100.0, 300.0, 400.0, 23.0));
    }

    public Character(String newName, String newPassword){
	this();
	username = newName;              
	password = newPassword;
    }

    public double getBet() {
    	return bet;
	}
	
    public void remBal(double lost) {
	balance -= lost;
    }
	
    public void addBal(double winnings) {
	balance += winnings;
    }
	
    public double getBal() {
	return balance;
    }
    
    public void choosePlace(){
	System.out.println("Where would you like to go? (casino, bar, shop)");
	String location = Keyboard.readString();
	if (location.equals("casino")){
	    chooseGame();
	} else if(location.equals("bar")){
	    chooseDrink();
	} else if(location.equals("shop")){
		shop();
	}
    }

	public void shop() {
	}



    public void chooseGame() {
	System.out.println("Which game would you like to play? (slots, roulette, blackjack)");
	String game = Keyboard.readString();
	if(game.equals("slots")){
		Game g = new Slots();
		g.playOnce(this);
		afterGame(g);	
	}else if(game.equals("roulette")){
		Game g = new Roulette();
		g.playOnce(this);
		afterGame(g);		
	}else if(game.equals("blackjack")){
		Game g = new Blackjack();
		g.playOnce(this);
		afterGame(g);		
	}
	}
	
	public void afterGame(Game g) {
	System.out.println("\n");
	System.out.println("What would you like to do? (choose a number)");
	String str = ("1. Play again.\n");
	str += ("2. Play different game.\n");
	str += ("3. Go somewhere else.\n");
	str += ("4. Quit.\n");
	System.out.println(str);
	int x = Keyboard.readInt();
	if (x == 1) {
		g.playOnce(this);
		afterGame(g);
	} else if (x == 2) {
		chooseGame();
	} else if (x == 3) {
		choosePlace();
	} else if (x == 4) {
		quitGame();
	}
	}
    
	public void chooseDrink(){

    }

	public void quitGame() {
	System.out.println("Leaving game...");
	System.out.println("Thanks for playing!");		
    }


    public boolean toBuy() {
	int x = 2;
	if (balance > shopPrice.get(x)) {
	    String y = shop.remove(x);
	    balance -= shopPrice.remove(x);
	    inventory.add(y);
	    System.out.println(y + " added to your inventory.");
	    return true;
	}
	else {
	    System.out.println("Insufficient balance");
	    return false;
	}
    }

    public void placeBet(){
	System.out.println("Your current balance is" + getBal());
	System.out.println("What would you like to bet?");
	double wager = Keyboard.readDouble();
	if (minBet >= balance) {
	    bet = balance;
	    balance = 0;
	    System.out.println("Your bet was less than the minimum bet.");
	    System.out.println("Your bet was set to $" + bet);
	} else if (minBet > wager) {
	    bet = minBet;
	    balance -= bet;
	    System.out.println("Your bet was less than the minimum bet.");
	    System.out.println("Your bet was set to $" + bet);  
	} else if (wager <= balance) {
	    bet = wager;
	    balance -= bet;
	    System.out.println("You bet $" + bet);
	} else {
	    System.out.println("Your bet was higher than your balance!");
	    placeBet();
	}
    }
	
	
}
