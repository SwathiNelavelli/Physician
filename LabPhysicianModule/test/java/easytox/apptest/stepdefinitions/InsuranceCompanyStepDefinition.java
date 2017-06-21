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
import easytox.apptest.utils.WebConnector;
import junit.framework.Assert;

public class InsuranceCompanyStepDefinition {
	
	WebDriver driver = null;	
	LoginPage loginpage;
	WebConnector connector = new WebConnector();
	InsuranceCompanyPage insurancecompany = null;
	
	@Given("^user enter easytox url$")
	public void user_enter_easytox_url() {
		System.setProperty("webdriver.chrome.driver", "src//test//java//easytox//apptest//driver//chromedriver.exe");
		driver = new ChromeDriver();
		loginpage = new LoginPage(driver);
		loginpage.navigatetowebApp();
		insurancecompany = new InsuranceCompanyPage(driver);
	
	//	Assert.assertEquals(forgotpwd, "Click here");
		//System.out.println(forgotpwd);
	}
		
	    
	@Given("^enter username as \"([^\"]*)\"$")
	public void enter_username_as(String arg1) throws Throwable {
		String forgotpwd= driver.findElement(By.linkText("Click here")).getText();
		Assert.assertEquals("Click here", forgotpwd);
		System.out.println(forgotpwd);
		loginpage.EnterUserName(connector.getstring(WebConnector.myUrl.URL_SIT,"User_Username"));
	}
	
	@And("^enter password as \"([^\"]*)\"$")
	public void enter_the_password(String arg1) {
		loginpage.EnterPassword(connector.getstring(WebConnector.myUrl.URL_SIT,"User_Password"));
	}

	@Then("^user click on \"([^\"]*)\" button$")
	public void user_click_on_button(String arg1) {
		loginpage.Loginbuttonclick();		
	}
	
	@Then("^closes the browser$")
	public void closes_the_browser() {
	   loginpage.closeDriver();
	}
	
//	-----------------------------------------------------
	
	@When("^Select Settings ->Insurance Company$")
	public void select_Settings_Insurance_Company() throws Throwable {
		insurancecompany.ClickOnSettingsIcon();
		insurancecompany.SelectInsuranceCompanyOption();
	}

	@Then("^Insurance Company List screen is displayed$")
	public void insurance_Company_List_screen_is_displayed() throws Throwable {
		Thread.sleep(2000);
		String InsuranceCompanyListInfo = connector.getWebElement(driver, WebConnector.Identifier.xpath,
				     connector.getstring(WebConnector.myUrl.URL_OR,"InsuranceCompanyList_xpath")).getText();
		Assert.assertEquals("Insurance Company List", InsuranceCompanyListInfo);
	}

	@When("^Click Add Insurance Company \"([^\"]*)\" icon$")
	public void click_Add_Insurance_Company_icon(String arg1) throws Throwable {
		insurancecompany.ClickOnPlusIcon();
	}

	@Then("^'Add Insurance Company' page should be displayed$")
	public void add_Insurance_Company_page_should_be_displayed() throws Throwable {
		Thread.sleep(2000);
		String AddInsuranceCompanyPageInfo = connector.getWebElement(driver, WebConnector.Identifier.xpath,
			     connector.getstring(WebConnector.myUrl.URL_OR,"AddInsuranceCompanyPage_xpath")).getText();
	Assert.assertEquals("Add Insurance Company", AddInsuranceCompanyPageInfo);
	}
	
	@When("^Enter CompanyCodeInfo as \"([^\"]*)\"$")
	public void enter_CompanyCodeInfo_as(String companycode) throws Throwable {
	   driver.findElement(By.xpath("//*[@id='form']/div[1]/div/input")).sendKeys(companycode);
	}

	@When("^Enter CompanyNameInfo as \"([^\"]*)\"$")
	public void enter_CompanyNameInfo_as(String companyname) throws Throwable {
		driver.findElement(By.xpath("//*[@id='form']/div[2]/div/input")).sendKeys(companyname);
	}

	@When("^Entered \"([^\"]*)\" Info$")
	public void entered_Info(String address1) throws Throwable {
		driver.findElement(By.xpath("//*[@id='form']/div[3]/div[1]/input")).sendKeys(address1);
	}

