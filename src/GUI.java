import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUI extends Frame implements MouseListener{
	
	private String _versionNumber;
	private DrawCanvas canvas;
	
	public GUI(String version, Dimension size){
		
		super();
		_versionNumber = version;
		canvas = new DrawCanvas();
		
		setSize(size);
		setTitle("KreisExtrene: v."+_versionNumber);
		add(canvas);
		
		addWindowListener(new WindowAdapter(){
		  public void windowClosing(WindowEvent we){
		    System.exit(0);
		  }
		});
		addMouseListener(this);
		
		setVisible(true);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("test");
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
