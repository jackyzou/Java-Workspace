import javax.swing.*;
public class CNButton extends JButton {
 
	private int value;
	private int x;
	private int y;
	
	CNButton(int xval, int yval) {
		x = xval;
		y = yval;
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int val) {
		value = val;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}