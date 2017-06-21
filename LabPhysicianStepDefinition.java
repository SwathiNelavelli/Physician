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
import easytox.apptest.pages.LabPhysicianPage;
import easytox.apptest.pages.LablistPage;
import easytox.apptest.pages.LoginPage;
import easytox.apptest.pages.TestingProfilePage;
import easytox.apptest.utils.WebConnector;
import junit.framework.Assert;

public class LabPhysicianStepDefinition {
	
	WebDriver driver = null;
	LoginPage loginpage;
	WebConnector connector = new WebConnector();
	TestingProfilePage testingprofile = null;
	InsuranceCompanyPage insurancecompany = null;
	LabPhysicianPage labphysician = null;
	
	@Given("^enter easytox url for Lab Physician$")
	public void enter_easytox_url_for_Lab_Physician() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "src//test//java//easytox//apptest//driver//chromedriver.exe");
		driver = new ChromeDriver();
		loginpage = new LoginPage(driver);
		loginpage.navigatetowebApp();
		labphysician = new LabPhysicianPage(driver);
		insurancecompany = new InsuranceCompanyPage(driver);
	}

	@Given("^enter username as \"([^\"]*)\" for Lab Physician$")
	public void enter_username_as_for_Lab_Physician(String arg1) throws Throwable {
		String forgotpwd= driver.findElement(By.linkText("Click here")).getText();
		Assert.assertEquals("Click here", forgotpwd);
		System.out.println(forgotpwd);
		loginpage.EnterUserName(connector.getstring(WebConnector.myUrl.URL_SIT,"User_Username"));
	}

	@Given("^enter password as \"([^\"]*)\" for Lab Physician$")
	public void enter_password_as_for_Lab_Physician(String arg1) throws Throwable {
		loginpage.EnterPassword(connector.getstring(WebConnector.myUrl.URL_SIT,"User_Password"));
	}

	@Then("^user click on \"([^\"]*)\" button for Lab Physician$")
	public void user_click_on_button_for_Lab_Physician(String arg1) throws Throwable {
		loginpage.Loginbuttonclick();
	}
	
	@Then("^Close the Lab Physician browser$")
	public void close_the_Lab_Physician_browser() throws Throwable {
		loginpage.closeDriver();
	}
	
@When("^Click on Setting icon -> Select the \"([^\"]*)\"$")
public void click_on_Setting_icon_Select_the(String arg1) throws Throwable {
	insurancecompany.ClickOnSettingsIcon();
	labphysician.SelectPhysicianOption();
}

@Then("^Physician List page should be open$")
public void physician_List_page_should_be_open() throws Throwable {
	Thread.sleep(2000);
	String PhysicianListInfo = connector.getWebElement(driver, WebConnector.Identifier.xpath,
			     connector.getstring(WebConnector.myUrl.URL_OR,"PhysicianList_xpath")).getText();
	Assert.assertEquals("Physician List", PhysicianListInfo);
}

@When("^Click on \"([^\"]*)\" icon beside the Search Box in Physician List page$")
public void click_on_icon_beside_the_Search_Box_in_Physician_List_page(String arg1) throws Throwable {
	insurancecompany.ClickOnPlusIcon();
}

@Then("^\"([^\"]*)\" screen should be displayed to enter details$")
public void screen_should_be_displayed_to_enter_details(String arg1) throws Throwable {
	Thread.sleep(2000);
	String AddPhysicianInfo = connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"AddPhysicianPage_xpath")).getText();
Assert.assertEquals("Add Physician", AddPhysicianInfo);
}

//@When("^Enter all the information in the screen and click Submit$")
//public void enter_all_the_information_in_the_screen_and_click_Submit() throws Throwable {
//	Thread.sleep(1000);
//	connector.getWebElement(driver, WebConnector.Identifier.xpath,
//		     connector.getstring(WebConnector.myUrl.URL_OR,"PortalAccess_xpath")).click();
//	Thread.sleep(3000);
//}
//
//@When("^New Physician is created successfully$")
//public void new_Physician_is_created_successfully() throws Throwable {
//    // Write code here that turns the phrase above into concrete actions
//    throw new PendingException();
//}

@When("^Click Edit icon for an existing physician$")
public void click_Edit_icon_for_an_existing_physician() throws Throwable {
	Thread.sleep(2000);
	connector.getWebElement(driver, WebConnector.Identifier.xpath,
			connector.getstring(WebConnector.myUrl.URL_OR,"PhysicianEditIcon_xpath")).click();
}

