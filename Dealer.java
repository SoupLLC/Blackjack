import java.util.Random;
import java.util.Scanner;


/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dealer extends Compare
{
    Deck d = new Deck();
    Random rand = new Random();
    public int x, y, a, b, h; 
    public static Card c;
    public static int dSum;
    
    //17 or greater, hit ; 16 or less stay
    /**
     * Constructor for objects of class Player
     */
    public Dealer()
    {
        //
    }
    
    public void dealerDeal() {
        x = rand.nextInt(52);
        a = d.cards.get(x).getValue();
        System.out.println("Dealer's shown card is a " + d.cards.get(x));
        
        y = rand.nextInt(52);
        c = d.cards.get(y);
        b = d.cards.get(y).getValue();
        
        dSum = a + b;
        dealerSum();
    }
    
    public static int dealerSum() {
        return dSum;
    }
    
    public static Card dealerCard2() {
        return c;
    }
}
