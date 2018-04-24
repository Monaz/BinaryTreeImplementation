import java.awt.EventQueue;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import javax.swing.JTextField;
import javax.swing.JLabel;
public class MainWindow {

	BSTFunctions bst;
	ArrayList<BSTNode> bstNodes; //store bst node values in the arraylist
	private JFrame frame;  // frame for the program
	private JTable table;  //table to show the data/entries
	private JPanel panel;

	Student student;
	
    ArrayList<Student> list;//store the student class variable in the arraylist
    DefaultTableModel model;
    private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
            try {
                MainWindow window;///creating/showing the JFrame
				window = new MainWindow();
				window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
	}

	/**
	 * Create the application.
	 */
	public MainWindow() 
	{
		initialize();
	    list = new ArrayList<Student>();
	    model = (DefaultTableModel)table.getModel();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	public Student getStudent(String s){
		
		ArrayList<Student> l = readFile();
		for(Student std : l){
			if(std.getLast_name().equals(s)){
				student = std;
			}
		}
		return student;
	}

	/**
		here it is reading the stored data from file
		and put this data into the student arraylist
		and than return this list
	*/
	
	
	public ArrayList<Student> readFile()
	{
		
	       try{
	            FileReader fileReader = new FileReader("src/StudentData.txt");//opening file
	            BufferedReader reader = new BufferedReader(fileReader);//opening file for reading
	            
	            String line = reader.readLine();//read a line
	            
	            while(line != null){ //read unless there is a null value in the file
	                
	                
	                //System.out.println(line);
	                String[] parts = line.split(",");
                    /**
					get the dta from file and than initialize the student class
					and put that variable in arraylist
					*/
	                
	                Student std = new Student();//opening file
	                std.setStd_id(parts[0]);
	                std.setFirst_name(parts[1]);
	                std.setLast_name(parts[2]);
	                std.setCourses(new String[]{parts[3],parts[4],parts[5],parts[6]});
	                std.setCredits(new int[]{Integer.parseInt(parts[7]),Integer.parseInt(parts[8]),Integer.parseInt(parts[9]),Integer.parseInt(parts[10])});
	                std.setGrades(new String[]{parts[11],parts[12],parts[13],parts[14]});
	                std.setTotal_credits(Integer.parseInt(parts[15]));
	                std.setCurrent_gpa(Double.parseDouble(parts[16]));
					///std.end(Double.parseDouble(parts[17]));
					if(std.getend().equals(-999)){
						break;
					}
	                
	                list.add(std);
	                line = reader.readLine();
	                
	            }
	            //label1.setText(my);
	       }catch(Exception e){
			   JOptionPane.showMessageDialog(null,"FILE NOT FOUND");
	           //System.out.print("file not found");
	       }
	       
	       return list;
	}


    /**
	here it is creating the window
	and puttting components into that like button.table etc
	*/
	
	
	
	private void initialize() 
	{
		frame = new JFrame();//frame for the program
		frame.setBounds(100, 100, 1050, 600);//size of the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//adding panel into the jframe
		frame.getContentPane().setLayout(null);
        /**
		*adding borders and bounds in the panel
		*/
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Student Records", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(4, 42, 1026, 215);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
        //creating a table
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
                //adding the header into the table
			new String[] {
				"New Column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table.setBounds(6, 16, 1014, 192);//setting table size
		panel.add(table);//adding table to the panel
		
		JButton btnShow = new JButton("readfile");//creating the button
		/**
         * This function will add the action to the button
		* so whenever the show button is pressed
		* this method will be called
		*/
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

		        model.setRowCount(0);
		         /**

					read file and load it in the arraylist
				*/
		        list = readFile();

		        JOptionPane.showMessageDialog(null, "File has been read and loaded into Program.");
		         /**
					Manipulate the student class so
					to get the value from that and put that into the table
				*/
		        
		            
		        for(Student std : list){
		            
		            String id = std.getStd_id();
		            String first = std.getFirst_name();
		            String last = std.getLast_name();
		            
		            String[] courses = std.getCourses();
		            String course1 = courses[0];
		            String course2 = courses[1];
		            String course3 = courses[2];
		            String course4 = courses[3];
		            
		            String[] credits = std.getCourses();
		            String credit1 = credits[0];
		            String credit2 = credits[1];
		            String credit3 = credits[2];
		            String credit4 = credits[3];
		            
		            String[] grades = std.getGrades();
		            String grade1 = grades[0];
		            String grade2 = grades[1];
		            String grade3 = grades[2];
		            String grade4 = grades[3];
		            
		            int total = std.getTotal_credits();
		            double gpa = std.getCurrent_gpa();
		            
		            //String[] col = {"ID","First Name","Last Name","Course 1","Course 2","Course 3","Course 4","Credit 1","Credit 2","Credit 3","Credit 4","Grade 1","Grade 2","Grade 3","Grade 4","Total Credits","Current gpa"};
		            Object[] data = {id,first,last,course1,course2,course3,course4,credit1,credit2,credit3,credit4,total,gpa};
		            
		            
		            model.addRow(data);
		        }
		      
				
			}
		});
		btnShow.setBounds(10, 11, 89, 29);//button size
		frame.getContentPane().add(btnShow);//add button
		
