package travelManagementSystem;

import java.awt.*;

import java.awt.event.*;

import javax.swing.border.*;
import javax.swing.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener{
	JButton login, signup, password;
	JTextField tfusername, tfpassword;
	
	Login() {
		setSize(700, 400);
		setLocation(300, 150);
		setLayout(null);
		
		getContentPane().setBackground(Color.WHITE);
		
		JPanel p1 = new JPanel();
		p1.setBackground(new Color(137, 159, 166));
		p1.setBounds(0,0,340, 440);
		p1.setLayout(null);
		add(p1);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
		Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(85,80,200,200);
		p1.add(image);
		
		JPanel p2 = new JPanel();
		p2.setLayout(null);
		p2.setBounds(340,0, 500, 550);
		add(p2);
		
		JLabel lbusername = new JLabel("Username");
		lbusername.setBounds(20,15,100,35);
		lbusername.setFont(new Font("SANS_SERIF", Font.PLAIN, 18));
		p2.add(lbusername);
		
		
		tfusername = new JTextField();
		tfusername.setBounds(25, 60, 300, 35);
		p2.add(tfusername);
		tfusername.setBorder(BorderFactory.createEmptyBorder());
		
		JLabel lbpassword = new JLabel("Password");
		lbpassword.setBounds(20,110,100,25);
		lbpassword.setFont(new Font("SANS_SERIF", Font.PLAIN, 18));
		p2.add(lbpassword);
		
		
		tfpassword = new JTextField();
		tfpassword.setBounds(25, 150, 300, 35);
		tfpassword.setBorder(BorderFactory.createEmptyBorder());
		p2.add(tfpassword);
		
		login = new JButton("Login"); 
		login.setBounds(30,230,90, 35);
		login.setBackground(new Color(70, 129, 244));
		login.setForeground(Color.WHITE);
		login.setBorder(new LineBorder(new Color(10,10,35)));
		login.addActionListener(this);
		p2.add(login);
		
		signup = new JButton("Signup"); 
		signup.setBounds(180,230,90, 35);
		signup.setBackground(new Color(70, 129, 244));
		signup.setForeground(Color.WHITE);
		signup.setBorder(new LineBorder(new Color(10,10,35)));
		signup.addActionListener(this);
		p2.add(signup);
		
		password = new JButton("Forget Password"); 
		password.setBounds(100,290,110, 35);
		password.setBackground(new Color(70, 129, 244));
		password.setForeground(Color.WHITE);
		password.setBorder(new LineBorder(new Color(10,10,35)));
		password.addActionListener(this);
		p2.add(password);
		
//		JLabel text = new JLabel("Trouble in Login...");
//		text.setBounds(150,350,150,40);
//		text.setFont(new Font("SANS_SERIF", Font.PLAIN, 18));
//		text.setForeground(Color.RED);
//		p2.add(text);
		
		
		setVisible(true);
	}

	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource()==login) {
			try {
				String username = tfusername.getText();
				String pass = tfpassword.getText();
				
				String query  =  "select * from account where username = '"+username+"'AND password = '"+pass+"'";
				conn c = new conn();
				ResultSet rs =c.s.executeQuery(query);
				if(rs.next()) {
					setVisible(false);
					new Loading(username);
				}else {
					JOptionPane.showMessageDialog(null, "incorrect username or password");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(ae.getSource()==signup) {
			setVisible(false);
			new Signup()
;		}else {
			this.setVisible(false);
			new ForgetPassword();		}
		
	}
	


	public static void main(String[] args) {
		new Login();

	}

}
