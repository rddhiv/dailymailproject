package StepDefinitions;

import com.cucumberFramework.helper.WaitHelper;
import com.cucumberFramework.pageObjects.DailyMailPage;
import io.cucumber.java.en.*;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.cucumberFramework.testBase.TestBase;

public class DailyMailUI {
	WebDriver driver = null;
	DailyMailPage dmui = new DailyMailPage(driver);

	@Given("^User Open the Webpage \"([^\"]*)\"$")
	public void user_click_on_the_webpage(String arg1) {
		dmui.loginWebpage(arg1);
	}

	@Then("User can able to view the current date and time at the corner in the webpage")
	public void user_can_able_to_view_the_current_date_and_time_at_the_corner_in_the_webpage() {
		dmui.verifyTimeAndDate();
	}

	@And("User can able to view Sports tab and click on it and it Navigate to the Sport menu and Click Football tab and verify the color of the Tab")
	public void user_can_able_to_view_sports_tab_in_the_webpage_and_click_on_the_tab() {
		dmui.verifySportandFootballColor();
	}

	@Then("User should click on the Football page first hyperlink and content should get displayed")
	public void user_should_click_on_the_football_page_first_hyperlink_and_content_should_get_displayed() {
		dmui.verifyfootballPage();
	}

	@Then("User should Go to the gallery and Click on gallery image")
	public void user_should_go_to_the_gallery_and_click_on_gallery_image() {
		dmui.ClickGalleryContent();
	}

	@And("Gallery Image should display verify previous and next button with proper image navigation")
	public void gallery_image_should_display_verify_previous_and_next_button_with_proper_image_navigation() {
		dmui.checkPreviousNextButton();
	}

	@When("User should Click on the Facebook embedded image and FB model dialog should appear")
	public void user_should_click_on_the_facebook_embedded_image_and_fb_model_dialog_should_appear() {
		dmui.checkFaceBookPage();
	}

	@Then("User should click on video embedded within the article and click the full screen button")
	public void user_should_click_on_video_embedded_within_the_article_and_click_the_full_screen_button() {
		dmui.clickEmbeddedVideo();
	}

	@And("ensure video can be viewed in full screen and minimized")
	public void ensure_video_can_be_viewed_in_full_screen_and_minimized() {
		dmui.viewMaximizeMinimizeVideo();
	}

	@Then("Navigate to the bottom right of the article page to the Premier League Table section")
	public void navigate_to_the_bottom_right_of_the_article_page_to_the_premier_league_table_section() {
		dmui.clickPremierLeagueTable();
	}

	@And("exhibit the points or positions of {string} from the Premier league table")
	public void exhibit_the_points_or_positions_of_from_the_premier_league_table(String teamName) {
		dmui.checkPositionofPLT(teamName);
	}

	@And("User close the browser")
	public void user_close_the_browser() {
		dmui.userCloseBrowser();
	}
}
