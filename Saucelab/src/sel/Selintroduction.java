package sel;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class Selintroduction {

	public static void main(String[] args) {
		
	//	System.setProperty("webdriver.chrome.driver", "/Users/nishapatel/Desktop/LSA/Softwares/Eclipse/chromedriver-mac-arm64");		
	WebDriver Driver = new ChromeDriver();
	Driver.manage().window().maximize();
	
	// Step 1: Navigate to the website
	Driver.get("https://www.saucedemo.com/");
	System.out.println(Driver.getTitle());
	System.out.println(Driver.getCurrentUrl());
	
	 // Step 2: Login
	Driver.findElement(By.id("user-name")).sendKeys("standard_user");
	Driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
	Driver.findElement(By.cssSelector("input#login-button")).click();
	
	 // Step 3: Add the highest price item to cart (Simple approach)
    WebElement expensiveItem = Driver.findElement(By.xpath("(//div[@class='inventory_item_price'])[last()]/following-sibling::button"));
    expensiveItem.click();
    
    // Step 4: Navigate to the cart page
    Driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
    
    
    // Verify item is added
    WebElement cartBadge = Driver.findElement(By.className("shopping_cart_badge"));
    System.out.println(cartBadge.getText().equals("1") ? "Test Passed: Item added to cart." : "Test Failed: Item was not added.");
    
	
	Driver.quit();

	}

}
