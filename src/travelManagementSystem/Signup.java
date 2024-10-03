package travelManagementSystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Signup extends JFrame implements ActionListener {

	JButton create, back;
	JTextField tfusername, tfpassword, tfname, tfanswer;
	Choice security;

	Signup() {
//		setBounds(350,200,900,360);
		setSize(700, 400);
		setLocation(300, 150);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);

		JPanel p1 = new JPanel();
		p1.setBackground(new Color(137, 159, 166));
		p1.setBounds(0, 0, 380, 440);
		p1.setLayout(null);
		add(p1);

		JLabel lbusername = new JLabel("Username");
		lbusername.setFont(new Font("SANS_SERIF", Font.PLAIN, 17));
		lbusername.setBounds(15, 30, 125, 25);
		p1.add(lbusername);

		tfusername = new JTextField();
		tfusername.setBounds(110, 30, 180, 30);
		tfusername.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfusername);

		JLabel lbname = new JLabel("Name");
		lbname.setFont(new Font("SANS_SERIF", Font.PLAIN, 17));
		lbname.setBounds(15, 75, 125, 25);
		p1.add(lbname);

		tfname = new JTextField();
		tfname.setBounds(110, 75, 180, 30);
		tfname.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfname);

		JLabel lbpassword = new JLabel("Password");
		lbpassword.setFont(new Font("SANS_SERIF", Font.PLAIN, 17));
		lbpassword.setBounds(15, 120, 125, 25);
		p1.add(lbpassword);

		tfpassword = new JTextField();
		tfpassword.setBounds(110, 120, 180, 30);
		tfpassword.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfpassword);

		JLabel lbsecurity = new JLabel("Security");
		JLabel lbsecurity2 = new JLabel("Question");
		lbsecurity.setFont(new Font("SANS_SERIF", Font.PLAIN, 17));
		lbsecurity.setBounds(15, 165, 90, 25);
		p1.add(lbsecurity);
		lbsecurity2.setFont(new Font("SANS_SERIF", Font.PLAIN, 17));
		lbsecurity2.setBounds(15, 178, 90, 25);
		p1.add(lbsecurity2);

		security = new Choice();
		security.add("Fav character from Friends");
		security.add("fav Marvel Superhero");
		security.add("Your lucky number");
		security.add("your childhood Superhero");
		security.setBounds(113, 168, 180, 30);
		p1.add(security);

		JLabel lbanswer = new JLabel("Answer");
		lbanswer.setFont(new Font("SANS_SERIF", Font.PLAIN, 17));
		lbanswer.setBounds(15, 210, 125, 25);
		p1.add(lbanswer);

		tfanswer = new JTextField();
		tfanswer.setBounds(110, 210, 180, 30);
		tfanswer.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfanswer);

		create = new JButton("Create");
		create.setBackground(new Color(70, 129, 244));
		create.setForeground(Color.white);
		create.setFont(new Font("SANS_SERIF", Font.PLAIN, 14));
		create.setBounds(35, 270, 90, 35);
		create.addActionListener(this);
		p1.add(create);

		back = new JButton("Back");
		back.setBackground(new Color(70, 129, 244));
		back.setForeground(Color.white);
		back.setFont(new Font("SANS_SERIF", Font.PLAIN, 14));
		back.setBounds(190, 270,90, 35);
		back.addActionListener(this);
		p1.add(back);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
		Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(410, 50, 250, 250);
		add(image);

		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == create) {
			String username = tfusername.getText();
			String name= tfname.getText();
			String password = tfpassword.getText();
			String question = security.getSelectedItem();
			String answer = tfanswer.getText();
			
			String query = "insert into account values ('"+username+"', '"+name+"', '"+password+"', '"+question+"','"+answer+"')";
			try {
				conn c = new conn();
				c.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null, "Account Created Successfully");
				setVisible(false);
				new Login();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		} else if (ae.getSource() == back) {
			setVisible(false);
			new Login();
		}

	}

	public static void main(String[] args) {
		new Signup();
	}

}
