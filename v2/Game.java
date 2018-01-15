import cs1.Keyboard;
abstract class Game {
    protected String name;
    protected double winnings;


    protected abstract void playOnce(Character player);
    protected abstract boolean outcome(Character player);
    
}