@Then("^Update Physician screen is displayed$")
public void update_Physician_screen_is_displayed() throws Throwable {
	Thread.sleep(2000);
	String UpdatePhysicianPageInfo = connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"UpdatePhysicianPage_xpath")).getText();
Assert.assertEquals("Update Physician", UpdatePhysicianPageInfo);
}

@Then("^Verify User Information should be locked for editing$")
public void verify_user_Information_should_be_locked_for_editing() throws Throwable {
	boolean Username = connector.getWebElement(driver, WebConnector.Identifier.xpath,
	     connector.getstring(WebConnector.myUrl.URL_OR,"Username_xpath")).isEnabled();
	Assert.assertEquals(Username, false);
	
	boolean Password = connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"Password_xpath")).isEnabled();
	Assert.assertEquals(Password, false);
}

@When("^Make changes for \"([^\"]*)\" and \"([^\"]*)\" in Update Physician page -> click Update button$")
public void make_changes_for_and_in_Update_Physician_page_click_Update_button(String fname, String degree) throws Throwable {
	connector.getWebElement(driver, WebConnector.Identifier.xpath, 
			connector.getstring(WebConnector.myUrl.URL_OR, "UpdateFirstName_xpath")).clear();
	
	Thread.sleep(2000);
	
	connector.getWebElement(driver, WebConnector.Identifier.xpath, 
			connector.getstring(WebConnector.myUrl.URL_OR, "UpdateFirstName_xpath")).sendKeys(fname);
	
	connector.getWebElement(driver, WebConnector.Identifier.xpath, 
			connector.getstring(WebConnector.myUrl.URL_OR, "UpdateMedicalDegree_xpath")).clear();
	
	Thread.sleep(2000);
	
	connector.getWebElement(driver, WebConnector.Identifier.xpath, 
			connector.getstring(WebConnector.myUrl.URL_OR, "UpdateMedicalDegree_xpath")).sendKeys(degree);
			
			Thread.sleep(2000);
	
	connector.getWebElement(driver, WebConnector.Identifier.xpath, 
			connector.getstring(WebConnector.myUrl.URL_OR, "PhysicianUpdateButton_xpath")).click();
}

@When("^Updated \"([^\"]*)\" and \"([^\"]*)\" should be reflected$")
public void updated_and_should_be_reflected(String fname, String degree) throws Throwable {
	String ValidateUpdatedFirstName = connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"ValidateUpdatedFirstName_xpath")).getText();
//	Assert.assertTrue(ValidateUpdatedFirstName.contains("fname"));
//	Assert.assertEquals(fname, ValidateUpdatedFirstName);
	
	String ValidateUpdatedMedicalDegree = connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"ValidateUpdatedMedicalDegree_xpath")).getText();
//	Assert.assertEquals(degree, ValidateUpdatedMedicalDegree);
}

@When("^Enter any search criteria as \"([^\"]*)\" in the Lab Physician List$")
public void enter_any_search_criteria_as_in_the_Lab_Physician_List(String search) throws Throwable {
	 insurancecompany.EnterSearchCriteria(search);
}

@When("^Matching records with \"([^\"]*)\" should be displayed in the Lab Physician List$")
public void matching_records_with_should_be_displayed_in_the_Lab_Physician_List(String search) throws Throwable {
	insurancecompany.ValidatingSearchCriteria(search);
}

@When("^Verify the default number of records displayed in Lab Physician List$")
public void verify_the_default_number_of_records_displayed_in_Lab_Physician_List() throws Throwable {
	insurancecompany.DefaultNumberOfRecordsDisplayedOnPage();
}

@When("^Default number \"([^\"]*)\" should be displayed in Lab Physician List$")
public void default_number_should_be_displayed_in_Lab_Physician_List(String arg1) throws Throwable {
    insurancecompany.DefaultNumber10Displayed();
}

@When("^Click on dropdown that shows no of records to be displayed on the Lab Physician List$")
public void click_on_dropdown_that_shows_no_of_records_to_be_displayed_on_the_Lab_Physician_List() throws Throwable {
	insurancecompany.ClickOnDisplayPageDropdown();
}

@When("^Select the \"([^\"]*)\" and corresponding records to be displayed in Lab Physician List$")
public void select_the_and_corresponding_records_to_be_displayed_in_Lab_Physician_List(String option) throws Throwable {
	insurancecompany.SelectOptionInDisplayDropdown(option);
}


