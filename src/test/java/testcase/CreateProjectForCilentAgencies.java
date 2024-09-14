package testcase;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CreateProjectPage;
import pages.CreateworkorderPage;
import pages.InvitingclientPage;
import utilities.ReadXLData;

@Listeners(base.Listeners.class)
public class CreateProjectForCilentAgencies extends BaseTest{
	
 //Create Project for Client/Agencies
    
    @Test(dependsOnMethods = {"testcase.Login.login"} ,dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void createProjectForAgencies(String CompanyName, String PersonName, String Email, String MobileResponsible
, String expectedSuccessMessage,String ProjectTitle,String ProjectDescription,String ProjectCode,String LinkTitle,
    		String LinkURL,String EnterMetrics,String EnterQuantity,String StartDate,String EndDate,String FieldName, String EnterFrequency, 
    		String EnterRadius,String EnterItem, String EnterDescription
    		,String EnterRates,String EnterQty, String EnterDays, String ExpectedResult) throws InterruptedException {
        InvitingclientPage ClientPage = new InvitingclientPage(driver);
        CreateProjectPage ProjectPage = new CreateProjectPage(driver);
 
        ClientPage.clickOnUserButton();
	       
        ClientPage.clickOnClientsOption();

        ClientPage.clickOnInviteClientButton();
       
        ClientPage.NavigateToDialogBox();
       
       
        String randomName = CompanyName + (int) (Math.random() * 1000);
        String randomAnotherName = PersonName + (int) (Math.random() * 1000); // Appends a random number between 0 and 999 to the name
        String randomPhone = generateRandomPhoneNumber(); // Generates a random phone number
        String randomEmail = generateRandomEmail(Email);
        // Appends a random number to the email username
 
        ClientPage.enterClientName(randomName);
        ClientPage.enterMobileNumber(randomAnotherName);
        ClientPage.enterEmail(randomEmail);
        ClientPage.enterAddress(randomPhone);
        Thread.sleep(4000);
        ClientPage.clickOnCreateClientButton();
        
      //ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnProjectTabButton();
       //ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnCreateProjectButton();
        ProjectPage.clickOnSelfClientButton();
        ProjectPage.clickOnNext1Button();
        Thread.sleep(2000);
        ProjectPage.clickOnProjectTypeButton();
        ProjectPage.clickOnSelectProjectTypeButton();
        ProjectPage.clickOnHotspotButton();
        ProjectPage.clickOnNext2Button();
        //ProjectPage.clickOnProjectDetailsButton();
        ProjectPage.enterProjectTitle(ProjectTitle);
        ProjectPage.enterProjectDescription(ProjectDescription);
        ProjectPage.enterProjectCode(ProjectCode);
        ProjectPage.enterLinkTitle(LinkTitle);
        ProjectPage.enterURL(LinkURL);
        ProjectPage.enterMetrics(EnterMetrics);
        ProjectPage.enterQuantity(EnterQuantity);
        ProjectPage.clickOnStartDateButton();
      //ProjectPage.enterStartDate(StartDate);
        ProjectPage.clickOnSelectStartDate();
        ProjectPage.clickOnEndDateButton();
      //ProjectPage.enterEndDate(EndDate);
        ProjectPage.clickOnSelectEndDate();
        ProjectPage.clickOnSelectLocationButton();
        ProjectPage.clickOnSelectLocationDelhiButton();
        ProjectPage.clickOnAddTrackingButton();
        ProjectPage.enterFieldName(FieldName);
        ProjectPage.clickOnFieldTypeDropDown();
        ProjectPage.clickOnPhoneNumberButton();
        ProjectPage.clickOnContinuousLocationTracking();
        ProjectPage.enterFrequency(EnterFrequency);
        ProjectPage.enterRadius(EnterRadius);
        //ProjectPage.clickOnOnlyGpsCoordinate();
        ProjectPage.clickOnAddBilling();
        ProjectPage.clickOnPricingFixed();
        ProjectPage.enterItem(EnterItem);
        ProjectPage.enterDescription(EnterDescription);
        ProjectPage.enterRate(EnterRates);
        ProjectPage.enterQty(EnterQty);
        ProjectPage.enterDays(EnterDays);
        ProjectPage.clickOnReviewProject();
        ProjectPage.clickOnSaveProject();
        
        
       String ProjectCreatedSuccesfully = ProjectPage.ProjectCreatedSuccesfully();
        softAssert.assertEquals(ProjectCreatedSuccesfully, ExpectedResult);
        try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}
     
        
    }
    
