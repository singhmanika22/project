package com.crm.vtigerTests;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyOrganisationTest {	
	WebDriver driver ;
	
	@BeforeMethod
	public void init(){
		System.setProperty("webdriver.gecko.driver", "./software/geckodriver.exe");
		driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        
        //get url
        driver.get("http://localhost:8888");
         
        //login to application
        driver.findElement(By.name("user_name")).sendKeys("admin");
        driver.findElement(By.name("user_password")).sendKeys("admin");
        driver.findElement(By.id("submitButton")).click();

	}
	
	@Test
	public void myOrganisation()
	{
        //navigate to organisation
        driver.findElement(By.linkText("Organizations")).click();
        
        //create organisation
        driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
        driver.findElement(By.name("accountname")).sendKeys("ZS Assoc1");
        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();   
	}
	 
	
	@Test
	public void testCreateContact() throws InterruptedException {
		//navigate to organisation
        driver.findElement(By.linkText("Contacts")).click();
        
      //create contact
        driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
        driver.findElement(By.name("lastname")).sendKeys("murthy");
        driver.findElement(By.name("firstname")).sendKeys("murthy");
        driver.findElement(By.xpath("//img[@title='Select']")).click();
        
        String parent = driver.getWindowHandle();
        Set <String> child = driver.getWindowHandles();
        
        for( String st: child) {
        	driver.switchTo().window(st);
        }
        
        driver.findElement(By.xpath("//*[@id='1']")).click();
        driver.switchTo().window(parent);
        
        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

        
	}
	
	@Test
	public void myOrganisationWithIndustry() throws InterruptedException
	{
        //navigate to organisation
        driver.findElement(By.linkText("Organizations")).click();
        
        //create organisation with Industry
        driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
        driver.findElement(By.name("accountname")).sendKeys("ZS Assoc4");
       // Banking
        WebElement ele =driver.findElement(By.name("industry"));
        
        Select s = new Select(ele);
        s.selectByValue("Banking");
       
        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();   
        Thread.sleep(7000);
	}

	
	
	
	@AfterMethod
	public void destory() {
		  //close browser
        driver.close();
	}
}
