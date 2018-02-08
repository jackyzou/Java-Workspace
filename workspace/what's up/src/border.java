import java.awt.*;
import java.awt.event.*;
import javax.swing .*;
import javax.swing.BorderFactory; 
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
public class border extends JFrame
{
JPanel compoundpanel,titledpanel;
Container cont;
Border compound,titled,raisedbevel,loweredbevel ;
JTabbedPane pane;
public border()
{
cont=getContentPane();
pane=new JTabbedPane();
compoundpanel=new JPanel();
raisedbevel = BorderFactory.createRaisedBevelBorder();
loweredbevel = BorderFactory.createLoweredBevelBorder();
compoundpanel.setBorder(BorderFactory.createCompoundBorder(raisedbevel,loweredbevel));
titledpanel=new JPanel();
titledpanel.setBorder(BorderFactory.createTitledBorder("title"));

pane.addTab("titled",titledpanel);
pane.addTab("compound",compoundpanel);
cont.add(pane,BorderLayout.CENTER);
}

public static void main(String a[])
{
JFrame frame =new border();
frame.setSize(400,400);
frame.setVisible(true);
}
}
