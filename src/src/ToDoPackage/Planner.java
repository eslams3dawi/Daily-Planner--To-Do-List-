package ToDoPackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class Planner extends JPanel implements ActionListener 
{
	private int numberOfTasks;
	JComboBox <String> DayComboBox;
	//JProgressBar ProgressPar; +scrolPane.
	JPanel FirstPanel ;
	JPanel SecondPanel;
	

	//JComboBox = A component that combines a button or editable field and a drop down list.
   //             remember that we need to pass an array of reference data type.
  //  JCheckBox = GUI components that can be selected or deslected.
	
	public Planner()
	{
		//Main panel.
		this.setLayout(null);
		this.setBackground(Color.gray);
	
        // first Panel for week combo box.		
		FirstPanel = new JPanel();
		FirstPanel.setBackground(Color.black);
		FirstPanel.setBounds(50, 40, 300, 200);
		
	    JLabel Label = new JLabel(); 
	    Label.setText("Select The Day");
	    Label.setForeground(Color.white);
		Label.setFont(new Font("MV Boli",Font.PLAIN ,35));
		
		String[] days = {"Saturday","Sunday","Monday","Tuesday","Wednesday","Thursday","Friday"};
		DayComboBox = new JComboBox(days);
		DayComboBox.setBounds(50, 20, 300, 40);
		DayComboBox.addActionListener(this);
		
		FirstPanel.add(Label);
		FirstPanel.add(DayComboBox);
		FirstPanel.setBounds(50,50,350,150);
		this.add(FirstPanel);
		
		//title panel for the second panel.
		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(Color.black);
		JLabel labelx = new JLabel("All Your Tasks");
		labelx.setForeground(Color.white);
		labelx.setFont(new Font("MV Boli",Font.PLAIN ,20));
		titlePanel.add(labelx);
		titlePanel.setBounds(500, 0, 600, 40);
		this.add(titlePanel);
		//Second panel.
		SecondPanel = new JPanel();
		SecondPanel.setBackground(Color.black);
		SecondPanel.setBounds(500, 90, 600, 600);
	    SecondPanel.setLayout(new GridLayout(5, 2, 10, 10));
	    //TaskNumberPanel TaskNumber = new TaskNumberPanel();
	    //int count = TaskNumber.getTaskCount();
		for (int i = 0; i < 10; i++)
		{
		   JTextField taskField = new JTextField("Task " + (i + 1));
		   JCheckBox taskCheck = new JCheckBox("Done");

		    SecondPanel.add(taskField);
		    SecondPanel.add(taskCheck);
		}	
		this.add(SecondPanel);			
	}
	
	@Override
	public void actionPerformed(ActionEvent e)// Response for events.
	{
	 if(e.getSource()==DayComboBox)
	 {
		 String SelectedDay = (String) DayComboBox.getSelectedItem();
		 
		 if(SelectedDay == "Saturday" )
		 {
			 this.setBackground(Color.lightGray);
		 }
		 else if(SelectedDay == "Sunday" )
		 {
			 this.setBackground(Color.black);
		 }
		 else if(SelectedDay == "Monday" )
		 {
			 this.setBackground(Color.pink);
		 }
		 else if(SelectedDay == "Tuesday" )
		 {
			 this.setBackground(Color.cyan);
		 }
		 else if(SelectedDay == "Wednesday" )
		 {
			 this.setBackground(Color.DARK_GRAY);
		 }
		 else if(SelectedDay == "Thursday" )
		 {
			 this.setBackground(Color.magenta);
		 }
		 else if(SelectedDay == "Friday" )
		 {
			 this.setBackground(Color.white);
		 } 
	 }	
	}
}
