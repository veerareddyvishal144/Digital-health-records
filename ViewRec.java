/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author govardhan
 */
import java.sql.*;

import javax.swing.*;

import java.awt.event.*;

import javax.swing.table.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author govardhan
 */
public class ViewRec extends javax.swing.JFrame {
	 // Variables declaration - do not modify
	private Connection conn;
    private javax.swing.JButton Close_Butt;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration      
    /**
     * Creates new form ViewRec
     */
private String uname;
	 public ViewRec(String ra) {
		 this.uname=ra;
	        initComponents();
	        setVisible(true);
	        load();
	    }

    public ViewRec() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Close_Butt = new javax.swing.JButton();
        jTable1.setEnabled(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        	
       setPreferredSize(new java.awt.Dimension(700, 400));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setBackground(new java.awt.Color(0, 204, 204));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Date", "DoctorName", "Problem", "Precription"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
        );

        Close_Butt.setBackground(new java.awt.Color(0, 0, 0));
        Close_Butt.setFont(new java.awt.Font("Sitka Heading", 3, 24)); // NOI18N
        Close_Butt.setForeground(new java.awt.Color(255, 255, 255));
        Close_Butt.setText("X");
        Close_Butt.setContentAreaFilled(false);
        Close_Butt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Close_Butt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Close_ButtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Close_Butt, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Close_Butt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(83, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    
    }// </editor-fold>
    public void load()
    {
    	
    	 try {
 			Class.forName("oracle.jdbc.driver.OracleDriver");
 		} catch (ClassNotFoundException e) {
 			
 			e.printStackTrace();
 		}  
 	    try {
 			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
    	PreparedStatement pra1;
		String query1="select today,doc_name,problem,prescription from pdata where username=? order by today";
		
		
    	try
    	{
    		pra1=conn.prepareStatement(query1);
    		pra1.setString(1,uname);
    		ResultSet ra=pra1.executeQuery();
    		
        	DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        	dtm.setRowCount(0);	
    	int col=ra.getMetaData().getColumnCount();
    	while(ra.next())
    	{
    		Object[] rows=new Object[col];
    		for(int i=1;i<=col;i++)
    		{
    			rows[i-1]=ra.getObject(i);
    		}
    	
    	dtm.insertRow(ra.getRow()-1,rows);
    	}
    	}
    	catch(SQLException e){e.printStackTrace();}
    }

    private void Close_ButtActionPerformed(java.awt.event.ActionEvent evt) {                                           
        dispose();
    }                                          

    /**
     * @param args the command line arguments
     */
    

                
}

