package com.cucumberFramework.pageObjects;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.cucumberFramework.helper.WaitHelper;

public class LoginLogoutPage {
	
	private WebDriver driver;
	
	@FindBy(xpath="//input[@type='email']")
	public WebElement userName;
	
	@FindBy(xpath="//input[@id='continue']")
	WebElement Continue;
	
	@FindBy(xpath="//input[@type='password']")
	public WebElement password;
	
	@FindBy(xpath="//input[@id='signInSubmit']")
	WebElement loginButton;
	
	@FindBy(xpath="//div[@id='nav-tools']/a[@data-nav-role='signin']")
	WebElement SignInfromNav;
	
	@FindBy(xpath="//span[contains(text(),'Sign')]/parent::a")
	public WebElement logoutBtn;
	
	@FindBy(xpath="//div[@id='nav-shop']/a")
	public WebElement allShopNav;

	@FindBy(xpath="//span[@data-nav-panelkey='TvApplElecPanel']")
	public WebElement TvApplElecPanel;
	
	@FindBy(xpath="//span[contains(text(),'Headphones')]/parent::a")
	public WebElement headPhonesCatLnk;
	
	@FindBy(xpath="//div[@id='mainResults']/ul/li[1]/div/div/div/a[contains(@class,'access-detail-page')]")
	public WebElement firstHeadPhoneLnk;
	
	@FindBy(xpath="//input[@id='add-to-cart-button']")
	public WebElement addToCartBtn;
	
	@FindBy(linkText="//a[@id='nav-cart']")
	public WebElement cartButton;
	
	@FindBy(xpath="//form[@id='activeCartViewForm']/div[@data-name='Active Items' or contains(@class,'sc-list-body')]//input[@value='Delete']")
	public List<WebElement> itemList;
	
	//form[@id='activeCartViewForm']/div[@data-name='Active Items' or contains(@class,'sc-list-body')]//input[@value='Delete']
	
	@FindBy(xpath="//div[contains(@class,'nav-search-field')]/input")
	public WebElement itemSearchField;
	
	@FindBy(xpath="//div[starts-with(@class,'sg-col-4')]/div[@class='sg-col-inner']/div/h5/a")
	public WebElement secondMacbookItem;
	
	@FindBy(xpath="//select[@id='quantity' or @name='quantity']")
	public List<WebElement> qtyField;
	
	
	WaitHelper waitHelper;
	
