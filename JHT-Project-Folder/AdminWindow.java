/*Name: TAVOY GORDON
 ID#: 2102035*/

package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import domain.Staff;



public class AdminWindow extends JFrame implements ActionListener {
	
    private static final long serialVersionUID = 1L;
    private DefaultTableModel model;
	private JDesktopPane desktopPane;
	 private JTextField idField, firstNameField,lastNameField,address1Field,address2Field,parishField,telephoneField,emailField,
	 positionField,statusField,salaryField;
    Staff staff = new Staff();

    
    public AdminWindow() {
        super("Admin User Interface");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        // Create MDI desktop pane
        desktopPane = new JDesktopPane();
        getContentPane().add(desktopPane, BorderLayout.CENTER);
        
        // Create buttons
        JButton addStaffButton = new JButton("Add Staff");
        addStaffButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open AddStaffFrame
               // AddStaffFrame addStaffFrame = new AddStaffFrame();
               // desktopPane.add(addStaffFrame);
               // addStaffFrame.setVisible(true);
            	 setContentPane(desktopPane);
                AddStaffFrame();
            }
        });
        
        JButton addCustomerButton = new JButton("Add Customer");
        //  action listener for add customer button
        addCustomerButton.addActionListener(this);
        JButton payrollButton = new JButton("Payroll Management");
        //  action listener for payroll button
        payrollButton.addActionListener(this);
        JButton salaryButton = new JButton("Salary Generation");
        //  action listener for salary button
        salaryButton.addActionListener(this);
        
       
        
        // Create panel for buttons
        JPanel buttonPanel = new JPanel(new GridLayout(1, 4));
        buttonPanel.add(addStaffButton);
        buttonPanel.add(addCustomerButton); 
        buttonPanel.add(payrollButton);
        buttonPanel.add(salaryButton);
        getContentPane().add(buttonPanel, BorderLayout.NORTH);
        // add the CRUD Buttons
        
        // Add button panel to frame
        getContentPane().add(buttonPanel, BorderLayout.NORTH);
        
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
 // Frame for adding staff
    private void AddStaffFrame() {
        JInternalFrame staffFrame = new JInternalFrame("Add Staff Member", true, true, true, true);
        staffFrame.setSize(600, 400);
        staffFrame.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);

        // Create dropdown for staff type
        String[] staffTypes = {"Maintainance staff", "Contractor staff"};
        JComboBox<String> staffTypeDropdown = new JComboBox<>(staffTypes);

        // Create input components panel
        //JPanel inputPanel = new JPanel(new GridLayout (0, 2));
        
        // Create input components panel
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        addComponent(inputPanel, new JLabel("ID:"), gbc, 0, 0);
        addComponent(inputPanel, new JLabel("First Name:"), gbc, 0, 1);
        addComponent(inputPanel, new JLabel("Last Name:"), gbc, 0, 2);
        addComponent(inputPanel, new JLabel("Address 1:"), gbc, 0, 3);
        addComponent(inputPanel, new JLabel("Address 2:"), gbc, 0, 4);
        addComponent(inputPanel, new JLabel("Parish:"), gbc, 0, 5);
        addComponent(inputPanel, new JLabel("Telephone:"), gbc, 0, 6);
        addComponent(inputPanel, new JLabel("Email:"), gbc, 0, 7);
        addComponent(inputPanel, new JLabel("Position:"), gbc, 0, 8);
        addComponent(inputPanel, new JLabel("Status:"), gbc, 0, 9);
        addComponent(inputPanel, new JLabel("Salary:"), gbc, 0, 10);
        addComponent(inputPanel, new JLabel("Staff Type:"), gbc, 0, 11);
        
        addComponent(inputPanel, new JTextField(10), gbc, 1, 0);
        addComponent(inputPanel, new JTextField(10), gbc, 1, 1);
        addComponent(inputPanel, new JTextField(10), gbc, 1, 2);
        addComponent(inputPanel, new JTextField(10), gbc, 1, 3);
        addComponent(inputPanel, new JTextField(10), gbc, 1, 4);
        addComponent(inputPanel, new JTextField(10), gbc, 1, 5);
        addComponent(inputPanel, new JTextField(10), gbc, 1, 6);
        addComponent(inputPanel, new JTextField(10), gbc, 1, 7);
        addComponent(inputPanel, new JTextField(10), gbc, 1, 8);
        addComponent(inputPanel, new JTextField(10), gbc, 1, 9);
        addComponent(inputPanel, new JTextField(10), gbc, 1, 10);
        addComponent(inputPanel, staffTypeDropdown, gbc, 1, 11);
        
        // Add save button
        JButton SaveButton = new JButton("Save Button");
        SaveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Retrieve input values and save staff details
                //  save logic here
            	String id = idField.getText();
  		        String firstName = firstNameField.getText();
  		        String lastName = lastNameField.getText();
  		        String address1 = address1Field.getText();
  		        String address2 = address2Field.getText();
  		        String parish = parishField.getText();
  		        String telephone = telephoneField.getText();
  		        String email = emailField.getText();
  		        String position = positionField.getText();
  		        String status = statusField.getText();
  		        String salary = salaryField.getText();
  		      String type = (String) staffTypeDropdown.getSelectedItem();
  		        
  		      staff.SaveButton(id ,firstName,lastName,address1,address2,parish,telephone,email,position,status,salary,type);
  		
  		      	idField.setText("");
  	        	firstNameField.setText("");
  	        	lastNameField.setText("");
  	        	address1Field.setText("");
  	        	address2Field.setText("");
  	        	parishField.setText("");
  	        	telephoneField.setText("");
  	        	emailField.setText("");
  	        	positionField.setText("");
  	        	statusField.setText("");
  	        	salaryField.setText("");
  	        	staffTypeDropdown.setSelectedIndex(0);
            }
        });
        addComponent(inputPanel, SaveButton, gbc, 0, 12); // Adjust coordinates as needed

     // Add clear field button
        JButton clearButton = new JButton("Clear Button");
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Clear input fields
                Component[] components = inputPanel.getComponents();
                for (Component component : components) {
                    if (component instanceof JTextField) {
                        ((JTextField) component).setText("");
                    }
                }
            }
        });
        addComponent(inputPanel, clearButton, gbc, 1, 12); // Adjust coordinates as needed


        staffFrame.add(inputPanel);
        desktopPane.add(staffFrame);
        staffFrame.setVisible(true);
    }

    private void addComponent(JPanel panel, JComponent component, GridBagConstraints gbc, int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
        panel.add(component, gbc);
    }
    

    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AdminWindow();
                AdminWindow frame = new AdminWindow();
                frame.setVisible(true);
            }
        });
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// testing 
		

		        // Clear text fields
		   if (e.getActionCommand().equals("Delete")) {
		        String id = idField.getText();

		        // Delete data from database
		        staff.deleteStaff(id);
		        
		        idField.setText("");
		        // Clear text fields
		        
		        clearFields();
		    } 
		   
		   if (e.getActionCommand().equals("ReadAll")) {
	        	
	        	int rowCount = model.getRowCount();
	        	for (int i = rowCount - 1;i >= 0; i--) {
	        		model.removeRow(i);
	        	}
	            try {
	                String sql = "SELECT * FROM staff";
	                //create a getter for the student connection and invoke
	                PreparedStatement statement = staff.getConnection().prepareStatement(sql);
	                ResultSet resultSet = statement.executeQuery();
	                while (resultSet.next()) {
	                    //System.out.println("ID: " + resultSet.getString("ID") + ", Name: " + resultSet.getString("Name"));
	                    model.addRow(new Object[]{resultSet.getString("id"),resultSet.getString("firstName"),resultSet.getString("lastName"),resultSet.getString("address1"), resultSet.getString("address2"),resultSet.getString("parish"),resultSet.getString("telephone"),resultSet.getString("email"),resultSet.getString("position"),resultSet.getString("status"),
	                    resultSet.getString("salary")});
	                }
	            } catch (SQLException e1) {
	                e1.printStackTrace();
	            }
	            //clear all the fields
	            idField.setText("");
	        	firstNameField.setText("");
	        	lastNameField.setText("");
	        	address1Field.setText("");
	        	address2Field.setText("");
	        	parishField.setText("");
	        	telephoneField.setText("");
	        	emailField.setText("");
	        	positionField.setText("");
	        	statusField.setText("");
	        	salaryField.setText("");
	            
	        }
		}

		// Method to clear all text fields
		private void clearFields() {
			idField.setText("");
        	firstNameField.setText("");
        	lastNameField.setText("");
        	address1Field.setText("");
        	address2Field.setText("");
        	parishField.setText("");
        	telephoneField.setText("");
        	emailField.setText("");
        	positionField.setText("");
        	statusField.setText("");
        	salaryField.setText("");
		}

		
	




}



