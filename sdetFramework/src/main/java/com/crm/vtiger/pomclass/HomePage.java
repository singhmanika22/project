package com.crm.vtiger.pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class HomePage extends WebDriverUtility{
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminstratorIMG;
	
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signOutLink;

	public WebElement getAdminstratorIMG() {
		return adminstratorIMG;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}

	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}
	/**
	 * click on organization link
	 */
	public OrganizationPage clickOnOrganizationLink() {
		organizationLink.click();
		return new OrganizationPage(driver);
	}
	/**
	 * click on contact link
	 */
	public void clickOnContactLink() {
		contactLink.click();
	}
	/**
	 * Signout from app
	 */
	public void signOut() {
		mouseOver(driver, adminstratorIMG);
		signOutLink.click();
	}

}
