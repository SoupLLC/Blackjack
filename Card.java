/**
 * Write a description of class Card here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Card
{
    String cardName;
    String cardSuit;
    int cardValue;
    public Card (String Name, String Suit, int value) {
       cardName = Name;
       cardValue = value;
       cardSuit = Suit;
    }
    
    public int getValue() {
        return cardValue;
    }
    
    public String getName() {
        return cardName;
    }
    
    public String getSuit() {
        return cardName;
    }
    
    public void setValue(int v) {
        cardValue = v;
    }
    
    public void setName(String n) {
        cardName = n;
    }
    
    public void setSuit(String s) {
        cardName = s;
    }
    
    public String toString() {
        return this.cardName + " of " + this.cardSuit;

    }
}

