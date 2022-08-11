package com.uiFramework.KTCTC.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.uiFramework.KTCTC.helper.select.DropDownHelper;

public class InventoryAddProductPageEcom {
	WebDriver driver=null;
	DropDownHelper sel;


	//Locator on product list page
	By productOptionFromInventory = By.xpath("//a[contains(text(),' Products')]");
	By newButtonOnProductListPage = By.xpath("//a[@id='addproduct']");
	By categoryDropDownOnProductListPage = By.xpath("//select[@id='select_category']");
	By searchTextBoxOnproductListPage = By.xpath("//input[@type='search']");
	By showEntriesDropDownOnproductListPage =By.xpath("//select[@name='example1_length']");
	By editButtonOnProductListPage = By.xpath("//button [contains(.,'Edit')]");
	By deleteButtonOnProductListPage =By.xpath("//td//button [contains(.,'Delete')]");


	//locator on add product model
	By nameTextBoxOnAddNewProductModal = By.xpath("//input[@id='name']");
	By brandDropDownOnAddProductonModal = By.xpath("//select[@id='brand']");
	By categoryDropDownAddProductModal = By.xpath("//select[@id='category']");
	By unitDropDownAddProductModal = By.xpath("//select[@id='unit']");
	By statusDropDownAddProductModal = By.xpath("//select[@name='status']");
	By stockTextBoxOnAddProductModal = By.xpath("//input[@name='stock']");
	By descriptionTextBoxonAddproductModal = By.xpath("//html[@dir='ltr']");
	By priceTextboxonAddProductmodal = By.id("price");
	By uploadphotoTextBoxonAddProductModal = By.id("photo");
	By saveButtonOnAddProductmodal =By.xpath("//button[@name='add']");
	By nameTextBoxOnEditProductModal = By.xpath("//input [@id='edit_name']");
	By catoegoryDropDownEditProductModel = By.xpath("//select[@id='edit_category']");
	By editPriceTextBoxOnEditProductPagemodal =By.xpath("//input[@id='edit_price']");
	By editUnitDropDownOnEditProductModal = By.xpath("//select[@id='edit_unit']");
	By availabledropDownonEditProductmodal = By.xpath("//select[@id='edit_avail']");
	By editBrandDropDownOnEditProductmodal = By.xpath("//select[@id='edit_brand']");
	By stockTextBoxOnEditproductModal =By.xpath("//input[contains(@class,'form-control stock')]");
	By updateButtonOnEditProductmodal = By.xpath("//button[@name='edit']");
	By deleteButtonOnDeleteModal =By.xpath("//button[@name='delete']");
	By fileUploadOptionOnAddNewProductModal = By.xpath("//div[@class='col-sm-5']/input[@name='photo'] ");

	//locator of success message
	By productAddedmessageOnpage = By.xpath("//div//div[contains(. ,'Product added successfully')]");
	By productEntriesDisplayessage = By.xpath("//div [@id='example1_info']");	
	By productDeletedSuccessfulMessageonpage =By.xpath("//section[contains(.,'Product deleted successfully')]");
	By productEditedSuccessfulMessageonpage =By.xpath("//section[contains(.,'Product updated successfully')]");

	public InventoryAddProductPageEcom(WebDriver driver)
	{
		this.driver=driver;
	}
	public void  expandProductFromInventory()
	{
		driver.findElement(productOptionFromInventory).click();
	}
	public void addNewProductInProductList(String product,String autocat,String price,String unitadd,String file,String status,String brand,String stockquantity )
	{
		sel =new DropDownHelper(driver);
		driver.findElement(newButtonOnProductListPage).click();
		driver.findElement(nameTextBoxOnAddNewProductModal).sendKeys(product); 
		sel.selectUsingVisibleText(driver.findElement(categoryDropDownAddProductModal), autocat);
		driver.findElement(priceTextboxonAddProductmodal).sendKeys(price);
		driver.findElement(fileUploadOptionOnAddNewProductModal).sendKeys(file);
		sel.selectUsingVisibleText(driver.findElement(statusDropDownAddProductModal), status);
		driver.findElement(brandDropDownOnAddProductonModal).sendKeys(brand);
		driver.findElement(stockTextBoxOnAddProductModal).sendKeys(stockquantity);
		driver.findElement(saveButtonOnAddProductmodal).click();

	}







}
