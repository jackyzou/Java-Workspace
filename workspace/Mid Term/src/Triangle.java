 import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


public class Triangle {
 enum Type{isosceles ,equilateral,right_angled,right_isosceles_angled,scalene,}
 public static void main(String args[]){
  new MyFrame();
 }

}

class MyFrame extends JFrame implements ActionListener{
 JButton jbOK=new JButton("OK");
 JTextField jf1=new JTextField(20);
 JTextField jf2=new JTextField(20);
 JTextField jf3=new JTextField(20);
 
 public MyFrame() {

  this.setTitle("Triangle");
  this.setBounds(100, 100, 240, 180); 
  this.setLayout(new FlowLayout());
  this.setSize(500,300);
  
  this.add(jf1);
  this.add(jf2);
  this.add(jf3);
  this.add(jbOK);
  this.setVisible(true);
  jbOK.addActionListener(this);
  
 }

 public void actionPerformed(ActionEvent e) {
  float a=0,b=0,c=0; 

  if(jf1.getText().equals("")||jf2.getText().equals("")||jf3.getText().equals(""))
  {
   JOptionPane.showMessageDialog(null, "Type in an integer", "Error", JOptionPane.ERROR_MESSAGE);
  }
  else{
	  
  a=Float.parseFloat(jf1.getText());
  b=Float.parseFloat(jf2.getText());
  c=Float.parseFloat(jf3.getText());
   System.out.println(a+" "+b+" "+c);
   sort(a,b,c);
  }
 }
 public void sort(float a,float b,float c){
	 Triangle.Type type=null;
  float temp[]=new float[3];
  temp[0]=a;
  temp[1]=b;
  temp[2]=c;
  for(int i=0;i<2;i++){
   float temp1 = 0;
   for(int j=0;j<2;j++){
    
    if(temp[j]<temp[j+1]){
     temp1=temp[j];
     temp[j]=temp[j+1];
     temp[j+1]=temp1;
    }
   }
    
  }
  if(temp[0]<temp[1]+temp[2]&&temp[0]-temp[2]<temp[1])
   {
     
   
   if(temp[0]==temp[1]||temp[1]==temp[2]){
    if(temp[0]==temp[2])
     type=Triangle.Type.equilateral;
    else if(temp[0]==Math.sqrt(Math.pow(temp[1], 2)+Math.pow(temp[2], 2)))
     type=Triangle.Type.right_isosceles_angled;
    else
     type=Triangle.Type.isosceles;
    
   }
   else if(temp[0]==Math.sqrt(Math.pow(temp[1], 2)+Math.pow(temp[2], 2)))
    type=Triangle.Type.right_angled;
   else
    type=Triangle.Type.scalene;
   JOptionPane.showMessageDialog(null, "It can make a triangle"+type,"alert" , JOptionPane.INFORMATION_MESSAGE);
   
   System.out.println(type);
   }  
  else
   JOptionPane.showMessageDialog(null, "Cannot make up a triangle","alert", JOptionPane.INFORMATION_MESSAGE);    
 }
  
}