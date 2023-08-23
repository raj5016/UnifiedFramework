package com.auz.selenium.CoreUtils;

import org.openqa.selenium.WebElement;


public interface Element {

	public void click(WebElement ele);
	
	public void append(WebElement ele, String data);
	
	public void clear(WebElement ele);
	
	public void clearAndType(WebElement ele,String data);
	
	public String getElementText(WebElement ele);	
	
	public String getBackgroundColor(WebElement ele);
	
	public String getTypedText(WebElement ele);
	
	public void selectDropDownUsingText(WebElement ele, String value) ;
	
	public void selectDropDownUsingIndex(WebElement ele, int index) ;
	
	public void selectDropDownUsingValue(WebElement ele, String value) ;
	
	public boolean verifyExactText(WebElement ele, String expectedText);
	
	public boolean verifyPartialText(WebElement ele, String expectedText);

	public boolean verifyExactAttribute(WebElement ele, String attribute, String value);
	
	public void verifyPartialAttribute(WebElement ele, String attribute, String value);
	
	public boolean verifyDisplayed(WebElement ele);
	
	public boolean verifyDisappeared(WebElement ele);	
	
	public boolean verifyEnabled(WebElement ele);	
	
	public void verifySelected(WebElement ele);

	public void clearAndTypeWithTagName(WebElement ele, String data, String tagName);

	public void click(WebElement ele, String Field);




	
}




