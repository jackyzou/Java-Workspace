import java.io.*;
class FileWrite 
{
 public static void main(String args[])
  {
  try{
  // Create file 
  FileWriter fstream = new FileWriter("1234.txt");
  BufferedWriter out = new BufferedWriter(fstream);
  out.write("Java fuck you ×æ×ÚÊ®°Ë´ú");
  System.out.println(fstream);
  //Close the output stream
  out.close();
  }catch (Exception e){//Catch exception if any
  System.err.println("Error: " + e.getMessage());
  }
  }
}
