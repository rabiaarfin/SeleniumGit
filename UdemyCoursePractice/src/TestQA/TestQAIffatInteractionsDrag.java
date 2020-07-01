package TestQA;

import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestQAIffatInteractionsDrag {

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
		WebElement tab = driver.findElement(By.cssSelector("div[class='dropdown-content'] a[href*='tab']"));
		ac.moveToElement(driver.findElement(By.cssSelector("button[class='dropbtn']"))).click(tab).build().perform();
		Thread.sleep(500);
		List<WebElement> Tab = driver.findElements(By.cssSelector("div[class='tab'] button"));
		Iterator<WebElement> it = Tab.iterator();
		WebElement city;
		while (it.hasNext()) {
			city = it.next();
			Thread.sleep(500);
			city.click();

			if (city.getAttribute("class").equalsIgnoreCase("tablinks active")) {
				System.out.println(driver
						.findElement(By.cssSelector("div[style='padding: 40px;'] div[style='display: block;'] h3"))
						.getText());

				System.out.println(
						driver.findElement(By.cssSelector("div[style='padding: 40px;'] div[style='display: block;'] p"))
								.getText());

			}
			System.out.println("------------------------------------------");
		}
		driver.close();

	}

}
