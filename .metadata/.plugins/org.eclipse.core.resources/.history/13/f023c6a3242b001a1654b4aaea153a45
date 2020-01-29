package gridControllers;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import grid.GridGenerator;

public class SupremeController {

	private static WebDriver driver;
	private static GridGenerator grid;
	//private static String productXPath = "//img[@alt='I hlzcscp5w']";
	
	public static void main(String[] args) throws MalformedURLException {
		
		fireBrowser(); //fires browser and gets it to https://www.supremenewyork.com/shop/new
		findProduct("//img[@alt='I hlzcscp5w']"); // (arg: Product XPath) finds the product and clicks on it
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		addToCart("XLarge","select[id='s']","input[type='submit']"); //(arg1: Size[Small,Medium,Large,XLarge], arg2: cssSelector for product size, arg3: cssSelector for add to cart button) adds the arg size item to cart
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[class='button checkout']")));;
		
		clickCheckout("a[class='button checkout']");//(arg: cssSelector) click the checkout button
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		fillPaymentDetails();
		
		//clickProcessPayment();
		
	}
	
	private static void fireBrowser() throws MalformedURLException {
		
		grid = new GridGenerator("firefox","http://192.168.1.2:4444/wd/hub"); //arg1->"browserName", arg2->"nodeURL"
		driver = grid.getDriver();
		
		//open and navigate to the site
		driver.manage().window().maximize();
		driver.get("https://www.supremenewyork.com/shop/new");
		
	}
	
	private static void findProduct(String productXPath) {
		
		//find the product and click on it.
		WebElement product = driver.findElement(By.xpath(productXPath)); 
		product.click();
		
	}
	
	private static void addToCart(String size, String cssSelector1, String cssSelector2) {
		
		//select product size 
		Select sizeDropdown = new Select(driver.findElement(By.cssSelector(cssSelector1)));
		sizeDropdown.selectByVisibleText(size);
		
		//add to cart
		WebElement addToCartBtn = driver.findElement(By.cssSelector(cssSelector2));
		addToCartBtn.click();
		
	}
	
	private static void clickCheckout(String cssSelector) {
		
		//XPath: "/html/body/div/div/div[1]/div/a[2]" ; "a[@class='button checkout']"
		
		//click checkout
		WebElement checkoutBtn = driver.findElement(By.cssSelector(cssSelector));
		checkoutBtn.click();
		
	}
	
	private static void fillPaymentDetails() {
		
		//Full Name (XPath: "/html/body/div[1]/div/form/div[2]/div[1]/fieldset/div[1]/input")
		driver.findElement(By.cssSelector("input[placeholder='name']")).sendKeys("Jim Carry"); 
		
		//Email (XPath: "/html/body/div[1]/div/form/div[2]/div[1]/fieldset/div[2]/input")
		driver.findElement(By.cssSelector("input[placeholder='email']")).sendKeys("jimcarry@gmail.com");
		
		//Telephone (XPath: "/html/body/div[1]/div/form/div[2]/div[1]/fieldset/div[3]/input")
		driver.findElement(By.cssSelector("input[placeholder='tel']")).sendKeys("7003219999");
		
		//Address (XPath: "//*[@id='bo']")
		driver.findElement(By.cssSelector("input[placeholder='address']")).sendKeys("Main Street");
		
		//Apartment, Unit Number (XPath: "//*[@id='oba3']")
		driver.findElement(By.cssSelector("input[placeholder='apt, unit, etc']")).sendKeys("1234");
		
		//Zip (XPath: "//*[@id='order_billing_zip']")
		driver.findElement(By.cssSelector("input[placeholder='zip']")).sendKeys("90032");
		
		
		driver.findElement(By.cssSelector("input[placeholder='city']")).sendKeys("Los Angeles");
		
//		Select stateDropdown = new Select(driver.findElement(By.cssSelector("input[name='order[billing_state]']")));
//		stateDropdown.selectByVisibleText("CA");
//		
//		Select countryDropdown = new Select(driver.findElement(By.cssSelector("input[name='order[billing_country]']")));
//		countryDropdown.selectByVisibleText("USA");
		
		//CC Number (XPath: "//*[@id='rnsnckrn']")
		driver.findElement(By.cssSelector("input[placeholder='number']")).sendKeys("4477432112344009");
		
		//Expiration Month
		Select expirationMonthDropdown = new Select(driver.findElement(By.xpath("//*[@id='credit_card_month']")));
		expirationMonthDropdown.selectByVisibleText("11");

		//Expiration Year
		Select expirationYearDropdown = new Select(driver.findElement(By.xpath("//*[@id='credit_card_year']")));
		expirationYearDropdown.selectByVisibleText("2022");
		
		//CVV (XPath: "//*[@id='vval']")
		driver.findElement(By.cssSelector("input[placeholder='CVV']")).sendKeys("321");
		
		//Terms Box
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/form/div[2]/div[2]/fieldset/p[2]/label/div/ins")).click();
		
	}
	
	private static void clickProcessPayment() {
		
		//XPath: "/html/body/div/div/div[1]/div/a[2]"
		driver.findElement(By.xpath("//input[@value='process payment']")).click();
		
	}

}



























