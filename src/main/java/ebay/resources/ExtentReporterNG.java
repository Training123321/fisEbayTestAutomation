package ebay.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	
	public static ExtentReports getReportObject()
	{   
		String path =System.getProperty("user.dir")+"//reports//index.html_"+ System.currentTimeMillis();
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("eBay Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		ExtentReports extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Tarun Sood");
		return extent;
		
		
		
	}
}
