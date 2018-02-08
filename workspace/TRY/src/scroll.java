import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
 
public class scroll extends JFrame {
 
	JTextArea txt = new JTextArea();
	JScrollPane scrolltxt = new JScrollPane(txt);
 
	public scroll() {
 
		setLayout(null);
 
		scrolltxt.setBounds(3, 3, 300, 200);
		add(scrolltxt);		
	}
 
 
	public static void main(String[] args) {
 
		scroll sta = new scroll();
		sta.setSize(313,233);
		sta.setTitle("Scrolling JTextArea with JScrollPane");
		sta.show();		
	}
 
}

