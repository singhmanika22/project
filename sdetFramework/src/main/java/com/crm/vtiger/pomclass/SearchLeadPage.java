package com.crm.vtiger.pomclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;

public class SearchLeadPage extends BaseClass{

	WebDriver driver;
	
	@FindBy(id="fcol0")
	private WebElement salutationDropdown;
	
	@FindBy(linkText="Leads")
	private WebElement leadsLink;
	
	@FindBy(linkText="Go to Advanced Search")
	private WebElement advanceSearchLink;
	
	@FindBy(id="fval0")
	private WebElement searchText;
	
	@FindBy(id="fop0")
	private WebElement comparasionDropDwn;
	
	@FindBy(xpath="//*[@id='advSearch']/form/table[3]/tbody/tr/td/input")
	private WebElement searchButton;
	
	@FindBy(xpath = "//img[@id='jscal_trigger_fval0']")
	private WebElement calenderImg;
	
	@FindBy(xpath = "//table/tbody/tr/td[@class='day selected today']")
	private WebElement currentDay;
	
	@FindBy(xpath = "//table/tbody/tr/td/a[@title='Leads']")
	private WebElement fName;
	
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getSalutationDropdown() {
		return salutationDropdown;
	}

	public WebElement getLeadsLink() {
		return leadsLink;
	}

	public WebElement getAdvanceSearchLink() {
		return advanceSearchLink;
	}

	public WebElement getSearchText() {
		return searchText;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getComparasionDropDwn() {
		return comparasionDropDwn;
	}
	
	
	public WebElement getCalenderImg() {
		return calenderImg;
	}

	public WebElement getCurrentDay() {
		return currentDay;
	}

	public WebElement getFName() {
		return fName;
	}

	public SearchLeadPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnAdvanceSearch() {
		leadsLink.click();	
		advanceSearchLink.click();
	}

	
}
