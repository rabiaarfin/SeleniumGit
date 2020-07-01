package udemyCorsePackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UdemyAssignment5 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\\\selenium\\\\Driver\\\\chromedriver_win32 (3)\\\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//a[contains(text(),'Nested Frames')]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("Main Frames= "+driver.findElements(By.xpath("//frame")).size());
		driver.switchTo().frame(driver.findElement(By.name("frame-top")));
		System.out.println("Frames in top Frame= "+driver.findElements(By.xpath("//frame")).size());
		driver.switchTo().frame(driver.findElement(By.name("frame-middle")));
		System.out.println("First Frame in top Frame= "+driver.findElement(By.xpath("//body//div[@id='content']")).getText());
		
		driver.close();
	}

}
