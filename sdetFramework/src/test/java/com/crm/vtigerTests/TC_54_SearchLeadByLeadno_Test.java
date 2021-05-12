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

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.GenericUtils.JavaUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;
import com.crm.vtiger.pomclass.SearchLeadPage;

public class TC_54_SearchLeadByLeadno_Test extends BaseClass{

	
	@Test(groups ="regressionTest" )
	public void TC_54_search_lead_by_leadno_Test() throws InterruptedException{
		SearchLeadPage searchLeadPage = new SearchLeadPage(driver);
		searchLeadPage.clickOnAdvanceSearch();
		
		wUtil.SelectOption(searchLeadPage.getSalutationDropdown(), "Lead No");
		wUtil.SelectOption(searchLeadPage.getComparasionDropDwn(), "greater than");
		        
		searchLeadPage.getSearchText().sendKeys("9");
		searchLeadPage.getSearchButton().click();
	    
	}
	
	
	
}
