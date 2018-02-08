
package Client;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Help extends JDialog{
	JLabel titleLabel = new JLabel("�����ҿͻ��˰���");
	JTextArea contentArea;
	JButton closeButton;
	Dimension dimension = new Dimension(300,250);
	
	JPanel titlePanel = new JPanel();
	JPanel centerPanel = new JPanel();
	JPanel downPanel = new JPanel();
	
	public  Help(JFrame frame){
//		super("����");
		super(frame,true);
		this.setTitle("����");
		
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
		
		String string = "1��������Ҫ���ӷ�������IP��ַ�Ͷ˿�(Ĭ������Ϊ\n"+
					"127.0.0.1:8888)��\n"+"2����������û���(Ĭ������Ϊ:ֻ��Ϊ���)\n"+
					"3�����\"��¼\"��������ӵ�ָ���ķ�����;\n"+"���\"ע��\"���Ժ�" +
					"�������Ͽ����ӡ�\n"+"4��ѡ����Ҫ������Ϣ���û�������Ϣ����д����Ϣ��\n"
					+"ͬ��ѡ����飬֮���ɷ�����Ϣ��";
		contentArea = new JTextArea();
		contentArea.setSize(300, 180);
		contentArea.setText(string);
		contentArea.setEditable(false);
		centerPanel.add(contentArea);
		contentPane.add(centerPanel,BorderLayout.CENTER);
		
		closeButton = new JButton("�ر�");
		downPanel.add(closeButton);
		contentPane.add(downPanel,BorderLayout.SOUTH);
		/*�¼�����*/
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
