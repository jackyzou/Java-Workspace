import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Locale;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JWindow;
import javax.swing.border.Border;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;


public class AccountHome extends JFrame  // makes class
{

	
	private JLabel bar,logoLabel, seperate,mapJLabel,back,signoutJLabel;
	private JButton createTrip,savedTrip,rpsfinance,logo,set,itinerary,map,cal,signout,changePic;
	
	private JLabel userPhoto;
	
	Container contentPane = getContentPane();
	private JPanel userBasic;
	
	private JPanel compoundpanel,titledpanel;

	private Border compound,titled,raisedbevel,loweredbevel ;
	private JTabbedPane pane;
	
	private JLabel nameJLabel, emailJLabel, phoneJLabel, addressJLabel,genderJLabel,countryJLabel,IDJLabel;
	private JTextField nameJTextField, emailJTextField, phoneJTextField, addressJTextField, genderJTextField, countryJTextField,IDJTextField;
	
	private int randomNum,minimum=1000,maximum=100000;
	private String name,email,password,phone,address,gender,country,ID;
	
	private Locale locale;
	
	private JLabel setSTART = new JLabel();
	private JLabel setDestination = new JLabel();
	private JLabel time = new JLabel();
	
	
	//JMapViewer Map = new JMapViewer(); 
	
	private JWindow LogoutScreen;
	
	
	private JLabel theWorldMap;
	JFrame frame = new JFrame();
		

	JDesktopPane desktopPane = new JDesktopPane();
	JInternalFrame intFrame = new JInternalFrame("Select a place to go first!");
	
	JInternalFrame calframeS = new JInternalFrame();
	JInternalFrame confirm = new JInternalFrame();

	JDateChooser dateChooser = new JDateChooser();
	
	private String startplace, destination,dateOfSettingOff;

	
	

	 int xpos; 
	 int ypos;
	 int rect1xco,rect1yco,rect1width,rect1height;

	 boolean mouseEntered;

	 boolean rect1Clicked;
	 
	 private JButton Next = new JButton (new ImageIcon("blafibutton.png"));
	private JButton update;
	private JLabel startingPlace;
	private JLabel destinationlabel;
	private JLabel date;
	private JLabel hint;
	private JLabel hint1;
	private JLabel tpsLOGOinConfirm;
	private JLabel startingPlace1;
	private JLabel destination1;
	private JLabel date1;
	private JButton save;
	private JLabel mapInTheInternalFrame;
	private Component junk;
	 
