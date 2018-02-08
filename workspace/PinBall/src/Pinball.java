import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
public class Pinball extends Thread { 
Table table = null; 
int x, y, vx, vy;
Pinball(int x, int y, int vx, int vy, Table table) { 
this.x = x; 
this.y = y; 
this.vx = vx; 
this.vy = vy; 
this.table = table;//×¢Òâ´Ë´¦
}
public void run() { 
while (true) { 
if (x > (table.getSize().width) - 25 || (x < 0)) 
vx = vx * -1; 
if (y > (table.getSize().width) - 25 || (y < 0)) 
vy *= -1; 
x += vx; 
y += vy; 
try { 
Thread.sleep(100);
} catch (Exception e) {
} 
table.repaint(); 
}
}
public void draw(Graphics g) { 
g.setColor(Color.BLACK); 
g.fillOval(x, y, 30, 30); 
g.setColor(Color.white); 
g.fillOval(x + 5, y + 5, 8, 6);
} 
}