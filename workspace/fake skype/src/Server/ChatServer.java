package Server;

import javax.swing.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Toolkit;
public class ChatServer extends JFrame {
	private JToolBar toolBar;
	private JMenuBar jmenuBar;
	private JMenu serverMenu, helpMenu;
	private JMenuItem portItem;
	private JMenuItem startItem;
	private JMenuItem stopItem;
	private JMenuItem exitItem;
	private JMenuItem helpItem;
	private JButton portSet;
	private JButton startServer;
	private JButton stopServer;
	private JButton exitButton;
	 Image icon;                   //程序图标
	
	private JTextArea messageShow;
	private Dimension dimension;
	private JTextField showStatus;
	private JComboBox combobox;
	private JScrollPane messageScrollPane;
	private JLabel sendToLabel,messageLabel;
	private JTextField sysMessage;
	private JButton sysMessageButton;
	
	private GridBagLayout gridbag;
	private GridBagConstraints gridBagCon;

	ServerSocket serverSocket;
	UserLinkList  userLinkList;
	ServerListen listenThread;
	public static int port = 8888;//服务器的监听端口
	public ChatServer(){
		super("聊天室服务器端");
		init();
		//添加框架的关闭事件处理
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		pack();
		
		//设置运行时窗口的位置
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((int)(screenSize.getWidth() - dimension.getWidth())/2,
						(int)(screenSize.getHeight() - dimension.getHeight())/2);
		this.setResizable(false);
		
		//设置程序图标
		try{
			icon = Toolkit.getDefaultToolkit().getImage("qq.gif");
			this.setIconImage(icon);
			show();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		/*为服务菜单设置热键*/
		serverMenu.setMnemonic('V');
		/*为菜单项设置快捷键*/
		portItem.setMnemonic('P');
		portItem.setAccelerator(KeyStroke.getKeyStroke(
								KeyEvent.VK_P, InputEvent.CTRL_MASK));
		startItem.setMnemonic('S');
		startItem.setAccelerator(KeyStroke.getKeyStroke(
								KeyEvent.VK_S, InputEvent.CTRL_MASK));
		/*为帮助菜单设置热键*/
		helpMenu.setMnemonic('V');
		setVisible(true);
	}
	public void init(){
		//建立菜单栏
		jmenuBar = new JMenuBar();
		serverMenu = new JMenu("服务(V)");
		helpMenu = new JMenu("帮助(H)");
		jmenuBar.add(serverMenu);
		jmenuBar.add(helpMenu);
		//添加菜单栏
		portItem = new JMenuItem("端口设置(P)");
		startItem = new JMenuItem("启动服务(S)");
		stopItem = new JMenuItem("停止服务(T)");
		exitItem = new JMenuItem("退出(X)");
		serverMenu.add(portItem);		
		serverMenu.add(startItem);
		serverMenu.add(stopItem);
		serverMenu.add(exitItem);
		helpItem = new JMenuItem("帮助(H)");
		helpMenu.add(helpItem);
	//	add(jmenuBar);
		this.setJMenuBar(jmenuBar);
		
		//建立工具栏
		toolBar = new JToolBar();
		portSet = new JButton("端口设置");
		startServer = new JButton("启动服务");
		stopServer = new JButton("停止服务");
		exitButton = new JButton("退出");
		toolBar.add(portSet);
		toolBar.add(startServer);
		toolBar.add(stopServer);
		toolBar.add(exitButton);		
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(toolBar,BorderLayout.NORTH);
		
		//初始时，令停止服务按钮不可用
		stopItem.setEnabled(false);
		stopServer.setEnabled(false);
		//添加滚动窗格
		dimension = new Dimension(400,600);
		messageShow = new JTextArea(10,20);
		messageShow.setEditable(false);
		messageScrollPane = new JScrollPane(messageShow,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS ,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		messageScrollPane.setPreferredSize(new Dimension(400,200));
		messageScrollPane.revalidate();
		
		
		JPanel jpanel = new JPanel();
		gridbag = new GridBagLayout();
		jpanel.setLayout(gridbag);
		gridBagCon = new GridBagConstraints();
		
		gridBagCon.gridx = 0;
		gridBagCon.gridy = 0;
		gridBagCon.gridheight = 2;
		gridBagCon.gridwidth = 3;
		//将组件的最小尺寸加大ipadx*2,ipady*2个像素。
		gridBagCon.ipadx = 5;
		gridBagCon.ipady = 5;
		JLabel none = new JLabel("   ");
		jpanel.add(none,gridBagCon);
		
		gridBagCon = new GridBagConstraints();
		sendToLabel = new JLabel("发送至:");
		gridBagCon.weightx = 1;
		gridBagCon.gridx = 0;
		gridBagCon.gridy = 2;
		gridBagCon.ipadx = 0;
		gridBagCon.ipady = 0;
		gridBagCon.anchor = GridBagConstraints.LINE_START;
		//使下一个组件bb7与网格单元之间在上，左，下，右，分别保持5,0,0,0个像素的空白位置。 
		gridBagCon.insets = new Insets(5,0,0,0);
		gridbag.setConstraints(sendToLabel, gridBagCon);
		//		jpanel.add(sendToLabel);
		jpanel.add(sendToLabel,gridBagCon);
		
//		String[] s ={"所有人"};
//		combobox = new JComboBox(s);
//		combobox.setEditable(true);
		combobox = new JComboBox();
		combobox.insertItemAt("所有人", 0);
		combobox.setSelectedIndex(0);
		gridBagCon.gridx = 1;
		gridBagCon.gridy = 2;
		gridBagCon.weightx = 4;
//		gridBagCon.anchor = GridBagConstraints.CENTER;
		jpanel.add(combobox,gridBagCon);
						
		messageLabel = new JLabel("发送消息:");
		gridBagCon.gridx = 0;
		gridBagCon.gridy = 3;
		gridBagCon.weightx = 1;
		jpanel.add(messageLabel,gridBagCon);
		
		sysMessage = new JTextField(20);
		gridBagCon.gridx = 1;
		gridBagCon.gridy = 3;
		gridBagCon.weightx = 1;
		sysMessage.setText("");
		jpanel.add(sysMessage,gridBagCon);
		
		sysMessageButton = new JButton("发送");
		gridBagCon.gridx = 2;
		gridBagCon.gridy = 3;
		gridBagCon.weightx = 1;
		jpanel.add(sysMessageButton,gridBagCon);
		
		showStatus = new JTextField();
		gridBagCon.gridx = 0;
		gridBagCon.gridy = 4;
		gridBagCon.weightx = 1;
		gridBagCon.gridwidth = 3;
		gridBagCon.fill = GridBagConstraints.HORIZONTAL;
//		showStatus.setEditable(false);
		jpanel.add(showStatus,gridBagCon);
		/**/
		this.setSize(dimension);
		this.getContentPane().add(messageScrollPane,BorderLayout.CENTER);
		this.getContentPane().add(jpanel,BorderLayout.SOUTH);
		
		/*为菜单栏添加监视器*/
		SimpleListener sLister = new SimpleListener();
		startItem.addActionListener(sLister);
		stopItem.addActionListener(sLister);
		portItem.addActionListener(sLister);
		exitItem.addActionListener(sLister);
		helpItem.addActionListener(sLister);
		
		/*为按钮添加事件*/
		startServer.addActionListener(sLister);
		stopServer.addActionListener(sLister);
		portSet.addActionListener(sLister);
		exitButton.addActionListener(sLister);
		
		/*添加系统消息的事件监听*/
		sysMessage.addActionListener(sLister);
		sysMessageButton.addActionListener(sLister);
		
		/*关闭程序的操作*/
		this.addWindowListener(new WindowAdapter(){
			public void actionPerformed(WindowEvent e){
				/*停止服务端*/
				System.exit(0);
			}
		});
	}
	
	/*事件处理*/
	public class SimpleListener implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			Object obj = ae.getSource();
			if(obj == startItem || obj == startServer){
				/*启动服务端*/
				startService();
			}else if(obj == stopItem || obj == stopServer){
				/*停止服务端*/
				int j = JOptionPane.showConfirmDialog(new JFrame(), 
						"真的停止服务吗？", "停止服务", JOptionPane.YES_OPTION,
										JOptionPane.QUESTION_MESSAGE);
				if(j == JOptionPane.YES_OPTION){
					stopService();
				}
				
			}else if(obj == portItem || obj == portSet){
				/*端口设置*/
				PortConf  portConf = new PortConf(new JFrame());
			}else if(obj == exitButton || obj == exitItem){
				/*退出程序*/
				int j = JOptionPane.showConfirmDialog(new JFrame(), 
						"真的停止服务吗？", "停止服务", JOptionPane.YES_OPTION,
										JOptionPane.QUESTION_MESSAGE);
				if(j == JOptionPane.YES_OPTION){
					stopService();
					System.exit(0);
				}
			}else  if(obj == helpItem){
				/*菜单栏中的帮助*/
				Help helpDialog = new Help(new JFrame());
				
			}else if(obj == sysMessage || obj == sysMessageButton){
				/*发送消息*/
				sendSystemMessage();
			}
			
		}
	}
	