/*class AddStaffFrame extends JInternalFrame {
    private static final long serialVersionUID = 1L;
    private JTextField idField, firstNameField,lastNameField,address1Field,address2Field,parishField,telephoneField,emailField,
	 positionField,statusField,salaryField,typeField ;
    private JComboBox<String> positionComboBox;
    private JButton submitButton;

	public AddStaffFrame() {
        super("Add Staff", true, true, true, true);
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(new JLabel("id:"));
        inputPanel.add(idField);
        inputPanel.add(new JLabel("firstname:"));
        inputPanel.add(firstNameField);
        inputPanel.add(new JLabel("lastname:"));
        inputPanel.add(lastNameField);
        inputPanel.add(new JLabel("address1:"));
        inputPanel.add(address1Field);
        inputPanel.add(new JLabel("address2:"));
        inputPanel.add(address2Field);
        inputPanel.add(new JLabel("parish:"));
        inputPanel.add(parishField);
        inputPanel.add(new JLabel("telephone:"));
        inputPanel.add(telephoneField);
        inputPanel.add(new JLabel("email:"));
        inputPanel.add(emailField);
        inputPanel.add(new JLabel("position:"));
        inputPanel.add(positionField);
        inputPanel.add(new JLabel("status:"));
        inputPanel.add(statusField);
        inputPanel.add(new JLabel("salary:"));
        inputPanel.add(salaryField);
        inputPanel.add(new JLabel("staff type:"));
        inputPanel.add(typeField);
        // Create dropdown for staff type
        String[] staffTypes = {"Admin Staff", "Contractors"};
        JComboBox<String> staffTypeDropdown = new JComboBox<>(staffTypes);
        inputPanel.add(positionComboBox);
        
        
        */