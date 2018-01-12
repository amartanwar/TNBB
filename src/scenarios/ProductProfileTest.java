package scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pom.LeaseWaveHeader;
import pom.ProductListPage;
import pom.ProductProfilePage;
import pom.TemplatesMenuPage;
import testDataProvider_Repository.Scenario2;

public class ProductProfileTest extends BaseTest
{
	@Test(dataProvider="scenario2_Testdata",dataProviderClass=Scenario2.class)
	public void productCreationTest(String productCode,String programName) throws IOException, InterruptedException
	{
		test=reports.createTest("productCreationTest","Product profile smoke tesst");
		
		LeaseWaveHeader lw= new LeaseWaveHeader(driver);
		lw.clickOnFleetManagement();
		
		TemplatesMenuPage tm= new TemplatesMenuPage(driver);
		tm.openProductProfile();
		
		
		ProductListPage pl= new ProductListPage(driver);
		
		pl.clickOnAddButton();
		
		ProductProfilePage pp= new ProductProfilePage(driver);
		pp.enterProductCode(productCode);
		
		pp.enterProductName(programName);
		
		pp.selectProductCategory(1);
		
		pp.selectProductFrequency(1);
		
		pp.selectGLTemplate(1);
		
		pp.selectSundryCode(1);
		
		pp.clickOnSaveButton();
		
		pp.verfyTittle("Product List", "Product "+productCode+" has been created successfully");
		test.log(Status.PASS, "Product "+productCode+" has been created successfully");
		
	}
}
