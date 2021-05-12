package com.crm.vtigerTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.GenericUtils.JavaUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;
import com.crm.vtiger.pomclass.SearchLeadPage;

public class TC_53_SearchLeadByFAX_Test extends BaseClass{

	@Test(groups ="smokeTest" )
	public void TC_53_search_lead_byFAX_Test() throws InterruptedException{
		SearchLeadPage searchLeadPage = new SearchLeadPage(driver);
		searchLeadPage.clickOnAdvanceSearch();
		
		wUtil.SelectOption(searchLeadPage.getSalutationDropdown(), "Fax");
		wUtil.SelectOption(searchLeadPage.getComparasionDropDwn(), "equals");
		        
		searchLeadPage.getSearchText().sendKeys(javaUtility.getRandomData());
		searchLeadPage.getSearchButton().click();
		wUtil.waitTillPerform(searchLeadPage.getFName());
		Assert.assertNotNull(searchLeadPage.getFName().getText());        
	}
	

	
	
}
