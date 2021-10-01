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
public class StaffInsert extends JFrame implements ActionListener{
	//TextField
	JTextField StaffIDField = new JTextField(10);
	JTextField StaffNameField = new JTextField(10);
	JTextField StaffAgeField = new JTextField(10);
	JTextField StaffGenderField = new JTextField(10);
	JTextField StaffDepartField = new JTextField(10);
	//Button
	JButton StaffInsertButton = new JButton("추가");
	JButton StaffCancelButton = new JButton("취소");
	StaffDAO StaffA = new StaffDAO();
	StaffDTO StaffT = new StaffDTO();
	public StaffInsert() {
		//panel
		JPanel StaffIDPanel = new JPanel();
		JPanel StaffNamePanel = new JPanel();
		JPanel StaffAgePanel = new JPanel();
		JPanel StaffGenderPanel = new JPanel();
		JPanel StaffDepartPanel = new JPanel();
		JPanel StaffInsertButtonPanel = new JPanel();
		//Label
		JLabel StaffID = new JLabel("스태프 아이디");
		JLabel StaffName = new JLabel("이름");
		JLabel StaffAge = new JLabel("나이");
		JLabel StaffGender = new JLabel("성별");
		JLabel StaffDepart = new JLabel("부서");

		StaffInsertButton.addActionListener(this);
		StaffCancelButton.addActionListener(this);
		
		//addComponet
		StaffIDPanel.add(StaffID);
		StaffIDPanel.add(StaffIDField);
		
		StaffNamePanel.add(StaffName);
		StaffNamePanel.add(StaffNameField);
		
		StaffAgePanel.add(StaffAge);
		StaffAgePanel.add(StaffAgeField);
		
		StaffGenderPanel.add(StaffGender);
		StaffGenderPanel.add(StaffGenderField);
		
		StaffDepartPanel.add(StaffDepart);
		StaffDepartPanel.add(StaffDepartField);
		
		StaffInsertButtonPanel.add(StaffInsertButton);
		StaffInsertButtonPanel.add(StaffCancelButton);
		
		add(StaffIDPanel);
		add(StaffNamePanel);
		add(StaffAgePanel);
		add(StaffGenderPanel);
		add(StaffDepartPanel);
		add(StaffInsertButtonPanel);
		
		setSize(300,350);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
		setLayout(new FlowLayout(FlowLayout.LEFT));
	}
	public static void main(String[] args) {

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == StaffInsertButton)
		{
			System.out.println("INSERT");
			StaffT.setStaffID(StaffIDField.getText());
			StaffT.setStaffName(StaffNameField.getText());
			StaffT.setStaffAge(StaffAgeField.getText());
			StaffT.setStaffGender(StaffGenderField.getText());
			StaffT.setStaffDepart(StaffDepartField.getText());
			
			Connection con = null;
			PreparedStatement ps = null;
			try {
				con = StaffA.getConn();
				String sql = "insert into STAFF(" + "STAFFID,STAFFNAME,STAFFAGE,STAFFGEN,DEPART)" +"values("+ "?,?,?,?,?)";
				ps = con.prepareStatement(sql);
				ps.setString(1,StaffT.getStaffID());
				ps.setString(2,StaffT.getStaffName());
				ps.setString(3,StaffT.getStaffAge());
				ps.setString(4,StaffT.getStaffGender());
				ps.setString(5,StaffT.getStaffDepart());
				
				
				int r = ps.executeUpdate();
				dispose();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		if(e.getSource()== StaffCancelButton)
		{
			dispose();
		}
	}

}
