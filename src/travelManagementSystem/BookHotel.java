package travelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookHotel extends JFrame implements ActionListener{

	Choice chotel, cac, cfood;
	JTextField tfpersons,tfdays,labelpersons;
	String username;
	JLabel labelusername,labelid, labelnumber, labelphone,labeltotal;
	JButton checkprice, bookpackage, back;
	
	BookHotel(String username) {
		this.username = username;
		
		setBounds(250, 70, 800, 600);
		setLayout(null);
		getContentPane().setBackground(new Color(206,235,251));

		JLabel text = new JLabel("BOOK HOTEL");
		text.setBounds(110, 10, 200, 30);
		text.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(text);

		JLabel lbusername = new JLabel("Username:");
		lbusername.setBounds(30, 70, 100, 20);
		lbusername.setFont(new Font("SANS_SERIF", Font.PLAIN, 16));
		add(lbusername);

		labelusername = new JLabel();
		labelusername.setBounds(200, 70, 130, 20);
		labelusername.setFont(new Font("SANS_SERIF", Font.PLAIN, 15));
		add(labelusername);

		JLabel lbpackage = new JLabel("Select Hotel:");
		lbpackage.setBounds(30, 110, 150, 25);
		lbpackage.setFont(new Font("SANS_SERIF", Font.PLAIN, 16));
		add(lbpackage);

		chotel = new Choice();
		chotel.setBounds(200, 110, 130, 20);
		add(chotel);
		
		try {
			conn c = new conn();
			ResultSet rs = c.s.executeQuery("select * from hotel");
			while(rs.next()) {
				chotel.add(rs.getString("name"));
			}
 		} catch (Exception e) {
			e.printStackTrace();
		}

		JLabel lbpersons = new JLabel("Total Persons:");
		lbpersons.setBounds(30, 150, 150, 25);
		lbpersons.setFont(new Font("SANS_SERIF", Font.PLAIN, 16));
		add(lbpersons);

//		labelpersons = new JTextField("1");
//		labelpersons.setBounds(200, 150, 130, 25);
//		add(labelpersons);
		
		tfpersons = new JTextField("1");
		tfpersons.setBounds(200, 150, 130, 25);
		add(tfpersons);

		
		JLabel lbdays = new JLabel("No. of Days:");
		lbdays.setBounds(30, 190, 150, 25);
		lbdays.setFont(new Font("SANS_SERIF", Font.PLAIN, 16));
		add(lbdays);
		
		tfdays = new JTextField("1");
		tfdays.setBounds(200, 190, 130, 25);
		add(tfdays);
		
		JLabel lbac = new JLabel("AC/Non-AC:");
		lbac.setBounds(30, 230, 150, 25);
		lbac.setFont(new Font("SANS_SERIF", Font.PLAIN, 16));
		add(lbac);
		
		cac = new Choice();
		cac.add("AC");
		cac.add("Non-AC");
		cac.setBounds(200, 230, 130, 25);
		add(cac);
		
		JLabel lbfood = new JLabel("Food Included:");
		lbfood.setBounds(30, 270, 150, 25);
		lbfood.setFont(new Font("SANS_SERIF", Font.PLAIN, 16));
		add(lbfood);
		
		cfood = new Choice();
		cfood.add("Yes");
		cfood.add("No");
		cfood.setBounds(200, 270, 130, 25);
		add(cfood);
		
		
		JLabel lbid = new JLabel("Id:");
		lbid.setBounds(30, 310, 150, 20);
		lbid.setFont(new Font("SANS_SERIF", Font.PLAIN, 16));
		add(lbid);

		labelid = new JLabel();
		labelid.setBounds(200, 310, 130, 25);
		labelid.setFont(new Font("SANS_SERIF", Font.PLAIN, 15));
		add(labelid);

		JLabel lbnumber = new JLabel("Number:");
		lbnumber.setBounds(30, 350, 150, 25);
		lbnumber.setFont(new Font("SANS_SERIF", Font.PLAIN, 16));
		add(lbnumber);

		labelnumber = new JLabel();
		labelnumber.setBounds(200, 350, 150, 25);
		labelnumber.setFont(new Font("SANS_SERIF", Font.PLAIN, 15));
		add(labelnumber);

		JLabel lbphone = new JLabel("Phone:");
		lbphone.setBounds(30, 390, 150, 25);
		lbphone.setFont(new Font("SANS_SERIF", Font.PLAIN, 16));
		add(lbphone);

		labelphone = new JLabel();
		labelphone.setBounds(200, 390, 130, 25);
		labelphone.setFont(new Font("SANS_SERIF", Font.PLAIN, 15));
		add(labelphone);

		JLabel lbtotal = new JLabel("Total Price:");
		lbtotal.setBounds(30, 430, 150, 25);
		lbtotal.setFont(new Font("SANS_SERIF", Font.PLAIN, 16));
		add(lbtotal);

		labeltotal = new JLabel();
		labeltotal.setBounds(200, 430, 130, 25);
		labeltotal.setFont(new Font("SANS_SERIF", Font.PLAIN, 15));
		add(labeltotal);

		try {
			conn c = new conn();
			String query = "select * from customer where username = '" + username + "'";
			ResultSet rs = c.s.executeQuery(query);
			while (rs.next()) {
				labelusername.setText(rs.getString("username"));
				labelid.setText(rs.getString("id"));
				labelnumber.setText(rs.getString("number"));
				labelphone.setText(rs.getString("phone"));

			}
		} catch (Exception e) {
			e.printStackTrace();
				
		}
		
		checkprice = new JButton("Check Price");
		checkprice.setBackground(new Color(70, 129, 244));
		checkprice.setForeground(Color.WHITE);
		checkprice.setBounds(30,480,110,30);
		checkprice.addActionListener(this);
		add(checkprice);
		
		bookpackage = new JButton("Book Hotel");
		bookpackage.setBackground(new Color(70, 129, 244));
		bookpackage.setForeground(Color.WHITE);
		bookpackage.setBounds(160,480,120,30);
		bookpackage.addActionListener(this);
		add(bookpackage);
		
		back = new JButton("Back");
		back.setBackground(new Color(70, 129, 244));
		back.setForeground(Color.WHITE);
		back.setBounds(300,480,80,30);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
		Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel i12 = new JLabel(i3);
		i12.setBounds(350,50,400,300);
		add(i12);

		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == checkprice) {
			try {
				conn c = new conn(); 
				ResultSet rs = c.s.executeQuery("select * from hotel where name =  '"+chotel.getSelectedItem()+"'");
				while(rs.next()) {
					int cost = Integer.parseInt(rs.getString("costperperson"));
					int food = Integer.parseInt(rs.getString("foodincluded"));
					int ac = Integer.parseInt(rs.getString("acroom"));
				
					int persons = Integer.parseInt(tfpersons.getText());
					int days = Integer.parseInt(tfdays.getText());
					
					String acselected =  cac.getSelectedItem();
					String foodselected = cfood.getSelectedItem();	
					
					if(persons * days > 0) {
						int total = 0;
						total += acselected.equals("AC")? ac:0;
						total += foodselected.equals("Yes")? food:0;
						total +=cost;
						total = total * persons * days;
						labeltotal.setText("Rs"+total);
						
					}else {
						JOptionPane.showMessageDialog(null, "Please Enter a valid number");
					}
				}
				}catch (Exception e) {
				e.printStackTrace();
			}
		}else if(ae.getSource()==bookpackage) {
			try {
				conn c = new conn();
				c.s.executeUpdate("insert into bookhotel values('"+labelusername.getText()+"', '"+chotel.getSelectedItem()+"', '"+tfpersons.getText()+"','"+tfdays.getText()+"','"+cac.getSelectedItem()+"','"+cfood.getSelectedItem()+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"','"+labeltotal.getText()+"')");
			
				JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
				setVisible(false);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else {
			setVisible(false);
		}
	}

	public static void main(String[] args) {
		new BookHotel("anushka01");

	}

}
