package udemyCorsePackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class UdemySortingStringColumn {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\Driver\\chromedriver_win32 (3)\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		Thread.sleep(5000);

		driver.findElement(By.cssSelector("tr th:nth-child(2)")).click();
		Thread.sleep(5000);

		driver.findElement(By.cssSelector("tr th:nth-child(2)")).click();

		List<WebElement> firstColList=driver.findElements(By.cssSelector("tr td:nth-child(2)"));
		//firstColList.get(0).click();
		
		
		ArrayList<String> OrignalList=new ArrayList<String>();
		ArrayList<String> SecondList=new ArrayList<String>();

		for(int i=0; i<firstColList.size(); i++) {
			
			OrignalList.add(firstColList.get(i).getText());
			SecondList.add(i, OrignalList.get(i));
			
			System.out.println(OrignalList.get(i));
			
		}
		Collections.sort(SecondList); 	
		
		
			for(int i=0; i<SecondList.size(); i++) {	
		System.out.println(SecondList.get(i));
		}
		if(SecondList.equals(OrignalList)) {
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");

		}
	}}
		


