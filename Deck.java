import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Deck 
{
    public List<Card> cards;
    int size = 0;

    
    public Deck() {
        makeDeck();
    }
    
    public List<Card> makeDeck() {
        String tempName = "";
        String tempSuit = "";
        int tempVal = 0;
        //Random rand = new Random();
        //int[][] arr = new int[3][3];
        cards = new ArrayList<Card>();
        int nums = 1;
        int x;
        for (int i = 0; i < 52; i++) {
            //int  x = rand.nextInt(52) + 1;
            x = nums;
            if (x > 0 && x < 14) {
                tempSuit = "Spades";
            }
            if (x > 13 && x < 27) {
                tempSuit = "Clubs";
            }
            if (x > 26 && x < 40) {
                tempSuit = "Hearts";
            }
            if (x > 39 && x < 53) {
                tempSuit = "Diamonds";
            }
            
            while (x > 13) {
                x -= 13;
            }
            if (x > 9 || x == 1) {
                tempVal = 10;
                if (x == 1) {
                    tempName = "Ace";
                    //x = 11;
                }
                if (x == 10) {
                    tempName = Integer.toString(10);
                }
                if (x == 11) {
                    tempName = "Jack";
                }
                if (x == 12) {
                    tempName = "Queen";
                }
                if (x == 13) {
                    tempName = "King";
                }
            }
            else {
                tempVal = x;
                tempName = Integer.toString(x);
            }
            nums++;
            Card temp = new Card(tempName, tempSuit, tempVal);
            cards.add(i, temp);
        }
        //System.out.println(cards);
        //System.out.println(cards.get(4));
        return cards;
    }
    
    public int deckSize() {
        int size = cards.size();
        return size;
    }
    
    public void printDeck() {
        System.out.println("The deck contains: ");
        for (Card c: cards) {
            System.out.println(c);
        }
        System.out.println();
    }   
}