import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class WindowController extends JFrame {

//date		
      //object
private Container contentPane;
private JTextField colorInputJTextField;
private JLabel colorJLabel;	
private JButton submitJButton;
private JButton RGBcheckJButton;
private Screen myScreen;
private JTextField enterRJTextField,enterGJTextField,enterBJTextField;
	
	
//constructor
//call this	
public WindowController()//WindowController control = new WindowController();	
{
	createUserInterface();
} // end constructor	
	
	
	
	
	
//methods
	
public void createUserInterface()
{
	myScreen = new Screen();
	
	contentPane = getContentPane();
	contentPane.setLayout(null);//Layout is relatively position
	contentPane.setBackground(Color.RED);	
	
	colorInputJTextField = new JTextField();
	colorInputJTextField.setBounds(100,100,50,30);
	contentPane.add(colorInputJTextField);
	
	
	colorJLabel = new JLabel("Type Color");
	colorJLabel.setForeground(Color.WHITE);
	colorJLabel.setBounds(5,40,100,160);
    contentPane.add(colorJLabel);
    
	enterRJTextField = new JTextField();
	enterRJTextField.setText("R");
	enterRJTextField.setBounds(5,150,50,30 );

enterRJTextField.setVisible(false);
      contentPane.add( enterRJTextField );
      enterRJTextField.addMouseListener(new MouseAdapter(){
          public void mouseClicked(MouseEvent e){
        	  enterRJTextField.setText("");
         }
          }
      );
  	enterGJTextField = new JTextField();
  	enterGJTextField.setText("G");
  	enterGJTextField.setBounds( 65,150,50,30  );

	enterGJTextField.setVisible(false);
      contentPane.add( enterGJTextField );
      enterGJTextField.addMouseListener(new MouseAdapter(){
          public void mouseClicked(MouseEvent e){
        	  enterGJTextField.setText("");
         }
          }
      );
  	enterBJTextField = new JTextField();
  	enterBJTextField.setText("B");
  	enterBJTextField.setBounds( 115,150,50,30  );

  	enterBJTextField.setVisible(false);
      contentPane.add( enterBJTextField );
      enterBJTextField.addMouseListener(new MouseAdapter(){
          public void mouseClicked(MouseEvent e){
        	  enterBJTextField.setText("");
         }
          }
      );
      
      RGBcheckJButton = new JButton("checkRGB");
      RGBcheckJButton.setBounds(100,200,90,50);
contentPane.add(RGBcheckJButton);
RGBcheckJButton.addActionListener(
		new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				
				
				enterRJTextField.setVisible(true);
			      enterGJTextField.setVisible(true);
			      enterBJTextField.setVisible(true);
			  	int  r=0,g=0,b=0;
				  r = Integer.parseInt(enterRJTextField.getText());
			      g = Integer.parseInt(enterGJTextField.getText());
			      b = Integer.parseInt(enterBJTextField.getText());
	
			      if(r<=256 && r>=0 && g<=256 && g>=0 && b<=256 && b>=0 )
			      {
			    	  myScreen.setBackground(new Color(r,g,b));
			      }
			      else
			      {
			    	  JOptionPane.showMessageDialog(null,"R,G,B must be an integer that smaller than 256","ERROR",
	    					  JOptionPane.ERROR_MESSAGE);
			      }
			}
		}
		);
      
      
    submitJButton = new JButton("Submit");
    submitJButton.setBounds(30,200,70,50);
    contentPane.add(submitJButton);
    submitJButton.addActionListener(
    		
    		new ActionListener()
    		{
    			public void actionPerformed(ActionEvent event)
    			{
    				String color = colorInputJTextField.getText(); 
    				myScreen.changeColor(color);
    				
    				
    			}
    		}
    		);
    
   
    
	
	//window set up
	setVisible(true);
	setTitle("WindowController");
	setSize(200,500);
	
}


		
		


}
