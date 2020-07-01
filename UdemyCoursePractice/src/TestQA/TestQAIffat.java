package TestQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestQAIffat {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\\\selenium\\\\Driver\\\\chromedriver_win32 (3)\\\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		 driver.get("https://qa-tekarch.firebaseapp.com/");
		 WebElement uname=driver.findElement(By.xpath("//*[@id='email_field']"));
		 uname.sendKeys("admin123@gmail.com");
		 WebElement pwd=driver.findElement(By.xpath("//*[@id='password_field']"));
		 pwd.sendKeys("admin123");
		 WebElement login=driver.findElement(By.xpath("//*[@id='login_div']/button"));
		 login.click();
			Thread.sleep(2000);

	driver.findElement(By.xpath("//input[@id='name']")).sendKeys("abc");
	driver.findElement(By.cssSelector("input[value='female']")).click();
	Select s=new Select(driver.findElement(By.cssSelector("select[id='city']")));
	s.selectByValue("mumbai");
	System.out.println(s.getFirstSelectedOption().getText());

	driver.findElement(By.cssSelector("button[class='bootbutton']")).click();
	
	
driver.close();
	

			



		
	}

}