@When("^Click on \"([^\"]*)\" Up arrow icon on Physician List 'Username' column$")
public void click_on_Up_arrow_icon_on_Physician_List_Username_column(String arg1) throws Throwable {
	Thread.sleep(2000);
	connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"UsernameUpDownArrow_xpath")).click();
}

@Then("^Records should be displayed based on the ascending order in the Physician List 'Username'$")
public void records_should_be_displayed_based_on_the_ascending_order_in_the_Physician_List_Username() throws Throwable {
	Thread.sleep(2000);
	String sort = connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"UsernameUpDownArrow_xpath")).getAttribute("aria-sort");
    Assert.assertEquals("ascending", sort);
}

@When("^Click on \"([^\"]*)\" Down arrow icon on Physician List 'Username' column$")
public void click_on_Down_arrow_icon_on_Physician_List_Username_column(String arg1) throws Throwable {
	Thread.sleep(2000);
	connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"UsernameUpDownArrow_xpath")).click();
}

@Then("^Records should be displayed based on the desecending order in the Physician List 'Username'$")
public void records_should_be_displayed_based_on_the_desecending_order_in_the_Physician_List_Username() throws Throwable {
	Thread.sleep(2000);
	String sort = connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"UsernameUpDownArrow_xpath")).getAttribute("aria-sort");
   Assert.assertEquals("descending", sort);
}

@When("^Click on \"([^\"]*)\" Up arrow icon on Physician List 'Name' column$")
public void click_on_Up_arrow_icon_on_Physician_List_Name_column(String arg1) throws Throwable {
	Thread.sleep(2000);
	connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"NameUpDownArrow_xpath")).click();
}

@Then("^Records should be displayed based on the ascending order in the Physician List 'Name'$")
public void records_should_be_displayed_based_on_the_ascending_order_in_the_Physician_List_Name() throws Throwable {
	Thread.sleep(2000);
	String sort = connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"NameUpDownArrow_xpath")).getAttribute("aria-sort");
    Assert.assertEquals("ascending", sort);
}

@When("^Click on \"([^\"]*)\" Down arrow icon on Physician List 'Name' column$")
public void click_on_Down_arrow_icon_on_Physician_List_Name_column(String arg1) throws Throwable {
	Thread.sleep(2000);
	connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"NameUpDownArrow_xpath")).click();
}

@Then("^Records should be displayed based on the desecending order in the Physician List 'Name'$")
public void records_should_be_displayed_based_on_the_desecending_order_in_the_Physician_List_Name() throws Throwable {
	Thread.sleep(2000);
	String sort = connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"NameUpDownArrow_xpath")).getAttribute("aria-sort");
    Assert.assertEquals("descending", sort);
}

@When("^Click on \"([^\"]*)\" Up arrow icon on Physician List 'Portal Access' column$")
public void click_on_Up_arrow_icon_on_Physician_List_Portal_Access_column(String arg1) throws Throwable {
	Thread.sleep(2000);
	connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"PortalAccessUpDownArrow_xpath")).click();
}

@Then("^Records should be displayed based on the ascending order in the Physician List 'Portal Access'$")
public void records_should_be_displayed_based_on_the_ascending_order_in_the_Physician_List_Portal_Access() throws Throwable {
	Thread.sleep(2000);
	String sort = connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"PortalAccessUpDownArrow_xpath")).getAttribute("aria-sort");
    Assert.assertEquals("ascending", sort);
}

@When("^Click on \"([^\"]*)\" Down arrow icon on Physician List 'Portal Access' column$")
public void click_on_Down_arrow_icon_on_Physician_List_Portal_Access_column(String arg1) throws Throwable {
	Thread.sleep(2000);
	connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"PortalAccessUpDownArrow_xpath")).click();
}

@Then("^Records should be displayed based on the desecending order in the Physician List 'Portal Access'$")
public void records_should_be_displayed_based_on_the_desecending_order_in_the_Physician_List_Portal_Access() throws Throwable {
	Thread.sleep(2000);
	String sort = connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"PortalAccessUpDownArrow_xpath")).getAttribute("aria-sort");
    Assert.assertEquals("descending", sort);
}

@When("^Click on \"([^\"]*)\" Up arrow icon on Physician List 'Medical Degree' column$")
public void click_on_Up_arrow_icon_on_Physician_List_Medical_Degree_column(String arg1) throws Throwable {
	Thread.sleep(2000);
	connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"MedicalDegreeUpDownArrow_xpath")).click();
}

