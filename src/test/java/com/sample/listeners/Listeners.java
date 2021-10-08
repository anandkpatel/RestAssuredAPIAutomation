package com.sample.listeners;
import com.relevantcodes.extentreports.LogStatus;
import com.sample.utilities.CurrentDate;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Listeners extends TestListenerAdapter
{

    protected static String currentdate = CurrentDate.currentDate();
    public ExtentHtmlReporter htmlReporter;
    public ExtentReports extent;
    public ExtentTest test;

    public void onStart(ITestContext testContext)
    {
        htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "//ExtentReports//Test Report_ "  +  currentdate + ".html");//specify location of the report


        htmlReporter.config().setDocumentTitle("Rest Assured API Automation Report"); // Tile of report
        htmlReporter.config().setReportName("API Automation Report"); // name of the report

        htmlReporter.config().setTheme(Theme.DARK);

        extent=new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Project Name","Sample API Automation Test");
        extent.setSystemInfo("Host name","LocalHost");
        extent.setSystemInfo("Environemnt","QA");
        extent.setSystemInfo("user","Anand");

    }

    public void onTestSuccess(ITestResult result)
    {
        test=extent.createTest(result.getName()); // create new entry in th report
        test.log(Status.PASS,  result.getName() + " Test Case successfully Passed");
    }

    public void onTestFailure(ITestResult result)
    {
        test=extent.createTest(result.getName()); // create new entry in th report

        test.log(Status.FAIL,  result.getName() + "Test case failed");
        test.log(Status.FAIL, result.getThrowable().getMessage());


    }

    public void onTestSkipped(ITestResult result)
    {
        test=extent.createTest(result.getName()); // create new entry in th report
        test.log(Status.SKIP, result.getName() + " Test Case skipped");
    }

    public void onFinish(ITestContext testContext)
    {
        extent.flush();
    }

}