    private String generateRandomPhoneNumber() {
	    // Generate the first digit as a random number between 5 and 9
	    int firstDigit = 5 + (int) (Math.random() * 5);

	    // Generate the remaining 9 digits
	    long remainingDigits = (long) (Math.random() * 1000000000L); // 9 digits

	    // Combine the first digit with the remaining 9 digits and format as a 10-digit number
	    return String.format("%d%09d", firstDigit, remainingDigits);
	}
 
    // Utility method to generate a random email
    private String generateRandomEmail(String baseEmail) {
        int randomNum = (int) (Math.random() * 1000); // Generates a random number between 0 and 999
        String[] emailParts = baseEmail.split("@");
        if (emailParts.length == 2) {
            return emailParts[0] + randomNum + "@" + emailParts[1]; // Inserts the random number before the '@' symbol
        }
        return baseEmail; // Fallback to the original email if the format is unexpected
    }
    
    // Invalid Project Type - Creating Project agencies
    
    @Test(dependsOnMethods = {"testcase.Login.login"} ,dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void CreateProjectInvalidProjectType(String CompanyName, String PersonName, String Email, String MobileResponsible
, String expectedSuccessMessage, String ExpectedResult) throws InterruptedException {
        InvitingclientPage ClientPage = new InvitingclientPage(driver);
        CreateProjectPage ProjectPage = new CreateProjectPage(driver);
 
        ClientPage.clickOnUserButton();
	       
        ClientPage.clickOnClientsOption();

        ClientPage.clickOnInviteClientButton();
       
        ClientPage.NavigateToDialogBox();
       
       
        String randomName = CompanyName + (int) (Math.random() * 1000);
        String randomAnotherName = PersonName + (int) (Math.random() * 1000); // Appends a random number between 0 and 999 to the name
        String randomPhone = generateRandomPhoneNumber(); // Generates a random phone number
        String randomEmail = generateRandomEmail(Email);
        // Appends a random number to the email username
 
        ClientPage.enterClientName(randomName);
        ClientPage.enterMobileNumber(randomAnotherName);
        ClientPage.enterEmail(randomEmail);
        ClientPage.enterAddress(randomPhone);
        Thread.sleep(4000);
        ClientPage.clickOnCreateClientButton();

        //ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnProjectTabButton();
       // ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnCreateProjectButton();
        ProjectPage.clickOnSelfClientButton();
        ProjectPage.clickOnNext1Button();
        Thread.sleep(2000);
        ProjectPage.clickOnProjectTypeButton();
        //ProjectPage.clickOnSelectProjectTypeButton();
       // ProjectPage.clickOnHotspotButton();
        ProjectPage.clickOnNext2Button();
        //ProjectPage.clickOnProjectDetailsButton();
        
        String SelectedImproperProjectType = ProjectPage.SelectedImproperProjectType();
        softAssert.assertEquals(SelectedImproperProjectType, ExpectedResult);
        try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}
    
}
  
    //Invalid Project Title - Creating Project Agencies
    