@Then("^Records should be displayed based on the ascending order in the Physician List 'Medical Degree'$")
public void records_should_be_displayed_based_on_the_ascending_order_in_the_Physician_List_Medical_Degree() throws Throwable {
	Thread.sleep(2000);
	String sort = connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"MedicalDegreeUpDownArrow_xpath")).getAttribute("aria-sort");
    Assert.assertEquals("ascending", sort);
}

@When("^Click on \"([^\"]*)\" Down arrow icon on Physician List 'Medical Degree' column$")
public void click_on_Down_arrow_icon_on_Physician_List_Medical_Degree_column(String arg1) throws Throwable {
	Thread.sleep(2000);
	connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"MedicalDegreeUpDownArrow_xpath")).click();
}

@Then("^Records should be displayed based on the desecending order in the Physician List 'Medical Degree'$")
public void records_should_be_displayed_based_on_the_desecending_order_in_the_Physician_List_Medical_Degree() throws Throwable {
	Thread.sleep(2000);
	String sort = connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"MedicalDegreeUpDownArrow_xpath")).getAttribute("aria-sort");
    Assert.assertEquals("descending", sort);
}

@When("^Click on \"([^\"]*)\" Up arrow icon on Physician List 'Salutation' column$")
public void click_on_Up_arrow_icon_on_Physician_List_Salutation_column(String arg1) throws Throwable {
	Thread.sleep(2000);
	connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"SalutationUpDownArrow_xpath")).click();
}

@Then("^Records should be displayed based on the ascending order in the Physician List 'Salutation'$")
public void records_should_be_displayed_based_on_the_ascending_order_in_the_Physician_List_Salutation() throws Throwable {
	Thread.sleep(2000);
	String sort = connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"SalutationUpDownArrow_xpath")).getAttribute("aria-sort");
    Assert.assertEquals("ascending", sort);
}

@When("^Click on \"([^\"]*)\" Down arrow icon on Physician List 'Salutation' column$")
public void click_on_Down_arrow_icon_on_Physician_List_Salutation_column(String arg1) throws Throwable {
	Thread.sleep(2000);
	connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"SalutationUpDownArrow_xpath")).click();
}

@Then("^Records should be displayed based on the desecending order in the Physician List 'Salutation'$")
public void records_should_be_displayed_based_on_the_desecending_order_in_the_Physician_List_Salutation() throws Throwable {
	Thread.sleep(2000);
	String sort = connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"SalutationUpDownArrow_xpath")).getAttribute("aria-sort");
    Assert.assertEquals("descending", sort);
}

@When("^Click on \"([^\"]*)\" Up arrow icon on Physician List 'Locations' column$")
public void click_on_Up_arrow_icon_on_Physician_List_Locations_column(String arg1) throws Throwable {
	Thread.sleep(2000);
	connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"LocationsUpDownArrow_xpath")).click();
}

@Then("^Records should be displayed based on the ascending order in the Physician List 'Locations'$")
public void records_should_be_displayed_based_on_the_ascending_order_in_the_Physician_List_Locations() throws Throwable {
	Thread.sleep(2000);
	String sort = connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"LocationsUpDownArrow_xpath")).getAttribute("aria-sort");
    Assert.assertEquals("ascending", sort);
}

@When("^Click on \"([^\"]*)\" Down arrow icon on Physician List 'Locations' column$")
public void click_on_Down_arrow_icon_on_Physician_List_Locations_column(String arg1) throws Throwable {
	Thread.sleep(2000);
	connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"LocationsUpDownArrow_xpath")).click();
}

@When("^Records should be displayed based on the desecending order in the Physician List 'Locations'$")
public void records_should_be_displayed_based_on_the_desecending_order_in_the_Physician_List_Locations() throws Throwable {
	Thread.sleep(2000);
	String sort = connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"LocationsUpDownArrow_xpath")).getAttribute("aria-sort");
    Assert.assertEquals("descending", sort);
}


@When("^Navigate back and forth by selecting page numbers -> Should navigate to selected Physician List page$")
public void navigate_back_and_forth_by_selecting_page_numbers_Should_navigate_to_selected_Physician_List_page() throws Throwable {
	insurancecompany.ClickOnNext();
    insurancecompany.ClickOnPrev();
    insurancecompany.ClickOnAnySelectedNumber();
}

@When("^A text message “Showing x to y of z entries” should be displayed on the bottom left corner of the Physician List$")
public void a_text_message_Showing_x_to_y_of_z_entries_should_be_displayed_on_the_bottom_left_corner_of_the_Physician_List() throws Throwable {
	insurancecompany.TextMessageOfPagesDisplayed();
}

}
	