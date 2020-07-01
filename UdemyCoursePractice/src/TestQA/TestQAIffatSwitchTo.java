package TestQA;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestQAIffatSwitchTo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\\\selenium\\\\Driver\\\\chromedriver_win32 (3)\\\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		WebDriver driver = new ChromeDriver();

		driver.get("https://qa-tekarch.firebaseapp.com/");
		WebElement uname = driver.findElement(By.xpath("//*[@id='email_field']"));
		uname.sendKeys("admin123@gmail.com");
		WebElement pwd = driver.findElement(By.xpath("//*[@id='password_field']"));
		pwd.sendKeys("admin123");
		WebElement login = driver.findElement(By.xpath("//*[@id='login_div']/button"));
		login.click();
		Thread.sleep(2000);

		Actions ac = new Actions(driver);
		WebElement alert = driver.findElement(By.cssSelector("div[class='dropdown-content'] a[href*='alert']"));
		ac.moveToElement(driver.findElement(By.cssSelector("button[class='dropbtn']"))).click(alert).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div [@class=' login']// button[contains( text(),'Window Alert')]")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();

		driver.findElement(By.xpath("//div [@class=' login']//button[contains(text(),'Promt Alert')]")).click();
		driver.switchTo().alert().sendKeys("rabia");
		driver.switchTo().alert().accept();

		Dimension Size = driver.findElement(By.cssSelector("div[id='overflowTest'] ")).getSize();
		System.out.println(Size);
		// WebElement
		// container=driver.findElement(By.cssSelector("div[id='overflowTest'] "));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("document.getElementById(id='overflowTest').scrollBy(0,100)");
		String Script = "return document.getElementById('overflowTest').textContent";

		String Text = (String) js.executeScript(Script);
		System.out.println(Text);
		driver.findElement(By.xpath("//div[@id=\"overflowTest\"]//button")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		driver.close();

	}

}
