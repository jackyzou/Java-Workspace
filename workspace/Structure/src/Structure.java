// Tutorial ^0^: Structure.java
// Calculates the number of items in a shipment based on the number
// of cartons received and the number of items per carton.
import java.awt.*;
import java.awt.event.*;
import java.io.File;
 
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
 
public class Structure extends JFrame
{
   private static final int CENTER = 0;
// JLabel and JTextField for cartons per shipment
 
   private JTextField EnterJTextField;
      private JTextField iJTextField;
      private JTextField iiJTextField;
 
   // JLabel and JTextField for items per carton
 
  
   // JLabel and JTextField for total items per shipment
 
   private JTextField ResultJTextField;
 
   // JButton to initiate calculation of total items per shipment
   private JButton calculateJButton;
   private JButton helpJButton;
     private JButton LastJButton;
 
   //+++++++++++++++++++++++++++++++++++++++++++++++++++++++
   public void playSound(String soundName)
   {
     try
     {
      AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile( ));
      Clip clip = AudioSystem.getClip( );
      clip.open(audioInputStream);
      clip.start( );
     }
     catch(Exception ex)
     {
       System.out.println("Error with playing sound.");
       ex.printStackTrace( );
     }
   }
   //+++++++++++++++++++++++++++++++++++++++++++++++++++++++
  
   // no-argument constructor
   public Structure()
   {
      createUserInterface();
   }
 
   // create and position GUI components; register event handlers
   public void createUserInterface()
   {
      // get content pane and set layout to null
      Container contentPane = getContentPane();
      contentPane.setLayout( null );
 
     //HELPHELPHELPHELPHELPHELPHELHPHEHLPEHLEPHLPEHLPELHPELHPEHLPEHLPEHPEHLPHELPHELPHELPHELHP
      helpJButton = new JButton();
      helpJButton.setText("Help");
      helpJButton.setBounds(450, 70, 100, 20);
      contentPane.add( helpJButton );
      helpJButton.addActionListener(
             
              new ActionListener()
              {
                  public void actionPerformed(ActionEvent event)
                  {
                     
                      playSound("help.wav");
                     
                      JOptionPane.showMessageDialog(null,"Please submit your grade and press enter.");
                     
                     
 
                  }
             
              }
             
             
             
              );
      //////////////////////////////////////////////////////////////////////////
     
      //++++++++++++++++++++++++++++++++++++++++++++
      EnterJTextField = new JTextField("Please submit score here");
      EnterJTextField.setBounds(200, 40, 200, 20);
      EnterJTextField.setEditable(true);
      EnterJTextField.setHorizontalAlignment(CENTER);
      contentPane.add( EnterJTextField );
      EnterJTextField.addMouseListener(new MouseAdapter(){
          public void mouseClicked(MouseEvent e){
              EnterJTextField.setText("");
              ResultJTextField.setText("Result will be here");
 
          }
          });
      EnterJTextField.addKeyListener(
                          
                           new KeyAdapter()
                           {
                               public void keyPressed(KeyEvent event)
                               {
                                  ResultJTextField.setText("Result will be here");
                               }
                          }
                          
                           );
     
      //++++++++++++++++++++++++++++++++++++++++++
     
      // set up totalResultJTextField
      ResultJTextField = new JTextField("Result will be here");
      ResultJTextField.setBounds(200, 70, 200, 20);
      ResultJTextField.setEditable(false);
      ResultJTextField.setHorizontalAlignment(CENTER);
      contentPane.add( ResultJTextField );
     
      //()()()()()()()()()()()()()((()(()()()()()()())()()()()()()(
        iJTextField = new JTextField("");
        iJTextField.setBounds(1000, 70, 200, 20);
        iJTextField.setEditable(false);
        iJTextField.setVisible(false);
        iJTextField.setHorizontalAlignment(CENTER);
         contentPane.add( iJTextField );
      //)()()()()()()()()()()(()()())()(()(()()()()()()()()()()()()
          iiJTextField = new JTextField("");
          iiJTextField.setBounds(1000, 90, 200, 20);
         iiJTextField.setEditable(false);
         iiJTextField.setVisible(false);
         iiJTextField.setHorizontalAlignment(CENTER);
          contentPane.add( iiJTextField );
                                                                        //I put a Last button if you forget your last input
      //------last last last------
         LastJButton = new JButton();
        LastJButton.setText("Last Entered");
        LastJButton.setBounds(200, 150, 200, 20);
        contentPane.add( LastJButton );
         LastJButton.addActionListener(
                
                new ActionListener()
                        {
                    public void actionPerformed(ActionEvent event)
                    {
                        int i = Integer.parseInt(iJTextField.getText());
                    String ii = (iiJTextField.getText());
                    ResultJTextField.setText(String.valueOf(ii));
                        EnterJTextField.setText(String.valueOf(i));
                }
                }
            );
      //------last last last------
 
     
      // set up calculateJButton
      calculateJButton = new JButton();
      calculateJButton.setText("Enter");
      calculateJButton.setBounds(200, 110, 200, 20);
      contentPane.add( calculateJButton );
      calculateJButton.addActionListener(
             
              new ActionListener()
              {
                  public void actionPerformed(ActionEvent event)
                  {
                      try
                      {
                                
                          int Enter = Integer.parseInt(EnterJTextField.getText());
                         
                         
                          if(Enter <= 100)
                          {
                          if( Enter>= 0)
 
                          {
 
                            if(Enter>=90)//90
                            {
                                playSound("100.wav");
                                ResultJTextField.setText("A");
                                     String lastr = ResultJTextField.getText();
                                   int laste = Integer.parseInt(EnterJTextField.getText());
                                   iiJTextField.setText(String.valueOf(lastr));
                                    iJTextField.setText(String.valueOf(laste));
                            }
                           
                            else//80
                            {
                            if(Enter>= 80)//80
                            {
                                ResultJTextField.setText("B");
                                String lastr = ResultJTextField.getText();
                                int laste = Integer.parseInt(EnterJTextField.getText());
                                iiJTextField.setText(String.valueOf(lastr));
                                 iJTextField.setText(String.valueOf(laste));
                            }
                            else//70
                            {
                                if(Enter>= 70)//70
                                {
                                    ResultJTextField.setText("C");
                                    String lastr = ResultJTextField.getText();
                                    int laste = Integer.parseInt(EnterJTextField.getText());
                                    iiJTextField.setText(String.valueOf(lastr));
                                     iJTextField.setText(String.valueOf(laste));
                                }
                                else//60
                                {
                                    if(Enter>= 60)//60
                                    {
                                        playSound("60.wav");
                                        ResultJTextField.setText("D");
                                        String lastr = ResultJTextField.getText();
                                        int laste = Integer.parseInt(EnterJTextField.getText());
                                        iiJTextField.setText(String.valueOf(lastr));
                                         iJTextField.setText(String.valueOf(laste));
                                    }
                                    else//60
                                    {
                                        if(Enter<= 60)//60elow
                                        {
                                            playSound("60.wav");
                                            ResultJTextField.setText("F");
                                            String lastr = ResultJTextField.getText();
                                            int laste = Integer.parseInt(EnterJTextField.getText());
                                            iiJTextField.setText(String.valueOf(lastr));
                                             iJTextField.setText(String.valueOf(laste));
                                        }
                                       
                                    }
                                }
                            }
                            }
 
 
                          }
 
                          else
 
                          {
 
                              playSound("error.wav");
                              JOptionPane.showMessageDialog(null,"Please enter Positive Integers","ERROR",
                                     
                                      JOptionPane.ERROR_MESSAGE);
                              EnterJTextField.setText("");
                          }
                          }
                          else
                          {
                              playSound("error.wav");
                              JOptionPane.showMessageDialog(null,"Please enter Integers below 100","ERROR",
                                     
                                      JOptionPane.ERROR_MESSAGE);
                              EnterJTextField.setText("");
                          }
 
 
                     
                     
                      }//syntax error will pick it up before i start
                      //syntax error- this code will not run there should be uppercase
                      catch(Exception e)
                      {
                          playSound("b.wav");
                          JOptionPane.showMessageDialog(null,"Please enter Integers","ERROR",
                                 
                                  JOptionPane.ERROR_MESSAGE);
                          EnterJTextField.setText("");
 
                      }
                     
                     
                      //logic error runs BUT NOT quite right
                  }
             
              }
             
              );
 
      // set properties of application window
      setTitle( "Structure" ); // set title bar text
      setSize( 650, 300 );     // set window size
      setVisible( true );      // display window
 
   } // end method createUserInterface
 
   // main method
   public static void main( String[] args )
   {
      Structure application = new Structure();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
 
   } // end method main
 
} // end class Structure
 
 
/**************************************************************************
  *                                                                       By Justin                                                           *
  **************************************************************************/