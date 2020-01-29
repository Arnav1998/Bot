//Write method to clear cart and to add different types of products to the cart
package gridControllers;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import data.Person;
import data.PersonGenerator;
import grid.GridGenerator;

public class SupremeController extends Thread {

	private WebDriver driver;
	private GridGenerator grid;
	private Person person;
	//private static String productXPath = "//img[@alt='I hlzcscp5w']";
	
	public SupremeController(PersonGenerator personGenerator) {
		this.person = personGenerator.getPerson();
	}
	
	public void run() {
		
		try {
			fireBrowser(); //fires browser and gets it to https://www.supremenewyork.com/shop/new
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} 

		findProduct("//img[@alt='I hlzcscp5w']"); // (arg: Product XPath) finds the product and clicks on it
		
		new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='submit']")));
		addToCart("Large","select[id='s']","input[type='submit']"); //(arg1: Size[Small,Medium,Large,XLarge], arg2: cssSelector for product size, arg3: cssSelector for add to cart button) adds the arg size item to cart
		
		new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[class='button checkout']")));
		clickCheckout("a[class='button checkout']");//(arg: cssSelector) click the checkout button
		
		new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='CVV']")));
		fillPaymentDetails();
		
		//explicitly wait until the process payment button is visible
		//clickProcessPayment();
		
	}
	
	private void fireBrowser() throws MalformedURLException {
		
		grid = new GridGenerator("firefox","http://10.85.49.92:4444/wd/hub"); //arg1->"browserName", arg2->"nodeURL"
		driver = grid.getDriver();
		
		
//		
//		JavascriptExecutor jse = (JavascriptExecutor)driver; 
//		
//		String javascript = "(async() => { await page.evaluateOnNewDocument(() => { Object.defineProperty(navigator, 'webdriver', { get: () => false,});});})();";
//		
//		jse.executeAsyncScript(javascript);
		
		
		
		//open and navigate to the site
		driver.manage().window().maximize();
		driver.get("https://www.supremenewyork.com/shop/new");
		
	}
	
	private void findProduct(String productXPath) {
		
		//find the product and click on it.
		WebElement product = driver.findElement(By.xpath(productXPath)); 
		product.click();
		
	}
	
	private void addToCart(String size, String cssSelector1, String cssSelector2) {
		
		//select product size 
		Select sizeDropdown = new Select(driver.findElement(By.cssSelector(cssSelector1)));
		sizeDropdown.selectByVisibleText(size);
		
		//add to cart
		WebElement addToCartBtn = driver.findElement(By.cssSelector(cssSelector2));
		addToCartBtn.click();
		
	}
	
	private void clickCheckout(String cssSelector) {
		
		//XPath: "/html/body/div/div/div[1]/div/a[2]" ; "a[@class='button checkout']"
		
		//click checkout
		WebElement checkoutBtn = driver.findElement(By.cssSelector(cssSelector));
		checkoutBtn.click();
		
	}
	
	private void fillPaymentDetails() {
		
		
		//Full Name (XPath: "/html/body/div[1]/div/form/div[2]/div[1]/fieldset/div[1]/input")
		driver.findElement(By.cssSelector("input[placeholder='name']")).sendKeys(person.getFullName()); 
		
		//Email (XPath: "/html/body/div[1]/div/form/div[2]/div[1]/fieldset/div[2]/input")
		driver.findElement(By.cssSelector("input[placeholder='email']")).sendKeys(person.getEmail());
		
		//Telephone (XPath: "/html/body/div[1]/div/form/div[2]/div[1]/fieldset/div[3]/input")
		driver.findElement(By.cssSelector("input[placeholder='tel']")).sendKeys(person.getTelephone());
		
		//Address (XPath: "//*[@id='bo']")
		driver.findElement(By.cssSelector("input[placeholder='address']")).sendKeys(person.getBillingStreet());
		
		//Apartment, Unit Number (XPath: "//*[@id='oba3']")
		driver.findElement(By.cssSelector("input[placeholder='apt, unit, etc']")).sendKeys(person.getBillingAptNumber());
		
		//Zip (XPath: "//*[@id='order_billing_zip']")
		driver.findElement(By.cssSelector("input[placeholder='zip']")).sendKeys(person.getBillingZip());
		
		
		driver.findElement(By.cssSelector("input[placeholder='city']")).sendKeys(person.getBillingCity());
		
//		Select stateDropdown = new Select(driver.findElement(By.cssSelector("input[name='order[billing_state]']")));
//		stateDropdown.selectByVisibleText("CA");
//		
//		Select countryDropdown = new Select(driver.findElement(By.cssSelector("input[name='order[billing_country]']")));
//		countryDropdown.selectByVisibleText("USA");
		
		//CC Number (XPath: "//*[@id='rnsnckrn']")
		driver.findElement(By.cssSelector("input[placeholder='number']")).sendKeys(person.getCcNumber());
		
		//Expiration Month
		Select expirationMonthDropdown = new Select(driver.findElement(By.xpath("//*[@id='credit_card_month']")));
		expirationMonthDropdown.selectByVisibleText(person.getCcExpMonth());

		//Expiration Year
		Select expirationYearDropdown = new Select(driver.findElement(By.xpath("//*[@id='credit_card_year']")));
		expirationYearDropdown.selectByVisibleText(person.getCcExpYear());
		
		//CVV (XPath: "//*[@id='vval']")
		driver.findElement(By.cssSelector("input[placeholder='CVV']")).sendKeys(person.getCcCVV());
		
		//Terms Box
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/form/div[2]/div[2]/fieldset/p[2]/label/div/ins")).click();
		
	}
	
	private void clickProcessPayment() {
		
		//XPath: "/html/body/div/div/div[1]/div/a[2]"
		driver.findElement(By.xpath("//input[@value='process payment']")).click();
		
	}

}



























