package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class AmazonMainPage extends BasePage{
	
	public AmazonMainPage(WebDriver driver) {
		super(driver);
		
	}
@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
WebElement txtSearchBoxElement;
@FindBy(xpath = "//input[@id='nav-search-submit-button']")
WebElement btnSearchButtonElement;

//public void setSearchInput(String searchTerm) {
//	wait.until(ExpectedConditions.visibilityOf(txtSearchBoxElement)).sendKeys(searchTerm);;
//}
//public void clickSearchButton() {
//	wait.until(ExpectedConditions.elementToBeClickable(btnSearchButtonElement)).click();
//}
public void setSearchInput(String searchTerm) {
    txtSearchBoxElement.sendKeys(searchTerm);
}

public void clickSearchButton() {
    btnSearchButtonElement.click();
}
	
}
