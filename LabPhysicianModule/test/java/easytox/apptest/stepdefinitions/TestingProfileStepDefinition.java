package easytox.apptest.stepdefinitions;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import easytox.apptest.pages.AbstractPage;
import easytox.apptest.pages.InsuranceCompanyPage;
import easytox.apptest.pages.LablistPage;
import easytox.apptest.pages.LoginPage;
import easytox.apptest.pages.TestingProfilePage;
import easytox.apptest.utils.WebConnector;
import junit.framework.Assert;

public class TestingProfileStepDefinition {
	
	WebDriver driver = null;
	LoginPage loginpage;
	WebConnector connector = new WebConnector();
	TestingProfilePage testingprofile = null;
	InsuranceCompanyPage insurancecompany = null;
	
@Given("^enter easytox url for Testing Profile$")
public void enter_easytox_url_for_Testing_Profile() throws Throwable {
	System.setProperty("webdriver.chrome.driver", "src//test//java//easytox//apptest//driver//chromedriver.exe");
	driver = new ChromeDriver();
	loginpage = new LoginPage(driver);
	loginpage.navigatetowebApp();
	testingprofile = new TestingProfilePage(driver);
	insurancecompany = new InsuranceCompanyPage(driver);
}

@Given("^enter username as \"([^\"]*)\" for Testing Profile$")
public void enter_username_as_for_Testing_Profile(String arg1) throws Throwable {
	String forgotpwd= driver.findElement(By.linkText("Click here")).getText();
	Assert.assertEquals("Click here", forgotpwd);
	System.out.println(forgotpwd);
	loginpage.EnterUserName(connector.getstring(WebConnector.myUrl.URL_SIT,"User_Username"));
}

@Given("^enter password as \"([^\"]*)\" for Testing Profile$")
public void enter_password_as_for_Testing_Profile(String arg1) throws Throwable {
	loginpage.EnterPassword(connector.getstring(WebConnector.myUrl.URL_SIT,"User_Password"));
}

@Then("^user click on \"([^\"]*)\" button for Testing Profile$")
public void user_click_on_button_for_Testing_Profile(String arg1) throws Throwable {
	loginpage.Loginbuttonclick();
}	

@Then("^close the Test Profile browser$")
public void close_the_Test_Profile_browser() throws Throwable {
	loginpage.closeDriver();
}
	
@When("^Click on Library icon -> Select the \"([^\"]*)\"$")
public void click_on_Library_icon_Select_the(String arg1) throws Throwable {
	testingprofile.ClickOnLibraryIcon();
	testingprofile.SelectTestingProfileOption();
}

@Then("^Testing Profile page should be open$")
public void testing_Profile_page_should_be_open() throws Throwable {
	Thread.sleep(2000);
	String ProfileListInfo = connector.getWebElement(driver, WebConnector.Identifier.xpath,
			     connector.getstring(WebConnector.myUrl.URL_OR,"ProfileList_xpath")).getText();
	Assert.assertEquals("Profile", ProfileListInfo);
}

@When("^Enter any search criteria as \"([^\"]*)\"$")
public void enter_any_search_criteria_as(String search) throws Throwable {
	 insurancecompany.EnterSearchCriteria(search);
}

@Then("^Matching records with \"([^\"]*)\" should be displayed in the Test Profile$")
public void matching_records_with_should_be_displayed_in_the_Test_Profile(String search) throws Throwable {
	insurancecompany.ValidatingSearchCriteria(search);
}

@When("^Click on \"([^\"]*)\" icon beside the Search Box in Profile page$")
public void click_on_icon_beside_the_Search_Box_in_Profile_page(String arg1) throws Throwable {
	insurancecompany.ClickOnPlusIcon();
}

@Then("^\"([^\"]*)\" screen should be displayed for Profile page$")
public void screen_should_be_displayed_for_Profile_page(String arg1) throws Throwable {
	Thread.sleep(2000);
	String AddProfileInfo = connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"AddProfilePage_xpath")).getText();
