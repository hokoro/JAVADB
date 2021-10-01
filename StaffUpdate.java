package Staff;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.lang.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

public class StaffUpdate extends JFrame implements ActionListener{
	
	//TextField
	JTextField StaffIDField = new JTextField(10);
	JTextField StaffNameField = new JTextField(10);
	JTextField StaffAgeField = new JTextField(10);
	JTextField StaffGenderField = new JTextField(10);
	JTextField StaffDepartField = new JTextField(10);
	//Button
	JButton StaffIDCheckButton = new JButton("확인");
	JButton StaffUpdateButton = new JButton("변경");
	JButton StaffCancelButton = new JButton("취소");
	
	StaffDAO StaffA = new StaffDAO();
	StaffDTO StaffT = new StaffDTO();
	
	public StaffUpdate()
	{
	//panel
			JPanel StaffIDPanel = new JPanel();
			JPanel StaffNamePanel = new JPanel();
			JPanel StaffAgePanel = new JPanel();
			JPanel StaffGenderPanel = new JPanel();
			JPanel StaffDepartPanel = new JPanel();
			JPanel StaffIUpdateButtonPanel = new JPanel();
			//Label
			JLabel StaffID = new JLabel("스태프 아이디");
			JLabel StaffName = new JLabel("이름");
			JLabel StaffAge = new JLabel("나이");
			JLabel StaffGender = new JLabel("성별");
			JLabel StaffDepart = new JLabel("부서");
			
			StaffIDCheckButton.addActionListener(this);
			StaffUpdateButton.addActionListener(this);
			StaffCancelButton.addActionListener(this);
			
			//addComponet
			StaffIDPanel.add(StaffID);
			StaffIDPanel.add(StaffIDField);
			StaffIDPanel.add(StaffIDCheckButton);
			
			StaffNamePanel.add(StaffName);
			StaffNamePanel.add(StaffNameField);
			
			StaffAgePanel.add(StaffAge);
			StaffAgePanel.add(StaffAgeField);
			
			StaffGenderPanel.add(StaffGender);
			StaffGenderPanel.add(StaffGenderField);
			
			StaffDepartPanel.add(StaffDepart);
			StaffDepartPanel.add(StaffDepartField);
			
			StaffIUpdateButtonPanel.add(StaffUpdateButton);
			StaffIUpdateButtonPanel.add(StaffCancelButton);
			
			//StaffName.setEnabled(false);
			StaffNameField.setEnabled(false);
			
			//StaffAge.setEnabled(false);
			StaffAgeField.setEnabled(false);
			//StaffGender.setEnabled(false);
			StaffGenderField.setEnabled(false);
			StaffUpdateButton.setEnabled(false);
			//StaffDepart.setEnabled(false);
			StaffDepartField.setEnabled(false);
			
			add(StaffIDPanel);
			add(StaffNamePanel);
			add(StaffAgePanel);
			add(StaffGenderPanel);
			add(StaffDepartPanel);
			add(StaffIUpdateButtonPanel);
			
			setSize(300,280);
			//setExtendedState(JFrame.MAXIMIZED_BOTH);
			setVisible(true);
			setLayout(new FlowLayout(FlowLayout.LEFT));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StaffUpdate SU = new StaffUpdate();
		SU.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==StaffCancelButton)
		{
			dispose();
		}
		if(e.getSource()==StaffIDCheckButton)
		{
			System.out.println("CHECK");
	           
	           Connection con = null;
	           PreparedStatement ps = null;
	            ResultSet rs = null;

	            try {
	                con = StaffA.getConn();
	                  StaffT.setStaffID(StaffIDField.getText());
	                
	                String sql = "select STAFFID from STAFF where STAFFID=?";
	                
	                ps = con.prepareStatement(sql);
	                ps.setString(1, StaffT.getStaffID());
	                
	                int r = ps.executeUpdate();
	                rs = ps.executeQuery();
	                if(rs.next()) {
	                 //String ActorID = rs.getString("ACTORID");
	        			
	        			StaffNameField.setEnabled(true);
	        			StaffAgeField.setEnabled(true);
	        			StaffGenderField.setEnabled(true);
	        			StaffDepartField.setEnabled(true);
	                	StaffUpdateButton.setEnabled(true);
	                }
	                
	             }catch(Exception error) {
	                error.printStackTrace();
	             }

			}
		
		if(e.getSource()==StaffUpdateButton)
		{
		Connection con = null;
        PreparedStatement ps = null;
        String sql;
        
		System.out.println("UPDATE");
		try
		{
		StaffT.setStaffID(StaffIDField.getText());
        StaffT.setStaffName(StaffNameField.getText());
        StaffT.setStaffAge(StaffAgeField.getText());
        StaffT.setStaffGender(StaffGenderField.getText());
        StaffT.setStaffDepart(StaffDepartField.getText());
        
        
        con = StaffA.getConn();
        sql = "update STAFF set STAFFNAME=?,STAFFAGE = ?,STAFFGEN=?,DEPART=? where STAFFID=?";
         
         ps = con.prepareStatement(sql);
         ps.setString(1, StaffT.getStaffName());
         ps.setString(2, StaffT.getStaffAge());
         ps.setString(3, StaffT.getStaffGender());
         ps.setString(4, StaffT.getStaffDepart());
         ps.setString(5, StaffT.getStaffID());
         
         
         int r = ps.executeUpdate();
         dispose();
	}
	catch(Exception error )
	{
		error.printStackTrace();
	}
		}
	}

}
