import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class DateSlider{
  JSlider slider;
  JLabel label;
  JTextField textF;
  JButton B;
  private Save mysave;
 
  public static void main(String[] args){
	  DateSlider cs = new DateSlider();
  }
 
		public void getperiod(String period)
		{
			String PERIOD = period;
			
			mysave.periodChanger(PERIOD);
		}
	

  public DateSlider(){
	  B = new JButton("OK");
	  B.addActionListener(
		         
		         new ActionListener() 
		         {
		            
		             public void actionPerformed ( ActionEvent event )
		             {
		            	
		            	  mysave = new Save();
		            	  
		            	  int value = slider.getValue();
		            	  String str = Integer.toString(value);
		            	  label.setText(str);
		            	  textF.setText(str);
		            	 
		            	  String x =textF.getText();
		            	  String period = x;
		            	  System.out.println(period);
		            	  
		            	  mysave.periodChanger(str);
		             }

		         } 

		      );
	  
	  
	  textF = new JTextField();
	  textF.setVisible(false);
  JFrame frame = new JFrame("Slider Frame");
  slider = new JSlider();
  slider.setValue(1);
  slider.addChangeListener(new MyChangeAction());
  label = new JLabel("Choose a period between 0-100");
  JPanel panel = new JPanel();
  panel.add(slider);
  panel.add(B);
  panel.add(label);
  frame.add(panel, BorderLayout.CENTER);
  frame.setSize(250, 120);
  frame.setVisible(true);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public class MyChangeAction implements ChangeListener{
  public void stateChanged(ChangeEvent ce){
  int value = slider.getValue();
  String str = Integer.toString(value);
  label.setText(str);
  textF.setText(str);
  String x =textF.getText();
  String period = x;

  }
  }
}