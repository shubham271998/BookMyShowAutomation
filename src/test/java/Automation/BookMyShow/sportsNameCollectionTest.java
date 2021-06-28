package Automation.BookMyShow;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class sportsNameCollectionTest{
	String userDIR = System.getProperty("user.dir");
	  //Initializing the driver
	    WebDriver driver;
	    Properties prop = new Properties();
	    
	    @BeforeMethod
	    public void setup(){
 
	    //set path to chromedriver.exe
	    //System.setProperty("webdriver.chrome.driver",prop.getProperty("chromeDriverPath"));
	    System.setProperty("webdriver.chrome.driver",userDIR+"\\WebDrivers\\chromedriver.exe");
	    //create chrome instance

	    driver = new ChromeDriver();
        
	    //implicit wait
	    driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
	    driver.manage().window().maximize();

	    }
		
		
		@Test
		public void clickAllLinks() throws IOException, InterruptedException{
			//open the page 
			driver.get("https://in.bookmyshow.com/");
            
             //to accept the pop up window
             driver.findElement(By.xpath("//button[@class='Sign me Up!']")).click();
             
             //driver.navigate().to(mainPageHandle);
             Thread.sleep(3000);
            //driver.findElement(By.xpath("//*[@class='sc-kZmsYB jJgfRB']/strong"));
     
             //Thread.sleep(5000);
             
             //selct the city as 'NCR'
            driver.findElement(By.xpath("//img[@alt='NCR']")).click();
             Thread.sleep(2000);
             
          
   
        //click on sports link
             driver.findElement(By.xpath("//*[@id='super-container']/div[2]/header/div[2]/div/div/div/div[1]/div/a[5]")).click();
             //Thread.sleep(4000);
             
             //import the javascript executor
             JavascriptExecutor js = (JavascriptExecutor) driver;
             
            //scroll the window so that we can find the this weekend button
             js.executeScript("window.scrollBy(0,200)");
             //Thread.sleep(3000);
             
             //click on this weekend button
             driver.findElement(By.xpath("//*[@id='super-container']/div[2]/div[4]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[2]/div/div")).click();
     	     //Thread.sleep(4000);
     	     
     	    js.executeScript("window.scrollBy(200,300)");
     	    Thread.sleep(3000);
     	    
     	    //click on price button
     	    driver.findElement(By.xpath("//*[@id=\'super-container\']/div[2]/div[4]/div[1]/div[1]/div[2]/div[4]/div/div[1]")).click();
     	    Thread.sleep(3000);
     	    
     	    //click on 0-500 range button
     	    driver.findElement(By.xpath("//*[@id='super-container']/div[2]/div[4]/div[1]/div[1]/div[2]/div[4]/div[2]/div[2]/div[2]/div/div")).click();
     	   Thread.sleep(3000);
     	    
     	 
         //creating a properties file to store the data related to games
     	    Properties prop = new Properties();
     	    OutputStream writeFile = null;
     	    
            writeFile = new FileOutputStream("gameDetails.properties"); 
            
            //all games under 500
            prop.setProperty("game under 500", "game details");
            
     	    
           // First game details
     	   js.executeScript("window.scrollBy(200,350)");
     	   driver.findElement(By.xpath("//*[@id=\'super-container\']/div[2]/div[4]/div[2]/div[3]/div/div[2]/a[1]/div/div[3]/div[1]/div")).click();
     	   js.executeScript("window.scrollBy(0,200)");
     	  
     	   String gameName = driver.findElement(By.xpath("//*[@id=\'app\']/div/div/div/div/div[2]/div/header/div/div/div[1]/div[1]/div[1]/h1")).getText();
     	   prop.setProperty("first game name", gameName);
     	   System.out.println(gameName);
     	  
     	   String gameDate = driver.findElement(By.xpath("//*[@id=\'app\']/div/div/div/div/div[2]/div/header/div/div/div[2]/div/div/div[1]/div/div")).getText();
     	   prop.setProperty("first game Date", gameDate);
     	  System.out.println(gameDate);
     	  
    	   String gamePrice = driver.findElement(By.xpath("//*[@id=\'app\']/div/div/div/div/div[2]/div/header/div/div/div[2]/div/div/div[2]/div[3]/div")).getText();
    	   prop.setProperty("first game price", gamePrice);
    	   System.out.println(gamePrice);
    	   
    	   
    	   driver.navigate().back();
    	   Thread.sleep(3000);
    	   
    	   //second game details
    	   js.executeScript("window.scrollBy(200,350)");
     	   driver.findElement(By.xpath("//*[@id=\"super-container\"]/div[2]/div[4]/div[2]/div[3]/div/div[2]/a[2]/div/div[3]/div[1]/div")).click();
     	  js.executeScript("window.scrollBy(0,200)");
     	  
     	   String gameName2 = driver.findElement(By.xpath("//*[@id=\'app\']/div/div/div/div/div[2]/div/header/div/div/div[1]/div[1]/div[1]/h1")).getText();
     	   prop.setProperty("Second game name", gameName2);
     	  System.out.println(gameName2);
     	  
     	   String gameDate2 = driver.findElement(By.xpath("//*[@id=\'app\']/div/div/div/div/div[2]/div/header/div/div/div[2]/div/div/div[1]/div/div")).getText();
     	   prop.setProperty("Second game Date", gameDate2);
     	  System.out.println(gameDate2);
     	  
    	   String gamePrice2 = driver.findElement(By.xpath("//*[@id=\'app\']/div/div/div/div/div[2]/div/header/div/div/div[2]/div/div/div[2]/div[3]/div")).getText();
    	   prop.setProperty("Second game price", gamePrice2);
    	   System.out.println(gamePrice2);
    	   
    	   driver.navigate().back();
    	   Thread.sleep(3000);
    	   
    	 //Third game details
    	   js.executeScript("window.scrollBy(200,350)");
     	   driver.findElement(By.xpath("//*[@id=\"super-container\"]/div[2]/div[4]/div[2]/div[3]/div/div[2]/a[3]/div/div[3]/div[1]/div")).click();
     	  js.executeScript("window.scrollBy(0,200)");
     	  
     	   String gameName3 = driver.findElement(By.xpath("//*[@id=\'app\']/div/div/div/div/div[2]/div/header/div/div/div[1]/div[1]/div[1]/h1")).getText();
     	   prop.setProperty("Third game name", gameName3);
     	  System.out.println(gameName3);
     	  
     	   String gameDate3 = driver.findElement(By.xpath("//*[@id=\'app\']/div/div/div/div/div[2]/div/header/div/div/div[2]/div/div/div[1]/div/div")).getText();
     	   prop.setProperty("Third game Date", gameDate3);
     	  System.out.println(gameDate3);
     	  
    	   String gamePrice3 = driver.findElement(By.xpath("//*[@id=\'app\']/div/div/div/div/div[2]/div/header/div/div/div[2]/div/div/div[2]/div[3]/div")).getText();
    	   prop.setProperty("Third game price", gamePrice3);
    	   System.out.println(gamePrice3);
    	   
    	   driver.navigate().back();
    	   Thread.sleep(3000);
    	   
    	 //Fourth game details
    	   js.executeScript("window.scrollBy(200,350)");
     	   driver.findElement(By.xpath("//*[@id=\"super-container\"]/div[2]/div[4]/div[2]/div[3]/div/div[2]/a[4]/div/div[3]/div[1]/div")).click();
     	  js.executeScript("window.scrollBy(0,200)");
     	  
     	   String gameName4 = driver.findElement(By.xpath("//*[@id=\'app\']/div/div/div/div/div[2]/div/header/div/div/div[1]/div[1]/div[1]/h1")).getText();
     	   prop.setProperty("Fourth game name", gameName4);
     	  System.out.println(gameName4);
     	  
     	   String gameDate4 = driver.findElement(By.xpath("//*[@id=\'app\']/div/div/div/div/div[2]/div/header/div/div/div[2]/div/div/div[1]/div/div")).getText();
     	   prop.setProperty("Fourth game Date", gameDate4);
     	  System.out.println(gameDate4);
     	  
    	   String gamePrice4 = driver.findElement(By.xpath("//*[@id=\'app\']/div/div/div/div/div[2]/div/header/div/div/div[2]/div/div/div[2]/div[3]/div")).getText();
    	   prop.setProperty("Fourth game price", gamePrice4);
    	   System.out.println(gamePrice4);
    	   
    	   driver.navigate().back();
    	   Thread.sleep(3000);
    	   
    	   
    	   // now scroll further down for next 4 games
    	   //js.executeScript("window.scrollBy(350,950)");
    	   //Thread.sleep(3000);
    	   
    	 //Fifth game details
    	   js.executeScript("window.scrollBy(350,950)");
     	   driver.findElement(By.xpath("//*[@id=\"super-container\"]/div[2]/div[4]/div[2]/div[4]/div/div[2]/a[1]/div/div[3]/div[1]/div")).click();
     	  //js.executeScript("window.scrollBy(0,20)");
     	   
     	   String gameName5 = driver.findElement(By.xpath("//*[@id=\'app\']/div/div/div/div/div[2]/div/header/div/div/div[1]/div[1]/div[1]/h1")).getText();
     	   prop.setProperty("Fifth game name", gameName5);
     	  System.out.println(gameName5);
     	  
     	   String gameDate5 = driver.findElement(By.xpath("//*[@id=\'app\']/div/div/div/div/div[2]/div/header/div/div/div[2]/div/div/div[1]/div/div")).getText();
     	   prop.setProperty("Fifth game Date", gameDate5);
     	  System.out.println(gameDate5);
     	  
    	   String gamePrice5 = driver.findElement(By.xpath("//*[@id=\'app\']/div/div/div/div/div[2]/div/header/div/div/div[2]/div/div/div[2]/div[3]/div")).getText();
    	   prop.setProperty("Fifth game price", gamePrice5);
    	   System.out.println(gamePrice5);
    	   
    	   driver.navigate().back();
    	   Thread.sleep(3000);
    	   
    	 //Sixth game details
    	   js.executeScript("window.scrollBy(350,950)");
     	   driver.findElement(By.xpath("//*[@id=\"super-container\"]/div[2]/div[4]/div[2]/div[4]/div/div[2]/a[2]/div/div[3]/div[1]/div")).click();
     	  js.executeScript("window.scrollBy(0,200)");
     	   
     	   String gameName6 = driver.findElement(By.xpath("//*[@id=\'app\']/div/div/div/div/div[2]/div/header/div/div/div[1]/div[1]/div[1]/h1")).getText();
     	   prop.setProperty("Sixth game name", gameName6);
     	  System.out.println(gameName6);
     	  
     	   String gameDate6 = driver.findElement(By.xpath("//*[@id=\'app\']/div/div/div/div/div[2]/div/header/div/div/div[2]/div/div/div[1]/div/div")).getText();
     	   prop.setProperty("Sixth game Date", gameDate6);
     	  System.out.println(gameDate6);
     	  
    	   String gamePrice6 = driver.findElement(By.xpath("//*[@id=\'app\']/div/div/div/div/div[2]/div/header/div/div/div[2]/div/div/div[2]/div[3]/div")).getText();
    	   prop.setProperty("Sixth game price", gamePrice6);
    	   System.out.println(gamePrice6);
    	   
    	   driver.navigate().back();
    	   Thread.sleep(3000);
    	   
    	 //Seventh game details
    	   js.executeScript("window.scrollBy(350,950)");
     	   driver.findElement(By.xpath("//*[@id=\"super-container\"]/div[2]/div[4]/div[2]/div[4]/div/div[2]/a[3]/div/div[3]/div[1]/div")).click();
     	  js.executeScript("window.scrollBy(0,200)");
     	   
     	   String gameName7 = driver.findElement(By.xpath("//*[@id=\'app\']/div/div/div/div/div[2]/div/header/div/div/div[1]/div[1]/div[1]/h1")).getText();
     	   prop.setProperty("Seventh game name", gameName7);
     	  System.out.println(gameName7);
     	  
     	   String gameDate7 = driver.findElement(By.xpath("//*[@id=\'app\']/div/div/div/div/div[2]/div/header/div/div/div[2]/div/div/div[1]/div/div")).getText();
     	   prop.setProperty("Seventh game Date", gameDate7);
     	  System.out.println(gameDate7);
     	  
    	   String gamePrice7 = driver.findElement(By.xpath("//*[@id=\'app\']/div/div/div/div/div[2]/div/header/div/div/div[2]/div/div/div[2]/div[3]/div")).getText();
    	   prop.setProperty("Seventh game price", gamePrice7);
    	   System.out.println(gamePrice7);
    	   
    	   driver.navigate().back();
    	   Thread.sleep(3000);
    	   
    	 //8th game details
    	   js.executeScript("window.scrollBy(350,950)");
     	   driver.findElement(By.xpath("//*[@id=\"super-container\"]/div[2]/div[4]/div[2]/div[4]/div/div[2]/a[4]/div/div[3]/div[1]/div")).click();
     	  js.executeScript("window.scrollBy(0,200)");
     	   
     	   String gameName8 = driver.findElement(By.xpath("//*[@id=\'app\']/div/div/div/div/div[2]/div/header/div/div/div[1]/div[1]/div[1]/h1")).getText();
     	   prop.setProperty("8th game name", gameName8);
     	  System.out.println(gameName8);
     	  
     	   String gameDate8 = driver.findElement(By.xpath("//*[@id=\'app\']/div/div/div/div/div[2]/div/header/div/div/div[2]/div/div/div[1]/div/div")).getText();
     	   prop.setProperty("8th game Date", gameDate8);
     	  System.out.println(gameDate8);
     	  
    	   String gamePrice8 = driver.findElement(By.xpath("//*[@id=\'app\']/div/div/div/div/div[2]/div/header/div/div/div[2]/div/div/div[2]/div[3]/div")).getText();
    	   prop.setProperty("8th game price", gamePrice8);
    	   System.out.println(gamePrice8);
    	   
    	   driver.navigate().back();
    	   Thread.sleep(3000);
    	   
    	  
          //scroll to the 0-500 range 
          js.executeScript("window.scrollBy(200,300)");
          
          //click on 0-500 button again to deselect the same
          driver.findElement(By.xpath("//*[@id='super-container']/div[2]/div[4]/div[1]/div[1]/div[2]/div[4]/div[2]/div[2]/div[2]/div/div")).click();
    	   Thread.sleep(3000);
    	   
    	  //click on price button again
    	   driver.findElement(By.xpath("//*[@id=\"super-container\"]/div[2]/div[4]/div[1]/div[1]/div[2]/div[4]/div/div[1]")).click();
    	   
    	   //click on 501-2000 range button
    	   driver.findElement(By.xpath("//*[@id=\"super-container\"]/div[2]/div[4]/div[1]/div[1]/div[2]/div[4]/div[2]/div[3]/div[2]/div/div")).click();	   
    	   
    	   //click on above 2000 range button
    	   driver.findElement(By.xpath("//*[@id=\"super-container\"]/div[2]/div[4]/div[1]/div[1]/div[2]/div[4]/div[2]/div[4]/div[2]/div/div")).click();

    	   // Details of the games which is greater than 500
    	   
    	   // 21th game details
     	   js.executeScript("window.scrollBy(200,350)");
     	   driver.findElement(By.xpath("//*[@id=\"super-container\"]/div[2]/div[4]/div[2]/div[3]/div/div[2]/a[1]/div/div[3]/div[1]/div")).click();
     	   js.executeScript("window.scrollBy(0,200)");
     	  
     	   String gameName21 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[2]/div/header/div/div/div[1]/div[1]/div[1]/h1")).getText();
     	   prop.setProperty("21th game name", gameName21);
     	   System.out.println(gameName21);
     	  
     	   String gameDate21 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[2]/div/header/div/div/div[2]/div/div/div[1]/div/div")).getText();
     	   prop.setProperty("21th game Date", gameDate21);
     	  System.out.println(gameDate21);
     	  
    	   String gamePrice21 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[2]/div/header/div/div/div[2]/div/div/div[2]/div[3]/div[1]")).getText();
    	   prop.setProperty("21th game price", gamePrice21);
    	   System.out.println(gamePrice21);
    	   
    	   
    	   driver.navigate().back();
    	   Thread.sleep(3000);
    	   
    	// 22th game details
     	   js.executeScript("window.scrollBy(200,350)");
     	   driver.findElement(By.xpath("//*[@id=\"super-container\"]/div[2]/div[4]/div[2]/div[3]/div/div[2]/a[2]/div/div[3]/div[1]/div")).click();
     	   js.executeScript("window.scrollBy(0,200)");
     	  
     	   String gameName22 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[2]/div/header/div/div/div[1]/div[1]/div[1]/h1")).getText();
     	   prop.setProperty("22th game name", gameName22);
     	   System.out.println(gameName22);
     	  
     	   String gameDate22 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[2]/div/header/div/div/div[2]/div/div/div[1]/div/div")).getText();
     	   prop.setProperty("22th game Date", gameDate22);
     	  System.out.println(gameDate22);
     	  
    	   String gamePrice22 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[2]/div/header/div/div/div[2]/div/div/div[2]/div[3]/div[1]")).getText();
    	   prop.setProperty("22th game price", gamePrice22);
    	   System.out.println(gamePrice22);
    	   
    	   driver.navigate().back();
    	   Thread.sleep(3000);
    	   
    	  prop.store(writeFile, null);
    	   writeFile.close();     
         
		}
		
		
	  @AfterMethod
		//function to close the driver
		public void closeDriver(){
			driver.quit();
		}
	  
	}




