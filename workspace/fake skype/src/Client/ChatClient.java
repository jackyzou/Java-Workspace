package Client;
import java.awt.*;
import java.awt.event.*;

import Client.UserConf;
import javax.swing.*;

import java.net.*;
import java.io.*;

public class ChatClient extends JFrame implements ActionListener{
	JToolBar toolBar = new JToolBar();
	JMenuBar menuBar = new JMenuBar();
	JMenu operationMenu = new JMenu("Operate(O)");
	JMenu settingMenu = new JMenu("Set(C)");
	JMenu helpMenu = new JMenu("Help(H)");
	JButton userButton;
	JButton connectionButton;
	JButton loginButton;
	JButton cancelButton;
	JButton exitButton;
	JButton sendButton;

	JPanel titlePane = new JPanel();
//	JPanel contentPane = new JPanel();
	JScrollPane messageScrollPane;
	JPanel downPane = new JPanel();
	JTextArea  textArea = new JTextArea();
	
	JLabel sendToLabel = new JLabel("To:");
	JLabel express = new JLabel("Faces：");
	JLabel messageLabel = new JLabel("Send：");
	JComboBox expressionlist;								//表情选择
	JComboBox combobox;									//选择发送消息的接收者
	JCheckBox checkBox;									//悄悄话
	JTextField clientMessage;
	JTextField showStatus;
	
	JMenuItem loginItem = new JMenuItem("Login(I)");
	JMenuItem logoffItem = new JMenuItem("Logout(L)");
	JMenuItem exitItem = new JMenuItem("Exit(X)");
	JMenuItem userItem = new JMenuItem("User(U)");
	JMenuItem connectItem = new JMenuItem("Connect(C)");
	JMenuItem helpItem = new JMenuItem("Help(H)");
	
	Dimension dimension = new Dimension(350,500);
	
	String userName = "Humbaba";    //用户名
	String ip = "127.0.0.1";        //连接到服务器端的IP地址
	int port = 8888;				//连接到服务器端的端口号
	Boolean isConnect = false;		//是否连接
	Socket socket;
	ObjectInputStream input;
	ObjectOutputStream output;
	ClientReceive recvThread;
	Help helpDialog;
	
	public ChatClient(){
		try{
			init();
			
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			setLocation((int)(screenSize.width-dimension.width)/2,
							(int)(screenSize.height-dimension.height)/2);
			setVisible(true);
			setResizable(false);
			//为操作菜单栏设置热键
			operationMenu.setMnemonic('O');
			//为用户登录设置快捷键Ctrl+I
			loginItem.setMnemonic('I');
			loginItem.setAccelerator(KeyStroke.getKeyStroke(
						KeyEvent.VK_I,InputEvent.CTRL_MASK));
			//为用户注销设置快捷键Ctrl+L
			logoffItem.setMnemonic('L');
			logoffItem.setAccelerator(KeyStroke.getKeyStroke(
					KeyEvent.VK_L, InputEvent.CTRL_MASK));
			//为退出设置快捷键Ctrl+X
			exitItem.setMnemonic('X');
			exitItem.setAccelerator(KeyStroke.getKeyStroke(
						KeyEvent.VK_X, InputEvent.CTRL_MASK));
			
			
			//为设置菜单栏设置热键
			settingMenu.setMnemonic('C');
			//为退出设置快捷键Ctrl+U
			userItem.setMnemonic('U');
			userItem.setAccelerator(KeyStroke.getKeyStroke(
					KeyEvent.VK_U, InputEvent.CTRL_MASK));
			//为退出设置快捷键Ctrl+C
			connectItem.setMnemonic('C');
			connectItem.setAccelerator(KeyStroke.getKeyStroke(
					KeyEvent.VK_C, InputEvent.CTRL_MASK));
			
			helpMenu.setMnemonic('H');
			helpItem.setMnemonic('H');
			helpItem.setAccelerator(KeyStroke.getKeyStroke(
									KeyEvent.VK_H, InputEvent.CTRL_MASK));
			
			}
			catch(Exception e){
				e.printStackTrace();
			}
	}
	
