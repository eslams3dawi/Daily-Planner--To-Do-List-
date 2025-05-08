package xxxx;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
//JLabel = a GUI display area for a string of text ,an image or both.
//JButton = a GUI button that performs an action when clicked on.

public class StartPanel extends JPanel // The First panel.
{
	
	JButton StartButton;
	JLabel Labelx;// text.
	JLabel Label;// to add icon.
	JLabel Label2;// icon.
	
	 public StartPanel()
	{
		 this.setLayout(null);
		 this.setBackground(Color.black);
		 Label = new JLabel();
		 ImageIcon Imagex =new ImageIcon("photo_2025-04-18_20-16-50.jpg");
		 Label.setBounds(900,500,510,510);
		 Label.setIcon(Imagex);
		 
		 Label2 = new JLabel();
		 ImageIcon Image =new ImageIcon("photo_2025-04-18_20-20-51.jpg");
		 Label2.setBounds(700,90,700,600);
		 Label2.setIcon(Image);
		 
		 Labelx = new JLabel ();
		 Labelx.setBounds(200, 100, 800, 100);
		 Labelx.setText("Welcome To Your Daily Planner!.");
		 Labelx.setFont(new Font("MV Boli",Font.PLAIN ,50));
		 Labelx.setForeground(Color.WHITE);// color of font .
		 
		 StartButton = new JButton();
		 StartButton.setBounds(100, 250, 300, 150);
		 StartButton.setText("Start Planning.");
		 StartButton.setFont(new Font("MV Boli",Font.BOLD ,40));
		 StartButton.setFocusable(false);
		 
		 this.add(Labelx);
		 this.add(Label);
		 this.add(Label2);
		 //this.add(StartButton); 
		 
		 
	}

}