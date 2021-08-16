package com.automation.pagelib;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.automation.testbase.TestBase;

public class Recharge extends TestBase {
	
	private static Logger logger = LogManager.getLogger(Recharge.class);
	public void operatorClick() throws Exception {
		new TestBase().defaultframe();

		logger.info("Click on Operaton option");
		getWebElement("app.operator").click();
	}



	public void operatorselect(String Operator) throws Exception {
		logger.info("Select the  Operator");
		for (int i = 0; i < getWebElements("app.operatorselect").size(); i++) {
			if (getWebElements("app.operatorselect").get(i).getText().equalsIgnoreCase(Operator)) {
				getWebElements("app.operatorselect").get(i).click();
			}
		}

	}

	public void setMobileNumber(String Name) throws Exception {
		logger.info("Enter the Mobile Number");
		getWebElement("app.mobilenumber").clear();
		getWebElement("app.mobilenumber").sendKeys(Name);
	}

	public void amountClick() throws Exception {
		new TestBase().defaultframe();
		logger.info("Click on Operaton option");

		getWebElement("app.amount").click();

	}

	public void amountselect(String Amount) throws Exception {
		logger.info("Select the  Amount");
		for (int i = 0; i < getWebElements("app.amountselect").size(); i++) {
			if (getWebElements("app.amountselect").get(i).getText().equalsIgnoreCase(Amount)) {
				getWebElements("app.amountselect").get(i).click();
			}
		}

	}

	public void nextbtnClick() throws Exception {
		new TestBase().defaultframe();
		logger.info("Click on Next  Button");
		getWebElement("app.nextbtn").click();

	}

	
	public WebElement RechagrCellularPage() throws Exception {
		new TestBase().defaultframe();
		//waitelement(getWebElement("app.recharge"));
		return getWebElement("app.recharge");
	}

	public WebElement PaymentPage() throws Exception {
		new TestBase().defaultframe();
		// waitelement(getWebElement("app.paymentscreen"));
		return getWebElement("app.paymentscreen");
	}
	public WebElement Cellular() throws Exception {
		new TestBase().defaultframe();
		//waitelement(getWebElement("app.spinner"));
		return getWebElement("app.spinner");
	}

	
	
}

