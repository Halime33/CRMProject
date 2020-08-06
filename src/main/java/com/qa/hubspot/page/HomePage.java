package com.qa.hubspot.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.AppConstants;
import com.qa.hubspot.util.ElementUtil;

public class HomePage extends BasePage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	By header = By.xpath("//h1[@class='private-header__heading private-header__heading--solo']");
	By accountName = By.xpath("//a [@id='navAccount-current']");
	By arrow = By.xpath("//*[@id='account-menu']");
	
	By mainContactsLink = By.id("nav-primary-contacts-branch");
	By childContactsLink = By.id("nav-secondary-contacts");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	public String getHomePageTitle() {
		elementUtil.waitForTitlePresent(AppConstants.HOME_PAGE_TITLE);
		return elementUtil.doGetPageTitle()	;
	}
    
	public String getHomePageHeader() {
		return elementUtil.doGetText(header);	
	}
	
	public void doclickarrow() {
	elementUtil.waitForElementPresent(arrow);	
	elementUtil.doClick(arrow);	
	}
	
	public String getLoggedInUserAccountName() {
		elementUtil.waitForElementPresent(accountName);
		return elementUtil.doGetText(accountName);
	}
	 public  void clicOnContacts() {
		 elementUtil.waitForElementPresent(mainContactsLink);
		 elementUtil.doClick(mainContactsLink);
		 elementUtil.waitForElementPresent(childContactsLink);
		 elementUtil.doClick(childContactsLink);
	 }
	 
	 public ContactsPage goToContactsPage() {
		 clicOnContacts();
		 return new ContactsPage(driver);
	 }
	 

}





