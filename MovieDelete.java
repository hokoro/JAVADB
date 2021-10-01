package Movie;
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
public class MovieDelete extends JFrame implements ActionListener{
	//TextField
	JTextField MovieNameTextField = new JTextField(10);
	JTextField MovieDateTextField = new JTextField(10);
	//Button
	JButton MovieDeleteButton = new JButton("삭제");
	JButton MovieCancelButton = new JButton("취소");
	MovieDAO MovieA = new MovieDAO();
	MovieDTO MovieT = new MovieDTO();
	public MovieDelete()
	{
		super("영화 정보 삭제창");
		//Panel
		//Panel
		JPanel MovieNamePanel = new JPanel();
		JPanel MovieDatePanel = new JPanel();
		JPanel MovieDeleteButtonPanel = new JPanel();
		
		//Label
		JLabel MovieName = new JLabel("영화 제목");
		JLabel MovieDate = new JLabel("개봉 날짜");

		MovieDeleteButton.addActionListener(this);
		MovieCancelButton.addActionListener(this);
		//add component
		MovieNamePanel.add(MovieName);
		MovieNamePanel.add(MovieNameTextField);
		
		MovieDatePanel.add(MovieDate);
		MovieDatePanel.add(MovieDateTextField);
		
		MovieDeleteButtonPanel.add(MovieDeleteButton);
		MovieDeleteButtonPanel.add(MovieCancelButton);
		
		add(MovieNamePanel);
		add(MovieDatePanel);
		add(MovieDeleteButtonPanel);
		setVisible(true);
		setSize(190,150);
		setLayout(new FlowLayout());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MovieDelete MD = new MovieDelete();
		MD.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == MovieCancelButton)
		{
			dispose();
		}
		
		if(arg0.getSource()==MovieDeleteButton)
		{
			System.out.println("DElETE");
			MovieT.setMovieName(MovieNameTextField.getText());
			MovieT.setMovieReleaseDate(MovieDateTextField.getText());
			Connection con = null;
			PreparedStatement ps = null;
			try {
				con = MovieA.getConn();
				String sql = "delete from MOVIE where MOVIENAME=? AND RELEASEDATE = ?";
				ps = con.prepareStatement(sql);
				ps.setString(1,MovieT.getMovieName());
				ps.setString(2,MovieT.getMovieReleaseDate());
				
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




