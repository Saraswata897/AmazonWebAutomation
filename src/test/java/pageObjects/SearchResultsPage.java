package pageObjects;

//import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchResultsPage extends BasePage{

	public SearchResultsPage(WebDriver driver) {
		super(driver);
	}

@FindBy(xpath = "//span[text()='Sort by:']")
WebElement btnSortByFilterElement;
@FindBy(xpath = "//a[text()='Price: Low to High']")
WebElement optPriceLowToHighElement;
@FindBy(xpath = "//span[normalize-space()='Capacity']")
WebElement sectionCapacity;
@FindBy(xpath = "//div[@id='p_n_feature_thirteen_browse-bin/52295472031']//span[text()='Access Location']")
WebElement sectionLoadType;
@FindBy(xpath = "//span[normalize-space()='Brands']")
WebElement sectionBrand;
//@FindBy(xpath = "//span[contains(@class,'a-size-base') and contains(text(),'8 kg')]")
//List<WebElement> chkLoad8KgElementList;
//@FindBy(xpath = "//div[@id='brandsRefinements']//span[@class='a-size-base a-color-base'][normalize-space()='Samsung']")
//List<WebElement> chkSamsungElementList;
//@FindBy(xpath = "//span[@class='a-size-base a-color-base'][text()='Top Load']")
//List<WebElement> chkTopLoadElementList;
@FindBy(xpath = "//span[contains(text(),'results for')]")
WebElement resultsDisplayedTextElement;
@FindBy(xpath = "(//div[@role='listitem']//button)[1]")
WebElement btnAddFirstElement;
@FindBy(xpath = "//div[@id='nav-cart-text-container']/span[2]")
WebElement btnCartElement;
@FindBy(xpath = "//span[contains(@class,'a-size-base') and contains(text(),'8 kg')]")
WebElement chkLoad8KgElement;
@FindBy(xpath = "//div[@id='brandsRefinements']//span[@class='a-size-base a-color-base'][normalize-space()='Samsung']")
WebElement chkSamsungElement;
@FindBy(xpath = "//span[@class='a-size-base a-color-base'][text()='Top Load']")
WebElement chkTopLoadElement;

//public void setResultDisplayFilter() {
//	wait.until(ExpectedConditions.elementToBeClickable(btnSortByFilterElement)).click();
//	wait.until(ExpectedConditions.elementToBeClickable(optPriceLowToHighElement)).click();	
//}
//public void setCapacityFilter() {
//	try {
//		Thread.sleep(500);
//		js.executeScript("arguments[0].scrollIntoView(true)", sectionCapacity);
//		wait.until(ExpectedConditions.visibilityOf(sectionCapacity));
//		wait.until(ExpectedConditions.elementToBeClickable(chkLoad8KgElement)).click();
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
//	if (chkLoad8KgElementList.size()>0) {
//		chkLoad8KgElementList.get(0).click();
//	}
//}
//public void setBrandFilter() {
//	try {
//		Thread.sleep(500);
//		js.executeScript("arguments[0].scrollIntoView(true)", sectionBrand);
//		wait.until(ExpectedConditions.visibilityOf(sectionBrand));
//		wait.until(ExpectedConditions.elementToBeClickable(chkSamsungElement)).click();
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
//	if (chkSamsungElementList.size()>0) {
//		chkSamsungElementList.get(0).click();
//	}
//}
//public void setLoadFilter() {
//	try {
//		Thread.sleep(500);
//		js.executeScript("arguments[0].scrollIntoView(true)", sectionLoadType);
//		wait.until(ExpectedConditions.visibilityOf(sectionLoadType));
//		wait.until(ExpectedConditions.elementToBeClickable(chkTopLoadElement)).click();
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
//	if (chkTopLoadElementList.size()>0) {
//		chkTopLoadElementList.get(0).click();
//	}
//}
public void clickAddElementToCart() {
	js.executeScript("arguments[0].scrollIntoView(true)", btnAddFirstElement);
	btnAddFirstElement.click();
}
public void clickGoToCart() {
	js.executeScript("arguments[0].scrollIntoView(true)", btnCartElement);
	btnCartElement.click();
}
public boolean getConfirmationSearchResultPage() {
	try {
		String tempString = "Washing Machine";
		return getTitleOfPage().contains(tempString);
	} catch (Exception e) {
		return false;
	}
}
public boolean getConfirmResultsDisplayed() {
	try {
		return resultsDisplayedTextElement.isDisplayed();
	} catch (Exception e) {
		return false;
	}
}
public void setResultDisplayFilter() {
    btnSortByFilterElement.click();
    optPriceLowToHighElement.click();
}

public void setCapacityFilter() {
    try {
        js.executeScript("arguments[0].scrollIntoView(true)", sectionCapacity);
        chkLoad8KgElement.click();
    } catch (Exception e) {
    	System.out.println(e.getMessage());
    }
}

public void setBrandFilter() {
    try {
        js.executeScript("arguments[0].scrollIntoView(true)", sectionBrand);
        chkSamsungElement.click();
    } catch (Exception e) {
    	System.out.println(e.getMessage());
    }
}

public void setLoadFilter() {
    try {
        js.executeScript("arguments[0].scrollIntoView(true)", sectionLoadType);
        chkTopLoadElement.click();
    } catch (Exception e) {
    	System.out.println(e.getMessage());
    }
}
}
