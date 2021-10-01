package MainDB;
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
import Actor.*;
import Director.*;
import Movie.*;
import Staff.*;

public class MainFrame extends JFrame {
	
	

	public MainFrame() {

		PanelActor PA = new PanelActor();
		PanelDirector PD = new PanelDirector();
		PanelMovie PM = new PanelMovie();
		StaffPanel PS = new StaffPanel();
		
		PA.setBounds(0, 0, 500,500);
		
		add(PA);
		PD.setBounds(500, 0, 500,500);
		
		add(PD);
		PM.setBounds(0,390, 500,500);
		add(PM);
		PS.setBounds(500, 390, 500,500);
		add(PS);

		//setLayout(new FlowLayout(FlowLayout.LEFT));
		//setLayout(new GridLayout(2,2));
		setLayout(null);
		//setLayout(new BorderLayout());
		setSize(1700,1000);
		//setLocationRelativeTo(null);
		setVisible(true);
		Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
		  System.out.println("ÇØ»óµµ : " + res.width + " x " + res.height);  
	



	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainFrame Frame = new MainFrame();
		Frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

}
