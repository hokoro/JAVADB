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

import Actor.ActorDAO;
import Actor.ActorDTO;
public class DirectorUpdate extends JFrame implements ActionListener{
	boolean IDCheck = false;
	//Button
	JButton DirectorIDCheckButton = new JButton("아이디 확인");
	JButton DirectorUpdateButton = new JButton("변경");
	JButton DirectorCancelButton = new JButton("취소");
	
	DirectorDAO DirectorA = new DirectorDAO();
	DirectorDTO DirectorT = new DirectorDTO();
	
	//TextField
	JTextField DirectorIDTextField = new JTextField(10);
	JTextField DirectorNameTextField = new JTextField(10);
	JTextField DirectorAgeTextField = new JTextField(10);
	JTextField DirectorGenderTextField = new JTextField(10);
	JTextField DirectorRecentMovieTextField = new JTextField(10);
	public DirectorUpdate()
	{
		super("감독 정보 수정창");
		
		//Panel
		JPanel DirectorIDPanel = new JPanel();
		JPanel DirectorNamePanel = new JPanel();
		JPanel DirectorAgePanel = new JPanel();
		JPanel DirectorGenderPanel = new JPanel();
		JPanel DirectorRecentMoviePanel = new JPanel();
		JPanel DirectorUpdateButtonPanel = new JPanel();
		//Label
		JLabel DirectorID = new JLabel("감독 아이디");
		JLabel DirectorName = new JLabel("이름");
		JLabel DirectorAge  = new JLabel("나이");
		JLabel DirectorGender = new JLabel("성별");
		JLabel DirectorRecentMovie = new JLabel("최근작품");
		
		DirectorIDCheckButton.addActionListener(this);
		DirectorUpdateButton.addActionListener(this);
		DirectorCancelButton.addActionListener(this);

        DirectorNameTextField.setEnabled(false);  
        DirectorUpdateButton.setEnabled(false); 
        DirectorAgeTextField.setEnabled(false);
		DirectorGenderTextField.setEnabled(false);
		DirectorRecentMovieTextField.setEnabled(false);
		//add component
		DirectorIDPanel.add(DirectorID);
		DirectorIDPanel.add(DirectorIDTextField);
		DirectorIDPanel.add(DirectorIDCheckButton);
		
		DirectorNamePanel.add(DirectorName);
		DirectorNamePanel.add(DirectorNameTextField);
		
		DirectorAgePanel.add(DirectorAge);
		DirectorAgePanel.add(DirectorAgeTextField);
		
		DirectorGenderPanel.add(DirectorGender);
		DirectorGenderPanel.add(DirectorGenderTextField);
		
		DirectorRecentMoviePanel.add(DirectorRecentMovie);
		DirectorRecentMoviePanel.add(DirectorRecentMovieTextField);
		
		DirectorUpdateButtonPanel.add(DirectorUpdateButton);
		DirectorUpdateButtonPanel.add(DirectorCancelButton);
	
		add(DirectorIDPanel);
		add(DirectorNamePanel);
		add(DirectorAgePanel);
		add(DirectorGenderPanel);
		add(DirectorRecentMoviePanel);
		add(DirectorUpdateButtonPanel);
		
		//setting Frame
		setVisible(true);
		setSize(320,300);
		setLayout(new FlowLayout(FlowLayout.LEFT));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DirectorUpdate DU = new DirectorUpdate();
		DU.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == DirectorIDCheckButton)
		{
			System.out.println("CHECK");
	           
	           Connection con = null;
	           PreparedStatement ps = null;
	            ResultSet rs = null;

	            try {
	                con = DirectorA.getConn();
	                DirectorT.setDirectorID(DirectorIDTextField.getText());
	                
	                String sql = "select DIRECTORID from DIRECTOR where DIRECTORID=?";
	                
	                ps = con.prepareStatement(sql);
	                ps.setString(1, DirectorT.getDirectorID());
	                
	                int r = ps.executeUpdate();
	                rs = ps.executeQuery();
	                if(rs.next()) {
	                 String DirectorID = rs.getString("DirectorID");
	                
	                IDCheck = true;
	                DirectorNameTextField.setEnabled(true);  
	                DirectorUpdateButton.setEnabled(true); 
	                DirectorAgeTextField.setEnabled(true);
	        		DirectorGenderTextField.setEnabled(true);
	        		DirectorRecentMovieTextField.setEnabled(true);
	                }
	                
	             }catch(Exception error) {
	                error.printStackTrace();
	             }
		}
		if(e.getSource() == DirectorUpdateButton)
		{
		      Connection con = null;
	           PreparedStatement ps = null;
	           String sql;
	           
			System.out.println("UPDATE");
			if(IDCheck == true)
			{
				try
				{
				      DirectorT.setDirectorID(DirectorIDTextField.getText());
	                  DirectorT.setDirectorName(DirectorNameTextField.getText());
	                  DirectorT.setDirectorAge(DirectorAgeTextField.getText());
	                  DirectorT.setDirectorGender(DirectorGenderTextField.getText());
	                  DirectorT.setDirectorRecentMovie(DirectorRecentMovieTextField.getText());
	                  
	                  
	                  con = DirectorA.getConn();
	                  sql = "update DIRECTOR set DIRECTORNAME=?,DIRECTORAGE = ?,DIRECTORGENDER=?,DIRECTORRECENTMOVIE=? where DIRECTORID=?";
	                   
	                   ps = con.prepareStatement(sql);
	                   ps.setString(1, DirectorT.getDirectorName());
	                   ps.setString(2, DirectorT.getDirectorAge());
	                   ps.setString(3, DirectorT.getDirectorGender());
	                   ps.setString(4, DirectorT.getDirectorRecentMovie());
	                   ps.setString(5, DirectorT.getDirectorID());
	                   
	                   int r = ps.executeUpdate();
	                   dispose();
				}
				catch(Exception error )
				{
					error.printStackTrace();
				}
			}
			else
			{
				dispose();
			}
		}
		if(e.getSource() == DirectorCancelButton)
		{
			dispose();
		}
	}

}
