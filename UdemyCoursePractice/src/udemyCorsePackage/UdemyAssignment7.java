package udemyCorsePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UdemyAssignment7 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\\\selenium\\\\Driver\\\\chromedriver_win32 (3)\\\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		int row=driver.findElements(By.cssSelector("table[id='product'] tr")).size();
		System.out.println("Number of rows="+row);
		
		int column=driver.findElements(By.cssSelector("table[id='product'] tr th")).size();
		System.out.println("Number of columns= "+column);
		for(int i=0; i<column; i++) {
		String rowdata=driver.findElements(By.cssSelector("table[id='product'] tr:nth-child(3) td")).get(i).getText();
		System.out.print(rowdata+" ");
		}
		
		

	}

}
