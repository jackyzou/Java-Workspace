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
    
	public static void main(String args[]) //没有没错，没这个就不工作，这个很重要
	{
	MyWindow app = new MyWindow();//construst a new object Mywindow app,所以，如果打入 MyWindow app2 = new MyWindow();那么就会有一个新的app.名字可以随便改。
	MyWindow app2 = new MyWindow();
	app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	
}
