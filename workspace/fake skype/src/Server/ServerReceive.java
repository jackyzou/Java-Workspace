package Server;
/*ServerReceive.java的作用是实现聊天室服务器的消息收发功能 */
/*ServerReceive类是服务器收发消息的类*/
import javax.swing.*;
import java.net.*;
import java.io.*;

public class ServerReceive extends Thread{

	JTextArea textArea;
	JTextField textField;
	JComboBox comboBox;
	Node	 client;
	UserLinkList userLinkList;  //用户链表
	public boolean isStop;
	
	public ServerReceive(JTextArea textArea, JTextField textField,
			JComboBox comboBox,Node	client,UserLinkList userLinkList)
	{
		this.textArea = textArea;
		this.textField = textField;
		this.comboBox = comboBox;
		this.client = client;
		this.userLinkList = userLinkList;
		isStop = false;
	}
	
	public void run(){
		/*向所有人发送用户的列表*/
		sendUserList();
		
		while(!isStop && !client.socket.isClosed()){
			try{
				String type = (String)client.input.readObject();
				if(type.equalsIgnoreCase("聊天信息")){
//					String toSomebody = client.userName;
					String toSomebody = (String)client.input.readObject();
					
					String status = (String)client.input.readObject();
					String expression = (String)client.input.readObject();
					String message= (String)client.input.readObject();
					
					String msg = client.userName+" "+expression+"对  "+
						toSomebody+" 说 :"+message+"\n";
					if(status.equalsIgnoreCase("悄悄话")){
						msg = "[悄悄话]"+msg;
					}
					textArea.append(msg);
					
					if(toSomebody.equalsIgnoreCase("所有人")){
						sendToAll(msg);
					}else
					{
						try{
							client.output.writeObject("聊天信息");
							client.output.flush();
							client.output.writeObject(msg);
							client.output.flush();
						}catch(Exception e){}
						
						Node node = userLinkList.findUser(toSomebody);
						if(node != null){
							node.output.writeObject("聊天信息");
							client.output.flush();
							node.output.writeObject(msg);
						}
					}
				}else if(type.equalsIgnoreCase("用户下线")){
					Node node = userLinkList.findUser(client.userName);
					userLinkList.delUser(node);
					String msg = "用户"+client.userName+"下线\n";
					int count = userLinkList.getCount();
					
					comboBox.removeAllItems();
					comboBox.addItem("所有人");
					int i=0;
					while(i<count){
						 node = userLinkList.findUser(i);
						 if(node == null){
							 i++;
							 continue;
						 }
						 comboBox.addItem(node.userName);
						 i++;
					}
					comboBox.setSelectedIndex(0);
					
					textArea.setText(msg);
					textField.setText("在线用户"+count+"人\n");
					
					sendToAll(msg);
					sendUserList();
					
					break;
				}
			}catch(Exception e){}
		}
		
	}
	
	/*向所有人发送用户的列表*/
	public void sendUserList(){
		String userlist = "";
		int count = userLinkList.getCount();
		
		int i=0;
		while(i<count){
			Node node = userLinkList.findUser(i);
			if(node == null){
				i++;
				continue;
				
			}
			
			userlist += node.userName;
			userlist += "\n";
			i++;
		}
		
		 i=0;
		while(i<count){
			Node node = userLinkList.findUser(i);
			if(node==null){
				i++;
				continue;
			}
			try{
				node.output.writeObject("用户列表");
				node.output.flush();
//				node.output.writeObject(userLinkList);
				node.output.writeObject(userlist);
				node.output.flush();
			}catch(Exception e){
				System.out.println("###Exception:"+e.getMessage());
			}
			i++;
		}
		
	}
	/*向所有人发送消息*/
	public void sendToAll(String message){
		int count = userLinkList.getCount();
		int i=0;
		while(i<count){
			Node node = userLinkList.findUser(i);
			if(node == null){
				i++;
				continue;
			}
			try{
				node.output.writeObject("聊天消息");
				node.output.flush();
				node.output.writeObject(message);
				node.output.flush();
			}catch(Exception e){}
				
			i++;
		}
	}
}