    @Test(dependsOnMethods = {"testcase.Login.login"} ,dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void CreateProjectInvalidProjectTitl(String CompanyName, String PersonName, String Email, String MobileResponsible
, String expectedSuccessMessage,String ProjectTitle,String ProjectDescription, String ExpectedResult) throws InterruptedException {
        InvitingclientPage ClientPage = new InvitingclientPage(driver);
        CreateProjectPage ProjectPage = new CreateProjectPage(driver);
 
        ClientPage.clickOnUserButton();
	       
        ClientPage.clickOnClientsOption();

        ClientPage.clickOnInviteClientButton();
       
        ClientPage.NavigateToDialogBox();
       
       
        String randomName = CompanyName + (int) (Math.random() * 1000);
        String randomAnotherName = PersonName + (int) (Math.random() * 1000); // Appends a random number between 0 and 999 to the name
        String randomPhone = generateRandomPhoneNumber(); // Generates a random phone number
        String randomEmail = generateRandomEmail(Email);
        // Appends a random number to the email username
 
        ClientPage.enterClientName(randomName);
        ClientPage.enterMobileNumber(randomAnotherName);
        ClientPage.enterEmail(randomEmail);
        ClientPage.enterAddress(randomPhone);
        Thread.sleep(4000);
        ClientPage.clickOnCreateClientButton();
        
       //ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnProjectTabButton();
       //ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnCreateProjectButton();
        //ProjectPage.clickOnSelfClientButton();
        ProjectPage.clickOnExistingEnterprise();
        ProjectPage.SelectDropdownEnterprise();
        ProjectPage.SelectOptionEnterprise();
        ProjectPage.clickOnNext1Button();
        Thread.sleep(2000);
        ProjectPage.clickOnProjectTypeButton();
        ProjectPage.SelectNewProjectType();
        ProjectPage.clickOnHotspotButton();
        ProjectPage.clickOnNext2Button();
      //  ProjectPage.clickOnProjectDetailsButton();
        ProjectPage.enterProjectTitle(ProjectTitle);
        ProjectPage.enterProjectDescription(ProjectDescription);
        ProjectPage.clickOnSelectLocationButton();
        
        String InvalidProjectTitle = ProjectPage.InvalidProjectTitle();
        softAssert.assertEquals(InvalidProjectTitle, ExpectedResult);
        try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		} 
}
    
    //Invalid Project Description - Creating Project Agencies
    
    @Test(dependsOnMethods = {"testcase.Login.login"} ,dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void CreateProjectInvalidProjectDesc(String CompanyName, String PersonName, String Email, String MobileResponsible
, String expectedSuccessMessage,String ProjectTitle,String ProjectDescription, String ExpectedResult) throws InterruptedException {
        InvitingclientPage ClientPage = new InvitingclientPage(driver);
        CreateProjectPage ProjectPage = new CreateProjectPage(driver);
 
        ClientPage.clickOnUserButton();
	       
        ClientPage.clickOnClientsOption();

        ClientPage.clickOnInviteClientButton();
       
        ClientPage.NavigateToDialogBox();
       
       
        String randomName = CompanyName + (int) (Math.random() * 1000);
        String randomAnotherName = PersonName + (int) (Math.random() * 1000); // Appends a random number between 0 and 999 to the name
        String randomPhone = generateRandomPhoneNumber(); // Generates a random phone number
        String randomEmail = generateRandomEmail(Email);
        // Appends a random number to the email username
 
        ClientPage.enterClientName(randomName);
        ClientPage.enterMobileNumber(randomAnotherName);
        ClientPage.enterEmail(randomEmail);
        ClientPage.enterAddress(randomPhone);
        Thread.sleep(4000);
        ClientPage.clickOnCreateClientButton();
        
      //ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnProjectTabButton();
       //ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnCreateProjectButton();
        //ProjectPage.clickOnSelfClientButton();
        ProjectPage.clickOnExistingEnterprise();
        ProjectPage.SelectDropdownEnterprise();
        ProjectPage.SelectOptionEnterprise();
        ProjectPage.clickOnNext1Button();
        Thread.sleep(2000);
        ProjectPage.clickOnProjectTypeButton();
        ProjectPage.SelectNewProjectType();
        ProjectPage.clickOnHotspotButton();
        ProjectPage.clickOnNext2Button();
        ProjectPage.enterProjectTitle(ProjectTitle);
        ProjectPage.enterProjectDescription(ProjectDescription);
        ProjectPage.clickOnSelectLocationButton();
        
        String InvalidProjectDescription = ProjectPage.EnterProperProjectDescription();
        softAssert.assertEquals(InvalidProjectDescription, ExpectedResult);
        try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}
	
    }
    
    //Invalid Field Name - Create Project Agencies
    
