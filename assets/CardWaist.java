package pl.boshi.cardgame.assets;

import java.util.Random;
import java.util.Vector;

public class CardWaist {
	
	private Vector<Card> Cards = new Vector<Card>();
	public void  reset(){
		for(int i = 1;i<=4;i++){
			for(int j = 2;j<=14;j++){
				Cards.add(new Card(i,j));
			}
		}
	}
	public Card getCard(){
		int Poz = Math.abs(new Random().nextInt(CartCount()));
		return Cards.remove(Poz);
	}
	public int CartCount(){
		return Cards.size();
	}
}
