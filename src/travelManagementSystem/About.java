package travelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class About extends JFrame implements ActionListener{
	
	About(){
		setBounds(230,60,700,500);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		
		JLabel l1 = new JLabel("ABOUT");
		l1.setBounds(300,10,100,40);
		l1.setForeground(Color.BLUE);
		l1.setFont(new Font("Tahoma",Font.PLAIN, 20));
		add(l1);
		
		String s = "About projetcs					\n" +	
				"	\n"+
				"Advantages of Project :\n"+
				" Gives accurate information\n"+
				" Simplifies the manual work\n";
		
		TextArea area = new TextArea(s,10,40,Scrollbar.VERTICAL);		
		area.setEditable(false);
		area.setBounds(30,60,620,360);
		add(area);
		
		JButton back = new JButton("Back");
		back.setBounds(300,420,100,25);
		back.addActionListener(this);
		add(back);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
	}

	public static void main(String[] args) {
		new About();

	}

}
