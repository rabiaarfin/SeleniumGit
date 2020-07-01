package udemyCorsePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecuter {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\\\selenium\\\\Driver\\\\chromedriver_win32 (3)\\\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		WebDriver driver = new ChromeDriver();
		driver.get("https://ksrtc.in/oprs-web/");
		driver.manage().window().maximize();
		WebElement FromPlace=driver.findElement(By.xpath("//input[@id='fromPlaceName']"));
		//FromPlace.click();
		FromPlace.sendKeys("BAN");
		FromPlace.sendKeys(Keys.DOWN);
		//FromPlace.sendKeys(Keys.DOWN);

		JavascriptExecutor js=(JavascriptExecutor)driver;
		String Script="return document.getElementById(id=\"fromPlaceName\").value;";
		String Text=(String)js.executeScript(Script);
		int i=0;
	
	while(!Text.equalsIgnoreCase("BANGALORE AIRPORT"))
		{
		i++;
			FromPlace.sendKeys(Keys.DOWN);
			Script="return document.getElementById(id=\"fromPlaceName\").value;";
			Text=(String)js.executeScript(Script);
			
			System.out.println(Text);
			if(i>10){
				break;
				
			}
	
}
if(i>10) {
	System.out.println("Element not found");
}
else
{
	System.out.println("Element found");
}
		
	}

}
