public void WEBSITE(String ip) throws Exception {  
    String strURL = "http://ip.chinaz.com/?IP=" + ip;  
    URL url = new URL(strURL);  
    HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();  
    InputStreamReader input = new InputStreamReader(httpConn  
            .getInputStream(), "utf-8");  
    BufferedReader bufReader = new BufferedReader(input);  
    String line = "";  
    StringBuilder contentBuf = new StringBuilder();  
    while ((line = bufReader.readLine()) != null) {  
        contentBuf.append(line);  
    }  
    String buf = contentBuf.toString();  
    int beginIx = buf.indexOf("查询结果[");  
    int endIx = buf.indexOf("上面四项依次显示的是");  
    String result = buf.substring(beginIx, endIx);  
    System.out.println("captureHtml()的结果：\n" + result);  
}  