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
		//TODO: Add border between the two areas
		//outputArea.setBorder();
		
		//TODO: fill panels with stuff
		JPanel[] search=new JPanel[5];
		search=makeSearch(5);
		for(JPanel j : search){
			searchArea.add(j);
		}
//		JPanel[] display=new JPanel[5];
//		display=displayOntology(5);
//		for(JPanel j : display){
//			searchArea.add(j);
//		}
		
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
