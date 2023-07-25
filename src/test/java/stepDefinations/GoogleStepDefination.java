package stepDefinations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleStepDefination {
	WebDriver driver;
	@Given("User Lunch Google Page")
	public void user_lunch_google_page() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.google.com/");
	    
	}
	@When("User Search Java Tutorial")
	public void user_search_java_tutorial() {
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("JAVA Tutorial");
		searchBox.submit();
		
	    
	}
	@Then("Should displayed Java Tutorial Page")
	public void should_displayed_java_tutorial_page() {
		Assert.assertEquals(driver.getTitle(), "JAVA Tutorial - Google Search");
		driver.quit();
	    
	}
	
	
	@When("User Search Selenium Tutorial")
	public void user_search_Selenium_tutorial() {
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("Selenium Tutorial");
		searchBox.submit();
		
	    
	}
	@Then("Should displayed Selenium Tutorial Page")
	public void should_displayed_Selenium_tutorial_page() {
		Assert.assertEquals(driver.getTitle(), "Selenium Tutorial - Google Search");
		driver.quit();
	    
	}
	
	@After
	public void atatchScreenshot(Scenario senario) {
		if(senario.isFailed()) {
			TakesScreenshot screen = (TakesScreenshot) driver;
			byte[] img = screen.getScreenshotAs(OutputType.BYTES);
			senario.attach(img, "image/png", "imgOne");
			
		}
		
	}
	

}
