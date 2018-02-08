package Server;
/*ServerListen.java文件的作用是实现聊天室服务器端的监听*/
import java.net.*;
import java.io.*;
import javax.swing.*;
public class ServerListen extends Thread{
	ServerSocket server;
	
	JComboBox comboBox;
	JTextArea textArea;
	JTextField textField;
	UserLinkList userLinkList;
	public boolean isStop;
	
	Node client;
	ServerReceive recvThread;
	public ServerListen(ServerSocket server,JComboBox comboBox,
					JTextArea textArea,JTextField textField,
					UserLinkList userLinkList){
			this.server = server;
			this.comboBox = comboBox;
			this.textArea = textArea;
			this.textField = textField;
			this.userLinkList = userLinkList;
			isStop = false;
	}
	
	public void run(){
		while(!isStop && !server.isClosed()){
			try{
				client = new Node();
				client.socket = server.accept();
				client.input = new ObjectInputStream(client.socket.getInputStream());
				client.output = new ObjectOutputStream(client.socket.getOutputStream());
				client.output.flush();
				client.userName = (String)client.input.readObject();
				
				//显示提示信息
				comboBox.addItem(client.userName);
				userLinkList.addUser(client);
				textArea.append("用户"+client.userName+"上线\n");
				textField.setText("在线用户"+userLinkList.getCount()+"人\n");
				recvThread = new ServerReceive(textArea,textField,
								comboBox,client,userLinkList);
				recvThread.start();
			}catch(Exception e){
				
			}
		}
	}
}
