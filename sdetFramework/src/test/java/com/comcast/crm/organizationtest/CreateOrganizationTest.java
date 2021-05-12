package com.comcast.crm.organizationtest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.GenericUtils.JavaUtility;
import com.crm.vtiger.pomclass.CreateOrganizationPage;
import com.crm.vtiger.pomclass.HomePage;
import com.crm.vtiger.pomclass.OragnizationInformationPage;
import com.crm.vtiger.pomclass.OrganizationPage;

public class CreateOrganizationTest extends BaseClass{

	@Test(groups = "smokeTest")
	public void createOrganizationTest() throws Throwable
	{
		String orgName=eUtil.getExcelData("org", 1, 2)+"_"+JavaUtility.getRandomData();
		homePage=new HomePage(driver);
		OragnizationInformationPage orgInfoPage = homePage.clickOnOrganizationLink()
				.clickOnCreateOrganizationIMG()
				.createOrganization(orgName);
		String actualOrgName=orgInfoPage.getOrganizationText();
		Assert.assertTrue(actualOrgName.contains(orgName));
	}

	@Test(groups = "regressionTest" )
	public void createOrgWithIndustryTest() throws Throwable
	{
		String orgName=eUtil.getExcelData("org", 4, 2)+"_"+JavaUtility.getRandomData();
		String industryType=eUtil.getExcelData("org", 4, 3);
		//Navigate to organizations
		homePage.clickOnOrganizationLink();
		//create organization
		OrganizationPage orgPage=new OrganizationPage(driver);
		orgPage.clickOnCreateOrganizationIMG();
		CreateOrganizationPage createOrgPage=new CreateOrganizationPage(driver);
		createOrgPage.createOrganization(orgName, industryType);
		//verification
		OragnizationInformationPage orgInfoPage=new OragnizationInformationPage(driver);
		String actualOrgName=orgInfoPage.getOrganizationText();
		Assert.assertTrue(actualOrgName.contains(orgName));
		String actualIndustryType=orgInfoPage.getIndustryText();
		Assert.assertEquals(actualIndustryType, industryType);
	}


}
