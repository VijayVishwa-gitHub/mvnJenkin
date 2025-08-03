package Practicing_TestNG;

import org.testng.annotations.Test;

public class Basics {
	
	@Test(enabled = true)   
	public void keepingEnabledAsTrue() {
		System.out.println("Enabled set as true");
	}
	@Test(enabled = false)
	public void keepingEnabledAsFalse() {
		System.out.println("Enabled set as false");
	}
	
	@Test(description = "Verify 'description' functionality")
	public void usingDescription() {
	    System.out.println("Descriptions are used for comments");
	}
	@Test(priority = 1)
	public void testingPriorityAnnotation() {
		System.out.println("This will be printed 2nd");
	}
	@Test(priority = 0)
	public void testingPriorityAnnotation2() {
		System.out.println("TestNG default priority is 0");
		System.out.println("This will be printed 1st");
	}
	

}
