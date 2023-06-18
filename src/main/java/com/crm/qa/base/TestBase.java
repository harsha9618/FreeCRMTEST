package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

import com.crm.qa.utilities.TestUtil;

@SuppressWarnings("deprecation")
public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringDecorator e_driver;
	public static  WebDriverListener eventListener;
	public static Logger log; 
	
	
	
	public TestBase() {
		try {
			prop = new Properties();
			
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/crm/qa/config/config.properties");
			prop.load(ip);
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	
	public static void  initialization() {
		
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\SeleniumJars\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if(browserName.equals("FF")) {
			System.setProperty("webdriver.chrome.driver", "E:\\SeleniumJars\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		log= Logger.getLogger(TestBase.class);
		
		
		/*
		 * e_driver=new EventFiringDecorator(driver); eventListener=new
		 * WebDriverListener(); e_driver.register(eventListener); driver=e_driver;
		 */
		 
		 
		log.info("**** Launch the Browser ****");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITY_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		log.info("**** Getting URL ****");
		
	}

}
