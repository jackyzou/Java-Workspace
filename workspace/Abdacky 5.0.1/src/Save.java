import java.util.Scanner;
import java.io.*;
import java.text.NumberFormat;     //class for numeric formatting
import java.util.Locale;	       //class for country-specific information
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Save
{
	public static void main(String[] args) throws IOException
	{
		double amount,		//amount of deposit at end of each year
			   principal,	//initial amount before interest
			   rate;		//rate of interest
		String input;

		//create NumberFormat for currency in US dollar format
		NumberFormat moneyFormat = NumberFormat.getCurrencyInstance( Locale.US );

    	//create keyboard
    	Scanner keyboard = new Scanner(System.in);

    	//create JTextArea to display output
    	JTextArea outputTextArea = new JTextArea();

    	input = JOptionPane.showInputDialog("Please enter Principal: ");
    	principal = Double.parseDouble(input);

    	input = JOptionPane.showInputDialog("Please enter Interest Rate (Format: 0.00) ");
    	rate = Double.parseDouble(input);

    	//set first line to display output
    	outputTextArea.setText("Year\tAmount on deposit\n");

		//open new file
    	FileWriter fwriter = new FileWriter("MyMoneys.txt", true);
    	PrintWriter outputFile = new PrintWriter(fwriter);

    	//calculate amount on deposit for each of ten years
    	for (int year = 1; year<= 10; year++)
    	{
    		amount = principal * Math.pow(1.0 + rate, year);

			// append one line of text to outputTextArea
			outputTextArea.append( year + "\t" +
			moneyFormat.format(amount) + "\n");
    	}// end for

    	//close file
    	outputFile.close();
    	System.out.println("Data written to file");

    	//display results
    	JOptionPane.showMessageDialog(null, outputTextArea,
			"Compound Interest", JOptionPane.INFORMATION_MESSAGE);

    	System.exit(0);  //terminate the application

    }//end of main

}//end of Interest3.java
