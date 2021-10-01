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
public class DirectorInsert extends JFrame implements ActionListener{
	//Button
	JButton DirectorInsertButton = new JButton("추가");
	JButton DirectorCancelButton = new JButton("취소");
	DirectorDTO DirectorT = new DirectorDTO();
	DirectorDAO DirectorA = new DirectorDAO();
	
	//TextField
	JTextField DirectorIDField = new JTextField(10);
	JTextField DirectorNameField = new JTextField(10);
	JTextField DirectorAgeField = new JTextField(10);
	JTextField DirectorGenderField = new JTextField(10);
	JTextField DirectorRecentMovieField = new JTextField(10);
	public DirectorInsert()
	{
		super("감독 정보 입력창");
		//Panel
		JPanel DirectorIDPanel = new JPanel();
		JPanel DirectorNamePanel = new JPanel();
		JPanel DirectorAgePanel = new JPanel();
		JPanel DirectorGenderPanel = new JPanel();
		JPanel DirectorRecentMoviePanel = new JPanel();
		JPanel DirectorInsertButtonPanel = new JPanel();
		//Label
		JLabel DirectorID = new JLabel("감독 아이디");
		JLabel DirectorName = new JLabel("이름");
		JLabel DirectorAge = new JLabel("나이");
		JLabel DirectorGender = new JLabel("성별");
		JLabel DirectorRecentMovie = new JLabel("최근 작품");
		
		DirectorInsertButton.addActionListener(this);
		DirectorCancelButton.addActionListener(this);
		

		//add component
		DirectorIDPanel.add(DirectorID);
		DirectorIDPanel.add(DirectorIDField);
		
		DirectorNamePanel.add(DirectorName);
		DirectorNamePanel.add(DirectorNameField);
		
		DirectorAgePanel.add(DirectorAge);
		DirectorAgePanel.add(DirectorAgeField);
		
		DirectorGenderPanel.add(DirectorGender);
		DirectorGenderPanel.add(DirectorGenderField);
		
		DirectorInsertButtonPanel.add(DirectorInsertButton);
		DirectorInsertButtonPanel.add(DirectorCancelButton);
		
		DirectorRecentMoviePanel.add(DirectorRecentMovie);
		DirectorRecentMoviePanel.add(DirectorRecentMovieField);
		add(DirectorIDPanel);
		add(DirectorNamePanel);
		add(DirectorAgePanel);
		add(DirectorGenderPanel);
		add(DirectorRecentMoviePanel);
		add(DirectorInsertButtonPanel);
		//setting Frame
		setSize(300,300);
		setVisible(true);
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DirectorInsert DI = new DirectorInsert();
		DI.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == DirectorCancelButton)
		{
			dispose();
		}
		if(e.getSource() == DirectorInsertButton)
		{
			System.out.println("INSERT");
			DirectorT.setDirectorID(DirectorIDField.getText());
			DirectorT.setDirectorName(DirectorNameField.getText());
			DirectorT.setDirectorAge(DirectorAgeField.getText());
			DirectorT.setDirectorGender(DirectorGenderField.getText());
			DirectorT.setDirectorRecentMovie(DirectorRecentMovieField.getText());
			
			Connection con = null;
			PreparedStatement ps = null;
			try {
				con = DirectorA.getConn();
				String sql = "insert into DIRECTOR(" + "DIRECTORID,DIRECTORNAME,DIRECTORAGE,DIRECTORGENDER,DIRECTORRECENTMOVIE)" +"values("+ "?,?,?,?,?)";
				ps = con.prepareStatement(sql);
				ps.setString(1,DirectorT.getDirectorID());
				ps.setString(2,DirectorT.getDirectorName());
				ps.setString(3,DirectorT.getDirectorAge());
				ps.setString(4,DirectorT.getDirectorGender());
				ps.setString(5,DirectorT.getDirectorRecentMovie());
				
				
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