	@When("^Enter \"([^\"]*)\" Info$")
	public void enter_Info(String address2) throws Throwable {
		driver.findElement(By.xpath("//*[@id='form']/div[3]/div[2]/input")).sendKeys(address2);
	}

	@When("^Enter ZipcodeInfo as \"([^\"]*)\"$")
	public void enter_ZipcodeInfo_as(String zipcode) throws Throwable {
		driver.findElement(By.xpath("//*[@id='zip']")).sendKeys(zipcode);
	}

	@When("^Enter CityInfo as \"([^\"]*)\"$")
	public void enter_CityInfo_as(String city) throws Throwable {
		driver.findElement(By.xpath("//*[@id='city']")).sendKeys(city);
	}

	@When("^Enter StateInfo as \"([^\"]*)\"$")
	public void enter_StateInfo_as(String state) throws Throwable {
		driver.findElement(By.xpath("//*[@id='state']")).sendKeys(state);
	}

	@When("^\"([^\"]*)\" Info enter$")
	public void info_enter(String Phone1) throws Throwable {
		driver.findElement(By.xpath("//*[@id='form']/div[5]/div[1]/input")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='form']/div[5]/div[1]/input")).sendKeys(Phone1);
		//Thread.sleep(3000);
	}

	@When("^\"([^\"]*)\" Info  entered$")
	public void info_entered(String Phone2) throws Throwable {
		driver.findElement(By.xpath("//*[@id='form']/div[5]/div[2]/input")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='form']/div[5]/div[2]/input")).sendKeys(Phone2);
		//Thread.sleep(3000);
	}

	@When("^Enter FaxInfo as \"([^\"]*)\"$")
	public void enter_FaxInfo_as(String faxnumber) throws Throwable {
		driver.findElement(By.xpath("//*[@id='form']/div[5]/div[3]/input")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='form']/div[5]/div[3]/input")).sendKeys(faxnumber);
		//Thread.sleep(3000);
	}

	@When("^Enter EmailInfo as \"([^\"]*)\"$")
	public void enter_EmailInfo_as(String email) throws Throwable {
		driver.findElement(By.xpath("//*[@id='form']/div[6]/div[1]/input")).sendKeys(email);
	}

	@When("^Enter WebsiteInfo as \"([^\"]*)\"$")
	public void enter_WebsiteInfo_as(String website) throws Throwable {
		driver.findElement(By.xpath("//*[@id='form']/div[6]/div[2]/input")).sendKeys(website);
	}

	@When("^Enter PayerIdInfo as \"([^\"]*)\"$")
	public void enter_PayerIdInfo_as(String payerid) throws Throwable {
		driver.findElement(By.xpath("//*[@id='form']/div[7]/div[1]/input")).sendKeys(payerid);
	}

	@When("^Enter AdjusterInfo as \"([^\"]*)\"$")
	public void enter_AdjusterInfo_as(String adjuster) throws Throwable {
		driver.findElement(By.xpath("//*[@id='form']/div[7]/div[2]/input")).sendKeys(adjuster);
	}

	@When("^Enter StatusInfo as \"([^\"]*)\"$")
	public void enter_StatusInfo_as(String status) throws Throwable {
		driver.findElement(By.xpath("//*[@id='form']/div[8]/div[1]/input")).sendKeys(status);
	}

	@When("^Enter PayNumInfo as \"([^\"]*)\"$")
	public void enter_PayNumInfo_as(String paynum) throws Throwable {
		driver.findElement(By.xpath("//*[@id='form']/div[8]/div[2]/input")).sendKeys(paynum);
	}

	@When("^Click on Submit button$")
	public void click_on_Submit_button() throws Throwable {
		Thread.sleep(2000);
		connector.getWebElement(driver, WebConnector.Identifier.xpath,
				connector.getstring(WebConnector.myUrl.URL_OR,"AddInsuranceCompanySubmitButton_xpath")).click();
	}
	
