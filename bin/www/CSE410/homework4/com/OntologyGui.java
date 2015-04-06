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

import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.util.FileManager;
import com.hp.hpl.jena.query.* ;
import java.io.*;
/**
 * @author Scott Howells
 *
 */
public class OntologyGui{
	
	//Fields used across functions
	JFrame ontWindow = new JFrame("Ontology Window");
	private JTextField wordSearch;
	private JTextArea SQLSearch;
	private JButton showOnt =new JButton("Show Ontology");
	private JButton showEntities = new JButton ("Show Entities");
	private JButton showSubClasses	= new JButton("Show Sub Classes");
	private JButton queryResults	= new JButton("Show Query Results");
	private JButton searchWord =new JButton("Search");
	private JButton SQLSearchBT =new JButton("Search");
	
	//Output Area
	private JPanel outputArea = new JPanel(new GridLayout(0,1));
	private JPanel out = new JPanel();
	private JTextArea output = new JTextArea();
	private JScrollPane outputScroll = new JScrollPane(output);
	/**
	 * Method: buildWindow
	 * Description: Constructs frame work for the GUI
	 */
	public void buildWindow(){
		//Build the basic frame
		
		ontWindow.setLayout(new GridLayout(0,1));
        ontWindow.setSize(1000,500);
        ontWindow.setLocationRelativeTo(null);
        ontWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   
		//Divide window into two areas for layout purposes
		JPanel searchArea = new JPanel(new GridLayout(0,3));
		ontWindow.add(searchArea);
		ontWindow.add(outputArea);
		
		//Organise Search Area for multiple options
		JPanel ButtonArea = new JPanel(new FlowLayout());
		JPanel SQLArea = new JPanel(new GridLayout(1,3));
		JPanel SearchBoxArea = new JPanel(new FlowLayout());
		
		//Set Up Output pane
		this.output.setColumns(10);
		this.output.setRows(5);
		this.output.setLineWrap(true);
		this.output.setWrapStyleWord(true);
		this.outputScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		//Set Max Size of Panels
		ButtonArea.setMaximumSize(new Dimension((searchArea.getMaximumSize().width/3),(searchArea.getMaximumSize().height)));
		SQLArea.setMaximumSize(new Dimension((searchArea.getMaximumSize().width/3),(searchArea.getMaximumSize().height)));
		SearchBoxArea.setMaximumSize(new Dimension((searchArea.getMaximumSize().width/3),(searchArea.getMaximumSize().height)));
		
		//Create Interfaces
		//Handlers
		DisplayEventHandler displayAreaHandler = new DisplayEventHandler();
		SPARQLSearchHandler SPARQLHandler = new SPARQLSearchHandler();
		SearchHandler searchHandler = new SearchHandler();
		
		showOnt.addActionListener(displayAreaHandler);
		showEntities.addActionListener(displayAreaHandler);
		showSubClasses.addActionListener(displayAreaHandler);
		queryResults.addActionListener(displayAreaHandler);
		SQLSearchBT.addActionListener(SPARQLHandler);
		searchWord.addActionListener(searchHandler);
		
		//Buttons for output area
		JPanel buttonInnerBox = new JPanel(new GridLayout(0,1));

		
		//Search for Entities
		JPanel searchInnerBox = new JPanel();
		searchInnerBox.setLayout(new BoxLayout(searchInnerBox, BoxLayout.Y_AXIS));
		JLabel searchWordLabel = new JLabel("Search Entities");
		this.wordSearch = new JTextField("",8);
		this.wordSearch.setMaximumSize(new Dimension(SearchBoxArea.getMaximumSize().width,wordSearch.getMinimumSize().height));

		//Search for Entities
		JPanel SQLInnerBox = new JPanel();
		SQLInnerBox.setLayout(new BoxLayout(SQLInnerBox, BoxLayout.Y_AXIS));
		JLabel SQLWordLabel = new JLabel("SPARQL Queries");
		this.SQLSearch = new JTextArea("PREFIX foaf: <http://xmlns.com/foaf/0.1/> \n" +
				"SELECT ?url\n " +
				"WHERE {" +
				" ?contributor foaf:name \"John Barstow\" . " +
				" ?contributor foaf:weblog ?url . " +
				" }",5,15);//"PREFIX foaf: <http://xmlns.com/foaf/0.1/> \n SELECT \n WHERE{} \n");
		
		this.SQLSearch.setColumns(10);
		this.SQLSearch.setRows(5);
		this.SQLSearch.setLineWrap(true);
		this.SQLSearch.setWrapStyleWord(true);
		JScrollPane SQLScrollWindow =new JScrollPane(this.SQLSearch);
		SQLScrollWindow.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
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
		SQLInnerBox.add(SQLScrollWindow);
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
	
	/**
	 * OntologyGui
	 * By: J.E.Scott Howells
	 * Description: 
	 * Created:Apr 6, 2015
	 * Modified: 
	 */
	private class DisplayEventHandler implements ActionListener{

		public void actionPerformed(ActionEvent event) {
			//initiate Output area
			out.removeAll();
			out.setLayout(new BoxLayout(out, 1));
			output.setText(null);
			out.add(outputScroll);
			out.updateUI();
			
			if(event.getSource()== showOnt ){
				System.out.println("Show Ontology");//TODO:REMOVE THIS
			}
			else if (event.getSource()== showEntities ){
				System.out.println("Show Entity");//TODO:REMOVE THIS
			}
			else if (event.getSource()== showSubClasses ){
				System.out.println("Show Sub Classes");//TODO:REMOVE THIS	
			}
			else if (event.getSource()== queryResults ){
				SQLSearchBT.doClick();//why reinvent the wheel :)
			}
		}
	}
	/**
	 * OntologyGui
	 * By: J.E.Scott Howells
	 * Description: 
	 * Created:Apr 6, 2015
	 * Modified: 
	 */
	private class SearchHandler implements ActionListener{

		public void actionPerformed(ActionEvent event) {
			System.out.println("Searched "+wordSearch.getText());//TODO:REMOVE THIS		
		}
	}
	/**
	 * OntologyGui
	 * By: J.E.Scott Howells
	 * Description: 
	 * Created:Apr 6, 2015
	 * Modified: 
	 */
	private class SPARQLSearchHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			System.out.println("Searched "+SQLSearch.getText());//TODO:REMOVE THIS	
			OntologyTutorial5 ontology = new OntologyTutorial5(SQLSearch.getText());
		}
		
	}

	private class OntologyTutorial5 {
		static final String inputFileName = "./ontology/bloggers.rdf";
		public OntologyTutorial5 (String queryString){
			//initiate Output area
			output.setText(null); //clear last result
			out.removeAll();
			out.setLayout(new BoxLayout(out, 1));
			
			// Create an empty in-memory model
			Model model = ModelFactory.createDefaultModel();
			// use the FileManager to open the bloggers RDF graph from the filesystem
			InputStream in = FileManager.get().open(inputFileName);
			if (in == null) {
				throw new IllegalArgumentException( "File: " + inputFileName + " not found");
			}
			// read the RDF/XML file
			model.read( in, "" );
			//Create a new query

			Query query = QueryFactory.create(queryString);
			//Execute the query and obtain results
			QueryExecution qe = QueryExecutionFactory.create(query, model);
			ResultSet results = qe.execSelect();
			//Convert Results to string
			String resultString = ResultSetFormatter.asText(results);
			//Output results
			output.setText(resultString);
			//Display results
			out.add(outputScroll);
			outputArea.add(out);
			System.out.println(resultString);//TODO Remove This
			//Important -free up resources used running the query
			out.updateUI();
			ontWindow.revalidate();
			
			qe.close();
		}
	}
}
