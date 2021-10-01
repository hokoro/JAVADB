package Staff;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;



public class StaffDAO {

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

	   public StaffDTO getActorDTO(String id) { //회원 정보 얻어오기
		      StaffDTO dto = new StaffDTO();
		      
		      Connection con = null;
		      PreparedStatement st = null;
		      ResultSet rs = null;
		      
		      try {
		         con = getConn();
		         String sql = "select * from STAFF where STAFFID=?";
		         st = con.prepareStatement(sql);
		         st.setString(1, id);
		         
		         rs = st.executeQuery();
		         
		         if(rs.next()) {
		            dto.setStaffID(rs.getString("STAFFID"));
		            dto.setStaffName(rs.getString("STAFFNAME"));
		            dto.setStaffAge(rs.getString("STAFFAGE"));
		            dto.setStaffGender(rs.getString("STAFFGEN"));
		            dto.setStaffDepart(rs.getString("DEPART"));
		            
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
		         String sql = "select * from STAFF order by STAFFID asc";
		         ps = con.prepareStatement(sql);
		         rs = ps.executeQuery();
		         
		         while(rs.next()) {
		            String StaffID = rs.getString("STAFFID");
		            String StaffName = rs.getString("STAFFNAME");
		            String StaffAge = rs.getString("STAFFAGE");
		            String StaffGender = rs.getString("STAFFGEN");
		            String StaffDepart = rs.getString("DEPART");
		            
		            
		            Vector row = new Vector();
		            row.add(StaffID);
		            row.add(StaffName);
		            row.add(StaffAge);
		            row.add(StaffGender);
		            row.add(StaffDepart);
		            
		            	
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
