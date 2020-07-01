package udemyCorsePackage;

import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UdemyEcommerece {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\Driver\\chromedriver_win32 (3)\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		//driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		String VegetableName[] = { "Cucumber", "Tomato", "Brinjal" };
		UdemyEcommerece MyProducts=new UdemyEcommerece();
		MyProducts.BuyVegetables(driver,VegetableName);
		System.out.println("Test Completed Sucessfully");
			//driver.close();

	}
	
	public void BuyVegetables(WebDriver driver,String[] VegetableName) throws InterruptedException {
		List<WebElement> product = driver.findElements(By.cssSelector("h4[class='product-name']"));

		List<String> ItemNeeded = Arrays.asList(VegetableName);
		String[] productName;
		int j = 0;
		for (int i = 0; i < product.size(); i++) {
			productName=product.get(i).getText().split("-");
			String Name=productName[0].trim();
			if (ItemNeeded.contains(Name)) {
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				j++;
				if (j >= ItemNeeded.size()) {
					break;
				}
			}

		}//end for
		driver.findElement(By.xpath("//a[@class='cart-icon']")).click();
		driver.findElement(By.xpath("//div[@class='cart-preview active']/div/button")).click();
		Thread.sleep(500);
		driver.findElement(By.cssSelector("input[class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button[class='promoBtn']")).click();
		WebDriverWait w=new WebDriverWait(driver,5);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));
		
		driver.findElement(By.xpath("//span[@class='promoInfo']"));
		driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();
		driver.findElement(By.xpath("//select/option[@value='United States']")).click();
		driver.findElement(By.cssSelector("input[class='chkAgree']")).click();

	}

}
