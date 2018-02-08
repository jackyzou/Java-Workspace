import java.awt.Desktop;
import java.io.File;
import java.io.IOException;


public class url2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	

		String htmlFilePath = "/Users/zoujiaqi/Downloads/flights.html"; // path to your new file
		File htmlFile = new File(htmlFilePath);

		// open the default web browser for the HTML page
		try {
			Desktop.getDesktop().browse(htmlFile.toURI());
			Desktop.getDesktop().open(htmlFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// if a web browser is the default HTML handler, this might work too
	
	}

}
