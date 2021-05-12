package com.crm.vtigerTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LeadTest {
	
	WebDriver driver;
	
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
        
		//navigate to lead
		driver.findElement(By.linkText("Leads")).click();	
		
		//navigate to go to advance search option
		driver.findElement(By.linkText("Go to Advanced Search")).click();
	}
	
	@Test
	public void TC_51_search_lead_byannualrev_Test() throws InterruptedException{
		//click on salutation in dropdown
		WebElement ele =driver.findElement(By.id("fcol0"));
	
		Select s = new Select(ele);
        s.selectByVisibleText("Annual Revenue");
        
        ele =driver.findElement(By.id("fop0"));
	    s = new Select(ele);
        s.selectByVisibleText("less than");
       
        driver.findElement(By.id("fval0")).sendKeys("600");
        Thread.sleep(3000);
       
        driver.findElement(By.xpath("//*[@id='advSearch']/form/table[3]/tbody/tr/td/input")).click();   	
		
	}

	
	@Test
	public void TC_52_search_lead_bycreatedtime_Test() throws InterruptedException{		
		//click on salutation in dropdown
		WebElement ele =driver.findElement(By.id("fcol0"));
		
		Select s = new Select(ele);
        s.selectByVisibleText("Created Time");
        
        ele =driver.findElement(By.id("fop0"));
	    s = new Select(ele);
        s.selectByVisibleText("greater than");
       
        driver.findElement(By.id("fval0")).sendKeys("2021-04-01 00:51:56");;
        Thread.sleep(3000);
       
        driver.findElement(By.xpath("//*[@id='advSearch']/form/table[3]/tbody/tr/td/input")).click();   
        
	}

	
	@Test
	public void TC_53_search_lead_byFAX_Test() throws InterruptedException{
		//click on salutation in dropdown
		WebElement ele =driver.findElement(By.id("fcol0"));
		
		Select s = new Select(ele);
        s.selectByVisibleText("Fax");
        
        ele =driver.findElement(By.id("fop0"));
	    s = new Select(ele);
        s.selectByVisibleText("equals");
       
        driver.findElement(By.id("fval0")).sendKeys("123456789");
        Thread.sleep(3000);
       
        driver.findElement(By.xpath("//*[@id='advSearch']/form/table[3]/tbody/tr/td/input")).click();   
        
	}
	
	@Test
	public void TC_54_search_lead_by_leadno_Test() throws InterruptedException{
		//click on salutation in dropdown
		WebElement ele =driver.findElement(By.id("fcol0"));
		
		Select s = new Select(ele);
        s.selectByVisibleText("Lead No");
        
        ele =driver.findElement(By.id("fop0"));
	    s = new Select(ele);
        s.selectByVisibleText("greater than");
       
        driver.findElement(By.id("fval0")).sendKeys("9");;
        Thread.sleep(3000);
       
        driver.findElement(By.xpath("//*[@id='advSearch']/form/table[3]/tbody/tr/td/input")).click();   
        
	}
	

	@Test
	public void TC_55_search_lead_by_leadsource_Test() throws InterruptedException{
		
		//click on salutation in dropdown
		WebElement ele =driver.findElement(By.id("fcol0"));
		
		Select s = new Select(ele);
        s.selectByVisibleText("Lead Source");
        
        ele =driver.findElement(By.id("fop0"));
	    s = new Select(ele);
        s.selectByVisibleText("contains");
       
        driver.findElement(By.id("fval0")).sendKeys("google");;
        Thread.sleep(3000);
       
        driver.findElement(By.xpath("//*[@id='advSearch']/form/table[3]/tbody/tr/td/input")).click();   
        
	}
	
	@AfterMethod
	public void destroy() 
	{
		//logout from application
		WebElement ele =driver.findElement(By.xpath("/html/body/table[1]/tbody/tr/td[3]/table/tbody/tr/td[2]/img"));
		Actions a= new Actions(driver);
		a.moveToElement(ele).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();
		
	}
	
}

