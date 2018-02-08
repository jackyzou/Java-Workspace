import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class TextArea extends JFrame {

private JTextArea text;

public TextArea()
{int x=1;

	while(x<2)
	{
		createUserInterface();
	}
	
}


private void createUserInterface()
{
	Container contentPane =getContentPane();
	contentPane.setLayout(null);//layout itself, nothing else
	
	text =new JTextArea();
	text.setEditable(false);
	
	text.setText("hello \n");
	text.append("I like this \n");//this send to text area
	text.append("a lot");//append 就是往上加，而不是覆盖
	System.out.println("Thanks for using");//this send to system
	
	contentPane.add(text);//pane add lot of things
	
	text.setBounds(0,0,100,100);
	
	
	setTitle("My tEXT");
	setVisible(true);
	setSize(300,300);
	
	
}
public static void main(String args[])//main必须要，每个程序都要，args是argument
{
	TextArea application = new TextArea();
    application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
}
}
