package Client;
/*实现客户端用户的信息配置*/
import  javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class UserConf extends JDialog{
	JPanel panelUserConf = new JPanel();
	JLabel message = new JLabel("请输入你的用户名:");
	JTextField textField = new JTextField(10);
	JLabel DLGINFO = new JLabel("                 默认用户名为：匆匆过客");
	JPanel savePanel = new JPanel();
	JButton save = new JButton("保存");
	JButton cancel = new JButton("取消");
	String userInputName;
	Dimension dimension = new Dimension(300,200);
/*
	public static void main(String args[]){
		new UserConf(new JFrame(), "只想对你好");
	}
*/
	public UserConf(JFrame frame, String str){
		super(frame,true);
		this.userInputName = str;
		try{
			init();			
//			System.out.println(textField.getText());
		}catch(Exception e){
			e.printStackTrace();
		}
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((int)(screenSize.width-dimension.width)/2,            /*两者顺序不能颠倒，否则没有图像打印！*/
					(int)(screenSize.height-dimension.height)/2);
		
		this.setResizable(false);
		this.setVisible(true);
	}
	
	
	private void init() throws Exception{
		this.setTitle("用户设置");
		setSize(dimension);
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		panelUserConf.setLayout(new FlowLayout());
		panelUserConf.add(message);
		textField.setText(userInputName);
		panelUserConf.add(textField);
		contentPane.add(panelUserConf, BorderLayout.NORTH);
		contentPane.add(DLGINFO, BorderLayout.CENTER);
		
		savePanel.add(save);
		savePanel.add(cancel);
		contentPane.add(savePanel,BorderLayout.SOUTH);

		/*事件处理*/ 
		SimpleListener simListener = new SimpleListener();
		save.addActionListener(simListener);
		cancel.addActionListener(simListener);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				DLGINFO.setText("          默认用户名为：匆匆过客");
				dispose();
			}
		});
	
	}

	public class SimpleListener implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			if(ae.getSource() == save){
				if(textField.getText().equals("")){
					DLGINFO.setText("                      用户名不能为空！");
					textField.setText(userInputName);
					return ;
				}else if(textField.getText().length() > 10){
					DLGINFO.setText("              用户名长度不能大于10个字符！");
					textField.setText(userInputName);
					return ;
					}
				userInputName = textField.getText();
				dispose();
			}else if(ae.getSource() == cancel){
				DLGINFO.setText("         默认用户名为：匆匆过客");
				dispose();
			}
		}
	}
	
	
}