	public LoginLogoutPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		//waitHelper.WaitForElement(userName, 60);
	}
	
	public void enterUserName(String userName){
		this.userName.sendKeys(userName);
	}
	
	public void enterPassword(String password){
		this.password.sendKeys(password);
	}
	
	public void clickLoginButton(){
		loginButton.click();
	}
	
	
	public void loginWebpage(String arg1)
	{
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe");
	driver = new ChromeDriver();	
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	//driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get(arg1);
	System.out.println("User entering the WebPage");
	}
	
	public void verifySportandFootballColor()
	{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebElement s=driver.findElement(By.linkText("Sport"));
	    s.click();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    //String color1 = s.getCssValue("background-color");
	    WebElement f=driver.findElement(By.linkText("Football"));
	    f.click();
	    //String color2 = f.getCssValue("background-color");
		System.out.println("User click sports tab" + f +","+s);
	}
	
	public void verifyfootballPage()
	{
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		// Javascript executor to return value
	    JavascriptExecutor j = (JavascriptExecutor) driver;
	    j.executeScript("return document.readyState").toString().equals("complete");
	    // get the current URL
	    String url = driver.getCurrentUrl();
	    // checking condition if the URL is loaded
	    if (url.equals("https://www.dailymail.co.uk/sport/football/index.html")) {
	       System.out.println("Page Loaded");
	       System.out.println("Current Url: " + url);
	    }
	    else {
	       System.out.println("Page did not load");
	    }
		WebElement s=driver.findElement(By.xpath("//div[@id='content']/div[2]/div[1]/div/h2/a"));
		s.click();
		System.out.println("User see the sports page");
	}
	
	public void ClickGalleryContent()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		  int size = driver.findElements(By.tagName("iframe")).size();
		  System.out.println("frame size"+size);
		  //driver.switchTo().frame("mailonlineprebidheader526476985912_MOAT_IFRAME");
		 
		//driver.findElement(By.xpath("//button[@class='vjs-close-button vjs-control vjs-button vjs-pip-close-button']")).click();
		
		WebElement s=driver.findElement(By.xpath("//button[@class='openGalleryButton-2CswR small-caPg5']"));
		if(s.isDisplayed())
		{
			 JavascriptExecutor js = (JavascriptExecutor) driver;
		        //Scroll down till the bottom of the page
			 js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", s);
			 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				js.executeScript("arguments[0].click()", s);
		       // s.click();
		}
			
		else
			
		{
			 size = driver.findElements(By.tagName("iframe")).size();
			System.out.println("frame size"+size);
			driver.switchTo().frame("mailonlineprebidheader526476985912_MOAT_IFRAME").navigate();
			
		}
			
		System.out.println("User see the sports page");
	}
	
	public void checkPreviousNextButton()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.switchTo().frame("mailonlineprebidheader526476985912_MOAT_IFRAME").navigate();
		WebElement next=driver.findElement(By.xpath("//button[@aria-label='Next']"));
		next.click();
		WebElement prev=driver.findElement(By.xpath("//button[@aria-label='Previous']"));
		next.click();
		WebElement close=driver.findElement(By.xpath("//button[@aria-label='Close']"));
		close.click();
		
		System.out.println("User see the sports page");
	}
	public void checkFaceBookPage()
	{

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement fb=driver.findElement(By.xpath("//div[@class='container-3zJLP vertical-2XJd5']/ul/li[1]"));
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].click()", fb);
		
		String parent=driver.getWindowHandle();

		Set<String>s=driver.getWindowHandles();

		System.out.println("User see the fb page :"+parent);
		// Now iterate using Iterator
		Iterator<String> I1= s.iterator();

		while(I1.hasNext())
		{

		String child_window=I1.next();


		if(!parent.equals(child_window))
		{
			
		driver.switchTo().window(child_window);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		System.out.println("Title name"+driver.switchTo().window(child_window).getTitle());
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.close();
		}

		}
		//switch to the parent window
		driver.switchTo().window(parent);
	}
	
	public void clickEmbeddedVideo()
	{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 //js.executeScript("arguments[0].click()", fb);
		 Actions action = new Actions(driver);
		//Find the targeted element
		 WebElement fb=driver.findElement(By.xpath("//video-js[@aria-label='Video Player']"));
		                //Here I used JavascriptExecutor interface to scroll down to the targeted element
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", fb);
		                //used doubleClick(element) method to do double click action
		action.doubleClick(fb).build().perform();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		action.doubleClick(fb).build().perform();
		
		
		System.out.println("User see the embedded video");
	}
	
	public void viewMaximizeMinimizeVideo()
	{
		System.out.println("User viewed in full screen and minimized");
		
	}
	
	public void clickPremierLeagueTable()
	{

		List <WebElement> col = driver.findElements(By.xpath(".//*[@id=\"leftcontainer\"]/table/thead/tr/th"));
	    System.out.println("No of cols are : " +col.size()); 
	    //No.of rows 
	    List <WebElement> rows = driver.findElements(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr/td[1]")); 
	    System.out.println("No of rows are : " + rows.size());
		
		System.out.println("User see the sports page");
	}
	
	public void checkPositionofPLT()
	{
		System.out.println("Exhibit the points or positions from the Premier league table");
	}
	
	public void verifyTimeAndDate() 
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement dateTimeField = driver.findElement(By.id("weather-wrapper"));
	  	String placeholderVal = dateTimeField.getText();
	  	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	    LocalDateTime now = LocalDateTime.now();  
	    System.out.println(dtf.format(now));  
	     
	     Format f = new SimpleDateFormat("HH.mm.ss Z");
	     f = new SimpleDateFormat("EEEE");
	     Date date = new Date();
	     String day = f.format(date);
	     System.out.println("Full Day Name = "+day);
	     
	     f = new SimpleDateFormat("MMM");
	     String Month = f.format(date);
	     System.out.println("Full Month Name = "+Month);
	     
	     f = new SimpleDateFormat("d");
	     String todaydate = f.format(date);
	     System.out.println("Full todaydate Name = "+todaydate);
	     
	     
	     
	     driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[3]/div/button[2]")).click();
		System.out.println("User entering the WebPage n see time :" + placeholderVal);
		String[] arrSplit = placeholderVal.split(" 2022");
	    for (int i=0; i < arrSplit.length; i++)
	    {
	    	placeholderVal=arrSplit[i];
	    	break;
	    }
	    System.out.println("User entering the WebPage n see time after split:" + placeholderVal);
	    if(placeholderVal.contentEquals(day+", "+Month+" "+todaydate+"th"))
		 {
	System.out.println("assertion passed");
		 }
	}
	
}
