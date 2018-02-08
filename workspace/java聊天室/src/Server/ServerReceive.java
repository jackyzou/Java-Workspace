package Server;
/*ServerReceive.java��������ʵ�������ҷ���������Ϣ�շ����� */
/*ServerReceive���Ƿ������շ���Ϣ����*/
import javax.swing.*;
import java.net.*;
import java.io.*;

public class ServerReceive extends Thread{

	JTextArea textArea;
	JTextField textField;
	JComboBox comboBox;
	Node	 client;
	UserLinkList userLinkList;  //�û�����
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
		/*�������˷����û����б�*/
		sendUserList();
		
		while(!isStop && !client.socket.isClosed()){
			try{
				String type = (String)client.input.readObject();
				if(type.equalsIgnoreCase("������Ϣ")){
//					String toSomebody = client.userName;
					String toSomebody = (String)client.input.readObject();
					
					String status = (String)client.input.readObject();
					String expression = (String)client.input.readObject();
					String message= (String)client.input.readObject();
					
					String msg = client.userName+" "+expression+"��  "+
						toSomebody+" ˵ :"+message+"\n";
					if(status.equalsIgnoreCase("���Ļ�")){
						msg = "[���Ļ�]"+msg;
					}
					textArea.append(msg);
					
					if(toSomebody.equalsIgnoreCase("������")){
						sendToAll(msg);
					}else
					{
						try{
							client.output.writeObject("������Ϣ");
							client.output.flush();
							client.output.writeObject(msg);
							client.output.flush();
						}catch(Exception e){}
						
						Node node = userLinkList.findUser(toSomebody);
						if(node != null){
							node.output.writeObject("������Ϣ");
							client.output.flush();
							node.output.writeObject(msg);
						}
					}
				}else if(type.equalsIgnoreCase("�û�����")){
					Node node = userLinkList.findUser(client.userName);
					userLinkList.delUser(node);
					String msg = "�û�"+client.userName+"����\n";
					int count = userLinkList.getCount();
					
					comboBox.removeAllItems();
					comboBox.addItem("������");
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
					textField.setText("�����û�"+count+"��\n");
					
					sendToAll(msg);
					sendUserList();
					
					break;
				}
			}catch(Exception e){}
		}
		
	}
	
	/*�������˷����û����б�*/
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
				node.output.writeObject("�û��б�");
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
	/*�������˷�����Ϣ*/
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
				node.output.writeObject("������Ϣ");
				node.output.flush();
				node.output.writeObject(message);
				node.output.flush();
			}catch(Exception e){}
				
			i++;
		}
	}
}