	/*启动服务端*/
	public  void startService(){
		try{
			serverSocket = new ServerSocket(port,10);
			portItem.setEnabled(false);
			startItem.setEnabled(false);
			portSet.setEnabled(false);
			startServer.setEnabled(false);
			stopItem.setEnabled(true);
			stopServer.setEnabled(true);
			sysMessage.setEditable(true);
		}catch(Exception e){}
		
		userLinkList = new UserLinkList();
		listenThread = new ServerListen(serverSocket,combobox,messageShow,
												showStatus,userLinkList);
		listenThread.start();
	}
	
	public void stopService(){
		try{
			//向所有人发送服务器关闭的消息
			sendStopToAll();
			listenThread.isStop = true;
			serverSocket.close();
			
			int count = userLinkList.getCount();
			int i=0;
			while(i<count){
				Node node = userLinkList.findUser(i);
				
				node.input.close();
				node.output.close();
				node.socket.close();
				i++;
			}
			
			stopServer.setEnabled(false);
			stopItem.setEnabled(false);
			startServer.setEnabled(true);
			startItem.setEnabled(true);
			portSet.setEnabled(true);
			portItem.setEnabled(true);
			sysMessage.setEditable(false);
			
			messageShow.append("服务器已经关闭\n");
			
			combobox.removeAll();
			combobox.addItem("所有人");
		}catch(Exception e){}
	}
	
