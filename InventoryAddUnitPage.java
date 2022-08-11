package com.uiFramework.KTCTC.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.uiFramework.KTCTC.helper.javaScript.JavaScriptHelper;
import com.uiFramework.KTCTC.helper.wait.WaitHelper;

public class InventoryAddUnitPage {
	WebDriver driver = null;  

	//locator of Add Unit in category Page
	By unitoptionfromInventory = By.xpath("//a[contains(.,'Add Unit')]");
	By newButtononCategoryUnitPage =By.xpath("//a[contains(.,'New')]");
	By searchTextBoxOnUnitCategorypage = By.xpath("//input[@type='search']");
	By editUnitOptionOnCategoryPage = By.xpath("//button[contains(text(),'Edit')]");
	By deletebuttononCategoryPage =By.xpath("//td//button[contains(text(),' Delete')]");

	//locator of Add Unit modal
	By nameTextBoxOnAddNewUnitModal =By.xpath("//div//input[@id='name']");
	By saveButtononAddnewUnitModal =By.xpath("//button[@name='add']");
	By closeButtonOnAddNewUnitModal = By.xpath("//*[@id='addnewunit']//div[3]/button[1]");
	By nameTextBoxOnEditUnitModal =By.xpath("//input[@id='edit_unit']");
	By updateButtonOnEditUnitModal =By.xpath("//div//button[@name='edit']");
	By closeButtononEditUnitModal =By.xpath("//*[@id='edit']//div[3]/button[1]");
	By deletebuttonOnDeleteunitModal = By.xpath("//button[@name='delete']");
	By closeButtonOnDelleteunitModal = By.xpath("//div[@id='deletes']//button[contains(text(),'Close')]");
	//locator of success message
	By unitAddedSuccessfullyMessage = By.xpath("//section/div[contains(.,'Unit added successfully')]");
	By unitCountMessageOnAddUnitCategory =By.xpath("//div[@id='example1_info']");
	By unitDeletedSuccessFullMessageOnUnitcategorypage= By.xpath("//section[contains(.,'Unit deleted successfully')]");
	By uniteditSuccessFullMessageOnUnitcategorypage= By.xpath("//section[contains(.,'success')]");

	public InventoryAddUnitPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void expandUnitOptionFrominventory()
	{
		driver.findElement(unitoptionfromInventory).click();
	}
	public void addunitOnCategoryPage(String addunit)
	{
		driver.findElement(newButtononCategoryUnitPage).click();
		driver.findElement(nameTextBoxOnAddNewUnitModal).sendKeys(addunit);
		driver.findElement(saveButtononAddnewUnitModal).click();

	}
	public boolean unitaddedSuccessfulMessage()
	{
		boolean flag = driver.findElement(unitAddedSuccessfullyMessage).isDisplayed();
		return flag;

	}

	public int getCountIncreased()
	{
		JavaScriptHelper js=new JavaScriptHelper(driver);
		js.scrollToElement(driver.findElement(unitCountMessageOnAddUnitCategory));
		String str = driver.findElement(unitCountMessageOnAddUnitCategory).getText();

		String[] index = str.split(" ");
		String ss = index[5];
		int a = Integer.parseInt(ss);
		js.scrollUpVertically();
		return a;
	}

	public void editUnitFromCategoryPage(String addunit , String newunit) 
	{
		driver.findElement(searchTextBoxOnUnitCategorypage).sendKeys(addunit);
		driver.findElement(editUnitOptionOnCategoryPage).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(nameTextBoxOnEditUnitModal).clear();
		driver.findElement(nameTextBoxOnEditUnitModal).sendKeys(newunit);
		driver.findElement(updateButtonOnEditUnitModal).click();
		
	}
	public boolean isUniteditedSuceessfullyMessageDisplay()
	{
		boolean flag = driver.findElement(uniteditSuccessFullMessageOnUnitcategorypage).isDisplayed();
		return flag;
	}
				
	public boolean deleteCategorySuccessfully(String newUnit)
	{
		driver.findElement(searchTextBoxOnUnitCategorypage).sendKeys(newUnit);
		driver.findElement(deletebuttononCategoryPage).click();
		driver.findElement(deletebuttonOnDeleteunitModal).click();
		boolean flag = driver.findElement(unitDeletedSuccessFullMessageOnUnitcategorypage).isDisplayed();
		return flag;

	}

	public void clearSearchBoxoncategorypage()
	{
		driver.findElement(searchTextBoxOnUnitCategorypage).clear();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(searchTextBoxOnUnitCategorypage).sendKeys(Keys.BACK_SPACE);
	}

	public void clearnameTextboxOnEditModal()
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(nameTextBoxOnEditUnitModal).sendKeys(Keys.BACK_SPACE);
	}


}
/*//locator
	By brandoptionfromInventory= By.xpath("//a[contains(.,'Brand')]");
	By newButtonOptiononBrandpage =By.xpath("//a[contains(.,'New')]");
	By nametextBoxOnAddNewBrandOnmodal= By.xpath("//input[@id='name']");
	By saveButtononAddNewBrandModal =By.xpath("//div//button[@name='add']");
	By searchTextboxOnBrandPage = By.xpath("//input[contains(@type,'search')]");
	By editOptionOnBrandPage = By.xpath("//button[contains(text(),'Edit')]");
	By nameTextBoxOneditBrandOnModal = By.xpath("//input[@id='edit_unit']");
	By updateButtonOnAddBrandModal =By.xpath("//button[@name='edit']");
	By deleteButtonOnBrandPage = By.xpath("//td//button[contains(text(),'Delete')]");
	By deleteButtonOnBrandEditModal = By.xpath("//button[@name='delete']");
	//success message 
	By brandAddedSuccessMessage = By.xpath("//section/div[contains(.,'Brand added successfully')]");
	By brandCountMessageOnPage =By.xpath("//div[@role='status']");
	By brandUpdatedSuccessMessage =By.xpath("//section[contains(.,'Brand updated successfully')]");
	By brandDeletedSuccessfullyMessage =By.xpath("//section[contains(.,'Brand deleted successfully')]");


	public InventoryAddUnitPage(WebDriver driver)
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
}*/