	private void init() throws Exception{
		this.setTitle("Chat Room");
		setSize(dimension);
		this.setJMenuBar(menuBar);
		menuBar.add(operationMenu);
		menuBar.add(settingMenu);
		menuBar.add(helpMenu);
		//为菜单栏添加菜单项
		operationMenu.add(loginItem);
		operationMenu.add(logoffItem);
		operationMenu.add(exitItem);
		settingMenu.add(userItem);
		settingMenu.add(connectItem);
		helpMenu.add(helpItem);
		
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		//将按钮添加到工具栏
		userButton = new JButton("User");
		connectionButton = new JButton("Connect");
		loginButton = new JButton("Login");
		cancelButton = new JButton("Logout");
		exitButton = new JButton("Exit");
		toolBar.add(userButton);
		toolBar.add(connectionButton);
		toolBar.add(loginButton);
		toolBar.add(cancelButton);
		toolBar.add(exitButton);
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		messageScrollPane = new JScrollPane(textArea);
		textArea.setEditable(false);
		messageScrollPane.setPreferredSize(new Dimension(350,360));
		messageScrollPane.setHorizontalScrollBar(
							new JScrollBar(JScrollBar.HORIZONTAL));
		messageScrollPane.setHorizontalScrollBarPolicy(
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(messageScrollPane,BorderLayout.CENTER);
		
		GridBagLayout gridbagLayout = new GridBagLayout();
		downPane.setLayout(gridbagLayout);
		GridBagConstraints gridbagCon = new GridBagConstraints();
		
//		gridbagCon.fill = GridBagConstraints.VERTICAL;
		gridbagCon.fill = GridBagConstraints.HORIZONTAL;
		gridbagCon.gridx = 0;
		gridbagCon.gridy = 0;
		gridbagCon.gridheight = 2;
		//		gridbagCon.gridwidth = GridBagConstraints.REMAINDER;
		gridbagCon.gridwidth = 5;
		downPane.add(new JLabel("  "),gridbagCon);
		
		
		gridbagCon = new GridBagConstraints();
		gridbagCon.gridx = 0;
		gridbagCon.gridy = 2;
		gridbagCon.anchor = GridBagConstraints.NORTHEAST;
		downPane.add(sendToLabel,gridbagCon);
		
		gridbagCon.gridx = 1;
		gridbagCon.gridy = 2;
		gridbagCon.ipadx = 5;
		combobox = new JComboBox();
//		combobox.setSelectedItem("所有人");
		combobox.addItem("Everyone");
		downPane.add(combobox,gridbagCon);
		
		gridbagCon.gridx = 2;
		gridbagCon.gridy = 2;
		gridbagCon.insets = new Insets(0,5,0,2);
		downPane.add(express, gridbagCon);
		
		gridbagCon.gridx = 3;
		gridbagCon.gridy = 2;
		String[] str = {"Happy","Sad","Today sucks"};
		expressionlist = new JComboBox(str);
		downPane.add(expressionlist,gridbagCon);
		
		checkBox = new JCheckBox("private conversation");
		gridbagCon.gridx = 4;
		gridbagCon.gridy = 2;
		gridbagCon.gridwidth = GridBagConstraints.REMAINDER;
		downPane.add(checkBox,gridbagCon);
		
		gridbagCon.gridx = 0;
		gridbagCon.gridy = 3;
		gridbagCon.insets = new Insets(0,0,0,2);
		gridbagCon.anchor = GridBagConstraints.LINE_START;
		downPane.add(messageLabel,gridbagCon);
		
		clientMessage = new JTextField(18);
		gridbagCon.gridx = 1;
		gridbagCon.gridy = 3;
//		gridbagCon.insets = new Insets(1,8,1,5);
		downPane.add(clientMessage,gridbagCon);
		
		sendButton = new JButton("Send");
		gridbagCon.insets = new Insets(0,3,0,0);
		gridbagCon.gridwidth = GridBagConstraints.REMAINDER;
		gridbagCon.gridx = 4;
		gridbagCon.gridy = 3;
		downPane.add(sendButton,gridbagCon);
		
		showStatus = new JTextField(30);
		showStatus.setEditable(false);
		gridbagCon.gridx = 0;
		gridbagCon.gridy = 4;
		gridbagCon.gridwidth = 5;
		downPane.add(showStatus,gridbagCon);
		
		contentPane.add(downPane, BorderLayout.SOUTH);
		
		/*为菜单栏添加监听器*/
		userItem.addActionListener(this);
		connectItem.addActionListener(this);
		loginItem.addActionListener(this);
		logoffItem.addActionListener(this);
		helpItem.addActionListener(this);
		exitItem.addActionListener(this);
		/*为按钮添加监听器*/
		userButton.addActionListener(this);
		connectionButton.addActionListener(this);
		loginButton.addActionListener(this);
		cancelButton.addActionListener(this);
		exitButton.addActionListener(this);
		/*为系统消息添加监听器*/
		clientMessage.addActionListener(this);
		sendButton.addActionListener(this);
	}

/*	
	class SimpleListener implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			Object obj = ae.getSource();
			if(obj==userItem || obj==userButton){//用户信息设置
				UserConf userConf = new UserConf(this, userName);
				
			}
		}
	}
	*/
	
	/*事件处理*/
	public void actionPerformed(ActionEvent ae){
		Object obj = ae.getSource();
		if(obj==userItem || obj==userButton){//用户信息设置
			//调出用户信息设置对话框
			UserConf userConf = new UserConf(this, userName);
			this.userName = userConf.userInputName;
		}
		else if(obj==connectionButton || obj==connectItem){
			//连接服务器设置，调出连接设置对话框
			ConnectConf conConf = new ConnectConf(this,ip,port);
			ip = conConf.userInputIP;
			port = conConf.userInputPort;
		}
		else if(obj==loginItem || obj==loginButton){
			//登陆
			showStatus.setEditable(true);
			Connect();
		}
		else if(obj==logoffItem || obj==cancelButton){
			//注销
			DisConnect();
			showStatus.setText("");
			showStatus.setEditable(false);
		}
		else if(obj==clientMessage || obj==sendButton){
			//发送消息
			sendMessage();
			clientMessage.setText("");
		}else if(obj == helpItem){//菜单栏中的帮助
			helpDialog = new Help(this);
//			helpDialog.show();
		}else if(obj==exitButton || obj==exitItem){
			int j = JOptionPane.showConfirmDialog(this, "Do you want to exit？", 
					"Exit",JOptionPane.YES_OPTION,
										JOptionPane.QUESTION_MESSAGE);
			if(j==JOptionPane.YES_OPTION){
				if(isConnect==true){
					DisConnect();
				}
				System.exit(0);
			}
		}
	}
	
	public void Connect(){
		try{
			socket = new Socket(ip, port);
		}catch(Exception e){
			JOptionPane.showConfirmDialog(this, "Could not connect to the specified services" +
					"\n Please confirm whether it is right connection Settings","Reminder",
						JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		try{
			output = new ObjectOutputStream(socket.getOutputStream());
			output.flush();
			input = new ObjectInputStream(socket.getInputStream());
			
			output.writeObject(userName);
			output.flush();
			
			recvThread = new ClientReceive(socket,output, input,
										combobox,textArea,showStatus);
			recvThread.start();
			
			loginButton.setEnabled(false);
			loginItem.setEnabled(false);
			userItem.setEnabled(false);
			userButton.setEnabled(false);
			connectItem.setEnabled(false);
			connectionButton.setEnabled(false);
			logoffItem.setEnabled(true);
			cancelButton.setEnabled(true);
			clientMessage.setEditable(true);
			textArea.append("Connect to service"+ip+":"+port+"connection succeed...\n");
			isConnect = true;               //连接成功
			
		}catch(Exception e){
			System.out.println("Exception:"+e.getMessage());
			return;
		}
	}
	
	public void sendMessage(){
		String toSomebody = combobox.getSelectedItem().toString();
		String status = "";
		if(checkBox.isSelected()){
			status = "Private Conversation";
		}
		String expression = expressionlist.getSelectedItem().toString();
		String message = clientMessage.getText();
		
		if(socket.isClosed()){
			return;
		}
		try{
			output.writeObject("Chat info.");
			output.flush();
			output.writeObject(toSomebody);
			output.flush();
			output.writeObject(status);
			output.flush();
			output.writeObject(expression);
			output.flush();
//			output = new ObjectOutputStream(socket.getOutputStream());
			output.writeObject(message);
			output.flush();
		}catch(Exception e){
			
		}
	}
	
	public void DisConnect(){
		loginButton.setEnabled(true);
		loginItem.setEnabled(true);
		userItem.setEnabled(true);
		userButton.setEnabled(true);
		connectItem.setEnabled(true);
		connectionButton.setEnabled(true);
		logoffItem.setEnabled(false);
		cancelButton.setEnabled(false);
		clientMessage.setEditable(false);
		
		if(socket.isClosed()){
			return ;
		}
		
		try{
			output.writeObject("User offline");
			output.flush();
			
			input.close();
			output.close();
			socket.close();
			textArea.append("Connection termin" +
					"ated...\n");
			isConnect = false;
		}catch(Exception e){
			
		}
	}
	
	public static void main(String args[]){
		new ChatClient();
	}
	
}
