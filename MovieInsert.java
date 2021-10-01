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
public class MovieInsert extends JFrame implements ActionListener{
	//Actor Insert , cancel button
	JButton MovieInsert = new JButton("추가");
	JButton MovieCancel = new JButton("취소");
	MovieDAO MovieA = new MovieDAO();
	MovieDTO MovieT = new MovieDTO();
	//Movie textField
	JTextField MovieNameField = new JTextField(10);
	JTextField MovieReleaseField = new JTextField(10);
	JTextField MovieRunningTimeField = new JTextField(10);
	JTextField MovieDirectorField = new JTextField(10);
	JTextField MovieCompanyField = new JTextField(10);
	JTextField MovieConturyField = new JTextField(10);
    JTextField MovieGenreField = new JTextField(10);
	public MovieInsert()
	{
		super("영화 정보 입력창");
		
		//Moviepanel
				JPanel MovieNamePanel = new JPanel();
				JPanel MovieReleasePanel = new JPanel();
				JPanel MovieRunningTimePanel = new JPanel();
				JPanel MovieDirectorPanel = new JPanel();
				JPanel MovieCompanyPanel = new JPanel();
				JPanel MovieConturyPanel = new JPanel();
				JPanel MovieGenrePanel = new JPanel();
				JPanel MovieInsertButtonPanel = new JPanel();
				//Actor label
				JLabel MovieName = new JLabel("영화제목");
				JLabel MovieRelease = new JLabel("개봉날짜");
				JLabel MovieRunningTime = new JLabel("상영 시간");
				JLabel MovieDirector = new JLabel("감독");
				JLabel MovieCompany = new JLabel("제작사");
				JLabel MovieContury = new JLabel("제작국가");
				JLabel MovieGenre = new JLabel("장르");

				
				MovieInsert.addActionListener(this);
				MovieCancel.addActionListener(this);
			    
				//Insert Component
				MovieNamePanel.add(MovieName);
				MovieNamePanel.add(MovieNameField);
				
				MovieReleasePanel.add(MovieRelease);
				MovieReleasePanel.add(MovieReleaseField);
				
				MovieRunningTimePanel.add(MovieRunningTime);
				MovieRunningTimePanel.add(MovieRunningTimeField);
				
				MovieDirectorPanel.add(MovieDirector);
				MovieDirectorPanel.add(MovieDirectorField);
				
				MovieCompanyPanel.add(MovieCompany);
				MovieCompanyPanel.add(MovieCompanyField);

				MovieConturyPanel.add(MovieContury);
				MovieConturyPanel.add(MovieConturyField);
				
				MovieGenrePanel.add(MovieGenre);
				MovieGenrePanel.add(MovieGenreField);
				
				
				MovieInsertButtonPanel.add(MovieInsert);
				MovieInsertButtonPanel.add(MovieCancel);
				
				//Insert Panel
				add(MovieNamePanel);
				add(MovieReleasePanel);
				add(MovieRunningTimePanel);
				add(MovieDirectorPanel);
				add(MovieCompanyPanel);
				add(MovieConturyPanel);
				add(MovieGenrePanel );
				add(MovieInsertButtonPanel);
				setSize(300,350);
				//setExtendedState(JFrame.MAXIMIZED_BOTH);
				setVisible(true);
				setLayout(new FlowLayout(FlowLayout.LEFT));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==MovieCancel)
		{
			dispose();
		}
		if(arg0.getSource()==MovieInsert)
		{
			System.out.println("INSERT");
			MovieT.setMovieName(MovieNameField.getText());
			MovieT.setMovieReleaseDate(MovieReleaseField.getText());
			MovieT.setMovieRunningTime(MovieRunningTimeField.getText());
			MovieT.setMovieDirector(MovieDirectorField.getText());
			MovieT.setMovieCompany(MovieCompanyField.getText());
			MovieT.setMovieCountry(MovieConturyField.getText());
			MovieT.setMovieGenre(MovieGenreField.getText());
			Connection con = null;
			PreparedStatement ps = null;
			try {
				con = MovieA.getConn();
				String sql = "insert into MOVIE(" + "MOVIENAME,RELEASEDATE,RUNNINGTIME,DIRECTORNAME,MAKINGCOM,MAKINGCON,GENER)" +"values("+ "?,?,?,?,?,?,?)";
				ps = con.prepareStatement(sql);
				ps.setString(1,MovieT.getMovieName());
				ps.setString(2,MovieT.getMovieReleaseDate());
				ps.setString(3,MovieT.getMovieRunningTime());
				ps.setString(4,MovieT.getMovieDirector());
				ps.setString(5,MovieT.getMovieCompany());
				ps.setString(6,MovieT.getMovieCountry());
				ps.setString(7,MovieT.getMovieGenre());
				
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
