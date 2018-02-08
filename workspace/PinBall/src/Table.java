import java.awt.Button; 
import java.awt.Color; 
import java.awt.FlowLayout; 
import java.awt.Frame; 
import java.awt.Graphics; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.awt.event.WindowEvent; 
import java.awt.event.WindowListener;
class Table extends Frame implements ActionListener, WindowListener {
Button star = new Button("开始"); 
Pinball t[] = new Pinball[5]; 
int v = 2;
Table() { 
super("子弹台球0"); 
setSize(300, 300); 
setBackground(Color.cyan); 
setVisible(true); 
setLayout(new FlowLayout()); 
add(star); 
star.addActionListener(this); 
validate(); 
addWindowListener(this);
}
public void actionPerformed(ActionEvent e) { 
for (int i = 0; i < t.length; i++) { 
int vx = i * (1 - i * (int) Math.round(Math.random())) + v; 
int vy = i * (1 - i * (int) Math.round(Math.random())) + v; 
int x = (int) (getSize().width * Math.random()); 
int y = (int) (getSize().height * Math.random()); 
t[i] = new Pinball(x, y, vx, vy,this);//注意此处 
t[i].start(); 
}
}
public void paint(Graphics g) { 
for (int i = 0; i < t.length; i++) { 
if (t[i] != null) 
t[i].draw(g);
} 
}
public void windowActivated(WindowEvent e) { 
// TODO Auto-generated method stub
}
public void windowClosed(WindowEvent e) { 
// TODO Auto-generated method stub
}
public void windowClosing(WindowEvent e) { 
System.exit(0); 
}
public void windowDeactivated(WindowEvent e) { 
// TODO Auto-generated method stub
}
public void windowDeiconified(WindowEvent e) { 
// TODO Auto-generated method stub
}
public void windowIconified(WindowEvent e) { 
// TODO Auto-generated method stub
}
public void windowOpened(WindowEvent e) { 
// TODO Auto-generated method stub
}
}
class S { 
public static void main(String[] args) { 
Table table = new Table();

}
}