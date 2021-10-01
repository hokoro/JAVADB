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
public class ActorUpdate extends JFrame implements ActionListener{
	boolean IDCheck = false;
	//Button
	JButton ActorIDCheckButton = new JButton("���̵�Ȯ��");
	JButton ActorUpdateButton = new JButton("����");
	JButton ActorCancelButton = new JButton("���");
	ActorDAO ActorD = new ActorDAO();
	ActorDTO ActorT = new ActorDTO();
	
	//TextField
	JTextField ActorIDTextField = new JTextField(10);
	JTextField ActorNameTextField = new JTextField(10);
	JTextField ActorAgeTextField = new JTextField(10);
	JTextField ActorGenderTextField = new JTextField(10);
	JTextField ActorCompanyTextField = new JTextField(10);
	JTextField ActorBirthTextField = new JTextField(10);
	public ActorUpdate()
	{
		super("��� ���� ����â");
		//Panel
		JPanel ActorIDPanel = new JPanel();
		JPanel ActorNamePanel = new JPanel();
		JPanel ActorAgePanel = new JPanel();
		JPanel ActorGenderPanel = new JPanel();
		JPanel ActorCompanyPanel = new JPanel();
		JPanel ActorBirthPanel = new JPanel();
		JPanel ActorUpdateButtonPanel = new JPanel();
		//Label
		JLabel ActorID = new JLabel("��� ���̵�");
		JLabel ActorName =new JLabel("�̸�");
		JLabel ActorAge = new JLabel("����");
		JLabel ActorGender = new JLabel("����");
		JLabel ActorCompany = new JLabel("�Ҽӻ�");
		JLabel ActorBirth = new JLabel("�������");

		ActorIDCheckButton.addActionListener(this);
		ActorUpdateButton.addActionListener(this);
		ActorCancelButton.addActionListener(this);

		ActorUpdateButton.setEnabled(false);
		ActorNameTextField.setEnabled(false);
		ActorAgeTextField.setEnabled(false);
		ActorGenderTextField.setEnabled(false);
		ActorCompanyTextField.setEnabled(false);
		ActorBirthTextField.setEnabled(false);
		//add component
		ActorIDPanel.add(ActorID);
		ActorIDPanel.add(ActorIDTextField);
		ActorIDPanel.add(ActorIDCheckButton);
		
		ActorNamePanel.add(ActorName);
		ActorNamePanel.add(ActorNameTextField);
		
		ActorAgePanel.add(ActorAge);
		ActorAgePanel.add(ActorAgeTextField);
		
		ActorGenderPanel.add(ActorGender);
		ActorGenderPanel.add(ActorGenderTextField);
		
		ActorCompanyPanel.add(ActorCompany);
		ActorCompanyPanel.add(ActorCompanyTextField);
		
		ActorBirthPanel.add(ActorBirth);
		ActorBirthPanel.add(ActorBirthTextField);
		
		ActorUpdateButtonPanel.add(ActorUpdateButton);
		ActorUpdateButtonPanel.add(ActorCancelButton);
		

		
		add(ActorIDPanel);
		add(ActorNamePanel);
		add(ActorAgePanel);
		add(ActorGenderPanel);
		add(ActorCompanyPanel);
		add(ActorBirthPanel);
		add(ActorUpdateButtonPanel);
	
		
		//Frame setting
		setVisible(true);
		setSize(320,300);
		setLayout(new FlowLayout(FlowLayout.LEFT));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ActorUpdate UI = new ActorUpdate();
		UI.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==ActorIDCheckButton)
		{
			System.out.println("CHECK");
           
           Connection con = null;
           PreparedStatement ps = null;
            ResultSet rs = null;

            try {
                con = ActorD.getConn();
                  ActorT.setActorID(ActorIDTextField.getText());
                
                String sql = "select ACTORID from ACTOR where ACTORID=?";
                
                ps = con.prepareStatement(sql);
                ps.setString(1, ActorT.getActorID());
                
                int r = ps.executeUpdate();
                rs = ps.executeQuery();
                if(rs.next()) {
                 String ActorID = rs.getString("ACTORID");
                
                IDCheck = true;
                ActorNameTextField.setEnabled(true); 
                ActorBirthTextField.setEnabled(true); 
                ActorUpdateButton.setEnabled(true); 
                ActorAgeTextField.setEnabled(true);
        		ActorGenderTextField.setEnabled(true);
        		ActorCompanyTextField.setEnabled(true);
                }
                
             }catch(Exception error) {
                error.printStackTrace();
             }

		}
		if(e.getSource()==ActorUpdateButton)
		{
	           Connection con = null;
	           PreparedStatement ps = null;
	           String sql;
	           
			System.out.println("UPDATE");
			if(IDCheck == true)
			{
				try
				{
				      ActorT.setActorID(ActorIDTextField.getText());
	                  ActorT.setActorName(ActorNameTextField.getText());
	                  ActorT.setActorAge(ActorAgeTextField.getText());
	                  ActorT.setActorGender(ActorGenderTextField.getText());
	                  ActorT.setActorCompany(ActorCompanyTextField.getText());
	                  ActorT.setActorBirth(ActorBirthTextField.getText());
	                  
	                  con = ActorD.getConn();
	                  sql = "update ACTOR set ACTORNAME=?,ACTORAGE = ?,ACTORGENDER=?,ACTORCOMPANY=?,ACTORBIRTH=? where ACTORID=?";
	                   
	                   ps = con.prepareStatement(sql);
	                   ps.setString(1, ActorT.getActorName());
	                   ps.setString(2, ActorT.getActorAge());
	                   ps.setString(3, ActorT.getActorGender());
	                   ps.setString(4, ActorT.getActorCompany());
	                   ps.setString(5, ActorT.getActorBirth());
	                   ps.setString(6, ActorT.getActorID());
	                   
	                   int r = ps.executeUpdate();
	                   dispose();
				}
				catch(Exception error )
				{
					error.printStackTrace();
				}
			}
			else
			{
				dispose();
			}
		}
		if(e.getSource()==ActorCancelButton)
		{
			dispose();
		}
		
	}

}
