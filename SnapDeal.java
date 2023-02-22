package week1.day3;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SnapDeal {
	public static void main(String[] args) throws IOException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		WebElement  MensFashion= driver.findElement(By.className("catText"));
		MensFashion.click();
		
		List<WebElement> Sportshoes = driver.findElements(By.className("linkTest"));
	    int size = Sportshoes.size();
	    System.out.println("Total Sportshoes= "+size);
		
		WebElement Sports = driver.findElement(By.className("linkTest"));
		Sports.click();
		
	    WebElement Trainingshoes = driver.findElement(By.xpath("//div[text()='Training Shoes']"));
	    Trainingshoes.click();
	    
	    
	    
	    List<WebElement> shoes = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
	    
        List<Integer> amt = new ArrayList<Integer>();
		
		for(int i=0;i<shoes.size();i++) 
		{
			String text = shoes.get(i).getText();
		   
		    String replaceAll = text.replaceAll("[^0-9]","");
		    System.out.println(replaceAll);
		     
		    int parseInt = Integer.parseInt(replaceAll);
		     
		    amt.add(parseInt);
		 }
		
		Collections.sort(amt);
		
		Integer min= amt.get(0);
		System.out.println("The lowest price = "+min);
		
		
		Integer max = amt.get(amt.size()-1);
		System.out.println("The Highest price = "+max);
		
		
		WebElement range1 = driver.findElement(By.xpath("(//input[@class='input-filter'])[1]"));
		range1.clear();
		range1.sendKeys("900");
		
		
		WebElement range2 = driver.findElement(By.xpath("(//input[@class='input-filter'])[2]"));
		range2.clear();
		range2.sendKeys("1200");
		
		
		WebElement Button = driver.findElement(By.xpath("//div[contains(@class,'price-go-arrow btn ')]"));
		Button.click();
		
		
		WebElement mouse = driver.findElement(By.xpath("//img[@class='product-image wooble']"));
		Actions act = new Actions(driver);
		act.moveToElement(mouse).build().perform();
		
		
		
		
		WebElement quick = driver.findElement(By.xpath("(//div[@class='clearfix row-disc'])/div"));
		quick.click();
		
		WebElement cost = driver.findElement(By.xpath("//span[@class='payBlkBig']"));
		String cost1 = cost.getText();
		System.out.println("Price of Shoe = "+cost1);
		
		
		WebElement disc = driver.findElement(By.xpath("//span[@class='percent-desc ']"));
		String ofr = disc.getText();
		System.out.println("Shoe Offer = "+ofr);
		
		File firstSrc = driver.getScreenshotAs(OutputType.FILE);
		
		File desc = new File("./snap/img4.png");
		
		FileUtils.copyFile(firstSrc, desc);
		
		driver.quit();
	
	}

}
