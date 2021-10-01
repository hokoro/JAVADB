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
public class ActorDelete extends JFrame implements ActionListener {
	//Button
	JButton ActorDeleteButton = new JButton("삭제");
	JButton ActorCancelButton = new JButton("취소");
	ActorDAO  ActorA = new ActorDAO();
	ActorDTO ActorT = new ActorDTO();
	
	//TextField
	JTextField ActorIDTextField = new JTextField(5);
	public ActorDelete()
	{
		super("배우 삭제 창");
		
		//Panel
		JPanel ActorIDPanel = new JPanel();
		JPanel ActorDeleteButtonPanel = new JPanel();
		
		//Label
		JLabel ActorID = new JLabel("배우 아이디");


		
		ActorDeleteButton.addActionListener(this);
		ActorCancelButton.addActionListener(this);
		//add component
		ActorIDPanel.add(ActorID);
		ActorIDPanel.add(ActorIDTextField);
		
		ActorDeleteButtonPanel.add(ActorDeleteButton);
		ActorDeleteButtonPanel.add(ActorCancelButton);
		
		add(ActorIDPanel);
		add(ActorDeleteButtonPanel);
		
		setSize(150,140);
		setLayout(new FlowLayout());
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ActorDelete AD = new ActorDelete();
		AD.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == ActorCancelButton)
		{
			dispose();
		}
		if(arg0.getSource() == ActorDeleteButton)
		{
			System.out.println("DElETE");
			ActorT.setActorID(ActorIDTextField.getText());
			Connection con = null;
			PreparedStatement ps = null;
			try {
				con = ActorA.getConn();
				String sql = "delete from ACTOR where ACTORID=?";
				ps = con.prepareStatement(sql);
				ps.setString(1,ActorT.getActorID());
				
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
