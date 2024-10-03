package travelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ViewCustomer extends JFrame implements ActionListener {

	JButton back;

	ViewCustomer(String username) {

		setBounds(250, 80, 750, 550);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);

		JLabel lbusername = new JLabel("Username:");
		lbusername.setBounds(30, 50, 150, 25);
		lbusername.setFont(new Font("SANS_SERIF", Font.BOLD, 16));
		add(lbusername);

		JLabel labelusername = new JLabel();
		labelusername.setBounds(150, 50, 150, 25);
		labelusername.setFont(new Font("SANS_SERIF", Font.PLAIN, 15));
		add(labelusername);

		JLabel lbid = new JLabel("ID:");
		lbid.setBounds(30, 100, 150, 25);
		lbid.setFont(new Font("SANS_SERIF", Font.BOLD, 16));
		add(lbid);

		JLabel labelid = new JLabel();
		labelid.setBounds(150, 100, 150, 25);
		labelid.setFont(new Font("SANS_SERIF", Font.PLAIN, 15));
		add(labelid);

		JLabel lbnumber = new JLabel("Number:");
		lbnumber.setBounds(30, 150, 150, 25);
		lbnumber.setFont(new Font("SANS_SERIF", Font.BOLD, 16));
		add(lbnumber);

		JLabel labelnumber = new JLabel();
		labelnumber.setBounds(150, 150, 150, 25);
		labelnumber.setFont(new Font("SANS_SERIF", Font.PLAIN, 15));
		add(labelnumber);

		JLabel lbname = new JLabel("Name:");
		lbname.setBounds(30, 200, 150, 25);
		lbname.setFont(new Font("SANS_SERIF", Font.BOLD, 16));
		add(lbname);

		JLabel labelname = new JLabel();
		labelname.setBounds(150, 200, 150, 25);
		labelname.setFont(new Font("SANS_SERIF", Font.PLAIN, 15));
		add(labelname);

		JLabel lbgender = new JLabel("Gender:");
		lbgender.setBounds(30, 250, 150, 25);
		lbgender.setFont(new Font("SANS_SERIF", Font.BOLD, 16));
		add(lbgender);

		JLabel labelgender = new JLabel();
		labelgender.setBounds(150, 250, 150, 25);
		labelgender.setFont(new Font("SANS_SERIF", Font.PLAIN, 15));
		add(labelgender);

		JLabel lbcontry = new JLabel("Contry:");
		lbcontry.setBounds(360, 50, 150, 25);
		lbcontry.setFont(new Font("SANS_SERIF", Font.BOLD, 16));
		add(lbcontry);

		JLabel labelcontry = new JLabel();
		labelcontry.setBounds(460, 50, 150, 25);
		labelcontry.setFont(new Font("SANS_SERIF", Font.PLAIN, 15));
		add(labelcontry);

		JLabel lbaddress = new JLabel("Address:");
		lbaddress.setBounds(360, 100, 150, 25);
		lbaddress.setFont(new Font("SANS_SERIF", Font.BOLD, 16));
		add(lbaddress);

		JLabel labeladdress = new JLabel();
		labeladdress.setBounds(460, 100, 150, 25);
		labeladdress.setFont(new Font("SANS_SERIF", Font.PLAIN, 15));
		add(labeladdress);

		JLabel lbphone = new JLabel("Phone:");
		lbphone.setBounds(360, 150, 150, 25);
		lbphone.setFont(new Font("SANS_SERIF", Font.BOLD, 16));
		add(lbphone);

		JLabel labelphone = new JLabel();
		labelphone.setBounds(460, 150, 150, 25);
		labelphone.setFont(new Font("SANS_SERIF", Font.PLAIN, 15));
		add(labelphone);

		JLabel lbemail = new JLabel("Email:");
		lbemail.setBounds(360, 200, 50, 25);
		lbemail.setFont(new Font("SANS_SERIF", Font.BOLD, 16));
		add(lbemail);

		JLabel labelemail = new JLabel();
		labelemail.setBounds(460, 200, 250, 25);
		labelemail.setFont(new Font("SANS_SERIF", Font.PLAIN, 15));
		add(labelemail);

		back = new JButton("Back");
		back.setBackground(new Color(70, 129, 244));
		back.setForeground(Color.WHITE);
		back.setBounds(300, 310, 100, 28);
		back.addActionListener(this);
		add(back);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
		Image i2 = i1.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(50, 350, 600, 200);
		add(image);

		try {
			conn c = new conn();
			String query = "select * from customer where username = '" + username + "'";
			ResultSet rs = c.s.executeQuery(query);
			while (rs.next()) {
				labelusername.setText(rs.getString("username"));
				labelid.setText(rs.getString("id"));
				labelnumber.setText(rs.getString("number"));
				labelname.setText(rs.getString("name"));
				labelgender.setText(rs.getString("gender"));
				labelcontry.setText(rs.getString("contry"));
				labeladdress.setText(rs.getString("address"));
				labelphone.setText(rs.getString("phone"));
				labelemail.setText(rs.getString("email"));

			}
		} catch (Exception e) {

		}

		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
	}

	public static void main(String[] args) {
		new ViewCustomer("anushka01");
	}

}