    @Test(dependsOnMethods = {"testcase.Login.login"} ,dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void CreateProjectInvalidFieldName(String CompanyName, String PersonName, String Email, String MobileResponsible
    		, String expectedSuccessMessage,String ProjectTitle,String ProjectDescription,String ProjectCode,String LinkTitle,
    		String LinkURL,String EnterMetrics,String EnterQuantity,String FieldName,String EnterFrequency,
    		String EnterRadius,String ExpectedResult) throws InterruptedException {
        InvitingclientPage ClientPage = new InvitingclientPage(driver);
        CreateProjectPage ProjectPage = new CreateProjectPage(driver);
 
        ClientPage.clickOnUserButton();
	       
        ClientPage.clickOnClientsOption();

        ClientPage.clickOnInviteClientButton();
       
        ClientPage.NavigateToDialogBox();
       
       
        String randomName = CompanyName + (int) (Math.random() * 1000);
        String randomAnotherName = PersonName + (int) (Math.random() * 1000); // Appends a random number between 0 and 999 to the name
        String randomPhone = generateRandomPhoneNumber(); // Generates a random phone number
        String randomEmail = generateRandomEmail(Email);
        // Appends a random number to the email username
 
        ClientPage.enterClientName(randomName);
        ClientPage.enterMobileNumber(randomAnotherName);
        ClientPage.enterEmail(randomEmail);
        ClientPage.enterAddress(randomPhone);
        Thread.sleep(4000);
        ClientPage.clickOnCreateClientButton();
        
        
      //ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnProjectTabButton();
       //ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnCreateProjectButton();
        //ProjectPage.clickOnSelfClientButton();
        ProjectPage.clickOnExistingEnterprise();
        ProjectPage.SelectDropdownEnterprise();
        ProjectPage.SelectOptionEnterprise();
        ProjectPage.clickOnNext1Button();
        Thread.sleep(2000);
        ProjectPage.clickOnProjectTypeButton();
        ProjectPage.SelectNewProjectType();
        ProjectPage.clickOnHotspotButton();
        ProjectPage.clickOnNext2Button();
      //ProjectPage.clickOnProjectDetailsButton();
        ProjectPage.enterProjectTitle(ProjectTitle);
        ProjectPage.enterProjectDescription(ProjectDescription);
        ProjectPage.enterProjectCode(ProjectCode);
        ProjectPage.enterLinkTitle(LinkTitle);
        ProjectPage.enterURL(LinkURL);
        ProjectPage.enterMetrics(EnterMetrics);
        ProjectPage.enterQuantity(EnterQuantity);
        ProjectPage.clickOnStartDateButton();
        ProjectPage.clickOnSelectStartDate();
        ProjectPage.clickOnEndDateButton();
        ProjectPage.clickOnSelectEndDate();
        ProjectPage.clickOnSelectLocationButton();
        ProjectPage.clickOnSelectLocationDelhiButton();
        ProjectPage.clickOnAddTrackingButton();
        ProjectPage.enterFieldName(FieldName);
        ProjectPage.clickOnFieldTypeDropDown();
        ProjectPage.clickOnPhoneNumberButton();
        ProjectPage.clickOnContinuousLocationTracking();
        ProjectPage.enterFrequency(EnterFrequency);
        ProjectPage.enterRadius(EnterRadius);
      //ProjectPage.clickOnOnlyGpsCoordinate();
        ProjectPage.clickOnAddBilling();
    
    
        String InvalidFieldName = ProjectPage.InvalidFieldName();
        softAssert.assertEquals(InvalidFieldName, ExpectedResult);
        try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}
	    
    }
    
    //Invalid Frequency - Create Project Agencies
    
