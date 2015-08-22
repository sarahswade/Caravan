/**
 * 
 * The card is the basic playing tool of caravan. Like a normal playing card.
 * 
 * @author Sarah
 *
 */

import java.awt.*;
import java.util.*;
public class Card {
	int value;			//The value of the card (0-13)
	String suit;		//spades, hearts, clubs, diamonds
	boolean face; 		//Is it a face card?
	Color color;		//black or red
	int state;			//State of play: 0-unplayed 1-in play 2-discarded
	int position;		//Position in the caravan
	
	public Card(int value, String suit){
		this.value = value;
		this.suit = suit;
		face = isFace();
		color = getColor();
		state = 0;
	}
	
	boolean isFace(){
		if (value == 0 || value > 10) return true;
		else return false;
	}
	
	Color getColor(){
		if (suit == null) return Color.white;
		if (suit.equals("spades") || suit.equals("clubs")) return Color.black;
		else return Color.red;
	}
	
	void setState(int state){
		this.state = state;
	}
	
	public String toString(){
		if(value == 1) return "Ace of " + suit;
		if(face == false){
			return value + " of " + suit;
		}
		if(value == 0) return "Joker";
		if(value == 11) return "Jack of " + suit;
		if(value == 12) return "Queen of " + suit;
		if(value == 13) return "King of " + suit;
		else return "???";
	}

}
