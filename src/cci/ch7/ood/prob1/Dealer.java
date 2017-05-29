package cci.ch7.ood.prob1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * @author: chaudharimehul
 * @date:	May 28, 2017
 * Main Class.
 * Initialize Four player
 * Initialize Deck
 * Distribute Card
 * Calculate Winner
 */
public class Dealer {



	List<Card> cardDeck = new ArrayList<Card>();
	List<Player> player = new ArrayList<Player>();


	public List<Card> initializeFourCard(String name, int value, boolean isFree, String playerName){
		List<Card> fourCards = new ArrayList<Card>();

		Card card = new Card();
		card.setCardValues(name, value, CardType.CLUB, isFree, playerName);
		fourCards.add(card);

		card = new Card();
		card.setCardValues(name, value, CardType.DIMOND, isFree, playerName);
		fourCards.add(card);
		
		card = new Card();
		card.setCardValues(name, value, CardType.HEART, isFree, playerName);
		fourCards.add(card);
		
		card = new Card();
		card.setCardValues(name, value, CardType.SPADE, isFree, playerName);
		fourCards.add(card);
		
		return fourCards;
	}

	public Dealer(){

		List<Card> initialCardDeck = new ArrayList<Card>();
		for(int i = 1 ; i <= 10 ; i++){

			List<Card> fourCard = initializeFourCard(""+i, i, true, null);
			initialCardDeck.addAll(fourCard);
		}

		//initialize J
		List<Card> J = initializeFourCard(""+11, 11, true, null);
		initialCardDeck.addAll(J);

		//initialize Queen
		List<Card> queen = initializeFourCard("Queen", 12, true, null);
		initialCardDeck.addAll(queen);

		//Initialize King
		List<Card> king = initializeFourCard("king", 13, true, null);
		initialCardDeck.addAll(king);

		setCardDeck(initialCardDeck);
	}

	public List<Card> getCardDeck() {
		return cardDeck;
	}

	public void setCardDeck(List<Card> cardDeck) {
		this.cardDeck = cardDeck;
	}

	public void calculateWinner(){
		int maxCardValue = 0;
		Player winner = null;

		for(Player p: getPlayer()){

			int playerCardValue = 0 ;
			for(Card card : p.getPlayerCard()){
				playerCardValue += card.getValue();
			}
			
			if(playerCardValue > maxCardValue && playerCardValue<=21 ){
				maxCardValue = playerCardValue;
				winner = p;
			}
		}

		System.out.println(" Winner Player Name " + winner.getName() + " ---- ID " + winner.getID());
		System.out.println(" Max Card Print Value ");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		
		Dealer dealer = new Dealer();
		List<Card> cards = dealer.getCardDeck();
		List<Player> playerList = new ArrayList<Player>();

		Player p1 = new Player("P1","p1");
		Player p2 = new Player("P2","p2");
		Player p3 = new Player("P3","p3");
		Player p4 = new Player("P4","p4");

		for(int i = 0 ; i < 3 ; i++){

			int value = rand.nextInt(51);
			Card card = cards.get(value);
			while(!card.getFree()){
				value = rand.nextInt(51);
				card = cards.get(value);
			}

			//Allocate card to player p1
			card.setFree(false);
			card.setPlayerName(p1.getName());
			p1.addPlayerCard(card);

			//allocate card to player p2
			value = rand.nextInt(51);
			card = cards.get(value);
			while(!card.getFree()){
				value = rand.nextInt(51);
				card = cards.get(value);
			}
			card.setFree(false);
			card.setPlayerName(p2.getName());
			p2.addPlayerCard(card);

			//allocate card to player p3
			value = rand.nextInt(51);
			card = cards.get(value);
			while(!card.getFree()){
				value = rand.nextInt(51);
				card = cards.get(value);
			}
			card.setFree(false);
			card.setPlayerName(p3.getName());
			p3.addPlayerCard(card);

			//allocate card to player p4
			value = rand.nextInt(51);
			card = cards.get(value);
			while(!card.getFree()){
				value = rand.nextInt(51);
				card = cards.get(value);
			}
			card.setFree(false);
			card.setPlayerName(p4.getName());
			p4.addPlayerCard(card);
			
		}
		
		p1.printPlayerCard();
		p2.printPlayerCard();
		p3.printPlayerCard();
		p4.printPlayerCard();

		playerList.add(p1);
		playerList.add(p2);
		playerList.add(p3);
		playerList.add(p4);

		dealer.setPlayer(playerList);

		dealer.calculateWinner();
	}

	public List<Player> getPlayer() {
		return player;
	}

	public void setPlayer(List<Player> player) {
		this.player = player;
	}

}