	@Then("^A new insurance company as \"([^\"]*)\" should be created successfully\\.$")
	public void a_new_insurance_company_as_should_be_created_successfully(String companyname) throws Throwable {
		Thread.sleep(2000);
		String AddInsuranceCompanySuccessMessage = connector.getWebElement(driver, WebConnector.Identifier.xpath,
				     connector.getstring(WebConnector.myUrl.URL_OR,"AddInsuranceCompanySuccessMessage_xpath")).getText();
		System.out.println(AddInsuranceCompanySuccessMessage);
		//Assert.assertTrue("Success Insurance Company Created",AddInsuranceCompanySuccessMessage.contains("Success Insurance Company" + companyname + "created"));
	}
	
	@When("^Click \\+ icon against the new \"([^\"]*)\" and \"([^\"]*)\"insurance company -> Data should be correctly populated$")
	public void click_icon_against_the_new_and_insurance_company_Data_should_be_correctly_populated(String code, String name) throws Throwable {
		Thread.sleep(2000);
		connector.getWebElement(driver, WebConnector.Identifier.xpath,
				connector.getstring(WebConnector.myUrl.URL_OR,"PageDisplayOption_xpath")).click();
		
		Thread.sleep(2000);
		new Select(connector.getWebElement(driver, WebConnector.Identifier.xpath, 
				connector.getstring(WebConnector.myUrl.URL_OR, "PageDisplayOption_xpath"))).selectByVisibleText("All");
		
		int rowCount=driver.findElements(By.xpath("//*[@id='example']/tbody/tr")).size();
		driver.findElement(By.xpath("//*[@id='example']/tbody/tr["+rowCount+"]/td[1]")).click();
		
		String ValidateCompanyCode = driver.findElement(By.xpath("//*[@id='example']/tbody/tr["+rowCount+"]/td[2]")).getText();
		Assert.assertEquals(code, ValidateCompanyCode);
		
		String ValidateCompanyName = driver.findElement(By.xpath("//*[@id='example']/tbody/tr["+rowCount+"]/td[3]")).getText();
		Assert.assertEquals(name, ValidateCompanyName);
	}

// ** Scenario 2 **-\\	
	
	@When("^Click Edit icon for a Insurance Company$")
	public void click_Edit_icon_for_a_Insurance_Company() throws Throwable {
	    insurancecompany.ClickOnEditIcon();
	}

	@Then("^'Update Insurance Company' page should be displayed$")
	public void update_Insurance_Company_page_should_be_displayed() throws Throwable {
		Thread.sleep(2000);
		String UpdateInsuranceCompanyPageInfo = connector.getWebElement(driver, WebConnector.Identifier.xpath,
			     connector.getstring(WebConnector.myUrl.URL_OR,"UpdateInsuranceCompanyPage_xpath")).getText();
	Assert.assertEquals("Update Insurance Company", UpdateInsuranceCompanyPageInfo);
	}
	
	@When("^Make changes for \"([^\"]*)\" and \"([^\"]*)\" -> click Update button$")
	public void make_changes_for_and_click_Submit(String code, String name) throws Throwable {
		connector.getWebElement(driver, WebConnector.Identifier.xpath, 
				connector.getstring(WebConnector.myUrl.URL_OR, "UpdateCompanyCode_xpath")).clear();
		
		Thread.sleep(2000);
		
		connector.getWebElement(driver, WebConnector.Identifier.xpath, 
				connector.getstring(WebConnector.myUrl.URL_OR, "UpdateCompanyCode_xpath")).sendKeys(code);
		
		connector.getWebElement(driver, WebConnector.Identifier.xpath, 
				connector.getstring(WebConnector.myUrl.URL_OR, "UpdateCompanyName_xpath")).clear();
		
		Thread.sleep(2000);
		
		connector.getWebElement(driver, WebConnector.Identifier.xpath, 
				connector.getstring(WebConnector.myUrl.URL_OR, "UpdateCompanyName_xpath")).sendKeys(name);
		
		connector.getWebElement(driver, WebConnector.Identifier.xpath, 
				connector.getstring(WebConnector.myUrl.URL_OR, "UpdateCompanyName_xpath")).sendKeys(Keys.TAB);
				
				Thread.sleep(2000);
		
		connector.getWebElement(driver, WebConnector.Identifier.xpath, 
				connector.getstring(WebConnector.myUrl.URL_OR, "UpdateButton_xpath")).click();
	}
	
