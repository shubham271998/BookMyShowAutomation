package Automation.BookMyShow;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.ScreenshotException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class movieNameCollectionTest {
	String userDIR = System.getProperty("user.dir");
	String mainPageHandle;
	JavascriptExecutor js;
	// Initializing the driver
	WebDriver driver;
	ExtentReports report = ExtentReportManager.getReportInstance();

	Properties prop = new Properties();

	@Parameters({ "browser", "Path0" })
	@BeforeTest
	public void setup(String browser, String Path0) throws Exception {
      
		driver = WebDriverFactory.setDriver(browser);

		driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		try {
			ScreenShotFunctionality.takeSnapShot(driver, userDIR + Path0);
		} // Take Screenshot
		catch (ScreenshotException e) {
			System.out.println("Unable to take Screen Shot");
		}

	}

	@Parameters({ "URL", "Path1" })
	@Test(priority = 0)
	public void openBrowser(String URL, String Path1) throws Exception {
    	
    	//opening the page 
		driver.get(URL);
		// getting the page title
		String title = driver.getTitle();

		String expectedTitle = "Movie Tickets, Plays, Sports, Events & Cinemas nearby - BookMyShow";
		// Checking if the right page opened
		Assert.assertEquals(title, expectedTitle); // Checking expected and actual result
		// Waiting
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		try {
			ScreenShotFunctionality.takeSnapShot(driver, userDIR + Path1);
		} // Take Screenshot
		catch (ScreenshotException e) {
			System.out.println("Unable to take Screen Shot");
		}
	}

	@Parameters({ "Path2", "Path3" })
	@Test(priority = 1)
	public void signUpNCR(String Path2, String Path3) throws Exception {
		mainPageHandle = driver.getWindowHandle();

		try {
			ScreenShotFunctionality.takeSnapShot(driver, userDIR + Path2);
		} // Take Screenshot
		catch (ScreenshotException e) {
			System.out.println("Unable to take Screen Shot");
		}
        
		driver.findElement(By.xpath("//button[@class='Sign me Up!']")).click();

		// select the city as 'NCR'
		driver.findElement(By.xpath("//img[@alt='NCR']")).click();
		try {
			ScreenShotFunctionality.takeSnapShot(driver, userDIR + Path3);
		} // Take Screenshot
		catch (ScreenshotException e) {
			System.out.println("Unable to take Screen Shot");
		}

	}

	@Test(priority = 2)
	public void moviesData() {
		ExtentTest logger = report.createTest("moviesData");
		// click on movies button
		logger.log(Status.INFO, "movies opened");
		driver.findElement(By.xpath("//*[@id=\'super-container\']/div[2]/header/div[2]/div/div/div/div[1]/div/a[1]"))
				.click();

		// click on upcoming movies
		driver.findElement(
				By.xpath("//*[@id=\"super-container\"]/div[2]/div[4]/div[2]/div[2]/div/div[2]/a/div/div[2]/div/img"))
				.click();

		// create a list to store the language of movies
		List<String> list = new ArrayList<String>();

		String hindi = driver
				.findElement(By.xpath("//*[@id=\"super-container\"]/div[2]/div[4]/div[2]/div[2]/div/div[1]/div/div"))
				.getText();
		list.add(hindi);
		String English = driver
				.findElement(
						By.xpath("//*[@id=\"super-container\"]/div[2]/div[4]/div[2]/div[2]/div/div[2]/div/div/div"))
				.getText();
		list.add(English);
		String Telugu = driver
				.findElement(
						By.xpath("//*[@id=\"super-container\"]/div[2]/div[4]/div[2]/div[2]/div/div[3]/div/div/div"))
				.getText();
		list.add(Telugu);
		String Tamil = driver
				.findElement(
						By.xpath("//*[@id=\"super-container\"]/div[2]/div[4]/div[2]/div[2]/div/div[4]/div/div/div"))
				.getText();
		list.add(Tamil);
		String Malayalam = driver
				.findElement(
						By.xpath("//*[@id=\"super-container\"]/div[2]/div[4]/div[2]/div[2]/div/div[6]/div/div/div"))
				.getText();
		list.add(Malayalam);
		String Marathi = driver
				.findElement(
						By.xpath("//*[@id=\"super-container\"]/div[2]/div[4]/div[2]/div[2]/div/div[7]/div/div/div"))
				.getText();
		list.add(Marathi);
		String Bengali = driver
				.findElement(
						By.xpath("//*[@id=\"super-container\"]/div[2]/div[4]/div[2]/div[2]/div/div[8]/div/div/div"))
				.getText();
		list.add(Bengali);
		String Punjabi = driver
				.findElement(
						By.xpath("//*[@id=\"super-container\"]/div[2]/div[4]/div[2]/div[2]/div/div[9]/div/div/div"))
				.getText();
		list.add(Punjabi);
		String Bhojpuri = driver
				.findElement(
						By.xpath("//*[@id=\"super-container\"]/div[2]/div[4]/div[2]/div[2]/div/div[10]/div/div/div"))
				.getText();
		list.add(Bhojpuri);
		String Gujarati = driver
				.findElement(
						By.xpath("//*[@id=\"super-container\"]/div[2]/div[4]/div[2]/div[2]/div/div[11]/div/div/div"))
				.getText();
		list.add(Gujarati);
		String Assamese = driver
				.findElement(
						By.xpath("//*[@id=\"super-container\"]/div[2]/div[4]/div[2]/div[2]/div/div[12]/div/div/div"))
				.getText();
		list.add(Assamese);
		String Rajasthani = driver
				.findElement(
						By.xpath("//*[@id=\"super-container\"]/div[2]/div[4]/div[2]/div[2]/div/div[13]/div/div/div"))
				.getText();
		list.add(Rajasthani);
		String Sanskrit = driver
				.findElement(
						By.xpath("//*[@id=\"super-container\"]/div[2]/div[4]/div[2]/div[2]/div/div[14]/div/div/div"))
				.getText();
		list.add(Sanskrit);

		System.out.println(list);
	}

	@AfterTest
	// function to close the driver
	public void closeDriver() {
		report.flush();
		driver.quit();
	}

}