		JButton btnStoreInBst = new JButton("Store in BST");//creating button to store data in bst
		btnStoreInBst.addActionListener(new ActionListener() {
            //action performed when button is clicked
			public void actionPerformed(ActionEvent e) {
				if(!list.isEmpty()){//if the student array list is not empty
		            
			        bst = new BSTFunctions();//creating bst
			        
			        //Inserting Student objects into the BST
			        //First Object
			        //System.out.println(list.get(0).getStd_id());
			        
			        bst.insertNode(bst.ROOT,list.get(0));
			        
			        //Second Student Object
			        
			        bst.insertNode(bst.ROOT,list.get(1));
			        
			        //Third Student Object
			        bst.insertNode(bst.ROOT,list.get(2));
			        
			        //Fourth Student Object
			        bst.insertNode(bst.ROOT,list.get(3));
			        
			        //Fifth Student Object
			        bst.insertNode(bst.ROOT,list.get(4));
			        
			        JOptionPane.showMessageDialog(null, "BST is loaded with data and is ready to go.");
			                
//			        bst.printInOrder(bst.ROOT);
//			        System.out.println("  ");
//			        bst.printPostOrder(bst.ROOT);
//			        
			        }
			        else
			        {
			            JOptionPane.showMessageDialog(null, "First read file and Store in BST.");
			        }

			}
		});
		btnStoreInBst.setBounds(119, 11, 124, 29);//button for search by id
		frame.getContentPane().add(btnStoreInBst);
		
		JButton btnSearchById = new JButton("Search by ID");
		btnSearchById.addActionListener(new ActionListener() {
            /**
				* here it will get the value from the text user add
				* then match it with the values in the list
				* if the value is present than it will show on the table
				*/

			public void actionPerformed(ActionEvent e) {
				
				if(textField.getText().equals("")){
		            JOptionPane.showMessageDialog(null, "Enter ID # of student and search");
		        }
		        else
		        {
		            
		        	if(bst == null){
		        		JOptionPane.showMessageDialog(null, "First load in BST then Search");
		        	}
		        	else
		        	{
		        		BSTNode node = bst.searchByID(bst.ROOT, textField.getText());
				        
			            if(node == null)
			            {
			                JOptionPane.showMessageDialog(null, "Student not found");
			            }
			            else
			            {
			                String[] courses = node.std.getCourses();
			            
			                String course1 = courses[0];
			                String course2 = courses[1];
			                String course3 = courses[2];
			                String course4 = courses[3];

			                String[] credits = node.std.getCourses();

			                String credit1 = credits[0];
			                String credit2 = credits[1];
			                String credit3 = credits[2];
			                String credit4 = credits[3];

			            
			                
			                Object[] data = {node.std.getStd_id(),node.std.getFirst_name(),node.std.getLast_name(),course1,course2,course3,course4,credit1,credit2,credit3,credit4,node.std.getTotal_credits(),node.std.getCurrent_gpa()};
			                //DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
			                model.setRowCount(0);
			                model.addRow(data);
			           
			            }

		        	}
		        }
		            		        
			}
		});
		
		
		btnSearchById.setBounds(655, 11, 114, 29);
		frame.getContentPane().add(btnSearchById);
        // creating button for search by name
		JButton btnNewButton = new JButton("Search by Name");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					/**
				* here it will get the value from the text user add
				* then match it with the values in the list
				* if the value is present than it will show on the table
				*/
				
