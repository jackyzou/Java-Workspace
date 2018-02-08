public static void writeFile(String canonicalFilename, String text) 
throws IOException
{
  File file = new File (canonicalFilename);
  BufferedWriter out = new BufferedWriter(new FileWriter(file)); 
  out.write(text);
  out.close();
}
public static void writeFileAsBytes(String fullPath, byte[] bytes) throws IOException
{
  OutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fullPath));
  InputStream inputStream = new ByteArrayInputStream(bytes);
  int token = -1;

  while((token = inputStream.read()) != -1)
  {
    bufferedOutputStream.write(token);
  }
  bufferedOutputStream.flush();
  bufferedOutputStream.close();
  inputStream.close();
}