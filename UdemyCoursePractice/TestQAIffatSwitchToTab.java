package udemyCorsePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class TestQAIffatSwitchToTab {


	private static final String Integer = null;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\\\selenium\\\\Driver\\\\chromedriver_win32 (3)\\\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		WebDriver driver = new ChromeDriver();
		// driver.get("https://qa-tekarch.firebaseapp.com/draganddrop.html");

		driver.get("https://qa-tekarch.firebaseapp.com/");
		WebElement uname = driver.findElement(By.xpath("//*[@id='email_field']"));
		uname.sendKeys("admin123@gmail.com");
		WebElement pwd = driver.findElement(By.xpath("//*[@id='password_field']"));
		pwd.sendKeys("admin123");
		WebElement login = driver.findElement(By.xpath("//*[@id='login_div']/button"));
		login.click();
		Thread.sleep(2000);
		Actions ac = new Actions(driver);

		WebElement drag = driver.findElement(By.cssSelector("div[class='dropdown-content'] a[href*='drag']"));
		ac.moveToElement(
				driver.findElement(By.xpath("//div[@class='dropdown']//button[contains(text(),'Intractions')]")))
				.click(drag).build().perform();
		/*JavascriptExecutor js=(JavascriptExecutor)driver;
		String Script="return document.getElementById(id='div1');";
		String Text=(String)js.executeScript(Script);
		System.out.println(Text);
	*/
		WebElement source = driver.findElement(By.xpath("//div[@class='container']//img"));
		System.out.println(source.getAttribute("width"));
		WebElement target = driver.findElement(By.cssSelector("div[id='div1']:nth-child(1)"));
		System.out.println(target.getText());

	//	ac.dragAndDrop(source, target).build().perform();
        ac.clickAndHold(source).moveToElement(target).release().build().perform();
		//driver.close();
	}

}
