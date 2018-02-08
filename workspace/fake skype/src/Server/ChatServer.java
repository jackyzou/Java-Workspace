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
	 Image icon;                   //����ͼ��
	
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
	public static int port = 8888;//�������ļ����˿�
	public ChatServer(){
		super("�����ҷ�������");
		init();
		//��ӿ�ܵĹر��¼�����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		pack();
		
		//��������ʱ���ڵ�λ��
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((int)(screenSize.getWidth() - dimension.getWidth())/2,
						(int)(screenSize.getHeight() - dimension.getHeight())/2);
		this.setResizable(false);
		
		//���ó���ͼ��
		try{
			icon = Toolkit.getDefaultToolkit().getImage("qq.gif");
			this.setIconImage(icon);
			show();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		/*Ϊ����˵������ȼ�*/
		serverMenu.setMnemonic('V');
		/*Ϊ�˵������ÿ�ݼ�*/
		portItem.setMnemonic('P');
		portItem.setAccelerator(KeyStroke.getKeyStroke(
								KeyEvent.VK_P, InputEvent.CTRL_MASK));
		startItem.setMnemonic('S');
		startItem.setAccelerator(KeyStroke.getKeyStroke(
								KeyEvent.VK_S, InputEvent.CTRL_MASK));
		/*Ϊ�����˵������ȼ�*/
		helpMenu.setMnemonic('V');
		setVisible(true);
	}
	public void init(){
		//�����˵���
		jmenuBar = new JMenuBar();
		serverMenu = new JMenu("����(V)");
		helpMenu = new JMenu("����(H)");
		jmenuBar.add(serverMenu);
		jmenuBar.add(helpMenu);
		//��Ӳ˵���
		portItem = new JMenuItem("�˿�����(P)");
		startItem = new JMenuItem("��������(S)");
		stopItem = new JMenuItem("ֹͣ����(T)");
		exitItem = new JMenuItem("�˳�(X)");
		serverMenu.add(portItem);		
		serverMenu.add(startItem);
		serverMenu.add(stopItem);
		serverMenu.add(exitItem);
		helpItem = new JMenuItem("����(H)");
		helpMenu.add(helpItem);
	//	add(jmenuBar);
		this.setJMenuBar(jmenuBar);
		
		//����������
		toolBar = new JToolBar();
		portSet = new JButton("�˿�����");
		startServer = new JButton("��������");
		stopServer = new JButton("ֹͣ����");
		exitButton = new JButton("�˳�");
		toolBar.add(portSet);
		toolBar.add(startServer);
		toolBar.add(stopServer);
		toolBar.add(exitButton);		
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(toolBar,BorderLayout.NORTH);
		
		//��ʼʱ����ֹͣ����ť������
		stopItem.setEnabled(false);
		stopServer.setEnabled(false);
		//��ӹ�������
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
		//���������С�ߴ�Ӵ�ipadx*2,ipady*2�����ء�
		gridBagCon.ipadx = 5;
		gridBagCon.ipady = 5;
		JLabel none = new JLabel("   ");
		jpanel.add(none,gridBagCon);
		
		gridBagCon = new GridBagConstraints();
		sendToLabel = new JLabel("������:");
		gridBagCon.weightx = 1;
		gridBagCon.gridx = 0;
		gridBagCon.gridy = 2;
		gridBagCon.ipadx = 0;
		gridBagCon.ipady = 0;
		gridBagCon.anchor = GridBagConstraints.LINE_START;
		//ʹ��һ�����bb7������Ԫ֮�����ϣ����£��ң��ֱ𱣳�5,0,0,0�����صĿհ�λ�á� 
		gridBagCon.insets = new Insets(5,0,0,0);
		gridbag.setConstraints(sendToLabel, gridBagCon);
		//		jpanel.add(sendToLabel);
		jpanel.add(sendToLabel,gridBagCon);
		
//		String[] s ={"������"};
//		combobox = new JComboBox(s);
//		combobox.setEditable(true);
		combobox = new JComboBox();
		combobox.insertItemAt("������", 0);
		combobox.setSelectedIndex(0);
		gridBagCon.gridx = 1;
		gridBagCon.gridy = 2;
		gridBagCon.weightx = 4;
//		gridBagCon.anchor = GridBagConstraints.CENTER;
		jpanel.add(combobox,gridBagCon);
						
		messageLabel = new JLabel("������Ϣ:");
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
		
		sysMessageButton = new JButton("����");
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
		
		/*Ϊ�˵�����Ӽ�����*/
		SimpleListener sLister = new SimpleListener();
		startItem.addActionListener(sLister);
		stopItem.addActionListener(sLister);
		portItem.addActionListener(sLister);
		exitItem.addActionListener(sLister);
		helpItem.addActionListener(sLister);
		
		/*Ϊ��ť����¼�*/
		startServer.addActionListener(sLister);
		stopServer.addActionListener(sLister);
		portSet.addActionListener(sLister);
		exitButton.addActionListener(sLister);
		
		/*���ϵͳ��Ϣ���¼�����*/
		sysMessage.addActionListener(sLister);
		sysMessageButton.addActionListener(sLister);
		
		/*�رճ���Ĳ���*/
		this.addWindowListener(new WindowAdapter(){
			public void actionPerformed(WindowEvent e){
				/*ֹͣ�����*/
				System.exit(0);
			}
		});
	}
	
	/*�¼�����*/
	public class SimpleListener implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			Object obj = ae.getSource();
			if(obj == startItem || obj == startServer){
				/*���������*/
				startService();
			}else if(obj == stopItem || obj == stopServer){
				/*ֹͣ�����*/
				int j = JOptionPane.showConfirmDialog(new JFrame(), 
						"���ֹͣ������", "ֹͣ����", JOptionPane.YES_OPTION,
										JOptionPane.QUESTION_MESSAGE);
				if(j == JOptionPane.YES_OPTION){
					stopService();
				}
				
			}else if(obj == portItem || obj == portSet){
				/*�˿�����*/
				PortConf  portConf = new PortConf(new JFrame());
			}else if(obj == exitButton || obj == exitItem){
				/*�˳�����*/
				int j = JOptionPane.showConfirmDialog(new JFrame(), 
						"���ֹͣ������", "ֹͣ����", JOptionPane.YES_OPTION,
										JOptionPane.QUESTION_MESSAGE);
				if(j == JOptionPane.YES_OPTION){
					stopService();
					System.exit(0);
				}
			}else  if(obj == helpItem){
				/*�˵����еİ���*/
				Help helpDialog = new Help(new JFrame());
				
			}else if(obj == sysMessage || obj == sysMessageButton){
				/*������Ϣ*/
				sendSystemMessage();
			}
			
		}
	}
	
	/*���������*/
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
			//�������˷��ͷ������رյ���Ϣ
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
			
			messageShow.append("�������Ѿ��ر�\n");
			
			combobox.removeAll();
			combobox.addItem("������");
		}catch(Exception e){}
	}
	
	/*�������˷��ͷ������رյ���Ϣ*/
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
				node.output.writeObject("����ر�");
				node.output.flush();
			}catch(Exception e){}
			i++;
		}
	}
	
	/*�������˷�����Ϣ*/
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
				node.output.writeObject("ϵͳ��Ϣ");
				node.output.flush();
				node.output.writeObject(msg);
				node.output.flush();
			}catch(Exception e){System.out.println("@@@"+e);}
			i++;
		}
		sysMessage.setText("");
	}
	
	/*��ͻ��˷�����Ϣ*/
	public void sendSystemMessage(){
		String toSomebody = combobox.getSelectedItem().toString();
		String message = sysMessage.getText()+"\n";
		if(toSomebody.equalsIgnoreCase("������")){
			sendMsgToAll(message);
		}else{
			try{
				Node node = userLinkList.findUser(toSomebody);
				node.output.writeObject("ϵͳ��Ϣ");
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
