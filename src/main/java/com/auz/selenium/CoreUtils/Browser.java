package com.auz.selenium.CoreUtils;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public interface Browser {
	
	
	//public RemoteWebDriver startApp(String url);
	
	
	public RemoteWebDriver startApp(String browser,boolean bRemote);
	
	public WebElement locateElement(String locatorType, String value);	
	
	public WebElement locateElement(String value);
	
	public List<WebElement> locateElements(String type, String value);	
	
	public void switchToAlert();
	
	public void acceptAlert();
	
	public void dismissAlert();
	
	public String getAlertText();

	public void typeAlert(String data);
	
	public void switchToWindow(int index);
	
	public void switchToWindow(String title);
	
	public void switchToFrame(int index);	
	
	public void switchToFrame(WebElement ele);

	public void switchToFrame(String idOrName);
	
	public void defaultContent();
	
	public boolean verifyUrl(String url);
	
	public boolean verifyTitle(String title);
	
	public void close();
	
	public void quit();

	
	
	
	

	
}
