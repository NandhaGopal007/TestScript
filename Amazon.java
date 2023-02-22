package week1.day3;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {
	public static void main(String[] args) throws IOException {
		
		  ChromeDriver driver=new ChromeDriver();
			
		   driver.get("https://www.amazon.in/");
		   
		   driver.manage().window().maximize();
		   
		   
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		   
			
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9pro",Keys.ENTER);
		    
	        WebElement price = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]"));
		
	        String price1 = price.getText().replaceAll("[^0-9]", "");
	        
	        System.out.println(price1);
	        
	        WebElement rat= driver.findElement(By.xpath("(//div[@class='a-section a-spacing-none a-spacing-top-micro'])[1]"));
	        
	        String rating = rat.getText();
	        
	        System.out.println(rating);
	        
	        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();
		
	        
	        
	        Set<String> windowhandles = driver.getWindowHandles();
	        
	        List<String> obj =new ArrayList<String>(windowhandles);
	        
	        driver.switchTo().window(obj.get(1));
	        
	       File firstSrc = driver.getScreenshotAs(OutputType.FILE);
	       
	       File desc = new File("./snap/img3.png");
	       
	       FileUtils.copyFile(firstSrc, desc);
	     
	        driver.findElement(By.id("add-to-cart-button")).click();
	        
	        String text = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
	        
	        String price2 = text.replaceAll("[^0-9]", "");
	        
	        if(price1.equals(price2))
	        {
	        	System.out.println("correct price");
	        }
	        else
	        {
	        	System.out.println("not correct price");
	        }
	        
	        driver.quit();

		}

}
