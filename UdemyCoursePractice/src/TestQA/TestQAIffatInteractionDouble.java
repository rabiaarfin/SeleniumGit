package TestQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class TestQAIffatInteractionDouble {



	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\\\selenium\\\\Driver\\\\chromedriver_win32 (3)\\\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		WebDriver driver = new ChromeDriver();
		// driver.get("https://qa-tekarch.firebaseapp.com/draganddrop.html");

		driver.get("https://qa-tekarch.firebaseapp.com/");
		driver.manage().window().maximize();

		WebElement uname = driver.findElement(By.xpath("//*[@id='email_field']"));
		uname.sendKeys("admin123@gmail.com");
		WebElement pwd = driver.findElement(By.xpath("//*[@id='password_field']"));
		pwd.sendKeys("admin123");
		WebElement login = driver.findElement(By.xpath("//*[@id='login_div']/button"));
		login.click();
		Thread.sleep(2000);
		Actions ac = new Actions(driver);

		ac.moveToElement(driver.findElement(By.xpath("//div[@class='dropdown'][2]"))).build().perform();
		WebElement double1 = driver.findElement(By.xpath("//*[@id=\"user_div\"]/div[1]/div[2]/div/a[2]"));
		System.out.println(double1.getText());
		System.out.println(double1.getAttribute("href"));
		ac.moveToElement(double1).doubleClick().build().perform();
		Thread.sleep(2000);
		ac.moveToElement(driver.findElement(By.xpath("//div[@class='dropdown'][2]"))).build().perform();
		WebElement double2 = driver.findElement(By.xpath("//*[@id=\"user_div\"]/div[1]/div[2]/div/a[3]"));
		System.out.println(double2.getText());
		System.out.println(double2.getAttribute("href"));
		ac.moveToElement(double2).doubleClick().build().perform();
		Thread.sleep(500);
		WebElement singleClickButton=driver.findElement(By.xpath("//*[@id=\"user_div\"]/div[2]/div[1]/button"));
		ac.moveToElement(singleClickButton).click().build().perform();
		WebElement doubleClickButton=driver.findElement(By.xpath("//*[@id=\"user_div\"]/div[2]/div[2]/button"));
		ac.moveToElement(doubleClickButton).doubleClick().build().perform();
	
			//driver.close();
	}

}
