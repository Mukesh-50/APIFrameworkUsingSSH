package config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader 
{
	Properties pro;

	public ConfigReader()
	{
		try 
		{
			File src=new File("src/main/resources/config.properties");
			
			FileInputStream fis=new FileInputStream(src);
			
			pro=new Properties();
			
			pro.load(fis);
			
		} catch (FileNotFoundException e) 
		{
			System.out.println("Could not locate the file "+e.getMessage());
			
		} catch (IOException e) 
		{
			System.out.println("Could not read the properties file "+e.getMessage());
		}
		
	}
	
	public String get(String key)
	{
		String value=pro.getProperty(key);
		
		return value;
	}
	
	
}
