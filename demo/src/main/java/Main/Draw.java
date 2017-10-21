package Main;

import javax.swing.JFrame;

public class Draw {
	
	public static void main(String[] args) {
		
		JFrame window = new JFrame("SENSOR DATA");
		window.setContentPane(new DrawPanel());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.pack();
		window.setVisible(true);
		
	}
	
}
