package pl.boshi.cardgame;



import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.PaintEvent;


public class Wargame {

	protected Shell shell;
	
	public static void main(String[] args) {
		Controler.resetGame(null);

		try {Wargame window = new Wargame();
		    window.open();
		} catch (Exception e) {e.printStackTrace();}
	}

	
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	private Button btnReset;
	private Button btnNewButton;
	protected void createContents() {
		shell = new Shell();
		shell.setMinimumSize(new Point(800, 600));
		shell.setSize(450, 300);
		shell.setText("Wojna");
		Canvas canvas;
		canvas = new Canvas(shell, SWT.NONE);
		canvas.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				View.Draw(e);
			}
		});
		canvas.setBounds(0, 0, 784, 562);

		btnNewButton = new Button(canvas, SWT.NONE);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
			}
		});
		btnNewButton.setBounds(0, 537, 94, 25);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Controler.nextTurn(e);
				View.redraw();
			}
		});
		btnNewButton.setText("Nastepny ruch");
		btnReset = new Button(canvas, SWT.NONE);
		btnReset.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Controler.resetGame(e);
			}
		});
		btnReset.setBounds(709, 537, 75, 25);
		btnReset.setText("Restart");
		
		View.setCanvas(canvas);

	}
}
