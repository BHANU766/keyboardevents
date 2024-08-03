package com.keyboardevents;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;

public class Keysupanddown {
	protected static String url="https://demoqa.com/text-box";
	WebDriver driver;
 
  @BeforeSuite
  public void startchromebrowser() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
  }
  
  @BeforeClass
  public void openurl() {
	  driver.get(url);
  }
  
// @Test
// public void fetchtitle() throws InterruptedException {	 
//	 String title=driver.getTitle();
//	 System.out.println(title);
//	 Thread.sleep(1000);
//} 
  
   @Test
   public void getkeyboardevent() throws InterruptedException {
     //create the object of Actions class
     Actions actions=new Actions(driver);
     
     //enter the fullname
     WebElement fullname=driver.findElement(By.id("username"));
     fullname.sendKeys("Bhanu rekha");
     
     //enter the email
     WebElement email=driver.findElement(By.id("userEmail"));
     email.sendKeys("rekha@gmail.com");
     
     //enter the current Address
     WebElement currentAddress=driver.findElement(By.id("currentaddress"));
     currentAddress.sendKeys("Kphb phase-15,Hyderabad");
    	    	
     //select the current Address CTRL+A
     actions.keyDown(Keys.CONTROL);
     actions.sendKeys("a");   	
     actions.keyUp(Keys.CONTROL);
     actions.build().perform();
    	
     //copy the current Address CTRL+C
     actions.keyDown(Keys.CONTROL);
     actions.sendKeys("c");
     actions.keyUp(Keys.CONTROL);
     actions.build().perform();
    	
     //press tab key
     actions.sendKeys(Keys.TAB);
     actions.build().perform();
    	
     //paste the Address in permanent Address CTRL+V
     actions.keyDown(Keys.CONTROL);
     actions.sendKeys("v");
     actions.keyUp(Keys.CONTROL);
     actions.build().perform();
    	
     //compare text of current Address and permanent Address
     WebElement permanentAddress=driver.findElement(By.id("permanentAddress"));
     assertEquals(currentAddress.getAttribute("value"),permanentAddress.getAttribute("value"));
    	    	
    }
  
  @AfterSuite
  public void closechromebrowser() {
	  driver.quit();
  }

}

