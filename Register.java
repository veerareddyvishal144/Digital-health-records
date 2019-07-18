import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import java.sql.*;

public class Register extends JFrame
{
	 private Connection con;
	  
	   
    //declaring swing components
	   private JLabel l_name,l_pass,l_user,l_ht,l_wt,l_gender;
	   private    JTextField t_name,t_ht,t_user,t_wt;
	   private JRadioButton male,female;
	   private ButtonGroup Gender; 
	   private   JPasswordField t_pass;     //A special JTextField but hides input text
	   private    JButton button;
	   private   JPanel []c;
 
    //reference to a inner class to handling ActionEvents
    handler handle;
 
    //reference to a separate class for processing database connection and authentication
  
 
 public   Register()
    {
	 
        super("Register");
 setLayout(new GridLayout(7,1));
        c=new JPanel[13];
        for(int i=0;i<13;i++)
        {
        	c[i]=new JPanel();
        c[i].setLayout(new FlowLayout(FlowLayout.CENTER));
        c[i].setBackground(Color.WHITE);
        }
      
       handle =new handler();
 
                //swing components
        l_name=new JLabel("Name:");
        l_pass=new JLabel("Password:");
        l_user=new JLabel("User Name:");
        l_ht=new JLabel("Height:");
        l_wt=new JLabel("Weight:");
        l_gender=new JLabel("Gender:");
        male=new JRadioButton("Male",true);
        female=new JRadioButton("Female");
        Gender=new ButtonGroup();
        Gender.add(male); 
        Gender.add(female);
        t_name=new JTextField(10);
       t_user=new JTextField(10);
        t_ht=new JTextField(10);
       t_wt=new JTextField(10);
        t_pass=new JPasswordField(10);
        button=new JButton("Register");
        button.setBackground(Color.GREEN);
        
button.setFont(button.getFont().deriveFont(14.0f));
	button.setPreferredSize(new Dimension(200,60));
        //adding actionlistener to the button
        button.addActionListener(handle);
        
        
      setBackground(Color.BLACK);
        //add to contaienr
        c[0].add(l_name);
        c[1].add(t_name);
        c[2].add(l_pass);
        c[3].add(t_pass);
       c[4].add(l_user);
       c[5].add(t_user);
       c[6].add(l_gender);
       c[7].add(male);
       c[7].add(female);
        c[8].add(l_ht);
        c[9].add(t_ht);
        c[10].add(l_wt);
        c[11].add(t_wt);
        c[12].add(button);
        for(int i=0;i<13;i++)
        {
        	add(c[i]);
        }
        //visual
        setVisible(true);
        setSize(1000,1000);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //setResizable(false);
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
    try {
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   
    }
 
    //an inner class for event handling
    class handler implements ActionListener
    {
    
        //This is triggered whenever the user clicks the login button
        public void actionPerformed(ActionEvent ae)
        {
        	boolean m =true;
        	if(female.isSelected())
        	{
        		m=false;
        	}
        	int s=1;
        	try
        	{
        	if(t_name.getText().length()==0||t_user.getText().length()==0||t_pass.getText().length()==0||t_ht.getText().length()==0||t_wt.getText().length()==0){
        		JOptionPane.showMessageDialog(null, "Registration failed!","Please Fill All the fields",
                        JOptionPane.ERROR_MESSAGE);
        	s=0;
        	}
        	
        	
        	
        	}
        	catch(NumberFormatException e){
        		
        		
        		JOptionPane.showMessageDialog(null, "Failed!!!","Registration Failed",
                        JOptionPane.ERROR_MESSAGE);
        		
        		
        	}
        	if(s!=0)
        	{
            //checks if the button clicked
           
            	
            	try {
                
                
                		 
                String query = "insert into pacc values(?,?,?,?,?,?)";

                      // create the mysql insert preparedstatement
                      PreparedStatement preparedStmt = con.prepareStatement(query);
                      preparedStmt.setString(1, t_user.getText());
                      preparedStmt.setString(2, t_name.getText());
                      preparedStmt.setString(3, t_pass.getText());
                      preparedStmt.setInt(4, Integer.parseInt(t_ht.getText()));
                      preparedStmt.setInt(5, Integer.parseInt(t_wt.getText()));
                      if(m)
                      preparedStmt.setString(6,"M");
                      else
                    	  preparedStmt.setString(6,"F");
                      

                      // execute the preparedstatement
                      preparedStmt.executeUpdate();
                     
               
             
    JOptionPane.showMessageDialog(null, "Your login id,password are  "+t_user.getText()+"  "+t_pass.getText(),"Success",JOptionPane.INFORMATION_MESSAGE);
               
                new PatientLOG();
            	dispose();
            	con.close();
            	} 
            catch (SQLException insertException) {
            	System.out.println(insertException);
            	
            	insertException.printStackTrace();
            	  JOptionPane.showMessageDialog(null, "Registration failed!","Failed!! change user name",
                          JOptionPane.ERROR_MESSAGE);
        		  }
            
             
         
            }
               
            	
            }//if
        }}//method
 
   
