package Movie;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.io.*;
import java.lang.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

import Actor.ActorDAO;
public class PanelMovie extends JPanel implements ActionListener{
			//Panel
			JPanel MovieImformationPanel = new JPanel();
			JPanel MovieTablePanel = new JPanel();
			JPanel MovieButtonPanel = new JPanel();
			
			//Button
			JButton MovieSearchButton = new JButton("검색");
			JButton MovieInsertButton = new JButton("추가");
			JButton MovieDeleteButton = new JButton("삭제");
			JButton MovieUpdateButton = new JButton("변경");
			//Table
			DefaultTableModel  MovieTableModel = new DefaultTableModel();
		    JTable MovieTable = new JTable(MovieTableModel);
		    JScrollPane Moviescroll = new JScrollPane(MovieTable);
		    public Vector MovieGetColumn()
		    {
				Vector MovieCol = new Vector();
				System.out.println("정상적으로 실행됨");
				MovieCol.add("영화 제목");
				MovieCol.add("개봉 날짜");
				MovieCol.add("상영 시간");
				MovieCol.add("감독");
				MovieCol.add("제작사");
				MovieCol.add("제작 국가");
				MovieCol.add("장르");
				return MovieCol;
		    }
	public PanelMovie()
	{
		
		
		
		//Label
		JLabel MovieImformationLabel = new JLabel("영화 정보");
		
		
		
	
	     MovieTableModel.setColumnIdentifiers(new String[] {"영화제목","개봉날짜", "상영시간", "감독 이름","제작회사","제작국가","장르"});

		
		//add component
	     MovieImformationPanel.add(MovieImformationLabel);
	     Moviescroll.setPreferredSize(new Dimension(470,250));
	     //MovieTablePanel.add(MovieTable);
	     //MovieTablePanel.add(MovieTable.getTableHeader());
		 MovieTablePanel.add(Moviescroll);
		
	     MovieButtonPanel.add(MovieSearchButton);
	     MovieButtonPanel.add(MovieInsertButton);
	     MovieButtonPanel.add(MovieDeleteButton);
	     MovieButtonPanel.add(MovieUpdateButton);
	     
	     MovieSearchButton.addActionListener(this);
	     MovieInsertButton.addActionListener(this);
	     MovieDeleteButton.addActionListener(this);
	     MovieUpdateButton.addActionListener(this);
	     
	     MovieImformationPanel.setBounds(0,80,500,0);
	  
		 MovieTablePanel.setBounds(0,100, 500, 350);
		 
		 MovieButtonPanel.setBounds(0,450, 500, 40);
	
	     add(MovieImformationPanel);
	     add(MovieTablePanel);
	     add(MovieButtonPanel);
	     setLayout(null); 
		//setting frame
		setVisible(true);
		//setBounds(0,850,300,300);
		//setLayout(new FlowLayout(FlowLayout.CENTER));
		//setLayout(new BorderLayout());
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		

	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==MovieSearchButton)
		{
			System.out.println("버튼 실행");
			MovieDAO MovieD = new MovieDAO();
			Vector MovieV;
			Vector MovieC;
			MovieV = MovieD.getMemberList();
			MovieC = MovieGetColumn();
			
			DefaultTableModel reMovieTable = new DefaultTableModel(MovieV,MovieC);
			MovieTable.setModel(reMovieTable);
			//ActorTablePanel.add(ActorTable.getTableHeader());
			MovieTablePanel.add(Moviescroll);
			add(MovieTablePanel);
		
		}
		if(arg0.getSource() == MovieInsertButton)
		{
			MovieInsert MI = new MovieInsert();
		}
		if(arg0.getSource()==MovieDeleteButton)
		{
			MovieDelete MD = new MovieDelete();
			
		}
		if(arg0.getSource() == MovieUpdateButton)
		{
			MovieUpdate MU = new MovieUpdate();
		}
	}

}
