package stepDefinations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class UserStepDefination {
	WebDriver driver;
	
	@Given("User is on Login Page")
	public void user_is_on_login_page() {
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  driver.get("https://the-internet.herokuapp.com/login");
	}
	@And("User enter Username and Password")
	public void user_enter_username_and_password() {
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("tomsmith");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.xpath("//*[@id=\"login\"]/button")).click();
	    
	}
	@Then("Should displayed home page")
	public void should_displayed_home_page() {
		boolean isValidUser = driver.findElement(By.xpath("//*[@id=\"flash2\"]")).isDisplayed();
		Assert.assertTrue(isValidUser);
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
