package ToDoPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

//JTextField = a GUI textbox component that can be used to add,set or get text.

//for the start panel اسلام
 //add label image for the start panel 
 //for all buttons, change the background color button & dimensions 

//for the taskNumberPanel اسلام
 //next even if there is no tasks اسر
 //Suppose there is no default no.tasks, the user must enter number to next اسر
 //absolute instead of flow layout 
 //add previous button 
 //limit the no.tasks 

//for the planner panel اسر
 //once start over, suppose delete the old tasks 
 //wedensday has no color 
 //add previous button 
 //can delete task 
//using itemListener, on the checkBox, for striketThrough

//Progress bar اسماء
 //once the taks's checkbox is selected, the progress bar increase

public class TaskNumberPanel extends JPanel implements ActionListener //this frame now can listen to events.
                                                                     //"Action listener interface" exists at java.awt.event library.
{
//	Border border = BorderFactory.createLineBorder(Color.cyan, 4);
	
	
	private JLabel Label;//label.
	private JTextField TaskCount;//text field to get number of tasks in.
	private JButton ConfirmButton;//Button.
	//defined out of constructor to be global for class.
	
	ImageIcon background = new ImageIcon("backgroundImg.jpg");
	private JLabel img = new JLabel(new ImageIcon(background.getImage().getScaledInstance(1400, 800, Image.SCALE_SMOOTH)));
	TaskNumberPanel()//constructor.
	{
		this.setLayout(null);
		this.setBackground(Color.BLACK);
		
		Label= new JLabel();
		Label.setText(" How Many Tasks for today?");
		Label.setForeground(Color.CYAN);//set font color of text.
		Label.setFont(new Font("MV Boli",Font.PLAIN ,40));//set font of text + the last parameter is the size of text.
		Label.setPreferredSize(new Dimension(700,200));
		Label.setBorder(BorderFactory.createLineBorder(Color.cyan, 4));
		
		Label.setBounds(380, 200, 580, 100);
		
		TaskCount = new JTextField();
//		TaskCount.setBackground(Color.LIGHT_GRAY);
	    TaskCount.setForeground(Color.black);
		TaskCount.setFont(new Font("MV Boli",Font.PLAIN ,40));
		
		TaskCount.setBounds(500, 310, 300, 100);
		 
		ConfirmButton = new JButton();
		ConfirmButton.setText("Confirm");
		ConfirmButton.setPreferredSize(new Dimension(500,100));
		ConfirmButton.setBackground(Color.WHITE);
		ConfirmButton.setForeground(Color.black);
		ConfirmButton.setFont(new Font("MV Boli",Font.PLAIN ,40));

		
//		 SwitchButton2.setBounds(700, 600, 250, 100);   // edit it 

		
		ConfirmButton.addActionListener(this);
		
		ConfirmButton.setBounds(350, 600, 250, 100);
		
		 img.setSize(1400,800);
		 img.setLocation(0,0);
		 this.add(img, -1);
		 
		this.add(Label, 0);
		this.add(TaskCount, 0);
		this.add(ConfirmButton, 0);
		

	}
	public int getTaskCount() 
	{
	    try
	    {
	        return Integer.parseInt(TaskCount.getText());
	        //Integer.parseInt = converts string into integer.
	    } 
	    catch (NumberFormatException e) //catch error.
	    {
	        return -1;
	    }
	}
	//JOptionPane = dialog box inform user of something.
   // shows temprory messege.
	@Override
	public void actionPerformed(ActionEvent e)
	{
	int Count = getTaskCount();
	if(Count <= 0)
	   
    {
        JOptionPane.showMessageDialog(this, "Error!!,Please enter a valid number of tasks.");
    }
	else
	{
		 JOptionPane.showMessageDialog(this, "OK Now you can start .Wishing you a productive day.");	
	}
 }
}
