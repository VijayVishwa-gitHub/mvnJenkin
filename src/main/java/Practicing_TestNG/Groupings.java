package Practicing_TestNG;

import org.testng.annotations.Test;

public class Groupings {
	/* This class consists example for groups, dependsOnMethods, dependsOnGroups
	 * Refer testng2.xml 
	 */
	

	@Test(groups = "smoke")
	public void group1() {
		System.out.println("smoke group");
	}
	@Test(priority = 0, groups = "regression")
	public void group2() {
		System.out.println("regression group");
	}
	@Test(groups = "smoke")
	public void group3() {
		System.out.println("smoke group");
	}
	@Test(priority = 1,groups = "regression")
	public void group4() {
		System.out.println("regression group");
	}
	
	//Unsuccessful dependsOnMethods
	@Test(groups = "smoke",description = "Testing dependsON")
	public void dummyMethod() {
		int a =2;
		System.out.println(a/0);
	}
	@Test(groups = "smoke", dependsOnMethods = {"dummyMethod"}, alwaysRun = true)   //example of alwaysRun
	public void failingDependentMethod() {
		System.out.println("This will be printed because of 'alwaysRun'");
	}
	
	//successful dependsOnMethods
	@Test(priority = 3, groups = "regression",description = "Testing dependsON")
	public void dummyMethod2() {
		int a =2;
		System.out.println(a/2);
	}
	@Test(priority = 4,  groups = "regression", dependsOnMethods = {"dummyMethod2"})
	public void passingDependentMethod() {
		System.out.println("DependsOnMethods - This will be printed");
	}
	
	//successful dependsOnGroups
	@Test(priority = 5,  groups = "myGroup")
	public void passingGroup() {
		System.out.println("Hey there!!");
	}
	@Test(priority = 6,  groups = "regression", dependsOnGroups = {"myGroup"})
	public void passingDependentGroup() {
		System.out.println("DependsOnGroup - This will be printed");
	}



}
