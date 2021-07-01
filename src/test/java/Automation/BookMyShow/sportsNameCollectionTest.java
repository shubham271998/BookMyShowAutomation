package Automation.BookMyShow;

import java.io.IOException;
import java.util.*;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class sportsNameCollectionTest{
	String userDIR = System.getProperty("user.dir");
	  //Initializing the driver
	    WebDriver driver;
	    Properties prop = new Properties();
	    ExtentReports report = ExtentReportManager.getReportInstance();
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
         	ExtentTest logger = report.createTest("sports");
         	logger.log(Status.INFO, "sports displayed");
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
     	    

     	        List<WebElement> eventNames= driver.findElements(By.xpath("//div[contains(@class,'style__VerticalCardContainer')]/div/div[contains(@class,'commonStyles__CardTextBox')][1]/div"));
     	        List<WebElement> eventPrices= driver.findElements(By.xpath("//div[contains(@class,'style__VerticalCardContainer')]/div/div[contains(@class,'commonStyles__CardTextBox')][4]/div"));
     	        HashMap<String, Integer> events= new HashMap<String, Integer>();
     	        for(int i=0;i<eventNames.size();i++){
     	            String s[]= eventPrices.get(i).getText().split(" ");

     	            int sPrice=Integer.parseInt(s[1]);
     	            events.put(eventNames.get(i).getText(),sPrice);
     	        }
     	        System.out.println(events);

       List<Map.Entry<String, Integer> > list =
     	                new LinkedList<Map.Entry<String, Integer> >(events.entrySet());


     	        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
     	            public int compare(Map.Entry<String, Integer> o1,
     	                               Map.Entry<String, Integer> o2)
     	            {
     	                return (o1.getValue()).compareTo(o2.getValue());
     	            }
     	        });


     	        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
     	        for (Map.Entry<String, Integer> aa : list) {
     	            temp.put(aa.getKey(), aa.getValue());
     	        }
     	        System.out.println(temp);
     	       
   	        for(String e: events.keySet()){
     	            System.out.println(e);
     	            if(e.contains("'")){
     	                String newName[]= e.split("'");
     	                if(newName[0].length()>newName[1].length()){
     	                    e=newName[0];
     	                }else{
     	                    e=newName[1];
     	                }

     	            }
     	            String xpath="//div[contains(text(),'"+e+"')]";
     	            String dt;
     	            try {
     	                Thread.sleep(2000);
     	                driver.findElement(By.xpath(xpath)).click();

     	               dt = driver.findElement(By.xpath("//div[contains(text(),' 2021 - ')]")).getText();
     	            }catch(Exception ex){
     	                dt=  "Date not available";
     	            }
     	            System.out.println(dt);
     	            driver.navigate().back();
     	        }

     	    }

	  @AfterMethod
		//function to close the driver
		public void closeDriver(){
		  report.flush();
			driver.quit();
		}
	  
	}




