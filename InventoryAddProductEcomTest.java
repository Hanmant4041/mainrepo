package regression;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.uiFramework.KTCTC.Pages.InventoryAddBrandPage;
import com.uiFramework.KTCTC.Pages.InventoryAddProductPageEcom;
import com.uiFramework.KTCTC.Pages.InventoryAddUnitPage;
import com.uiFramework.KTCTC.Pages.InventoryCategoryPage;
import com.uiFramework.KTCTC.common.CommonMethods;
import com.uiFramework.KTCTC.helper.browserConfiguration.ChromeBrowser;
import com.uiFramework.KTCTC.helper.property.PropertyFileHelper;
import com.uiFramework.KTCTC.testbase.TestBase;

public class InventoryAddProductEcomTest extends TestBase {

	InventoryAddProductPageEcom inventoryAddProductPageEcom = new InventoryAddProductPageEcom(driver);
	InventoryCategoryTest inventoryCategoryTest = new InventoryCategoryTest();
	InventoryBrandTest  inventoryBrandTest = new  InventoryBrandTest();
	CommonMethods cmobj;
	String product ="";
	String price="";
	String stock="";
	String brand =cmObj.getAlphaNumericString(4);
	String unit=cmObj.getcharacterString(3);
	String categoryName = cmObj.getcharacterString(6);
	
	@BeforeClass
	public void beforeClassOfA() {
		driver = ChromeBrowser.getBrowserInstance();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		//driver.manage().window().maximize();
		test = extent.createTest(getClass().getSimpleName());
		PropertyFileHelper proObj = new PropertyFileHelper("env.properties");
		driver.get(proObj.getPropertyValueFromFile("baseURL"));
		cmObj.loginToApplication(driver, proObj.getPropertyValueFromFile("adminNumber"),proObj.getPropertyValueFromFile("adminPass"));
		InventoryCategoryPage inventoryCategoryPage = new InventoryCategoryPage(driver);
		cmObj.expandInventoryOption(driver);
		inventoryCategoryPage.expandCategoruOption();
		inventoryCategoryPage.addNewCategory(categoryName);
		InventoryAddBrandPage inventoryAddBrandPage = new InventoryAddBrandPage(driver);
		inventoryAddBrandPage.expandBrandoption();
		inventoryAddBrandPage.addNewBrandInventory(brand);
		InventoryAddUnitPage inventoryAddUnitPage = new InventoryAddUnitPage(driver);
		inventoryAddUnitPage.expandUnitOptionFrominventory();
		inventoryAddUnitPage.addunitOnCategoryPage(unit);
		
	}
		
	@Test(priority=1)
	public void verifyusercanAddNewProduct()
	{
		inventoryAddProductPageEcom = new InventoryAddProductPageEcom(driver);
		SoftAssert sas = new SoftAssert();
		cmobj=new CommonMethods ();
		cmobj.getAlphaNumericString(5);
		cmobj.expandInventoryOption(driver);
		product=cmobj.getAlphaNumericString(5);
		price =cmobj.getNumericString(2);
		stock = cmobj.getNumericString(2);
		//inventoryCategoryTest.verifyUserCanAddNewCategory();
		//inventoryBrandTest.verifyUserCanAddNewBrand();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		inventoryAddProductPageEcom.expandProductFromInventory();
		inventoryAddProductPageEcom.addNewProductInProductList(product, categoryName, price, unit , "D:\\HBD\\TTTT\\image\\rasgulla.jpg", "Yes", inventoryBrandTest.newbrandName, stock);

		//String product,String autocat,String price,String unitadd,String file,String status,String brand,String stockquantity

		sas.assertAll();
	}




}
