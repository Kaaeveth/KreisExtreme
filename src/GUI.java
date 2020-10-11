import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUI extends Frame{
	
	private String _versionNumber;
	private DrawingCanvas _canvas;
	
	public GUI(String version, Dimension size){
		
		super();
		_versionNumber = version;
		_canvas = new DrawingCanvas(2); //Canvas mit maximal 2 Kreisen
		
		setSize(size);
		setTitle("KreisExtrene v"+_versionNumber+" QuadratEdition");
		add(_canvas);
		
		addWindowListener(new WindowAdapter(){
		  public void windowClosing(WindowEvent we){
		    System.exit(0);
		  }
		});
		
		setVisible(true);
	}	
}
