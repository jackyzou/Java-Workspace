package Client;
/*ClientReceive.java�ļ���������ʵ�ֿͻ��˵���Ϣ�շ�*/
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
				if(type.equalsIgnoreCase("ϵͳ��Ϣ")){
					String sysmsg = (String)input.readObject();
					textArea.append("ϵͳ��Ϣ:"+sysmsg);
				}
				else if(type.equalsIgnoreCase("����ر�")) {
					output.close();
					input.close();
					socket.close();
					textArea.append("�������Ѿ��ر�!\n");
					
					break;
				}				
				else if(type.equalsIgnoreCase("������Ϣ")){
					String message = (String)input.readObject();
					textArea.append(message);
				}
				else if(type.equalsIgnoreCase("�û��б�")){
					String userlist = (String)input.readObject();
					String usernames[] = userlist.split("\n");
					combobox.removeAllItems();
					
					int i=0;
					combobox.addItem("������");
					while(i<usernames.length){
						combobox.addItem(usernames[i]);
						i++;
					}
					combobox.setSelectedIndex(0);
					showStatus.setText("�����û�"+usernames.length+"��");
				}
			}catch(Exception e){
				System.out.println("$$$Exception:"+e.getMessage());
			}
		}
	}
}
