package easytox.apptest.pages;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

















import com.sun.tools.javac.util.List;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import easytox.apptest.utils.WebConnector;

public class InsuranceCompanyPage extends AbstractPage {
	//WebDriver driver;
	
	public InsuranceCompanyPage(WebDriver driver) {
		super(driver);
	}
	
	public void ClickOnSettingsIcon()throws Throwable {
		Thread.sleep(2000);
		connector.getWebElement(driver, WebConnector.Identifier.xpath,
				connector.getstring(WebConnector.myUrl.URL_OR,"Settings_xpath")).click();
		}
	
	public void SelectInsuranceCompanyOption()throws Throwable {
		Thread.sleep(2000);
		connector.getWebElement(driver, WebConnector.Identifier.xpath,
				connector.getstring(WebConnector.myUrl.URL_OR,"InsuranceCompany_xpath")).click();
		}
	
	public void ClickOnPlusIcon()throws Throwable {
		Thread.sleep(2000);
		connector.getWebElement(driver, WebConnector.Identifier.xpath,
				connector.getstring(WebConnector.myUrl.URL_OR,"PlusIcon_xpath")).click();
		}
	
	public void ClickOnEditIcon()throws Throwable {
		Thread.sleep(2000);
		connector.getWebElement(driver, WebConnector.Identifier.xpath,
				connector.getstring(WebConnector.myUrl.URL_OR,"EditIcon_xpath")).click();
		}
	
	public void ClickOnDeleteButton()throws Throwable {
		Thread.sleep(2000);
		connector.getWebElement(driver, WebConnector.Identifier.xpath,
				connector.getstring(WebConnector.myUrl.URL_OR,"DeleteButton_xpath")).click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		String alertMessage=driver.switchTo().alert().getText();
		Assert.assertEquals("Are you sure?", alertMessage);
		}
	
	public void EnterSearchCriteria(String search)throws Throwable {
		Thread.sleep(2000);
		connector.getWebElement(driver, WebConnector.Identifier.xpath,
			     connector.getstring(WebConnector.myUrl.URL_OR,"SeacrhBox_xpath")).sendKeys(search);
	}
	
	public void ValidatingSearchCriteria(String search)throws Throwable {
		Thread.sleep(2000);
		boolean search_column = driver.findElement(By.xpath("//table[@id='example']//tr/td[contains(., "+search+")]")).isDisplayed();
		Assert.assertEquals(search_column,true);
	}
	
	public void DefaultNumberOfRecordsDisplayedOnPage()throws Throwable {
		Thread.sleep(1000);
		int default_value = Integer.parseInt(driver.findElement(By.xpath("//*[@id='example_length']/label/select/option[1]")).getText()); 
		int rowCount=driver.findElements(By.xpath("//*[@id='example']/tbody/tr")).size();
		//Assert.assertEquals(rowCount,default_value);
	}
	
	public void DefaultNumber10Displayed()throws Throwable {
		Select select = new Select (connector.getWebElement(driver, WebConnector.Identifier.xpath,
			     connector.getstring(WebConnector.myUrl.URL_OR,"DefaultNumberOfRecordsDisplayed_xpath")));
		 String option = select.getFirstSelectedOption().getText();
		 Assert.assertEquals("10", option);
	}
		
	public void ClickOnDisplayPageDropdown()throws Throwable {
		Thread.sleep(2000);
		connector.getWebElement(driver, WebConnector.Identifier.xpath,
			     connector.getstring(WebConnector.myUrl.URL_OR,"DefaultNumberOfRecordsDisplayed_xpath")).click();
		Thread.sleep(3000);
		}
	
	public void SelectOptionInDisplayDropdown(String option)throws Throwable {
		Select select = new Select (connector.getWebElement(driver, WebConnector.Identifier.xpath,
			     connector.getstring(WebConnector.myUrl.URL_OR,"DefaultNumberOfRecordsDisplayed_xpath")));
		Thread.sleep(3000);
		select.selectByVisibleText(option);
		 String selectedoption = select.getFirstSelectedOption().getText();
		 Assert.assertEquals(option, selectedoption);
			Thread.sleep(3000);
		}
	
	public void ClickOnNext() throws Throwable{
		WebElement next = connector.getWebElement(driver, WebConnector.Identifier.css,
			     connector.getstring(WebConnector.myUrl.URL_OR,"Next_css"));
			if(next.isEnabled() ) {
			    next.click();
			    Thread.sleep(2000);
			     String activePage = driver.findElement(By.cssSelector(".pagination li.active a")).getText();
			     Thread.sleep(2000);
			     System.out.println("Active Page is: " +activePage);
			   }
}
	
	public void ClickOnPrev() throws Throwable{
		WebElement prev = connector.getWebElement(driver, WebConnector.Identifier.xpath,
			     connector.getstring(WebConnector.myUrl.URL_OR,"Prev_xpath"));
		   if(prev.isEnabled()) {
			    prev.click();
			    Thread.sleep(2000);
			     String activePage = driver.findElement(By.cssSelector(".pagination li.active a")).getText();
			     Thread.sleep(2000);
			     System.out.println("Active Page is: " +activePage);
			   }
	}
	public void ClickOnAnySelectedNumber() throws Throwable{
		Thread.sleep(2000);
		connector.getWebElement(driver, WebConnector.Identifier.xpath,
			     connector.getstring(WebConnector.myUrl.URL_OR,"Page_xpath")).click();
		String activePage = driver.findElement(By.cssSelector(".pagination li.active a")).getText();
		Thread.sleep(2000);
		System.out.println("Active Page is: " +activePage);
	}
	
	public void TextMessageOfPagesDisplayed() throws Throwable{
		String PageNumberDisplayMeassage = connector.getWebElement(driver, WebConnector.Identifier.xpath,
			     connector.getstring(WebConnector.myUrl.URL_OR,"PageNumberDisplayMeassage_xpath")).getText();
		//Assert.assertTrue("Display Message",PageNumberDisplayMeassage.contains("Showing 21 to 30 of 32 entries"));
	}
	
}
