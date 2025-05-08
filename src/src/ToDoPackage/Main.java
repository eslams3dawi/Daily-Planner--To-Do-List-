package   ToDoPackage;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main extends JFrame implements ActionListener 
{
	//CardLayout = Layout manager allows to swap between components in the same window.
   //              only one component is visable at a time. 
  //               this component here is panel.
	CardLayout cardlayout;
	Container container;//container of panels.
	StartPanel startpanel;
	TaskNumberPanel tasknumberPanel; 
	Planner planner;
	JButton SwitchButton1;
	JButton SwitchButton2;
	JButton SwitchButton3;
	
	 public Main()
	{
	 //Frame.
	 this.setSize(1400, 800);
	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 this.setLocationRelativeTo(null);
	 //Card Layout.
	 cardlayout = new CardLayout();
	 container =  getContentPane();// get the content of frame.
	 container.setLayout(cardlayout);
	 
	 //Panel1.
	 startpanel = new StartPanel();
	 
	 //Panel2.
	 tasknumberPanel  = new TaskNumberPanel (); 
	 
	 //Panel3.
	 planner = new Planner();
	 
	 //Switch Buttons.
	 SwitchButton1 = new JButton();
	 SwitchButton1.setBounds(410, 425, 400, 150);
	 SwitchButton1.setText("Start Planning.");
	 SwitchButton1.setFont(new Font("MV Boli",Font.BOLD ,40));
	 SwitchButton1.setBackground(Color.white);
	 SwitchButton1.setFocusable(false);
	 SwitchButton1.addActionListener(this);
	 
	 SwitchButton2 = new JButton();
	 SwitchButton2.setBounds(300, 300, 500, 600);
	 SwitchButton2.setText("Next");
	 SwitchButton2.setFont(new Font("MV Boli",Font.BOLD ,40));
	 SwitchButton2.setFocusable(false);
	 SwitchButton2.addActionListener(this);
	 SwitchButton2.setBackground(Color.white);
	 
	 SwitchButton2.setBounds(700, 600, 250, 100);
	 
	 SwitchButton3 = new JButton();
	 SwitchButton3.setBounds(50, 500, 160, 100);
	 SwitchButton3.setText("Next");
	 SwitchButton3.setFont(new Font("MV Boli",Font.BOLD ,40));
	 SwitchButton3.setFocusable(false);
	 SwitchButton3.addActionListener(this);//when i click on the action happens.
	  
	 // Add the switch buttons to Panels.
	 startpanel.add(SwitchButton1);
	 tasknumberPanel.add(SwitchButton2);
	 planner.add(SwitchButton3);
	 
	 //Add Panels to Frame.
	 container.add(startpanel,"p1");
	 container.add(tasknumberPanel,"p2");
	 container.add(planner,"p3");

	 this.setVisible(true);
		
	}

	int CurrentPanel = 1;
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		CurrentPanel++;
		if(CurrentPanel>3)
		{
			JOptionPane.showMessageDialog(this, "Start Over");
			// parent,title ,message,type of mark.
			//we can use color chooser method to set its color.
			CurrentPanel = 1;
		}
		cardlayout.show(container, "p"+ CurrentPanel);//how to get the next panel.	
	}
	
	public static void main(String[] args) 
	{
		new Main();
	}
}
