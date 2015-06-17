package pl.boshi.cardgame.assets;

import java.util.Random;

import org.eclipse.swt.graphics.Image;

import pl.boshi.cardgame.Wargame;

public class Card {
 	private int Value, Colour;
 	
 	private Image img;
	public Card(int i, int j) {
		Colour= i;
		Value= j;
		img =new Image(null, Wargame.class.getResourceAsStream("/Karty/k"+Value+ " ("+Colour+").png"));
	}
	public int getValue() {
		return Value;
	}
	public int getColour() {
		return Colour;
	}
	public Image getImg() {
		return img;
	}


}
