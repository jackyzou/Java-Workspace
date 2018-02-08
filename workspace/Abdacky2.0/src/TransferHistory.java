import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.TitledBorder;
public class TransferHistory extends JFrame{

	private Container contentPane;//object
	private JPanel hisPanel;
	private JTextArea JTextArea;
	
	public TransferHistory()
	{
		createUserInterface();//this is method
	}
	public void setHistory(double amount, String date)
	{
		JTextArea.append(String.valueOf(amount) + "         " + date);
	}

	private void createUserInterface() {
		contentPane = getContentPane();
		contentPane.setLayout(null);
		
		hisPanel = new JPanel();
		hisPanel.setLayout( null );
		hisPanel.setBounds( 1, 5, 500, 300 );
		hisPanel.setBorder( 
	         new TitledBorder( "Transfer History" ) );
	      contentPane.add( hisPanel );
	
	      JTextArea= new JTextArea ();
	      JTextArea.setLineWrap(true);
	      JScrollPane scroller = new JScrollPane(JTextArea);
	      scroller.setBounds( 10, 25,470, 270 );
	      JTextArea.setEditable(true);
	      JTextArea.append("This is the History");
	      scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	  
	      contentPane.add(scroller, BorderLayout.CENTER);
	     
		
	setVisible(true);
	setSize(500,340);
	setTitle("TransferHistory");
	setLocationRelativeTo(null);
	}

}
