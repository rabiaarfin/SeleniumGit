package udemyCorsePackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AjaxExampleTest {
	public static void main(String[] args) throws InterruptedException {

System.setProperty("webdriver.chrome.driver", "C:\\\\selenium\\\\Driver\\\\chromedriver_win32 (3)\\\\chromedriver.exe");
	System.setProperty("webdriver.chrome.silentOutput", "true");
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

driver.findElement(By.id("autocomplete")).click();

driver.findElement(By.id("autocomplete")).sendKeys(Keys.chord("Uni"), Keys.DOWN);

Thread.sleep(1000);

List<WebElement> dropList = driver.findElements(By.cssSelector("li[class='ui-menu-item']"));

int listSize = dropList.size();

for (int i = 0; i < listSize; i++) {

String data = driver.findElements(By.cssSelector("li[class='ui-menu-item'] div")).get(i).getText();

if (data.equalsIgnoreCase("United States (USA)")) {

driver.findElements(By.cssSelector("li[class='ui-menu-item'] div")).get(i).click();

System.out.println(data+" selected");

break;

} else {

driver.findElement(By.id("autocomplete")).sendKeys(Keys.ARROW_DOWN);

}

}

}



}
