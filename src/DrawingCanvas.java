import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RectangularShape;

public class DrawingCanvas extends Canvas implements MouseListener{
	
	private Shape[] _circles; //Alle Kreise auf dem Canvas (Buffer)
	private int _currentCircles;  //Anzahl aller momentanen Kreise
	private float _radius = 30.0f;
	
	public DrawingCanvas(int circles) {
		super();
		addMouseListener(this);
		_circles = new Shape[circles]; // circles ist die maximale Anzahl an Kreisen
		_currentCircles = 0;
		setBackground(Color.DARK_GRAY);
		
	}
	
	//Fuegt einen Kreis ein, x/y - Mauskoordinaten / r - Radius
	private void drawCircle(float x, float y, float r) {
		//Sind maximal viele Kreise im Buffer?
		if(_currentCircles == _circles.length) {  
			_circles = new Shape[_circles.length]; // Buffer reseten
			_currentCircles = 0;
		} else {
			_circles[_currentCircles++] = new Ellipse2D.Float(x, y, r, r); //Neuen Kreis im Buffer
		}
		repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics2D gd2 = (Graphics2D)g;
		gd2.setColor(Color.WHITE); //Kreisfarbe
		for(Shape cir : _circles) {
			if(cir != null) {
				gd2.draw(cir);
				
				//Koordinaten an den Kreisen zeichen
				RectangularShape shape = (RectangularShape)cir;
				gd2.drawString("(X: "+shape.getX()+", Y: "+shape.getY()+")", (float)shape.getX(), (float)shape.getY());
				
				if(_circles[1] != null) {
					gd2.drawLine((int)((RectangularShape)_circles[0]).getCenterX(),
							(int)((RectangularShape)_circles[0]).getCenterY(),
							(int)((RectangularShape)_circles[1]).getCenterX(),
							(int)((RectangularShape)_circles[1]).getCenterY());
				

					// Berechne Distanz aus den beiden Kreiskoordinaten
					double distance = Math.sqrt(
							Math.pow((float)((RectangularShape)_circles[1]).getCenterX()
								- (float)((RectangularShape)_circles[0]).getCenterX(), 2) +
							Math.pow((float)((RectangularShape)_circles[1]).getCenterY() -
									(float)((RectangularShape)_circles[0]).getCenterY(), 2));
					// Gibt die Distanz aus
					gd2.drawString("DISTANCE: " + distance, 0, 15);
				}
			}
		}
	}
	
	public float getRadius() {return _radius;}
	public void setRadius(float r) {_radius = r;} 
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2 && !e.isConsumed()) { //Doppelclick
		     e.consume();
		     drawCircle(e.getX(), e.getY(), _radius);
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
