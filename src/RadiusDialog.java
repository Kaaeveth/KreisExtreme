import java.awt.Dialog;
import java.awt.TextField;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RadiusDialog extends Dialog {
	
	private TextField _radiusInput;
	
	public RadiusDialog(Window owner) {
		super(owner, "Radius: ", ModalityType.APPLICATION_MODAL);
		setModal(true);
		setResizable(false);
		setSize(350, 100);
		
		_radiusInput = new TextField(1);
		_radiusInput.setText(String.valueOf(((GUI) owner).getCanvas().getRadius())); //Anfangsradius im Dialog setzen
		
		addWindowListener(new WindowAdapter(){
		  public void windowClosing(WindowEvent we){
		    setVisible(false);
		  }
		});
		
		
		add(_radiusInput);
	}
	
	//Zeigt das Dialog an
	public float askRadius() {
		setVisible(true);
		return Float.parseFloat(_radiusInput.getText());
	}

}
