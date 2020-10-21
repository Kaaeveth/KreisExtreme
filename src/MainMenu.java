import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;


public class MainMenu extends MenuBar {
	
	private Menu _menuColor;
	private Menu _menuMisc;
	private GUI _frame = null;
	
	public MainMenu(GUI win) {
		_frame = win;
		_menuColor = new Menu("Hintergrundfarbe");
		_menuMisc = new Menu("Misc");
		
		MenuItem radiusItem = new MenuItem("Kreisradius");
		radiusItem.addActionListener(new OnModalClick());
		_menuMisc.add(radiusItem);
		
		MenuItem farbe1= new MenuItem("Farbe: grün");
		MenuItem farbe2= new MenuItem("Farbe: dunkelgrau");
		MenuItem farbe3= new MenuItem("Farbe: orange");
		MenuItem farbe4= new MenuItem("Farbe: schwarz");
		farbe1.addActionListener(new ColourClick(Color.green));
		farbe2.addActionListener(new ColourClick(Color.darkGray));	
		farbe3.addActionListener(new ColourClick(Color.orange));	
		farbe4.addActionListener(new ColourClick(Color.black));	
		_menuColor.add(farbe2);
		_menuColor.add(farbe1);
		_menuColor.add(farbe3);
		_menuColor.add(farbe4);
		
		add(_menuColor);
		add(_menuMisc);
	}
	
	private class ColourClick implements ActionListener{
		private Color c;
		public ColourClick(Color c) {
			this.c = c;
		}
		
		//Wenn eine Farbe ausgewaehlt wird
		@Override
		public void actionPerformed(ActionEvent arg0) {
			_frame.getCanvas().setBackground(c);
		}
		
	}
	
	private class OnModalClick implements ActionListener{

		//Wenn das Radiusdialog geoeffnet wird / Neuer Radius angefordert wird
		@Override
		public void actionPerformed(ActionEvent e) {
			_frame.getCanvas().setRadius(_frame.getRadiusDialog().askRadius());
		}
		
	}
}
