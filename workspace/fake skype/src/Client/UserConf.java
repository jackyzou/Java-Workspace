package Client;
/*ʵ�ֿͻ����û�����Ϣ����*/
import  javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class UserConf extends JDialog{
	JPanel panelUserConf = new JPanel();
	JLabel message = new JLabel("����������û���:");
	JTextField textField = new JTextField(10);
	JLabel DLGINFO = new JLabel("                 Ĭ���û���Ϊ���Ҵҹ���");
	JPanel savePanel = new JPanel();
	JButton save = new JButton("����");
	JButton cancel = new JButton("ȡ��");
	String userInputName;
	Dimension dimension = new Dimension(300,200);
/*
	public static void main(String args[]){
		new UserConf(new JFrame(), "ֻ������");
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
		setLocation((int)(screenSize.width-dimension.width)/2,            /*����˳���ܵߵ�������û��ͼ���ӡ��*/
					(int)(screenSize.height-dimension.height)/2);
		
		this.setResizable(false);
		this.setVisible(true);
	}
	
	
	private void init() throws Exception{
		this.setTitle("�û�����");
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

		/*�¼�����*/ 
		SimpleListener simListener = new SimpleListener();
		save.addActionListener(simListener);
		cancel.addActionListener(simListener);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				DLGINFO.setText("          Ĭ���û���Ϊ���Ҵҹ���");
				dispose();
			}
		});
	
	}

	public class SimpleListener implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			if(ae.getSource() == save){
				if(textField.getText().equals("")){
					DLGINFO.setText("                      �û�������Ϊ�գ�");
					textField.setText(userInputName);
					return ;
				}else if(textField.getText().length() > 10){
					DLGINFO.setText("              �û������Ȳ��ܴ���10���ַ���");
					textField.setText(userInputName);
					return ;
					}
				userInputName = textField.getText();
				dispose();
			}else if(ae.getSource() == cancel){
				DLGINFO.setText("         Ĭ���û���Ϊ���Ҵҹ���");
				dispose();
			}
		}
	}
	
	
}
