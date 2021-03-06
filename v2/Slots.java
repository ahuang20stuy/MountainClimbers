import cs1.Keyboard;
public class Slots extends Game {
    private final String[] combinations  = { 
	"lemon", "lemon", "lemon", 
	"seven", "seven", "seven", 
	"orange", "orange", "orange", 
	"tangerine", "tangerine", "tangerine", 
	"watermelon", "watermelon", "watermelon",
	"plum", "plum", "plum",
	"star", "star", "star",
	"banana", "banana", "banana"
    };
  
    private String[] _combinations;

    public Slots() {
	name = "Slots";
	_combinations = new String[combinations.length ];
	for( int i=0; i<combinations.length; i++ ) {
	    _combinations[i] = combinations[i];
	}
    }

    public String toString() {
	return _combinations[0] + "\t" +
	    _combinations[1] + "\t" +
	    _combinations[2];
    }

    private void swap( int i, int j ) {
	String foo = _combinations[i];
	_combinations[i] = _combinations[j];
	_combinations[j] = foo;
    }

    public void spinOnce() {
	for( int i = 0; i < _combinations.length; i++ )
	    swap( i, (int)( Math.random() * _combinations.length) );
    }



    public double whatWin() {
	if (_combinations[0].equals("seven")) {
	    winnings = 1000.0;
	    return winnings;
	}
	else {
	    winnings = 100.0;
	    return winnings;
	}		
    }

    public String welcome() {
	String retStr = "Welcome to Slots!\n";
	retStr += "Spinning the slots machine costs 20 dollars.\n";
	retStr += "Getting three sevens result in a 1000 dollar jackpot or three of the same fruit results in a 100 dollar jackpot\n";
	return retStr;
    }
	    
    protected void playOnce(Character player) {
	System.out.println(welcome());
	System.out.println("Continue? (yes or no)");
	String cont = Keyboard.readString();
	if (cont.equals("yes")) {
	    System.out.println("Spinning...");
	    System.out.print("Results: ");
	    spinOnce();
	    System.out.println(this);
	    outcome(player);
	}
    }

    protected boolean outcome(Character player) {
	boolean retStr = false;
	if ( _combinations[0].equals(_combinations[1]) && _combinations[0].equals(_combinations[2])) {
	    System.out.println("Congratulations! you won $" + whatWin());
	    player.addBal(winnings);
	    retStr = true;
	}
	else {
	    System.out.println("Better luck next time!");
	}
	return retStr;
    }
}
	
		
			
		
	    
	    

	
		

