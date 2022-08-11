package regression;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.uiFramework.KTCTC.Pages.InventoryAddBrandPage;
import com.uiFramework.KTCTC.Pages.InventoryAddUnitPage;
import com.uiFramework.KTCTC.Pages.InventoryCategoryPage;
import com.uiFramework.KTCTC.common.CommonMethods;
import com.uiFramework.KTCTC.testbase.TestBase;

public class InventoryUnitTest extends TestBase{

	InventoryAddUnitPage inventoryAddUnitPage = new InventoryAddUnitPage(driver);
	CommonMethods cmobj;
	String unit="";
	String  newUnit="";
	int initialcount=0;
	int newCount=0;
	int editedCount=0;


	@Test (priority=1)
	public void userCanAddUnit()
	{
	 inventoryAddUnitPage = new InventoryAddUnitPage(driver);
		SoftAssert sa = new SoftAssert();
		cmobj = new CommonMethods ();
		cmobj.expandInventoryOption(driver);
		inventoryAddUnitPage.expandUnitOptionFrominventory();
		initialcount = inventoryAddUnitPage.getCountIncreased();
		unit =cmobj.getcharacterString(4);
		inventoryAddUnitPage.addunitOnCategoryPage(unit);
		newCount = inventoryAddUnitPage.getCountIncreased();
		sa.assertAll();
	}
	@Test (priority=2)
	public void isCategoryAddeduccessfullyMsgisDisplayed()
	{
		SoftAssert sa = new SoftAssert();
		boolean flag = inventoryAddUnitPage.unitaddedSuccessfulMessage();
		sa.assertTrue(flag,"unit cannot add");
				
	}
	@Test (priority=3)
	public void isCountIncreasedAfterAddUnitincategoryPage()
	{
		SoftAssert sa = new SoftAssert();
		inventoryAddUnitPage.clearSearchBoxoncategorypage();
		newCount = inventoryAddUnitPage.getCountIncreased();
		sa.assertEquals(newCount, (initialcount+1));
		sa.assertAll();
	}
	@Test (priority=4)
	public void userCanEditunitfromCategoryUnit()
	{
		SoftAssert sa = new SoftAssert();
		inventoryAddUnitPage.clearSearchBoxoncategorypage();
		newUnit=cmobj.getcharacterString(3);
		inventoryAddUnitPage.editUnitFromCategoryPage(unit, newUnit);
		
		sa.assertAll();
	}
	
	@Test (priority=5)
	public void isunitEditedSuccefulmsgIsdisplayed()
	{
		SoftAssert sa = new SoftAssert();		
		boolean flag = inventoryAddUnitPage.isUniteditedSuceessfullyMessageDisplay();
		sa.assertTrue(flag,"unit not updated sucessfully");
		sa.assertAll();
	}
	@Test (priority=6)
	public void isCountIncreasedAfterEditUnitincategoryPage()
	{
		SoftAssert sa = new SoftAssert();
		inventoryAddUnitPage.clearSearchBoxoncategorypage();
		editedCount = inventoryAddUnitPage.getCountIncreased();
		sa.assertEquals(newCount, editedCount);
		sa.assertAll();
	}

	@Test (priority=7)
	public void userCanDeleteunitFromCategoryofUnit()
	{
		SoftAssert sa = new SoftAssert();
		inventoryAddUnitPage.clearSearchBoxoncategorypage();
		boolean flag = inventoryAddUnitPage.deleteCategorySuccessfully(newUnit);
		sa.assertTrue(flag,"user not able to delete unit ");
		sa.assertAll();
	}
	@Test (priority=8)
	public void isCountDecreasedFromCategory()
	{
		SoftAssert sa = new SoftAssert();
		int deleteCount = inventoryAddUnitPage.getCountIncreased();

		sa.assertEquals((deleteCount+1), editedCount);
		sa.assertAll();

	}
}





















