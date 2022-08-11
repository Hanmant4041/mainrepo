package com.uiFramework.KTCTC.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.uiFramework.KTCTC.helper.javaScript.JavaScriptHelper;
import com.uiFramework.KTCTC.helper.wait.WaitHelper;

public class InventoryAddBrandPage {

	WebDriver driver = null;  
	//locator on Brand Page
	By brandoptionfromInventory= By.xpath("//a[contains(.,'Brand')]");
	By newButtonOptiononBrandpage =By.xpath("//a[contains(.,'New')]");
	By searchTextboxOnBrandPage = By.xpath("//input[contains(@type,'search')]");
	By editOptionOnBrandPage = By.xpath("//button[contains(text(),'Edit')]");
	By deleteButtonOnBrandPage = By.xpath("//td//button[contains(text(),'Delete')]");
	//locator on add new brand modal
	By nametextBoxOnAddNewBrandOnmodal= By.xpath("//input[@id='name']");
	By saveButtononAddNewBrandModal =By.xpath("//div//button[@name='add']");
	By nameTextBoxOneditBrandOnModal = By.xpath("//input[@id='edit_unit']");
	By updateButtonOnAddBrandModal =By.xpath("//button[@name='edit']");
	By deleteButtonOnBrandEditModal = By.xpath("//button[@name='delete']");
	//success message 
	By brandAddedSuccessMessage = By.xpath("//section/div[contains(.,'Brand added successfully')]");
	By brandCountMessageOnPage =By.xpath("//div[@role='status']");
	By brandUpdatedSuccessMessage =By.xpath("//section[contains(.,'Brand updated successfully')]");
	By brandDeletedSuccessfullyMessage =By.xpath("//section[contains(.,'Brand deleted successfully')]");


	public InventoryAddBrandPage(WebDriver driver)
	{
		this.driver=driver;
	}

	public void expandBrandoption()
	{

		driver.findElement(brandoptionfromInventory).click();

	}


	public void addNewBrandInventory(String brandname)
	{
		driver.findElement(newButtonOptiononBrandpage).click();	
		driver.findElement(nametextBoxOnAddNewBrandOnmodal).sendKeys(brandname);
		driver.findElement(saveButtononAddNewBrandModal).click();
	}

	public boolean brandAddedSucessfullyMessagisDisplay()
	{
		boolean flag=false;
		try {
			flag = driver.findElement(brandAddedSuccessMessage).isDisplayed();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			flag=false;
		}
		return flag;
	}
	public void clearSearchBoxOnBrandPage()
	{
		WebElement Searc = driver.findElement(searchTextboxOnBrandPage);
		Searc.clear();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Searc.sendKeys(Keys.BACK_SPACE);

	}

	public int getCountofRecordOnbrandPage()
	{
		JavaScriptHelper js = new JavaScriptHelper(driver);
		js.scrollToElement(driver.findElement(brandCountMessageOnPage));

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String str = driver.findElement(brandCountMessageOnPage).getText();
		String[] arr = str.split(" ");

		String value = arr[5];
		int a = Integer.parseInt(value);
		js.scrollUpVertically();

		return a;
	}
	public void editBrandfromBrandPage(String brandname,String newbrand) throws InterruptedException
	{
		clearSearchBoxOnBrandPage();
		driver.findElement(searchTextboxOnBrandPage).sendKeys(brandname);
		driver.findElement(editOptionOnBrandPage).click();
		Thread.sleep(5000);
		driver.findElement(nameTextBoxOneditBrandOnModal).clear();
		driver.findElement(nameTextBoxOneditBrandOnModal).sendKeys(newbrand);
		driver.findElement(updateButtonOnAddBrandModal).click();
		
	}
	
