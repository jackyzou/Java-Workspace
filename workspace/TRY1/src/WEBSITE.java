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
    int beginIx = buf.indexOf("��ѯ���[");  
    int endIx = buf.indexOf("��������������ʾ����");  
    String result = buf.substring(beginIx, endIx);  
    System.out.println("captureHtml()�Ľ����\n" + result);  
}  