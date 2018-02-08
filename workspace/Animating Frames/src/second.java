import javax.swing.*;
import java.awt.event.*;
import java.awt.*;



	public class second extends JPanel implements ActionListener{
		private Timer animator;
		private ImageIcon imageArray[];
		private int delay = 100 ,totalFrames = 10, currentFrame = 0;
		
		public second()
		{
			imageArray = new ImageIcon[totalFrames];
			for(int i=0; i < imageArray.length;i++)
			{
			
				imageArray[i] = new ImageIcon("frame" +  i  + ".jpg");
			}
			animator = new Timer(delay,this);
			animator.start();
			
		}
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			if(currentFrame>imageArray.length)
			{
				currentFrame = 0;
			}
			currentFrame++;
			imageArray[currentFrame].paintIcon(this,g,0,0);
			
			
		}
		
		public void actionPerformed(ActionEvent e)
		{
			repaint();
		}
		
		
	}

