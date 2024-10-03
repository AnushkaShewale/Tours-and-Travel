package travelManagementSystem;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Dashboard extends JFrame implements ActionListener{

	JButton addpersonDetails,viewPersonalDetails, updatePersonDetails, checkPackage,bookPackage, viewPackage,viewHotels,destinations,BookHotel,viewBookedHotel,payment,calculator,notepad,about;
	JScrollPane jp;
	String username;
	
	Dashboard(String username) {
		this.username = username;
		

		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLayout(null);
		
		JPanel p1 = new JPanel();
		p1.setLayout(null);
		p1.setBackground(new Color(21,52,80));
		p1.setBounds(0,0,1600, 65);
		add(p1);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
		Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel icon = new JLabel(i3);
		icon.setBounds(5,0,70,70);
		p1.add(icon);
		
		JLabel heading =  new JLabel("Dashboard");
		heading.setBounds(80,10,300,40);
		heading.setForeground(Color.WHITE);
		heading.setFont(new Font("Tahoma", Font.BOLD, 25));
		p1.add(heading);
		
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(0, 1));
//		p2.setLayout(null);
		p2.setBackground(new Color(68,114,148));
//		p2.setBounds(0,65,300, 900);
		add(p2);
		
		
		addpersonDetails = new JButton("Add Personal Details");
		addpersonDetails.setBounds(0,0,300,50);
		addpersonDetails.setBackground(new Color(68,114,148));
		addpersonDetails.setForeground(Color.WHITE);
		addpersonDetails.setFont(new Font("Tahoma",Font.PLAIN, 16));
		addpersonDetails.setMargin(new Insets(0, 0, 0, 100));
		addpersonDetails.addActionListener(this);
		p2.add(addpersonDetails);
		
		updatePersonDetails = new JButton("Update Personal Details");
		updatePersonDetails.setBounds(0,50,300,50);
		updatePersonDetails.setBackground(new Color(68,114,148));
		updatePersonDetails.setForeground(Color.WHITE);
		updatePersonDetails.setFont(new Font("Tahoma",Font.PLAIN, 16));
		updatePersonDetails.setMargin(new Insets(0, 0, 0, 80));
		updatePersonDetails.addActionListener(this);
		p2.add(updatePersonDetails);
		
		viewPersonalDetails = new JButton("View Personal Details");
		viewPersonalDetails.setBounds(0,100,350,50);
		viewPersonalDetails.setBackground(new Color(68,114,148));
		viewPersonalDetails.setForeground(Color.WHITE);
		viewPersonalDetails.setFont(new Font("Tahoma",Font.PLAIN, 16));
		viewPersonalDetails.setMargin(new Insets(0, 0, 0, 100));
		viewPersonalDetails.addActionListener(this);
		p2.add(viewPersonalDetails);
		
		JButton deletePersonalDetails = new JButton("Delete Personal Details");
		deletePersonalDetails.setBounds(0,150,350,50);
		deletePersonalDetails.setBackground(new Color(68,114,148));
		deletePersonalDetails.setForeground(Color.WHITE);
		deletePersonalDetails.setFont(new Font("Tahoma",Font.PLAIN, 16));
		deletePersonalDetails.setMargin(new Insets(0, 0, 0, 90));
		p2.add(deletePersonalDetails);
		
		checkPackage = new JButton("Check Package Details");
		checkPackage.setBounds(0,200,350,50);
		checkPackage.setBackground(new Color(68,114,148));
		checkPackage.setForeground(Color.WHITE);
		checkPackage.setFont(new Font("Tahoma",Font.PLAIN, 16));
		checkPackage.setMargin(new Insets(0, 0, 0, 90));
		checkPackage.addActionListener(this);
		p2.add(checkPackage);
		
		bookPackage = new JButton("Book Package");
		bookPackage.setBounds(0,250,350,50);
		bookPackage.setBackground(new Color(68,114,148));
		bookPackage.setForeground(Color.WHITE);
		bookPackage.setFont(new Font("Tahoma",Font.PLAIN, 16));
		bookPackage.setMargin(new Insets(0, 0, 0, 150));
		bookPackage.addActionListener(this);
		p2.add(bookPackage);
		
		viewPackage = new JButton("View Package");
		viewPackage.setBounds(0,300,350,50);
		viewPackage.setBackground(new Color(68,114,148));
		viewPackage.setForeground(Color.WHITE);
		viewPackage.setFont(new Font("Tahoma",Font.PLAIN, 16));
		viewPackage.setMargin(new Insets(0, 0, 0, 150));
		viewPackage.addActionListener(this);
		p2.add(viewPackage);
		
		viewHotels = new JButton("View hotels");
		viewHotels.setBounds(0,350,350,50);
		viewHotels.setBackground(new Color(68,114,148));
		viewHotels.setForeground(Color.WHITE);
		viewHotels.setFont(new Font("Tahoma",Font.PLAIN, 16));
		viewHotels.setMargin(new Insets(0, 0, 0, 165));
		viewHotels.addActionListener(this);
		p2.add(viewHotels);
		
		BookHotel = new JButton("Book hotel");
		BookHotel.setBounds(0,400,350,50);
		BookHotel.setBackground(new Color(68,114,148));
		BookHotel.setForeground(Color.WHITE);
		BookHotel.setFont(new Font("Tahoma",Font.PLAIN, 16));
		BookHotel.setMargin(new Insets(0, 0, 0, 168));
		BookHotel.addActionListener(this);
		p2.add(BookHotel);
		
		viewBookedHotel = new JButton("View Booked hotel");
		viewBookedHotel.setBounds(0,450,350,50);
		viewBookedHotel.setBackground(new Color(68,114,148));
		viewBookedHotel.setForeground(Color.WHITE);
		viewBookedHotel.setFont(new Font("Tahoma",Font.PLAIN, 16));
		viewBookedHotel.setMargin(new Insets(0, 0, 0, 125));
		viewBookedHotel.addActionListener(this);
		p2.add(viewBookedHotel);
		
		destinations = new JButton("Destinations");
		destinations.setBounds(0,500,350,50);
		destinations.setBackground(new Color(68,114,148));
		destinations.setForeground(Color.WHITE);
		destinations.setFont(new Font("Tahoma",Font.PLAIN, 16));
		destinations.setMargin(new Insets(0, 0, 0, 160));
		destinations.addActionListener(this);
		p2.add(destinations);
		
		payment = new JButton("Payment");
		payment.setBounds(0,550,350,50);
		payment.setBackground(new Color(68,114,148));
		payment.setForeground(Color.WHITE);
		payment.setFont(new Font("Tahoma",Font.PLAIN, 16));
		payment.setMargin(new Insets(0, 0, 0, 173));
		payment.addActionListener(this);
		p2.add(payment);
		
		calculator = new JButton("Calculator");
		calculator.setBounds(0,600,350,50);
		calculator.setBackground(new Color(68,114,148));
		calculator.setForeground(Color.WHITE);
		calculator.setFont(new Font("Tahoma",Font.PLAIN, 16));
		calculator.setMargin(new Insets(0, 0, 0, 171));
		calculator.addActionListener(this);
		p2.add(calculator);
		
		notepad = new JButton("Notepad");
		notepad.setBounds(0,650,350,50);
		notepad.setBackground(new Color(68,114,148));
		notepad.setForeground(Color.WHITE);
		notepad.setFont(new Font("Tahoma",Font.PLAIN, 16));
		notepad.setMargin(new Insets(0, 0, 0, 170));
		notepad.addActionListener(this);
		p2.add(notepad);
		
		about = new JButton("About Us");
		about.setBounds(0,700,350,50);
		about.setBackground(new Color(68,114,148));
		about.setForeground(Color.WHITE);
		about.setFont(new Font("Tahoma",Font.PLAIN, 16));
		about.setMargin(new Insets(0, 0, 0, 170));
		about.addActionListener(this);
		p2.add(about);
		
		jp = new JScrollPane(p2);
        jp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jp.setBounds(0, 65, 300, 600);
        p2.setPreferredSize(new Dimension(250, 1000));
        add(jp);
		
		ImageIcon i4= new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
		Image i5= i4.getImage().getScaledInstance(1600, 1000, Image.SCALE_DEFAULT);
		ImageIcon i6= new ImageIcon(i5);
		JLabel image = new JLabel(i6);
		image.setBounds(0,0,1650,1000);
		add(image);
		
		JLabel text = new JLabel("Travel and Tuorism Management System");
		text.setBounds(380,70,1000,70);
		text.setForeground(new Color(14,52,91));
		text.setFont(new Font("RALEWAY",Font.PLAIN, 45));
		image.add(text);
		
				
		
		setVisible(true);
	}
	

	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == addpersonDetails) {
			new AddCustomer(username);
		}else if(ae.getSource()==viewPersonalDetails) {
			new ViewCustomer(username);
		}else if(ae.getSource() == updatePersonDetails) {
			new UpdateCustomer(username);
		}else if(ae.getSource()==checkPackage) {
			new CheckPackage();
		}else if(ae.getSource()==bookPackage) {
			new BookPackage(username);
		}else if(ae.getSource()==viewPackage) {
			new ViewPackage(username);
		}else if(ae.getSource()==viewHotels) {
			new CheckHotels();
		}else if(ae.getSource()==destinations) {
			new Destinations();
		}else if(ae.getSource()==BookHotel) {
			new BookHotel(username);
		}else if (ae.getSource()==viewBookedHotel) {
			new ViewBookedHotel(username);
		}else if(ae.getSource()==payment) {
			new Payment();
		}else if(ae.getSource()==calculator) {
			try {
				Runtime.getRuntime().exec("calc.exe");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(ae.getSource()==notepad){
			try {
				Runtime.getRuntime().exec("notepad.exe");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(ae.getSource()==about) {
			new About();
		}
	}
	
	public static void main(String[] args) {
		new Dashboard("");

	}

}
