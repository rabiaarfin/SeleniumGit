package udemyCorsePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandlingFrame {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\\\selenium\\\\Driver\\\\chromedriver_win32 (3)\\\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
		WebElement Movingobject=driver.findElement(By.id("draggable"));
		WebElement TargetObject=driver.findElement(By.cssSelector("div[id='droppable']"));
		System.out.println(Movingobject.getText());
		Actions moveMe=new Actions(driver);
		moveMe.dragAndDrop(Movingobject, TargetObject).build().perform();
		driver.close();
	} 

}