/*
	String brandname = "";
	String newbrandName ="";
	int initialCount=0;
	int finalCount=0;
	int editCount=0;
	CommonMethods cmobj;
	@Test(priority=1)
	public void verifyUserCanAddNewBrand()
	{

		SoftAssert sas = new SoftAssert();
		inventoryAddBrandPage = new InventoryAddBrandPage(driver);
		cmobj1 =new CommonMethods();
		cmobj1.expandInventoryOption(driver);
		inventoryAddBrandPage.expandBrandoption();
		initialCount= inventoryAddBrandPage.getCountofRecordOnbrandPage();
		brandname = cmobj1.getAlphaNumericString(5);
		inventoryAddBrandPage.addNewBrandInventory(brandname);
		sas.assertAll();
	}

	@Test (priority=2)
	public void VerifyisBrandaddedMessageDisplayOnBrandPage()
	{
		SoftAssert sas = new SoftAssert();
		boolean flag = inventoryAddBrandPage.brandAddedSucessfullyMessagisDisplay();
		sas.assertTrue(flag,"brand is not addes successfully");
		sas.assertAll();

	}
	@Test (priority=3)
	public void verifyIsIncreasedCountOfBrandAdded()
	{
		SoftAssert sas = new SoftAssert();
		inventoryAddBrandPage.clearSearchBoxOnBrandPage();
		finalCount = inventoryAddBrandPage.getCountofRecordOnbrandPage();
		sas.assertEquals((initialCount+1), finalCount);
		sas.assertAll();
	}

	@Test (priority=4)
	public void verifyUserCanEditBrand() throws InterruptedException

	{

		SoftAssert sas = new SoftAssert();
		cmobj1.getAlphaNumericString(9);
		inventoryAddBrandPage.editBrandfromBrandPage(brandname, newbrandName);
		cmobj1.getAlphaNumericString(9);
		sas.assertNotEquals(brandname,newbrandName);

		sas.assertAll();
	}
	@Test (priority=5)
	public void isBrandudatedMessagedisplayedOnbrandPage()
	{
		SoftAssert sas = new SoftAssert();
		boolean flag=inventoryAddBrandPage.isEditMessageDisplayedOnEditbrandpage();
		sas.assertTrue(flag);
		sas.assertAll();
	}
	@Test (priority=6)
	public void verifyiscountDoesNotChangeAfterEditTheBrand()
	{
		SoftAssert sas = new SoftAssert();
		inventoryAddBrandPage.clearSearchBoxOnBrandPage();
		editCount = inventoryAddBrandPage.getCountofRecordOnbrandPage();
		sas.assertEquals(finalCount,editCount);
		sas.assertAll();
	}
	@Test (priority=7)
	public void verifyUsercanDeleteTheBrandFromBrandPage() 
	{
		SoftAssert sas = new SoftAssert();
		inventoryAddBrandPage.clearSearchBoxOnBrandPage(); 
		inventoryAddBrandPage.brandDeletedSuccessfully(newbrandName);
		boolean flag = inventoryAddBrandPage.brandDeletedSuccefulMessage();
		sas.assertTrue(flag);
		sas.assertAll();
	}
	@Test (priority=8)
	public void verifyisCountDecreasedAfterDeleteTheBrandFromBrandPage()
	{
		SoftAssert sas = new SoftAssert();
		inventoryAddBrandPage.clearSearchBoxOnBrandPage();

		int afterDeleteCount = inventoryAddBrandPage.getCountofRecordOnbrandPage();
		sas.assertEquals((editCount-1), afterDeleteCount);
	}
}



 */






