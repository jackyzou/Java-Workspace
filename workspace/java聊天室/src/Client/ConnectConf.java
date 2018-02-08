package Client;
/*ConnectConf.java��������ʵ�ֿͻ���������Ϣ������*/
import javax.swing.*;
//import java.io.*;
//import Server.PortConf;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
public class ConnectConf extends JDialog {
	JPanel panelUserConf = new JPanel();
	JButton save = new JButton("����");
	JButton cancel = new JButton("ȡ��");
	JLabel DLGINFO = new JLabel("Ĭ����������Ϊ 127.0.0.1:8888");
	
	JPanel panelSave = new JPanel();
	JLabel message = new JLabel("�������������IP��ַ:");
	Dimension dimension = new Dimension(300,180);
	String userInputIP;
	int userInputPort;
	JTextField inputIP;
	JTextField inputPort;
	
	public ConnectConf(JFrame frame,String ip, int port){
		super(frame,true);
		this.userInputIP = ip;
		this.userInputPort = port;
		try{
			init();
			this.setSize(dimension);
			this.setResizable(true);
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			this.setLocation((int)(screenSize.width-dimension.width)/2, 
								(int)(screenSize.height-dimension.height)/2);
			setVisible(true);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void init() throws Exception{
		this.setTitle("��������");
		inputIP = new JTextField(10);
		inputPort = new JTextField(4);
		inputIP.setText(userInputIP);
		inputPort.setText(""+userInputPort); 
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		panelUserConf.setLayout(new GridLayout(2,2,1,1));
		panelUserConf.add(message);
		panelUserConf.add(inputIP);
		panelUserConf.add(new JLabel("������������Ķ˿ں�:"));
		panelUserConf.add(inputPort);
		contentPane.add(panelUserConf,BorderLayout.NORTH);
		
		panelSave.add(save);
		panelSave.add(cancel);
		contentPane.add(DLGINFO,BorderLayout.CENTER);
		contentPane.add(panelSave, BorderLayout.SOUTH);
		/*�¼�����*/
		SimpleListener simListener = new SimpleListener();
		save.addActionListener(simListener);
		cancel.addActionListener(simListener);
		this.addWindowListener(new WindowAdapter(){
			public void actionWindowClosing(WindowEvent e){
				DLGINFO.setText("Ĭ����������Ϊ 127.0.0.1:8888");
			}
		});
	}
	
	public class SimpleListener implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			if(ae.getSource() == save){
	//			int savePort;
	//			String inputIp;
				//�ж�IP��ַ�Ƿ�Ϸ�
				try{
					userInputIP =  ""+InetAddress.getByName(inputIP.getText());
					userInputIP = userInputIP.substring(1);
				}catch(UnknownHostException e){
					DLGINFO.setText("�����IP��ַ��");
					return;
				}
				//�ж϶˿ں��Ƿ�Ϸ�
				try{
					userInputPort = Integer.parseInt(inputPort.getText());
					if(userInputPort<1 || userInputPort>65535){
						DLGINFO.setText("�����˿ںű�����0~65535֮���������");
						inputPort.setText("");
						return ;
					}
//					userInputPort = savePort;
					dispose();
				}catch(NumberFormatException e){
					DLGINFO.setText("����Ķ˿ںţ��˿ں�����д������");
					inputPort.setText("");
					return;
			}
			}else if(ae.getSource() == cancel){
				DLGINFO.setText("Ĭ����������Ϊ 127.0.0.1:8888");
				dispose();
			}
		}
	}
/*
	public static void main(String args[])
	{
		new ConnectConf(new JFrame(),"127.0.0.0",8888);
	}
*/
}
