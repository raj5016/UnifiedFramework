package com.auz.SupportedUtils;

import java.util.List;


import java.util.ArrayList;
import java.util.HashMap;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class SQLWrapper {
	public static Connection conn = null;
	public static PreparedStatement stmnt = null;
	public static ResultSet rs = null;
	@SuppressWarnings("rawtypes")
	public static List<HashMap> resultList;

	public static Connection createConnection() {
		try {
			conn = getMySQLDBConnection(lib.configData.getProperty("MYSQLDatabaseServer"),
					lib.configData.getProperty("MYSQLDatabasePort"), lib.configData.getProperty("MYSQLDatabaseName"),
					lib.configData.getProperty("MYSQLDatabaseUserID"),
					lib.configData.getProperty("MYSQLDatabaseUserPwd"));
			if (conn.isClosed()) {
				System.out.println("Database connection should be successful");
			}
		} catch (Exception e) {
			System.out.println("Exception occured while connecting Database: " + e.getMessage());
			e.printStackTrace();
		}
		return conn;
	}

	public static Connection getMySQLDBConnection(String sServer, String portNumber, String dbName, String sUser,
			String sPassword) throws Exception {
		StringBuffer connectionURL = new StringBuffer();
		connectionURL.append("jdbc:mysql://");
		connectionURL.append(sServer);
		connectionURL.append(":" + portNumber + "/");
		connectionURL.append(dbName);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("URL::" + connectionURL.toString());
			conn = DriverManager.getConnection(connectionURL.toString(), sUser, sPassword);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return conn;
	}

	public static List<HashMap> getResultSet(String sQuery) throws Exception {
		resultList = new ArrayList();
		try {
			if (conn == null) {
				conn = createConnection();
			}
			stmnt = conn.prepareStatement(sQuery);
			rs = stmnt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			while (rs.next()) {
				HashMap<String, Object> resultMap = new HashMap();
				for (int i = 1; i <= columnCount; i++) {
					String colName = rsmd.getColumnName(i);
					Object colVal = rs.getObject(colName);
					resultMap.put(colName, colVal);
				}
				resultList.add(resultMap);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
		return resultList;
	}

	public static void modifyDataIntoDB(String sQuery, String indicatorKey) throws Exception {
		// indicatorKey--is( update or delete or insert)
		PreparedStatement stmnt = null;
		try {
			if (conn == null) {
				conn = createConnection();
			}
			stmnt = conn.prepareStatement(sQuery);
			int rs = stmnt.executeUpdate();
			System.out.println(rs + "  " + indicatorKey + " records affected");
			System.out.println(rs + "  " + indicatorKey + " records affected");
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}
	
	public static void closeMySqlConnection() throws Exception {
		
		try {
			if (conn != null) {
				conn.close();
				System.out.println("Connection closed:::::");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}
	
}
