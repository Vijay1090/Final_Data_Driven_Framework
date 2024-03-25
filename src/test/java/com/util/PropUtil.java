package com.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropUtil {
	
	public String getCommanData(String key) throws IOException {
		FileInputStream commonfile=new FileInputStream("C:\\AdvancedJava\\Final_Data_Driven_Framework\\src\\main\\java\\com\\config\\config.properties");
		Properties prop=new Properties();
		prop.load(commonfile);
		
		String comData = prop.getProperty(key);
		return comData;
		
		
	}
	}
