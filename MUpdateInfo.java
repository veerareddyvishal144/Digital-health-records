import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
public class MUpdateInfo extends JFrame {

	 private Connection con;
	   private PreparedStatement pst;
	   private ResultSet rs;
  //declaring swing components
	   private JLabel l_name,l_pass;
	   private    JTextField t_name;
	 private   JPasswordField t_pass;     //A special JTextField but hides input text
	private JFrame ind;
	   private    JButton button;
	   private   JPanel []c;

  //reference to a inner class to handling ActionEvents
  handler handle;

  //reference to a separate class for processing database connection and authentication


public   MUpdateInfo(ResultSet ps,JFrame id)
  {
	 
      super("MUpdate-form");
      ind=id;
      rs=ps;
setLayout(new GridLayout(5,1));
      c=new JPanel[9];
      for(int i=0;i<9;i++)
      {
      	c[i]=new JPanel();
      c[i].setLayout(new FlowLayout(FlowLayout.CENTER));
      c[i].setBackground(Color.WHITE);
      }
    
     handle =new handler();

              //swing components
      l_name=new JLabel("Name:");
      l_pass=new JLabel("Password:");
   //  l_ht=new JLabel("Height:");
     // l_wt=new JLabel("Weight:");
      t_name=new JTextField(10);
     //t_ht=new JTextField(10);
     //t_wt=new JTextField(10);
      t_pass=new JPasswordField(10);
      button=new JButton("Update");
      button.setBackground(Color.GREEN);
     //add contents to fields
      try
      {
      t_name.setText(rs.getString(2));
      t_pass.setText(rs.getString(6));
    // t_ht.setText(rs.getString(3));
     //t_wt.setText(rs.getString(4));
      }
      catch(SQLException sql)
      {
    	  System.out.println("Table error"+"\t"+sql);
      }
      //adding actionlistener to the button
      button.addActionListener(handle);
     setBackground(Color.BLACK);
      //add to contaienr
      c[0].add(l_name);
      c[1].add(t_name);
      c[2].add(l_pass);
      c[3].add(t_pass);
   /*  c[4].add(l_ht);
      c[5].add(t_ht);
      c[6].add(l_wt);
      c[7].add(t_wt);*/
      c[4].add(button);
      for(int i=0;i<5;i++)
      {
      	add(c[i]);
      }
      //visual
      setVisible(true);
      setSize(1000,1000);
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      setResizable(false);
      setExtendedState(JFrame.MAXIMIZED_BOTH);
      
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
      	
      	int s=1;
      	try
      	{
      	if(t_name.getText().length()==0||t_pass.getText().length()==0){
      		JOptionPane.showMessageDialog(null, "Update failed!","Please Fill in All the fields",
                      JOptionPane.ERROR_MESSAGE);
      	s=0;
      	}
      	
      	
      	}
      	catch(NumberFormatException e){
      		
      		
      		JOptionPane.showMessageDialog(null, "Failed!!!","Enter numbers into ht and wt ",
                      JOptionPane.ERROR_MESSAGE);
      		
      		
      	}
      	if(s!=0)
      	{
          //checks if the button clicked
         
          	
          	try {
              
              
              		 
              String query = "update macc set mname=?,mpassword=? where musername=? ";

                    // create the mysql insert preparedstatement
                    PreparedStatement preparedStmt = con.prepareStatement(query);
                   
                    
                    preparedStmt.setString (1, t_name.getText());
                   preparedStmt.setString(2, t_pass.getText());
                   // preparedStmt.setFloat    (3, Float.parseFloat(t_ht.getText()));
                    //preparedStmt.setFloat    (4, Float.parseFloat(t_wt.getText()));
                  preparedStmt.setString(3,rs.getString(1));
                  int a=JOptionPane.showConfirmDialog(null,"Are you sure?");  
 				 if(a==JOptionPane.YES_OPTION){  
 				   
 					// execute the preparedstatement
 					 preparedStmt.executeUpdate();
 		             
 		           
 					  JOptionPane.showMessageDialog(null, "You have updated your data  "+"Please Log-In again","Success",JOptionPane.INFORMATION_MESSAGE);
 					             
 					 dispose();
 					 
 					ind.dispose();
 					 new MedicalLOG();
 					 }
 				
 				 else if(a==JOptionPane.CANCEL_OPTION)
 				 {
 					 dispose();
 				 }
 				 
 				 else
 				 {
 					 throw new SQLException();
 				 }
                    
                    
              
          	
          	} 
          catch (SQLException sql1) {
        	  
          	  JOptionPane.showMessageDialog(null, "Update failed!","Failed!! Try again",
                        JOptionPane.ERROR_MESSAGE);
      		  }
          
           
       
          }
             
          	
          }//if
      }}//method

 	

