package travelManagementSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class ForgetPassword extends JFrame implements ActionListener {

	JTextField tfusername, tfname, tfquestion, tfanswer, tfpassword;
	JButton search, retrieve, back;

	ForgetPassword() {
//		setBounds(350,200,850,380);
		setSize(700, 400);
		setLocation(300, 150);

		getContentPane().setBackground(Color.WHITE);
		setLayout(null);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
		Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(450, 70, 200, 200);
		add(image);

		JPanel p1 = new JPanel();
		p1.setLayout(null);
		p1.setBounds(0, 0, 420, 350);
		add(p1);

		JLabel lbusername = new JLabel("Username");
		lbusername.setBounds(40, 30, 100, 25);
		lbusername.setFont(new Font("Tahoma", Font.BOLD, 14));
		p1.add(lbusername);

		tfusername = new JTextField();
		tfusername.setBounds(150, 30, 150, 30);
		tfusername.setBorder((BorderFactory.createEmptyBorder()));
		p1.add(tfusername);

		search = new JButton("Search");
		search.setBackground(Color.GRAY);
		search.setForeground(Color.WHITE);
		search.setBounds(310, 30, 90, 25);
		search.addActionListener(this);
		p1.add(search);

		JLabel lbname = new JLabel("Name");
		lbname.setBounds(40, 70, 100, 25);
		lbname.setFont(new Font("Tahoma", Font.BOLD, 14));
		p1.add(lbname);

		tfname = new JTextField();
		tfname.setBounds(150, 70, 150, 30);
		tfname.setBorder((BorderFactory.createEmptyBorder()));
		p1.add(tfname);

		JLabel lbquestion = new JLabel("Security Question");
		lbquestion.setBounds(40, 110, 100, 25);
		lbquestion.setFont(new Font("Tahoma", Font.BOLD, 14));
		p1.add(lbquestion);

		tfquestion = new JTextField();
		tfquestion.setBounds(150, 110, 150, 30);
		tfquestion.setBorder((BorderFactory.createEmptyBorder()));
		p1.add(tfquestion);

		JLabel lbanswer = new JLabel("Answer");
		lbanswer.setBounds(40, 150, 100, 25);
		lbanswer.setFont(new Font("Tahoma", Font.BOLD, 14));
		p1.add(lbanswer);

		tfanswer = new JTextField();
		tfanswer.setBounds(150, 150, 150, 30);
		tfanswer.setBorder((BorderFactory.createEmptyBorder()));
		p1.add(tfanswer);

		retrieve = new JButton("Retrieve");
		retrieve.setBackground(Color.GRAY);
		retrieve.setForeground(Color.WHITE);
		retrieve.setBounds(310, 150, 90, 25);
		retrieve.addActionListener(this);
		p1.add(retrieve);

		JLabel lbpassword = new JLabel("Password");
		lbpassword.setBounds(40, 190, 100, 25);
		lbpassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		p1.add(lbpassword);

		tfpassword = new JTextField();
		tfpassword.setBounds(150, 190, 150, 30);
		tfpassword.setBorder((BorderFactory.createEmptyBorder()));
		p1.add(tfpassword);

		back = new JButton("Back");
		back.setBackground(Color.BLUE);
		back.setBackground(new Color(70, 129, 244));
		back.setBounds(150, 250, 90, 35);
		back.addActionListener(this);
		p1.add(back);

		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == search) {
			try {
				String query = "select * from account where username = '" + tfusername.getText() + "'";
				conn c = new conn();
				
				ResultSet rs = c.s.executeQuery(query);
				while(rs.next()) {
					tfname.setText(rs.getString("name"));
					tfquestion.setText(rs.getString("security"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (ae.getSource() == retrieve) {
			try {
				String query = "select * from account where answer = '" + tfanswer.getText() + "' AND username = '"+tfusername.getText()+"'";
				conn c = new conn();
				
				ResultSet rs = c.s.executeQuery(query);
				while(rs.next()) {
					tfpassword.setText(rs.getString("password"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			setVisible(false);
			new Login();
		}
	}

	public static void main(String[] args) {
		new ForgetPassword();

	}
}