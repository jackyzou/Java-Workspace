import java.awt.*;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.awt.event.KeyAdapter;

import java.awt.event.KeyEvent;

import javax.swing.*;

import javax.swing.border.TitledBorder;



public class homepage extends JFrame // makes class

{



private JPanel userBasic;

private Container contentPane;

private JTextField userNameJTextField;

private JLabel userNameJLabel;

private JTextField IDJTextField;

private JLabel IDJLabel;



// constructs objects this is called when

//screenController bjhsad = new screenController();

public homepage()

{

createUserInterface();

}


//method

private void createUserInterface()

{



//contentPane = what is in window

contentPane = getContentPane();

contentPane.setLayout(null);

contentPane.setBackground(Color.white);


userBasic = new JPanel();

userBasic.setBounds(0,0, 300, 300);

userBasic.setBorder( new TitledBorder( "User Basic Information" ) );

contentPane.add(userBasic);


userNameJLabel = new JLabel("User Name: ");

userNameJLabel.setBounds(0,85,100,30);

userNameJLabel.setForeground(Color.BLACK);

userBasic.add(userNameJLabel);


userNameJTextField = new JTextField("hj324234324d");

userNameJTextField.setBounds(30,65,12300,30);

userBasic.add(userNameJTextField);


IDJTextField = new JTextField();

IDJTextField.setBounds(30,65,100,30);

userBasic.add(IDJTextField);













//window stuff

setVisible(true);

setSize(1200,600);

setTitle("Home Page");





}



}