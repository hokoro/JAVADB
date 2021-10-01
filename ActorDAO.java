package Actor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.*;
import java.lang.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

import java.sql.*;
import java.util.Vector;

public class ActorDAO {
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

	   public ActorDTO getActorDTO(String id) { //회원 정보 얻어오기
		      ActorDTO dto = new ActorDTO();
		      
		      Connection con = null;
		      PreparedStatement st = null;
		      ResultSet rs = null;
		      
		      try {
		         con = getConn();
		         String sql = "select * from ACTOR where ACTORID=?";
		         st = con.prepareStatement(sql);
		         st.setString(1, id);
		         
		         rs = st.executeQuery();
		         
		         if(rs.next()) {
		            dto.setActorID(rs.getString("ACTORID"));
		            dto.setActorName(rs.getString("ACTORNAME"));
		            dto.setActorAge(rs.getString("ACTORAGE"));
		            dto.setActorGender(rs.getString("ACTORGENDER"));
		            dto.setActorCompany(rs.getString("ACTORCOMPANY"));
		            dto.setActorBirth(rs.getString("ACTORBIRTH"));
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
		         String sql = "select * from ACTOR order by ACTORID asc";
		         ps = con.prepareStatement(sql);
		         rs = ps.executeQuery();
		         
		         while(rs.next()) {
		            String ActorID = rs.getString("ACTORID");
		            String ActorName = rs.getString("ACTORNAME");
		            String ActorAge = rs.getString("ACTORAGE");
		            String ActorGender = rs.getString("ACTORGENDER");
		            String ActorCompany = rs.getString("ACTORCOMPANY");
		            String ActorBirth = rs.getString("ACTORBIRTH");
		            
		            Vector row = new Vector();
		            row.add(ActorID);
		            row.add(ActorName);
		            row.add(ActorAge);
		            row.add(ActorGender);
		            row.add(ActorCompany);
		            row.add(ActorBirth);
		            	
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
