Package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainWindow{


	public static void CreateWindow(){
		JFrame frame = new JFrame("MainWindow");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel label = new JLabel("");
		label.setPreferredSize(new Dimension(1000, 680));
		frame.getContentPane().add(label, BorderLayout.CENTER);

		JButton cirButton = new JButton("Circle");
		cirButton.addItemList


		frame.pack();
		frame.setVisible(true);
	}


	public static void main(String args[]){
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				CreateWindow();
			}
		});
	}
}