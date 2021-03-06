package extendsreports;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;

import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentDemo {

ExtentReports extent;

@BeforeTest

public void config()

{

// ExtentReports , ExtentSparkReporter

String path =System.getProperty("user.dir")+"\\reports\\index.html";

ExtentSparkReporter reporter = new ExtentSparkReporter(path);

reporter.config().setReportName("Web Automation Results");

reporter.config().setDocumentTitle("Test Results");

extent =new ExtentReports();

extent.attachReporter(reporter);

extent.setSystemInfo("Tester", "abc");

}

@Test

public void initialDemo()

{

ExtentTest test= extent.createTest("Initial Demo");

WebDriverManager.chromedriver().setup();

WebDriver driver =new ChromeDriver();
System.out.println("This is new Changes I have done");

driver.get("https://rahulshettyacademy.com");

System.out.println(driver.getTitle());

driver.close();

//test.fail("Result do not match");

extent.flush();

}

}

