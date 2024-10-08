package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseTest;

public class ManageAttendance extends BaseTest {
	
	WebElement btn_Workorder;
	WebElement btn_More;
	WebElement click_ViewJobSeekerSchedules;
	WebElement btn_ViewTasks;
	WebElement click_Openmenutoexplore;
	WebElement click_Active;
	WebElement actual_message;

	
	
	
	
	public ManageAttendance(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickOnbtn_Workorder() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_Workorder")))).click();
	}
	
	public void clickOnbtn_More() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_More")))).click();
	}
	
	public void clickOn_ViewJobSeekerSchedules() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("click_ViewJobSeekerSchedules")))).click();
	}
	
	public void clickOnbtn_ViewTasks() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("btn_ViewTasks")))).click();
	}
	
	public void clickOn_Openmenutoexplore() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("click_Openmenutoexplore")))).click();
	}
	
	public void clickOn_Active() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("click_Active")))).click();
	}
	
	public String get_Actualmessage() {
		   return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loc.getProperty("actual_message")))).getText();
	 }
	
}