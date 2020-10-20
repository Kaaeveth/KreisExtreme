import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;


public class MainMenu extends MenuBar {
	
	private Menu _menu;
	private DrawingCanvas _canvas = null;
	public MainMenu(DrawingCanvas canvas) {
		_canvas = canvas;
		_menu = new Menu("Hintergrundfarbe");
		MenuItem farbe1= new MenuItem("Farbe: grün");
		MenuItem farbe2= new MenuItem("Farbe: dunkelgrau");
		MenuItem farbe3= new MenuItem("Farbe: orange");
		MenuItem farbe4= new MenuItem("Farbe: schwarz");
		farbe1.addActionListener(new ColourClick(Color.green));
		farbe2.addActionListener(new ColourClick(Color.darkGray));	
		farbe3.addActionListener(new ColourClick(Color.orange));	
		farbe4.addActionListener(new ColourClick(Color.black));	
		_menu.add(farbe2);
		_menu.add(farbe1);
		_menu.add(farbe3);
		_menu.add(farbe4);
		add(_menu);
	}
	
	private class ColourClick implements ActionListener{
		private Color c;
		public ColourClick(Color c) {
			this.c = c;
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub			
				_canvas.setBackground(c);					
		}
		
	}
}
