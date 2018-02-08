import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;


public class DrawTheMovingFade extends JComponent implements ActionListener{
	private long cycleStart;
	private int currentResolution = 50;
	 Timer timer = null; // animation Timer
	private int blurSize =5;
	 float trailOpacity[];


	public DrawTheMovingFade() {
	    // createAnimationImage();
	    cycleStart = System.nanoTime() / 1000000;
	    startTimer(currentResolution );
	  }
	
	
	public void paintComponent1(Graphics g) {
		  g.setColor(Color.WHITE);
		    g.fillRect(0, 0, getWidth(), getHeight());

		    // Draw the fading image
		    Graphics2D gFade = (Graphics2D) g.create();
		   
	
		    gFade.dispose();
		    float incrementalFactor = .2f / (blurSize  + 1);
		    for (int i = 0; i < blurSize; ++i) {
		    trailOpacity[i] = (.2f - incrementalFactor) - i * incrementalFactor;
		    }
	}
	
	
	
	 private void startTimer(int resolution) {
		 if (timer != null) {
		      timer.stop();
		      timer.setDelay(resolution);
		    } else {
		      timer = new Timer(resolution, this);
		    }
		    timer.start();
		
	}

	public void paintComponent(Graphics g) 
	 {
		 
		 
	 }
	
	
	public static void main(String[] args) {
		   Runnable doCreateAndShowGUI = new Runnable() {
			      public void run() {
			        createAndShowGUI();
			      }
			    };
			    SwingUtilities.invokeLater(doCreateAndShowGUI);
			  }

	
 	
private static void createAndShowGUI() {
    JFrame f = new JFrame("Smooth Moves");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setSize( 150, 300);
    DrawTheMovingFade component = new DrawTheMovingFade();
    f.add(component);
    f.setVisible(true);

  }

@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	
}

}
