package com.javaautomationproject;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class TakeScreenshot {

	 WebDriver driver= new ChromeDriver();	
	 
	 @Test
	public void screenshot() throws Exception {
	
	System.setProperty("webdriver.chrome.driver", "C:/Users/win 10/Desktop/eclipse_workspace/com.javaautomationproject/src/test/resources/driver/chromedriver.exe");
	
		driver.get("http://www.google.com/");
	driver.manage().window().maximize();
	
	
	//accept alert on google
	driver.findElement(By.id("L2AGLb")).click();

	//search ProQuest
			driver.findElement(By.id("APjFqb")).sendKeys("ProQuest");
			driver.findElement(By.id("APjFqb")).submit();
			
	driver.findElement(By.xpath("//*[@id='rso']/div[1]//div[1]/a/h3")).click();
	Thread.sleep(200);
	driver.findElement(By.id("onetrust-accept-btn-handler")).click();
	driver.findElement(By.id("searchTerm")).sendKeys("QA");
	driver.findElement(By.id("expandedSearch")).click();
	
	String userDirectory=System.getProperty("user.dir");
	this.takeSnapShot(driver, userDirectory + "/src/main/resources/Screenshot/img.png");
}

	//take screenshot
	public void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
                File DestFile=new File(fileWithPath);

               FileUtils.copyFile(SrcFile, DestFile);

    }
}

