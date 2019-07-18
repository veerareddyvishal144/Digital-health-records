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
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
public class FindDoc extends javax.swing.JFrame {

    /**
     * Creates new form FindDoc
     */
	// Variables declaration - do not modify  
	private Connection conn;
    private JButton Find;
    private javax.swing.JLabel Location;
    private javax.swing.JPanel Result_panel;
    private javax.swing.JLabel Specialist;
    private javax.swing.JLabel Title_lab;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField loc_tf;
    private javax.swing.JPanel search_panel;
    private javax.swing.JTextField spec_tf;
    // End of variables declaration            
    public FindDoc() {
        initComponents();
        setTitle("DocFinder");
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        Result_panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        search_panel = new javax.swing.JPanel();
        Specialist = new javax.swing.JLabel();
        Location = new javax.swing.JLabel();
        Find = new javax.swing.JButton();
        Title_lab = new javax.swing.JLabel();
        spec_tf = new javax.swing.JTextField();
        loc_tf = new javax.swing.JTextField();
        jTable1.setEnabled(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Result_panel.setBackground(new java.awt.Color(140, 240, 240));
        Result_panel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Specialisation", "Gender", "ClinicName", "ClinicAddress", "Experience", "Rating", "Location"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout Result_panelLayout = new javax.swing.GroupLayout(Result_panel);
        Result_panel.setLayout(Result_panelLayout);
        Result_panelLayout.setHorizontalGroup(
            Result_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Result_panelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 339, Short.MAX_VALUE))
        );
        Result_panelLayout.setVerticalGroup(
            Result_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Result_panelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1037, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        search_panel.setBackground(new java.awt.Color(51, 222, 65));
        search_panel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        Specialist.setFont(new java.awt.Font("SansSerif", 3, 14)); // NOI18N
        Specialist.setForeground(new java.awt.Color(51, 0, 255));
        Specialist.setLabelFor(spec_tf);
        Specialist.setText("Specialist:");

        Location.setBackground(new java.awt.Color(255, 0, 153));
        Location.setFont(new java.awt.Font("SansSerif", 3, 14)); // NOI18N
        Location.setForeground(new java.awt.Color(0, 0, 255));
        Location.setText("Location:");

        Find.setBackground(new java.awt.Color(255, 102, 51));
        Find.setFont(new java.awt.Font("Trebuchet MS", 2, 12)); // NOI18N
        Find.setForeground(new java.awt.Color(0, 0, 51));
        Find.setText("Find");
        Find.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FindActionPerformed(evt);
            }
        });

        Title_lab.setBackground(new java.awt.Color(255, 51, 153));
        Title_lab.setFont(new java.awt.Font("Copperplate Gothic Bold", 3, 24)); // NOI18N
        Title_lab.setForeground(new java.awt.Color(255, 255, 0));
        Title_lab.setText("        DOC_FINDER");

        javax.swing.GroupLayout search_panelLayout = new javax.swing.GroupLayout(search_panel);
        search_panel.setLayout(search_panelLayout);
        search_panelLayout.setHorizontalGroup(
            search_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(search_panelLayout.createSequentialGroup()
                .addGroup(search_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Location, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Specialist, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(search_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(spec_tf)
                    .addComponent(loc_tf, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(search_panelLayout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(Find, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, search_panelLayout.createSequentialGroup()
                .addComponent(Title_lab, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                .addContainerGap())
        );
        search_panelLayout.setVerticalGroup(
            search_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(search_panelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(Title_lab, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101)
                .addGroup(search_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Specialist, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spec_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(search_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Location)
                    .addComponent(loc_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81)
                .addComponent(Find, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(606, 606, 606))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(search_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Result_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(search_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Result_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void FindActionPerformed(java.awt.event.ActionEvent evt) {                                     
    	try {
    		Class.forName("oracle.jdbc.driver.OracleDriver");
    	} catch (ClassNotFoundException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}  
        try {
    		conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
    	} catch (SQLException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
        
        
        PreparedStatement pra1;
		String query1="select name,specialisation,gender,clinic_name,clinic_address,experience,rating,location from dacc where location=? or specialisation=?";
		
		
    	try
    	{
    		pra1=conn.prepareStatement(query1);
    		pra1.setString(1,(loc_tf.getText()).toLowerCase());
    		pra1.setString(2, spec_tf.getText().toLowerCase());
    		ResultSet ra=pra1.executeQuery();
    		
        	DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        	dtm.setRowCount(0);	
    	int col=ra.getMetaData().getColumnCount();
    
    int l=0;
    	while(ra.next())
    	{
    		l++;
    		Object[] rows=new Object[col];
    		for(int i=1;i<=col;i++)
    		{
    			rows[i-1]=ra.getObject(i);
    		}
    	
    	dtm.insertRow(ra.getRow()-1,rows);
    	}
    	if(l==0){JOptionPane.showMessageDialog(this,"No Results Match Your Query");
		return ;
		}
    	}
    	catch(SQLException e){e.printStackTrace();}
        
        
        
    }                                    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
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
        //</editor-fold>

        /* Create and display the form */
        
    }

           
}