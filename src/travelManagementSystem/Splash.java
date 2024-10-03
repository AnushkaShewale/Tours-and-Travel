package travelManagementSystem;

import javax.security.auth.login.LoginContext;
import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable{
	
	Thread thread;
	

	Splash() {
		setSize(400, 200);
		setLocation(50, 100);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/splash.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1000, 550, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		add(image);

		setVisible(true);
		
		thread = new Thread(this);
		thread.start();
		
	}
	
	public void run() {
		try {
			Thread.sleep(7000);
//			new Login ();
			setVisible(false);
		} catch (Exception e) {
			
		}
	}

	public static void main(String[] args) {
		Splash frame = new Splash();

		int x = 1;
		for (int i = 1; i <= 400; x += 4, i += 4) {
			frame.setLocation(520 - (x + i) / 3, 350 - (i / 2));
			frame.setSize(x + i, i);
			try {
				Thread.sleep(5);
			} catch (Exception e) {

			}
		}
	}

	

}
