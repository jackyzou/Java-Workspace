package Server;
/**PortConf.java文件的作用是修改配置服务器端的侦听端口
 类PortConf:生成端口设置对话框的类* **/
import javax.swing.*;
import java.awt.*;
//import Server.ChatServer;
import java.awt.event.*;

public class PortConf extends JDialog{
	JPanel panelPort = new JPanel();
	public static JLabel DLGINFO = new JLabel("默认端口号为:8888");
	JButton jbSave = new JButton("保存");
	JButton jbCancel = new JButton("取消");
	
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
		this.setTitle("端口设置");
		this.setSize(new Dimension(300,160));
//		setLayout(new BorderLayout());
		message.setText("请输入侦听的端口号：");
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
		/*事件处理*/
		SimpleListener sListener = new SimpleListener();
		jbSave.addActionListener(sListener);
		jbCancel.addActionListener(sListener);
/*使用适配器处理窗口事件*/		
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
			PortConf.DLGINFO.setText("默认端口号为：8888");
			}
		});
	}
	/*使用一个简单的内部类实现ActionListener接口，勇于处理按钮事件。*/
	private class SimpleListener implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			int savePort;
			if(ae.getSource() == jbSave){
				try{
					savePort = Integer.parseInt(PortConf.portNumber.getText());
					if(savePort<1 || savePort>65535){
						PortConf.DLGINFO.setText("侦听端口必须是0~65535之间的整数！");
						PortConf.portNumber.setText("");
						return;
					}
					ChatServer.port = savePort;
					dispose();
				}catch(NumberFormatException e){
					PortConf.DLGINFO.setText("错误的端口号，端口号请填写整数！");
					PortConf.portNumber.setText("");
					return;
				}
			}
			else if(ae.getSource() == jbCancel){
				PortConf.DLGINFO.setText("默认端口号为：8888");
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
