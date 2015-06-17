package pl.boshi.cardgame;

import java.util.Vector;

import org.eclipse.swt.widgets.Canvas;

import pl.boshi.cardgame.assets.Card;
import pl.boshi.cardgame.assets.CardWaist;

public class Model {
	static Vector<Card> CartsOnTable = new Vector<Card>();
	static Vector<Card> PlayerCards = new Vector<Card>();
	static Vector<Card> OponentCards = new Vector<Card>();
	static CardWaist Cards = new CardWaist();
	static Card PlayerCard;
	static Card OponentCard;
}
