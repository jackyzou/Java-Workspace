import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class ToolBar extends DrawPad{
	
	
	final DrawPad pad = new DrawPad();
  public   ToolBar() {
	  
	  
	  
	  JFrame frame = new JFrame();	  
	  
	  JButton clearButton = new JButton("Clear");
      clearButton.setBounds(0,150,120,30);
      frame.add(clearButton);
      
      clearButton.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent e) { 
        	pad.clear();		
        	
        }												
      });
      

      JButton colorButton = new JButton( "Color" );
      colorButton.setBounds(0,0,120,30);
      frame.add(colorButton);
      
      
      colorButton.addActionListener(
         new ActionListener() {
            public void actionPerformed( ActionEvent e )
            {
          	  Color paint = JColorChooser.showDialog(
                        null, "Select a Color", Color.black );
          	  pad.color(paint);
            }
         }
      );
	  
      JButton rectButton = new JButton( "Rectangle" );
      rectButton.setBounds(0,30,120,30);
      frame.add(rectButton);
      
      
      rectButton.addActionListener(
         new ActionListener() {
            public void actionPerformed( ActionEvent e )
            {
            	pad.setRect();
            }
         }
      );
      
      JButton circleButton = new JButton( "Circle" );
      circleButton.setBounds(0,60,120,30);
      frame.add(circleButton);
      
      
      circleButton.addActionListener(
         new ActionListener() {
            public void actionPerformed( ActionEvent e )
            {
            	pad.setCircle();
            }
         }
      );
      
      JButton brushButton = new JButton( "Brush" );
      brushButton.setBounds(0,90,120,30);
      frame.add(brushButton);
      
      
      brushButton.addActionListener(
         new ActionListener() {
            public void actionPerformed( ActionEvent e )
            {
            	int value = Integer.parseInt(
                        JOptionPane.showInputDialog(
                                null, "Please enter brush size: "));
            	pad.setBrushSize(value);
            	pad.setBrush();
            }
         }
      );
      
      JButton triButtaon = new JButton( "Triangle" );
      triButtaon.setBounds(0,120,120,30);
      frame.add(triButtaon);
      
      
      triButtaon.addActionListener(
         new ActionListener() {
            public void actionPerformed( ActionEvent e )
            {
            	pad.setTri();
            }
         }
      );
      
      JButton saveButtaon = new JButton( "Save" );
      saveButtaon.setBounds(0,180,120,30);
      frame.add(saveButtaon);
      
      
      saveButtaon.addActionListener(
         new ActionListener() {
            public void actionPerformed( ActionEvent e )
            {
            	pad.saveImage();
            }
         }
      );
      
      
      JButton a = new JButton( "" );
      a.setVisible(false);
      frame.add(a);

	  
	  frame.setVisible(true);
	   // frame.add(drawPad, BorderLayout.CENTER);
	    frame.setBounds(800,0,120, 600);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	  frame.setResizable(false);
	  frame.setTitle("Toolbar");
		JFrame frame2 = new JFrame();
		
		frame2.add(pad, BorderLayout.CENTER);
		//frame.add(tools );
		
		frame2.setBounds(0, 0, 800, 600);
		frame2.setVisible(true);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setTitle("Drawing Pad by Justin Chen");
	  
	  
	  
	  
   /* JToolBar toolbar = new JToolBar(JToolBar.VERTICAL);

    JButton selectb = new JButton();
    JButton freehandb = new JButton();
    JButton shapeedb = new JButton();
    JButton penb = new JButton();

    toolbar.add(selectb);
    toolbar.add(freehandb);
    toolbar.add(shapeedb);
    toolbar.add(penb);*/
	  
   /* JFrame f = new JFrame();
    f.add(toolbar, BorderLayout.WEST);

    f.setSize(250, 350);
    f.setLocationRelativeTo(null);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setVisible(true);*/
  }
  public static void main(String[] args)
  {
	  
  }
  
}

   
    