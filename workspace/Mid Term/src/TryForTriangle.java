
import java.awt.*;



import java.awt.event.*;



import java.text.DecimalFormat;



import javax.swing.*;



public class TryForTriangle extends JFrame

{

private JLabel x1JLabel;

private JLabel y1JLabel;

private JLabel cord1JLabel;


private JLabel x2JLabel;

private JLabel y2JLabel;

private JLabel cord2JLabel;


private JLabel x3JLabel;

private JLabel y3JLabel;

private JLabel cord3JLabel;


private JTextField x1JTextField;

private JTextField y1JTextField;

private JTextField cord1JTextField;


private JTextField x2JTextField;

private JTextField y2JTextField;

private JTextField cord2JTextField;


private JTextField x3JTextField;

private JTextField y3JTextField;

private JTextField cord3JTextField;


private JButton goJButton;

private JButton go2JButton;

private JButton go3JButton;


private JLabel distanceJLabel;


private JButton c1c2JButton;

private JButton c1c3JButton;

private JButton c2c3JButton;


private JTextField c1c2JTextField;

private JTextField c1c3JTextField;

private JTextField c2c3JTextField;


private JButton checkDistanceJButton;

private JButton checkTriangleLengthJButton;

private JTextField triangleLengthTypeJTextField;


private JButton AngleMeasureJButton;

private JTextField angleMeasure1JTextField;

private JTextField angleMeasure2JTextField;

private JTextField angleMeasure3JTextField;


private JTextField angleTypeJTextField;

private JButton angleTypeJButton;


private JButton pictureJButton;

private JLabel pictureJLabel;

private JLabel pictureJLabel1;

private JLabel pictureJLabel2;

private JLabel pictureJLabel3;

private JLabel pictureJLabel4;

private JLabel pictureJLabel5;

private JLabel pictureJLabel6;

private JLabel pictureJLabel7;



private double a=0,b=0,c=0;

private double slope1=0,slope2=0,slope3=0;

private double c1c2,c1c3,c2c3;


public TryForTriangle()

{

createUserInterface();

}

private void createUserInterface()

{

// get content pane and set layout to null

Container contentPane = getContentPane();

contentPane.setLayout( null );

x1JLabel = new JLabel();

x1JLabel.setText( "Enter X1:" );

x1JLabel.setBounds( 16, 30, 140, 16 );

contentPane.add( x1JLabel );

x1JTextField = new JTextField();

x1JTextField.setBounds( 75, 30, 75, 21 );

contentPane.add( x1JTextField );

x1JTextField.addKeyListener(


new KeyAdapter()

{

public void keyPressed(KeyEvent event)

{

cord1JTextField.setText("");

triangleLengthTypeJTextField.setText("");

c1c2JTextField.setText("");

c1c3JTextField.setText("");

c2c3JTextField.setText("");


angleMeasure1JTextField.setText("");

angleMeasure2JTextField.setText("");

angleMeasure3JTextField.setText("");


angleTypeJTextField.setText("");

pictureJLabel1.setVisible(false);

pictureJLabel2.setVisible(false);

pictureJLabel3.setVisible(false);

pictureJLabel4.setVisible(false);

pictureJLabel5.setVisible(false);

pictureJLabel6.setVisible(false);

pictureJLabel7.setVisible(false);


}

}


);



y1JLabel = new JLabel();

y1JLabel.setText( "Enter Y1:" );

y1JLabel.setBounds( 16, 70, 75, 16 );

contentPane.add( y1JLabel );

y1JTextField = new JTextField();

y1JTextField.setBounds( 75, 70, 75, 21 );

contentPane.add( y1JTextField );

y1JTextField.addKeyListener(


new KeyAdapter()

{

public void keyPressed(KeyEvent event)

{

cord1JTextField.setText("");

triangleLengthTypeJTextField.setText("");

c1c2JTextField.setText("");

c1c3JTextField.setText("");

c2c3JTextField.setText("");


angleMeasure1JTextField.setText("");

angleMeasure2JTextField.setText("");

angleMeasure3JTextField.setText("");


angleTypeJTextField.setText("");

pictureJLabel1.setVisible(false);

pictureJLabel2.setVisible(false);

pictureJLabel3.setVisible(false);

pictureJLabel4.setVisible(false);

pictureJLabel5.setVisible(false);

pictureJLabel6.setVisible(false);

pictureJLabel7.setVisible(false);

}

}


);

cord1JLabel= new JLabel();

cord1JLabel.setText( "cord 1:" );

cord1JLabel.setBounds( 200, 50, 140, 16 );

contentPane.add( cord1JLabel );

cord1JTextField = new JTextField();

cord1JTextField.setBounds( 250, 50, 100, 21 );

cord1JTextField.setEditable(false);

contentPane.add( cord1JTextField );



goJButton = new JButton();//calculates coordnates

goJButton.setText( "Calculate cord 1" );

goJButton.setBounds( 80, 100, 200, 30 );

contentPane.add( goJButton );

goJButton.addActionListener(



new ActionListener() // anonymous inner class

{

// event handler called when enterJButton is pressed

public void actionPerformed( ActionEvent event )

{

try

{

Double x1= Double.parseDouble(x1JTextField.getText());

Double y1= Double.parseDouble(y1JTextField.getText());


cord1JTextField.setText(String.valueOf("( "+x1+" , "+y1+" )"));

}

catch(Exception e)

{

JOptionPane.showMessageDialog(null, "please enter a double/number","ERROR", JOptionPane.ERROR_MESSAGE);

}

}



} // end anonymous inner class



);

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

x2JLabel = new JLabel();

x2JLabel.setText( "Enter X2:" );

x2JLabel.setBounds( 16, 150, 140, 16 );

contentPane.add( x2JLabel );

x2JTextField = new JTextField();

x2JTextField.setBounds( 75, 150, 75, 21 );

contentPane.add( x2JTextField );

x2JTextField.addKeyListener(


new KeyAdapter()

{

public void keyPressed(KeyEvent event)

{

cord2JTextField.setText("");

triangleLengthTypeJTextField.setText("");

c1c2JTextField.setText("");

c1c3JTextField.setText("");

c2c3JTextField.setText("");


angleMeasure1JTextField.setText("");

angleMeasure2JTextField.setText("");

angleMeasure3JTextField.setText("");


angleTypeJTextField.setText("");

pictureJLabel1.setVisible(false);

pictureJLabel2.setVisible(false);

pictureJLabel3.setVisible(false);

pictureJLabel4.setVisible(false);

pictureJLabel5.setVisible(false);

pictureJLabel6.setVisible(false);

pictureJLabel7.setVisible(false);



}

}


);



y2JLabel = new JLabel();

y2JLabel.setText( "Enter Y2:" );

y2JLabel.setBounds( 16, 190, 75, 16 );

contentPane.add( y2JLabel );

y2JTextField = new JTextField();

y2JTextField.setBounds( 75, 190, 75, 21 );

contentPane.add( y2JTextField );

y2JTextField.addKeyListener(


new KeyAdapter()

{

public void keyPressed(KeyEvent event)

{

cord2JTextField.setText("");

triangleLengthTypeJTextField.setText("");

c1c2JTextField.setText("");

c1c3JTextField.setText("");

c2c3JTextField.setText("");


angleMeasure1JTextField.setText("");

angleMeasure2JTextField.setText("");

angleMeasure3JTextField.setText("");


angleTypeJTextField.setText("");

pictureJLabel1.setVisible(false);

pictureJLabel2.setVisible(false);

pictureJLabel3.setVisible(false);

pictureJLabel4.setVisible(false);

pictureJLabel5.setVisible(false);

pictureJLabel6.setVisible(false);

pictureJLabel7.setVisible(false);



}

}


);

cord2JLabel= new JLabel();

cord2JLabel.setText( "cord 2:" );

cord2JLabel.setBounds( 200, 170, 140, 16 );

contentPane.add( cord2JLabel );

cord2JTextField = new JTextField();

cord2JTextField.setBounds( 250, 170, 100, 21 );

cord2JTextField.setEditable(false);

contentPane.add( cord2JTextField );

go2JButton = new JButton();//calculates coordinates

go2JButton.setText( "Calculate cord 2" );

go2JButton.setBounds( 80, 230, 200, 30 );

contentPane.add( go2JButton );

go2JButton.addActionListener(



new ActionListener() // anonymous inner class

{

// event handler called when enterJButton is pressed

public void actionPerformed( ActionEvent event )

{

try

{

Double x2= Double.parseDouble(x2JTextField.getText());

Double y2= Double.parseDouble(y2JTextField.getText());


cord2JTextField.setText(String.valueOf("( "+x2+" , "+y2+" )"));

}

catch(Exception e)

{

JOptionPane.showMessageDialog(null, "please enter a double/number","ERROR", JOptionPane.ERROR_MESSAGE);

}

}



}



);

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

x3JLabel = new JLabel();

x3JLabel.setText( "Enter X3:" );

x3JLabel.setBounds( 16, 280, 140, 16 );

contentPane.add( x3JLabel );

x3JTextField = new JTextField();

x3JTextField.setBounds( 75, 280, 75, 21 );

contentPane.add( x3JTextField );

x3JTextField.addKeyListener(


new KeyAdapter()

{

public void keyPressed(KeyEvent event)

{

cord3JTextField.setText("");

triangleLengthTypeJTextField.setText("");

c1c2JTextField.setText("");

c1c3JTextField.setText("");

c2c3JTextField.setText("");


angleMeasure1JTextField.setText("");

angleMeasure2JTextField.setText("");

angleMeasure3JTextField.setText("");


angleTypeJTextField.setText("");

pictureJLabel1.setVisible(false);

pictureJLabel2.setVisible(false);

pictureJLabel3.setVisible(false);

pictureJLabel4.setVisible(false);

pictureJLabel5.setVisible(false);

pictureJLabel6.setVisible(false);

pictureJLabel7.setVisible(false);



}

}


);



y3JLabel = new JLabel();

y3JLabel.setText( "Enter Y3:" );

y3JLabel.setBounds( 16, 320, 75, 16 );

contentPane.add( y3JLabel );

y3JTextField = new JTextField();

y3JTextField.setBounds( 75, 320, 75, 21 );

contentPane.add( y3JTextField );

y3JTextField.addKeyListener(


new KeyAdapter()

{

public void keyPressed(KeyEvent event)

{

cord3JTextField.setText("");

triangleLengthTypeJTextField.setText("");

c1c2JTextField.setText("");

c1c3JTextField.setText("");

c2c3JTextField.setText("");


angleMeasure1JTextField.setText("");

angleMeasure2JTextField.setText("");

angleMeasure3JTextField.setText("");


angleTypeJTextField.setText("");

pictureJLabel1.setVisible(false);

pictureJLabel2.setVisible(false);

pictureJLabel3.setVisible(false);

pictureJLabel4.setVisible(false);

pictureJLabel5.setVisible(false);

pictureJLabel6.setVisible(false);

pictureJLabel7.setVisible(false);



}

}


);

cord3JLabel= new JLabel();

cord3JLabel.setText( "cord 3:" );

cord3JLabel.setBounds( 200, 300, 140, 16 );

contentPane.add( cord3JLabel );

cord3JTextField = new JTextField();

cord3JTextField.setBounds( 250, 300, 100, 21 );

cord3JTextField.setEditable(false);

contentPane.add( cord3JTextField );

go3JButton = new JButton();//calculates coordinates

go3JButton.setText( "Calculate cord 3" );

go3JButton.setBounds( 80, 350, 200, 30 );

contentPane.add( go3JButton );

go3JButton.addActionListener(



new ActionListener() // anonymous inner class

{

// event handler called when enterJButton is pressed

public void actionPerformed( ActionEvent event )

{

try

{

Double x3= Double.parseDouble(x3JTextField.getText());

Double y3= Double.parseDouble(y3JTextField.getText());


cord3JTextField.setText(String.valueOf("( "+x3+" , "+y3+" )"));

}

catch(Exception e)

{

JOptionPane.showMessageDialog(null, "please enter a double/number","ERROR", JOptionPane.ERROR_MESSAGE);

}

}



}



);

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////




distanceJLabel = new JLabel();

distanceJLabel.setText( "Click to find the distances between: " );

distanceJLabel.setVisible(true);

distanceJLabel.setBounds( 425, 20, 300, 16 );

contentPane.add( distanceJLabel );



c1c2JButton = new JButton();//calculates coordnates

c1c2JButton.setText( "C1 C2" );

c1c2JButton.setVisible(true);

c1c2JButton.setBounds( 400, 50, 100, 30 );

contentPane.add( c1c2JButton );

c1c2JButton.addActionListener(



new ActionListener() // anonymous inner class

{

// event handler called when enterJButton is pressed

public void actionPerformed( ActionEvent event )

{

try

{

Double x1= Double.parseDouble(x1JTextField.getText());

Double y1= Double.parseDouble(y1JTextField.getText());


Double x2= Double.parseDouble(x2JTextField.getText());

Double y2= Double.parseDouble(y2JTextField.getText());


c1c2=Math.sqrt(Math.pow((x2-x1),2)+Math.pow((y2-y1),2));



DecimalFormat decform= new DecimalFormat("0.00");

c1c2JTextField.setText(String.valueOf(decform.format(c1c2)));

c1c2JTextField.setVisible(true);

}

catch(Exception x)

{

JOptionPane.showMessageDialog(null, "you need to have two valid coordnates: coordinate 1 and coordnate 2","ERROR",

JOptionPane.ERROR_MESSAGE);

}



}



}



);


c1c3JButton = new JButton();//calculates coordnates

c1c3JButton.setText( "C1 C3" );

c1c3JButton.setVisible(true);

c1c3JButton.setBounds( 500, 50, 100, 30 );

contentPane.add( c1c3JButton );

c1c3JButton.addActionListener(



new ActionListener() // anonymous inner class

{

// event handler called when enterJButton is pressed

public void actionPerformed( ActionEvent event )

{

try{

Double x1= Double.parseDouble(x1JTextField.getText());

Double y1= Double.parseDouble(y1JTextField.getText());


Double x3= Double.parseDouble(x3JTextField.getText());

Double y3= Double.parseDouble(y3JTextField.getText());


c1c3=Math.sqrt(Math.pow((x3-x1),2)+Math.pow((y3-y1),2));

DecimalFormat decform= new DecimalFormat("0.00");

c1c3JTextField.setText(String.valueOf(decform.format(c1c3)));

c1c3JTextField.setVisible(true);

}

catch(Exception x)

{

JOptionPane.showMessageDialog(null, "you need to have two valid coordnates: coordinate 1 and coordnate 3","ERROR",

JOptionPane.ERROR_MESSAGE);

}



}



}



);

c2c3JButton = new JButton();//calculates coordnates

c2c3JButton.setText( "C2 C3" );

c2c3JButton.setVisible(true);

c2c3JButton.setBounds( 600, 50, 100, 30 );

contentPane.add( c2c3JButton );

c2c3JButton.addActionListener(



new ActionListener() // anonymous inner class

{

// event handler called when enterJButton is pressed

public void actionPerformed( ActionEvent event )

{

try{

Double x2 = Double.parseDouble(x2JTextField.getText());

Double y2 = Double.parseDouble(y2JTextField.getText());


Double x3 = Double.parseDouble(x3JTextField.getText());

Double y3 = Double.parseDouble(y3JTextField.getText());


c2c3 = Math.sqrt(Math.pow((x3-x2),2)+Math.pow((y3-y2),2));

DecimalFormat decform = new DecimalFormat("0.00");

c2c3JTextField.setText(String.valueOf(decform.format(c2c3)));

c2c3JTextField.setVisible(true);

}

catch(Exception x)

{

JOptionPane.showMessageDialog(null, "you need to have two valid coordnates: coordinate 2 and coordnate 3","ERROR",

JOptionPane.ERROR_MESSAGE);

}



}



}



);

c1c2JTextField = new JTextField("hi1");

c1c2JTextField.setBounds( 400, 100, 100, 21 );

c1c2JTextField.setEditable(false);

c1c2JTextField.setVisible(false);

contentPane.add( c1c2JTextField );

c1c3JTextField = new JTextField("hi2");

c1c3JTextField.setBounds( 500, 100, 100, 21 );

c1c3JTextField.setEditable(false);

c1c3JTextField.setVisible(false);

contentPane.add( c1c3JTextField );

c2c3JTextField = new JTextField("hi3");

c2c3JTextField.setBounds( 600, 100, 100, 21 );

c2c3JTextField.setEditable(false);

c2c3JTextField.setVisible(false);

contentPane.add( c2c3JTextField );

checkTriangleLengthJButton=new JButton("check triangle type by lengths");

checkTriangleLengthJButton.setBounds( 400, 200, 270, 30 );

checkTriangleLengthJButton.setVisible(true);

contentPane.add( checkTriangleLengthJButton );

checkTriangleLengthJButton.addActionListener(



new ActionListener() // anonymous inner class

{

// event handler called when enterJButton is pressed

public void actionPerformed( ActionEvent event )

{

try{



a= Double.parseDouble(c1c2JTextField.getText());

b= Double.parseDouble(c2c3JTextField.getText());

c= Double.parseDouble(c1c3JTextField.getText());


Double x1=Double.parseDouble(x1JTextField.getText());

Double x2=Double.parseDouble(x2JTextField.getText());

Double x3=Double.parseDouble(x3JTextField.getText());


Double y1=Double.parseDouble(y1JTextField.getText());

Double y2=Double.parseDouble(y2JTextField.getText());

Double y3=Double.parseDouble(y3JTextField.getText());


System.out.println(a);

System.out.println(b);

System.out.println(c);


slope1 = (y1-y2)/(x1-x2);

slope2 = (y1-y3)/(x1-x3);

slope3 = (y2-y3)/(x2-x3);


System.out.println("//////////////////////////");

System.out.println(slope1);

System.out.println(slope2);

System.out.println(slope3);


if((x1==x2 && x2==x3 && x1==x3) || (y1==y2 && y2==y3 && y1==y3) ||

(slope1==slope2) || (slope1==slope3) || (slope2==slope3))


{

JOptionPane.showMessageDialog(null, "These coornates do not form a triangle","ERROR",

JOptionPane.ERROR_MESSAGE);

}

else

{

if(a==c && a==b && b==c)

{

triangleLengthTypeJTextField.setText("eqilateral");

}

else if((a == c))

{

triangleLengthTypeJTextField.setText("issoceles");

}

else if(a == b)

{

triangleLengthTypeJTextField.setText("issoceles");

}

else if(b == c)

{

triangleLengthTypeJTextField.setText("issoceles");

}

else if(!(a==b) && !(a==c) && !(b==c))

{

triangleLengthTypeJTextField.setText("Scalene");

}

else

{

System.err.print("YOUR FACE DOE");

}

}

}

catch(Exception x)

{

JOptionPane.showMessageDialog(null, "you need to have to calculate all 3 sides to do this","ERROR",

JOptionPane.ERROR_MESSAGE);

}




}



}



);

triangleLengthTypeJTextField=new JTextField();

triangleLengthTypeJTextField.setBounds( 400, 250, 100, 21 );

triangleLengthTypeJTextField.setEditable(false);

triangleLengthTypeJTextField.setVisible(true);

contentPane.add( triangleLengthTypeJTextField );

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

AngleMeasureJButton= new JButton(" Angles Measurments");

AngleMeasureJButton.setBounds( 810, 60, 180, 30 );

AngleMeasureJButton.setVisible(true);

contentPane.add( AngleMeasureJButton );

AngleMeasureJButton.addActionListener(



new ActionListener() // anonymous inner class

{

// event handler called when enterJButton is pressed

public void actionPerformed( ActionEvent event )

{

try{

Double a = c1c2;

Double b = c2c3;

Double c = c1c3;

DecimalFormat decform= new DecimalFormat("0.00");



double A = ((((a * a) - ((b * b) + (c * c))) / ((-2.0) * c * b)));

double angleA = Math.acos(A) * (180/Math.PI);


angleMeasure1JTextField.setText(String.valueOf(decform.format(angleA)));



double B = ((((b * b) - ((a * a) + (c * c))) / ((-2.0) * c * a)));

double angleB = Math.acos(B) * (180/Math.PI);


angleMeasure2JTextField.setText(String.valueOf(decform.format(angleB)));


double C = ((((c * c) - ((b * b) + (a * a))) / ((-2.0) * a * b)));

double angleC = Math.acos(C) * (180/Math.PI);


angleMeasure3JTextField.setText(String.valueOf(decform.format(angleC)));





}


catch(Exception x)

{

JOptionPane.showMessageDialog(null, "you need to have three valid coordnates","ERROR",

JOptionPane.ERROR_MESSAGE);

}




}



}



);

angleMeasure1JTextField=new JTextField();

angleMeasure1JTextField.setBounds( 850, 100, 100, 21 );

angleMeasure1JTextField.setEditable(false);

angleMeasure1JTextField.setVisible(true);

contentPane.add( angleMeasure1JTextField );

angleMeasure2JTextField=new JTextField();

angleMeasure2JTextField.setBounds( 850, 130, 100, 21 );

angleMeasure2JTextField.setEditable(false);

angleMeasure2JTextField.setVisible(true);

contentPane.add( angleMeasure2JTextField );

angleMeasure3JTextField=new JTextField();

angleMeasure3JTextField.setBounds( 850, 160, 100, 21 );

angleMeasure3JTextField.setEditable(false);

angleMeasure3JTextField.setVisible(true);

contentPane.add( angleMeasure3JTextField );

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

angleTypeJButton = new JButton("Triangle type by angle");

angleTypeJButton.setBounds( 800, 260, 190, 21 );

contentPane.add( angleTypeJButton );

angleTypeJButton.addActionListener(



new ActionListener() // anonymous inner class

{

// event handler called when enterJButton is pressed

public void actionPerformed( ActionEvent event )

{



try{

Double angle1 =Double.parseDouble(angleMeasure1JTextField.getText());

Double angle2 =Double.parseDouble(angleMeasure2JTextField.getText());

Double angle3 =Double.parseDouble(angleMeasure3JTextField.getText());


if(angle1 > 90 || angle2 > 90 || angle3 > 90)

{

angleTypeJTextField.setText("obtuse");

}

else if(angle1 == 90 || angle2 == 90 || angle3 == 90 )

{

angleTypeJTextField.setText("right");

}

else

{

angleTypeJTextField.setText("acute");

}

}



catch(Exception x)

{

JOptionPane.showMessageDialog(null, "you need to calculate all 3 angle measures","ERROR",

JOptionPane.ERROR_MESSAGE);

}

}


}

);



// set up pictureJLabel

pictureJLabel = new JLabel();

pictureJLabel.setIcon(new ImageIcon("horizontal line.jpg"));

pictureJLabel.setBounds(0,410,450,10);//sets everything(x,y,width,length)

pictureJLabel.setHorizontalAlignment(JLabel.CENTER);

contentPane.add( pictureJLabel );

// set up pictureJLabel

pictureJLabel = new JLabel();

pictureJLabel.setIcon(new ImageIcon("horizontal line.jpg"));

pictureJLabel.setBounds(600,410,450,10);//sets everything(x,y,width,length)

pictureJLabel.setHorizontalAlignment(JLabel.CENTER);

contentPane.add( pictureJLabel );

// set up pictureJLabel

pictureJLabel = new JLabel();

pictureJLabel.setIcon(new ImageIcon("vertical_line.jpg"));

pictureJLabel.setBounds(370,10,1,400);//sets everything(x,y,width,length)

contentPane.add( pictureJLabel );

// set up pictureJLabel

pictureJLabel = new JLabel();

pictureJLabel.setIcon(new ImageIcon("vertical_line.jpg"));

pictureJLabel.setBounds(750,10,1,400);//sets everything(x,y,width,length)

contentPane.add( pictureJLabel );

angleTypeJTextField = new JTextField();

angleTypeJTextField.setBounds( 850, 300, 100, 21 );

angleMeasure3JTextField.setEditable(false);

contentPane.add( angleTypeJTextField );

pictureJButton = new JButton("Picture of Triangle");

pictureJButton.setBounds(450,400,150,30);

contentPane.add( pictureJButton );

pictureJButton.addActionListener(


new ActionListener() // anonymous inner class

{

// event handler called when enterJButton is pressed

public void actionPerformed( ActionEvent event )

{

try{


String lengthType = triangleLengthTypeJTextField.getText();

String angleType = angleTypeJTextField.getText();


if(lengthType.equals("eqilateral"))

{

pictureJLabel5.setVisible(true);


pictureJLabel7.setVisible(false);

pictureJLabel6.setVisible(false);

pictureJLabel4.setVisible(false);

pictureJLabel3.setVisible(false);

pictureJLabel2.setVisible(false);

pictureJLabel1.setVisible(false);

}

else if(lengthType.equals("issoceles"))

{

if(angleType.equals("acute"))

{

pictureJLabel1.setVisible(true);


pictureJLabel7.setVisible(false);

pictureJLabel6.setVisible(false);

pictureJLabel5.setVisible(false);

pictureJLabel4.setVisible(false);

pictureJLabel3.setVisible(false);

pictureJLabel2.setVisible(false);

}

else if(angleType.equals("right"))

{

pictureJLabel2.setVisible(true);


pictureJLabel7.setVisible(false);

pictureJLabel6.setVisible(false);

pictureJLabel5.setVisible(false);

pictureJLabel4.setVisible(false);

pictureJLabel3.setVisible(false);

pictureJLabel1.setVisible(false);

}

else //obtuse

{

pictureJLabel3.setVisible(true);


pictureJLabel7.setVisible(false);

pictureJLabel6.setVisible(false);

pictureJLabel5.setVisible(false);

pictureJLabel4.setVisible(false);

pictureJLabel2.setVisible(false);

pictureJLabel1.setVisible(false);

}

}

else

{

if(angleType.equals("acute"))

{

pictureJLabel4.setVisible(true);


pictureJLabel7.setVisible(false);

pictureJLabel6.setVisible(false);

pictureJLabel5.setVisible(false);

pictureJLabel1.setVisible(false);

pictureJLabel3.setVisible(false);

pictureJLabel2.setVisible(false);

}

else if(angleType.equals("right"))

{

pictureJLabel6.setVisible(true);


pictureJLabel7.setVisible(false);

pictureJLabel5.setVisible(false);

pictureJLabel4.setVisible(false);

pictureJLabel3.setVisible(false);

pictureJLabel2.setVisible(false);

pictureJLabel1.setVisible(false);

}

else//obtuse

{

pictureJLabel7.setVisible(true);


pictureJLabel6.setVisible(false);

pictureJLabel5.setVisible(false);

pictureJLabel4.setVisible(false);

pictureJLabel3.setVisible(false);

pictureJLabel2.setVisible(false);

pictureJLabel1.setVisible(false);


}

}




}

catch(Exception x)

{

JOptionPane.showMessageDialog(null, "you need to have all the information above","ERROR",

JOptionPane.ERROR_MESSAGE);

}


}


}

);



// set up pictureJLabel

pictureJLabel1 = new JLabel();

pictureJLabel1.setIcon(new ImageIcon("isosceles acute.gif"));

pictureJLabel1.setBounds(450,200,700,700);//sets everything(x,y,width,length)

pictureJLabel1.setVisible(false);

contentPane.add( pictureJLabel1 );

// set up pictureJLabel

pictureJLabel2 = new JLabel();

pictureJLabel2.setIcon(new ImageIcon("Isosceles-right-triangle.png"));

pictureJLabel2.setBounds(400,400,350,300);//sets everything(x,y,width,length)

pictureJLabel2.setVisible(false);

contentPane.add( pictureJLabel2 );

// set up pictureJLabel

pictureJLabel3 = new JLabel();

pictureJLabel3.setIcon(new ImageIcon("obtuse triangle.png"));//issoceles

pictureJLabel3.setBounds(150,300,700,700);//sets everything(x,y,width,length)

pictureJLabel3.setVisible(false);

contentPane.add( pictureJLabel3 );

// set up pictureJLabel

pictureJLabel4 = new JLabel();

pictureJLabel4.setIcon(new ImageIcon("scalene acute.jpeg"));

pictureJLabel4.setBounds(450,200,700,700);//sets everything(x,y,width,length)

pictureJLabel4.setVisible(false);

contentPane.add( pictureJLabel4 );

// set up pictureJLabel

pictureJLabel5 = new JLabel();

pictureJLabel5.setIcon(new ImageIcon("Triangle.Equilateral.png"));

pictureJLabel5.setBounds(450,200,700,700);//sets everything(x,y,width,length)

pictureJLabel5.setVisible(false);

contentPane.add( pictureJLabel5 );

// set up pictureJLabel

pictureJLabel6 = new JLabel();

pictureJLabel6.setIcon(new ImageIcon("scalene-right.gif"));

pictureJLabel6.setBounds(450,250,700,700);//sets everything(x,y,width,length)

pictureJLabel6.setVisible(false);

contentPane.add( pictureJLabel6 );

// set up pictureJLabel

pictureJLabel6 = new JLabel();

pictureJLabel6.setIcon(new ImageIcon("scalene-right.gif"));

pictureJLabel6.setBounds(450,250,700,700);//sets everything(x,y,width,length)

pictureJLabel6.setVisible(false);

contentPane.add( pictureJLabel6 );

// set up pictureJLabel

pictureJLabel7 = new JLabel();

pictureJLabel7.setIcon(new ImageIcon("scalene obtuse.png"));

pictureJLabel7.setBounds(450,250,700,700);//sets everything(x,y,width,length)

pictureJLabel7.setVisible(false);

contentPane.add( pictureJLabel7 );

// set properties of application's window

setTitle( "Triangle coordnates" ); // set title bar text

setSize( 1000, 800 ); // set window's size

setVisible( true ); // display window



} // end method createUserInterface



// add previous balance to deposit and display result





// main method

public static void main( String[] args )

{

	TryForTriangle application = new TryForTriangle();

application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );



} // end method main



} // end class AccountInformation

