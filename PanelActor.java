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
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import java.util.*;
public class PanelActor extends JPanel implements ActionListener{
	//panel
	JPanel ActorImformationPanel = new JPanel();
	JPanel ActorTablePanel = new JPanel();
	JPanel ActorButtonPanel = new JPanel();
	
	//Button
			JButton ActorSearchButton = new JButton("검색");
			JButton ActorInsertButton = new JButton("추가");
			JButton ActorDeleteButton = new JButton("삭제");
			JButton ActorUpdateButton = new JButton("변경");
			DefaultTableModel  ActorTableModel = new DefaultTableModel();
			JTable ActorTable = new JTable(ActorTableModel);
		    JScrollPane Actorscroll = new JScrollPane(ActorTable);
		   
		public Vector ActorGetColumn()
		{
			Vector ActorCol = new Vector();
			System.out.println("정상적으로 실행됨");
			ActorCol.add("배우 아이디");
			ActorCol.add("이름");
			ActorCol.add("나이");
			ActorCol.add("성별");
			ActorCol.add("소속사");
			ActorCol.add("생년월일");
			return ActorCol;
		}
		public PanelActor()
		{

		
		//Label
		JLabel ActorImformationLabel = new JLabel("배우 정보");
		
		
		//table
		ActorTableModel.setColumnIdentifiers(new String[] {"배우 아이디","이름", "나이", "성별","소속사","생년월일"});
	     //ActorTable.setSize(100,500);
		Actorscroll.setPreferredSize(new Dimension(470,250));
	     //add component
		ActorImformationPanel.add(ActorImformationLabel);
		//ActorTablePanel.add(ActorTable.getTableHeader());
		ActorTablePanel.add(Actorscroll);
		ActorButtonPanel.add(ActorSearchButton);
		ActorButtonPanel.add(ActorInsertButton);
		ActorButtonPanel.add(ActorDeleteButton);
		ActorButtonPanel.add(ActorUpdateButton);
		
		ActorSearchButton.addActionListener(this);
		ActorInsertButton.addActionListener(this);
		ActorDeleteButton.addActionListener(this);
		ActorUpdateButton.addActionListener(this);
		
		//getContentPane().add(ActorTable.getTableHeader(), BorderLayout.NORTH);
	    //getContentPane().add(Actorscroll, BorderLayout.CENTER);
		//add(ActorTable.getTableHeader(),BorderLayout.NORTH);
		ActorImformationPanel.setBounds(0, 0, 500, 20);
	
		ActorTablePanel.setBounds(0, 30, 500, 350);
	
		ActorButtonPanel.setBounds(0, 380, 500, 40);

		add(ActorImformationPanel);
		add(ActorTablePanel);
		add(ActorButtonPanel);
		
		//frame setting
		setLayout(null);
		
		//setLayout(new FlowLayout(FlowLayout.CENTER));
		//setBounds(0,0,500,850);
		setVisible(true);
		
		//setLayout(null);
		//setLayout(new FlowLayout(FlowLayout.CENTER));
		//setLayout(new FlowLayout(FlowLayout.RIGHT));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource() == ActorSearchButton)
		{
			System.out.println("버튼 실행");
			ActorDAO ActorD = new ActorDAO();
			Vector ActorV;
			Vector ActorC;
			ActorV = ActorD.getMemberList();
			ActorC = ActorGetColumn();
			
			DefaultTableModel reActorTable = new DefaultTableModel(ActorV,ActorC);
			ActorTable.setModel(reActorTable);
			//ActorTablePanel.add(ActorTable.getTableHeader());
			ActorTablePanel.add(Actorscroll);
			add(ActorTablePanel);
		
		}
		if(arg0.getSource() == ActorInsertButton)
		{
			ActorInsert AI = new ActorInsert();
		}
		if(arg0.getSource() == ActorDeleteButton)
		{
			ActorDelete AD = new ActorDelete();
		}
		if(arg0.getSource() == ActorUpdateButton)
		{
			ActorUpdate AU = new ActorUpdate();
		}
	}

}
