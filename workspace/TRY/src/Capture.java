import java.net.* ; 
import java.io.* ; 
import java.util.regex.* ; 
public class Capture{ 
    public static void main(String args[])throws Exception{ 
        System.out.println("*************************手机号查询************************") ; 

        System.out.println("手机卡类型是：" + new GrabMobile().grabMobileType("15023141745")) ; 
        System.out.println("我的邮编是：" + new GrabMobile().grabMobilePost("15023141745")) ; 
        System.out.println("*************************身份证查询************************") ; 
        System.out.println("我的性别是：" + new GrabIdentity().grabIdentitySex("362203199208243575")) ; 
        System.out.println("我的生日是：" + new GrabIdentity().grabIdentityBirth("440305197803293414")) ; 
        System.out.println("我的家乡是：" + new GrabIdentity().grabIdentityHome("362203199208243575")) ; 
    } 
} 
class GrabMobile{ 
    public String grabMobileLocation(String m)throws Exception{ 
        String strUrl = "http://www.ip138.com:8080/search.asp?action=mobile&mobile=" + m; 
        URL url = new URL(strUrl) ; 
        HttpURLConnection httpUrlCon = (HttpURLConnection)url.openConnection() ; 
        InputStreamReader inRead = new InputStreamReader(httpUrlCon.getInputStream(),"GBK") ; 
        BufferedReader bufRead = new BufferedReader(inRead) ; 
        StringBuffer strBuf = new StringBuffer() ; 
        String line = "" ; 
        while ((line = bufRead.readLine()) != null) { 
            strBuf.append(line); 
        } 
        String strStart = "卡号归属地" ; 
        String strEnd = "卡 类 型"; 
        String strAll = strBuf.toString() ; 
         
        int start = strAll.indexOf(strStart) ; 
         
        int end = strAll.indexOf(strEnd) ; 
         
        String result = strAll.substring(start+42,end-33) ; 
        result = drawChMob(result) ; 
        return result ; 
    } 
    public String grabMobileType(String m)throws Exception{ 
        String strUrl = "http://www.ip138.com:8080/search.asp?action=mobile&mobile=" + m; 
        URL url = new URL(strUrl) ; 
        HttpURLConnection httpUrlCon = (HttpURLConnection)url.openConnection() ; 
        InputStreamReader inRead = new InputStreamReader(httpUrlCon.getInputStream(),"GBK") ; 
        BufferedReader bufRead = new BufferedReader(inRead) ; 
        StringBuffer strBuf = new StringBuffer() ; 
        String line = "" ; 
        while ((line = bufRead.readLine()) != null) { 
            strBuf.append(line); 
        } 
        String strStart = "卡 类 型" ; 
        String strEnd = "<TD align=\"center\">区 号</TD>"; 
        String strAll = strBuf.toString() ; 
         
        int start = strAll.indexOf(strStart) ; 
         
        int end = strAll.indexOf(strEnd) ; 
         
        String result = strAll.substring(start+12,end) ; 
        result = drawChMob(result) ; 
        result = result.substring(1) ; 
        return result ; 
    } 
    public String grabMobilePost(String m)throws Exception{ 
        String strUrl = "http://www.ip138.com:8080/search.asp?action=mobile&mobile=" + m; 
        URL url = new URL(strUrl) ; 
        HttpURLConnection httpUrlCon = (HttpURLConnection)url.openConnection() ; 
        InputStreamReader inRead = new InputStreamReader(httpUrlCon.getInputStream(),"GBK") ; 
        BufferedReader bufRead = new BufferedReader(inRead) ; 
        StringBuffer strBuf = new StringBuffer() ; 
        String line = "" ; 
        while ((line = bufRead.readLine()) != null) { 
            strBuf.append(line); 
        } 
        String strStart = "邮 编" ; 
        String strEnd = "更详细的.."; 
        String strAll = strBuf.toString() ; 
         
        int start = strAll.indexOf(strStart) ; 
         
        int end = strAll.indexOf(strEnd) ; 
         
        String result = strAll.substring(start+40,end-55) ; 
        return result ; 
    } 
    public String drawChMob(String str){ 
        StringBuffer strBuf = new StringBuffer() ; 
        String regex="([\u4e00-\u9fa5]+)"; 
        Matcher matcher = Pattern.compile(regex).matcher(str); 
        while(matcher.find()){ 
            strBuf.append(matcher.group(0)).toString() ; 
        } 
        return strBuf.toString() ; 
    } 
} 
class GrabIdentity{ 
    public String grabIdentitySex(String userid)throws Exception{ 
        String strUrl = "http://qq.ip138.com/idsearch/index.asp?action=idcard&userid=" + userid + "&B1=%B2%E9+%D1%AF"; 
        URL url = new URL(strUrl) ; 
        HttpURLConnection httpUrlCon = (HttpURLConnection)url.openConnection() ; 
        InputStreamReader inRead = new InputStreamReader(httpUrlCon.getInputStream(),"GBK") ; 
        BufferedReader bufRead = new BufferedReader(inRead) ; 
        StringBuffer strBuf = new StringBuffer() ; 
        String line = "" ; 
        while ((line = bufRead.readLine()) != null) { 
            strBuf.append(line); 
        } 
        String strStart = " 别" ; 
        String strEnd = "出生日期"; 
        String strAll = strBuf.toString() ; 
         
        int start = strAll.indexOf(strStart) ; 
         
        int end = strAll.indexOf(strEnd) ; 
         
        String result = strAll.substring(start+7,end) ; 
        result = drawCh(result) ; 
        return result ; 
    } 
    public String grabIdentityBirth(String userid)throws Exception{ 
        String strUrl = "http://qq.ip138.com/idsearch/index.asp?action=idcard&userid=" + userid + "&B1=%B2%E9+%D1%AF"; 
        URL url = new URL(strUrl) ; 
        HttpURLConnection httpUrlCon = (HttpURLConnection)url.openConnection() ; 
        InputStreamReader inRead = new InputStreamReader(httpUrlCon.getInputStream(),"GBK") ; 
        BufferedReader bufRead = new BufferedReader(inRead) ; 
        StringBuffer strBuf = new StringBuffer() ; 
        String line = "" ; 
        while ((line = bufRead.readLine()) != null) { 
            strBuf.append(line); 
        } 
        String strStart = "出生日期：</td><td class=\"tdc2\">" ; 
        String strEnd = "</td><tr><tr><td class="; 
        String strAll = strBuf.toString() ; 
         
        int start = strAll.indexOf(strStart) ; 
        int end = strAll.indexOf(strEnd) ; 
         
        String result = strAll.substring(start+27,end) ; 
        return result ; 
    } 
    public String grabIdentityHome(String userid)throws Exception{ 
        String strUrl = "http://qq.ip138.com/idsearch/index.asp?action=idcard&userid=" + userid + "&B1=%B2%E9+%D1%AF"; 
        URL url = new URL(strUrl) ; 
        HttpURLConnection httpUrlCon = (HttpURLConnection)url.openConnection() ; 
        InputStreamReader inRead = new InputStreamReader(httpUrlCon.getInputStream(),"GBK") ; 
        BufferedReader bufRead = new BufferedReader(inRead) ; 
        StringBuffer strBuf = new StringBuffer() ; 
        String line = "" ; 
        while ((line = bufRead.readLine()) != null) { 
            strBuf.append(line); 
        } 
        String strStart = "证 地：</td><td class=\"tdc2\">" ; 
        String strEnd = "<br/></td></tr><tr><td class=\"tdc3\" valign=\"top\" align=\"right\">部分或" ; 
        String strAll = strBuf.toString() ; 
         
        int start = strAll.indexOf(strStart) ; 
        int end = strAll.indexOf(strEnd) ; 
         
        String result = strAll.substring(start+31,end) ; 
        return result ; 
    } 
    public String drawCh(String str){ 
        StringBuffer strBuf = new StringBuffer() ; 
        String regex="([\u4e00-\u9fa5]+)"; 
        Matcher matcher = Pattern.compile(regex).matcher(str); 
        if(matcher.find()){ 
            str = strBuf.append(matcher.group(0)).toString() ; 
        } 
        return str ; 
    } 
} 