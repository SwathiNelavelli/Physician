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



public class LabPhysicianPage extends AbstractPage {

	public LabPhysicianPage(WebDriver driver) {
		super(driver);
	}
	
	public void SelectPhysicianOption()throws Throwable {
		Thread.sleep(2000);
		connector.getWebElement(driver, WebConnector.Identifier.linktext,
				connector.getstring(WebConnector.myUrl.URL_OR,"Physician_link")).click();
		}
	
}