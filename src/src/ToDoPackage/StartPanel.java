package ToDoPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
//JLabel = a GUI display area for a string of text ,an image or both.
//JButton = a GUI button that performs an action when clicked on.

public class StartPanel extends JPanel // The First panel.
{
	
	JButton StartButton;
	JLabel Welcome;// Welcome To Your Daily Planner
	JLabel ImageOne;// to add icon.
	JLabel ImageTwo;// icon.
	
	ImageIcon background = new ImageIcon("backgroundImg.jpg");
	private JLabel img = new JLabel(new ImageIcon(background.getImage().getScaledInstance(1400, 800, Image.SCALE_SMOOTH)));
	 public StartPanel()
	{
		 this.setLayout(null);
//		 this.setLayout(new BorderLayout());
//		 this.setBackground(Color.black);
		 ImageOne = new JLabel();
		 
		 // لما تيجى قولى 
		 // فيه عك بيحصل عندك xD
		 
//		 URL imgURL = getClass().getResource("photo_2025-04-18_20-16-50.jpg");
//		 System.out.println(imgURL);

		 
		 ImageIcon Imagex =new ImageIcon("photo_2025-04-18_20-16-50.jpg");
		 ImageOne.setBounds(900,500,510,510);
		 ImageOne.setIcon(Imagex);
		 
		 ImageTwo = new JLabel();
		 ImageIcon Image =new ImageIcon("photo_2025-04-18_20-20-51.jpg");
		 ImageTwo.setBounds(810,90,700,600);
		 ImageTwo.setIcon(Image);
		 
		 Welcome = new JLabel ();
		 Welcome.setBounds(200, 100, 800, 100);
		 Welcome.setText("Welcome To Your Daily Planner!.");
		 Welcome.setFont(new Font("MV Boli",Font.PLAIN ,50));
		 Welcome.setForeground(Color.WHITE);// color of font .
		 
		 img.setSize(1400,800);
		 img.setLocation(0,0);
		 this.add(img, -1);
		 this.add(Welcome, 0);
//		 this.add(ImageOne);
//		 this.add(ImageTwo);		
//		 
		 
	}
}