Assert.assertEquals("Add Profile", AddProfileInfo);
}


@When("^Verify the default number of records displayed in Profile Page$")
public void verify_the_default_number_of_records_displayed_in_Profile_Page() throws Throwable {
	insurancecompany.DefaultNumberOfRecordsDisplayedOnPage();
}

@When("^Default number \"([^\"]*)\" should be displayed in Profile Page$")
public void default_number_should_be_displayed_in_Profile_Page(String arg1) throws Throwable {
	insurancecompany.DefaultNumber10Displayed();
}

@When("^Click on dropdown that shows no of records to be displayed on the Profile page$")
public void click_on_dropdown_that_shows_no_of_records_to_be_displayed_on_the_Profile_page() throws Throwable {
	insurancecompany.ClickOnDisplayPageDropdown();
}

@Then("^Select the \"([^\"]*)\" and corresponding records to be displayed in Profile page$")
public void select_the_and_corresponding_records_to_be_displayed_in_Profile_page(String option) throws Throwable {
	insurancecompany.SelectOptionInDisplayDropdown(option);
}

@When("^Click on \"([^\"]*)\" Up arrow icon on Profile Name column$")
public void click_on_Up_arrow_icon_on_Profile_Name_column(String arg1) throws Throwable {
	Thread.sleep(2000);
	connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"ProfileNameUpDownArrow_xpath")).click();
}

@Then("^Records should be displayed based on the ascending order of the Profile Name$")
public void records_should_be_displayed_based_on_the_ascending_order_of_the_Profile_Name() throws Throwable {
	Thread.sleep(2000);
	String sort = connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"ProfileNameUpDownArrow_xpath")).getAttribute("aria-sort");
    Assert.assertEquals("ascending", sort);
}

@When("^Click on \"([^\"]*)\" Down arrow icon on Profile Name column$")
public void click_on_Down_arrow_icon_on_Profile_Name_column(String arg1) throws Throwable {
	Thread.sleep(2000);
	connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"ProfileNameUpDownArrow_xpath")).click();
}

@Then("^Records should be displayed based on the desecending order of the Profile Name$")
public void records_should_be_displayed_based_on_the_desecending_order_of_the_Profile_Name() throws Throwable {
	Thread.sleep(2000);
	String sort = connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"ProfileNameUpDownArrow_xpath")).getAttribute("aria-sort");
   Assert.assertEquals("descending", sort);
}


@When("^Click on Edit under Action Column in Profile page$")
public void click_on_Edit_under_Action_Column_in_Profile_page() throws Throwable {
	Thread.sleep(2000);
	connector.getWebElement(driver, WebConnector.Identifier.xpath,
			connector.getstring(WebConnector.myUrl.URL_OR,"EditButton_xpath")).click();
}

@Then("^\"([^\"]*)\" window should be displayed for Profile page$")
public void window_should_be_displayed_for_Profile_page(String arg1) throws Throwable {
	Thread.sleep(2000);
	String EditProfileInfo = connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"EditProfileInfo_xpath")).getText();
Assert.assertEquals("Edit Profile", EditProfileInfo);
}

@When("^Navigate back and forth by selecting page numbers -> Should navigate to selected Profile page$")
public void navigate_back_and_forth_by_selecting_page_numbers_Should_navigate_to_selected_Profile_page() throws Throwable {
	insurancecompany.ClickOnNext();
    insurancecompany.ClickOnPrev();
    insurancecompany.ClickOnAnySelectedNumber();
}

@When("^A text message “Showing x to y of z entries” should be displayed on the bottom left corner of the Profile list$")
public void a_text_message_Showing_x_to_y_of_z_entries_should_be_displayed_on_the_bottom_left_corner_of_the_Profile_list() throws Throwable {
	insurancecompany.TextMessageOfPagesDisplayed();
}

}