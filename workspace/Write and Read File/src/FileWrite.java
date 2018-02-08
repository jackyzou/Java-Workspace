import java.io.*;//io = input output
class FileWrite 
{
 public static void main(String args[])
 {
  	try
  	{
  		// Create file 
  		FileWriter fstream = new FileWriter("out.txt");
  		BufferedWriter out = new BufferedWriter(fstream);
  		out.write("Hello,Java \n");
  		out.write("Next Line \n");
  		out.write("Next Next Line");
  		
  		out.close();  //Close the output stream
   }
  
  catch (Exception e) //Catch exception if any
  {
  	System.err.println("Error: " + e.getMessage());
  }
  
  }// end main
  
}// end class FileWrite



