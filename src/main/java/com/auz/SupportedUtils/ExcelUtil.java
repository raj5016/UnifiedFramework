package com.auz.SupportedUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

import com.auz.SupportedUtils.ExcelUtil;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class ExcelUtil {
	public static HashMap<String, String> getRequestParams(String fileName,String requestSheetName, String testName) throws Exception {// IncomePostings,Sample1_Posting
		HashMap<String, String> result = new HashMap<String, String>();
		String sQuery = "SELECT * FROM " + requestSheetName + " where TestName = '" + testName + "'";
		result = ExcelUtil.GetRowDataFromExcel(fileName+".xlsx",sQuery);
		return result;
	}

	public static HashMap<String, String> GetRowDataFromExcel(String sFile, String sQuery) throws Exception {//Payment_transaction.xlsx,Query
		LinkedHashMap<String, String> results = new LinkedHashMap<String, String>();
		Recordset rs = null;
		String columnNames = "";
		int columnCount = 0;
		int rowCount = 0;

		String dataFile = lib.dataInputLocation + sFile;//Payment_transaction.xlsx
		if (lib.isInvalid(sQuery)) {
		System.out.println("Query to execute is empty :");
			// addExceptionsToList("Query to execute is empty :");
			return null;
		}
		Fillo fillo = new Fillo();
		Connection connObj = fillo.getConnection(dataFile);
		if (null != connObj) {
			try {
				rs = connObj.executeQuery(sQuery);
				ArrayList<String> fields = rs.getFieldNames();
				columnCount = fields.size();//10
				rowCount = 0;
				while (rs.next()) {
					rowCount++;
					columnNames = "";
					for (int i = 0; i < columnCount; i++) {
						String columnName = fields.get(i);
						if (columnNames == "")
							columnNames = columnName;
						else
							columnNames = columnNames + ";" + columnName;//col1;col2

						String sTemp = rs.getField(columnName);
						if (sTemp == null)
							sTemp = "";
						results.put(columnName, sTemp);//keeps column names values in map object
					}
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		if (null != connObj)
			connObj.close();

		// logger.info("This is from lib");
		results.put("RowCount", rowCount + "");
		results.put("ColumnCount", columnCount + "");
		results.put("ColumnNames", columnNames);
		//System.out.println(results);
		return results;
	}

	public static HashMap<String, String> GetAllDataFromExcel(String sFile, String sQuery) throws Exception {//Payment_transaction.xlsx,select TestName from HoldingDetails where ExecutionFlag ='Y'
		LinkedHashMap<String, String> results = new LinkedHashMap<String, String>();
		Recordset rs = null;
		String columnNames = "";
		int columnCount = 0;
		int rowCount = 0;

		String dataFile = lib.dataInputLocation + sFile; //src/test/resources/API/Payment_transaction.xlsx
		if (lib.isInvalid(sQuery)) {
			System.out.println("Query to execute is empty :");
			// addExceptionsToList("Query to execute is empty :");
			return null;
		}
		Fillo fillo = new Fillo();
		Connection connObj = null;
		try {
			connObj = fillo.getConnection(dataFile);
			if (null != connObj) {

				rs = connObj.executeQuery(sQuery);
				ArrayList<String> fields = rs.getFieldNames();
				columnCount = fields.size();//8
				rowCount = 0;
				while (rs.next()) {
					rowCount++;//1
					columnNames = "";
					for (int i = 0; i < columnCount; i++) {
						String columnName = fields.get(i);
						if (columnNames == "")
							columnNames = columnName;
						else
							columnNames = columnNames + ";" + columnName;//col1;col2;col3;

						String sTemp = rs.getField(columnName);//colval
						if (sTemp == null)
							sTemp = "";
						results.put(columnName + rowCount, sTemp);//col1name1,colval
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// addExceptionsToList(e.getMessage());
		}

		if (null != connObj)
			connObj.close();

		// logger.info("This is from lib");
		results.put("RowCount", rowCount + "");
		results.put("ColumnCount", columnCount + "");
		results.put("ColumnNames", columnNames);
		//System.out.println(results);
		return results;
	}


	public static Object[][] GetExcelDataHash1(String filename,String sQuery) throws Exception {//select TestName from HoldingDetails where ExecutionFlag ='Y',testname

		String[][] testData = null;
		HashMap<String, String> excelData = ExcelUtil.GetAllDataFromExcel(filename + ".xlsx"  ,
				sQuery);//Payment_transaction.xlsx,select TestName from HoldingDetails where ExecutionFlag ='Y'
		int rowCount = Integer.parseInt(excelData.get("RowCount"));
		testData = new String[rowCount][1];

		Set<String> keys = excelData.keySet();
		keys.remove("RowCount");
		keys.remove("ColumnCount");
		keys.remove("ColumnNames");
		int i = 1;
		for (String s : keys) {
				//System.out.println(excelData.get(s));
				testData[(i - 1)][0] = excelData.get(s);
				i++;
		}

		return (testData);
	}



}
