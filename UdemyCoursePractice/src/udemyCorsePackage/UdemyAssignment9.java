package udemyCorsePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UdemyAssignment9 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\\\selenium\\\\Driver\\\\chromedriver_win32 (3)\\\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		WebElement country=driver.findElement(By.xpath("//input[@autocomplete]"));
		country.sendKeys("uni");
		country.sendKeys(Keys.DOWN);
		System.out.println(country.getText());
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String Script="return document.getElementById(\"autocomplete\").value;";
		String text=(String) js.executeScript(Script);
		System.out.println(text);
		int i=0;
		while(!(text.contains("States"))) {
			i++;
			country.sendKeys(Keys.DOWN);
			 text=(String) js.executeScript(Script);
				System.out.println(text);
				if(i>10) {
					break;
				}//end if	
		}//end while

		if(i>10) {
			System.out.println("Element not found");
			
		}
		else {
			System.out.println("Element  found");

			
		}

	}

}
