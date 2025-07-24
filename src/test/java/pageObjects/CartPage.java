package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage{

	public CartPage(WebDriver driver) {
		super(driver);
	}
@FindBy(xpath = "//h2[contains(text(),'Shopping Cart')]")
WebElement shoppingCartHeadingElement;
@FindBy(xpath = "//fieldset[@name='sc-quantity']/button[2]")
WebElement btnQuantityIncreaseElement;
@FindBy(xpath = "//fieldset[@name='sc-quantity']/div[2]/span[2]")
WebElement quantityElement;
@FindBy(xpath = "//span[@class='a-truncate sc-grid-item-product-title a-size-base-plus']//span[1]")
WebElement otpNameElement;
@FindBy(xpath = "//div[@class='sc-item-price-block']//span/span/span[2]")
WebElement otpPriceElement;
@FindBy(xpath = "//span[@id='sc-subtotal-amount-activecart']/span")
WebElement otpTotalAmountElement;

public void setIncreaseElementQuantity() {
	btnQuantityIncreaseElement.click();
}
//public boolean getQuantityIncreaseConfirmation() {
//	try {
//		wait.until(ExpectedConditions.visibilityOf(quantityElement));
//		int actQuantity=Integer.parseInt(quantityElement.getText());
//		return actQuantity==2;
//	} catch (Exception e) {
//		return false;
//	}
//}
public boolean getQuantityIncreaseConfirmation() {
    try {
        int actQuantity = Integer.parseInt(quantityElement.getText());
        return actQuantity == 2;
    } catch (Exception e) {
        return false;
    }
}
public boolean getConfirmationCartPage() {
	try {
		return shoppingCartHeadingElement.isDisplayed();
	} catch (Exception e) {
		return false;
	}
}

//public String getProductName() {
//	String name = wait.until(ExpectedConditions.visibilityOf(otpNameElement)).getText();
//	return name;
//}
//public String getProductPrice() {
//	String price = wait.until(ExpectedConditions.visibilityOf(otpPriceElement)).getText();
//	return price;
//}
//public String getProductQuantity() {
//	String quantity = wait.until(ExpectedConditions.visibilityOf(quantityElement)).getText();
//	return quantity;
//}
//public String getTotalAmount() {
//	String total = wait.until(ExpectedConditions.visibilityOf(otpTotalAmountElement)).getText();
//	return total;
//}
public String getProductName() {
    String name = otpNameElement.getText(); // Used original name 'otpNameElement'
    return name;
}

public String getProductPrice() {
    String price = otpPriceElement.getText(); // Used original name 'otpPriceElement'
    return price;
}

public String getProductQuantity() {
    String quantity = quantityElement.getText();
    return quantity;
}

public String getTotalAmount() {
    String total = otpTotalAmountElement.getText(); // Used original name 'otpTotalAmountElement'
    return total;
}
}
