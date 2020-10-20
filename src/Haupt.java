import java.awt.Dimension;

public class Haupt {

	final static String version = "1.1.0";
	final static Dimension windowSize = new Dimension(800, 500);
	
	public static void main(String[] args) {
		new GUI(version, windowSize);
	}

}
