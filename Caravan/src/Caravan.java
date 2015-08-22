/**
 * 
 * The caravan is the basic "slot" for the board. It can hold an "unlimited" amount of cards. 
 * 
 * @author Sarah
 *
 */
import java.util.*;
public class Caravan{
	/**
	 *  Auto generated
	 */
	private static final long serialVersionUID = 1L;
	
	ArrayList<Card> caravan = new ArrayList<Card>();
	String name;			//Name for the caravan
	int value;				//The value of the caravan (recalculated at the end of each turn)
	boolean ascending;		//true if ascending (cannot be descending)
	boolean descending;		//true if descending (cannot be ascending)
	int size;

	public Caravan(String name){
		this.name = name;
		value = 0;
		size = 0;
	}
	
	int total(){
		int tot = 0;
		for(Card card: caravan){
			if(card.face==false){
				tot += card.value;
			}
			else{
				//If the card is a king add the card directly below's value
				if(card.value == 13){
					tot += caravan.get(card.position-1).value;
				}
			}
		}
		return tot;
	}
	
	void add(Card card){
		caravan.add(card);
		card.position = size;
		size +=1;
		value = total();
	}
	
	void add(Card card, int place){
		caravan.add(place+1,card);
		card.position = place+1;
		size +=1;
		for(int i=(place+2); i < size; i++){
			caravan.get(i).position +=1;
		}
		value = total();
	}
	
	Card remove(int place){
		Card card = caravan.remove(place);
		size -=1;
		for(int i=place; i < size; i++){
			caravan.get(i).position -=1;
		}
		value = total();
		return card;
	}
	
	boolean isSellable(){
		if (value >= 21 && value <=26 ) return true;
		else return false;
	}
	
	public String toString(){
		String ret = name +": [";
		for(Card card : caravan){
			ret += card+", ";
		}
		return ret+ value +"]";
	}
	
	public static void main(String[] args){
		Caravan primm = new Caravan("Primm");
		Caravan newVegas = new Caravan("New Vegas");
		
		Card jok1 = new Card(0, null);
		Card jok2 = new Card(0, null);
		//Spades
		Card SA = new Card(1, "spades");
		Card S2 = new Card(2, "spades");
		Card S3 = new Card(3, "spades");
		Card S4 = new Card(4, "spades");
		Card S5 = new Card(5, "spades");
		Card S6 = new Card(6, "spades");
		Card S7 = new Card(7, "spades");
		Card S8 = new Card(8, "spades");
		Card S9 = new Card(9, "spades");
		Card S10 = new Card(10, "spades");
		Card SJ = new Card(11, "spades");
		Card SQ = new Card(12, "spades");
		Card SK = new Card(13, "spades");
		//Diamonds
		Card DA = new Card(1, "diamonds");
		Card D2 = new Card(2, "diamonds");
		Card D3 = new Card(3, "diamonds");
		Card D4 = new Card(4, "diamonds");
		Card D5 = new Card(5, "diamonds");
		Card D6 = new Card(6, "diamonds");
		Card D7 = new Card(7, "diamonds");
		Card D8 = new Card(8, "diamonds");
		Card D9 = new Card(9, "diamonds");
		Card D10 = new Card(10, "diamonds");
		Card DJ = new Card(11, "diamonds");
		Card DQ = new Card(12, "diamonds");
		Card DK = new Card(13, "diamonds");
		//Clubs
		Card CA = new Card(1, "clubs");
		Card C2 = new Card(2, "clubs");
		Card C3 = new Card(3, "clubs");
		Card C4 = new Card(4, "clubs");
		Card C5 = new Card(5, "clubs");
		Card C6 = new Card(6, "clubs");
		Card C7 = new Card(7, "clubs");
		Card C8 = new Card(8, "clubs");
		Card C9 = new Card(9, "clubs");
		Card C10 = new Card(10, "clubs");
		Card CJ = new Card(11, "clubs");
		Card CQ = new Card(12, "clubs");
		Card CK = new Card(13, "clubs");
		//Hearts
		Card HA = new Card (1, "hearts");
		Card H2 = new Card (2, "hearts");
		Card H3 = new Card (3, "hearts");
		Card H4 = new Card (4, "hearts");
		Card H5 = new Card (5, "hearts");
		Card H6 = new Card (6, "hearts");
		Card H7 = new Card (7, "hearts");
		Card H8 = new Card (8, "hearts");
		Card H9 = new Card (9, "hearts");
		Card H10 = new Card (10, "hearts");
		Card HJ = new Card (11, "hearts");
		Card HQ = new Card (12, "hearts");
		Card HK = new Card (13, "hearts");
		
		primm.add(C10);
		primm.add(H9);
		primm.add(C8);
		primm.remove(1);
		primm.add(HK,0);
		System.out.println(primm);
		System.out.println(primm.size);
	}
	
}
