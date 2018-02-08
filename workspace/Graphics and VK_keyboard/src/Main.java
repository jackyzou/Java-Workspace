import javax.swing.JFrame;


public class Main {


	public static void main(String[] args) {
		second s = new second();
		JFrame f = new JFrame();
		f.add(s);
		f.setVisible(true);
		f.setSize(500,650);
		f.setTitle("Graph");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}