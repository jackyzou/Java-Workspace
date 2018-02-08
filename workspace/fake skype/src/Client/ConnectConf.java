package Client;
/*ConnectConf.java的作用是实现客户端连接信息的配置*/
import javax.swing.*;
//import java.io.*;
//import Server.PortConf;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
public class ConnectConf extends JDialog {
	JPanel panelUserConf = new JPanel();
	JButton save = new JButton("保存");
	JButton cancel = new JButton("取消");
	JLabel DLGINFO = new JLabel("默认连接设置为 127.0.0.1:8888");
	
	JPanel panelSave = new JPanel();
	JLabel message = new JLabel("请输入服务器的IP地址:");
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
		this.setTitle("连接设置");
		inputIP = new JTextField(10);
		inputPort = new JTextField(4);
		inputIP.setText(userInputIP);
		inputPort.setText(""+userInputPort); 
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		panelUserConf.setLayout(new GridLayout(2,2,1,1));
		panelUserConf.add(message);
		panelUserConf.add(inputIP);
		panelUserConf.add(new JLabel("请输入服务器的端口号:"));
		panelUserConf.add(inputPort);
		contentPane.add(panelUserConf,BorderLayout.NORTH);
		
		panelSave.add(save);
		panelSave.add(cancel);
		contentPane.add(DLGINFO,BorderLayout.CENTER);
		contentPane.add(panelSave, BorderLayout.SOUTH);
		/*事件处理*/
		SimpleListener simListener = new SimpleListener();
		save.addActionListener(simListener);
		cancel.addActionListener(simListener);
		this.addWindowListener(new WindowAdapter(){
			public void actionWindowClosing(WindowEvent e){
				DLGINFO.setText("默认连接设置为 127.0.0.1:8888");
			}
		});
	}
	
	public class SimpleListener implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			if(ae.getSource() == save){
	//			int savePort;
	//			String inputIp;
				//判断IP地址是否合法
				try{
					userInputIP =  ""+InetAddress.getByName(inputIP.getText());
					userInputIP = userInputIP.substring(1);
				}catch(UnknownHostException e){
					DLGINFO.setText("错误的IP地址！");
					return;
				}
				//判断端口号是否合法
				try{
					userInputPort = Integer.parseInt(inputPort.getText());
					if(userInputPort<1 || userInputPort>65535){
						DLGINFO.setText("监听端口号必须是0~65535之间的整数。");
						inputPort.setText("");
						return ;
					}
//					userInputPort = savePort;
					dispose();
				}catch(NumberFormatException e){
					DLGINFO.setText("错误的端口号，端口号请填写整数！");
					inputPort.setText("");
					return;
			}
			}else if(ae.getSource() == cancel){
				DLGINFO.setText("默认连接设置为 127.0.0.1:8888");
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
