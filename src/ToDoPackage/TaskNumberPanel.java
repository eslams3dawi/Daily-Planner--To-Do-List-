package ToDoPackage;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//JTextField = a GUI textbox component that can be used to add,set or get text.
//"Action listener interface" exists at java.awt.event library.

public class TaskNumberPanel extends JPanel implements ActionListener{

	private JLabel Label; //label.
	private static JTextField TaskCount; //text field to get number of tasks in.
	private JButton ConfirmButton; //Button.
	private JButton SwitchButton2 = new JButton();
	private JButton PreviousButton2 = new JButton();
	ImageIcon background = new ImageIcon("img2.jpg");
	private JLabel img = new JLabel(new ImageIcon(background.getImage().getScaledInstance(1400, 800, Image.SCALE_SMOOTH)));

	//defined out of constructor to be global for class.
	public TaskNumberPanel(){	//constructor.
		this.setLayout(null);
		this.setBackground(Color.BLACK);
		
		Label= new JLabel();
		Label.setText(" How Many Tasks for today?");
		Label.setForeground(Color.CYAN); //set font color of text.
		Label.setFont(new Font("MV Boli",Font.PLAIN ,40)); //set font of text + the last parameter is the size of text.
		Label.setPreferredSize(new Dimension(700,200));
		Label.setBorder(BorderFactory.createLineBorder(Color.cyan, 4));
		Label.setBounds(380, 200, 580, 100);
		
		TaskCount = new JTextField();
		TaskCount.setForeground(Color.black);
		TaskCount.setFont(new Font("MV Boli",Font.PLAIN ,40));
		TaskCount.setBounds(500, 310, 300, 100);
		
		ConfirmButton = new JButton();
		ConfirmButton.setText("Confirm");
		ConfirmButton.setPreferredSize(new Dimension(500,100));
		ConfirmButton.setBackground(Color.WHITE);
		ConfirmButton.setForeground(Color.black);
		ConfirmButton.setFont(new Font("MV Boli",Font.PLAIN ,40));
		ConfirmButton.setBounds(350, 600, 250, 100);
		ConfirmButton.addActionListener(this);
		
		SwitchButton2.setBounds(300, 300, 500, 600);
		SwitchButton2.setText("Next");
		SwitchButton2.setFont(new Font("MV Boli",Font.BOLD ,40));
		SwitchButton2.setFocusable(false);
		SwitchButton2.setBackground(Color.white);
		SwitchButton2.setBounds(700, 600, 250, 100);
		SwitchButton2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(getTaskCount() > 0){
					JOptionPane.showMessageDialog(null, "Wishing you a productive day.");//why null
					Main.planner.GetDefault();
					Main.changecard("Tasks Panel");
				}
				else
					JOptionPane.showMessageDialog(null, "Error!!,Please enter a valid number of tasks.");
		}});	 	 
		PreviousButton2 = new JButton();
		PreviousButton2.setBounds(40, 650, 250, 100);
		PreviousButton2.setText("Back");
		PreviousButton2.setBackground(Color.WHITE);
		PreviousButton2.setFont(new Font("MV Boli",Font.BOLD ,40));
		PreviousButton2.setFocusable(false);
		PreviousButton2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				Main.changecard("Welcome Panel");
		}});
		
		img.setSize(1400,800);
		img.setLocation(0,0);
		
		this.add(Label);
		this.add(SwitchButton2);
		this.add(PreviousButton2);
		this.add(TaskCount);
		this.add(ConfirmButton);
		this.add(img);
	}
	
	public static int getTaskCount(){
		try
		{
			return Integer.parseInt(TaskCount.getText());//Integer.parseInt = converts string into integer.
		}
		catch (NumberFormatException e){
			return -1;
		}
	}

	//JOptionPane = dialog box inform user of something.
	//shows temprory messege.
	@Override
	public void actionPerformed(ActionEvent e){
		int Count = getTaskCount();
		if(Count <= 0)
			JOptionPane.showMessageDialog(this, "Error!, please enter a valid number of tasks.");//why this
		else
			JOptionPane.showMessageDialog(this, "OK Now you can start, wishing you a productive day.");
	}
}