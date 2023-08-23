package com.auz.SupportedUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonComponent {
	
	public static JSONObject getJsonObject(String  strJsonObjectName) {
		try {
			JSONObject JSONFileData = (JSONObject) new JSONParser().parse(new FileReader(System.getProperty("user.dir") + Constants.JSONOBJECT_JOB_DIR +strJsonObjectName+ ".json"));
			return JSONFileData;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public static JSONObject getJsonData(String strDataElementName,String strFileName) {
		try {
			JSONObject JSONFileData = (JSONObject) new JSONParser().parse(new FileReader(System.getProperty("user.dir") +Constants.DATAINPUT_DIR +"\\"+strFileName+".json"));
			JSONObject joTestData = (JSONObject) JSONFileData.get(strDataElementName);
			return joTestData;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	// Verifies whether files are exists in repective path
		public static boolean fileExists(String filePath) {
			File f = new File(filePath);
			return f.exists();
		}
	// Reads the json file - Requesting for the body
	public static String readTextFile(String filePath) throws IOException {

		if (!fileExists(filePath))
			return "";
		FileInputStream inputStream = new FileInputStream(filePath);
		String sTemp = IOUtils.toString(inputStream);
		inputStream.close();
		return sTemp.replace("&amp;", "&");
	}

}
