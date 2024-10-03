package travelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ViewPackage extends JFrame implements ActionListener {

	JButton back;

	ViewPackage(String username) {

		setBounds(300, 80, 750, 450);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel text = new JLabel("VIEW PACKAGE DETAILS");
		text.setBounds(40, 30, 300, 25);
		text.setFont(new Font("SANS_SERIF", Font.BOLD, 20));
		add(text);

		JLabel lbusername = new JLabel("Username:");
		lbusername.setBounds(30, 70, 150, 25);
		lbusername.setFont(new Font("SANS_SERIF", Font.BOLD, 16));
		add(lbusername);

		JLabel labelusername = new JLabel();
		labelusername.setBounds(150, 70, 150, 25);
		labelusername.setFont(new Font("SANS_SERIF", Font.PLAIN, 15));
		add(labelusername);

		JLabel lbpackage = new JLabel("Package:");
		lbpackage.setBounds(30, 110, 150, 25);
		lbpackage.setFont(new Font("SANS_SERIF", Font.BOLD, 16));
		add(lbpackage);

		JLabel labepackage = new JLabel();
		labepackage.setBounds(150, 110, 150, 25);
		labepackage.setFont(new Font("SANS_SERIF", Font.PLAIN, 15));
		add(labepackage);

		JLabel lbpersons = new JLabel("Total Persons:");
		lbpersons.setBounds(30, 150, 150, 25);
		lbpersons.setFont(new Font("SANS_SERIF", Font.BOLD, 16));
		add(lbpersons);

		JLabel labelpersons = new JLabel();
		labelpersons.setBounds(150, 150, 150, 25);
		labelpersons.setFont(new Font("SANS_SERIF", Font.PLAIN, 15));
		add(labelpersons);

		JLabel lbid = new JLabel("ID:");
		lbid.setBounds(30, 190, 150, 25);
		lbid.setFont(new Font("SANS_SERIF", Font.BOLD, 16));
		add(lbid);

		JLabel labelid = new JLabel();
		labelid.setBounds(150, 190, 150, 25);
		labelid.setFont(new Font("SANS_SERIF", Font.PLAIN, 15));
		add(labelid);

		JLabel lbnumber = new JLabel("Number:");
		lbnumber.setBounds(30, 230, 150, 25);
		lbnumber.setFont(new Font("SANS_SERIF", Font.BOLD, 16));
		add(lbnumber);

		JLabel labelnumber = new JLabel();
		labelnumber.setBounds(150, 230, 150, 25);
		labelnumber.setFont(new Font("SANS_SERIF", Font.PLAIN, 15));
		add(labelnumber);

		JLabel lbphone = new JLabel("Phone:");
		lbphone.setBounds(30, 270, 150, 25);
		lbphone.setFont(new Font("SANS_SERIF", Font.BOLD, 16));
		add(lbphone);

		JLabel labelphone = new JLabel();
		labelphone.setBounds(150, 270, 150, 25);
		labelphone.setFont(new Font("SANS_SERIF", Font.PLAIN, 15));
		add(labelphone);

		JLabel lbprice = new JLabel("Price:");
		lbprice.setBounds(30, 300, 150, 25);
		lbprice.setFont(new Font("SANS_SERIF", Font.BOLD, 16));
		add(lbprice);

		JLabel labelprice = new JLabel();
		labelprice.setBounds(150, 300, 150, 25);
		labelprice.setFont(new Font("SANS_SERIF", Font.PLAIN, 15));
		add(labelprice);

		back = new JButton("Back");
		back.setBackground(new Color(70, 129, 244));
		back.setForeground(Color.WHITE);
		back.setBounds(80, 350, 100, 28);
		back.addActionListener(this);
		add(back);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
		Image i2 = i1.getImage().getScaledInstance(420, 320, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(310, 35, 420, 320);
		add(image);

		try {
			conn c = new conn();
			String query = "select * from bookpackage where username = '" + username + "'";
			ResultSet rs = c.s.executeQuery(query);
			while (rs.next()) {
				labelusername.setText(rs.getString("username"));
				labelid.setText(rs.getString("id"));
				labelnumber.setText(rs.getString("number"));
				labepackage.setText(rs.getString("package"));
				labelprice.setText(rs.getString("price"));
				labelphone.setText(rs.getString("phone"));
				labelpersons.setText(rs.getString("persons"));

			}
		} catch (Exception e) {

		}

		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
	}

	public static void main(String[] args) {
		new ViewPackage("anushka01");
	}

}
