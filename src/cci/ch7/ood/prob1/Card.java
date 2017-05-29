package cci.ch7.ood.prob1;

/**
 * @author: chaudharimehul
 * @date:	May 28, 2017
 * Card class for deck. Card will have 52 cards.
 */
enum CardType{
	DIMOND, HEART, SPADE, CLUB
}

public class Card {
	String name;
	int value;
	CardType type;
	boolean isFree;
	String playerName;
	
	public void setCardValues(String name, int value, CardType type, boolean isFree, String playerName){
		setName(name);
		setValue(value);
		setType(type);
		setFree(isFree);
		setPlayerName(playerName);
	}
	
	public void setPlayerName(String playerName){
		this.playerName = playerName;
	}
	
	public void setFree(boolean isFree){
		this.isFree = isFree;
	}
	
	public boolean getFree(){
		return this.isFree;
	}
	
	public String getPlayerName(){
		return this.playerName;
	}
	
	public CardType getType(){
		return this.type;
	}
	
	public int getValue(){
		return this.value;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setType(CardType type){
		this.type = type;
	}
	
	public void setValue(int value){
		this.value = value;
	}

	@Override
	public String toString() {
		return "Card [name=" + name + ", value=" + value + ", type=" + type + ", isFree=" + isFree + ", playerName="
				+ playerName + "]";
	}
}
