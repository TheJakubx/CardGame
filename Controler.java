package pl.boshi.cardgame;

import org.eclipse.swt.events.SelectionEvent;

public class Controler {

	
	public static void resetGame(SelectionEvent e){
		Model.Cards.reset();
		Model.PlayerCards.clear();
		Model.OponentCards.clear();
		Model.CartsOnTable.clear();
		while (Model.Cards.CartCount() > 0) {
			Model.PlayerCards.add(Model.Cards.getCard());
			Model.OponentCards.add(Model.Cards.getCard());
		}
		Model.PlayerCard=null;
		Model.OponentCard=null;
		View.redraw();
	}
	public static void nextTurn(SelectionEvent e) {
		if (Model.PlayerCards.size() != 0 && Model.OponentCards.size() != 0) {
			
			Model.PlayerCard = Model.PlayerCards.remove(0);
			Model.OponentCard = Model.OponentCards.remove(0);
			
			
			if (Model.PlayerCard.getValue() > Model.OponentCard.getValue()) {
				Model.PlayerCards.addAll(Model.CartsOnTable);
				Model.PlayerCards.add(Model.PlayerCard);
				Model.PlayerCards.add(Model.OponentCard);
				System.out.println("Wygrales " + Model.PlayerCards.size() + " "+ Model.OponentCards.size());
				Model.CartsOnTable.clear();
				
			} else if (Model.PlayerCard.getValue() < Model.OponentCard.getValue()) {
				Model.OponentCards.addAll(Model.CartsOnTable);
				Model.OponentCards.add(Model.PlayerCard);
				Model.OponentCards.add(Model.OponentCard);
				System.out.println("Przegrales " + Model.PlayerCards.size() + " "+ Model.OponentCards.size());
				Model.CartsOnTable.clear();
				
			} else {
				Model.CartsOnTable.add(Model.PlayerCard);
				Model.CartsOnTable.add(Model.OponentCard);
				Model.CartsOnTable.add(Model.PlayerCards.remove(Model.PlayerCards.size() - 1));
				Model.CartsOnTable.add(Model.OponentCards.remove(Model.OponentCards.size() - 1));
				System.out.println("WOJNA");
			}

			if (Model.PlayerCards.size() == 0 && 0 == Model.OponentCards.size()) {
				System.out.println("REMIS");
			} else {
				if (Model.PlayerCards.size() == 0) {
					System.out.println("PRZEGRALES");
				}
				if (Model.OponentCards.size() == 0) {
					System.out.println("WYGRALES");
				}
			}
		}
		
	}

}
