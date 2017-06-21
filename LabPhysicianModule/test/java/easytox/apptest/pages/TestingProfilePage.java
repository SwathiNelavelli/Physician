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



public class TestingProfilePage extends AbstractPage {

	public TestingProfilePage(WebDriver driver) {
		super(driver);
	}
	
	public void ClickOnLibraryIcon()throws Throwable {
		Thread.sleep(2000);
		connector.getWebElement(driver, WebConnector.Identifier.xpath,
				connector.getstring(WebConnector.myUrl.URL_OR,"Library_xpath")).click();
		}
	
	public void SelectTestingProfileOption()throws Throwable {
		Thread.sleep(2000);
		connector.getWebElement(driver, WebConnector.Identifier.linktext,
				connector.getstring(WebConnector.myUrl.URL_OR,"TestingProfile_link")).click();
		}
}
