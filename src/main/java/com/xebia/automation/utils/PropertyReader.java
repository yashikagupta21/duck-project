package com.xebia.automation.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class PropertyReader {
	public static final Logger logger = LogManager.getLogger(PropertyReader.class);	

	public static String getMyProperty(String key) throws IOException {
		// Step 1= Create properties object
		Properties properties = new Properties();

		// Step 2 = Input the File
		InputStream inputstream = new FileInputStream("env.properties");

		// Step 3 = Load the Properties object with file
		properties.load(inputstream);

		// Step 4 = access the properties from file
		String value = properties.getProperty(key);
		//System.out.println("Value is  " + value);
		logger.info("Key value is  " + value);
		return value;

	}
}
