package testcase;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;
import pages.WithdrawCredit;
import utilities.ReadXLData;

@Listeners(base.Listeners.class)
public class WithdrawCreditTest extends BaseTest {
	private WithdrawCredit withdrawCredit;

	/**
	 * Test case to withdraw credit with valid UPI details.
	 */
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void Withdraw_valid_Upi(String Email, String Password, String Amount, String Upi, String Remark, String Otp,
			String expectedPaymentStatus, String expectedCreditStatus, String expectedCreditType,
			String expectedSuccessMessage) {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();
		
		withdrawCredit = new WithdrawCredit(driver);

		// Perform login and navigate to withdraw page
		withdrawCredit.enterEmail(Email);
		withdrawCredit.enterPassword(Password);
		withdrawCredit.clickLoginButton();
		withdrawCredit.clickCreditButton();
		withdrawCredit.clickWithdrawButton();

		// Fill out the withdrawal form
		withdrawCredit.enterAmount(Amount);
		withdrawCredit.clickNext();
		withdrawCredit.clearAndEnterUpi(Upi);
		withdrawCredit.enterRemark(Remark);
		withdrawCredit.clickCheckBox();
		withdrawCredit.clickNext();
		withdrawCredit.enterOtp(Otp);
		withdrawCredit.clickNext();

		// Validate the results
		String actualSuccessMessage = withdrawCredit.getSuccessMessage().replace("...", "�");
		String ActualPaymentStatus = withdrawCredit.getPaymentStatus();
		String ActualCreditStatus = withdrawCredit.getCreditStatus();
		String ActualCreditType = withdrawCredit.getCreditTypeTask();

		// Assert the results
		try {
			softAssert.assertEquals(actualSuccessMessage, expectedSuccessMessage);
			softAssert.assertEquals(ActualPaymentStatus, expectedPaymentStatus);
			softAssert.assertEquals(ActualCreditStatus, expectedCreditStatus);
			softAssert.assertEquals(ActualCreditType, expectedCreditType);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}
	}

	/**
	 * Test case to withdraw credit with valid bank details.
	 * @throws InterruptedException 
	 */
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void Withdraw_valid_Bank(String Email, String Password, String Amount, String BankAccountNumber,
			String BankAccountConfirm, String IFSCcode, String AccountHolderName, String Remark, String Otp,
			String expectedPaymentStatus, String expectedCreditStatus, String expectedCreditType,
			String expectedSuccessMessage) throws InterruptedException {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();
		
		withdrawCredit = new WithdrawCredit(driver);

		// Perform login and navigate to withdraw page
		withdrawCredit.enterEmail(Email);
		withdrawCredit.enterPassword(Password);
		withdrawCredit.clickLoginButton();
		withdrawCredit.clickCreditButton();
		withdrawCredit.clickWithdrawButton();

		// Fill out the withdrawal form
		withdrawCredit.enterAmount(Amount);
		withdrawCredit.clickNext();
	//	Thread.sleep(3000);
	//	withdrawCredit.navigateToBankPopup();
		withdrawCredit.clickRadioButton();
		withdrawCredit.enterBankAccount(BankAccountNumber);
		withdrawCredit.enterBankAccountConfirm(BankAccountConfirm);
		withdrawCredit.enterIFSCcode(IFSCcode);
		withdrawCredit.enterAccountHolderName(AccountHolderName);
		withdrawCredit.enterRemark(Remark);
		withdrawCredit.clickCheckBox();
		withdrawCredit.clickNext();
		withdrawCredit.enterOtp(Otp);
		withdrawCredit.clickNext();

		// Validate the results
		String actualSuccessMessage = withdrawCredit.getSuccessMessage();
		String ActualPaymentStatus = withdrawCredit.getPaymentStatus();
		String ActualCreditStatus = withdrawCredit.getCreditStatus();
		String ActualCreditType = withdrawCredit.getCreditTypeTask();

		// Assert the results
		try {
			softAssert.assertEquals(actualSuccessMessage, expectedSuccessMessage);
			softAssert.assertEquals(ActualPaymentStatus, expectedPaymentStatus);
			softAssert.assertEquals(ActualCreditStatus, expectedCreditStatus);
			softAssert.assertEquals(ActualCreditType, expectedCreditType);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}
	}

