package travelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ViewBookedHotel extends JFrame implements ActionListener {

	JButton back;

	ViewBookedHotel(String username) {

		setBounds(230, 60, 850, 600);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel text = new JLabel("VIEW BOOKED HOTEL DETAILS");
		text.setBounds(40, 30, 400, 25);
		text.setFont(new Font("SANS_SERIF", Font.BOLD, 20));
		add(text);

		JLabel lbusername = new JLabel("Username:");
		lbusername.setBounds(30, 70, 150, 25);
		lbusername.setFont(new Font("SANS_SERIF", Font.BOLD, 16));
		add(lbusername);

		JLabel labelusername = new JLabel();
		labelusername.setBounds(165, 70, 150, 25);
		labelusername.setFont(new Font("SANS_SERIF", Font.PLAIN, 15));
		add(labelusername);

		JLabel lbpackage = new JLabel("Hotel Name:");
		lbpackage.setBounds(30, 110, 150, 25);
		lbpackage.setFont(new Font("SANS_SERIF", Font.BOLD, 16));
		add(lbpackage);

		JLabel labelpackage = new JLabel();
		labelpackage.setBounds(165, 110, 150, 25);
		labelpackage.setFont(new Font("SANS_SERIF", Font.PLAIN, 15));
		add(labelpackage);

		JLabel lbpersons = new JLabel("Total Persons:");
		lbpersons.setBounds(30, 150, 150, 25);
		lbpersons.setFont(new Font("SANS_SERIF", Font.BOLD, 16));
		add(lbpersons);

		JLabel labelpersons = new JLabel();
		labelpersons.setBounds(165, 150, 150, 25);
		labelpersons.setFont(new Font("SANS_SERIF", Font.PLAIN, 15));
		add(labelpersons);
		
		JLabel lbdays = new JLabel("Total Days:");
		lbdays.setBounds(30, 190, 150, 25);
		lbdays.setFont(new Font("SANS_SERIF", Font.BOLD, 16));
		add(lbdays);

		JLabel labeldays = new JLabel();
		labeldays.setBounds(165, 190, 150, 25);
		labeldays.setFont(new Font("SANS_SERIF", Font.PLAIN, 15));
		add(labeldays);
		
		JLabel lbac = new JLabel("AC/NON-AC:");
		lbac.setBounds(30, 230, 150, 25);
		lbac.setFont(new Font("SANS_SERIF", Font.BOLD, 16));
		add(lbac);

		JLabel labelac = new JLabel();
		labelac.setBounds(165, 230, 150, 25);
		labelac.setFont(new Font("SANS_SERIF", Font.PLAIN, 15));
		add(labelac);
		
		JLabel lbfood = new JLabel("Food included?:");
		lbfood.setBounds(30, 270, 150, 25);
		lbfood.setFont(new Font("SANS_SERIF", Font.BOLD, 16));
		add(lbfood);

		JLabel labelfood = new JLabel();
		labelfood.setBounds(165, 270, 150, 25);
		labelfood.setFont(new Font("SANS_SERIF", Font.PLAIN, 15));
		add(labelfood);
		

		JLabel lbid = new JLabel("Id:");
		lbid.setBounds(30, 310, 150, 25);
		lbid.setFont(new Font("SANS_SERIF", Font.BOLD, 16));
		add(lbid);

		JLabel labelid = new JLabel();
		labelid.setBounds(165, 310, 150, 25);
		labelid.setFont(new Font("SANS_SERIF", Font.PLAIN, 15));
		add(labelid);

		JLabel lbnumber = new JLabel("Number:");
		lbnumber.setBounds(30, 350, 150, 25);
		lbnumber.setFont(new Font("SANS_SERIF", Font.BOLD, 16));
		add(lbnumber);

		JLabel labelnumber = new JLabel();
		labelnumber.setBounds(165, 350, 150, 25);
		labelnumber.setFont(new Font("SANS_SERIF", Font.PLAIN, 15));
		add(labelnumber);

		JLabel lbphone = new JLabel("Phone:");
		lbphone.setBounds(30, 390, 150, 25);
		lbphone.setFont(new Font("SANS_SERIF", Font.BOLD, 16));
		add(lbphone);

		JLabel labelphone = new JLabel();
		labelphone.setBounds(165, 390, 150, 25);
		labelphone.setFont(new Font("SANS_SERIF", Font.PLAIN, 15));
		add(labelphone);

		JLabel lbprice = new JLabel("Price:");
		lbprice.setBounds(30, 430, 150, 25);
		lbprice.setFont(new Font("SANS_SERIF", Font.BOLD, 16));
		add(lbprice);

		JLabel labelprice = new JLabel();
		labelprice.setBounds(165, 430, 150, 25);
		labelprice.setFont(new Font("SANS_SERIF", Font.PLAIN, 15));
		add(labelprice);

		back = new JButton("Back");
		back.setBackground(new Color(70, 129, 244));
		back.setForeground(Color.WHITE);
		back.setBounds(80, 500, 100, 28);
		back.addActionListener(this);
		add(back);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
		Image i2 = i1.getImage().getScaledInstance(420, 320, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(360, 70, 420, 320);
		add(image);

		try {
			conn c = new conn();
			String query = "select * from bookhotel where username = '" + username + "'";
			ResultSet rs = c.s.executeQuery(query);
			while (rs.next()) {
				labelusername.setText(rs.getString("username"));
				labelid.setText(rs.getString("id"));
				labelnumber.setText(rs.getString("number"));
				labelpackage.setText(rs.getString("name"));
				labelprice.setText(rs.getString("price"));
				labelphone.setText(rs.getString("phone"));
				labelpersons.setText(rs.getString("persons"));
				labelfood.setText(rs.getString("food"));
				labelac.setText(rs.getString("ac"));
				labeldays.setText(rs.getString("days"));
			}
		} catch (Exception e) {

		}

		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
	}

	public static void main(String[] args) {
		new ViewBookedHotel("anushka01");
	}

}
