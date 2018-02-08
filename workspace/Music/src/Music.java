/*
	 * This program was created to play different types of music files.
	 * According to Java 2, the AudioClip object can play the following 
	 * types of audio files
	 * AU, AIFF, WAV, and MIDI
	 */

	/**
	 *
	 * @author Mr. Lake
	 */

	import java.applet.AudioClip;
	import javax.swing.JApplet;
	import java.net.URL;
	import java.util.*;
	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.*;



	public class Music extends JFrame
	{

	    /**
	     * @param args the command line arguments
	     */
	    URL musicURL;
	    
	    AudioClip music;
	    
	    JButton playJButton, stopJButton;
	
	    JLabel radioJLabel, playingMusicJLabel;
	    
	    String musicList[] = {"file:a.wav","file:Carry On.wav"};
	    
	    JComboBox musicSelection;
	    
	  
	    
	    public Music()
	    {
	           createUserInterface();
	               
	    }
	    
	    
	    
	    private void createUserInterface()
	    {
	        Container contentPane = getContentPane();
	        contentPane.setLayout(null);
	        contentPane.setBackground(Color.yellow);
	        
	        musicSelection = new JComboBox(musicList);
	        musicSelection.setBounds( 136, 200, 135, 21 );
	        musicSelection.setMaximumRowCount( 5 );
	        musicSelection.addActionListener(
	        		new ActionListener()
	        		{
	        			public void actionPerformed(ActionEvent e)
	        			{
	        					        			
	        			}
	        		}
	        		
	        
	        );
	        contentPane.add( musicSelection );
	        
	        playJButton = new JButton("Play");
	        playJButton.setBounds(75, 400, 80, 50);
	        contentPane.add(playJButton);
	        playJButton.addActionListener(
	                
	                new ActionListener()
	                {
	                    public void actionPerformed(ActionEvent e)
	                    {
	                    	playSelectedSong(e);
  
	                    }
	            
	                }
	                
	                
	                );
	        
	        stopJButton = new JButton("Stop");
	        stopJButton.setBounds(250, 400, 80, 50);
	        contentPane.add(stopJButton);
	        stopJButton.addActionListener(
	                
	                new ActionListener()
	                {
	                    public void actionPerformed(ActionEvent e)
	                    {
	                       stop(e);
	                    }
	            
	                }
	                
	                
	                );
	        
	       
	        
	        setTitle("Radio");
	        setSize(400, 600);
	        setVisible(true);
	        
	        
	      
	        
	    }
	    
	    
	   
	    public void playSelectedSong(ActionEvent e)
	    {
	    	try
	    	{
	    		int index = musicSelection.getSelectedIndex();
		    	String value = musicList[index];
	            musicURL = new URL(value);
                music = JApplet.newAudioClip(musicURL);
                if (music != null)
 	               music.loop();   // There is also a method called play()
 	        	 
 	                else
 	                    System.out.println("Did not find the music file!");
	    		
	    	}
	    	catch(Exception ecp)
	    	{
	    		
	    	}
	    	
	    	
	    }
	    
	    // method play stops an AudioClip object
	    public void stop(ActionEvent event)
	    {
	        music.stop();
	    }
	    
	    public static void main(String[] args)
	    {
	       
	        
	    	Music musicObject = new Music();
	        
	        musicObject.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	        
	       
	    }

	}