	public boolean isEditMessageDisplayedOnEditbrandpage() {
		boolean flag = driver.findElement(brandUpdatedSuccessMessage).isDisplayed();

		return flag;
	}
	public void brandDeletedSuccessfully(String newbrand)
	{
		driver.findElement(deleteButtonOnBrandPage).sendKeys(newbrand);
		driver.findElement(deleteButtonOnBrandPage).click();
		driver.findElement(deleteButtonOnBrandEditModal).click();
		
	}
	public boolean brandDeletedSuccefulMessage() 
	{
		
		boolean flag=false;
		try {
			flag = driver.findElement(brandDeletedSuccessfullyMessage).isDisplayed();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
}








/*
	// Locators on category Page
	By newButtonOnProductListPage = By.xpath("//a[@id='addproduct']");
	By categoryDropDownOnProductListPage = By.xpath("//select[@id='select_category']");
	By searchTextBoxOnproductListPage = By.xpath("//input[@type='search']");
	By showEntriesDropDownOnproductListPage =By.xpath("//select[@name='example1_length']");
	By nameTextBoxOnAddNewProductModal = By.xpath("//input[@id='name']");
	By priceTextboxonAddProductmodal = By.id("price");
	By uploadphotoTextBoxonAddProductModal = By.id("photo");
	By brandDropDownOnAddProductonModal = By.xpath("//select[@id='brand']");
	By categoryDropDownAddProductModal = By.xpath("//select[@id='category']");
	By unitDropDownAddProductModal = By.xpath("//select[@id='unit']");
	By statusDropDownAddProductModal = By.xpath("//select[@name='status']");
	By stockTextBoxOnAddProductModal = By.xpath("//input[@name='stock']");
	By descriptionTextBoxonAddproductModal = By.xpath("//html[@dir='ltr']");
	By productOptionFromInventory = By.xpath("//a[contains(text(),' Products')]");
	By inventoryOption = By.xpath("//a[contains(.,'Inventory')]");
	By saveButtonOnAddProductmodal =By.xpath("//button[@name='add']");
	//message
	By productAddedmessageOnpage = By.xpath("//div//div[contains(. ,'Product added successfully')]");

	By categoryCountMessageOnCategoryPage = By.id("example1_info");
	By editButtonOnCategoryPage = By.xpath("//button[contains(text(),' Edit')]");
	By deleteButtonOnCategoryPage = By.xpath("//td//button[contains(text(),' Delete')]");
	// Locators of add new category modals
	By nameTextBoxOnAddNewCategoryModal = By.id("name");
	By saveButtonOnAddNewCategoryModal = By.name("add");

	By nameTextBoxOnEditCategoryModal = By.id("edit_name");
	By updateButtonOnEditCategoryModal = By.name("edit");

	By deleteButtonOnDelteModal = By.name("delete");
	By categoryOptionFromInventory = By.xpath("//*[starts-with(@href,'category')]");
	// success messages
	By categoryAddedSuccessfullyMessage = By.xpath("//section//*[contains(.,'Category added successfully')]");
	By categoryupdatedSuccessfullyMessage = By.xpath("//section//*[contains(.,'Category updated successfully')]");
	By categorydeletedSuccessfullyMessage = By.xpath("//section//*[contains(.,'Category deleted successfully')]");
	public InventoryAddBrandPage (WebDriver driver) {
		this.driver = driver;
	}
	public void expandProductOption(WebDriver driver)
	{

		driver.findElement(productOptionFromInventory).click();
	}

	public void addNewproduct(WebDriver driver,String categoryname,String productname,
			String Productunit,String img,String status,String brandname,String stockquantity,String discription,String priceofproduct)
	{

		driver.findElement(newButtonOnProductListPage).click();
		driver.findElement(nameTextBoxOnAddNewProductModal).sendKeys(productname);
		WebElement ak =driver.findElement(categoryDropDownAddProductModal);
		Select sel = new Select(ak);
		sel.selectByVisibleText(categoryname);
		driver.findElement(priceTextboxonAddProductmodal).sendKeys(priceofproduct);
		sel = new Select(driver.findElement(unitDropDownAddProductModal));
		sel.selectByVisibleText(Productunit);
		driver.findElement(uploadphotoTextBoxonAddProductModal).sendKeys(img);
		sel = new Select(driver.findElement(statusDropDownAddProductModal));
		sel.selectByVisibleText(status);
		sel = new Select(driver.findElement(brandDropDownOnAddProductonModal));
		sel.selectByVisibleText(brandname);
		driver.findElement(stockTextBoxOnAddProductModal).sendKeys(stockquantity);
		//WebElement dis = driver.findElement(descriptionTextBoxonAddproductModal);
		//driver.switchTo().frame(dis);
		//dis.sendKeys(discription);
		driver.findElement(saveButtonOnAddProductmodal).click();
		boolean flag = driver.findElement(productAddedmessageOnpage).isDisplayed();

	}




	public void expandCategoruOption(WebDriver driver)
	{
		//WaitHelper wt = new WaitHelper(driver);
		//	wt.WaitForElementClickable(driver.findElement(categoryOptionFromInventory), 4);
		driver.findElement(categoryOptionFromInventory).click();
	}

	public boolean isCategoryAddedSuccessMessageDisplayed(WebDriver driver)
	{
		boolean flag = false;

		try {
			flag = driver.findElement(categoryAddedSuccessfullyMessage).isDisplayed();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			flag = false;
		}
		return flag;

	}
	public boolean isCategoryUpdatedSuccessMessageDisplayed(WebDriver driver)
	{
		boolean flag = false;

		try {
			flag = driver.findElement(categoryupdatedSuccessfullyMessage).isDisplayed();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			flag = false;
		}
		return flag;

	}
	public boolean isCategoryDeletedSuccessMessageDisplayed(WebDriver driver)
	{
		boolean flag = false;

		try {
			flag = driver.findElement(categorydeletedSuccessfullyMessage).isDisplayed();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			flag = false;
		}
		return flag;

	}
	public void addNewCategory(WebDriver driver, String name)
	{
		driver.findElement(newButtonOnCategoryPage).click();
		driver.findElement(nameTextBoxOnAddNewCategoryModal).sendKeys(name);
		driver.findElement(saveButtonOnAddNewCategoryModal).click();

	}

	public void searchStringInSearchBox(WebDriver driver, String str)
	{
		clearSearchBox(driver);
		driver.findElement(searchBoxOnCategoryPage).sendKeys(str);
	}
	public void clearSearchBox(WebDriver driver)
	{
		driver.findElement(searchBoxOnCategoryPage).clear();
		driver.findElement(searchBoxOnCategoryPage).sendKeys(Keys.BACK_SPACE);
	}

	public void editExistingCategory(WebDriver driver, String oldCategory, String newCatString)
	{
		searchStringInSearchBox(driver, oldCategory);
		driver.findElement(editButtonOnCategoryPage).click();
		driver.findElement(nameTextBoxOnEditCategoryModal).clear();
		driver.findElement(nameTextBoxOnEditCategoryModal).sendKeys(newCatString);
		driver.findElement(updateButtonOnEditCategoryModal).click();

	}

	public void deleteExistingCategory(WebDriver driver, String category)
	{
		searchStringInSearchBox(driver, category);
		driver.findElement(deleteButtonOnCategoryPage).click();

		driver.findElement(deleteButtonOnDelteModal).click();


	}

	public boolean isCategoryDIsplayedOnCategoryPage(WebDriver driver, String category)
	{
		searchStringInSearchBox(driver, category);
		boolean flag = false;

		try {
			flag = driver.findElement(By.xpath("//td[contains(text(),'"+category+"')]")).isDisplayed();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			flag = false;
		}
		return flag;
	}

	public int getCountOfRecordsOnCategoryPage(WebDriver driver)
	{
		JavaScriptHelper js = new JavaScriptHelper(driver);
		js.scrollToElement(driver.findElement(categoryCountMessageOnCategoryPage));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String str = driver.findElement(categoryCountMessageOnCategoryPage).getText();
		String[] ar = str.split(" ");
		String str1 = ar[5];
		int a = Integer.parseInt(str1);
		js.scrollUpVertically();

		return a;

	}*/


