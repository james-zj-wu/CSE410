/**
 * OntologyGui.java
 * By: J.E.Scott Howells
 * Description: 
 * Created:
 * Modified: 
 */
package www.CSE410.homework4.com;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.StrokeBorder;

/**
 * @author Scott Howells
 *
 */
public class OntologyGui{
	
	/**
	 * 
	 * Description:
	 * Parameters
	 * Return:
	 */
	public void buildWindow(){
		//Build the basic frame
		JFrame ontWindow = new JFrame("Ontology Window");
		ontWindow.setLayout(new GridLayout(0,1));
        ontWindow.setSize(1000,700);
        ontWindow.setLocationRelativeTo(null);
        ontWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   
		//Divide window into two areas for layout purposes
		JPanel searchArea = new JPanel(new GridLayout(0,3));
		JPanel outputArea = new JPanel(new GridLayout(0,1));
		ontWindow.add(searchArea);
		ontWindow.add(outputArea);
		
		//TODO:Build Options
		//Organise Search Area for multiple options
		JPanel ButtonArea = new JPanel(new GridLayout(0,1));
		JPanel SQLArea = new JPanel(new GridLayout(1,3));
		JPanel SearchBoxArea = new JPanel(new GridLayout(1,3));
		
		//Set Max Size of Panels
		ButtonArea.setMaximumSize(new Dimension((searchArea.getMaximumSize().width/3),(searchArea.getMaximumSize().width)));
		SQLArea.setMaximumSize(new Dimension((searchArea.getMaximumSize().width/3),(searchArea.getMaximumSize().width)));
		SearchBoxArea.setMaximumSize(new Dimension((searchArea.getMaximumSize().width/3),(searchArea.getMaximumSize().width)));
		
		//Create Interfaces
		JButton showOnt =new JButton("Show Ontology");
		JButton showEntities = new JButton ("Show Entities");
		JButton showSubClasses	= new JButton("Show Sub Classes");
		

		
		//Add Display Layout Buttons
		showOnt.setMaximumSize(new Dimension(showOnt.getMinimumSize().width, showOnt.getMinimumSize().height));
		showEntities.setMaximumSize(new Dimension(showEntities.getMinimumSize().width, showEntities.getMinimumSize().height));
		showSubClasses.setMaximumSize(new Dimension(showSubClasses.getMinimumSize().width, showSubClasses.getMinimumSize().height));
		
		ButtonArea.add(showOnt);
		ButtonArea.add(showEntities);
		ButtonArea.add(showSubClasses);
		
		//Add All Divisions
		searchArea.setBorder(BorderFactory.createEmptyBorder(0,10, 0, 10));
		searchArea.add(ButtonArea,BorderLayout.LINE_START);
		searchArea.add(new JSeparator(JSeparator.VERTICAL));
		searchArea.add(SearchBoxArea,BorderLayout.CENTER);
		searchArea.add(new JSeparator(JSeparator.VERTICAL));
		searchArea.add(SQLArea,BorderLayout.LINE_END);
		
		//Decorate Output Area
		outputArea.setBorder(BorderFactory.createLineBorder(Color.black));
		outputArea.setBackground(Color.white);

		//Show window
		ontWindow.setVisible(true);
		
	}
	/**
	 * @param size
	 * @return
	 * Description:
	 * Parameters
	 * Return:
	 */
	private JPanel[] makeSearch(int size){
		JPanel [] temp = new JPanel[size];
		int count=0;
		for (JPanel t : temp){
			t=new JPanel();
		}
		return temp;
	}
	/**
	 * @return
	 * Description:
	 * Parameters
	 * Return:
	 */
	private JPanel[] displayOntology(int size) {
		JPanel [] temp = new JPanel[size];
		int count =0;
		for (JPanel t : temp){
			t=new JPanel();
			t.add(new JLabel(Integer.toString(count++)));
		}
		return temp;
	}


}
