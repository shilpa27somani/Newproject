package Project_Demo;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import Utility.GenericUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Main {
	public static GenericUtility ge = new GenericUtility();
	//SINGLE NIGHT SINGLE ROOM
	@Test
	public void test() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		ChromeDriver driver=new ChromeDriver(ops);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.mybookingsite.io/inst/#home?propertyId=881Ig8qRvy312GgLYBSOJLr5FxEi22ufAv05AJ5x4ss91i3FjUxOTY2NiI=&JDRN=Y");
		driver.manage().window().maximize();

        try {
            // Attempt to interact with an element
            WebElement element = driver.findElement(By.xpath("//*[@class=\"btn-close\"]"));
            element.click();
        } 
        catch (Exception e ) {
            System.out.println("No alert");
        }
		
        JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement CheckinDate = driver.findElement(By.xpath("//*[@id=\"start-Date-Input\"]"));
	    ge.ClickByJS(driver, CheckinDate);
		ge.CheckINOUTDateProvider(driver, "Oct 2023", "10", "Oct 2023", "11");
			
		
		}
}
