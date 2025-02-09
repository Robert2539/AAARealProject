package com.sw.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	public PropertyReader() {

	}

	public static Properties prop = new Properties();

	static { // eagar initialization
		try {
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "/ApplicationUrls/application.Properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} // fis null means can't find properties file
		catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static String getValue(String key) throws Exception {
		if (prop.getProperty(key) == null) {
			throw new Exception("Property name " + key + " is not found. PLease check application.properties file");
		}
		return prop.getProperty(key).trim(); // used trim to handle even if user gave space at the end in property fine

	}
}
