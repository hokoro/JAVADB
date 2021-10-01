package Movie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;


public class MovieDAO {
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	   private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	   
	   private static final String USERID = "CHEON6";
	   private static final String USERPW = "1234";
	   
	   public Connection getConn() { //DB 연결
		      Connection con = null;
		      
		      try {
		         Class.forName(DRIVER);
		         con = DriverManager.getConnection(URL, USERID, USERPW);
		      } catch (ClassNotFoundException e ) {
		         e.printStackTrace();
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
		      
		      return con;
		   }

	   public MovieDTO getMovieDTO(String id) { //회원 정보 얻어오기
		      MovieDTO dto = new MovieDTO();
		      
		      Connection con = null;
		      PreparedStatement st = null;
		      ResultSet rs = null;
		      
		      try {
		         con = getConn();
		         String sql = "select * from MOVIE where MOVIENAME=? AND RELEASEDATE = ?";
		         st = con.prepareStatement(sql);
		         st.setString(1, id);
		         st.setString(2, id);
		         
		         rs = st.executeQuery();
		         
		         if(rs.next()) {
		            dto.setMovieName(rs.getString("MOVIENAME"));
		            dto.setMovieReleaseDate(rs.getString("RELEASEDATE"));
		            dto.setMovieRunningTime(rs.getString("RUNNINGTIME"));
		            dto.setMovieDirector(rs.getString("DIRECTORNAME"));
		            dto.setMovieCompany(rs.getString("MAKINGCOM"));
		            dto.setMovieCountry(rs.getString("MAKINGCON"));
		            dto.setMovieGenre(rs.getString("GENER"));
		         }
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
		      
		      return dto;
		   }

	   public Vector getMemberList() { //DB 정보 읽어오기 
		      Vector data = new Vector();
		      System.out.println("정상적으로 실행됨");
		      Connection con = null;
		      PreparedStatement ps = null;
		      ResultSet rs = null;
		      
		      try {
		         con = getConn();
		         String sql = "select * from MOVIE order by RELEASEDATE asc";
		         ps = con.prepareStatement(sql);
		         rs = ps.executeQuery();
		         
		         while(rs.next()) {
		            String MovieName = rs.getString("MOVIENAME");
		            String MovieReleaseDate = rs.getString("RELEASEDATE");
		            String MovieRunningTime = rs.getString("RUNNINGTIME");
		            String MovieDirector = rs.getString("DIRECTORNAME");
		            String MovieCompany = rs.getString("MAKINGCOM");
		            String MovieContury = rs.getString("MAKINGCON");
		            String MovieGenre = rs.getString("GENER");
		            
		            Vector row = new Vector();
		            row.add(MovieName);
		            row.add(MovieReleaseDate);
		            row.add(MovieRunningTime);
		            row.add(MovieDirector);
		            row.add(MovieCompany);
		            row.add(MovieContury);
		            row.add(MovieGenre);
		            	
		            data.add(row);
		         }
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
		      
		      return data;
		   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