/*




	InventoryCategoryPage inventoryCategoryPage = new InventoryCategoryPage();
	String categoryName = "";
	String newCategoryName = "";
	int initialCount = 0;
	int afterAddCount = 0;
	@Test (priority = 1)
	public void verifyUserCanAddNewCategory()
	{
		SoftAssert sAssert = new SoftAssert();
		cmObj.expandInventoryOption(driver);	    
		inventoryCategoryPage.expandCategoruOption(driver);
		initialCount = inventoryCategoryPage.getCountOfRecordsOnCategoryPage(driver);
		 categoryName = cmObj.getcharacterString(6);
		inventoryCategoryPage.addNewCategory(driver, categoryName);
		boolean flag = inventoryCategoryPage.isCategoryDIsplayedOnCategoryPage(driver, categoryName);
		sAssert.assertTrue(flag, "Newly Added category is not displayed on UI");
		sAssert.assertAll();
	}
	@Test (priority = 2)
	public void verifyCategoryAddedSuccessMessageIsDisplayed()
	{
		SoftAssert sAssert = new SoftAssert();
		boolean flag = inventoryCategoryPage.isCategoryAddedSuccessMessageDisplayed(driver);
		sAssert.assertTrue(flag, "Category added message is not displayed");
		sAssert.assertAll();
	}
	@Test (priority = 3)
	public void verifyCategoryPageCountGetsIncreasedOnAddingNewCategory()
	{
		SoftAssert sAssert = new SoftAssert();
		inventoryCategoryPage.clearSearchBox(driver);
		 afterAddCount = inventoryCategoryPage.getCountOfRecordsOnCategoryPage(driver);
		sAssert.assertEquals((initialCount+1), afterAddCount);

		sAssert.assertAll();
	}
	@Test (priority = 4)
	public void verifyUserCanEditExistingCategory()
	{
		SoftAssert sAssert = new SoftAssert();
		newCategoryName = cmObj.getcharacterString(6);
		inventoryCategoryPage.editExistingCategory(driver, categoryName, newCategoryName);
		boolean flag = inventoryCategoryPage.isCategoryDIsplayedOnCategoryPage(driver, newCategoryName);
		sAssert.assertTrue(flag, "Edited category is not displayed on UI");
		boolean flag1 = inventoryCategoryPage.isCategoryDIsplayedOnCategoryPage(driver, categoryName);
		sAssert.assertFalse(flag1, "Old category is still displayed on UI");
		sAssert.assertAll();

	}
	@Test (priority = 5)
	public void verifyCategoryUpdatedSuccessMessageIsDisplayed()
	{
		SoftAssert sAssert = new SoftAssert();
		boolean flag = inventoryCategoryPage.isCategoryUpdatedSuccessMessageDisplayed(driver);
		sAssert.assertTrue(flag, "Category updated message is not displayed");
		sAssert.assertAll();
	}
	@Test (priority = 6)
	public void verifyCategoryPageCountWillBeSameAfterEdit()
	{
		SoftAssert sAssert = new SoftAssert();
		inventoryCategoryPage.clearSearchBox(driver);
		 int afterEdit = inventoryCategoryPage.getCountOfRecordsOnCategoryPage(driver);
		sAssert.assertEquals(afterEdit, afterAddCount);
		sAssert.assertAll();
	}

	@Test (priority = 7)
	public void verifyUserCanDeleteExistingCategory()
	{
		SoftAssert sAssert = new SoftAssert();
		inventoryCategoryPage.deleteExistingCategory(driver, newCategoryName);
		boolean flag1 = inventoryCategoryPage.isCategoryDIsplayedOnCategoryPage(driver, newCategoryName);
		sAssert.assertFalse(flag1, "Deleted category is still displayed on UI");
		sAssert.assertAll();

	}
	@Test (priority = 8)
	public void verifyCategoryDeletedSuccessMessageIsDisplayed()
	{
		SoftAssert sAssert = new SoftAssert();		
		sAssert.assertTrue(inventoryCategoryPage.isCategoryDeletedSuccessMessageDisplayed(driver), "Category deleted message is not displayed");
		sAssert.assertAll();
	}
/*	@Test (priority = 9)
	public void verifyCategoryPageCountWillGetDecreasedAfterDelete()
	{
		SoftAssert sAssert = new SoftAssert();
		inventoryCategoryPage.clearSearchBox(driver);
		 int afterDelete = inventoryCategoryPage.getCountOfRecordsOnCategoryPage(driver);
		sAssert.assertEquals((afterDelete+1), afterAddCount);
		sAssert.assertAll();
	}*/