	/*向所有人发送服务器关闭的消息*/
	public void sendStopToAll(){
		int count = userLinkList.getCount();
		int i=0;
		while(i<count){
			Node node = userLinkList.findUser(i);
			if(node == null){
				i++;
				continue;
			}
			try{
				node.output.writeObject("服务关闭");
				node.output.flush();
			}catch(Exception e){}
			i++;
		}
	}
	
	/*向所有人发送消息*/
	public void sendMsgToAll(String msg){
		int count = userLinkList.getCount();
		int i=0;
		while(i<count){
			Node node = userLinkList.findUser(i);
			if(node == null){
				i++;
				continue;
			}
			try{
				node.output.writeObject("系统消息");
				node.output.flush();
				node.output.writeObject(msg);
				node.output.flush();
			}catch(Exception e){System.out.println("@@@"+e);}
			i++;
		}
		sysMessage.setText("");
	}
	
	/*想客户端发送消息*/
	public void sendSystemMessage(){
		String toSomebody = combobox.getSelectedItem().toString();
		String message = sysMessage.getText()+"\n";
		if(toSomebody.equalsIgnoreCase("所有人")){
			sendMsgToAll(message);
		}else{
			try{
				Node node = userLinkList.findUser(toSomebody);
				node.output.writeObject("系统消息");
				node.output.flush();
				node.output.writeObject(message);
				node.output.flush();
				
			}catch(Exception e){
				System.out.println("!!!"+e.getMessage());
			}
		}
		sysMessage.setText("");
	}
	
	public static  void  main(String args[]){
		new ChatServer();
	}
	
}