	@Then("^Insurance Company \"([^\"]*)\" should be updated successfully$")
	public void insurance_Company_should_be_updated_successfully(String name) throws Throwable {
		Thread.sleep(2000);
		String UpdateInsuranceCompanySuccessMessage = connector.getWebElement(driver, WebConnector.Identifier.xpath,
				     connector.getstring(WebConnector.myUrl.URL_OR,"UpdateInsuranceCompanySuccessMessage_xpath")).getText();
		System.out.println(UpdateInsuranceCompanySuccessMessage);
		//Assert.assertTrue("Success Insurance Company Updated",UpdateInsuranceCompanySuccessMessage.contains("Success Insurance Company" + name + "updated"));
	}

	@When("^Click \\+ icon against the updated \"([^\"]*)\" \"([^\"]*)\" insurance company -> Changes should be reflected$")
	public void click_icon_against_the_updated_insurance_company_Changes_should_be_reflected(String code, String name) throws Throwable {
		connector.getWebElement(driver, WebConnector.Identifier.xpath,
				connector.getstring(WebConnector.myUrl.URL_OR,"PlusIconAgainstUpdatedCompanyCode_xpath")).click();
		
		String ValidateUpdatedCompanycode = connector.getWebElement(driver, WebConnector.Identifier.xpath,
			     connector.getstring(WebConnector.myUrl.URL_OR,"ValidateUpdatedCompanycode_xpath")).getText();
		Assert.assertEquals(code, ValidateUpdatedCompanycode);
		
		String ValidateUpdatedCompanyname = connector.getWebElement(driver, WebConnector.Identifier.xpath,
			     connector.getstring(WebConnector.myUrl.URL_OR,"ValidateUpdatedCompanyname_xpath")).getText();
		Assert.assertEquals(name, ValidateUpdatedCompanyname);
	}
	
	//--**--Scenario 3--**--//
	
	@When("^Click Delete button -> Confirmation message box is displayed$")
	public void click_Delete_button_Confirmation_message_box_is_displayed() throws Throwable {
	  insurancecompany.ClickOnDeleteButton();
	}

	@Then("^Click \"([^\"]*)\" on confirmation message box -> Insurance company not deleted$")
	public void click_on_confirmation_message_box_Insurance_company_not_deleted(String arg1) throws Throwable {
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		alert.dismiss();
	}
	
	@When("^Click \"([^\"]*)\" on confirmation message box -> Insurance company deleted$")
	public void click_on_confirmation_message_box_Insurance_company_deleted(String arg1) throws Throwable {
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		alert.accept();
		Thread.sleep(2000);
		String DeletedInsuranceCompanySuccessMessage = connector.getWebElement(driver, WebConnector.Identifier.xpath,
			     connector.getstring(WebConnector.myUrl.URL_OR,"DeletedInsuranceCompanySuccessMessage_xpath")).getText();
	System.out.println(DeletedInsuranceCompanySuccessMessage);
	//Assert.assertTrue("Success Insurance Company Deleted",DeletedInsuranceCompanySuccessMessage.contains("Success Insurance Company deleted"));
	Thread.sleep(2000);
	}
	
	//----*** Scenario 4 ---***---///
	
	@When("^Enter any search criteria as \"([^\"]*)\" in search box$")
	public void enter_any_search_criteria_as_and_click_on_search_icon(String search) throws Throwable {
	    insurancecompany.EnterSearchCriteria(search);
	}
	@When("^Matching records with \"([^\"]*)\" data should be displayed in the Insurance Company List$")
	public void matching_records_with_data_should_be_displayed_in_the_Insurance_Company_List(String search) throws Throwable {
		 insurancecompany.ValidatingSearchCriteria(search);
	}
	
	
	//--**--Scenario 5**---//
	
	@When("^Verify the default number of records displayed$")
	public void verify_the_default_number_of_records_displayed() throws Throwable {
		insurancecompany.DefaultNumberOfRecordsDisplayedOnPage();
	}

