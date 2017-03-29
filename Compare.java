import java.io.*;
import java.util.Scanner;
import java.util.Random;

/**
 * Write a description of class Compare here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Compare
{
    Deck d = new Deck();
    Random rand = new Random();
    int ln = d.deckSize();
    int sum, x, a, h;
    public boolean playerBust, dealerBust = false;
    public boolean autoWin = false;
    public int pSum, dSum;
    
    /**
     * Constructor for objects of class Compare
     */
    public Compare()
    {
        //
    }
    
    public void compare(int c, int d) {
        pSum = c + d;
        if(pSum == 21) {
            System.out.println("21!");
            System.out.println("Your card values: " + pSum);
            newCard();
        }
        
        else if(pSum < 21) {
            System.out.println("Your card values: " + pSum);
            newCard();
        }
        
        else if(pSum > 21) {
            System.out.println("Over 21, you lose!");
            System.out.println("Your card values: " + pSum);
            playerBust = true;
            end();
        }
    }
    
    public void dealerCompare(int u, int i) {
        dSum = u + i;
        if(dSum == 21) {
            System.out.println("21!");
            System.out.println("Dealer card values: " + dSum);
            dealerEnd();
        }
        
        else if(dSum < 21) {
            System.out.println("Dealer card values: " + dSum);
            hitOrStay();
        }
        
        else if(dSum > 21) {
            System.out.println("Over 21!");
            System.out.println("Dealer card values: " + dSum);
            dealerBust = true;
            dealerEnd();
        }
    }
    
    public void finalCompare(int g, int k) {
        if(g > k) {
            System.out.println("Dealer wins!");
            Game.money -= Player.betAmount;
        }
        else if(k > g) {
            System.out.println("Player wins!");
            Game.money += Player.betAmount;
        }
        else {
            System.out.println("Draw!");
        }
    }
    
    public void newCard() {
        System.out.println("Would you like to hit? (Y/N)");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        if(choice.equals("Y")) {
            x = rand.nextInt(52);
            a = d.cards.get(x).getValue();
            System.out.println("Your new card is a " + d.cards.get(x));
            if (a == 1){
                System.out.println("Would you like your ace to be 1 or 11?");
                Scanner scn = new Scanner(System.in);
                a = scn.nextInt();
            }
            compare(pSum, a);
        }
        else {
            System.out.println();
            System.out.println("Final score: " + pSum);
            end();
        }
    }
    
    public void hitOrStay() {
        if(dSum <= 17) {
            x = rand.nextInt(52);
            h = d.cards.get(x).getValue();
            System.out.println("Dealer's new card is a " + d.cards.get(x));
            dealerCompare(dSum, h);
        }
        else {
            dealerEnd();
        }
    }
    
    public void end() {
        dSum = Dealer.dealerSum();
        System.out.println();
        System.out.println("Dealer's second card is a " + Dealer.dealerCard2());
        System.out.println("Dealer's total is " + dSum);
    }
    
    public void dealerEnd() {
        if (autoWin == true && playerBust == false){
            System.out.println("You got Blackjack");
            Game.money += 1.5 * Player.betAmount;
        }
        else if(playerBust == true && dealerBust == true) {
            System.out.println("It's a tie!");
        }
        else if(playerBust == true) {
            System.out.println("Dealer wins!");
            Game.money -= Player.betAmount;
        }
        else if(dealerBust == true) {
            System.out.println("Player wins!");
            Game.money += Player.betAmount;
        }
        else {
            finalCompare(dSum, pSum);
        }
        System.out.println("You now have $" + Game.money + ".");
        Player b = new Player();
    }
}