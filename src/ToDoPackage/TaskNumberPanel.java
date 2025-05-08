package ToDoPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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

public class TaskNumberPanel extends JPanel implements ActionListener //this frame now can listen to events.
                                                                     //"Action listener interface" exists at java.awt.event library.
{
	private JLabel Label;//label.
	private JTextField TaskCount;//text field to get number of tasks in.
	private JButton ConfirmButton;//Button.
	//defined out of constructor to be global for class.
	
	TaskNumberPanel()//constructor.
	{
		this.setLayout(new FlowLayout());
		this.setBackground(Color.BLACK);
		
		Label= new JLabel();
		Label.setText("How Many Tasks for today?");
		Label.setForeground(Color.CYAN);//set font color of text.
		Label.setFont(new Font("MV Boli",Font.PLAIN ,40));//set font of text + the last parameter is the size of text.
		Label.setPreferredSize(new Dimension(700,200));
		Border border = BorderFactory.createLineBorder(Color.cyan, 4);
		Label.setBorder(border);
		
		TaskCount = new JTextField();
		TaskCount.setPreferredSize(new Dimension(400,200));//x,y.
		TaskCount.setBackground(Color.LIGHT_GRAY);
	    TaskCount.setForeground(Color.black);
		TaskCount.setFont(new Font("MV Boli",Font.PLAIN ,40));
		 
		ConfirmButton = new JButton();
		ConfirmButton.setText("Confirm");
		ConfirmButton.setPreferredSize(new Dimension(500,100));
		ConfirmButton.setBackground(Color.LIGHT_GRAY);
		ConfirmButton.setForeground(Color.black);
		ConfirmButton.setFont(new Font("MV Boli",Font.PLAIN ,40));
		ConfirmButton.addActionListener(this);
		
		this.add(Label);
		this.add(TaskCount);
		this.add(ConfirmButton);
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
