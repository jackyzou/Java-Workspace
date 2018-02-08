
package Client;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Help extends JDialog{
	JLabel titleLabel = new JLabel("聊天室客户端帮助");
	JTextArea contentArea;
	JButton closeButton;
	Dimension dimension = new Dimension(300,250);
	
	JPanel titlePanel = new JPanel();
	JPanel centerPanel = new JPanel();
	JPanel downPanel = new JPanel();
	
	public  Help(JFrame frame){
//		super("帮助");
		super(frame,true);
		this.setTitle("帮助");
		
		this.setSize(dimension);
		
		init();
		Dimension screenSize = this.getToolkit().getScreenSize();
//		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((int)(screenSize.width-dimension.width)/2, 
				(int)(screenSize.height-dimension.height)/2);
		setVisible(true);
		this.setResizable(true);
		
		
	}
	
	public void init(){
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		titlePanel.add(titleLabel);
		contentPane.add(titlePanel,BorderLayout.NORTH);
		
		String string = "1、设置所要连接服务器的IP地址和端口(默认设置为\n"+
					"127.0.0.1:8888)。\n"+"2、输入你的用户名(默认设置为:只想为你好)\n"+
					"3、点击\"登录\"便可以连接到指定的服务器;\n"+"点击\"注销\"可以和" +
					"服务器断开连接。\n"+"4、选择需要接受消息的用户，在消息栏中写入消息，\n"
					+"同事选择表情，之后便可发送消息。";
		contentArea = new JTextArea();
		contentArea.setSize(300, 180);
		contentArea.setText(string);
		contentArea.setEditable(false);
		centerPanel.add(contentArea);
		contentPane.add(centerPanel,BorderLayout.CENTER);
		
		closeButton = new JButton("关闭");
		downPanel.add(closeButton);
		contentPane.add(downPanel,BorderLayout.SOUTH);
		/*事件处理*/
		closeButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae){
//				System.exit(0);	
				dispose();
			}
		});
	}
/*	
	public static void main(String args[]){
		
		new Help(new JFrame());
	}
*/	
}
