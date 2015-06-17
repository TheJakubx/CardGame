package pl.boshi.cardgame;

import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.widgets.Canvas;

public class View {
	private static Canvas canvas;
	public static void setCanvas(Canvas c){
		canvas = c;
	}
	public static void Draw(PaintEvent e){
		if(Model.PlayerCard!=null)e.gc.drawImage(Model.PlayerCard.getImg(), 400-48/2, 350-96/2);
		if(Model.OponentCard!=null)e.gc.drawImage(Model.OponentCard.getImg(), 400-48/2, 250-96/2);
		
		for(int i = 0;i<Model.CartsOnTable.size();i++){
			e.gc.drawImage(Model.CartsOnTable.get(i).getImg(), (int) 470+i*10, 240);
		}
		
		for(int i = 0;i<Model.PlayerCards.size();i++){
			e.gc.drawImage(Model.PlayerCards.get(Model.PlayerCards.size()-i-1).getImg(), (int) (500+(0.2f*i))-48/2, 360-96/2+50);
		}
		e.gc.drawText(Model.PlayerCards.size()+"", 500, 460,20);
		for(int i = 0;i<Model.OponentCards.size();i++){
			e.gc.drawImage(Model.OponentCards.get(Model.OponentCards.size()-i-1).getImg(), (int) (300-(0.2f*i))-48/2, 240-96/2-50);
		}
		e.gc.drawText(Model.OponentCards.size()+"", 300, 240,20);
		
		if(Model.CartsOnTable.size()>0)e.gc.drawText("Wojna!", 0, 0,50);
		if (Model.PlayerCards.size() == 0)e.gc.drawText("PRZEGRALES", 0, 0,50);
		if (Model.OponentCards.size() == 0)e.gc.drawText("WYGRALES", 0, 0,50);
		
	}
	public static void redraw() {
		if(canvas!=null)canvas.redraw();
		
	}
}
