package Director;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;



public class DirectorDAO {
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

	   public DirectorDTO getActorDTO(String id) { //회원 정보 얻어오기
		      DirectorDTO dto = new DirectorDTO();
		      
		      Connection con = null;
		      PreparedStatement st = null;
		      ResultSet rs = null;
		      
		      try {
		         con = getConn();
		         String sql = "select * from DIRECTOR where DIRECTORID=?";
		         st = con.prepareStatement(sql);
		         st.setString(1, id);
		         
		         rs = st.executeQuery();
		         
		         if(rs.next()) {
		            dto.setDirectorID(rs.getString("DIRECTORID"));
		            dto.setDirectorName(rs.getString("DIRECTORNAME"));
		            dto.setDirectorAge(rs.getString("DIRECTORAGE"));
		            dto.setDirectorGender(rs.getString("DIRECTORGENDER"));
		            dto.setDirectorRecentMovie(rs.getString("DIRECTORRECENTMOVIE"));
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
		         String sql = "select * from DIRECTOR order by DIRECTORID asc";
		         ps = con.prepareStatement(sql);
		         rs = ps.executeQuery();
		         
		         while(rs.next()) {
		            String DirectorID = rs.getString("DIRECTORID");
		            String DirectorName = rs.getString("DIRECTORNAME");
		            String DirectorAge = rs.getString("DIRECTORAGE");
		            String DirectorGender = rs.getString("DIRECTORGENDER");
		            String DirectorRecentMovie = rs.getString("DIRECTORRECENTMOVIE");
		           
		            
		            Vector row = new Vector();
		            row.add(DirectorID);
		            row.add(DirectorName);
		            row.add(DirectorAge);
		            row.add(DirectorGender);
		      
		            row.add(DirectorRecentMovie);
		            	
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