	/**
	 * Test case to validate error message for invalid UPI.
	 */
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void Withdraw_Invalid_Upi(String Email, String Password, String Amount, String Upi, String Remark,
			String expectedErrorMessage) {
		
		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		withdrawCredit = new WithdrawCredit(driver);

		// Perform login and navigate to withdraw page
		withdrawCredit.enterEmail(Email);
		withdrawCredit.enterPassword(Password);
		withdrawCredit.clickLoginButton();
		withdrawCredit.clickCreditButton();
		withdrawCredit.clickWithdrawButton();

		// Fill out the withdrawal form
		withdrawCredit.enterAmount(Amount);
		withdrawCredit.clickNext();
		withdrawCredit.clearAndEnterUpi(Upi);
		withdrawCredit.enterRemark(Remark);
		withdrawCredit.clickCheckBox();
		withdrawCredit.clickNext();

		// Validate the error message
		String actualErrorMessage = withdrawCredit.getErrorMessageForInvalidUpi();

		try {
			softAssert.assertEquals(actualErrorMessage, expectedErrorMessage);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}
	}

	/**
	 * Test case to validate error message for invalid bank account number.
	 */
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void Withdraw_Invalid_BankNumber(String Email, String Password, String Amount, String BankAccountNumber,
			String BankAccountConfirm, String IFSCcode, String AccountHolderName, String Remark,
			String expectedErrorMessage) {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();
		
		withdrawCredit = new WithdrawCredit(driver);

		// Perform login and navigate to withdraw page
		withdrawCredit.enterEmail(Email);
		withdrawCredit.enterPassword(Password);
		withdrawCredit.clickLoginButton();
		withdrawCredit.clickCreditButton();
		withdrawCredit.clickWithdrawButton();

		// Fill out the withdrawal form
		withdrawCredit.enterAmount(Amount);
		withdrawCredit.clickNext();
		withdrawCredit.clickRadioButton();
		withdrawCredit.enterBankAccount(BankAccountNumber);
		withdrawCredit.enterBankAccountConfirm(BankAccountConfirm);
		withdrawCredit.enterIFSCcode(IFSCcode);
		withdrawCredit.enterAccountHolderName(AccountHolderName);
		withdrawCredit.enterRemark(Remark);
		withdrawCredit.clickCheckBox();
		withdrawCredit.clickNext();

		// Validate the error message
		String actualErrorMessage = withdrawCredit.getErrorMessageForInvalidBankAccountNumber();

		try {
			softAssert.assertEquals(actualErrorMessage, expectedErrorMessage);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}
	}

	/**
	 * Test case for additional validation of bank number errors.
	 */
	// Expected result is not working correctly for this tried manually
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void Withdraw_Invalid_ConfAccBankNum(String Email, String Password, String Amount, String BankAccountNumber,
			String BankAccountConfirm, String IFSCcode, String AccountHolderName, String Remark) {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();
		
		withdrawCredit = new WithdrawCredit(driver);

		// Perform login and navigate to withdraw page
		withdrawCredit.enterEmail(Email);
		withdrawCredit.enterPassword(Password);
		withdrawCredit.clickLoginButton();
		withdrawCredit.clickCreditButton();
		withdrawCredit.clickWithdrawButton();

		// Fill out the withdrawal form
		withdrawCredit.enterAmount(Amount);
		withdrawCredit.clickNext();
		withdrawCredit.clickRadioButton();
		withdrawCredit.enterBankAccount(BankAccountNumber);
		withdrawCredit.enterBankAccountConfirm(BankAccountConfirm);
		withdrawCredit.enterIFSCcode(IFSCcode);
		withdrawCredit.enterAccountHolderName(AccountHolderName);
		withdrawCredit.enterRemark(Remark);
		withdrawCredit.clickCheckBox();
		withdrawCredit.clickNext();
		
		
	}

	/**
	 * Test case to validate error message for invalid IFSC code.
	 */
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void Withdraw_Invalid_IFSCcode(String Email, String Password, String Amount, String BankAccountNumber,
			String BankAccountConfirm, String IFSCcode, String AccountHolderName, String Remark,
			String expectedErrorMessage) {
		
		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		withdrawCredit = new WithdrawCredit(driver);

		// Perform login and navigate to withdraw page
		withdrawCredit.enterEmail(Email);
		withdrawCredit.enterPassword(Password);
		withdrawCredit.clickLoginButton();
		withdrawCredit.clickCreditButton();
		withdrawCredit.clickWithdrawButton();

		// Fill out the withdrawal form
		withdrawCredit.enterAmount(Amount);
		withdrawCredit.clickNext();
		withdrawCredit.clickRadioButton();
		withdrawCredit.enterBankAccount(BankAccountNumber);
		withdrawCredit.enterBankAccountConfirm(BankAccountConfirm);
		withdrawCredit.enterIFSCcode(IFSCcode);
		withdrawCredit.enterAccountHolderName(AccountHolderName);
		withdrawCredit.enterRemark(Remark);
		withdrawCredit.clickCheckBox();
		withdrawCredit.clickNext();

		// Validate the error message
		String actualErrorMessage = withdrawCredit.getErrorMessageForInvalidIFSCcode();

		try {
			softAssert.assertEquals(actualErrorMessage, expectedErrorMessage);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}
	}

