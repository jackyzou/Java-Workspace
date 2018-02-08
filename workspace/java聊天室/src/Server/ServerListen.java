package Server;
/*ServerListen.java�ļ���������ʵ�������ҷ������˵ļ���*/
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
				
				//��ʾ��ʾ��Ϣ
				comboBox.addItem(client.userName);
				userLinkList.addUser(client);
				textArea.append("�û�"+client.userName+"����\n");
				textField.setText("�����û�"+userLinkList.getCount()+"��\n");
				recvThread = new ServerReceive(textArea,textField,
								comboBox,client,userLinkList);
				recvThread.start();
			}catch(Exception e){
				
			}
		}
	}
}