	private JLabel flags;
	  

	
	public AccountHome() 
	{
		setLayout(null);
		createUserInterface();
		randomNum = minimum + (int)(Math.random()*maximum); 
		ID = String.valueOf(randomNum);
		IDJTextField.setText(String.valueOf(ID));
		
		locale = Locale.getDefault();
		System.out.print(locale);
	}
	
	
	public void paintComponent(Graphics g)
	{
		super.paintComponents(g);
		
		Graphics2D g2 = (Graphics2D) g;
	
		Line2D line = new Line2D.Double(300,200,0,500);

	
		g2.draw(line);
	
	
	}
	
	
	public void getUserBasicInfo(String n, String e, String pass, String p, String a, String g, String c)
	{
		name = n;
		email = e;
		password = pass;
		phone = p;
		address= a;
		gender= g;
		country= c;
		
		nameJTextField.setText(name);
		emailJTextField.setText(email);
		phoneJTextField.setText(phone);
		addressJTextField.setText(address);
		genderJTextField.setText(gender);
		countryJTextField.setText(country);

	}

	
	
	
	private void createUserInterface()
	{
		
		
		
		contentPane.setLayout(null);
		contentPane.setBackground(Color.white);
	
		//Map = new JMapViewer();
	
		flags = new JLabel(new ImageIcon("flag.png"));
		flags.setBounds(400,220,30,30);
		contentPane.add(flags);
		

	
		theWorldMap= new JLabel(new ImageIcon("world-map(gold ext).png"));
		theWorldMap.setBounds(10, 20, 1427, 628 );
		theWorldMap.setVisible(true);
		contentPane.add( theWorldMap );
		
		
	
		
	///////The Panel////	
		
		pane = new JTabbedPane();
		pane.setBounds(10,320,300, 350);
		compoundpanel=new JPanel();
		compoundpanel.setBackground( new Color(215, 107, 37));
		compoundpanel.setBounds(10,320,300, 350);
		raisedbevel = BorderFactory.createRaisedBevelBorder();
		loweredbevel = BorderFactory.createLoweredBevelBorder();
		compoundpanel.setBorder(BorderFactory.createCompoundBorder(raisedbevel,loweredbevel));
		titledpanel = new JPanel();
		titledpanel.setBackground( new Color(123, 187, 189));
		titledpanel.setBounds(10,320,300, 350);
		titledpanel.setBorder(BorderFactory.createTitledBorder("Basic User Info"));

		pane.addTab("User Info",titledpanel);
		pane.addTab("History",compoundpanel);
		titledpanel.setLayout(null);
		contentPane.add(pane);
		

		
	
		
		nameJLabel = new JLabel();
		nameJLabel.setText("Name:");
		nameJLabel.setFont (new Font("Bradley Hand ITC TT", Font.PLAIN,20));
		nameJLabel.setBounds(15, 20, 70, 50 );
		nameJLabel.setVisible(true);
		titledpanel.add( nameJLabel );
		
		nameJTextField= new JTextField();
		nameJTextField.setBounds(100, 30, 150, 30 );
		nameJTextField.setEditable(false);
		nameJTextField.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		nameJTextField.setVisible(true);
		titledpanel.add( nameJTextField );
		
	
		emailJLabel= new JLabel();
		emailJLabel.setText("Email:");
		emailJLabel.setFont (new Font("Bradley Hand ITC TT", Font.PLAIN,20));
		emailJLabel.setBounds(15, 60, 80, 50 );
		emailJLabel.setVisible(true);
		titledpanel.add( emailJLabel );
		
		emailJTextField= new JTextField();
		emailJTextField.setBounds(100, 70, 150, 30 );
		emailJTextField.setEditable(false);
		emailJTextField.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		emailJTextField.setVisible(true);
		titledpanel.add( emailJTextField );
		
		phoneJLabel= new JLabel();
		phoneJLabel.setText("Phone#:");
		phoneJLabel.setFont (new Font("Bradley Hand ITC TT", Font.PLAIN,20));
		phoneJLabel.setBounds(15, 100, 90, 50 );
		phoneJLabel.setVisible(true);
		titledpanel.add( phoneJLabel );
		
		phoneJTextField= new JTextField();
		phoneJTextField.setBounds(100, 110, 150, 30 );
		phoneJTextField.setEditable(false);
		phoneJTextField.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		phoneJTextField.setVisible(true);
		titledpanel.add( phoneJTextField );
		
		addressJLabel= new JLabel();
		addressJLabel.setText("Address:");
		addressJLabel.setFont (new Font("Bradley Hand ITC TT", Font.PLAIN,20));
		addressJLabel.setBounds(15, 140, 90, 50 );
		addressJLabel.setVisible(true);
		titledpanel.add( addressJLabel );
		
		addressJTextField= new JTextField();
		addressJTextField.setBounds(100, 150, 150, 30 );
		addressJTextField.setEditable(false);
		addressJTextField.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		addressJTextField.setVisible(true);
		titledpanel.add( addressJTextField );
	
		genderJLabel= new JLabel();
		genderJLabel.setText("Gender:");
		genderJLabel.setFont (new Font("Bradley Hand ITC TT", Font.PLAIN,20));
		genderJLabel.setBounds(15, 180, 80, 50 );
		genderJLabel.setVisible(true);
		titledpanel.add( genderJLabel );
		
		genderJTextField= new JTextField();
		genderJTextField.setBounds(100, 190, 150, 30 );
		genderJTextField.setEditable(false);
		genderJTextField.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		genderJTextField.setVisible(true);
		titledpanel.add( genderJTextField );
	
		countryJLabel= new JLabel();
		countryJLabel.setText("Country:");
		countryJLabel.setFont (new Font("Bradley Hand ITC TT", Font.PLAIN,20));
		countryJLabel.setBounds(15, 220, 80, 50 );
		countryJLabel.setVisible(true);
		titledpanel.add( countryJLabel );
		
		countryJTextField= new JTextField();
		countryJTextField.setBounds(100, 230, 150, 30 );
		countryJTextField.setEditable(false);
		countryJTextField.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		countryJTextField.setVisible(true);
		titledpanel.add( countryJTextField );
		
		IDJLabel= new JLabel();
		IDJLabel.setText("ID#:");
		IDJLabel.setFont (new Font("Bradley Hand ITC TT", Font.PLAIN,20));
		IDJLabel.setBounds(15, 260, 80, 50 );
		IDJLabel.setVisible(true);
		titledpanel.add( IDJLabel );
		
		IDJTextField= new JTextField();
		IDJTextField.setBounds(100, 270, 150, 30 );
		IDJTextField.setEditable(false);
		IDJTextField.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		IDJTextField.setVisible(true);
		titledpanel.add( IDJTextField );
		
		 hint = new JLabel("Single Click to select a starting place");
		hint.setBounds(0,395,300,30);
		 hint1 = new JLabel("Hold the click for 1 second to select a destination");
		hint1.setBounds(0,410,320,30);
		intFrame.add(hint);
		intFrame.add(hint1);
		
		logo= new JButton(new ImageIcon("TPS-logo-med.png"));
		logo.setBounds(26, 21, 50, 60 );
		logo.setVisible(true);
		contentPane.add( logo );
		logo.addMouseListener( 
				new MouseAdapter()
				{
				public void mouseEntered (MouseEvent me) { 
					setCursor (Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				}
				 public void mouseExited (MouseEvent me) { 
					 setCursor (Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				 }
				}
				 );
		
		logo.addActionListener(
	    		  
	    		  new ActionListener()
	    		  {
	    			  public void actionPerformed( ActionEvent event)
	    			  {
	    				
	    				  logoActionPerformed( event );
		
	    
	    			  }

					private void logoActionPerformed(ActionEvent event) 
					{
						{
							int k = JOptionPane.showConfirmDialog(null, 
		            				" Are you sure you want to go home? "
									, " Warning, might lose information! ", JOptionPane.YES_OPTION);
		         		
		         		//System.out.print(x);
		         		
		         		if(k == 1)
		         		{
		         			
		         			//Means NO
		         			System.out.print("NO");
		         		}
		         		
		         		else if(k == 2)
		         		{
		         			
		         			//Means Cancel
		         			System.out.print("Cancel");
		         		}
		         		else 
		         		{
		         			MasterClass.goHome();
							dispose();
		         			//Means Yes
		         			System.out.print("Yes");
		         			
		         		}
						
						}
					}
	    		  }
		
						);
						
		logoLabel = new JLabel(new ImageIcon("TPS-logo-med.png"));
		logoLabel.setBounds(1, -1, 100, 104 );
		logoLabel.setVisible(true);
		contentPane.add( logoLabel );
		
		changePic= new JButton("?");
		changePic.setBounds(240, 295, 15, 15 );
		changePic.setVisible(true);
		contentPane.add( changePic );
		changePic.addActionListener(
	    		  
	    		  new ActionListener()
	    		  {
	    			  public void actionPerformed( ActionEvent event)
	    			  {
	    				
	    				  changePicPerformed( event );
		
	    
	    			  }

					private void changePicPerformed(ActionEvent event) 
					{
						{
							JFileChooser fc = new JFileChooser();
							int returnVal = fc.showOpenDialog(contentPane); //Where frame is the parent component

							File file = null;
							try
							{
							if (returnVal == JFileChooser.APPROVE_OPTION) {
							    file = fc.getSelectedFile();
							    BufferedImage bufferedImage = ImageIO.read(file);
							    userPhoto.setIcon(new ImageIcon(bufferedImage));
							} 
							}
							catch(Exception x)
							{
								int k = JOptionPane.showConfirmDialog(null, 
			            				" Not a valid file, sorry! :( "
										, " ERROR! ", JOptionPane.YES_OPTION);
							}
						}
					}
	    		  }
					);
		
		
		
		


		
		//dateChooser.requestFocusInWindow();

		
		
		
	//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calframeS.setMaximizable(true);
		calframeS.setIconifiable(true);
		calframeS.setResizable(true);
		calframeS.setClosable(false);
		calframeS.setLocation(300, 150);
		calframeS.moveToFront();
		calframeS.setVisible(false);
		calframeS.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);

		
		calframeS.setSize(300, 100);
		calframeS.add(dateChooser);
		
		//calframe.add(dateChooser1);
		desktopPane.add(calframeS);
		
		update = new JButton("Update");
		update.setBounds(620,370,80,30);
		intFrame.add(update);
		update.addActionListener( new ActionListener()
		  {
			  public void actionPerformed( ActionEvent event)
			  {
				
				  updateActionPerformed( event );


			  }

			private void updateActionPerformed(ActionEvent event) 
			{
				if(!setSTART.getText().equals("")&&!setDestination.getText().equals(""))
				{
					String start= setSTART.getText();
					String des =setDestination.getText();
					startplace =start;
					destination = des;
					
					dateOfSettingOff = JDateChooser.comeDate();
					System.out.print(dateOfSettingOff);
					time.setText(dateOfSettingOff);
					time.setVisible(true);
														}
			}
		  }
		);
		 
		tpsLOGOinConfirm = new JLabel((new ImageIcon("TPS-logo-med.png")));
		 tpsLOGOinConfirm.setBounds(0,0,100,103);
		
		
			
			
			JButton ca = new JButton(new ImageIcon("ca.png"));
			ca.setBounds(160,70,20,20);
			ca.addMouseListener(new MouseAdapter() {

		    	  public void mouseClicked(MouseEvent evt) {

		    		  if (evt.getClickCount() == 1) 
	    		      {
	    		    	 setSTART.setText("Canada");
	    		      }
	    		      else if(!setSTART.equals(""))
	    		      {
	    		    	  setDestination.setText("Canada");
	    		      }
		    		  if(!setSTART.getText().equals("")&&!setDestination.getText().equals(""))
						{
							String start= setSTART.getText();
							String des =setDestination.getText();
							startplace =start;
							destination = des;
							
							calframeS.moveToFront();
							calframeS.setVisible(true);
							calframeS.setTitle("Select a date to set off from "+ start);
						}   
		    	  }});

			
		
			JButton de = new JButton(new ImageIcon("de.png"));
			de.setBounds(455,90,14,14);
			de.addMouseListener(new MouseAdapter() {

		    	  public void mouseClicked(MouseEvent evt) {

		    		  if (evt.getClickCount() == 1) 
	    		      {
	    		    	 setSTART.setText("Germany");
	    		      }
	    		      else if(!setSTART.equals(""))
	    		      {
	    		    	  setDestination.setText("Germany");
	    		      }if(!setSTART.getText().equals("")&&!setDestination.getText().equals(""))
						{
							String start= setSTART.getText();
							String des =setDestination.getText();
							startplace =start;
							destination = des;
							
							calframeS.moveToFront();
							calframeS.setVisible(true);
							calframeS.setTitle("Select a date to set off from "+ start);
						}
		    	  }});
			JButton fr = new JButton(new ImageIcon("fr.png"));
			fr.setBounds(440,100,14,14);
			fr.addMouseListener(new MouseAdapter() {

		    	  public void mouseClicked(MouseEvent evt) {
		    		  
		    		  if (evt.getClickCount() == 1) 
	    		      {
	    		    	 setSTART.setText("French");
	    		      }
	    		      else if(!setSTART.equals(""))
	    		      {
	    		    	  setDestination.setText("French");
	    		      }
		    		  if(!setSTART.getText().equals("")&&!setDestination.getText().equals(""))
						{
							String start= setSTART.getText();
							String des =setDestination.getText();
							startplace =start;
							destination = des;
							
							calframeS.moveToFront();
							calframeS.setVisible(true);
							calframeS.setTitle("Select a date to set off from "+ start);
						}
		    	  }});
			JButton gb = new JButton(new ImageIcon("gb.png"));
			gb.setBounds(440,70,14,14);
			gb.addMouseListener(new MouseAdapter() {

		    	  public void mouseClicked(MouseEvent evt) {

		    		  if (evt.getClickCount() == 1) 
	    		      {
	    		    	 setSTART.setText("Britain");
	    		      }
	    		      else if(!setSTART.equals(""))
	    		      {
	    		    	  setDestination.setText("Britain");
	    		      }

		    		  if(!setSTART.getText().equals("")&&!setDestination.getText().equals(""))
						{
							String start= setSTART.getText();
							String des =setDestination.getText();
							startplace =start;
							destination = des;
							
							calframeS.moveToFront();
							calframeS.setVisible(true);
							calframeS.setTitle("Select a date to set off from "+ start);
						}
		    	  }});
JButton in = new JButton(new ImageIcon("in.png"));
			in.setBounds(650,170,14,14);
			in.addMouseListener(new MouseAdapter() {

		    	  public void mouseClicked(MouseEvent evt) {
		    		  

		    		  if (evt.getClickCount() == 1) 
	    		      {
	    		    	 setSTART.setText("India");
	    		      }
	    		      else if(!setSTART.equals(""))
	    		      {
	    		    	  setDestination.setText("India");
	    		      }
		    		  
		    		  if(!setSTART.getText().equals("")&&!setDestination.getText().equals(""))
						{
							String start= setSTART.getText();
							String des =setDestination.getText();
							startplace =start;
							destination = des;
							
							calframeS.moveToFront();
							calframeS.setVisible(true);
							calframeS.setTitle("Select a date to set off from "+ start);
						}
		    		
		    	  }});
			JButton jp = new JButton(new ImageIcon("jp.png"));
			jp.setBounds(820,125,14,14);
			jp.addMouseListener(new MouseAdapter() {

		    	  public void mouseClicked(MouseEvent evt) {
		    		  

		    		  if (evt.getClickCount() == 1) 
	    		      {
	    		    	 setSTART.setText("Japen");
	    		      }
	    		      else if(!setSTART.equals(""))
	    		      {
	    		    	  setDestination.setText("Japen");
	    		      }

		    		  if(!setSTART.getText().equals("")&&!setDestination.getText().equals(""))
						{
							String start= setSTART.getText();
							String des =setDestination.getText();
							startplace =start;
							destination = des;
							
							calframeS.moveToFront();
							calframeS.setVisible(true);
							calframeS.setTitle("Select a date to set off from "+ start);
						}
		    	  }});
			JButton us = new JButton(new ImageIcon("us.png"));
			us.setBounds(160,115,20,20);
			us.addMouseListener(new MouseAdapter() {

		    	  public void mouseClicked(MouseEvent evt) {
		    		  

		    		  if (evt.getClickCount() == 1) 
	    		      {
	    		    	 setSTART.setText("USA");
	    		      }
	    		      else if(!setSTART.equals(""))
	    		      {
	    		    	  setDestination.setText("USA");
	    		      }
		    		  if(!setSTART.getText().equals("")&&!setDestination.getText().equals(""))
						{
							String start= setSTART.getText();
							String des =setDestination.getText();
							startplace =start;
							destination = des;
							
							calframeS.moveToFront();
							calframeS.setVisible(true);
							calframeS.setTitle("Select a date to set off from "+ start);
						}
		    	
		    	  }});
			JButton vn = new JButton(new ImageIcon("vn.png"));
			vn.setBounds(730,188,14,14);
			vn.addMouseListener(new MouseAdapter() {

		    	  public void mouseClicked(MouseEvent evt) {
		    		  

		    		  if (evt.getClickCount() == 1) 
	    		      {
	    		    	 setSTART.setText("Vietnam");
	    		      }
	    		      else if(!setSTART.equals(""))
	    		      {
	    		    	  setDestination.setText("Vietnam");
	    		      }
		    		  if(!setSTART.getText().equals("")&&!setDestination.getText().equals(""))
						{
							String start= setSTART.getText();
							String des =setDestination.getText();
							startplace =start;
							destination = des;
							
							calframeS.moveToFront();
							calframeS.setVisible(true);
							calframeS.setTitle("Select a date to set off from "+ start);
						}
		    	  }});
			JButton ch = new JButton(new ImageIcon("ch.png"));
			ch.setBounds(710,130,20,20);
			ch.addMouseListener(new MouseAdapter() {

		    	  public void mouseClicked(MouseEvent evt) {
		    		  

		    		  if (evt.getClickCount() == 1) 
	    		      {
	    		    	 setSTART.setText("China");
	    		      }
	    		      else if(!setSTART.equals(""))
	    		      {
	    		    	  setDestination.setText("China");
	    		      }
		    		  if(!setSTART.getText().equals("")&&!setDestination.getText().equals(""))
						{
							String start= setSTART.getText();
							String des =setDestination.getText();
							startplace =start;
							destination = des;
							
							calframeS.moveToFront();
							calframeS.setVisible(true);
							calframeS.setTitle("Select a date to set off from "+ start);
						}
		    		 
		    	  }});
			JButton ru = new JButton(new ImageIcon("ru.png"));
			ru.setBounds(680,50,25,25);
			ru.addMouseListener(new MouseAdapter() {

		    	  public void mouseClicked(MouseEvent evt) {
		    		  

		    		  if (evt.getClickCount() == 1) 
	    		      {
	    		    	 setSTART.setText("Russia");
	    		      }
	    		      else if(!setSTART.equals(""))
	    		      {
	    		    	  setDestination.setText("Russia");
	    		      }

		    		  if(!setSTART.getText().equals("")&&!setDestination.getText().equals(""))
						{
							String start= setSTART.getText();
							String des =setDestination.getText();
							startplace =start;
							destination = des;
							
							calframeS.moveToFront();
							calframeS.setVisible(true);
							calframeS.setTitle("Select a date to set off from "+ start);
						}
		    	  }});
			JButton au = new JButton(new ImageIcon("au.png"));
			au.setBounds(800,320,28,28);
			au.addMouseListener(new MouseAdapter() {

		    	  public void mouseClicked(MouseEvent evt) {
		    		  

		    		  if (evt.getClickCount() == 1) 
	    		      {
	    		    	 setSTART.setText("Australia");
	    		      }
	    		      else if(!setSTART.equals(""))
	    		      {
	    		    	  setDestination.setText("Australia");
	    		      }
		    		  if(!setSTART.getText().equals("")&&!setDestination.getText().equals(""))
						{
							String start= setSTART.getText();
							String des =setDestination.getText();
							startplace =start;
							destination = des;
							
							calframeS.moveToFront();
							calframeS.setVisible(true);
							calframeS.setTitle("Select a date to set off from "+ start);
						}
		    	  }});
			JButton eg = new JButton(new ImageIcon("eg.png"));
			eg.setBounds(510,156,18,18);
			eg.addMouseListener(new MouseAdapter() {

		    	  public void mouseClicked(MouseEvent evt) {
		    		  

		    		  if (evt.getClickCount() == 1) 
	    		      {
	    		    	 setSTART.setText("Egypt");
	    		      }
	    		      else if(!setSTART.equals(""))
	    		      {
	    		    	  setDestination.setText("Egypt");
	    		      }
		    		  if(!setSTART.getText().equals("")&&!setDestination.getText().equals(""))
						{
							String start= setSTART.getText();
							String des =setDestination.getText();
							startplace =start;
							destination = des;
							
							calframeS.moveToFront();
							calframeS.setVisible(true);
							calframeS.setTitle("Select a date to set off from "+ start);
						}
		    		  
		    	  }});
			JButton br = new JButton(new ImageIcon("br.png"));
			br.setBounds(270,280,25,25);
			br.addMouseListener(new MouseAdapter() {

		    	  public void mouseClicked(MouseEvent evt) {
		    		  

		    		  if (evt.getClickCount() == 1) 
	    		      {
	    		    	 setSTART.setText("Brazil");
	    		      }
	    		      else if(!setSTART.equals(""))
	    		      {
	    		    	  setDestination.setText("Brazil");
	    		      }
		    		  if(!setSTART.getText().equals("")&&!setDestination.getText().equals(""))
						{
							String start= setSTART.getText();
							String des =setDestination.getText();
							startplace =start;
							destination = des;
							
							calframeS.moveToFront();
							calframeS.setVisible(true);
							calframeS.setTitle("Select a date to set off from "+ start);
						}
		    		 
		    	  }});
			JButton sa = new JButton(new ImageIcon("sa.png"));
			sa.setBounds(500,320,25,25);
			sa.addMouseListener(new MouseAdapter() {

		    	  public void mouseClicked(MouseEvent evt) {
		    		  

		    		  if (evt.getClickCount() == 1) 
	    		      {
	    		    	 setSTART.setText("South Africa");
	    		      }
	    		      else if(!setSTART.equals(""))
	    		      {
	    		    	  setDestination.setText("South Africa");
	    		      }
		    		  if(!setSTART.getText().equals("")&&!setDestination.getText().equals(""))
						{
							String start= setSTART.getText();
							String des =setDestination.getText();
							startplace =start;
							destination = des;
							
							calframeS.moveToFront();
							calframeS.setVisible(true);
							calframeS.setTitle("Select a date to set off from "+ start);
						}
		    		  
		    	  }});
			JButton ko = new JButton(new ImageIcon("ko.png"));
			ko.setBounds(770,135,20,17);
			ko.addMouseListener(new MouseAdapter() {

		    	  public void mouseClicked(MouseEvent evt) {
		    		  

		    		  if (evt.getClickCount() == 1) 
	    		      {
	    		    	 setSTART.setText("Korean");
	    		      }
	    		      else if(!setSTART.equals(""))
	    		      {
	    		    	  setDestination.setText("Korean");
	    		      }
		    		  if(!setSTART.getText().equals("")&&!setDestination.getText().equals(""))
						{
							String start= setSTART.getText();
							String des =setDestination.getText();
							startplace =start;
							destination = des;
							
							calframeS.moveToFront();
							calframeS.setVisible(true);
							calframeS.setTitle("Select a date to set off from "+ start);
						}
		    	
		    	  }});
			JButton sp = new JButton(new ImageIcon("sp.png"));
			sp.setBounds(423,120,14,11);
			sp.addMouseListener(new MouseAdapter() {

		    	  public void mouseClicked(MouseEvent evt) {
		    		  

		    		  if (evt.getClickCount() == 1) 
	    		      {
	    		    	 setSTART.setText("Spain");
	    		      }
	    		      else if(!setSTART.equals(""))
	    		      {
	    		    	  setDestination.setText("Spain");
	    		      }
		    		  if(!setSTART.getText().equals("")&&!setDestination.getText().equals(""))
						{
							String start= setSTART.getText();
							String des =setDestination.getText();
							startplace =start;
							destination = des;
							
							calframeS.moveToFront();
							calframeS.setVisible(true);
							calframeS.setTitle("Select a date to set off from "+ start);
						}
		 
		    	  }});
			JButton me = new JButton(new ImageIcon("me.png"));
			me.setBounds(137,155,25,25);
			me.addMouseListener(new MouseAdapter() {

		    	  public void mouseClicked(MouseEvent evt) {
		    		  

		    		  if (evt.getClickCount() == 1) 
	    		      {
	    		    	 setSTART.setText("Mexico");
	    		      }
	    		      else if(!setSTART.equals(""))
	    		      {
	    		    	  setDestination.setText("Mexico");
	    		      }
		    		  if(!setSTART.getText().equals("")&&!setDestination.getText().equals(""))
						{
							String start= setSTART.getText();
							String des =setDestination.getText();
							startplace =start;
							destination = des;
							
							calframeS.moveToFront();
							calframeS.setVisible(true);
							calframeS.setTitle("Select a date to set off from "+ start);
						}
		    	
		    	  }});
			
			
			
			time.setVisible(false);
			time.setBounds(700,400,200,30);
			

	
		
			
			intFrame.add(ca);
			intFrame.add(de);
			intFrame.add(fr);
			intFrame.add(gb);
			intFrame.add(in);
			intFrame.add(jp);
			intFrame.add(us);
			intFrame.add(vn);
			intFrame.add(ch);	
			intFrame.add(ru);
			intFrame.add(au);
			intFrame.add(eg);
			intFrame.add(br);
			intFrame.add(sa);
			intFrame.add(ko);
			intFrame.add(sp);
			intFrame.add(me);
		
			intFrame.add(setSTART);
			intFrame.add(setDestination);
			intFrame.add(Next);
			
			intFrame.add(time);
			
			
			
			intFrame.setMaximizable(true);
			intFrame.setIconifiable(true);
			intFrame.setResizable(false);
			intFrame.setClosable(false);
			intFrame.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
			
			
			mapInTheInternalFrame = new JLabel(new ImageIcon("world-map(gold ext).png"));
			mapInTheInternalFrame.setBounds(-15,0,1000,440);
			
			intFrame.add(mapInTheInternalFrame);
			
			intFrame.setSize(1000, 480);

			intFrame.setBackground(Color.WHITE);
			intFrame.setVisible(true);
			desktopPane.add(intFrame);
			desktopPane.add(confirm);
		 
		 
		 
		 
		 
		 
		 
		 
		 startingPlace1 = new JLabel();
		startingPlace1.setBounds(0,10,500,30);
		startingPlace1.setFont (new Font("Bradley Hand ITC TT", Font.PLAIN,25));
		startingPlace1.setForeground(Color.RED);

		 destination1 = new JLabel();
		destination1.setBounds(0,100,500,30);
		destination1.setFont (new Font("Bradley Hand ITC TT", Font.PLAIN,25));
		destination1.setForeground(Color.RED);
		
		 date1 = new JLabel();
		date1.setBounds(0,190,500,30);
		date1.setFont (new Font("Bradley Hand ITC TT", Font.PLAIN,25));
		date1.setForeground(Color.RED);
		
		
		 save = new JButton("'Safe' it"+" and "+"Bon Voyage!");
		save.setBounds(100,240,300,70);
		save.setFont (new Font("Bauhaus 93", Font.PLAIN,20));
		save.addActionListener(
	    		  
	    		  new ActionListener()
	    		  {
	    			  public void actionPerformed( ActionEvent event)
	    			  {
	    				
	    				  saveActionPerformed( event );
		
	    
	    			  }

					private void saveActionPerformed(ActionEvent event) 
					{
						frame.dispose();
						//instead of disposing set the visibility to false
						// clear all labels + dates
						// Jalabel.setText(""); to clear the label text to nothing
						
						MasterClass.getTripInfo(startplace,destination,dateOfSettingOff);
						MasterClass.writetrip();
						
					}
	    		  }
	    		  );
		
		
		confirm.add(save);
		confirm.add(startingPlace1);
		confirm.add(destination1);
		confirm.add(date1);
		confirm.add(tpsLOGOinConfirm);
		
		startingPlace = new JLabel("Starting Place:");
		startingPlace.setBounds(380,370,200,30);
		startingPlace.setFont (new Font("Bradley Hand ITC TT", Font.PLAIN,17));
		startingPlace.setForeground(Color.RED);
		intFrame.add(startingPlace);

		destinationlabel = new JLabel("Destination:");
		destinationlabel.setBounds(380,400,200,30);
		destinationlabel.setFont (new Font("Bradley Hand ITC TT", Font.PLAIN,17));
		destinationlabel.setForeground(Color.RED);
		intFrame.add(destinationlabel);
		
		date = new JLabel("Date:");
		date.setBounds(630,400,200,30);
		date.setFont (new Font("Bradley Hand ITC TT", Font.PLAIN,17));
		date.setForeground(Color.RED);
		intFrame.add(date);
		
	 
		junk = new JLabel("");
		junk.setBounds(10000,1000000,1,1);
		junk.setVisible(false);
		intFrame.add(junk);
		
		
		
		frame.add(desktopPane);
		frame.setTitle("To Create a New Trip...");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(1100, 650);
		frame.setVisible(false);
	
		
		createTrip= new JButton(new ImageIcon("createTripnew.png"));
		createTrip.setBounds(600, 10, 100, 20 );
		createTrip.setVisible(true);
		contentPane.add( createTrip );
		createTrip.addMouseListener( 
				new MouseAdapter()
				{
				public void mouseEntered (MouseEvent me) { 
					setCursor (Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				}
				 public void mouseExited (MouseEvent me) { 
					 setCursor (Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				 }
				}
				 );
	
		createTrip.addActionListener(
	    		  
	    		  new ActionListener()
	    		  {
	    			  public void actionPerformed( ActionEvent event)
	    			  {
	    				
	    				  createTripPerformed( event );
		
	    
	    			  }

					private void createTripPerformed(ActionEvent event) 
					{
						
						{
							//a better way to do this is to create the frame in the beggening and then set the visibility to false
							// every time you need to use it, just clear the fields after every save and when u click this button just 
							// set the visibility to true
							
							
							Next.setBounds(920,380,50,50);
							Next.addActionListener(
						    		  
						    		  new ActionListener()
						    		  {
						    			  public void actionPerformed( ActionEvent event)
						    			  {
						    				
						    				  NextActionPerformed( event );
							
						    
						    			  }

										private void NextActionPerformed(ActionEvent event) 
										{
											String start= setSTART.getText();
											String des =setDestination.getText();
											String d = time.getText();
											
											if(start.equals("")||des.equals("")||d.equals(""))
											{
												 JOptionPane.showMessageDialog(null, "Information NOT sufficient!",
														 "ERROR", JOptionPane.ERROR_MESSAGE);
											}
											else
											{
												String htmlFilePath = "/Users/zoujiaqi/Downloads/flights.html"; // path to your new file
												File htmlFile = new File(htmlFilePath);

												String htmlFilePath1 = "/Users/zoujiaqi/Downloads/hotel.html"; // path to your new file
												File htmlFile1 = new File(htmlFilePath1);
												try {
													Desktop.getDesktop().browse(htmlFile.toURI());
													Desktop.getDesktop().open(htmlFile);
												} catch (IOException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}

												// open the default web browser for the HTML page
												try {
													Desktop.getDesktop().browse(htmlFile1.toURI());
													Desktop.getDesktop().open(htmlFile1);
												} catch (IOException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}

											
												
												
												confirm.moveToFront();
												confirm.setVisible(true);
												confirm.setTitle("Confirmation Page");
												
												confirm.setMaximizable(true);
												confirm.setIconifiable(true);
												confirm.setResizable(true);
												confirm.setClosable(false);
												confirm.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
												
												confirm.setSize(500, 370);
											
												confirm.setBackground(Color.WHITE);
												
										
												
												 startingPlace1.setText("Starting Place:	     " + start);
												 destination1.setText("Destination:	          " +des);
												 date1.setText("Date:	" + d);
											
												
												

												
											}
										
											
										
										}
						    		  }
						    		  );
							
							
							
							setSTART.setBounds(500,370,200,30);
							setDestination.setBounds(500,400,200,30);
							


							
							intFrame.setVisible(true);
							frame.setVisible(true);
					
							
							
						
						}
					}
	    		  }
	    		  );
		
		
		savedTrip= new JButton(new ImageIcon("savedTrip.png"));
		savedTrip.setBounds(720, 9, 100, 21 );
		savedTrip.setVisible(true);
		contentPane.add( savedTrip );
		savedTrip.addMouseListener( 
				new MouseAdapter()
				{
				public void mouseEntered (MouseEvent me) { 
					setCursor (Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				}
				 public void mouseExited (MouseEvent me) { 
					 setCursor (Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				 }
				}
				 );
		savedTrip.addActionListener(
	    		  
	    		  new ActionListener()
	    		  {
	    			  public void actionPerformed( ActionEvent event)
	    			  {
	    				
	    				  signoutPerformed( event );
		
	    
	    			  }

					private void signoutPerformed(ActionEvent event) 
					{
						MasterClass.readtrip(name); 
						
						MasterClass.opensavedTrip();
					}
	    		  }
	    		  );
		
	
		
		rpsfinance= new JButton(new ImageIcon("rpsFinance.png"));
		rpsfinance.setBounds(120, 20, 125, 62 );
		rpsfinance.setVisible(true);
		contentPane.add( rpsfinance );
		rpsfinance.addMouseListener( 
				new MouseAdapter()
				{
				public void mouseEntered (MouseEvent me) { 
					setCursor (Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				}
				 public void mouseExited (MouseEvent me) { 
					 setCursor (Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				 }
				}
				 );
		
		rpsfinance.addActionListener(
	    		  
	    		  new ActionListener()
	    		  {
	    			  public void actionPerformed( ActionEvent event)
	    			  {
	    				
	    				  signoutPerformed( event );
		
	    
	    			  }

					private void signoutPerformed(ActionEvent event) 
					{
						AccountHomePage ahp = new AccountHomePage();
						AccountHomePage.getUserBasicInfo(name,email,phone,password,country,address,gender);
						ahp.setVisible(true);
						MasterClass.readBalance(name);
					}
	    		  }
	    		  );
		
		seperate= new JLabel(new ImageIcon("seperate.png"));
		seperate.setBounds(57, 0, 100, 104 );
		seperate.setVisible(true);
		contentPane.add( seperate );
		
		
		cal= new JButton(new ImageIcon("cal.png"));
		cal.setBounds(850, 1, 40, 40 );
		cal.setVisible(true);
		contentPane.add( cal );
		cal.addMouseListener( 
				new MouseAdapter()
				{
				public void mouseEntered (MouseEvent me) { 
					setCursor (Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				}
				 public void mouseExited (MouseEvent me) { 
					 setCursor (Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				 }
				}
				 );
		
		cal.addActionListener(
	    		  
	    		  new ActionListener()
	    		  {
	    			  public void actionPerformed( ActionEvent event)
	    			  {
	    				
	    				  calPerformed( event );
		
	    
	    			  }

					private void calPerformed(ActionEvent event) 
					{
							JFrame frame = new JFrame("TPS Calendar");
						//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								JCalendar jcalendar = new JCalendar();
								frame.getContentPane().add(jcalendar);
								frame.pack();
								frame.setVisible(true);
					}
	    		  }
	    		  );
		
		set= new JButton(new ImageIcon("set.png"));
		set.setBounds(1003, 1, 40, 40 );
		set.setVisible(true);
		contentPane.add( set );
		set.addMouseListener( 
				new MouseAdapter()
				{
				public void mouseEntered (MouseEvent me) { 
					setCursor (Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				}
				 public void mouseExited (MouseEvent me) { 
					 setCursor (Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				 }
				}
				 );
		
		set.addActionListener(
	    		  
	    		  new ActionListener()
	    		  {
	    			  public void actionPerformed( ActionEvent event)
	    			  {
	    				
	    				  setPerformed( event );
		
	    
	    			  }

					private void setPerformed(ActionEvent event) 
					{
						
						 EditUserInfo eui = new EditUserInfo();
						 eui.setVisible(true);
				    	 eui.EditUserInfo(name,email,password,phone,address,gender,country);
				         setVisible(false);
					}
	    		  }
	    		  );
		
		
		itinerary= new JButton(new ImageIcon("itinerary.png"));
		itinerary.setBounds(950, 1, 40, 40 );
		itinerary.setVisible(true);
		contentPane.add( itinerary );
		itinerary.addMouseListener( 
				new MouseAdapter()
				{
				public void mouseEntered (MouseEvent me) { 
					setCursor (Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				}
				 public void mouseExited (MouseEvent me) { 
					 setCursor (Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				 }
				}
				 );
		
		itinerary.addActionListener(
	    		  
	    		  new ActionListener()
	    		  {
	    			  public void actionPerformed( ActionEvent event)
	    			  {
	    				
	    				  itineraryPerformed( event );
		
	    
	    			  }

					private void itineraryPerformed(ActionEvent event) 
					{
						NotePad notepad = new NotePad();
						notepad.setVisible(true);
					}
	    		  }
	    		  );
		
		
		
		map= new JButton(new ImageIcon("maps_icon.png"));
		map.setBounds(903, 8, 35, 30 );
		map.setVisible(true);
		contentPane.add( map );
		map.addMouseListener( 
				new MouseAdapter()
				{
				public void mouseEntered (MouseEvent me) { 
					setCursor (Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				}
				 public void mouseExited (MouseEvent me) { 
					 setCursor (Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				 }
				}
				 );
		
		map.addActionListener(
	    		  
	    		  new ActionListener()
	    		  {
	    			  public void actionPerformed( ActionEvent event)
	    			  {
	    				
	    				  mapPerformed( event );
		
	    
	    			  }

					private void mapPerformed(ActionEvent event) 
					{
					MasterClass.openMap();
					}
	    		  }
	
	    		  );
		
		mapJLabel= new JLabel(new ImageIcon("maps_icon.png"));
		mapJLabel.setBounds(900, 1, 40, 43 );
		mapJLabel.setVisible(true);
		contentPane.add( mapJLabel );
		
		signout= new JButton(new ImageIcon("SignOut.png"));
		signout.setBounds(1056, 3, 100, 33 );
		signout.setVisible(true);
		contentPane.add( signout );
		signout.addMouseListener( 
				new MouseAdapter()
				{
				public void mouseEntered (MouseEvent me) { 
					setCursor (Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				}
				 public void mouseExited (MouseEvent me) { 
					 setCursor (Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				 }
				}
				 );
		
		signout.addActionListener(
	    		  
	    		  new ActionListener()
	    		  {
	    			  public void actionPerformed( ActionEvent event)
	    			  {
	    				
	    				  signoutPerformed( event );
		
	    
	    			  }

					private void signoutPerformed(ActionEvent event) 
					{
						
					
						LogoutScreen = new LogoutScreen();
						LogoutScreen.setSize(640, 480);
						LogoutScreen.setLocationRelativeTo(null);
						LogoutScreen.setVisible(true);
						dispose();
						MasterClass.getAllInfo(name,email,password,phone,address,gender,country);
						//MasterClass.writeInfo();
					}
		
	    		  }
	);
		signoutJLabel= new JLabel(new ImageIcon("SignOut.png"));
		signoutJLabel.setBounds(1037, -3, 138, 44 );
		signoutJLabel.setVisible(true);
		contentPane.add( signoutJLabel );
		
		userPhoto = new JLabel();
		userPhoto.setIcon(new ImageIcon("4623.png"));
		userPhoto.setBounds( 55, 110, 200, 200 );
		contentPane.add(userPhoto);
	
		
		
		bar= new JLabel(new ImageIcon("QQ20130503-4.png"));
		bar.setBounds(0, 0, 1250, 40 );
		bar.setVisible(true);
		contentPane.add( bar );
		
		back= new JLabel(new ImageIcon("colored3.jpg"));
		back.setBounds(0, 0, 1170, 700 );
		back.setVisible(true);
		contentPane.add( back );
		
		
	
		

		
		
		//window stuff
		setVisible(true);
		setSize(1170,700);
		setTitle("Home Page");
		setResizable(false);


			
				
		

		
		
	}

	public void mouseClicked (MouseEvent me) {

		  // Save the coordinates of the click lke this. 
		  xpos = me.getX(); 
		  ypos = me.getY();

		  // Check if the click was inside the rectangle area. 
		  if (xpos > rect1xco && xpos < rect1xco+rect1width && ypos >rect1yco &&  
		    ypos < rect1yco+rect1height)  rect1Clicked = true; 
		  // if it was not then rect1Clicked is false; 
		  else  
		   rect1Clicked = false; 
		  //show the results of the click 
		  repaint();
		  System.out.println(xpos+","+ypos);

		 }
	
	

	

	
}


