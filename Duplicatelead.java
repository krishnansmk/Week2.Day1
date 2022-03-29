package week2.day1assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Duplicatelead 
{

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		
		//enter user credentials and login to the application.
		driver.findElement(By.id("username")).sendKeys("DemoCSR");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		
		//Enter lead info to create a new one
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLead01");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Riyha");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Mohanakrishnan");
		
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("TestleadLocal");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Information Technology");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("About Testlead and his department");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("testlead@gmail.com");
		
		//select "New york" from state/province drop down
		WebElement webobj=driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select selobj=new Select(webobj);
		selobj.selectByVisibleText("New York");
		
		//click on 'Create Lead' button.
		driver.findElement(By.className("smallSubmit")).click();
		
		//Click on the Duplicate Lead button
		driver.findElement(By.linkText("Duplicate Lead")).click();
		
		//Re-enter new company name and firstname
		driver.findElement(By.id("createLeadForm_companyName")).clear();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Revised Comp name");
		driver.findElement(By.id("createLeadForm_firstName")).clear();
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Rithika");
		driver.findElement(By.className("smallSubmit")).click();		
		
		//Retrieve the title of the page
		System.out.println("The title of current page is..."+driver.getTitle());

	}

}
