package com.automation.testscript;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.Assert.ThrowingRunnable;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.automation.excelread.Dataprovider;
import com.automation.pagelib.Recharge;
import com.automation.testbase.TestBase;

public class Recharge_TC extends TestBase {

	private static Logger logger = LogManager.getLogger(Recharge_TC.class);

	@Test(dataProvider = "rechargedetails", dataProviderClass = Dataprovider.class)
	public void rechargeDetails(String InputType, String Operator, String MobileNumber, String Amount,
			String PageVerify, String PaymentScreen) throws Exception {
		SoftAssert softas = new SoftAssert();
		if (InputType.trim().equalsIgnoreCase("Y")) {

			TestBase.test = report.extent.createTest("Recharge_TC");
			if (new Recharge().RechagrCellularPage().getText().trim().equalsIgnoreCase(PageVerify.trim())) {
				new Recharge().operatorClick();
				test.pass("Operator is clicked");
				new Recharge().operatorselect(Operator);
				test.pass("Operator is Selected" + Operator);
				new Recharge().setMobileNumber(MobileNumber);
				test.pass("Set the Mobile Number as " + MobileNumber);
				new Recharge().amountClick();
				test.pass("Click on Amount Field");
				new Recharge().amountselect(Amount);
				test.pass("Select the Amount as" + Amount);
				new Recharge().nextbtnClick();
				test.pass("Click on Next Button");
		
				if (new Recharge().PaymentPage().getText().trim().equalsIgnoreCase(PaymentScreen.trim())) {

				} else {

					test.fail(PaymentScreen + " page is not displayed");
					boolean paymentscr = new Recharge().PaymentPage().isDisplayed();
		
					Assert.assertEquals(paymentscr, true);
				}

			} else {
				test.fail(PageVerify + " page is not displayed");
				boolean pageV = new Recharge().RechagrCellularPage().isDisplayed();

				Assert.assertEquals(pageV, true);
			}

		}

		else {
			logger.info("TesCase Not Executed");
			test.skip("Test Case skipped");

		}

	}

}
