import java.util.Random;
import java.util.Scanner;


/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Dealer
{
    Deck d = new Deck();
    Random rand = new Random();
    int x, y, a, b, z;
    public static int betAmount;
    
    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
        readyCheck();
    }
    
    public void begin() {
        System.out.println();
        System.out.println("Welcome to BlackJack.");
    }
    
    public void readyCheck() {
        System.out.println("Would you like to be dealt a new hand?(Y/N)");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        if(choice.equals("Y")) {
            begin();
            deal();
            dealerDeal();
            compare(a, b);
            hitOrStay();
        }
    }
    
    public void deal() {
        System.out.println("You have $" + Game.money + " in the bank, how much would you like to bet?");
        Scanner scan = new Scanner(System.in);
        betAmount = scan.nextInt();
        bet();
        
        x = rand.nextInt(52);
        System.out.println("Your first card is a " + d.cards.get(x));
        a = d.cards.get(x).getValue();
        
        y = rand.nextInt(52);
        System.out.println("Your second card is a " + d.cards.get(y));
        b = d.cards.get(y).getValue();
        
        if (a == 1){
            System.out.println("Would you like your ace to be 1 or 11?");
            Scanner scn = new Scanner(System.in);
            a = scn.nextInt();
        }
        
        if (b == 1){
            System.out.println("Would you like your ace to be 1 or 11?");
            Scanner sccn = new Scanner(System.in);
            b = sccn.nextInt();
        }
        
        if (a + b == 21){
            autoWin = true;
            System.out.println("Blackjack!!!");
        }
    }
    
    public void bet() {
        if (betAmount == 123456789) {
            System.out.println("Cheat code! You get $123456789!");
            Game.money = 123456789;
            betAmount = 123456789;
        }
        else if (betAmount < 0){
            System.out.println("You can't bet negative.");
            System.out.println("You have $" + Game.money + " in the bank, how much would you like to bet?");
            Scanner scan = new Scanner(System.in);
            betAmount = scan.nextInt();
            bet();
        }
        else if (betAmount > Game.money) {
            System.out.println("You don't have that much money!");
            System.out.println("You have $" + Game.money + " in the bank, how much would you like to bet?");
            Scanner scan = new Scanner(System.in);
            betAmount = scan.nextInt();
            bet();
        }
    }
}
