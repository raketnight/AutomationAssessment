package com.qa.Assessment;

import static org.junit.Assert.assertEquals;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {
	
	ChromeDriver driver;
	
	ExtentReports extent = new ExtentReports("C:\\Users\\Admin\\Desktop\\reports\\Assessment.html", true);
	ExtentTest test1;
	ExtentTest test2;
	ExtentTest test3;
	
	
	
	public void reportTest1(boolean createUserScreen, boolean userDetailsEntered, boolean detailsSubmitted, boolean checkUsername, boolean multipleUserDetailsEntered, boolean multipleUsernameCheck) {
		//for logging the reports
		
		if (createUserScreen) {
			test1.log(LogStatus.PASS, "In the create user screen.");
		}
		else {
			test1.log(LogStatus.FAIL, "Not in the create user screen.");
		}
		if (userDetailsEntered) {
			test1.log(LogStatus.PASS, "User details entered.");
		}
		else {
			test1.log(LogStatus.FAIL, "User details not enetered.");
		}
		if (detailsSubmitted) {
			test1.log(LogStatus.PASS, "user details submitted.");
		}
		else {
			test1.log(LogStatus.FAIL, "Details were not submitted.");
		}
		if (checkUsername) {
			test1.log(LogStatus.PASS, "user detailed checked.");
		}
		else {
			test1.log(LogStatus.FAIL, "User details was not shown.");
		}
		if (multipleUserDetailsEntered) {
			test1.log(LogStatus.PASS, "Multiple user details entered.");
		}
		else {
			test1.log(LogStatus.FAIL, "Could not enter multiple user details.");
		}
		if (multipleUsernameCheck) {
			test1.log(LogStatus.PASS, "Multiple user details checked.");
		}
		else {
			test1.log(LogStatus.FAIL, "Could not see the multiple user names.");
		}
	}
	
	public void reportTest2(boolean usernameVisible, boolean usernameClicked, boolean usernameDisplayed) {
		if (usernameVisible) {
			test2.log(LogStatus.PASS, "The username is visible");
		}
		else {
			test2.log(LogStatus.FAIL, "Not visible");
		}
		if (usernameClicked) {
			test2.log(LogStatus.PASS, "User name is clicked.");
		}
		else {
			test2.log(LogStatus.FAIL, "could not click username");
		}
		if (usernameDisplayed) {
			test2.log(LogStatus.PASS, "user details displayed");
		}
		else {
			test2.log(LogStatus.FAIL, "could not find userdetails");
		}
	}
	
	public void reportTest3(boolean userProfileLoaded, boolean configureButtonClicked, boolean newFullname, boolean configurePageSaved, boolean newFullnameShown) {
		if (userProfileLoaded) {
			test3.log(LogStatus.PASS, "In the create user screen.");
		}
		else {
			test3.log(LogStatus.FAIL, "Not in the create user screen.");
		}
		if (configureButtonClicked) {
			test3.log(LogStatus.PASS, "Configure button clicked.");
		}
		else {
			test3.log(LogStatus.FAIL, "Configure button was not clicked");
		}
		if (newFullname) {
			test3.log(LogStatus.PASS, "New full name entered.");
		}
		else {
			test3.log(LogStatus.FAIL, "Could not enter the new full name.");
		}
		if (configurePageSaved) {
			test3.log(LogStatus.PASS, "New configure was saved.");
		}
		else {
			test3.log(LogStatus.FAIL, "Could not save the new configure.");
		}
		if (newFullnameShown) {
			test3.log(LogStatus.PASS, "New fullname is shown");
		}
		else {
			test3.log(LogStatus.FAIL, "Could not see the new full name");
		}
		
	}
	
	
	
	@Before
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver", Constants.chromeDriverLocation);
		
/*		ExcelUtils.setExcelFile(Constants.fileTestData, 0);  //did not get exell to work
		ExcelUtils.setCellData("Userame", 1, 1);
		ExcelUtils.setCellData("Password1", 2, 1);
		ExcelUtils.setCellData("Password2", 3, 1);
		ExcelUtils.setCellData("Email", 4, 1);
		ExcelUtils.setCellData("Test Result", 5, 1);*/
		
		driver = new ChromeDriver();    //new chrome
		driver.get(Constants.assessmentWebsite); //get the assesment website
		
		test1 = extent.startTest("Atomated creation of users");
		test2 = extent.startTest("View a user on the database");
		test3 = extent.startTest("Update the FullName of the selected users");
	}
	
	@After
	public void teardown() {
		driver.quit();
		reportTest1(Constants.createUserScreen, Constants.userDetailsEntered, Constants.detailsSubmitted, Constants.checkUsername, Constants.multipleUserDetailsEntered, Constants.multipleUsernameCheck);
		reportTest2(Constants.usernameVisible, Constants.usernameClicked ,  Constants.usernameDisplayed  );
		reportTest3(Constants.userProfileLoaded, Constants.configureButtonClicked, Constants.newFullname, Constants.configurePageSaved, Constants.newFullnameShown);
		extent.flush();
	} 
	
	@Given("^that you are on the create UserScreen$")
	public void that_you_are_on_the_create_UserScreen() throws Throwable {
		
		LogInPage loginPage = PageFactory.initElements(driver, LogInPage.class);  //initialise the pages because
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		ManageJenkinsPage managejenkins = PageFactory.initElements(driver, ManageJenkinsPage.class);
		ManageUsersPage manageUsers = PageFactory.initElements(driver, ManageUsersPage.class);
		
		loginPage.signIn();
	    homePage.clickManageJenkins();
	    managejenkins.clickManageUsers();
	    manageUsers.clickCreateUser();
	    
	    if (Constants.createUserUrl.equals(driver.getCurrentUrl())) {
	    	Constants.createUserScreen = true;
	    }
	}

	@When("^the User details are entered on the Create UserScreen$")
	public void the_User_details_are_entered_on_the_Create_UserScreen() throws Throwable {
		
	    CreateUserPage createUserPage = PageFactory.initElements(driver, CreateUserPage.class);
	    
	    createUserPage.typeUsername(Constants.test1username);
	    createUserPage.typePasswword1(Constants.test1password);
	    createUserPage.typePasswword2(Constants.test1password);
	    createUserPage.typeFullname(Constants.test1fullname);
	    createUserPage.typeEmail(Constants.test1email);
	    
	    Constants.userDetailsEntered = true;
	    
	}

	@When("^the details are submitted on the Create UserScreen$")
	public void the_details_are_submitted_on_the_Create_UserScreen() throws Throwable {
		
		CreateUserPage createUserPage = PageFactory.initElements(driver, CreateUserPage.class);
		
		createUserPage.clickSubmit();
		
		Constants.detailsSubmitted = true;
		
	}

	@Then("^the Username should be visible on the UsersScreen$")
	public void the_Username_should_be_visible_on_the_UsersScreen() throws Throwable {
		
		UsersPage userPage = PageFactory.initElements(driver, UsersPage.class);
		
		userPage.checkUser(driver, Constants.test1username);
		
		Constants.checkUsername = true;
	
	}

	@When("^the User details \"([^\"]*)\" username, \"([^\"]*)\" password, \"([^\"]*)\" confirm Password, and \"([^\"]*)\" Fullname are entered on the Create UserScreen$")
	public void the_User_details_username_password_confirm_Password_and_Fullname_are_entered_on_the_Create_UserScreen(String arg1, String arg2, String arg3, String arg4) throws Throwable {
		
		CreateUserPage createUserPage = PageFactory.initElements(driver, CreateUserPage.class);	    
	    
		createUserPage.typeUsername(arg1);
	    createUserPage.typePasswword1(arg2);
	    createUserPage.typePasswword2(arg3);
	    createUserPage.typeFullname(arg4);
	    createUserPage.typeEmail(Constants.test1email);
	    
	}

	@Then("^the \"([^\"]*)\" username should be visible on the UsersScreen$")
	public void the_username_should_be_visible_on_the_UsersScreen(String arg1) throws Throwable {
		Constants.multipleUserDetailsEntered = true;
		
		UsersPage userPage = PageFactory.initElements(driver, UsersPage.class);
		
		userPage.checkUser(driver, arg1);
		
		Constants.multipleUsernameCheck = true;
		
	}

	@Given("^the \"([^\"]*)\" username is visible on the UsersScreen$")
	public void the_username_is_visible_on_the_UsersScreen(String arg1) throws Throwable {
		
		LogInPage loginPage = PageFactory.initElements(driver, LogInPage.class);
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		ManageJenkinsPage managejenkins = PageFactory.initElements(driver, ManageJenkinsPage.class);
		UsersPage userPage = PageFactory.initElements(driver, UsersPage.class);
		
		loginPage.signIn();
		homePage.clickManageJenkins();
	    managejenkins.clickManageUsers();
	    userPage.checkUser(driver, arg1);
	    
	    Constants.usernameVisible = true;
	    
	}

	@When("^the \"([^\"]*)\" username is clicked on the UserScreen$")
	public void the_username_is_clicked_on_the_UserScreen(String arg1) throws Throwable {
		
		System.out.println(driver.getCurrentUrl());
		
	    UsersPage userPage = PageFactory.initElements(driver, UsersPage.class);
	    
	    userPage.clickUser(driver, arg1);
	    
	    Constants.usernameClicked = true;
	    
	}

	@Then("^the User Profile should display the \"([^\"]*)\" username on the ProfileScreen$")
	public void the_User_Profile_should_display_the_username_on_the_ProfileScreen(String arg1) throws Throwable {
		
	    ProfilePage profilePage = PageFactory.initElements(driver, ProfilePage.class);
	    
	    profilePage.checkUser(driver, arg1);
	    
	    Constants.usernameDisplayed = true;
	    
	}

	@Given("^the \"([^\"]*)\" Username's profile page has been loaded$")
	public void the_Username_s_profile_page_has_been_loaded(String arg1) throws Throwable {
		
		LogInPage loginPage = PageFactory.initElements(driver, LogInPage.class);
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		ManageJenkinsPage managejenkins = PageFactory.initElements(driver, ManageJenkinsPage.class);
		UsersPage userPage = PageFactory.initElements(driver, UsersPage.class);
		
		loginPage.signIn();
		homePage.clickManageJenkins();
	    managejenkins.clickManageUsers();
	    userPage.clickUser(driver, arg1);
	    
	    Constants.userProfileLoaded = true;
	}

	@Given("^the configure button has been clicked on the profile page$")
	public void the_configure_button_has_been_clicked_on_the_profile_page() throws Throwable {
	    
		ProfilePage profilePage = PageFactory.initElements(driver, ProfilePage.class);
		
		profilePage.clickConfigure();
		
		Constants.configureButtonClicked = true;
		
		
	}

	@When("^I change the old FullName on the Configure Page to a new FullName \"([^\"]*)\"$")
	public void i_change_the_old_FullName_on_the_Configure_Page_to_a_new_FullName(String arg1) throws Throwable {
	    
		ConfigurePage configPage = PageFactory.initElements(driver, ConfigurePage.class);
		
		configPage.sendFullName(arg1);
		
		Constants.newFullname = true;
	}

	@When("^I save the changes to the Configure Page$")
	public void i_save_the_changes_to_the_Configure_Page() throws Throwable {
		
		ConfigurePage configPage = PageFactory.initElements(driver, ConfigurePage.class);
		
		configPage.save();
		
		Constants.configurePageSaved = true;
	}

	@Then("^the Configure Page should show the NewFullName \"([^\"]*)\"$")
	public void the_Configure_Page_should_show_the_NewFullName(String arg1) throws Throwable {
		
		ConfigurePage configPage = PageFactory.initElements(driver, ConfigurePage.class);
		
		configPage.checkFullname(arg1);
		
		Constants.newFullnameShown = true;
	}


}
