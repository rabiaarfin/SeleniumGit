package udemyCorsePackage;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class HandleWindow {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\\\selenium\\\\Driver\\\\chromedriver_win32 (3)\\\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Multiple Windows")).click();
		System.out.println(driver.getTitle());

		driver.findElement(By.xpath("//div[@class='example']/a")).click();
		Set <String>windows=driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		String Parent=it.next();
		String Child=it.next();
		driver.switchTo().window(Child);
		System.out.println("Title of child window= "+driver.getTitle());
		driver.switchTo().window(Parent);
		System.out.println("Title of parent window= "+driver.getTitle());
		System.out.println("Text in Parent Window= "+driver.findElement(By.xpath("//h3")).getText());
		driver.quit();

		

	}

}