	/**
	 * Test case to validate error message for short IFSC code.
	 */
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void Withdraw_Short_IFSCcode(String Email, String Password, String Amount, String BankAccountNumber,
			String BankAccountConfirm, String IFSCcode, String AccountHolderName, String Remark,
			String expectedErrorMessage) {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();
		
		withdrawCredit = new WithdrawCredit(driver);

		// Perform login and navigate to withdraw page
		withdrawCredit.enterEmail(Email);
		withdrawCredit.enterPassword(Password);
		withdrawCredit.clickLoginButton();
		withdrawCredit.clickCreditButton();
		withdrawCredit.clickWithdrawButton();

		// Fill out the withdrawal form
		withdrawCredit.enterAmount(Amount);
		withdrawCredit.clickNext();
		withdrawCredit.clickRadioButton();
		withdrawCredit.enterBankAccount(BankAccountNumber);
		withdrawCredit.enterBankAccountConfirm(BankAccountConfirm);
		withdrawCredit.enterIFSCcode(IFSCcode);
		withdrawCredit.enterAccountHolderName(AccountHolderName);
		withdrawCredit.enterRemark(Remark);
		withdrawCredit.clickCheckBox();
		withdrawCredit.clickNext();

		// Validate the error message
		String actualErrorMessage = withdrawCredit.getErrorMessageForShortIFSCcode();

		try {
			softAssert.assertEquals(actualErrorMessage, expectedErrorMessage);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}
	}

	/**
	 * Test case to validate error message for invalid account holder name.
	 */
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void Withdraw_Invalid_Name(String Email, String Password, String Amount, String BankAccountNumber,
			String BankAccountConfirm, String IFSCcode, String AccountHolderName, String Remark,
			String expectedErrorMessage) {
		
		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();

		withdrawCredit = new WithdrawCredit(driver);

		// Perform login and navigate to withdraw page
		withdrawCredit.enterEmail(Email);
		withdrawCredit.enterPassword(Password);
		withdrawCredit.clickLoginButton();
		withdrawCredit.clickCreditButton();
		withdrawCredit.clickWithdrawButton();

		// Fill out the withdrawal form
		withdrawCredit.enterAmount(Amount);
		withdrawCredit.clickNext();
		withdrawCredit.clickRadioButton();
		withdrawCredit.enterBankAccount(BankAccountNumber);
		withdrawCredit.enterBankAccountConfirm(BankAccountConfirm);
		withdrawCredit.enterIFSCcode(IFSCcode);
		withdrawCredit.enterAccountHolderName(AccountHolderName);
		withdrawCredit.enterRemark(Remark);
		withdrawCredit.clickCheckBox();
		withdrawCredit.clickNext();

		// Validate the error message
		String actualErrorMessage = withdrawCredit.getErrorMessageForInvalidName();

		try {
			softAssert.assertEquals(actualErrorMessage, expectedErrorMessage);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}
	}

	/**
	 * Test case to validate error message for short account holder name.
	 */
	@Test(dataProviderClass = ReadXLData.class, dataProvider = "testData")
	public void Withdraw_Short_Name(String Email, String Password, String Amount, String BankAccountNumber,
			String BankAccountConfirm, String IFSCcode, String AccountHolderName, String Remark,
			String expectedErrorMessage) {

		softAssert = new SoftAssert();
		assertionMessage = new ThreadLocal<>();
		
		withdrawCredit = new WithdrawCredit(driver);

		// Perform login and navigate to withdraw page
		withdrawCredit.enterEmail(Email);
		withdrawCredit.enterPassword(Password);
		withdrawCredit.clickLoginButton();
		withdrawCredit.clickCreditButton();
		withdrawCredit.clickWithdrawButton();

		// Fill out the withdrawal form
		withdrawCredit.enterAmount(Amount);
		withdrawCredit.clickNext();
		withdrawCredit.clickRadioButton();
		withdrawCredit.enterBankAccount(BankAccountNumber);
		withdrawCredit.enterBankAccountConfirm(BankAccountConfirm);
		withdrawCredit.enterIFSCcode(IFSCcode);
		withdrawCredit.enterAccountHolderName(AccountHolderName);
		withdrawCredit.enterRemark(Remark);
		withdrawCredit.clickCheckBox();
		withdrawCredit.clickNext();

		// Validate the error message
		String actualErrorMessage = withdrawCredit.getErrorMessageForShortName();
		
		try {
			softAssert.assertEquals(actualErrorMessage, expectedErrorMessage);
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} catch (Exception e) {
			BaseTest.logExceptionToReport(e); // Log exception to Extent Reports
			throw e;
		}
	}
}
