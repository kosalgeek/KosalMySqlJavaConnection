package com.kosalgeek.java.ex1;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.concurrent.LinkedBlockingDeque;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.kosalgeek.java.mysqljavaconnection.MyConnectionInfo;
import com.kosalgeek.java.mysqljavaconnection.MySqlConnection;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Test extends JFrame {

	MyConnectionInfo info = new MyConnectionInfo("db_student");
	MySqlConnection con = new MySqlConnection(info);
	
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		table = new JTable();
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(6, 18, 421, 238);
		contentPane.add(scrollPane);
		
		String sql = "SELECT * FROM tbl_student WHERE name LIKE ?";
		LinkedHashMap data = new LinkedHashMap();
		data.put(1, "Test1");
		try {
			DefaultTableModel model = con.buildTableModel(sql, data);
			table.setModel(model);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
