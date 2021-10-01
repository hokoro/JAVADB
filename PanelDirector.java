package Director;
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
public class PanelDirector extends JPanel implements ActionListener{

	//Panel
	JPanel DirectorImformationPanel = new JPanel();
	JPanel DirectorTablePanel = new JPanel();
	JPanel DirectorButtonPanel = new JPanel();
	
	//Button
	JButton DirectorSearchButton = new JButton("검색");
	JButton DirectorInsertButton = new JButton("추가");
	JButton DirectorDeleteButton = new JButton("삭제");
	JButton DirectorUpdateButton = new JButton("변경");
	
	//Table
	DefaultTableModel DirectorTableModel = new DefaultTableModel();
	JTable DirectorTable = new JTable(DirectorTableModel);
	JScrollPane Directorscroll = new JScrollPane(DirectorTable);
	
	public Vector DirectorGetColumn()
	{
		Vector DirectorCol = new Vector();
		System.out.println("정상적으로 실행됨");
		DirectorCol.add("감독 아이디");
		DirectorCol.add("이름");
		DirectorCol.add("나이");
		DirectorCol.add("성별");
		DirectorCol.add("최근작");
		return DirectorCol;
	}
	public PanelDirector()
	{
		//super("감독 정보창");

		
		//Label
		JLabel DirectorImformationLabel = new JLabel("감독 정보");


		DirectorTableModel.setColumnIdentifiers(new String[] {"감독 아이디","감독 이름","나이","성별","최근작품"});
		Directorscroll.setPreferredSize(new Dimension(470,250));
		//add component
		DirectorImformationPanel.add(DirectorImformationLabel);
		//DirectorTablePanel.add(DirectorTable.getTableHeader());
		DirectorTablePanel.add(Directorscroll);
		DirectorButtonPanel.add(DirectorSearchButton);
		DirectorButtonPanel.add(DirectorInsertButton);
		DirectorButtonPanel.add(DirectorDeleteButton);
		DirectorButtonPanel.add(DirectorUpdateButton);
		
		DirectorSearchButton.addActionListener(this);
		DirectorInsertButton.addActionListener(this);
		DirectorDeleteButton.addActionListener(this);
		DirectorUpdateButton.addActionListener(this);
		
		DirectorImformationPanel.setBounds(0, 0, 500, 20);
	
		DirectorTablePanel.setBounds(-10, 30, 500, 350);

		DirectorButtonPanel.setBounds(0, 380, 500, 40);

		add(DirectorImformationPanel);
		add(DirectorTablePanel);
		add(DirectorButtonPanel);
		//Frame setting
		//setLayout(new FlowLayout(FlowLayout.CENTER));
		setLayout(null);
		setBounds(0,0,500,850);
		setVisible(true);
		
		//setLayout(new BorderLayout());
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			//PanelDirector PD = new PanelDirector();
			//PD.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == DirectorSearchButton)
		{
			System.out.println("버튼 실행");
			DirectorDAO DirectorD = new DirectorDAO();
			Vector DirectorV;
			Vector DirectorC;
			DirectorV = DirectorD.getMemberList();
			DirectorC = DirectorGetColumn();
			
			DefaultTableModel reDirectorTable = new DefaultTableModel(DirectorV,DirectorC);
			DirectorTable.setModel(reDirectorTable);
			DirectorTablePanel.add(DirectorTable.getTableHeader());
			DirectorTablePanel.add(Directorscroll);
			add(DirectorTablePanel);
		}
		if(arg0.getSource()==DirectorInsertButton)
		{
			DirectorInsert DI = new DirectorInsert();
		}
		if(arg0.getSource() == DirectorDeleteButton)
		{
			DirectorDelete DD = new DirectorDelete();
		}
		if(arg0.getSource() == DirectorUpdateButton)
		{
			DirectorUpdate DU = new DirectorUpdate();
		}
	}

}
