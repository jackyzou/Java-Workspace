import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class CrossNoughtsGame {
	
	private JFrame frame;
	private JPanel mainPanel;
	private ArrayList<CNButton> buttonList = new ArrayList<CNButton>();
	private boolean isX = true;
	private int moveCount = 0;
	private int dimension = 3;
	
	public void setupGame() {
		// Initialize Game GUI
		frame = new JFrame("Tic-Tac-Toe Game - Warning! Alpha Prototype");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GridLayout grid = new GridLayout(dimension, dimension, 0, 0);
		mainPanel = new JPanel(grid);
		//mainPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		for (int x = 0 ; x < dimension; x++ ) {
			for (int y = 0 ; y < dimension; y++ ) {
				CNButton tempButton = new CNButton(x, y);
				tempButton.addActionListener(new clickListener());
				//tempButton.setPreferredSize(new Dimension(25,25));
				
				buttonList.add(tempButton);
				mainPanel.add(tempButton);
			}
		}
		
		frame.getContentPane().add(mainPanel);
		
		frame.setSize(300,300);
		frame.setVisible(true);
	}
	
	public boolean isGameOver() {
		// Checks state of all CNButton elements to see if game is over. Prints appropriate message
		return true;
	}
	
	private class clickListener implements ActionListener {
		// Listener Class for callback from CNButton elements
		// Sets state of button correctly, displays X or O
		
		public void actionPerformed(ActionEvent e) {
			
			CNButton clickedButton = (CNButton) e.getSource(); // Source Button that fired event
			System.out.println("Button Co-ordinates: " + clickedButton.getX() + ", " + clickedButton.getY());
			if (clickedButton.getValue() == 0) {
				if ( isX ) {
					clickedButton.setText("X");
					clickedButton.setValue(1);
				} else {
					clickedButton.setText("O");
					clickedButton.setValue(-1);
				}
				moveCount++;
				isX = !isX;
				clickedButton.setEnabled(false); // Disable button from future clicks
				
				isGameOver();
			}
		}
		
	}
	
	public static void main(String [] args) {
		CrossNoughtsGame GameGUI = new CrossNoughtsGame();
		GameGUI.setupGame();
	}

}

