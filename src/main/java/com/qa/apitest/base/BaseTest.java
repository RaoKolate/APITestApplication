package com.qa.apitest.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseTest
{
	public int RESPONSE_STATUS_CODE_200 =200;
	public int RESPONSE_STATUS_CODE_500 =500;
	public int RESPONSE_STATUS_CODE_400 =400;
	public static Properties prop;
	
    public BaseTest()
    {
    	
   
    	
    	prop = new Properties();
    	
    	FileInputStream input = null ;
		
			try {
				input = new FileInputStream("C:\\Users\\r.sambhaji.kolate\\workspace\\APITest\\src\\main\\java\\com\\qa\\apitest\\configurations\\config.properties");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
    	try {
			prop.load(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	
    }
	
}
