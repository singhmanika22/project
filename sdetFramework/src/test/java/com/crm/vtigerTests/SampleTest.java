package com.crm.vtigerTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;

public class SampleTest extends BaseClass{

	
	@Test
	public void createOrg() {
		System.out.println("execute creatOrg");	
		Assert.assertFalse(false);
	}
	
	@Test
    public void createOrgWithInd() {
		System.out.println("execute createOrgWithInd");	
		Assert.assertFalse(true);
	}
}
