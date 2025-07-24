package testCases;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AmazonMainPage;
import pageObjects.CartPage;
import pageObjects.SearchResultsPage;
import testBase.BaseClass;
import utilities.DataProviders;
import utilities.ExcelOutput;

public class WashingMachineSearch extends BaseClass{
	@Test(priority = 0,dataProvider = "searchData",dataProviderClass = DataProviders.class)
	public void searchWashingMachine(String search){
		try {
			AmazonMainPage amp = new AmazonMainPage(driver);
			amp.setSearchInput(search);
			amp.clickSearchButton();
			SearchResultsPage srp = new SearchResultsPage(driver);
			Thread.sleep(500);
			Assert.assertTrue(srp.getConfirmationSearchResultPage());
		} catch (Exception e) {
			Assert.fail();
		}
		
	}
	@Test(priority = 1,dependsOnMethods = {"searchWashingMachine"})
	public void sortPriceLowToHigh() {
		try {
			SearchResultsPage srp = new SearchResultsPage(driver);
			srp.setResultDisplayFilter();
			Thread.sleep(1000);
			Assert.assertTrue(srp.getConfirmResultsDisplayed());
		} catch (InterruptedException e) {
			Assert.fail();
		}
	}
	@Test(priority = 2,dependsOnMethods = {"searchWashingMachine","sortPriceLowToHigh"})
	public void applyFilters() {
		try {
			SearchResultsPage srp = new SearchResultsPage(driver);
			srp.setCapacityFilter();
			srp.setLoadFilter();
			srp.setBrandFilter();
			Assert.assertTrue(srp.getConfirmResultsDisplayed());
		} catch (Exception e) {
			Assert.fail();
		}
	}
	@Test(priority = 3,dependsOnMethods = "applyFilters")
	public void addFirstItemToCart() {
		try {
			SearchResultsPage srp = new SearchResultsPage(driver);
			srp.clickAddElementToCart();
			Thread.sleep(500);
		} catch (Exception e) {
			Assert.fail();
		}
	}
	@Test(priority = 4,dependsOnMethods = {"addFirstItemToCart"})
	public void goToCart() {
		try {
			SearchResultsPage srp = new SearchResultsPage(driver);
			srp.clickGoToCart();
			CartPage cp = new CartPage(driver);
			Assert.assertTrue(cp.getConfirmationCartPage());
			Thread.sleep(500);
		} catch (InterruptedException e) {
			Assert.fail();
		}
	}
	@Test(priority = 5,dependsOnMethods = {"goToCart"})
	public void increaseQuantity() {
		try {
			CartPage cp = new CartPage(driver);
			cp.setIncreaseElementQuantity();
			Thread.sleep(1000);
			Assert.assertTrue(cp.getQuantityIncreaseConfirmation());
//			Thread.sleep(500);
		} catch (InterruptedException e) {
			Assert.fail();
		}
	}
	@Test(priority = 6)
	public void goBack() throws IOException{
		try {
			CartPage cp = new CartPage(driver);
			String productName = cp.getProductName();
			String productPrice = cp.getProductPrice();
			String productQuantity = cp.getProductQuantity();
			String totalAmount = cp.getTotalAmount();
			ExcelOutput exl = new ExcelOutput(productName, productPrice, productQuantity, totalAmount, browserUsed);
			exl.setData();
			cp.returnToPreviousPage();
			SearchResultsPage srp = new SearchResultsPage(driver);
			Assert.assertTrue(srp.getConfirmationSearchResultPage());
			Thread.sleep(500);
		} catch (InterruptedException e) {
			Assert.fail();
		}
	}
}
