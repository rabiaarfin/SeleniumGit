package TestQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class TestQAIffatInteractionToolTip {



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
		WebElement mousehover = driver.findElement(By.xpath("//*[@id=\"user_div\"]/div[1]/div[2]/div/a[2]"));
		System.out.println(mousehover.getText());
		System.out.println(mousehover.getAttribute("href"));
		ac.moveToElement(mousehover).doubleClick().build().perform();
		Thread.sleep(2000);
		ac.moveToElement(driver.findElement(By.xpath("//div[@class='dropdown'][2]"))).build().perform();
		WebElement ToolTip = driver.findElement(By.xpath("//*[@id=\"user_div\"]/div[1]/div[2]/div/a[4]"));
		System.out.println(ToolTip.getText());
		ac.moveToElement(ToolTip).doubleClick().build().perform();
		Thread.sleep(2000);
		WebElement tooltipright= driver.findElement(By.xpath("//div[@class='tooltipr']"));
		ac.moveToElement(tooltipright).build().perform();
		System.out.println(driver.findElement(By.xpath("//div[@class='tooltipr']//span")).isDisplayed());
				
		//driver.close();
	}

}
