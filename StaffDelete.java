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
public class StaffDelete extends JFrame implements ActionListener {
	//Panel
	JPanel StaffIDPanel = new JPanel();
	JPanel StaffDeleteButtonPanel = new JPanel();
	//Button
	JButton StaffDeleteButton = new JButton("삭제");
	JButton StaffCancelButton = new JButton("취소");
	//JTextField
	JTextField StaffIDTextField = new JTextField(5);
    StaffDAO StaffA = new StaffDAO();
    StaffDTO StaffT = new StaffDTO();
	public StaffDelete()
	{
		super("스태프 정보 삭제");

		//Label
		JLabel StaffID = new JLabel("스태프 아이디");
		


		StaffDeleteButton.addActionListener(this);
		StaffCancelButton.addActionListener(this);
		//add Component
		StaffIDPanel.add(StaffID);
		StaffIDPanel.add(StaffIDTextField);
		StaffDeleteButtonPanel.add(StaffDeleteButton);
		StaffDeleteButtonPanel.add(StaffCancelButton);
		
		add(StaffIDPanel);
		add(StaffDeleteButtonPanel);
		
		setVisible(true);
		setSize(190,150);
		setLayout(new FlowLayout());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StaffDelete SD = new StaffDelete();
		SD.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==StaffDeleteButton)
		{
			System.out.println("DElETE");
			StaffT.setStaffID(StaffIDTextField.getText());
			Connection con = null;
			PreparedStatement ps = null;
			try {
				con = StaffA.getConn();
				String sql = "delete from STAFF where STAFFID=?";
				ps = con.prepareStatement(sql);
				ps.setString(1,StaffT.getStaffID());
				
				int r = ps.executeUpdate();
				dispose();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		if(e.getSource()==StaffCancelButton)
		{
			dispose();
		}
	}

}
