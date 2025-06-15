package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import config.ConfigReader;

// handle flaky test, unstable test
public class RetryAnalyzer implements IRetryAnalyzer
{

	private int retryCount=0;
	
	private int maxRetryCount=Integer.parseInt(new ConfigReader().get("maxretrycount"));
	
	//private int maxRetryCount=5;
	
	public boolean retry(ITestResult result) 
	{
		
		if(retryCount<maxRetryCount)
		{
			retryCount++;
			
			System.out.println("Retrying tests: "+result.getMethod().getMethodName()+ " Attempts: "+retryCount);
			
			return true;
		}
		
		return false;
	}

}
