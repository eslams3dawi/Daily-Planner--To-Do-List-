package myapp;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartPanel extends JPanel
{
	
	JButton StartButton;
	JLabel Labelx;
	
	 public StartPanel()
	{
		 this.setLayout(new FlowLayout(FlowLayout.CENTER,20,100));
		 this.setBackground(Color.BLACK);
		 Labelx = new JLabel ();
		 Labelx.setText("Welcome To Your Daily Planner.");
		 Labelx.setFont(new Font("MV Boli",Font.PLAIN ,100));
		 
		 StartButton = new JButton();
		 StartButton.setText("Start Planning.");
		 StartButton.setFont(new Font("MV Boli",Font.BOLD ,40));
		 
		 this.add(Labelx);
		 this.add(StartButton); 
		 
		 
	}

}
