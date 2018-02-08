package Server;

import javax.swing.*;
import java.awt.*;

/*���ɰ����Ի���*/
public class Help extends JDialog{
	JPanel titlePanel = new JPanel();
	JPanel contentPanel = new JPanel();
	JPanel closedPanel = new JPanel();
	
	JButton close = new JButton();
	JLabel title = new JLabel("�����ҷ���������");
	JTextArea jtextArea = new JTextArea();
	
	Color bg = new Color(255,0,255);
	public Help(JFrame frame){
		super(frame,true);
		try{
			jbInit();
		}catch(Exception e){
			System.out.println("Exception:"+e.getMessage());
		}
		
		//��������λ�ã�ʹ�Ի������
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//		System.out.println(screenSize.width+screenSize.height);
		setLocation((int)(screenSize.width - 400)/2+150,(int)(screenSize.height-320)/2+150);
		this.setResizable(true);
	}
	
	private void jbInit() throws Exception{
		this.setSize(410, 220);
		this.setTitle("����");
		setLayout(new BorderLayout());
		
		titlePanel.setBackground(bg);
		contentPanel.setBackground(bg);
		closedPanel.setBackground(bg);
		
		titlePanel.add(new Label("            "));
		titlePanel.add(title);
		titlePanel.add(new Label("            "));
		this.getContentPane().add(titlePanel,BorderLayout.NORTH);
		
		jtextArea.setText("1�����÷���˵���������(Ĭ�ϴ���Ϊ8888)��\n"+
				"2����� �������� ��ť�����ָ���Ķ˿���������\n"+
				"3��ѡ����Ҫ�Ľ�����Ϣ���û�������Ϣ����д����Ϣ��֮���ɷ�����Ϣ��\n"+
				"4����Ϣ״̬������ʾ��������ǰ��������ֹͣ״̬��"+
				"�û����͵���Ϣ��\n  �������˷��͵�ϵͳ��Ϣ��");
		jtextArea.setEditable(false);
		contentPanel.add(jtextArea);
		this.getContentPane().add(contentPanel,BorderLayout.CENTER);
		
		closedPanel.add(new Label("                     "));
		close.setText("�ر�");
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
