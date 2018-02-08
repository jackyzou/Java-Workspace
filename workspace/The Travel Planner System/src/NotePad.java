import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.io.*;

public class NotePad extends JFrame implements ActionListener {
	private TextArea textArea = new TextArea("", 0,0, TextArea.SCROLLBARS_VERTICAL_ONLY);
	private MenuBar menuBar = new MenuBar(); 
	private Menu file = new Menu();  
	private MenuItem openFile = new MenuItem();   
	private MenuItem saveFile = new MenuItem();  
	private MenuItem close = new MenuItem();  
	Font lostFont = new Font("Tahoma", Font.ITALIC, 14);
	
	public NotePad() {
		this.setSize(600, 500);  
		this.setLocationRelativeTo(getRootPane());
		this.setTitle("Your Itinerary");  

		this.textArea.setFont(new Font("Century Gothic", Font.BOLD, 12));   
		
		this.textArea.addFocusListener(new FocusAdapter() 
		{  
	    	   
	        
	         public void focusGained(FocusEvent e) 
	         {  
	        	
	        	 if (textArea.getText().equals("")||textArea.getText().equals("To write down your amazing journey here!")) {  
	        		 textArea.setText("");
	               } 
	        	 else
	        	 {
	        		
	        		 textArea.setForeground(Color.BLACK);  
	        	 }
	         }
	         public void focusLost(FocusEvent e) 
	         {  
	        
	        	 
	        	 if ( textArea.getText().equals("")) {  
	        		 textArea.append("To write down your amazing journey here!");
	        		 textArea.setFont(lostFont);
	        		 textArea.setForeground(Color.GRAY);  
	               } else {  
	            	 
	               }  
	         }
	         
		}      
	);
	
		this.getContentPane().setLayout(new BorderLayout()); // the BorderLayout bit makes it fill it automatically
		this.getContentPane().add(textArea);

		 
		this.setMenuBar(menuBar);
		this.menuBar.add(file); 
		this.file.setLabel("File");
		
		this.openFile.setLabel("Open(.txt)");  
		this.openFile.addActionListener(this);  
		this.openFile.setShortcut(new MenuShortcut(KeyEvent.VK_O, false));  
		this.file.add(this.openFile); 
		// and the save...
		this.saveFile.setLabel("Save");
		this.saveFile.addActionListener(this);
		this.saveFile.setShortcut(new MenuShortcut(KeyEvent.VK_S, false));
		this.file.add(this.saveFile);
		
	
		this.close.setLabel("Close");

		this.close.setShortcut(new MenuShortcut(KeyEvent.VK_F4, false));
		this.close.addActionListener(this);
		this.file.add(this.close);
	}
	
	public void actionPerformed (ActionEvent e) {
	
		if (e.getSource() == this.close)
		{
			int k = JOptionPane.showConfirmDialog(null, 
    				" Are you sure you close your Itinerary? "
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
 			this.dispose(); 
 			System.out.print("Yes");
 			
 		}
			
		}
	
		else if (e.getSource() == this.openFile) {
			JFileChooser open = new JFileChooser();  
			int option = open.showOpenDialog(this); 
			 
			if (option == JFileChooser.APPROVE_OPTION) {
				this.textArea.setText("");  
				try {
					 
					Scanner scan = new Scanner(new FileReader(open.getSelectedFile().getPath()));
					while (scan.hasNext())  
						this.textArea.append(scan.nextLine() + "\n");  
				} catch (Exception ex) {  
				 
					System.out.println(ex.getMessage());
				}
			}
		}
		
		 
		else if (e.getSource() == this.saveFile) {
			JFileChooser save = new JFileChooser();   
			int option = save.showSaveDialog(this);  
			 
			if (option == JFileChooser.APPROVE_OPTION) {
				try {
					// create a buffered writer to write to a file
					BufferedWriter out = new BufferedWriter(new FileWriter(save.getSelectedFile().getPath()));
					out.write(this.textArea.getText()); // write the contents of the TextArea to the file
					out.close(); // close the file stream
				} catch (Exception ex) { // again, catch any exceptions and...
					// ...write to the debug console
					System.out.println(ex.getMessage());
				}
			}
		}
	}
	
    
    public static void main(String args[]) {
        NotePad app = new NotePad();
        app.setVisible(true);
}
}