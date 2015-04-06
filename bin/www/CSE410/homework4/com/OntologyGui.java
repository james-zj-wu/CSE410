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
        ontWindow.setSize(1000,500);
        ontWindow.setLocationRelativeTo(null);
        ontWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   
		//Divide window into two areas for layout purposes
		JPanel searchArea = new JPanel(new GridLayout(0,3));
		JPanel outputArea = new JPanel(new GridLayout(0,1));
		ontWindow.add(searchArea);
		ontWindow.add(outputArea);
		
		//TODO:Build Options
		//Organise Search Area for multiple options
		JPanel ButtonArea = new JPanel(new FlowLayout());
		JPanel SQLArea = new JPanel(new GridLayout(1,3));
		JPanel SearchBoxArea = new JPanel(new FlowLayout());
		
		//Set Max Size of Panels
		ButtonArea.setMaximumSize(new Dimension((searchArea.getMaximumSize().width/3),(searchArea.getMaximumSize().height)));
		SQLArea.setMaximumSize(new Dimension((searchArea.getMaximumSize().width/3),(searchArea.getMaximumSize().height)));
		SearchBoxArea.setMaximumSize(new Dimension((searchArea.getMaximumSize().width/3),(searchArea.getMaximumSize().height)));
		
		//Create Interfaces
		//Buttons for output area
		JPanel buttonInnerBox = new JPanel(new GridLayout(0,1));
		
		JButton showOnt =new JButton("Show Ontology");
		JButton showEntities = new JButton ("Show Entities");
		JButton showSubClasses	= new JButton("Show Sub Classes");
		JButton queryResults	= new JButton("Show Query Results");
		//Search for Entities
		JPanel searchInnerBox = new JPanel();
		searchInnerBox.setLayout(new BoxLayout(searchInnerBox, BoxLayout.Y_AXIS));
		JLabel searchWordLabel = new JLabel("Search Entities");
		JTextField wordSearch = new JTextField("",8);
		wordSearch.setMaximumSize(new Dimension(SearchBoxArea.getMaximumSize().width,wordSearch.getMinimumSize().height));
		JButton searchWord =new JButton("Search");
		//Search for Entities
		JPanel SQLInnerBox = new JPanel();
		SQLInnerBox.setLayout(new BoxLayout(SQLInnerBox, BoxLayout.Y_AXIS));
		JLabel SQLWordLabel = new JLabel("SPARQL Queries");
		JTextArea SQLSearch = new JTextArea("SELECT \n WHERE{} \n ORDER BY \n");
		SQLSearch.setMaximumSize(new Dimension(SQLArea.getMaximumSize().width,SQLSearch.getMinimumSize().height));
		JButton SQLSearchBT =new JButton("Search");
		
		//Add Display Layout Buttons
		ButtonArea.add(buttonInnerBox);
		SearchBoxArea.add(searchInnerBox);
		
		buttonInnerBox.add(showOnt);
		buttonInnerBox.add(showEntities);
		buttonInnerBox.add(showSubClasses);
		buttonInnerBox.add(queryResults);
		
		searchInnerBox.add(searchWordLabel);
		searchInnerBox.add(wordSearch);
		searchInnerBox.add(searchWord);
		
		SQLArea.add(SQLInnerBox);
		SQLInnerBox.add(SQLWordLabel);
		SQLInnerBox.add(SQLSearch);
		SQLInnerBox.add(SQLSearchBT);
		
		//Add All Divisions		
		searchArea.add(ButtonArea);
		searchArea.add(SearchBoxArea);
		searchArea.add(SQLArea);
				
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
