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
public class MovieUpdate extends JFrame implements ActionListener {
	boolean NameCheck = false;
	boolean ReleaseCheck = false;
	//Button
	JButton MovieNameCheckButton = new JButton("영화제목확인");
	JButton MovieReleaseCheckButton = new JButton("개봉날짜 확인");
	JButton MovieUpdateButton = new JButton("변경");
	JButton MovieCancelButton = new JButton("취소");
	
	MovieDAO MovieA = new MovieDAO();
	MovieDTO MovieT = new MovieDTO();
	//TextField
	JTextField MovieNameTextField = new JTextField(10);
	JTextField MovieReleaseNameTextField = new JTextField(10);
	JTextField MovieRunningTimeTextField = new JTextField(10);
	JTextField MovieDirectorTextField = new JTextField(10);
	JTextField MovieCompanyTextField = new JTextField(10);
	JTextField MovieConturyTextField = new JTextField(10);
	JTextField MovieGenreTextField = new JTextField(10);
	public MovieUpdate()
	{
		super("영화 정보 갱신창");
		//Panel
				JPanel MovieNamePanel = new JPanel();
				JPanel MovieReleasePanel = new JPanel();
				JPanel MovieRunningTimePanel = new JPanel();
				JPanel MovieDirectorPanel = new JPanel();
				JPanel MovieCompanyPanel = new JPanel();
				JPanel MovieConturyPanel = new JPanel();
				JPanel MovieGenrePanel = new JPanel();
				JPanel MovieUpdateButtonPanel = new JPanel();
				//Label
				JLabel MovieName = new JLabel("영화 제목");
				JLabel MovieRelease =new JLabel("개봉날짜");
				JLabel MovieRunningTime = new JLabel("상영 시간");
				JLabel MovieDirector = new JLabel("감독");
				JLabel MovieCompany = new JLabel("제작사");
				JLabel MovieContury = new JLabel("제작국가");
				JLabel MovieGenre = new JLabel("장르");
				
				MovieNameCheckButton.addActionListener(this);
				MovieReleaseCheckButton.addActionListener(this);
				MovieUpdateButton.addActionListener(this);
				MovieCancelButton.addActionListener(this);

				//add component
				
				MovieNamePanel.add(MovieName);
				MovieNamePanel.add(MovieNameTextField);
				MovieNamePanel.add(MovieNameCheckButton);
				
				MovieReleasePanel.add(MovieRelease);
				MovieReleasePanel.add(MovieReleaseNameTextField);
				MovieReleasePanel.add(MovieReleaseCheckButton);
				
				MovieRunningTimePanel.add(MovieRunningTime);
				MovieRunningTimePanel.add(MovieRunningTimeTextField);
				
				MovieDirectorPanel.add(MovieDirector);
				MovieDirectorPanel.add(MovieDirectorTextField);
				
				MovieCompanyPanel.add(MovieCompany);
				MovieCompanyPanel.add(MovieCompanyTextField);
				
				MovieConturyPanel.add(MovieContury);
				MovieConturyPanel.add(MovieConturyTextField);
				
				MovieGenrePanel.add(MovieGenre);
				MovieGenrePanel.add(MovieGenreTextField);
				
				MovieUpdateButtonPanel.add(MovieUpdateButton);
				MovieUpdateButtonPanel.add(MovieCancelButton);
				
				//MovieReleaseCheckButton.setEnabled(false);
				MovieUpdateButton.setEnabled(false);
				//MovieReleaseNameTextField.setEnabled(false);
				MovieRunningTimeTextField.setEnabled(false);
				MovieDirectorTextField.setEnabled(false);
				MovieCompanyTextField.setEnabled(false);
				MovieConturyTextField.setEnabled(false);
				MovieGenreTextField.setEnabled(false);
				add(MovieNamePanel);
				add(MovieReleasePanel);
				add(MovieRunningTimePanel);
				add(MovieDirectorPanel);
				add(MovieCompanyPanel);
				add(MovieConturyPanel);
				add(MovieGenrePanel);
				add(MovieUpdateButtonPanel);
				
				//Frame setting
				setVisible(true);
				setSize(320,350);
				setLayout(new FlowLayout(FlowLayout.LEFT));
			
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==MovieCancelButton)
		{
			dispose();
		}
		if(e.getSource()==MovieNameCheckButton)
		{
			System.out.println("NameCheck");
			NameCheck = true;
		}
		if(e.getSource() == MovieReleaseCheckButton)
		{
			System.out.println("ReleaseCheck");
			ReleaseCheck = true;
		}
		if(NameCheck && ReleaseCheck)
		{
			System.out.println("ALL CHECK");
	           
	           Connection con = null;
	           PreparedStatement ps = null;
	            ResultSet rs = null;

	            try {
	                con = MovieA.getConn();
	                MovieT.setMovieName(MovieNameTextField.getText());
	                MovieT.setMovieReleaseDate(MovieReleaseNameTextField.getText());
	                
	                String sql = "select MOVIENAME from MOVIE where MOVIENAME=? AND RELEASEDATE = ?";
	                
	                ps = con.prepareStatement(sql);
	                ps.setString(1, MovieT.getMovieName());
	                ps.setString(2,MovieT.getMovieReleaseDate());
	                
	                int r = ps.executeUpdate();
	                rs = ps.executeQuery();
	                if(rs.next()) {
	                 //String ActorID = rs.getString("ACTORID");
	                	MovieUpdateButton.setEnabled(true);
	                	MovieRunningTimeTextField.setEnabled(true);
	    				MovieDirectorTextField.setEnabled(true);
	    				MovieCompanyTextField.setEnabled(true);
	    				MovieConturyTextField.setEnabled(true);
	    				MovieGenreTextField.setEnabled(true);
	                }
	                
	             }catch(Exception error) {
	                error.printStackTrace();
	             }
		}

	
		if(e.getSource() == MovieUpdateButton)
		{
			Connection con = null;
	           PreparedStatement ps = null;
	           String sql;
	           
			System.out.println("UPDATE");
			try
			{
			      MovieT.setMovieName(MovieNameTextField.getText());
                  MovieT.setMovieReleaseDate(MovieReleaseNameTextField.getText());
                  MovieT.setMovieRunningTime(MovieRunningTimeTextField.getText());
                  MovieT.setMovieDirector(MovieDirectorTextField.getText());
                  MovieT.setMovieCompany(MovieCompanyTextField.getText());
                  MovieT.setMovieCountry(MovieConturyTextField.getText());
                  MovieT.setMovieGenre(MovieGenreTextField.getText());
                  
                  con = MovieA.getConn();
                  sql = "update MOVIE set RUNNINGTIME=?,DIRECTORNAME=?,MAKINGCOM=?,MAKINGCON=?,GENER=? where MOVIENAME=? AND RELEASEDATE = ?";
                   
                   ps = con.prepareStatement(sql);
                   ps.setString(1, MovieT.getMovieRunningTime());
                   ps.setString(2, MovieT.getMovieDirector());
                   ps.setString(3, MovieT.getMovieCompany());
                   ps.setString(4, MovieT.getMovieCountry());
                   ps.setString(5, MovieT.getMovieGenre());
                   ps.setString(6, MovieT.getMovieName());
                   ps.setString(7, MovieT.getMovieReleaseDate());
                   
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


