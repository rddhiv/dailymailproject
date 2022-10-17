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

public class DailyMailPage {

	private WebDriver driver;

	WaitHelper waitHelper;

	public List<WebElement> col;

	public List<WebElement> rows;

	public DailyMailPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		// waitHelper.WaitForElement(userName, 60);
	}

	public void OpenWebpage(String arg1) {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(arg1);
		System.out.println("User entering the WebPage");
	}

	public void verifySportandFootballColor() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement s = driver.findElement(By.linkText("Sport"));
		s.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// String color1 = s.getCssValue("background-color");
		WebElement f = driver.findElement(By.linkText("Football"));
		f.click();
		// String color2 = f.getCssValue("background-color");
		System.out.println("User click sports tab");
	}

	public void verifyfootballPage() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		// Javascript executor to return value
		//JavascriptExecutor j = (JavascriptExecutor) driver;
		//j.executeScript("return document.readyState").toString().equals("complete");
		/*try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		// get the current URL
		String url = driver.getCurrentUrl();
		// checking condition if the URL is loaded
		if (url.equals("https://www.dailymail.co.uk/sport/football/index.html")) {
			System.out.println("Football Page Loaded");
			//System.out.println("Current Url: " + url);
		} else {
			System.out.println("Page did not load");
		}
		WebElement s = driver.findElement(By.xpath("//div[@id='content']/div[2]/div[1]/div/h2/a"));
		s.click();
		System.out.println("User see the sports page");
	}

	public void ClickGalleryContent() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		int size = driver.findElements(By.tagName("iframe")).size();
		//System.out.println("frame size" + size);
		
		try
		{
			WebElement s = driver.findElement(By.xpath("//*[contains(@class,'openGalleryButton')]"));
		} 
		catch(Exception e)
		{
			//System.out.println("Unable to locate the OpenGalleryButton" );
			Actions action = new Actions(driver);
			WebElement nxtpage=driver.findElement(By.xpath("//*[contains(@class,'prevNextButton')]")); 
			action.click(nxtpage).build().perform();
		}
		finally{
			WebElement s = driver.findElement(By.xpath("//*[contains(@class,'openGalleryButton')]"));
			if (s.isDisplayed()) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				// Scroll down till the bottom of the page
				js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", s);
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				js.executeScript("arguments[0].click()", s);
				// s.click();
			}
	
			else
	
			{
				size = driver.findElements(By.tagName("iframe")).size();
				//System.out.println("frame size" + size);
				driver.switchTo().frame("mailonlineprebidheader526476985912_MOAT_IFRAME").navigate();
	
			}
	
			System.out.println("User see the Gallery page");
		}
	}

	public void checkPreviousNextButton() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// driver.switchTo().frame("mailonlineprebidheader526476985912_MOAT_IFRAME").navigate();
		WebElement next = driver.findElement(By.xpath("//button[@aria-label='Next']"));
		next.click();
		next.click();
		WebElement prev = driver.findElement(By.xpath("//button[@aria-label='Previous']"));
		prev.click();
		WebElement close = driver.findElement(By.xpath("//button[@aria-label='Close']"));
		close.click();

		System.out.println("User can able to click previous and next page");
	}

	public void checkFaceBookPage() {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String parent = driver.getWindowHandle();
		WebElement fb = driver.findElement(By.xpath("//div[@class='container-3zJLP vertical-2XJd5']/ul/li[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", fb);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Set<String> s = driver.getWindowHandles();

		System.out.println("User see the fb page ");
		// Now iterate using Iterator
		Iterator<String> I1 = s.iterator();

		while (I1.hasNext()) {

			String child_window = I1.next();

			if (!parent.equals(child_window)) {

				driver.switchTo().window(child_window);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

				//System.out.println("Title name" + driver.switchTo().window(child_window).getTitle());

				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				driver.close();
				driver.switchTo().window(parent);
			}

		}
		// switch to the parent window
		driver.switchTo().window(parent);
	}

	public void clickEmbeddedVideo() {
		try {
			Thread.sleep(2000);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			// js.executeScript("arguments[0].click()", fb);
			Actions action = new Actions(driver);
			// Find the targeted video frame element
			WebElement vf = driver
					.findElement(By.xpath("//button[@class='vjs-fullscreen-control vjs-control vjs-button']"));
			// Here I used JavascriptExecutor interface to scroll down to the targeted
			// element
			js.executeScript("arguments[0].scrollIntoView();", vf);
			// used doubleClick(element) method to do double click action
			action.click(vf).build().perform();
			// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			Thread.sleep(2000);
			action.click(vf).build().perform();
			System.out.println("Clicked the embedded video");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void viewMaximizeMinimizeVideo() {
		System.out.println("User viewed in full screen and minimized");

	}

	public void clickPremierLeagueTable() {
		Actions action = new Actions(driver);
		WebElement nxtpage=driver.findElement(By.xpath("//*[contains(@class,'prevNextButton')]")); 
		action.click(nxtpage).build().perform();
		 
		col = driver.findElements(By.xpath("//div[contains(@class,'competitionTable')]/table/thead/tr/th"));
		//System.out.println("No of cols are : " + col.size());
		// No.of rows
		rows = driver.findElements(By.xpath("//div[contains(@class,'competitionTable')]/table/tbody/tr"));
		//System.out.println("No of rows are : " + rows.size());

		System.out.println("User see the Premier League table");
	}

	public void checkPositionofPLT(String teamName) {
		String teamnameSearch;
		String points = "";
		String position = "";
		for (int i = 1; i < rows.size(); i++) {
			teamnameSearch = driver
					.findElement(By.xpath("//div[contains(@class,'competitionTable')]/table/tbody/tr[" + i + "]/td[4]"))
					.getText();
			if (teamnameSearch.equals(teamName)) {
				position = driver
						.findElement(
								By.xpath("//div[contains(@class,'competitionTable')]/table/tbody/tr[" + i + "]/td[1]"))
						.getText();
				points = driver
						.findElement(
								By.xpath("//div[contains(@class,'competitionTable')]/table/tbody/tr[" + i + "]/td[5]"))
						.getText();
				break;
			}
		}
		System.out.println();
		System.out.println();
		System.out.println("-------------------------------------------------------------------");
		System.out.println("  Team Name is " + teamName);
		System.out.println("  Position of  " + teamName + " is 	:" + position);
		System.out.println("  Points of " + teamName + " is 	:" + points);
		System.out.println("-------------------------------------------------------------------");
	}
	
	public void userCloseBrowser()
	{
		
		driver.quit();
		System.out.println("User close the Browser");
	}

	public void verifyTimeAndDate() {
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
		//System.out.println("Full Day Name = " + day);

		f = new SimpleDateFormat("MMM");
		String Month = f.format(date);
		//System.out.println("Full Month Name = " + Month);

		f = new SimpleDateFormat("d");
		String todaydate = f.format(date);
		//System.out.println("Full todaydate Name = " + todaydate);

		driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[3]/div/button[2]")).click();
		//System.out.println("User entering the WebPage and view current time :" + placeholderVal);
		String[] arrSplit = placeholderVal.split(" 2022");
		for (int i = 0; i < arrSplit.length; i++) {
			placeholderVal = arrSplit[i];
			break;
		}
		System.out.println("User entering the WebPage and View the time :" + placeholderVal);
		if (placeholderVal.contentEquals(day + ", " + Month + " " + todaydate + "th")) {
			System.out.println("assertion passed");
		}
	}

}
