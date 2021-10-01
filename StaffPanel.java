package Staff;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Actor.ActorDAO;

public class StaffPanel extends JPanel implements ActionListener{
	//Panel
	JPanel StaffImformationPanel = new JPanel();
	JPanel StaffTablePanel = new JPanel();
	JPanel StaffButtonPanel = new JPanel();	
	//Button
	JButton StaffSearchButton = new JButton("검색");
	JButton StaffInsertButton = new JButton("추가");
	JButton StaffDeleteButton = new JButton("삭제");
	JButton StaffUpdateButton = new JButton("변경");
	//Table
	DefaultTableModel  StaffTableModel = new DefaultTableModel();
    JTable StaffTable = new JTable(StaffTableModel);
    JScrollPane Staffscroll = new JScrollPane(StaffTable);
    
	public Vector StaffGetColumn()
	{
		Vector StaffCol = new Vector();
		System.out.println("정상적으로 실행됨");
		StaffCol.add("스태프 아이디");
		StaffCol.add("이름");
		StaffCol.add("나이");
		StaffCol.add("성별");
		StaffCol.add("부서");
		return StaffCol;
	}
	public StaffPanel() {

			
			
			//Label
			JLabel StaffImformationLabel = new JLabel("스태프 정보");
			
			
		
			
		     StaffTableModel.setColumnIdentifiers(new String[] {"스태프아이디","이름", "나이", "성별","부서"});
		     Staffscroll.setPreferredSize(new Dimension(470,250));
			
		     StaffSearchButton.addActionListener(this);
		     StaffInsertButton.addActionListener(this);
		     StaffDeleteButton.addActionListener(this);
		     StaffUpdateButton.addActionListener(this);
			//add component
		     StaffImformationPanel.add(StaffImformationLabel);
		     //MovieTablePanel.add(MovieTable);
		     StaffTablePanel.add(StaffTable.getTableHeader());
			 StaffTablePanel.add(Staffscroll);
				
		     StaffButtonPanel.add(StaffSearchButton);
		     StaffButtonPanel.add(StaffInsertButton);
		     StaffButtonPanel.add(StaffDeleteButton);
		     StaffButtonPanel.add(StaffUpdateButton);
		     
				StaffImformationPanel.setBounds(0, 80, 500, 0);
				
				StaffTablePanel.setBounds(-10, 100, 500, 350);

				StaffButtonPanel.setBounds(0, 450, 500, 40);
		     add(StaffImformationPanel);
		     add(StaffTablePanel);
		     add(StaffButtonPanel);
		     
			//setting frame
			setVisible(true);
			//setSize(5000,5000);
			//setLayout(new FlowLayout(FlowLayout.CENTER));
			//setLayout(new BorderLayout());
			setLayout(null);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==StaffSearchButton)
		{
			System.out.println("버튼 실행");
			StaffDAO StaffA = new StaffDAO();
			Vector StaffV;
			Vector StaffC;
			StaffV = StaffA.getMemberList();
			StaffC = StaffGetColumn();
			
			DefaultTableModel reStaffTable = new DefaultTableModel(StaffV,StaffC);
			StaffTable.setModel(reStaffTable);
			//ActorTablePanel.add(ActorTable.getTableHeader());
			StaffTablePanel.add(Staffscroll);
			add(StaffTablePanel);
		}
		if(arg0.getSource() == StaffInsertButton)
		{
			StaffInsert SI = new StaffInsert();
		}
		if(arg0.getSource()==StaffDeleteButton)
		{
			StaffDelete SD = new StaffDelete();
		}
		if(arg0.getSource()==StaffUpdateButton)
		{
			StaffUpdate SU = new StaffUpdate();
		}
	}

}
