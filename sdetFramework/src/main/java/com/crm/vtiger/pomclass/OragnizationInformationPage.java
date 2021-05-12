package com.crm.vtiger.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author Manika
 *
 */
public class OragnizationInformationPage {
	
	public OragnizationInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement organizationInfo;
	
	@FindBy(id = "dtlview_Industry")
	private WebElement industryInfo;

	public WebElement getOrganizationInfo() {
		return organizationInfo;
	}

	public WebElement getIndustryInfo() {
		return industryInfo;
	} 
	
	
	public String getOrganizationText() {
		return organizationInfo.getText();
	}
	
	public String getIndustryText() {
		return industryInfo.getText();
	}
	

}
