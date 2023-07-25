package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features="src\\test\\resources\\features\\",
				 glue={"stepDefinations"},
				 monochrome=true,
				 plugin= {"pretty",
						 "usage:target\\reports\\UsageReports",
						 "html:target\\reports\\HtmlReports.html",
						 "json:target\\reports\\JsonReports",
						 "testng:target\\reports\\TestNgReports",
						 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
				 dryRun=false)
public class GooglePageRunner extends AbstractTestNGCucumberTests {
  
}
