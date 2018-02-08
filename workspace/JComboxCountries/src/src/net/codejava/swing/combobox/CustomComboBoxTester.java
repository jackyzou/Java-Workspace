package src.net.codejava.swing.combobox;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class CustomComboBoxTester extends JFrame {
	
	public CustomComboBoxTester() {
		super("Demo program for custom combobox");
		setLayout(new FlowLayout());
		
		CountryComboBox customCombobox = new CountryComboBox();
		customCombobox.setPreferredSize(new Dimension(120, 30));
		customCombobox.setEditable(true);
		customCombobox.addItems(countryList);
		
		add(customCombobox);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 100);
		setLocationRelativeTo(null);	// center on screen
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new CustomComboBoxTester().setVisible(true);
			}
		});
	}

	private String[][] countryList = {{"USA", "us.png"},
									  {"India", "in.png"},
									  {"Vietnam", "vn.png"},
									  {"Germany", "de.png"},
									  {"Canada", "ca.png"},
									  {"Japan", "jp.png"},
									  {"Great Britain", "gb.png"},
									  {"France", "fr.png"}};
}