package Server;

import javax.swing.*;
import java.awt.*;

/*生成帮助对话框*/
public class Help extends JDialog{
	JPanel titlePanel = new JPanel();
	JPanel contentPanel = new JPanel();
	JPanel closedPanel = new JPanel();
	
	JButton close = new JButton();
	JLabel title = new JLabel("聊天室服务器帮助");
	JTextArea jtextArea = new JTextArea();
	
	Color bg = new Color(255,0,255);
	public Help(JFrame frame){
		super(frame,true);
		try{
			jbInit();
		}catch(Exception e){
			System.out.println("Exception:"+e.getMessage());
		}
		
		//设置运行位置，使对话框居中
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//		System.out.println(screenSize.width+screenSize.height);
		setLocation((int)(screenSize.width - 400)/2+150,(int)(screenSize.height-320)/2+150);
		this.setResizable(true);
	}
	
	private void jbInit() throws Exception{
		this.setSize(410, 220);
		this.setTitle("帮助");
		setLayout(new BorderLayout());
		
		titlePanel.setBackground(bg);
		contentPanel.setBackground(bg);
		closedPanel.setBackground(bg);
		
		titlePanel.add(new Label("            "));
		titlePanel.add(title);
		titlePanel.add(new Label("            "));
		this.getContentPane().add(titlePanel,BorderLayout.NORTH);
		
		jtextArea.setText("1、设置服务端的侦听窗口(默认窗口为8888)。\n"+
				"2、点击 启动服务 按钮便可在指定的端口启动服务。\n"+
				"3、选择需要的接受消息的用户，在消息栏里写入消息，之后便可发送消息。\n"+
				"4、信息状态栏中显示服务器当前的启动和停止状态、"+
				"用户发送的消息和\n  服务器端发送的系统消息。");
		jtextArea.setEditable(false);
		contentPanel.add(jtextArea);
		this.getContentPane().add(contentPanel,BorderLayout.CENTER);
		
		closedPanel.add(new Label("                     "));
		close.setText("关闭");
		closedPanel.add(close);
		closedPanel.add(new Label("                     "));
		this.getContentPane().add(closedPanel, BorderLayout.SOUTH);
		setVisible(true);
	}

/*
	public static void main(String args[])
	{
		new Help(new JFrame());
	}
*/	
}
