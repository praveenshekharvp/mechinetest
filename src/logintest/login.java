package logintest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class login {
	
	ChromeDriver driver;
	@BeforeTest
	public void setup()
	{
		driver= new ChromeDriver();
	}
	
	@BeforeMethod
	public void urlloading()
	{
		driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");
	}
	@Test
	public void test()
	{
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("pravinmnz00@gmail.com",Keys.ENTER);
		driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("abc@123",Keys.ENTER);
	     driver.findElement(By.xpath("//*[@id=\"input-email\"]")).clear();
		
		driver.findElement(By.xpath("//*[@id=\"input-password\"]")).clear();
		
		driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("pravinmnz00@gmail.com",Keys.ENTER);
		driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("Praveen@33",Keys.ENTER);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/div/form/input[1]")).click();
		
		driver.navigate().refresh();
		
		String actual= driver.getPageSource();
		String expected="My Account";
		Assert.assertEquals(actual, expected);
		System.out.println("login successfully");
		
		
	}
	
	

}
