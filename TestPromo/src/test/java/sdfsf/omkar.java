package sdfsf;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Utility.GenericUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class omkar {
	public static GenericUtility ge = new GenericUtility();
//Single_night_single_Room
	
	@Test
	public void test() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		ChromeDriver driver=new ChromeDriver(ops);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.mybookingsite.io/2/#/home?propertyId=519231");
		driver.manage().window().maximize();
		
		
	        JavascriptExecutor js=(JavascriptExecutor)driver;
			WebElement CheckinDate = driver.findElement(By.xpath("(//*[@class=\"whitespace-nowrap flex items-center\"])[2]"));
		    ge.ClickByJS(driver, CheckinDate);
			ge.CheckINOUTDateProvider(driver, "Oct 2023", "8", "Oct 2023", "9");
			driver.findElement(By.xpath("//*[@id=\"radioDefault01\"]")).click();
			driver.findElement(By.xpath("//*[@class=\"text-center mt-6\"]")).click();
			 JavascriptExecutor DwonScroll = (JavascriptExecutor) driver;
		     DwonScroll.executeScript("window.scrollBy(0,1000)");
		     driver.findElement(By.xpath("(//*[@type=\"text\"])[1]")).sendKeys("Shilpa");
		     driver.findElement(By.xpath("(//*[@type=\"text\"])[2]")).sendKeys("Somani");
		     
		     driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("shilpasomani2792@gmail.com");
		     driver.findElement(By.xpath("(//*[@type=\"text\"])[4]")).sendKeys("8600207649");
		    WebElement Booknow= driver.findElement(By.xpath("//button[@class=\"bookBtnBg px-4 py-2 text-white rounded transition mt-3 disabled:opacity-50\"]"));
            ge.ClickByJS(driver, Booknow);
            WebElement ConfirmButton=driver.findElement(By.xpath("//button[text()='Confirm']"));
            ge.ClickByJS(driver, ConfirmButton);
            WebElement ConfirmButton2=driver.findElement(By.xpath("(//button[text()='Confirm Booking'])[2]"));
            ge.ClickByJS(driver, ConfirmButton2);

            driver.findElement(By.xpath("//*[@id=\"cc_number\"]")).sendKeys("5267 3181 8797 5449");
            WebElement month= driver.findElement(By.xpath("(//*[@id=\"dropdownMenuButton1\"])[1]"));
             ge.ClickByJS(driver, month);
             driver.findElement(By.xpath("//*[@id=\"MM7\"]")).click();
             WebElement year = driver.findElement(By.xpath("(//*[@id=\"dropdownMenuButton1\"])[2]"));
             ge.ClickByJS(driver, year);
             driver.findElement(By.xpath("//*[@id=\"2026\"]")).click();
             driver.findElement(By.xpath("//*[@id=\"cvv\"]")).sendKeys("987");
             driver.findElement(By.xpath("//*[@id=\"btn1\"]")).click();
	}        
  //Multiple Night single room 
             
    @Test
    public void Multiple_night_Booking() throws InterruptedException {
    	
    	WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		ChromeDriver driver=new ChromeDriver(ops);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.mybookingsite.io/2/#/home?propertyId=519231");
		driver.manage().window().maximize();
		
		
	        JavascriptExecutor js=(JavascriptExecutor)driver;
			WebElement CheckinDate = driver.findElement(By.xpath("(//*[@class=\"whitespace-nowrap flex items-center\"])[2]"));
		    ge.ClickByJS(driver, CheckinDate);
			ge.CheckINOUTDateProvider(driver, "Oct 2023", "7", "Oct 2023", "9");
			driver.findElement(By.xpath("//*[@id=\"radioDefault01\"]")).click();
			driver.findElement(By.xpath("//*[@class=\"text-center mt-6\"]")).click();
			 JavascriptExecutor DwonScroll = (JavascriptExecutor) driver;
		     DwonScroll.executeScript("window.scrollBy(0,1000)");
		     driver.findElement(By.xpath("(//*[@type=\"text\"])[1]")).sendKeys("Shilpa");
		     driver.findElement(By.xpath("(//*[@type=\"text\"])[2]")).sendKeys("Somani");
		     
		     driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("shilpasomani2792@gmail.com");
		     driver.findElement(By.xpath("(//*[@type=\"text\"])[4]")).sendKeys("8600207649");
		    WebElement Booknow= driver.findElement(By.xpath("//button[@class=\"bookBtnBg px-4 py-2 text-white rounded transition mt-3 disabled:opacity-50\"]"));
            ge.ClickByJS(driver, Booknow);
            WebElement ConfirmButton=driver.findElement(By.xpath("//button[text()='Confirm']"));
            ge.ClickByJS(driver, ConfirmButton);
            WebElement ConfirmButton2=driver.findElement(By.xpath("(//button[text()='Confirm Booking'])[2]"));
            ge.ClickByJS(driver, ConfirmButton2);

            driver.findElement(By.xpath("//*[@id=\"cc_number\"]")).sendKeys("5267 3181 8797 5449");
            WebElement month= driver.findElement(By.xpath("(//*[@id=\"dropdownMenuButton1\"])[1]"));
             ge.ClickByJS(driver, month);
             driver.findElement(By.xpath("//*[@id=\"MM7\"]")).click();
             WebElement year = driver.findElement(By.xpath("(//*[@id=\"dropdownMenuButton1\"])[2]"));
             ge.ClickByJS(driver, year);
             driver.findElement(By.xpath("//*[@id=\"2026\"]")).click();
             driver.findElement(By.xpath("//*[@id=\"cvv\"]")).sendKeys("987");
             driver.findElement(By.xpath("//*[@id=\"btn1\"]")).click();
             //second_room
             driver.findElement(By.xpath("//*[@id=\"radioDefault01\"]")).click();
             
    	
    }
            	
            	
  @Test
   public void Single_night_multipleRoom () throws InterruptedException {
	   WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		ChromeDriver driver=new ChromeDriver(ops);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.mybookingsite.io/2/#/home?propertyId=519231");
		driver.manage().window().maximize();
		
		
	        JavascriptExecutor js=(JavascriptExecutor)driver;
			WebElement CheckinDate = driver.findElement(By.xpath("(//*[@class=\"whitespace-nowrap flex items-center\"])[2]"));
			ge.ClickByJS(driver, CheckinDate);
			ge.CheckINOUTDateProvider(driver, "Oct 2023", "10", "Oct 2023", "11");
			driver.findElement(By.xpath("//*[@id=\"radioDefault01\"]")).click();
			driver.findElement(By.xpath("//*[@class=\"text-center mt-6\"]")).click();
			 JavascriptExecutor DwonScroll = (JavascriptExecutor) driver;
		     DwonScroll.executeScript("window.scrollBy(0,1000)");
		     driver.findElement(By.xpath("(//*[@type=\"text\"])[1]")).sendKeys("Shilpa");
		     driver.findElement(By.xpath("(//*[@type=\"text\"])[2]")).sendKeys("Somani");
		     
		     driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("shilpasomani2792@gmail.com");
		     driver.findElement(By.xpath("(//*[@type=\"text\"])[4]")).sendKeys("8600207649");
		    WebElement Booknow= driver.findElement(By.xpath("//button[@class=\"bookBtnBg px-4 py-2 text-white rounded transition mt-3 disabled:opacity-50\"]"));
            ge.ClickByJS(driver, Booknow);
            WebElement secondRoom= driver.findElement(By.xpath(" (//*[@class=\"flex\"])[2]"));
            ge.ClickByJS(driver,secondRoom );
           WebElement Proceed= driver.findElement(By.xpath("//*[text()='Proceed']"));
            ge.ClickByJS(driver,Proceed );
            driver.findElement(By.xpath("(//*[@type=\"text\"])[1]")).sendKeys("Shilpa");
		     driver.findElement(By.xpath("(//*[@type=\"text\"])[2]")).sendKeys("Somani");
		     
		     driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("shilpasomani2792@gmail.com");
		     driver.findElement(By.xpath("(//*[@type=\"text\"])[4]")).sendKeys("8600207649");
		     WebElement Booknow1= driver.findElement(By.xpath("//button[@class=\"bookBtnBg px-4 py-2 text-white rounded transition mt-3 disabled:opacity-50\"]"));
	            ge.ClickByJS(driver, Booknow1);
	            WebElement ConfirmButton=driver.findElement(By.xpath("//button[text()='Confirm']"));
	            ge.ClickByJS(driver, ConfirmButton);
	            WebElement ConfirmButton2=driver.findElement(By.xpath("(//button[text()='Confirm Booking'])[2]"));
	            ge.ClickByJS(driver, ConfirmButton2);

	            driver.findElement(By.xpath("//*[@id=\"cc_number\"]")).sendKeys("5267 3181 8797 5449");
	            WebElement month= driver.findElement(By.xpath("(//*[@id=\"dropdownMenuButton1\"])[1]"));
	             ge.ClickByJS(driver, month);
	             driver.findElement(By.xpath("//*[@id=\"MM7\"]")).click();
	             WebElement year = driver.findElement(By.xpath("(//*[@id=\"dropdownMenuButton1\"])[2]"));
	             ge.ClickByJS(driver, year);
	             driver.findElement(By.xpath("//*[@id=\"2026\"]")).click();
	             driver.findElement(By.xpath("//*[@id=\"cvv\"]")).sendKeys("987");
	             driver.findElement(By.xpath("//*[@id=\"btn1\"]")).click();
	             //second_room
	             driver.findElement(By.xpath("//*[@id=\"radioDefault01\"]")).click();
          			
			
   }
            	
            	
     @Test
     
     public void Multipleroom_mutipleNigt() throws InterruptedException {
    	 
    	  WebDriverManager.chromedriver().setup();
  		ChromeOptions ops = new ChromeOptions();
  		ops.addArguments("--remote-allow-origins=*");
  		ChromeDriver driver=new ChromeDriver(ops);
  		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  		
  		driver.get("https://www.mybookingsite.io/2/#/home?propertyId=519231");
  		driver.manage().window().maximize();
  		
  		
  	        JavascriptExecutor js=(JavascriptExecutor)driver;
  			WebElement CheckinDate = driver.findElement(By.xpath("(//*[@class=\"whitespace-nowrap flex items-center\"])[2]"));
  			ge.ClickByJS(driver, CheckinDate);
  			ge.CheckINOUTDateProvider(driver, "Oct 2023", "4", "Oct 2023", "5");
  			driver.findElement(By.xpath("//*[@id=\"radioDefault01\"]")).click();
  			driver.findElement(By.xpath("//*[@class=\"text-center mt-6\"]")).click();
  			 JavascriptExecutor DwonScroll = (JavascriptExecutor) driver;
  		     DwonScroll.executeScript("window.scrollBy(0,1000)");
  		     driver.findElement(By.xpath("(//*[@type=\"text\"])[1]")).sendKeys("Shilpa");
  		     driver.findElement(By.xpath("(//*[@type=\"text\"])[2]")).sendKeys("Somani");
  		     
  		     driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("shilpasomani2792@gmail.com");
  		     driver.findElement(By.xpath("(//*[@type=\"text\"])[4]")).sendKeys("8600207649");
  		    WebElement Booknow= driver.findElement(By.xpath("//button[@class=\"bookBtnBg px-4 py-2 text-white rounded transition mt-3 disabled:opacity-50\"]"));
              ge.ClickByJS(driver, Booknow);
              WebElement secondRoom= driver.findElement(By.xpath(" (//*[@class=\"flex\"])[2]"));
              ge.ClickByJS(driver,secondRoom );
             WebElement Proceed= driver.findElement(By.xpath("//*[text()='Proceed']"));
              ge.ClickByJS(driver,Proceed );
              driver.findElement(By.xpath("(//*[@type=\"text\"])[1]")).sendKeys("Shilpa");
  		     driver.findElement(By.xpath("(//*[@type=\"text\"])[2]")).sendKeys("Somani");
  		     
  		     driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("shilpasomani2792@gmail.com");
  		     driver.findElement(By.xpath("(//*[@type=\"text\"])[4]")).sendKeys("8600207649");
  		     WebElement Booknow1= driver.findElement(By.xpath("//button[@class=\"bookBtnBg px-4 py-2 text-white rounded transition mt-3 disabled:opacity-50\"]"));
  	            ge.ClickByJS(driver, Booknow1);
  	            WebElement ConfirmButton=driver.findElement(By.xpath("//button[text()='Confirm']"));
  	            ge.ClickByJS(driver, ConfirmButton);
  	            WebElement ConfirmButton2=driver.findElement(By.xpath("(//button[text()='Confirm Booking'])[2]"));
  	            ge.ClickByJS(driver, ConfirmButton2);

  	            driver.findElement(By.xpath("//*[@id=\"cc_number\"]")).sendKeys("5267 3181 8797 5449");
  	            WebElement month= driver.findElement(By.xpath("(//*[@id=\"dropdownMenuButton1\"])[1]"));
  	             ge.ClickByJS(driver, month);
  	             driver.findElement(By.xpath("//*[@id=\"MM7\"]")).click();
  	             WebElement year = driver.findElement(By.xpath("(//*[@id=\"dropdownMenuButton1\"])[2]"));
  	             ge.ClickByJS(driver, year);
  	             driver.findElement(By.xpath("//*[@id=\"2026\"]")).click();
  	             driver.findElement(By.xpath("//*[@id=\"cvv\"]")).sendKeys("987");
  	             driver.findElement(By.xpath("//*[@id=\"btn1\"]")).click();
  	             //second_room
  	             driver.findElement(By.xpath("//*[@id=\"radioDefault01\"]")).click();
    	 
     } 
	
     
     @Test
     public void testaa() throws InterruptedException {

 		WebDriverManager.chromedriver().setup();
 		ChromeOptions ops = new ChromeOptions();
 		ops.addArguments("--remote-allow-origins=*");
 		ChromeDriver driver=new ChromeDriver(ops);
 		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 		
 		driver.get("https://www.mybookingsite.io/2/#/home?propertyId=519231");
 		driver.manage().window().maximize();
 		
 		
 	        JavascriptExecutor js=(JavascriptExecutor)driver;
 			WebElement CheckinDate = driver.findElement(By.xpath("(//*[@class=\"whitespace-nowrap flex items-center\"])[2]"));
 		    ge.ClickByJS(driver, CheckinDate);
 			ge.CheckINOUTDateProvider(driver, "Oct 2023", "8", "Oct 2023", "9");
//		driver.findElement(By.xpath("//*[@id=\"radioDefault01\"]")).click();
//		driver.findElement(By.xpath("//*[@class=\"text-center mt-6\"]")).click();
//		 JavascriptExecutor DwonScroll = (JavascriptExecutor) driver;
//	     DwonScroll.executeScript("window.scrollBy(0,1000)");
//	     driver.findElement(By.xpath("(//*[@type=\"text\"])[1]")).sendKeys("Shilpa");
//	     driver.findElement(By.xpath("(//*[@type=\"text\"])[2]")).sendKeys("Somani");
//	     
//	     driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("shilpasomani2792@gmail.com");
//	     driver.findElement(By.xpath("(//*[@type=\"text\"])[4]")).sendKeys("8600207649");
//	    WebElement Booknow= driver.findElement(By.xpath("//button[@class=\"bookBtnBg px-4 py-2 text-white rounded transition mt-3 disabled:opacity-50\"]"));
//      ge.ClickByJS(driver, Booknow);
//      WebElement ConfirmButton=driver.findElement(By.xpath("//button[text()='Confirm']"));
//      ge.ClickByJS(driver, ConfirmButton);
//      WebElement ConfirmButton2=driver.findElement(By.xpath("(//button[text()='Confirm Booking'])[2]"));
//      ge.ClickByJS(driver, ConfirmButton2);
//
//      driver.findElement(By.xpath("//*[@id=\"cc_number\"]")).sendKeys("5267 3181 8797 5449");
//      WebElement month= driver.findElement(By.xpath("(//*[@id=\"dropdownMenuButton1\"])[1]"));
//       ge.ClickByJS(driver, month);
//       driver.findElement(By.xpath("//*[@id=\"MM7\"]")).click();
//       WebElement year = driver.findElement(By.xpath("(//*[@id=\"dropdownMenuButton1\"])[2]"));
//       ge.ClickByJS(driver, year);
//       driver.findElement(By.xpath("//*[@id=\"2026\"]")).click();
//       driver.findElement(By.xpath("//*[@id=\"cvv\"]")).sendKeys("987");
//       driver.findElement(By.xpath("//*[@id=\"btn1\"]")).click();
 	
     }
}
