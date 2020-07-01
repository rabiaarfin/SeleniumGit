package TestQA;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class TestQAIffatWidgetTable {

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

		ac.moveToElement(driver.findElement(By.xpath("//div[@class='dropdown'][3]"))).build().perform();
		driver.findElement(By.xpath("//div[@class='dropdown'][3]//a[1]")).click();
		Thread.sleep(1000);
		WebElement table=driver.findElement(By.cssSelector("table"));
		List<WebElement> col=driver.findElements(By.tagName("th"));
		List<WebElement> Row=table.findElements(By.tagName("tr"));
		int headerIndex=0;
		for(int i=0; i<col.size(); i++) {
			String FirstName=driver.findElements(By.tagName("th")).get(i).getText();
			if(FirstName.contentEquals("First Name")) {
				headerIndex=i;
				break;
				}

			}
		for(int j=2; j<Row.size(); j++) {
			String name=table.findElement(By.xpath("//tr["+j+"]//td["+(headerIndex+1)+"]")).getText();
			if(name.contentEquals("Swapnil")) {
				System.out.println(table.findElement(By.xpath("//tr["+j+"]")).getText());
				break;
			}
			

		}

			driver.close();
	}

}