	@Then("^Default number \"([^\"]*)\" should be displayed in the dropdown box$")
	public void default_number_should_be_displayed_in_the_dropdown_box(String arg1) throws Throwable {
		insurancecompany.DefaultNumber10Displayed();
	}

	@When("^Click on dropdown that shows no of records to be displayed on the page$")
	public void click_on_dropdown_that_shows_no_of_records_to_be_displayed_on_the_page() throws Throwable {
		insurancecompany.ClickOnDisplayPageDropdown();
	}

	@When("^Select the \"([^\"]*)\" and corresponding records to be displayed$")
	public void select_the_and_corresponding_records_to_be_displayed(String option) throws Throwable {
		insurancecompany.SelectOptionInDisplayDropdown(option);
	}
	
//----****---Scenario 6----***---//
	
@When("^Click on Up arrow next to Company Code$")
public void click_on_Up_arrow_next_to_Company_Code() throws Throwable {
	Thread.sleep(2000);
	connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"CompanyCodeUpDownArrow_xpath")).click();
}

@Then("^Records should be sorted ascending order in Company Code column$")
public void records_should_be_sorted_ascending_order_in_Company_Code_column() throws Throwable {
	Thread.sleep(2000);
	String sort = connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"CompanyCodeUpDownArrow_xpath")).getAttribute("aria-sort");
    Assert.assertEquals("ascending", sort);
}

@When("^Click on Down arrow next to Company Code$")
public void click_on_Down_arrow_next_to_Company_Code() throws Throwable {
	Thread.sleep(2000);
	connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"CompanyCodeUpDownArrow_xpath")).click();
}

@Then("^Records should be sorted descending order in Company Code column$")
public void records_should_be_sorted_descending_order_in_Company_Code_column() throws Throwable {
	Thread.sleep(2000);
	String sort = connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"CompanyCodeUpDownArrow_xpath")).getAttribute("aria-sort");
   Assert.assertEquals("descending", sort);
}

@When("^Click on Up arrow next to Company Name$")
public void click_on_Up_arrow_next_to_Company_Name() throws Throwable {
	Thread.sleep(2000);
	connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"CompanyNameUpDownArrow_xpath")).click();
}

@Then("^Records should be sorted ascending order in Company Name column$")
public void records_should_be_sorted_ascending_order_in_Company_Name_column() throws Throwable {
	Thread.sleep(2000);
	String sort = connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"CompanyNameUpDownArrow_xpath")).getAttribute("aria-sort");
    Assert.assertEquals("ascending", sort);
}

@When("^Click on Down arrow next to Company Name$")
public void click_on_Down_arrow_next_to_Company_Name() throws Throwable {
	Thread.sleep(2000);
	connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"CompanyNameUpDownArrow_xpath")).click();
}

@Then("^Records should be sorted descending order in Company Name column$")
public void records_should_be_sorted_descending_order_in_Company_Name_column() throws Throwable {
	Thread.sleep(2000);
	String sort = connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"CompanyNameUpDownArrow_xpath")).getAttribute("aria-sort");
    Assert.assertEquals("descending", sort);
}


@When("^Click on Up arrow next to Contact Number$")
public void click_on_Up_arrow_next_to_Contact_Number() throws Throwable {
	Thread.sleep(2000);
	connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"ContactNumberUpDownArrow_xpath")).click();
}

@Then("^Records should be sorted ascending order in Contact Number column$")
public void records_should_be_sorted_ascending_order_in_Contact_Number_column() throws Throwable {
	Thread.sleep(2000);
	String sort = connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"ContactNumberUpDownArrow_xpath")).getAttribute("aria-sort");
    Assert.assertEquals("ascending", sort);
}

@When("^Click on Down arrow next to Contact Number$")
public void click_on_Down_arrow_next_to_Contact_Number() throws Throwable {
	Thread.sleep(2000);
	connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"ContactNumberUpDownArrow_xpath")).click();
}

@Then("^Records should be sorted descending order in Contact Number column$")
public void records_should_be_sorted_descending_order_in_Contact_Number_column() throws Throwable {
	Thread.sleep(2000);
	String sort = connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"ContactNumberUpDownArrow_xpath")).getAttribute("aria-sort");
    Assert.assertEquals("descending", sort);
}

