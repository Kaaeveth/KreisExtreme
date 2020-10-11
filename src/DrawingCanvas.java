import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;

public class DrawingCanvas extends Canvas implements MouseListener{
	
	private Shape[] _squares; //Alle Kreise auf dem Canvas (Buffer)
	private int _currentSquares;  //Anzahl aller momentanen Kreise
	
	public DrawingCanvas(int squares) {
		super();
		addMouseListener(this);
		_squares = new Shape[squares]; // circles ist die maximale Anzahl an Kreisen
		_currentSquares = 0;
		setBackground(Color.DARK_GRAY);
		
	}
	
	//Fuegt einen Kreis ein, x/y - Mauskoordinaten / r - Radius
	private void drawSquare(float x, float y, float r) {
		//Sind maximal viele Kreise im Buffer?
		if(_currentSquares == _squares.length) {  
			_squares = new Shape[_squares.length]; // Buffer reseten
			_currentSquares = 0;
		} else {
			_squares[_currentSquares++] = new Rectangle2D.Float(x, y, r, r); //Neuen Kreis im Buffer
		}
		repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics2D gd2 = (Graphics2D)g;
		gd2.setColor(Color.WHITE); //Kreisfarbe
		for(Shape cir : _squares) {
			if(cir != null)
				gd2.draw(cir);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2 && !e.isConsumed()) { //Doppelclick
		     e.consume();
		     drawSquare(e.getX(), e.getY(), 30.0f);
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
