package sdfsf;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GenericUtility {
	public WebDriver driver = null;	
	
	public WebDriver setup(String Browser, String url) {

		if (Browser.equalsIgnoreCase("chrome")) {  
			WebDriverManager.chromedriver().setup();
			// driver = new ChromeDriver();
			ChromeOptions ops = new ChromeOptions();
			ops.addArguments("--remote-allow-origins=*");
			ops.addArguments("--headless");
			driver = new ChromeDriver(ops);
		} else if (Browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions ops = new FirefoxOptions();
			ops.setBinary("/usr/lib/firefox/firefox");
			FirefoxDriver driver = new FirefoxDriver(ops);
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		// driver.manage().window().setSize(new Dimension(300,250));

		driver.get(url);
		return driver;
	}
	
	public BigDecimal DoubleTypeCasting(String a1) {		
		DecimalFormat df = new DecimalFormat("0.00");
		double d=Double.valueOf(a1.replaceAll("[a-zA-Z]", "").replaceAll(" ", "").replaceAll(",", ""));
		BigDecimal h=new BigDecimal(df.format(d));
		//System.out.println(h);
		return h;
	}
	public void ClickByJS(WebDriver driver,WebElement ele) {         //generic method of click by java script
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", ele);
	}
	
	public void ClickByJSUpdated(WebDriver driver,WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].dispatchEvent(new Event('click'));", ele);
	}
	public void LogPrinter(String a) {
		 System.out.println(a);
		 Reporter.log(a);
	}
	public void LogPrinterBigDecimal(BigDecimal a) {
		 System.out.println(a);
		 Reporter.log(a.toString());
	}
	
	public void ExplicitWait(WebElement ele) { 
		WebDriverWait wait=new WebDriverWait(driver,30); 
		wait.until(ExpectedConditions.visibilityOf(ele)); 
	}
	
	
	public String RandomCheckinDateProvider() {
		 LocalDate currentDate = LocalDate.now();
		 Random random = new Random();
	     int randomDays = random.nextInt(30) + 1;
	     LocalDate checkInDate = currentDate.plusDays(randomDays);
	     String a=checkInDate.format(DateTimeFormatter.ofPattern("MMM yyyy"));
		 return a;
	}
	public void ScrollByPageDown(WebDriver driver,int time) {
		WebElement element=driver.findElement(By.tagName("Body"));
		for(int i=1;i<=time;i++) {
		element.sendKeys(Keys.PAGE_DOWN);
		}
	}
	public void ScrollByDpwnarrow(WebDriver driver,int time) {
		WebElement element=driver.findElement(By.tagName("Body"));
		for(int i=1;i<=time;i++) {
		element.sendKeys(Keys.ARROW_DOWN);
		}
	}
	public void implicitwait(int time) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}
	public void CheckINOUTDateProvider(WebDriver driver,String ChecinMonthYear, String CheckInDate, String CheckoutMonthYear, String CheckoutDate)
			throws InterruptedException {	
		while (!driver.findElement(By.xpath("//div[@class='rdrMonthName']")).getText().contentEquals(ChecinMonthYear)) {
			// System.out.println(driver.findElement(By.xpath("//div[@class='rdrMonthName']")).getText());
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@class='rdrNextPrevButton rdrNextButton']")).click();
		}
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement ele = driver.findElement(By.xpath("//div[@class='rdrMonthName' and (text()='" + ChecinMonthYear
				+ "')]/following-sibling::div[@class='rdrDays']//span[(text()='" + CheckInDate
				+ "')]//ancestor::button[not(contains(@tabindex,'-1'))]"));
		wait.until(ExpectedConditions.visibilityOf(ele));
		ele.click();
		Thread.sleep(1000);
		WebElement Cdt = driver.findElement((By.xpath("//div[@class='rdrMonthName' and (text()='" + CheckoutMonthYear
				+ "')]//following-sibling::div[@class='rdrDays']" + "//span[(text()='" + CheckoutDate
				+ "')]//ancestor::button[not(contains(@tabindex,'-1'))]")));
		wait.until(ExpectedConditions.visibilityOf(Cdt));
		Cdt.click();						
	}

	/*
	 * public static ArrayList<String> randomCheckInOutMonthYearDate() {
	 * ArrayList<String> arr = new ArrayList<String>(); LocalDate currentDate =
	 * LocalDate.now(); Random random = new Random(); int randomDays =
	 * random.nextInt(30) + 1; LocalDate checkInDate =
	 * currentDate.plusDays(randomDays); int randomNights = random.nextInt(30) + 1;
	 * LocalDate checkOutDate = checkInDate.plusDays(randomNights); String
	 * CheckinMonthYear =
	 * checkInDate.format(DateTimeFormatter.ofPattern("MMM yyyy")); // to provide
	 * checkin month and year arr.add(CheckinMonthYear); String Checkindate =
	 * checkInDate.format(DateTimeFormatter.ofPattern("d")); // to provide checkin
	 * date arr.add(Checkindate); String CheckoutMonthYear =
	 * checkOutDate.format(DateTimeFormatter.ofPattern("MMM yyyy")); // to provide
	 * checkout month and year arr.add(CheckoutMonthYear); String CheckoutDate =
	 * checkOutDate.format(DateTimeFormatter.ofPattern("d")); //to provide checkout
	 * date arr.add(CheckoutDate); String
	 * API_CheckinDateProvider=checkInDate.format(DateTimeFormatter.ofPattern(
	 * "yyyy-MM-dd")); arr.add(API_CheckinDateProvider); String
	 * API_CheckoutDateProvider=checkOutDate.format(DateTimeFormatter.ofPattern(
	 * "yyyy-MM-dd")); arr.add(API_CheckoutDateProvider);
	 * //System.out.println(arr.get(4)); //System.out.println(arr.get(5)); //
	 * System.out.println(checkInDate.format(DateTimeFormatter.ofPattern("MMM //
	 * yyyy"))); return arr; }
	 */
	public static ArrayList<String> randomCheckInOutMonthYearDate() {         // method to pass random checkinout date to test case and api request 
	    ArrayList<String> arr = new ArrayList<String>();
	    LocalDate currentDate = LocalDate.now();
	    Random random = new Random();
	    int randomDays = random.nextInt(30) + 1;
	    LocalDate checkInDate = currentDate.plusDays(randomDays);
	    int randomNights = random.nextInt(30) + 1;
	    LocalDate checkOutDate = checkInDate.plusDays(randomNights);
	    
	    String checkInMonthYear = checkInDate.format(DateTimeFormatter.ofPattern("MMM yyyy"));			//0
	    arr.add(checkInMonthYear);
	    String checkInDateFormatted = checkInDate.format(DateTimeFormatter.ofPattern("d"));			    //1
	    arr.add(checkInDateFormatted);
	    String checkoutMonthYear = checkOutDate.format(DateTimeFormatter.ofPattern("MMM yyyy"));		//2
	    arr.add(checkoutMonthYear);
	    String checkoutDateFormatted = checkOutDate.format(DateTimeFormatter.ofPattern("d"));			//3
	    arr.add(checkoutDateFormatted);
	    String apiCheckInDateProvider = checkInDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));	//4
	    arr.add(apiCheckInDateProvider);
	    String apiCheckoutDateProvider = checkOutDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")); //5
	    arr.add(apiCheckoutDateProvider);
	    

	    arr.add(Integer.toString(randomNights));     // Add random nights to the last index of arr
	    LocalDate apiCheckInDateProviderPlusOneDay = checkInDate.plusDays(1);
	    String apiCheckInDateProviderPlusOneDayFormatted = apiCheckInDateProviderPlusOneDay.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	    arr.add(apiCheckInDateProviderPlusOneDayFormatted);
	    return arr;
	}
	
	@Test
	public static ArrayList<String> SingleNight_SingleRoom_randomCheckInOutMonthYearDate() {         // method to pass random checkinout date to test case and api request 
	    ArrayList<String> arr = new ArrayList<String>();
	    LocalDate currentDate = LocalDate.now();
	    Random random = new Random();
	    int randomDays = random.nextInt(30) + 1;
	    LocalDate checkInDate = currentDate.plusDays(randomDays);
	    int randomNights = random.nextInt(1) + 1;
	    LocalDate checkOutDate = checkInDate.plusDays(randomNights);
	    
	    String checkInMonthYear = checkInDate.format(DateTimeFormatter.ofPattern("MMM yyyy"));
	    arr.add(checkInMonthYear);
	    String checkInDateFormatted = checkInDate.format(DateTimeFormatter.ofPattern("d"));
	    arr.add(checkInDateFormatted);
	    String checkoutMonthYear = checkOutDate.format(DateTimeFormatter.ofPattern("MMM yyyy"));
	    arr.add(checkoutMonthYear);
	    String checkoutDateFormatted = checkOutDate.format(DateTimeFormatter.ofPattern("d"));
	    arr.add(checkoutDateFormatted);
	    String apiCheckInDateProvider = checkInDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	    arr.add(apiCheckInDateProvider);
	    String apiCheckoutDateProvider = checkOutDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	    arr.add(apiCheckoutDateProvider);
	    arr.add(Integer.toString(randomNights));     // Add random nights to the last index of arr
	    LocalDate apiCheckInDateProviderPlusOneDay = checkInDate.plusDays(1);
	    String apiCheckInDateProviderPlusOneDayFormatted = apiCheckInDateProviderPlusOneDay.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	    arr.add(apiCheckInDateProviderPlusOneDayFormatted);
	    return arr;
	}
	@Test
	public void testabove() throws ParseException {						
		 ArrayList<String> randomDates = SingleNight_SingleRoom_randomCheckInOutMonthYearDate();
		    String checkInMonthYear = randomDates.get(0);
		    String checkInDate = randomDates.get(1);
		    String checkoutMonthYear = randomDates.get(2);
		    String checkoutDate = randomDates.get(3);
		    String apiCheckInDate = randomDates.get(4);
		    String apiCheckoutDate = randomDates.get(5);
		    String noofdays=randomDates.get(6);
		    
		    System.out.println("Check-in Month and Year: " + checkInMonthYear);
		    System.out.println("Check-in Date: " + checkInDate);
		    System.out.println("Checkout Month and Year: " + checkoutMonthYear);
		    System.out.println("Checkout Date: " + checkoutDate);
		    System.out.println("API Check-in Date: " + apiCheckInDate);
		    System.out.println("API Checkout Date: " + apiCheckoutDate);
		    System.out.println("nos of nights for Booking :- "+noofdays);
	}
	@Test
	public void dateTest() throws ParseException {
		System.out.println(GenericUtility.randomCheckInOutMonthYearDate());

	}	

	public void selectbyvisibleText(WebElement ele, String text) {
		Select select = new Select(ele); // generic method of selectByVisibleText();
		select.selectByVisibleText(text);
	}

	public void selectbyindex(WebElement ele, int num) {
		Select select = new Select(ele); // generic method for selectByIndex();
		select.selectByIndex(num);
	}

	public String selectdefaultselected(WebElement ele) {
		Select select = new Select(ele); // generic method to print default selected element in dropdown
		return select.getFirstSelectedOption().getText();
	}
	
	public static Double String_To_DoubleConvertor_With_Formatt(String input) throws ParseException {
		Double doubleValue = Double.parseDouble(input);       
        DecimalFormat df = new DecimalFormat("0.00");       
        String formattedValue = df.format(doubleValue);       
        Double formattedDouble = (Double) df.parse(formattedValue);
      //  System.out.println(formattedDouble);
        return formattedDouble;
	}
	
}
