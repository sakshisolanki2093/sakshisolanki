package com.javaautomationproject;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.FileOutputStream;  

public class CopyTitles {
		
	WebDriver driver= new ChromeDriver();
	 BufferedWriter writer;
	
@BeforeSuite
void launchDriver() throws IOException, InterruptedException {
	
	//Launch chrome and hit google
	
	System.setProperty("webdriver.chrome.driver", "C:/Users/win 10/Desktop/eclipse_workspace/com.javaautomationproject/src/test/resources/driver/chromedriver.exe");
	driver.get("http://www.google.com/");
	driver.manage().window().maximize();
	
	//accept alert on google
	driver.findElement(By.id("L2AGLb")).click();
}
@BeforeTest

void search() {
	//search ProQuest
			driver.findElement(By.id("APjFqb")).sendKeys("ProQuest");
			driver.findElement(By.id("APjFqb")).submit();
}

@Test
 void writeTitlesinNotes() throws InterruptedException, IOException {
	
	//Get all titles
		List<String> list= new ArrayList<>();
		List<WebElement> elements= driver.findElements(By.xpath("//*[@id='rso']//div/a/h3"));
		Thread.sleep(500);
			
			for (WebElement string : elements) {
				Thread.sleep(10);
				list.add(string.getText());
			}
			
			System.out.println(list);
			
	//Write list to note file
			String userDire=System.getProperty("user.dir");
			
			 FileOutputStream titleFile=new FileOutputStream(userDire
					 + "/src/main/resources/Notes/note.txt");  
			
			  for (String s : list)

			  { 
				  byte b[]=s.getBytes();
			  titleFile.write(b);  
              }
			 
     
            
        driver.close();
}

}


