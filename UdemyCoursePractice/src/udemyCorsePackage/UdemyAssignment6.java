package udemyCorsePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class UdemyAssignment6 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\\\selenium\\\\Driver\\\\chromedriver_win32 (3)\\\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	driver.findElement(By.xpath("//label[@for='benz']/input")).click();
	String lableValue=driver.findElement(By.xpath("//label[@for='benz']")).getText();
	System.out.println(lableValue);
	Select sel=new Select(driver.findElement(By.cssSelector("select[id='dropdown-class-example']")));
	sel.selectByVisibleText(lableValue);
	driver.findElement(By.cssSelector("input[id='name']")).sendKeys(lableValue);
	driver.findElement(By.cssSelector("input[id='alertbtn']")).click();
	String alertText=driver.switchTo().alert().getText();	
	System.out.println(alertText);
	if (alertText.contains(lableValue)) {
		System.out.println("Test Pass");
	}
	
	 

	}

}
