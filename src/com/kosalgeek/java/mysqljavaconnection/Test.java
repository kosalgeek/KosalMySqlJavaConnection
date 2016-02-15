package com.kosalgeek.java.mysqljavaconnection;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;

public class Test {
	
	MyConnectionInfo info = new MyConnectionInfo("db_student");
	MySqlConnection conn = new MySqlConnection(info);
	
	
	public Test(){
		LinkedHashMap data = new LinkedHashMap();
		data.put(1, "%test%");
		String sql = "SELECT * FROM tbl_student WHERE name LIKE ?";
		try {
			ResultSet rs = conn.execQuery(sql, data);
			while(rs.next()){
				System.out.println(rs.getInt(rs.findColumn("sid")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private void insert(){
		String sql = "INSERT INTO tbl_student VALUES(?, ?, ?, ?, ?, ?)";
		int ok;
		try {
			LinkedHashMap data = new LinkedHashMap();
			data.put(1, null);
			data.put(2, "666");
			data.put(3, "fff");
			data.put(4, Date.valueOf("2000-6-6"));
			data.put(5, 1);
			data.put(6, 2);
			ok = conn.execUpdate(sql, data);
			if(ok > 0){
				System.out.println("Inserted");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Test();

	}

}
