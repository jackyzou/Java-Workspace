import java.awt.*;
import javax.swing.*;

public class MyWindow extends JFrame
{
  public MyWindow()
    {
	  createUserinterface();
  
    }
    public void createUserinterface()
    {
    	Container contentPane = getContentPane();
    	contentPane.setLayout(null);
    
    	//do add some stuff here
    	
    setTitle("My Window");
    setSize(1000,1000);
    setVisible(true);
    }
    
	public static void main(String args[]) //û��û��û����Ͳ��������������Ҫ
	{
	MyWindow app = new MyWindow();//construst a new object Mywindow app,���ԣ�������� MyWindow app2 = new MyWindow();��ô�ͻ���һ���µ�app.���ֿ������ġ�
	MyWindow app2 = new MyWindow();
	app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	
}
