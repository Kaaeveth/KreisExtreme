import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUI extends Frame{
	
	private String _versionNumber;
	private DrawingCanvas _canvas;
	private RadiusDialog _rDialog;
	
	public GUI(String version, Dimension size){
		
		super();
		_versionNumber = version;
		_canvas = new DrawingCanvas(2); //Canvas mit maximal 2 Kreisen
		_rDialog = new RadiusDialog(this);
		
		setSize(size);
		setTitle("KreisExtreme v"+_versionNumber);
		add(_canvas);
		
		addWindowListener(new WindowAdapter(){
		  public void windowClosing(WindowEvent we){
		    System.exit(0);
		  }
		});
		
		setMenuBar(new MainMenu(this));
		setVisible(true);
	}	
	
	public DrawingCanvas getCanvas() {return _canvas;}
	public RadiusDialog getRadiusDialog() {return _rDialog;}
}
