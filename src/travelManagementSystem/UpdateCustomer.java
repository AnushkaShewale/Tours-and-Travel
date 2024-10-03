package travelManagementSystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;


public class UpdateCustomer extends JFrame implements ActionListener{
	
	JLabel labelusername, labelname;
	JComboBox comboid;
	JTextField tfnumber, tfaddress,tfcontry, tfemail, tfphone,tfid,tfgender;
	JRadioButton rmale, rfemale;
	JButton add, back;
	
	
	UpdateCustomer(String username) {
		setBounds(250, 80,750,550);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		JLabel text = new JLabel("Update Customer Details");
		text.setBounds(55,0,300,25);
		text.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(text);
		
		JLabel lbusername = new JLabel("username");
		lbusername.setBounds(30,40,150,25);
		add(lbusername);
		
		labelusername = new JLabel();
		labelusername.setBounds(200,40,150,25);
		add(labelusername);
	
		JLabel lbid = new JLabel("ID");
		lbid.setBounds(30,80,150,25);
		add(lbid);
		
		tfid = new JTextField();
		tfid.setBounds(200,90,150,25);
		add(tfid);
		
		JLabel lbnumber = new JLabel("Number");
		lbnumber.setBounds(30,120,150,25);
		add(lbnumber);
		
		tfnumber = new JTextField();
		tfnumber.setBounds(200,120,150,25);
		add(tfnumber);
		
		JLabel lbname = new JLabel("Name");
		lbname.setBounds(30,160,150,25);
		add(lbname);
		
		labelname = new JLabel();
		labelname.setBounds(200,160,150,25);
		add(labelname);
		
		JLabel lbgender = new JLabel("Gender");
		lbgender.setBounds(30,200,150,25);
		add(lbgender);
		
		tfgender = new JTextField();
		tfgender.setBounds(200,200,150,25);
		add(tfgender);
		
		JLabel lbcontry = new JLabel("Country");
		lbcontry.setBounds(30,250,150,25);
		add(lbcontry);
		
		tfcontry = new JTextField();
		tfcontry.setBounds(200,250,150,25);
		add(tfcontry);
		
		JLabel lbaddress = new JLabel("Address");
		lbaddress.setBounds(30,290,150,25);
		add(lbaddress);
		
		tfaddress = new JTextField();
		tfaddress.setBounds(200,290,150,25);
		add(tfaddress);
		
		JLabel lbphone = new JLabel("Phone");
		lbphone.setBounds(30,330,150,25);
		add(lbphone);
		
		tfphone = new JTextField();
		tfphone.setBounds(200,330,150,25);
		add(tfphone);
		
		JLabel lbemail = new JLabel("Email");
		lbemail.setBounds(30,370,150,25);
		add(lbemail);
		
		tfemail = new JTextField();
		tfemail.setBounds(200,370,150,25);
		add(tfemail);
		
		add = new JButton("Update");
		add.setBackground(Color.BLACK);
		add.setForeground(Color.WHITE);
		add.setBounds(70,425,80,25);
		add.addActionListener(this);
		add(add);
		
		back = new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBounds(200,425,80,25);
		back.addActionListener(this);

		add(back);
		
		ImageIcon i1 =  new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
		Image i2 = i1.getImage().getScaledInstance(200, 350, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(330, 60 ,450,350);
		add(image);
		
		try {
			conn c = new conn();
			ResultSet rs=c.s.executeQuery("select * from customer where username = '"+username+"'");
			while(rs.next()){
				labelusername.setText(rs.getString("username"));
				labelname.setText(rs.getString("name"));
				tfid.setText(rs.getString("id"));
				tfnumber.setText(rs.getString("number"));
				tfgender.setText(rs.getString("gender"));
				tfcontry.setText(rs.getString("contry"));
				tfaddress.setText(rs.getString("address"));
				tfphone.setText(rs.getString("phone"));
				tfemail.setText(rs.getString("email"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()== add)
		{
			String username = labelusername.getText();
			String id = tfid.getText();
			String number =  tfnumber.getText();
			String name = labelname.getText();
			String gender = tfgender.getText();
			String contry = tfcontry.getText();
			String address = tfaddress.getText();
			String phone = tfphone.getText();
			String email = tfemail.getText();
			
			try {
				conn c = new conn();
				String query = "update customer set username = '"+username+"',id = '"+id+"',number = '"+number+"', name ='"+name+"',gender = '"+gender+"',contry = '"+contry+"',address = '"+address+"',phone = '"+phone+"',email = '"+email+"'" ;
				c.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null, "Customer Details Updated Successfully");
				setVisible(false);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		
		new UpdateCustomer("anushka01");
	}

}