@When("^Click on Up arrow next to Fax$")
public void click_on_Up_arrow_next_to_Fax() throws Throwable {
	Thread.sleep(2000);
	connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"FaxUpDownArrow_xpath")).click();
}

@Then("^Records should be sorted ascending order in Fax column$")
public void records_should_be_sorted_ascending_order_in_Fax_column() throws Throwable {
	Thread.sleep(2000);
	String sort = connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"FaxUpDownArrow_xpath")).getAttribute("aria-sort");
    Assert.assertEquals("ascending", sort);
}

@When("^Click on Down arrow next to Fax$")
public void click_on_Down_arrow_next_to_Fax() throws Throwable {
	Thread.sleep(2000);
	connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"FaxUpDownArrow_xpath")).click();
}

@Then("^Records should be sorted descending order in Fax column$")
public void records_should_be_sorted_descending_order_in_Fax_column() throws Throwable {
	Thread.sleep(2000);
	String sort = connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"FaxUpDownArrow_xpath")).getAttribute("aria-sort");
    Assert.assertEquals("descending", sort);
}

@When("^Click on Up arrow next to Email$")
public void click_on_Up_arrow_next_to_Email() throws Throwable {
	Thread.sleep(2000);
	connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"EmailUpDownArrow_xpath")).click();
}

@Then("^Records should be sorted ascending order in Email column$")
public void records_should_be_sorted_ascending_order_in_Email_column() throws Throwable {
	Thread.sleep(2000);
	String sort = connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"EmailUpDownArrow_xpath")).getAttribute("aria-sort");
    Assert.assertEquals("ascending", sort);
}

@When("^Click on Down arrow next to Email$")
public void click_on_Down_arrow_next_to_Email() throws Throwable {
	Thread.sleep(2000);
	connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"EmailUpDownArrow_xpath")).click();
}

@Then("^Records should be sorted descending order in Email column$")
public void records_should_be_sorted_descending_order_in_Email_column() throws Throwable {
	Thread.sleep(2000);
	String sort = connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"EmailUpDownArrow_xpath")).getAttribute("aria-sort");
    Assert.assertEquals("descending", sort);
}


@When("^Click on Up arrow next to Website$")
public void click_on_Up_arrow_next_to_Website() throws Throwable {
	Thread.sleep(2000);
	connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"WebsiteUpDownArrow_xpath")).click();
}

@Then("^Records should be sorted ascending order in Website column$")
public void records_should_be_sorted_ascending_order_in_Website_column() throws Throwable {
	Thread.sleep(2000);
	String sort = connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"WebsiteUpDownArrow_xpath")).getAttribute("aria-sort");
    Assert.assertEquals("ascending", sort);
}

@When("^Click on Down arrow next to Website$")
public void click_on_Down_arrow_next_to_Website() throws Throwable {
	Thread.sleep(2000);
	connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"WebsiteUpDownArrow_xpath")).click();
}

@Then("^Records should be sorted descending order in Website column$")
public void records_should_be_sorted_descending_order_in_Website_column() throws Throwable {
	Thread.sleep(2000);
	String sort = connector.getWebElement(driver, WebConnector.Identifier.xpath,
		     connector.getstring(WebConnector.myUrl.URL_OR,"WebsiteUpDownArrow_xpath")).getAttribute("aria-sort");
    Assert.assertEquals("descending", sort);
}

//---***---Scenario 7----***---//

@When("^Navigate back and forth by selecting page numbers -> Should navigate to selected page$")
public void navigate_back_and_forth_by_selecting_page_numbers_Should_navigate_to_selected_page() throws Throwable {
	  insurancecompany.ClickOnNext();
	    insurancecompany.ClickOnPrev();
	    insurancecompany.ClickOnAnySelectedNumber();
}

@When("^A text message “Showing x to y of z entries” should be displayed on the bottom left corner of the list$")
public void a_text_message_Showing_x_to_y_of_z_entries_should_be_displayed_on_the_bottom_left_corner_of_the_list() throws Throwable {
	insurancecompany.TextMessageOfPagesDisplayed();
}
}