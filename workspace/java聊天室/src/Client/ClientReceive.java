package Client;
/*ClientReceive.java文件的作用是实现客户端的消息收发*/
import javax.swing.*;
import java.io.*;
import java.net.*;
public class ClientReceive extends Thread{
	private JComboBox combobox;
	private JTextArea textArea;
	
	Socket socket;
	ObjectOutputStream output;
	ObjectInputStream input;
	JTextField showStatus;
	
	public ClientReceive(Socket socket,ObjectOutputStream output,
			ObjectInputStream input,JComboBox combobox,
			JTextArea textArea, JTextField showStatus){
				this.socket = socket;
				this.output = output;
				this.input = input;
				this.combobox = combobox;
				this.textArea = textArea;
				this.showStatus = showStatus;
				
	}
	
	public void run(){
		while(!socket.isClosed()){
			try{
				String type = (String)input.readObject();
				if(type.equalsIgnoreCase("系统消息")){
					String sysmsg = (String)input.readObject();
					textArea.append("系统消息:"+sysmsg);
				}
				else if(type.equalsIgnoreCase("服务关闭")) {
					output.close();
					input.close();
					socket.close();
					textArea.append("服务器已经关闭!\n");
					
					break;
				}				
				else if(type.equalsIgnoreCase("聊天信息")){
					String message = (String)input.readObject();
					textArea.append(message);
				}
				else if(type.equalsIgnoreCase("用户列表")){
					String userlist = (String)input.readObject();
					String usernames[] = userlist.split("\n");
					combobox.removeAllItems();
					
					int i=0;
					combobox.addItem("所有人");
					while(i<usernames.length){
						combobox.addItem(usernames[i]);
						i++;
					}
					combobox.setSelectedIndex(0);
					showStatus.setText("在线用户"+usernames.length+"人");
				}
			}catch(Exception e){
				System.out.println("$$$Exception:"+e.getMessage());
			}
		}
	}
}
