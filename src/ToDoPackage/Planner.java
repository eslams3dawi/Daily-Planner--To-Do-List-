package ToDoPackage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Planner extends JPanel implements ActionListener{

    JPanel FirstPanel;
    static JPanel SecondPanel;
    static int numberOfTasks;
    JComboBox <String> DayComboBox;
    static JProgressBar Bar;
    JScrollPane ScrollPane;
    private JButton FinishButton = new JButton("Finish");
    private JButton BackButton = new JButton("Back");
    private Timer RefreshGUI = new Timer(0, new ActionListener(){
    @Override
        public void actionPerformed(ActionEvent e){
            repaintGUI();
        }
    });

//JComboBox = A component that combines a button or editable field and a drop down list.
//remember that we need to pass an array of reference data type.
//JCheckBox = GUI components that can be selected or deslected.
    
    public Planner(){
        //Main panel.
        this.setLayout(null);
        this.setBackground(new Color(46,46,46));
        RefreshGUI.start();

        // first Panel for week combo box.    
        FirstPanel = new JPanel();
        FirstPanel.setBackground(new Color(0, 0 ,0, 0));
        FirstPanel.setBounds(50, 40, 300, 200);
        
        JLabel Label = new JLabel(); 
        Label.setText("Select The Day");
        Label.setForeground(Color.white);
        Label.setFont(new Font("MV Boli",Font.PLAIN ,35));
        
        String[] days = {"Saturday","Sunday","Monday","Tuesday","Wedensday","Thursday","Friday"};
        DayComboBox = new JComboBox (days);
        DayComboBox.setSize(50,20);
        DayComboBox.setFont(new Font("MV Boli",Font.PLAIN ,20));
        DayComboBox.addActionListener(this);
        
        FirstPanel.add(Label);
        FirstPanel.add(DayComboBox);
        FirstPanel.setBounds(50,50,350,150);
        this.add(FirstPanel);

        //title panel for the second panel.
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(0, 0 ,0, 0));
        
        JLabel labelx = new JLabel("Enter your tasks");
        labelx.setForeground(Color.white);
        labelx.setFont(new Font("MV Boli",Font.PLAIN ,20));
        titlePanel.add(labelx);
        titlePanel.setBounds(500, 0, 600, 40);
        this.add(titlePanel);

        //Second panel.
        SecondPanel = new JPanel();
        SecondPanel.setBackground(new Color(0, 0 ,0, 0));
        ScrollPane = new JScrollPane(SecondPanel);
        ScrollPane.setBackground(new Color(0, 0 ,0, 0));
        ScrollPane.setBounds(500, 90, 600, 600);
        ScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        ScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        Bar = new JProgressBar();
        Bar.setBounds(50, 250, 400, 50);
        Bar.setFont(new Font (null,Font.BOLD,25));
        Bar.setStringPainted(true);	
        this.add(ScrollPane);  
        
        FinishButton.setBounds(1200, 650, 160, 100);
        FinishButton.setBackground(Color.WHITE);
        FinishButton.setFont(new Font("MV Boli",Font.BOLD ,40));
        FinishButton.setFocusable(false);
        FinishButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, "Start Over");
                Main.changecard("Welcome Panel");
                setDefault();//has remove all method to clear and start again
        }});	 
        
        BackButton.setBounds(40, 650, 250, 100);
        BackButton.setBackground(Color.WHITE);
        BackButton.setFont(new Font("MV Boli",Font.BOLD ,40));
        BackButton.setFocusable(false);
        BackButton.addActionListener(new ActionListener(){
            @Override
                public void actionPerformed(ActionEvent e){
                Main.changecard("Task No.s");
                setDefault();
        }});
        this.add(FinishButton);
        this.add(BackButton);
        this.add(Bar);
    }

    private void repaintGUI(){
        revalidate();
        repaint();
    }

  	public static void GetDefault(){          
        numberOfTasks = TaskNumberPanel.getTaskCount();
        SecondPanel.setLayout(new GridLayout(numberOfTasks, 2, 10, 10));// dimension of x 10, dimension of y 10
        for(int i = 0; i < numberOfTasks; i++){
            JTextField taskField = new JTextField("Task " + (i + 1));
            taskField.setFont(new Font("MV Boli",Font.PLAIN ,20));
            JCheckBox taskCheck = new JCheckBox("Done");
            taskCheck.setFont(new Font("MV Boli",Font.PLAIN ,20));
            
            Bar.setString(0 + " / " + numberOfTasks);
            Bar.setMaximum(numberOfTasks);
            Bar.setValue(0);
            taskCheck.addItemListener(e-> updateProgressBar());
            SecondPanel.add(taskField);
            SecondPanel.add(taskCheck);
        }
	}

	public void setDefault(){
        SecondPanel.removeAll();
        SecondPanel.revalidate();
        SecondPanel.repaint();
        this.setBackground(new Color(46,46,46));
        DayComboBox.setSelectedIndex(0);
	}
  
    private static void updateProgressBar(){
        int Done = 0;
        for(Component c : SecondPanel.getComponents()){//foreach
        if(c instanceof JCheckBox && ((JCheckBox) c).isSelected())
            Done++;
        Bar.setValue(Done);
        Bar.setString(Done + " / " + numberOfTasks);
        }
    }
  
  // Response for events.
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == DayComboBox){
            String SelectedDay = (String) DayComboBox.getSelectedItem();
            if(SelectedDay == "Saturday")
                this.setBackground(new Color(46,46,46));
            else if(SelectedDay == "Sunday")
                this.setBackground(new Color(44,120,108));
            else if(SelectedDay == "Monday")
                this.setBackground(new Color(53,80,112));
            else if(SelectedDay == "Tuesday")
                this.setBackground( new Color(139,69,19));
            else if(SelectedDay == "Wedensday")
                this.setBackground(new Color (128,0,32));
            else if(SelectedDay == "Thursday")
                this.setBackground(new Color(188,143,143));
            else if(SelectedDay == "Friday")
                this.setBackground( new Color(75,56,50));
        }
    }
}