package Actor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.lang.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import java.awt.event.*;
public class ActorInsert extends JFrame implements ActionListener{
	//Actor Insert , cancel button
	JButton ActorInsert = new JButton("추가");
	JButton ActorCancel = new JButton("취소");
	ActorDAO ActorD = new ActorDAO();
	ActorDTO ActorT = new ActorDTO();
	
	//Actor textField
	JTextField ActorIDField = new JTextField(10);
	JTextField ActorNameField = new JTextField(10);
	JTextField ActorAgeField = new JTextField(10);
	JTextField ActorGenderField = new JTextField(10);
	JTextField ActorCompanyField = new JTextField(10);
	JTextField ActorBirthField = new JTextField(10);
	public ActorInsert()
	{
		//super("배우 정보 입력창 ");
		
		//Actorpanel
		JPanel ActorIDPanel = new JPanel();
		JPanel ActorNamePanel = new JPanel();
		JPanel ActorAgePanel = new JPanel();
		JPanel ActorGenderPanel = new JPanel();
		JPanel ActorCompanyPanel = new JPanel();
		JPanel ActorBirthPanel = new JPanel();
		JPanel ActorInsertButtonPanel = new JPanel();
		//Actor label
		JLabel ActorID = new JLabel("배우 아이디");
		JLabel ActorName = new JLabel("이름");
		JLabel ActorAge = new JLabel("나이");
		JLabel ActorGender = new JLabel("성별");
		JLabel ActorCompany = new JLabel("소속사");
		JLabel ActorBirth = new JLabel("생년월일");
		
		ActorInsert.addActionListener(this);
		ActorCancel.addActionListener(this);
		

		//Insert Component
		ActorIDPanel.add(ActorID);
		ActorIDPanel.add(ActorIDField);
		
		ActorNamePanel.add(ActorName);
		ActorNamePanel.add(ActorNameField);
		
		ActorAgePanel.add(ActorAge);
		ActorAgePanel.add(ActorAgeField);
		
		ActorGenderPanel.add(ActorGender);
		ActorGenderPanel.add(ActorGenderField);
		
		ActorCompanyPanel.add(ActorCompany);
		ActorCompanyPanel.add(ActorCompanyField);

		ActorBirthPanel.add(ActorBirth);
		ActorBirthPanel.add(ActorBirthField);
		
		
		ActorInsertButtonPanel.add(ActorInsert);
		ActorInsertButtonPanel.add(ActorCancel);
		
		//Insert Panel
		add(ActorIDPanel);
		add(ActorNamePanel);
		add(ActorAgePanel);
		add(ActorGenderPanel);
		add(ActorCompanyPanel);
		add(ActorBirthPanel);
		add(ActorInsertButtonPanel);
		setSize(300,300);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ActorInsert AI = new ActorInsert();
		AI.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == ActorCancel)
		{
			dispose();
		}
		if(e.getSource() == ActorInsert)
		{
			System.out.println("INSERT");
			ActorT.setActorID(ActorIDField.getText());
			ActorT.setActorName(ActorNameField.getText());
			ActorT.setActorAge(ActorAgeField.getText());
			ActorT.setActorGender(ActorGenderField.getText());
			ActorT.setActorCompany(ActorCompanyField.getText());
			ActorT.setActorBirth(ActorBirthField.getText());
			Connection con = null;
			PreparedStatement ps = null;
			try {
				con = ActorD.getConn();
				String sql = "insert into ACTOR(" + "ACTORID,ACTORNAME,ACTORAGE,ACTORGENDER,ACTORCOMPANY,ACTORBIRTH)" +"values("+ "?,?,?,?,?,?)";
				ps = con.prepareStatement(sql);
				ps.setString(1,ActorT.getActorID());
				ps.setString(2,ActorT.getActorName());
				ps.setString(3,ActorT.getActorAge());
				ps.setString(4,ActorT.getActorGender());
				ps.setString(5,ActorT.getActorCompany());
				ps.setString(6,ActorT.getActorBirth());
				
				int r = ps.executeUpdate();
				dispose();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			
		}
		
	}

}
