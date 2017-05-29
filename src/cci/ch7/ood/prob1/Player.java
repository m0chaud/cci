package cci.ch7.ood.prob1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: chaudharimehul
 * @date:	May 28, 2017
 * 
 */
public class Player {
	String Name;
	String iD;
	List<Card> playerCard;
	
	public Player(){
		
	}
	
	public Player(String name, String iD){
		setName(name);
		setID(iD);
		setPlayerCard(new ArrayList<Card>());
	}
	
	public void addPlayerCard(Card card){
		this.playerCard.add(card);
	}
	public void printPlayerCard(){
		System.out.println(" ------ ");
		System.out.println(" Player Name " + getName());
		
		for(Card card : getPlayerCard()){
			System.out.println("Card Name: " + card.getName() + " ---- Card Value:" + card.getValue());
		}
		
		System.out.println(" ------ ");
	}
	
	public String getName() {
		return Name;
	}
	
	public void setName(String name) {
		Name = name;
	}
	
	public String getID() {
		return iD;
	}
	
	public void setID(String iD) {
		this.iD = iD;
	}
	
	public List<Card> getPlayerCard() {
		return playerCard;
	}
	
	public void setPlayerCard(List<Card> playerCard) {
		this.playerCard = playerCard;
	}
}
