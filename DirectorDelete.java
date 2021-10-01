package Director;
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
public class DirectorDelete extends JFrame implements ActionListener {
	//Button
	JButton DirectorDeleteButton = new JButton("삭제");
	JButton DirectorCancelButton = new JButton("취소");
	DirectorDAO DirectorA = new DirectorDAO();
	DirectorDTO DirectorT = new DirectorDTO();
	
	//TextField
	JTextField DirectorIDTextField = new JTextField(5);
	public DirectorDelete()
	{
		super("감독 삭제 창");
		//Panel
		JPanel DirectorIDPanel = new JPanel();
		JPanel DirectorDeleteButtonPanel = new JPanel();
		
		//Label
		JLabel DirectorID = new JLabel("감독 아이디");
		

		DirectorDeleteButton.addActionListener(this);
		DirectorCancelButton.addActionListener(this);
		
		//add component
		DirectorIDPanel.add(DirectorID);
		DirectorIDPanel.add(DirectorIDTextField);
		
		DirectorDeleteButtonPanel.add(DirectorDeleteButton);
		DirectorDeleteButtonPanel.add(DirectorCancelButton);
		
		add(DirectorIDPanel);
		add(DirectorDeleteButtonPanel);
		//Frame setting
		setSize(160,140);
		setLayout(new FlowLayout());
		setVisible(true);
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DirectorDelete DD = new DirectorDelete();
		DD.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == DirectorCancelButton)
		{
			dispose();
		}
		if(e.getSource() == DirectorDeleteButton)
		{
			System.out.println("DElETE");
			DirectorT.setDirectorID(DirectorIDTextField.getText());
			Connection con = null;
			PreparedStatement ps = null;
			try {
				con = DirectorA.getConn();
				String sql = "delete from DIRECTOR where DIRECTORID=?";
				ps = con.prepareStatement(sql);
				ps.setString(1,DirectorT.getDirectorID());
				
				int r = ps.executeUpdate();
				dispose();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}

}
