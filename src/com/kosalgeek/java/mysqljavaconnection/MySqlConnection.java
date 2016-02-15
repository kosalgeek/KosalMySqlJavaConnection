package com.kosalgeek.java.mysqljavaconnection;

import java.sql.*;
import java.util.LinkedHashMap;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class MySqlConnection {
	private Connection conn = null;
	public MySqlConnection(MyConnectionInfo info){
		try {
			Class.forName(info.getDriver());
			MysqlDataSource ds = new MysqlDataSource();
			ds.setUrl(info.getUrl());
			ds.setUser(info.getUsername());
			ds.setPassword(info.getPassword());
			conn = ds.getConnection();
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.toString());
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	}
	
	public int execUpdate(String sql) throws SQLException{
		Statement stmt = conn.createStatement();
		int confirm = stmt.executeUpdate(sql);
		return confirm;
	}
	
	public int execUpdate(String sql, LinkedHashMap data) throws SQLException{
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt = checkData(stmt, data);
		int confirm = stmt.executeUpdate();
		return confirm;
	}
	
	public ResultSet execQuery(String sql) throws SQLException{
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		return rs;
	}
	
	public ResultSet execQuery(String sql, LinkedHashMap data) throws SQLException{
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt = checkData(stmt, data);
		ResultSet rs = stmt.executeQuery();
		return rs;
	}
	
	private PreparedStatement checkData(PreparedStatement stmt, LinkedHashMap data){
		int index = 1;
		try {
			for(Object value : data.values()){
				if(value instanceof Integer){
					stmt.setInt(index, (int) value);
				}
				else if(value instanceof Long){
					stmt.setLong(index, (long) value);
				}
				else if(value instanceof Float){
					stmt.setFloat(index, (float) value);
				}
				else if(value instanceof Double){
					stmt.setDouble(index, (double) value);
				}
				else if(value instanceof String){
					stmt.setString(index, (String) value);
				}
				else if(value instanceof Boolean){
					stmt.setBoolean(index, (boolean) value);
				}
				else if(value instanceof Date){
					stmt.setDate(index, Date.valueOf("" + value));
				}
				else if(value instanceof Time){
					stmt.setTime(index, Time.valueOf("" + value));
				}
				else if(value instanceof Clob){
					stmt.setClob(index, (Clob) value);
				}
				else if(value == null){
					stmt.setNull(index, java.sql.Types.NULL);
				}
				index++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return stmt;
		
		
	}
	
}
