package testscripts.AssetCostAndValueAssignment;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import pom.AssetMenuPage;
import pom.AssetValueAndStatusChangePage;

public class AssetStatusAndValueChangeMethod  
{

	public void assetValueAssignement(WebDriver driver,String cost) throws InterruptedException, IOException
	{
		AssetMenuPage asm= new AssetMenuPage(driver);
		asm.openAssetCostAssignmentPage();
		AssetValueAndStatusChangePage asvl= new  AssetValueAndStatusChangePage(driver);
		asvl.selectGridCheckBox();
		asvl.selectAssignmentOperator();
		asvl.enterCostOfAsset(cost);
		asvl.clickOnAddButton();
		asvl.clickOnAssignmentButton();
		asvl.selectGLTemplate();
		asvl.clickOnSaveButton();
		asvl.handlePopup();
		asvl.verfyTittle("Asset List", "failed");
	}
}
