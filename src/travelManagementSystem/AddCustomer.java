package travelManagementSystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;


public class AddCustomer extends JFrame implements ActionListener{
	
	JLabel labelusername, labelname;
	JComboBox comboid;
	JTextField tfnumber, tfaddress,tfcontry, tfemail, tfphone;
	JRadioButton rmale, rfemale;
	JButton add, back;
	
	
	AddCustomer(String username) {
		setBounds(250, 80,750,550);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		JLabel lbusername = new JLabel("username");
		lbusername.setBounds(30,40,150,25);
		add(lbusername);
		
		labelusername = new JLabel();
		labelusername.setBounds(200,40,150,25);
		add(labelusername);
	
		JLabel lbid = new JLabel("ID");
		lbid.setBounds(30,80,150,25);
		add(lbid);
		
		comboid = new JComboBox (new String [] {"passport", "Aadhar Card", "Pan Card", "Ration Card"});
		comboid.setBounds(200,80,150,25);
		comboid.setBackground(Color.WHITE);
		add(comboid);
		
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
		
		rmale = new JRadioButton("Male");
		rmale.setBounds(200, 200,70,25);
		rmale.setBackground(Color.white);
		add(rmale);
		
		rfemale = new JRadioButton("Female");
		rfemale.setBounds(285, 200,70,25);
		rfemale.setBackground(Color.white);
		add(rfemale);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rmale);
		bg.add(rfemale);
		
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
		
		add = new JButton("Add");
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
		
		ImageIcon i1 =  new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
		Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(330, 20 ,450,420);
		add(image);
		
		try {
			conn c = new conn();
			ResultSet rs=c.s.executeQuery("select * from account where username = '"+username+"'");
			while(rs.next()){
				labelusername.setText(rs.getString("username"));
				labelname.setText(rs.getString("name"));
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
			String id = (String) comboid.getSelectedItem();
			String number =  tfnumber.getText();
			String name = labelname.getText();
			String gender = null;
			if(rmale.isSelected()) {
				gender = "Male";
			}else {
				gender = "Female";
			}
			String contry = tfcontry.getText();
			String address = tfaddress.getText();
			String phone = tfphone.getText();
			String email = tfemail.getText();
			
			try {
				conn c = new conn();
				String query = "insert into customer values('"+username+"','"+id+"','"+number+"', '"+name+"','"+gender+"','"+contry+"','"+address+"','"+phone+"','"+email+"')" ;
				c.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
				setVisible(false);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		
		new AddCustomer("anushka01");
	}

}
