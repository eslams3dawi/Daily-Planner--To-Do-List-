package  ToDoPackage;

import java.awt.*;
import javax.swing.*;

public class Main extends JFrame{

	//CardLayout = Layout manager allows to swap between components in the same window.
	//              only one component is visible at a time. 
	//               this component here is panel.

	static CardLayout cardlayout = new CardLayout(); //must be static, because the method that use it static
	static Container container = new Container();
	StartPanel startpanel;
	public static TaskNumberPanel tasknumberPanel;
	public static Planner planner = new Planner();

	public Main(){
		//Frame.
		this.setSize(1400, 800);
		this.setTitle("Daily Planner");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		ImageIcon icone = new ImageIcon("TaskIcon.png");
		this.setIconImage(icone.getImage());

		//Card Layout.
		container = getContentPane();//28
		container.setLayout(cardlayout);

		//Panel1.
		startpanel = new StartPanel();

		//Panel2.
		tasknumberPanel = new TaskNumberPanel();
		
		//panel3 doesn't start

		//Add Panels to Frame.
		container.add(startpanel,"Welcome Panel");
		container.add(tasknumberPanel,"Task No.s");
		container.add(planner,"Tasks Panel");
		
		this.setVisible(true);
	}

	public static void changecard(String ChoosedPanel){ //static method can be accessed even if the class is non-static
		cardlayout.show(container, ChoosedPanel); //to how to get the next panel.	
	} 

	public static void main(String[] args){
		new Main();
	}
}