    @Test(dependsOnMethods = {"testcase.Login.login"} ,dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void CreateProjectInvalidFrequency(String CompanyName, String PersonName, String Email, String MobileResponsible
    		, String expectedSuccessMessage,String ProjectTitle,String ProjectDescription,String ProjectCode,String LinkTitle,
    		String LinkURL,String EnterMetrics,String EnterQuantity,String FieldName,String EnterFrequency,
    		String EnterRadius,String ExpectedResult) throws InterruptedException {
        InvitingclientPage ClientPage = new InvitingclientPage(driver);
        CreateProjectPage ProjectPage = new CreateProjectPage(driver);
 
        ClientPage.clickOnUserButton();
	       
        ClientPage.clickOnClientsOption();

        ClientPage.clickOnInviteClientButton();
       
        ClientPage.NavigateToDialogBox();
       
       
        String randomName = CompanyName + (int) (Math.random() * 1000);
        String randomAnotherName = PersonName + (int) (Math.random() * 1000); // Appends a random number between 0 and 999 to the name
        String randomPhone = generateRandomPhoneNumber(); // Generates a random phone number
        String randomEmail = generateRandomEmail(Email);
        // Appends a random number to the email username
 
        ClientPage.enterClientName(randomName);
        ClientPage.enterMobileNumber(randomAnotherName);
        ClientPage.enterEmail(randomEmail);
        ClientPage.enterAddress(randomPhone);
        Thread.sleep(4000);
        ClientPage.clickOnCreateClientButton();
        
      //ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnProjectTabButton();
       //ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnCreateProjectButton();
        //ProjectPage.clickOnSelfClientButton();
        ProjectPage.clickOnExistingEnterprise();
        ProjectPage.SelectDropdownEnterprise();
        ProjectPage.SelectOptionEnterprise();
        ProjectPage.clickOnNext1Button();
        Thread.sleep(2000);
        ProjectPage.clickOnProjectTypeButton();
        ProjectPage.SelectNewProjectType();
        ProjectPage.clickOnHotspotButton();
        ProjectPage.clickOnNext2Button();  
        //ProjectPage.clickOnProjectDetailsButton();
        ProjectPage.enterProjectTitle(ProjectTitle);
        ProjectPage.enterProjectDescription(ProjectDescription);
        ProjectPage.enterProjectCode(ProjectCode);
        ProjectPage.enterLinkTitle(LinkTitle);
        ProjectPage.enterURL(LinkURL);
        ProjectPage.enterMetrics(EnterMetrics);
        ProjectPage.enterQuantity(EnterQuantity);
        ProjectPage.clickOnStartDateButton();
        ProjectPage.clickOnSelectStartDate();
        ProjectPage.clickOnEndDateButton();
        ProjectPage.clickOnSelectEndDate();
        ProjectPage.clickOnSelectLocationButton();
        ProjectPage.clickOnSelectLocationDelhiButton();
        ProjectPage.clickOnAddTrackingButton();
        ProjectPage.enterFieldName(FieldName);
        ProjectPage.clickOnFieldTypeDropDown();
        ProjectPage.clickOnPhoneNumberButton();
        ProjectPage.clickOnContinuousLocationTracking();
        ProjectPage.enterFrequency(EnterFrequency);
        ProjectPage.enterRadius(EnterRadius);
        //ProjectPage.clickOnOnlyGpsCoordinate();
        ProjectPage.clickOnAddBilling();
        
        String InvalidFrequency = ProjectPage.InvalidFrequency();
        softAssert.assertEquals(InvalidFrequency, ExpectedResult);
        try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}
    	
    }
    
    //Invalid Radius - Create Project Agencies
    
