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
			JButton ActorSearchButton = new JButton("�˻�");
			JButton ActorInsertButton = new JButton("�߰�");
			JButton ActorDeleteButton = new JButton("����");
			JButton ActorUpdateButton = new JButton("����");
			DefaultTableModel  ActorTableModel = new DefaultTableModel();
			JTable ActorTable = new JTable(ActorTableModel);
		    JScrollPane Actorscroll = new JScrollPane(ActorTable);
		   
		public Vector ActorGetColumn()
		{
			Vector ActorCol = new Vector();
			System.out.println("���������� �����");
			ActorCol.add("��� ���̵�");
			ActorCol.add("�̸�");
			ActorCol.add("����");
			ActorCol.add("����");
			ActorCol.add("�Ҽӻ�");
			ActorCol.add("�������");
			return ActorCol;
		}
		public PanelActor()
		{

		
		//Label
		JLabel ActorImformationLabel = new JLabel("��� ����");
		
		
		//table
		ActorTableModel.setColumnIdentifiers(new String[] {"��� ���̵�","�̸�", "����", "����","�Ҽӻ�","�������"});
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
			System.out.println("��ư ����");
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