				if(textField.getText().equals("")){
		            JOptionPane.showMessageDialog(null, "Enter Last Name of student and search");
		        }
		        else
		        {
		        	
		        	if(bst == null){
		        		JOptionPane.showMessageDialog(null, "First load in BST then Search");
		        	}
		        	else
		        	{
		        		String x= textField.getText();
		        		Student s = getStudent(x);
				        
			        	
			            BSTNode node = bst.searchByName(bst.ROOT,s);
			        
			            if(node == null)
			            {
			                JOptionPane.showMessageDialog(null, "Student not found");
			            }
			            else
			            {
			                String[] courses = node.std.getCourses();
			            
			                String course1 = courses[0];
			                String course2 = courses[1];
			                String course3 = courses[2];
			                String course4 = courses[3];

			                String[] credits = node.std.getCourses();

			                String credit1 = credits[0];
			                String credit2 = credits[1];
			                String credit3 = credits[2];
			                String credit4 = credits[3];

			            
			                
			                Object[] data = {node.std.getStd_id(),node.std.getFirst_name(),node.std.getLast_name(),course1,course2,course3,course4,credit1,credit2,credit3,credit4,node.std.getTotal_credits(),node.std.getCurrent_gpa()};
			                //DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
			                model.setRowCount(0);
			                model.addRow(data);
			            }
		        	}

		        }

				
				
			}
		});
		btnNewButton.setBounds(779, 11, 143, 29);
		frame.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(521, 11, 124, 29);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterId = new JLabel("Enter ID # or Last name to Search");
		lblEnterId.setBounds(285, 11, 202, 29);
		frame.getContentPane().add(lblEnterId);
		
		JButton btnNewButton_1 = new JButton("Sort by ID#");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(bst == null){
					JOptionPane.showMessageDialog(null, "First Store in BST and Then Sort");
				}
				else
				{
				
					bstNodes = bst.printInOrder(bst.ROOT);
					
					
					model.setRowCount(0);
			        
			        
			        JOptionPane.showMessageDialog(null, "File has been Sorted. Press Ok to Display");
			        
			        
			            
			        for(BSTNode bstNode : bstNodes){
			            
			            String id = bstNode.std.getStd_id();
			            String first = bstNode.std.getFirst_name();
			            String last = bstNode.std.getLast_name();
			            
			            String[] courses = bstNode.std.getCourses();
			            String course1 = courses[0];
			            String course2 = courses[1];
			            String course3 = courses[2];
			            String course4 = courses[3];
			            
			            String[] credits = bstNode.std.getCourses();
			            String credit1 = credits[0];
			            String credit2 = credits[1];
			            String credit3 = credits[2];
			            String credit4 = credits[3];
			            
			            String[] grades = bstNode.std.getGrades();
			            String grade1 = grades[0];
			            String grade2 = grades[1];
			            String grade3 = grades[2];
			            String grade4 = grades[3];
			            
			            int total = bstNode.std.getTotal_credits();
			            double gpa = bstNode.std.getCurrent_gpa();
			            
			            //String[] col = {"ID","First Name","Last Name","Course 1","Course 2","Course 3","Course 4","Credit 1","Credit 2","Credit 3","Credit 4","Grade 1","Grade 2","Grade 3","Grade 4","Total Credits","Current gpa"};
			            Object[] data = {id,first,last,course1,course2,course3,course4,credit1,credit2,credit3,credit4,total,gpa};
			            
			            
			            model.addRow(data);
			        }
			    
					
				}
				
				
				
				
			}
		});
		btnNewButton_1.setBounds(4, 278, 133, 37);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Save Sorted records");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//list = readFile();
				
				if(bstNodes != null)
				{
					
					JOptionPane.showMessageDialog(null, "File has been sorted and saved to StudentDataSorted.txt");
		        
		            
		            int i = 1;
		            try{
		                PrintWriter writer = new PrintWriter("StudentDataSorted.txt", "UTF-8");
		                for(BSTNode bstNode : bstNodes){
		                    
		                    writer.println("Record " + i + ": ");
		                    i++;
		                    
		                    writer.println("ID: " + bstNode.std.getStd_id());
		                    writer.println("First Name: " + bstNode.std.getFirst_name());
		                    writer.println("Last Name: " + bstNode.std.getLast_name());
		                    String [] courses = bstNode.std.getCourses();
		                    writer.println("Course 1: " + courses[0]);
		                    writer.println("Course 2: " + courses[1]);
		                    writer.println("Course 3: " + courses[2]);
		                    writer.println("Course 4: " + courses[3]);
		                    
		                    int [] credits = bstNode.std.getCredits();
		                    writer.println("Credit 1: " + credits[0]);
		                    writer.println("Credit 2: " + credits[1]);
		                    writer.println("Credit 3: " + credits[2]);
		                    writer.println("Credit 4: " + credits[3]);
		                    
		                    writer.println("Total Credits: " + bstNode.std.getTotal_credits());
		                    writer.println("Current gpa: " + bstNode.std.getCurrent_gpa());
		                    
		                    writer.println("\n\n");
		                    
		                }
		            
		            
		            writer.close();
		        
		            }catch(Exception ex){
		                ex.printStackTrace();
		            }


					
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "First Sort Data by pressing sort records.");
				}
		        				
				
			}
		});
		btnNewButton_2.setBounds(184, 278, 163, 37);
		frame.getContentPane().add(btnNewButton_2);
	}
}

