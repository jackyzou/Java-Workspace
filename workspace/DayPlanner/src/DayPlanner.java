import java.awt.*;                  
import java.awt.event.*;            
import javax.swing.*;               
import javax.swing.event.*;

public class DayPlanner extends JFrame implements ActionListener {

   // GUI components

   private JTextArea display;
   private JComboBox year, month, day, time;
   private JButton   query;
   private JPanel panel1, panel2;
   private DOMPlanner handler;

   public DayPlanner() {

      super( "DOM-Based Travel Planner" );

      // Set the output font      

      Font font = new Font( "Monospaced", java.awt.Font.BOLD, 16 );
      display   = new JTextArea();
      display.setFont( font );
      display.setEditable( false );
      
      handler = new DOMPlanner( display );

      // Initialize the user interface components    

      year = new JComboBox( handler.getYears() );

      String months[] = new String[ 13 ];
      months[ 0 ]     = "ANY";

      for ( int i = 1; i < 13; i++ )
         months[ i ] = Integer.toString( i );

      month = new JComboBox( months );

      String days[] = new String[ 32 ];
      days[ 0 ] = "ANY";

      for ( int i = 1; i < 32; i++ )
         days[ i ] = Integer.toString( i );

      day = new JComboBox( days );

      String times[] = {      "ANY",
                          "Morning",
                        "Afternoon",
                          "Evening",
                            "Night" };

      time = new JComboBox( times );

      // Create "Get Schedules" button and attach listener.

      query = new JButton( "Get Schedules" );
      query.addActionListener( this );

      // Panel containing components for querying

      panel1 = new JPanel();
      panel1.setLayout( new GridLayout( 4, 2 ) );
      panel1.add( new JLabel( "Year" ) ); 
      panel1.add( year );
      panel1.add( new JLabel( "Month" ) ); 
      panel1.add( month );
      panel1.add( new JLabel( "Day" ) ); 
      panel1.add( day );
      panel1.add( new JLabel("Time") ); 
      panel1.add( time );

      // Panel containing text area for output
      // and panel2 containing other GUI components.

      panel2 = new JPanel();
      panel2.setLayout( new GridLayout( 1, 2 ) );
      panel2.add( panel1 );      
      panel2.add( query );      

      // Arrange panels on content pane using border layout.....

      Container c = getContentPane();
      c.setLayout( new BorderLayout() ); 
      c.add( new JScrollPane( display ), BorderLayout.CENTER );
      c.add( panel2, BorderLayout.SOUTH );

      // Size and display frame....

      setSize( 700, 450 );
      show();
   }

   // Method executed when query button is pressed

   public void actionPerformed( ActionEvent e ) {

      if ( e.getSource() == query ) {
         int yearIndex, monthIndex, dayIndex, timeIndex;

         // Get the integer values of all the query parameters

         yearIndex  = getIntegerValue( ( String ) year.getSelectedItem() );
         monthIndex = getIntegerValue( ( String ) month.getSelectedItem() );
         dayIndex   = getIntegerValue( ( String ) day.getSelectedItem() );
         timeIndex  = time.getSelectedIndex() - 1;

         // Get the result of query

         handler.getQueryResult( yearIndex, monthIndex,
                                 dayIndex, timeIndex );
      }
   }

   // Method to convert the string value to integer

   public int getIntegerValue( String str ) {

      // If the value 'ANY' is selected, return -1

      if ( str.equals( "ANY" ) )
         return -1;
      else
         return Integer.parseInt( str );

   }

   // Main method for Day Planner application.....

   public static void main( String s[] ) {

      // Create instance of DayPlanner().....

      DayPlanner d = new DayPlanner();

      // Setup (inner class) listener to close window.....

      d.addWindowListener(
         new WindowAdapter() {
            public void windowClosing( WindowEvent e ) {
               System.exit( 0 );
            }
         }
      );
   }
}