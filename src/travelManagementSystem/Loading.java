package travelManagementSystem;
import java.awt.Color;

import javax.swing.*;

import com.mysql.cj.util.TestUtils;

import java.awt.*;

public class Loading extends JFrame implements Runnable{
	Thread t;
	JProgressBar bar;
	String username;
	
	public void run() {
		try {
			for(int i=1; i<=101; i++) {
				int max= bar.getMaximum();
				int value= bar.getValue();
				
				if(value <max) {
					bar.setValue(bar.getValue() + 1);
				}else {
					setVisible(false);
					//New class object
					new Dashboard(username);
				}
				Thread.sleep(50);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	Loading(String username){
		this.username = username;
		t= new Thread(this);
		setBounds(330,150,650,400);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel text = new JLabel("Travel and Tourism Application");
		text.setBounds(100,20,600,45);
		text.setForeground(new Color(21, 52, 80));
		text.setFont(new Font("Raleway", Font.BOLD, 30));
		add(text);
		
		bar = new JProgressBar();
		bar.setBounds(150,100,300,35);
		bar.setStringPainted(true);
		add(bar);
		
		JLabel loading = new JLabel("Loading, please wait...");
		loading.setBounds(220,130,200,30);
		loading.setForeground(Color.RED);
		loading.setFont(new Font("Raleway", Font.BOLD, 16));
		add(loading);
		
		JLabel lbusername = new JLabel("Welcome "+username);
		lbusername.setBounds(20,310,400,40);
		lbusername.setForeground(Color.RED);
		lbusername.setFont(new Font("Raleway", Font.BOLD, 16));
		add(lbusername);
		
		t.start();
		setVisible(true);
		
	}

	public static void main(String[] args) {
		
		new Loading("");
	}

}
