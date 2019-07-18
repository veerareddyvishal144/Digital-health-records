import java.awt.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.event.*;
public class PatientLOG extends JFrame
{
    //declaring swing components
	JFrame main=new JFrame();
	private Connection conn;
	private JLabel l_name,l_pass;
   private  JTextField t_name;
   private  JPasswordField t_pass;     //A special JTextField but hides input text
   private  JButton button,SignIn;
   JPanel k,c,p,m;
   private ImageIcon icon = new ImageIcon("mini.jpg");
   
    //reference to a inner class to handling ActionEvents
    handler handle;
 
    //reference to a separate class for processing database connection and authentication
  
 
   public PatientLOG()
    {
	   super("Login form");
	   try {
           for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
               if ("Nimbus".equals(info.getName())) {
                   javax.swing.UIManager.setLookAndFeel(info.getClassName());
                   break;
               }
           }
       } catch (ClassNotFoundException ex) {
           java.util.logging.Logger.getLogger(FindDoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (InstantiationException ex) {
           java.util.logging.Logger.getLogger(FindDoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (IllegalAccessException ex) {
           java.util.logging.Logger.getLogger(FindDoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       } catch (javax.swing.UnsupportedLookAndFeelException ex) {
           java.util.logging.Logger.getLogger(FindDoc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       }
	   main=this;
	   try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			
			JOptionPane.showMessageDialog(null,e);
		}  
	    try {
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,e);
		}
	   
         
 setLayout(new BorderLayout());
 JPanel noth=new JPanel();
 
setLayout(new GridLayout(5,1));
 
 JLabel p1,jl=new JLabel(icon);
 //add font and size it and color it
 noth.add(jl);
 Color cp=new Color(255,240,60);
 add(noth);
 p1=new JLabel("LOGIN FORM");
 p1.setFont(new Font("Times New Roman",Font.BOLD,28));
 p1.setForeground(Color.RED);
 k=new JPanel();
 k.add(p1);
 add(k);
 c=new JPanel();
       p=new JPanel(); 
       m=new JPanel(); 
      handle =new handler();
 
        c.setLayout(new FlowLayout(FlowLayout.CENTER));
        l_name=new JLabel("Username:");
        l_pass=new JLabel("Password:");
        t_name=new JTextField(24);
        t_pass=new JPasswordField(24);
        button=new JButton("Sign Up");
        SignIn=new JButton("Login");
        SignIn.setBackground(cp);
        button.setBackground(new Color(255,0,0));
        //adding actionlistener to the button
        t_pass.addActionListener(handle);
        SignIn.addActionListener(handle);
        button.addActionListener(handle);
        button.setBackground(Color.CYAN);
       
button.setFont(button.getFont().deriveFont(14.0f));
	button.setPreferredSize(new Dimension(200,60));
SignIn.setBackground(Color.CYAN);
	
	 SignIn.setFont(button.getFont().deriveFont(14.0f));
	 	SignIn.setPreferredSize(new Dimension(200,60));
        //add to contaienr
     try
     {
       
        c.add(l_name);
        c.add(t_name);
        p.add(l_pass);
        p.add(t_pass);
       m.add(SignIn);
       m.add(button);
       add(c);
       add(p);
       add(m);
       setSize(1000,1000);
      setVisible(true);
     //setResizable(false);
     //setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
     }
     catch(Exception e){JOptionPane.showMessageDialog(null,e);}
    }
    public static void main(String args[])
    {
    	
       new PatientLOG();
   
    }
 
    //an inner class for event handling
    class handler implements ActionListener
    {
        //This is triggered whenever the user clicks the login button
        public void actionPerformed(ActionEvent ae)
        {
            //checks if the button clicked
            if(ae.getSource()==SignIn||ae.getSource()==t_pass)
            {
            	
            	try
            	{
            	String query="select username,INITCAP(name),height,weight,Gender,password from pacc where username=? and password=?";
            	PreparedStatement pra=conn.prepareStatement(query);
            	pra.setString(1,t_name.getText());
            	pra.setString(2,t_pass.getText());
            	ResultSet rs=pra.executeQuery();
            	if(rs.next()==false)
            	{
            		JOptionPane.showMessageDialog(null, "Re-enter!!!","Wrong Credentials",
                            JOptionPane.ERROR_MESSAGE);
            		
            	}
            	else
            	{
            		
            		
            		
            		swing_sample in=new swing_sample(rs);
                	
                	dispose();
                	main.dispose();
            	}
            	
            	}
            	catch(Exception e){
            	System.out.println(e+"There");
            		
            		}
            }
            else
            {
            	try
            	{
            new Register();
        
            	}
            	catch(Exception e){JOptionPane.showMessageDialog(null,e);}
            	
               
        	   

        	   
            }
        }//method
 
    }//inner class
}//class
//class