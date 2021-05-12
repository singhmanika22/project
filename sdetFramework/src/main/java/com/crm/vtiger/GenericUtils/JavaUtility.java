package com.crm.vtiger.GenericUtils;

import java.util.Date;
import java.util.Random;

/**
 * This class contains java specific generic libraries
 * @author Manika
 */

public class JavaUtility {
	
	/**
	 * generate random number 
	 * @author Manika
	 * 
	 */
	public static String getRandomData()
	{
		Random random=new Random();
		int ran=random.nextInt(1000);
		return ""+ran;			
	}
	
	/**
	 * Generate current system date
	 * @author Manika
	 */
	public String getCurrentSystemDate()
	{
		//2021-05-12 00:27:30
		Date date = new Date();
		String currentDate=date.toString();
		return "2021-05-12";
		
	}
	
	public static void main(String args[]) {
		Date date = new Date();
		String currentDate=date.getYear()+"-"+date.getMonth()+
				"-"+ date.getDate()+" "+ date.getHours()+
				":"+date.getMinutes()+":"+date.getSeconds();
	    System.out.println(" ff  "+currentDate);
	}

}
