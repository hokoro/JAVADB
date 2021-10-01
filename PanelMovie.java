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
			JButton MovieSearchButton = new JButton("�˻�");
			JButton MovieInsertButton = new JButton("�߰�");
			JButton MovieDeleteButton = new JButton("����");
			JButton MovieUpdateButton = new JButton("����");
			//Table
			DefaultTableModel  MovieTableModel = new DefaultTableModel();
		    JTable MovieTable = new JTable(MovieTableModel);
		    JScrollPane Moviescroll = new JScrollPane(MovieTable);
		    public Vector MovieGetColumn()
		    {
				Vector MovieCol = new Vector();
				System.out.println("���������� �����");
				MovieCol.add("��ȭ ����");
				MovieCol.add("���� ��¥");
				MovieCol.add("�� �ð�");
				MovieCol.add("����");
				MovieCol.add("���ۻ�");
				MovieCol.add("���� ����");
				MovieCol.add("�帣");
				return MovieCol;
		    }
	public PanelMovie()
	{
		
		
		
		//Label
		JLabel MovieImformationLabel = new JLabel("��ȭ ����");
		
		
		
	
	     MovieTableModel.setColumnIdentifiers(new String[] {"��ȭ����","������¥", "�󿵽ð�", "���� �̸�","����ȸ��","���۱���","�帣"});

		
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
			System.out.println("��ư ����");
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
