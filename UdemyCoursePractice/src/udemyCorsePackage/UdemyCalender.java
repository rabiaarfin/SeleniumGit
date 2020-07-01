package udemyCorsePackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UdemyCalender {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\\\selenium\\\\Driver\\\\chromedriver_win32 (3)\\\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		WebDriver driver = new ChromeDriver();
		driver.get("https://book.spicejet.com/");
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
//-------------button-------------
		System.out.println(driver.findElement(By.xpath("//div[@id='marketDate_1']/button")).getTagName());
		driver.findElement(By.xpath("//div[@id='marketDate_1']/button")).click();
//---------------------year--------------------------------------		
		String year = driver.findElement(By.xpath(
				"//div[@class='ui-datepicker-group ui-datepicker-group-last']//div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-right']//div[@class='ui-datepicker-title']//span[@class='ui-datepicker-year']"))
				.getText();

		System.out.println("first time year=  " + year);
		while (!(year.contains("2021"))) {
			driver.findElement(By.cssSelector("[class='ui-icon ui-icon-circle-triangle-e']")).click();
			year = driver.findElement(By.xpath(
					"//div[@class='ui-datepicker-group ui-datepicker-group-last']//div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-right']//div[@class='ui-datepicker-title']//span[@class='ui-datepicker-year']"))
					.getText();
		}

		System.out.println(year);
//--------------------month----------------------------------------		
		String month = driver.findElement(By.xpath(
				"//div[@class='ui-datepicker-group ui-datepicker-group-last']//div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-right']//div[@class='ui-datepicker-title']//span[@class='ui-datepicker-month']"))
				.getText();
		System.out.println(month);

		while (!(month.contains("April"))) {
			driver.findElement(By.cssSelector("[class='ui-icon ui-icon-circle-triangle-e']")).click();
			month = driver.findElement(By.xpath(
					"//div[@class='ui-datepicker-group ui-datepicker-group-last']//div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-right']//div[@class='ui-datepicker-title']//span[@class='ui-datepicker-month']"))
					.getText();
		}

		List<WebElement> count = driver.findElements(By.xpath(
				"//div[@class='ui-datepicker-group ui-datepicker-group-last']//table[@class='ui-datepicker-calendar']//tr//td//a[@class='ui-state-default']"));

		for (int i = 0; i < count.size(); i++) {

			String value = driver.findElements(By.xpath(
					"//div[@class='ui-datepicker-group ui-datepicker-group-last']//table[@class='ui-datepicker-calendar']//tr//td//a[@class='ui-state-default']"))
					.get(i).getText();
			if (value.contains("17")) {

				driver.findElements(By.xpath(
						"//div[@class='ui-datepicker-group ui-datepicker-group-last']//table[@class='ui-datepicker-calendar']//tr//td//a[@class='ui-state-default']"))
						.get(i).click();
				break;
			}
		}
		// driver.close();

	}// end main

}// end class
