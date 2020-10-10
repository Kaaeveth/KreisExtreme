import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;

public class DrawingCanvas extends Canvas implements MouseListener{
	
	private Ellipse2D[] _circles; //Alle Kreise auf dem Canvas (Buffer)
	private int _currentCircles;  //Anzahl aller momentanen Kreise
	
	public DrawingCanvas(int circles) {
		super();
		addMouseListener(this);
		_circles = new Ellipse2D[circles]; // circle ist die maximale Anzahl an Kreisen
		_currentCircles = 0;
		setBackground(Color.DARK_GRAY);
		
	}
	
	//Fuegt einen Kreis ein, x/y - Mauskoordinaten / r - Radius
	private void drawCircle(float x, float y, float r) {//Sind maximal viele Kreise im Buffer?
		//Sind maximal viele Kreise im Buffer?
		if(_currentCircles == _circles.length) {  
			_circles = new Ellipse2D[_circles.length]; // Buffer reseten
			_currentCircles = 0;
		} else {
			_circles[_currentCircles++] = new Ellipse2D.Float(x,y,r,r); //Neuen Kreis im Buffer
		}
		repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics2D gd2 = (Graphics2D)g;
		gd2.setColor(Color.WHITE); //Kreisfarbe
		for(Ellipse2D cir : _circles) {
			if(cir != null)
				gd2.draw(cir);		
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		drawCircle(e.getX(), e.getY(), 30.0f);
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
