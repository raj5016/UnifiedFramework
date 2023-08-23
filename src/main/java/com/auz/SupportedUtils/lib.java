package com.auz.SupportedUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;
import com.auz.SupportedUtils.lib;

public class lib {

	public static String resourceLocation = Constants.RESOURCE_DIR;
	public static String dataInputLocation = Constants.DATAINPUT_DIR;
	public static Properties pointerData = new Properties();
	
	public static ThreadLocal<String> testName = new ThreadLocal<String>();
	public static Properties configData = new Properties();
	static {
		try {
			File file = new File((System.getProperty("user.dir").toString().replace("\\", "\\\\")
					+ Constants.RESOURCE_DIR + "DBDataUtils.xml"));
			FileInputStream fileInput = new FileInputStream(file);

			configData.loadFromXML(fileInput);
			fileInput.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static boolean isInvalid(String sInput) throws Exception {
		boolean isInvalid = true;
		if (sInput != null && sInput.trim().length() > 0)
			isInvalid = false;
		return isInvalid;
	}
	
	public static Properties LoadProperties(String XMLFilePath)
			throws Exception, FileNotFoundException, InvalidPropertiesFormatException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(XMLFilePath);
		prop.loadFromXML(fis);
		return prop;
	}
	
	public static String readEnvironmentData() {
		Properties mavenProps = new Properties();
		String environment = null ;
		try {
			mavenProps.load(lib.class.getClassLoader().getResourceAsStream("maven.properties"));
			environment = mavenProps.getProperty("ENVIRONMENT");

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return environment;
	
	}
}
