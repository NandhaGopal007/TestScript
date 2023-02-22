package week1.day3;


import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.sun.tools.javac.util.List;

public class Nykaa {
	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement ele = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(ele).perform();
		driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris");
		driver.findElement(By.xpath("//a[contains(@href,'/brands/loreal-paris/c/595?ptype=b')]")).click();
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//button[@class=' css-n0ptfk']")).click();
		driver.findElement(By.xpath("//label[@for='radio_customer top rated_undefined']")).click();
		driver.findElement(By.xpath("(//div [@class='filter-action'])[1]")).click();
		driver.findElement(By.xpath("(//div[@class=' css-b5p5ep'])[2]")).click();
		driver.findElement(By.xpath("(//div[@class=' css-b5p5ep'])[1]")).click();
		driver.findElement(By.xpath("(//div[@class='control-indicator checkbox '])[1]")).click();
		driver.findElement(By.xpath("(//div[@class='css-xdicx1'])[5]")).click();
		driver.findElement(By.xpath("//label[@for='checkbox_Color Protection_10764']")).click();
		driver.findElement(By.xpath("//div[@class='css-xrzmfa']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		ArrayList<String> list = new ArrayList<String>(windowHandles);
		driver.switchTo().window(list.get(1));
		WebElement size = driver.findElement(By.xpath("//div[@class='css-691drn']"));
		Select select = new Select(size);
		select.selectByVisibleText("180ml");
		WebElement print = driver.findElement(By.xpath("(//span[@class='css-1jczs19'])[1]"));
		System.out.println(print.getText());
		driver.findElement(By.xpath("(//button[@class=' css-1qvy369'])[1]")).click();
		driver.findElement(By.xpath("//*[@class='css-g4vs13']")).click();
		WebElement total = driver.findElement(By.xpath("//span[.='₹279']"));
		System.out.println(total.getText());
		driver.findElement(By.xpath("//div[@class='css-15vhhhd e25lf6d4']")).click();
		driver.findElement(By.xpath("//button[.='Continue as guest']")).click();
		WebElement grandtotal = driver.findElement(By.xpath("//p[@class='css-1e59vjt eka6zu20']"));
		System.out.println(grandtotal.getText());
		
		if(print.equals(grandtotal)) {
			System.out.println("The Grand Total is the same in step 14");
		}
		
		driver.quit();

   }

}