    @Test(dependsOnMethods = {"testcase.Login.login"} ,dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void CreateProjectInvalidRadius(String CompanyName, String PersonName, String Email, String MobileResponsible
    		, String expectedSuccessMessage,String ProjectTitle,String ProjectDescription,String ProjectCode,String LinkTitle,
    		String LinkURL,String EnterMetrics,String EnterQuantity,String FieldName,String EnterFrequency,
    		String EnterRadius,String ExpectedResult) throws InterruptedException {
        InvitingclientPage ClientPage = new InvitingclientPage(driver);
        CreateProjectPage ProjectPage = new CreateProjectPage(driver);
 
        ClientPage.clickOnUserButton();
	       
        ClientPage.clickOnClientsOption();

        ClientPage.clickOnInviteClientButton();
       
        ClientPage.NavigateToDialogBox();
       
       
        String randomName = CompanyName + (int) (Math.random() * 1000);
        String randomAnotherName = PersonName + (int) (Math.random() * 1000); // Appends a random number between 0 and 999 to the name
        String randomPhone = generateRandomPhoneNumber(); // Generates a random phone number
        String randomEmail = generateRandomEmail(Email);
        // Appends a random number to the email username
 
        ClientPage.enterClientName(randomName);
        ClientPage.enterMobileNumber(randomAnotherName);
        ClientPage.enterEmail(randomEmail);
        ClientPage.enterAddress(randomPhone);
        Thread.sleep(4000);
        ClientPage.clickOnCreateClientButton();
        
      //ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnProjectTabButton();
       //ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnCreateProjectButton();
        //ProjectPage.clickOnSelfClientButton();
        ProjectPage.clickOnExistingEnterprise();
        ProjectPage.SelectDropdownEnterprise();
        ProjectPage.SelectOptionEnterprise();
        ProjectPage.clickOnNext1Button();
        Thread.sleep(2000);
        ProjectPage.clickOnProjectTypeButton();
        ProjectPage.SelectNewProjectType();
        ProjectPage.clickOnHotspotButton();
        ProjectPage.clickOnNext2Button();  
      //ProjectPage.clickOnProjectDetailsButton();
        ProjectPage.enterProjectTitle(ProjectTitle);
        ProjectPage.enterProjectDescription(ProjectDescription);
        ProjectPage.enterProjectCode(ProjectCode);
        ProjectPage.enterLinkTitle(LinkTitle);
        ProjectPage.enterURL(LinkURL);
        ProjectPage.enterMetrics(EnterMetrics);
        ProjectPage.enterQuantity(EnterQuantity);
        ProjectPage.clickOnStartDateButton();
        ProjectPage.clickOnSelectStartDate();
        ProjectPage.clickOnEndDateButton();
        ProjectPage.clickOnSelectEndDate();
        ProjectPage.clickOnSelectLocationButton();
        ProjectPage.clickOnSelectLocationDelhiButton();
        ProjectPage.clickOnAddTrackingButton();
        ProjectPage.enterFieldName(FieldName);
        ProjectPage.clickOnFieldTypeDropDown();
        ProjectPage.clickOnPhoneNumberButton();
        ProjectPage.clickOnContinuousLocationTracking();
        ProjectPage.enterFrequency(EnterFrequency);
        ProjectPage.enterRadius(EnterRadius);
      //ProjectPage.clickOnOnlyGpsCoordinate();
       ProjectPage.clickOnAddBilling();
    
    
    String InvalidRadius = ProjectPage.InvalidRadius();
    softAssert.assertEquals(InvalidRadius, ExpectedResult);
    try {
		softAssert.assertAll();
	} catch (AssertionError e) {
		assertionMessage.set(e.getMessage());
		throw e;
	}
	
    }
    
    // Invalid Name
    
    @Test(dependsOnMethods = {"testcase.Login.login"} ,dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void verify_NameError(String CompanyName, String PersonName, String Email, String MobileResponsible
    		, String expectedErrorMessage) throws InterruptedException {
        InvitingclientPage ClientPage = new InvitingclientPage(driver);
 
        ClientPage.clickOnUserButton();
	       
        ClientPage.clickOnClientsOption();

        ClientPage.clickOnInviteClientButton();
       
        ClientPage.NavigateToDialogBox();
       
       
  //      String randomName = CompanyName + (int) (Math.random() * 1000);
        String randomAnotherName = PersonName + (int) (Math.random() * 1000); // Appends a random number between 0 and 999 to the name
        String randomPhone = generateRandomPhoneNumber(); // Generates a random phone number
        String randomEmail = generateRandomEmail(Email);
        // Appends a random number to the email username
 
    //    ClientPage.enterClientName(randomName);
        ClientPage.enterMobileNumber(randomAnotherName);
        ClientPage.enterEmail(randomEmail);
        ClientPage.enterAddress(randomPhone);
        Thread.sleep(4000);
        ClientPage.clickOnCreateClientButton();
        
        String actualErrorMessage = ClientPage.getErrorMessage();
        softAssert.assertEquals(actualErrorMessage, expectedErrorMessage);
 
        try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}
        
    }
    
    //Invalid Phone number
    
    @Test(dependsOnMethods = {"testcase.Login.login"} ,dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void verify_PhoneError(String Name, String Phone, String Email, String Address, String
    		expectedPhoneErrorMessage) throws InterruptedException {
        InvitingclientPage ClientPage = new InvitingclientPage(driver);
 
 ClientPage.clickOnUserButton();
        
        ClientPage.clickOnClientsOption();
 
        ClientPage.clickOnInviteClientButton();
        
        ClientPage.NavigateToDialogBox();
        
        
        String randomName = Name + (int) (Math.random() * 1000); // Appends a random number between 0 and 999 to the name
        String randomPhone = generateRandomPhoneNumber(); // Generates a random phone number
        String randomEmail = generateRandomEmail(Email); // Appends a random number to the email username
 
        ClientPage.enterClientName(randomName);
  //      ClientPage.enterMobileNumber(randomPhone);
        ClientPage.enterEmail(randomEmail);
        ClientPage.enterAddress(Address);
        
        ClientPage.clickOnCreateClientButton();
        
        String actualPhoneErrorMessage = ClientPage.getPhoneErrorMessage();
        softAssert.assertEquals(actualPhoneErrorMessage, expectedPhoneErrorMessage);
 
        try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}     
        
    }
    
    //Invalid Email
    
    @Test(dependsOnMethods = {"testcase.Login.login"} ,dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void verify_EmailError(String Name, String Phone, String Email, String Address, String
    		expectedEmailErrorMessage) throws InterruptedException {
        InvitingclientPage ClientPage = new InvitingclientPage(driver);
 
 ClientPage.clickOnUserButton();
        
        ClientPage.clickOnClientsOption();
 
        ClientPage.clickOnInviteClientButton();
        
        ClientPage.NavigateToDialogBox();
        
        
        String randomName = Name + (int) (Math.random() * 1000); // Appends a random number between 0 and 999 to the name
        String randomPhone = generateRandomPhoneNumber(); // Generates a random phone number
        String randomEmail = generateRandomEmail(Email); // Appends a random number to the email username
 
        ClientPage.enterClientName(randomName);
        ClientPage.enterMobileNumber(randomPhone);
  //      ClientPage.enterEmail(randomEmail);
        ClientPage.enterAddress(Address);
        
        ClientPage.clickOnCreateClientButton();
        
        String actualEmailErrorMessage = ClientPage.getEmailErrorMessage();
        softAssert.assertEquals(actualEmailErrorMessage, expectedEmailErrorMessage);
 
        try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}
               
    }
    
    // Invalid Enterprise
    
    @Test(dependsOnMethods = {"testcase.Login.login"} ,dataProviderClass = ReadXLData.class, dataProvider = "testData")
    public void ProjectClientInvalidEnterprise(String CompanyName, String PersonName, String Email, String MobileResponsible
    		, String expectedSuccessMessage,String ExpectedMessage) throws InterruptedException {
        InvitingclientPage ClientPage = new InvitingclientPage(driver);
        CreateProjectPage ProjectPage = new CreateProjectPage(driver);
        CreateworkorderPage WorkorderPage = new CreateworkorderPage(driver);

        ClientPage.clickOnUserButton();
	       
        ClientPage.clickOnClientsOption();

        ClientPage.clickOnInviteClientButton();
       
        ClientPage.NavigateToDialogBox();
       
       
        String randomName = CompanyName + (int) (Math.random() * 1000);
        String randomAnotherName = PersonName + (int) (Math.random() * 1000); // Appends a random number between 0 and 999 to the name
        String randomPhone = generateRandomPhoneNumber(); // Generates a random phone number
        String randomEmail = generateRandomEmail(Email);
        // Appends a random number to the email username
 
        ClientPage.enterClientName(randomName);
        ClientPage.enterMobileNumber(randomAnotherName);
        ClientPage.enterEmail(randomEmail);
        ClientPage.enterAddress(randomPhone);
        Thread.sleep(4000);
        ClientPage.clickOnCreateClientButton();
        
      //ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnProjectTabButton();
       // ProjectPage.clickOnErrorMessage();
        ProjectPage.clickOnCreateProjectButton();
   //     ProjectPage.clickOnSelfClientButton();
        ProjectPage.clickOnNext1Button();
        
        String AcceptRejectInvalidEnterprise = ProjectPage.AcceptRejectInvalidEnterprise();
        softAssert.assertEquals(AcceptRejectInvalidEnterprise, ExpectedMessage);
        try {
			softAssert.assertAll();
		} catch (AssertionError e) {
			assertionMessage.set(e.getMessage());
			throw e;
		}    
	}
                 
        
    }

