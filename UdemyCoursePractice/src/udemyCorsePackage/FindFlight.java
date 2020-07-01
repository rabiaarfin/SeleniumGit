package udemyCorsePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindFlight {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\Driver\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		WebDriver driver = new ChromeDriver();
		driver.get("https://book.spicejet.com/");

		WebElement OneWay = driver.findElement(
				By.cssSelector("input[id='ControlGroupSearchView_AvailabilitySearchInputSearchView_OneWay']"));
		boolean selectRadio = OneWay.isSelected();
		System.out.println(selectRadio);
		if (selectRadio == false)
			OneWay.click();
		// ----------------------------------select destination----------------------
		System.out.println("first city");
		Thread.sleep(100);
		driver.findElement(By
				.cssSelector("input[id='ControlGroupSearchView_AvailabilitySearchInputSearchVieworiginStation1_CTXT']"))
				.click();
		driver.findElement(By.xpath("//a[@ value='MAA']")).click();
		System.out.println("second city");
		driver.findElement(By.xpath(
				"//div[@ id='glsControlGroupSearchView_AvailabilitySearchInputSearchViewdestinationStation1_CTNR'] //a[@ value='BLR']"))
				.click();
		System.out.println("calender");

		// -----------------calender------------------

		Thread.sleep(500);
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();

		// ------------------------------Select Passenger-----------------

		driver.findElement(By.xpath("//div[@ id='divpaxinfo']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath(
				"//select[@ id='ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListPassengerType_ADT']"))
				.click();
		driver.findElement(By.xpath(
				"//select[@ id='ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListPassengerType_ADT']//option[3]"))
				.click();
		System.out.println("select Adult");
		// Thread.sleep(100);
		driver.findElement(By.cssSelector(
				"select[id='ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListPassengerType_CHD'] [value='3']"))
				.click();

		// -------------------search---------------
		driver.findElement(
				By.cssSelector("input[id='ControlGroupSearchView_AvailabilitySearchInputSearchView_ButtonSubmit']"))
				.click();

	}

}
