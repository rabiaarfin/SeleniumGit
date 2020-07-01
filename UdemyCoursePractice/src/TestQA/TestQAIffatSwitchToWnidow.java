package TestQA;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestQAIffatSwitchToWnidow {

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
		WebElement window = driver.findElement(By.cssSelector("div[class='dropdown-content'] a[href*='window']"));
		ac.moveToElement(driver.findElement(By.cssSelector("button[class='dropbtn']"))).click(window).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class=' login'] //button[contains(text(),'Tab')]")).click();
		String target=driver.findElement(By.cssSelector("div[class=' login'] a[target='_blank']")).getAttribute("target");
		System.out.println(target);
		// verify that window open in new tab
		
		Set<String> NewTab=driver.getWindowHandles();
		Iterator<String> it=NewTab.iterator();
		String ParentName=it.next();
		String TabName;
		System.out.println(driver.getTitle());
		Thread.sleep(2000);

		while(it.hasNext()) {
			System.out.println(driver.getTitle());

			TabName=it.next();
			driver.switchTo().window(TabName);
			System.out.println(driver.getTitle());
			

		}
		Thread.sleep(500);
		driver.switchTo().window(ParentName);
		driver.findElement(By.xpath("//div[@class=' login'] //button[contains(text(),'Window')]")).click();
		System.out.println(driver.getTitle());
		
		if(target.equals("_blank")) {}
		System.out.println("open in new tab");

	}

}
