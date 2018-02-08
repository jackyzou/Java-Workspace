package Server;
/**PortConf.java�ļ����������޸����÷������˵������˿�
 ��PortConf:���ɶ˿����öԻ������* **/
import javax.swing.*;
import java.awt.*;
//import Server.ChatServer;
import java.awt.event.*;

public class PortConf extends JDialog{
	JPanel panelPort = new JPanel();
	public static JLabel DLGINFO = new JLabel("Ĭ�϶˿ں�Ϊ:8888");
	JButton jbSave = new JButton("����");
	JButton jbCancel = new JButton("ȡ��");
	
	JPanel panelSave = new JPanel();
	JLabel message = new JLabel();
	
	public static JTextField portNumber;
	
	public PortConf(JFrame frame){
		super(frame, true);
		try{
			init();
			Dimension dimension = this.getToolkit().getScreenSize();
			this.setLocation((int)(dimension.getWidth()-400)/2+150,
					(int)(dimension.getHeight()-600)/2+150);
			this.setResizable(false);
			}catch(Exception e){
				e.printStackTrace();
				
				
			}
		
		setVisible(true);
	}
	
	public void init() throws Exception{
		this.setTitle("�˿�����");
		this.setSize(new Dimension(300,160));
//		setLayout(new BorderLayout());
		message.setText("�����������Ķ˿ںţ�");
		portNumber = new JTextField(10);
//		portNumber.setText("8888");
		portNumber.setText(""+ChatServer.port);
		portNumber.setEditable(true);
		panelPort.setLayout(new FlowLayout());
		panelPort.add(message);
		panelPort.add(portNumber);
		
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(panelPort, BorderLayout.NORTH);
		
		contentPane.add(DLGINFO, BorderLayout.CENTER);

		panelSave.add(jbSave);
		panelSave.add(jbCancel);
		contentPane.add(panelSave,BorderLayout.SOUTH);
		/*�¼�����*/
		SimpleListener sListener = new SimpleListener();
		jbSave.addActionListener(sListener);
		jbCancel.addActionListener(sListener);
/*ʹ���������������¼�*/		
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
			PortConf.DLGINFO.setText("Ĭ�϶˿ں�Ϊ��8888");
			}
		});
	}
	/*ʹ��һ���򵥵��ڲ���ʵ��ActionListener�ӿڣ����ڴ���ť�¼���*/
	private class SimpleListener implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			int savePort;
			if(ae.getSource() == jbSave){
				try{
					savePort = Integer.parseInt(PortConf.portNumber.getText());
					if(savePort<1 || savePort>65535){
						PortConf.DLGINFO.setText("�����˿ڱ�����0~65535֮���������");
						PortConf.portNumber.setText("");
						return;
					}
					ChatServer.port = savePort;
					dispose();
				}catch(NumberFormatException e){
					PortConf.DLGINFO.setText("����Ķ˿ںţ��˿ں�����д������");
					PortConf.portNumber.setText("");
					return;
				}
			}
			else if(ae.getSource() == jbCancel){
				PortConf.DLGINFO.setText("Ĭ�϶˿ں�Ϊ��8888");
				dispose();
			}
		}
	}
/*	
	public static void main(String args[])
	{
		new PortConf(new JFrame());
	}
	*/
}
