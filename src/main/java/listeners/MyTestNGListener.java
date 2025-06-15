package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.chaintest.plugins.ChainTestListener;

public class MyTestNGListener implements ITestListener 
{

	public void onTestSuccess(ITestResult result) 
	{
		ChainTestListener.log("Listeners - Test Passed "+result.getMethod().getMethodName());
		//System.out.println("Listeners - Test Passed");
	}

	public void onTestFailure(ITestResult result) {
		//System.out.println("Listeners - Test Failed " + result.getThrowable().getMessage());
		
		ChainTestListener.log("Listeners - Test Failed "+result.getThrowable().getMessage());
	
		
	}

	public void onTestSkipped(ITestResult result) 
	{
		
		ChainTestListener.log("Listeners - Test Skipped "+result.getThrowable().getMessage());
		
		//System.out.println("Listeners - Test Skipped " + result.getThrowable().getMessage());
	}

	public void onStart(ITestContext context) 
	{
		ChainTestListener.log("Listeners - Test Started "+context.getClass().getName());
	}

	public void onFinish(ITestContext context) 
	{
		ChainTestListener.log("Listeners - Test Finised "+context.getClass().getName());
	}

}
