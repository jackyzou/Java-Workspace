import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class About extends JPanel implements ActionListener,KeyListener{
		private Timer animator;
		private ImageIcon imageArray[];
		private static JTextArea TextArea;
		private static JScrollPane scroller;
		private static JLabel ABOUT;
		private int delay = 8000,totalFrames =12, currentFrame = 1;
		
		
		public About()
		{    

			imageArray = new ImageIcon[totalFrames];
			for(int i =0; i < imageArray.length;i++)
			{
			
				imageArray[i] = new ImageIcon("frame" +  i  + ".jpg");
			}
			animator = new Timer(delay,this);
			animator.start();

		}
		


		public void paintComponent(Graphics g)
		{
		  super.paintComponent(g);
			
			if(currentFrame == imageArray.length |currentFrame > imageArray.length )
			{
				currentFrame = 1;
			}
			currentFrame++;
			imageArray[currentFrame].paintIcon(this,g,0,0);
		}
		

		public void actionPerformed(ActionEvent e)
		{
			repaint();
			
		}
		
		
		public static void main(String[] args) {
			About s = new About();
			JFrame f = new JFrame();
			f.add(s);
			f.setVisible(true);
			f.setResizable(false);
			f.setSize(1324,650);
			f.setTitle("About");
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			
		      TextArea = new JTextArea ();
		      TextArea.setLineWrap(true);
		      JScrollPane scroller = new JScrollPane(TextArea);
		      scroller.setBounds( 1024, 50, 300, 600 );
		      TextArea.setEditable(false);
		      TextArea.setBounds( 1024, 50, 300, 600 );
		      TextArea.append("     As we know, travel became a big part of our life. A nice, elaborated, well-planned trip will make you feel happy and relaxed, and you can throw yourself into work or study more efficiently. However, a disordered trip will make you sad, maybe it will even distract you from work. Therefore, a well-planned trip is very important and a Travel Planner is necessary."+"\n");
		      TextArea.append("     The Travel Planner System (TPS) includes many parts that help you to organize an elaborated trip. This system is basically consisting of two main parts. After login, user can choose to create a new travel plan or keep track of the current plan. The first part is to create a new plan. TPS allows every user to have an account to keep track of their arrangement. The travel itinerary is based on user itself, which allow user to be creative. In order to create a travel itinerary, the system provides a calendar, which is synchronized to GMT (Greenwich mean time). It provides a world map that shows the points of interest. The map is clickable; click on different regions will show the information of that point of interest and zoom the pictures. The map is user friendly, you can sketch the routine that you want to go by just dragging your mouse from place to place (mouse events). For another option, you can choose the places manually. After choosing the destinations, the system will remind you to decide how many days to stay in each place. Furthermore, the system will generate the plane tickets according to user��s previous settings. The seat reservation will be using 2D array. It charges various rates for particular sections of the plane. Example, first class is going to cost more than coach. The fee and billhead will be notified and user can easily login their RPS Bank account to pay the bill. The seat reservation will be synchronized to the calendar on the homepage, so do the destinations. In the meantime, the system will pops up a hotel reservation window, user can manage the hotels ahead of time or save it for later. Hotel reservation will also be achieved by 2D array. There will be a button like ��Add to Cart��, all the costs will be listing on one page. The costs auto-connects to RPS Bank, which reminds you if the expenses exceed your budget. You can easily modify the plan by click on the item you want to change. So that user can minimize the costs. The system will go back to the setting page of that item and let the user change it. TPS also provide a currency converter for traveller who travels around different countries. After confirming the cost list, user will receive a complete schedule of trip. The schedule will be saved as a file with user��s account on the computer."+"\n");
		      TextArea.append("     The second part is to keep track on your plan. Every user has an account; the account will read the files on the computer every time the user login. After login, you can see some useful apps on your homepage, like calculator, currency converter, Google the place you are going and some little games to kill time. More importantly, you can modify your travel plan anytime such as adding people, places, days; changing routines, flights and hotels by adding the corresponding costs."+"\n");
		      TextArea.append("     For the security aspect, after a certain time not taking actions, the system will go into a screen saver mode, which require user to re-login to continue. "+"\n");
		      TextArea.append("     In conclusion, the Travel Planner System is capable to make a travel plan for you. The map-destination-selecting method and bill paying method make user��s life so much easier. All other little apps also increase the efficiency for user to create a better plan."+"\n");
		      scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		      f.add(scroller, BorderLayout.CENTER);
		   
		}
		@Override
		public void keyPressed(KeyEvent event) 
		{
			// TODO Auto-generated method stub

			   int keyCode = event.getKeyCode();
			if (keyCode == KeyEvent.VK_RIGHT) 
			{ 
				currentFrame = 6;
		    }
		}	
		public void keyReleased(KeyEvent arg0) 
		{
			
			
		}
		public void keyTyped(KeyEvent arg0) 
		{
			
			
		}

	}
	