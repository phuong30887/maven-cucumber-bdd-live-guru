package commons;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import userPageObjects.ProductListingPageObject;
import userPageObjects.UserHomepageObject;
import userPageObjects.UserPageGenaratorManager;

public class AbstractPage {

    private WebElement element;
    private JavascriptExecutor jsExecutor;
    private List<WebElement> allItems;
    private WebDriverWait explicitWait;
    private Select select;
    private Actions actions;

    // ================= A. SELENIUM WEB BROWSER =================

    public void openPageURL(WebDriver driver, String URL) {
	driver.get(URL);
    }

    public String getCurrentPageURL(WebDriver driver) {
	return driver.getCurrentUrl();
    }

    public String getCurrentPageTitle(WebDriver driver) {
	return driver.getTitle();
    }

    public String getCurrentPageSource(WebDriver driver) {
	return driver.getPageSource();
    }

    public void backToPreviousPage(WebDriver driver) {
	driver.navigate().back();
    }

    public void forwardToNextPage(WebDriver driver) {
	driver.navigate().forward();
    }

    public void refreshCurrentPage(WebDriver driver) {
	driver.navigate().refresh();
    }

    // ============== ALERT ===============
    public void acceptAlert(WebDriver driver) {
	driver.switchTo().alert().accept();
    }

    public void cancelAlert(WebDriver driver) {
	driver.switchTo().alert().dismiss();
    }

    public String getAlertText(WebDriver driver) {
	return driver.switchTo().alert().getText();
    }

    public void sendKeyToAlert(WebDriver driver, String keyValue) {
	driver.switchTo().alert().sendKeys(keyValue);
    }

    public void waitAlertPresence(WebDriver driver) {
	WebDriverWait explicitWait = new WebDriverWait(driver, 30);
	explicitWait.until(ExpectedConditions.alertIsPresent());
    }

    // ============== WINDOW ===============

    public String getCurrentWindowID(WebDriver driver) {
	return driver.getWindowHandle();
    }

    public void switchToWindowByID(WebDriver driver, String parentID) {
	Set<String> allWindows = driver.getWindowHandles();
	for (String runWindow : allWindows) {
	    if (!runWindow.equals(parentID)) {
		driver.switchTo().window(runWindow);
		break;
	    }
	}
    }

    public void switchToWindowByTitle(WebDriver driver, String title) {
	Set<String> allWindows = driver.getWindowHandles();
	for (String runWindows : allWindows) {
	    driver.switchTo().window(runWindows);
	    String currentPageTitle = driver.getTitle();
	    if (currentPageTitle.equals(title)) {
		break;
	    }
	}
    }

    public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
	Set<String> allWindows = driver.getWindowHandles();
	for (String runWindows : allWindows) {
	    if (!runWindows.equals(parentID)) {
		driver.switchTo().window(runWindows);
		driver.close();
	    }
	}
	driver.switchTo().window(parentID);
    }

    // ================= B. SELENIUM WEB ELEMENT =================

    public WebElement getElement(WebDriver driver, String locator) {
	return driver.findElement(getByXpath(locator));
    }

    public List<WebElement> getElements(WebDriver driver, String locator) {
	return driver.findElements(getByXpath(locator));
    }

    public By getByXpath(String locator) {
	return By.xpath(locator);
    }

    public String getDynamicLocator(String locator, String... values) {
	locator = String.format(locator, (Object[]) values);
	return locator;
    }

    public void clickToElement(WebDriver driver, String locator) {
	element = getElement(driver, locator);
	element.click();
    }

    public void clickToElement(WebDriver driver, String locator, String... values) {
	element = getElement(driver, getDynamicLocator(locator, values));
	element.click();
    }

    public void sendkeyToElement(WebDriver driver, String locator, String keyValue) {
	element = driver.findElement(By.xpath(locator));
	element.clear();
	element.sendKeys(keyValue);
    }

    public void sendkeyToElement(WebDriver driver, String keyValue, String locator, String... values) {
	element = driver.findElement(By.xpath(getDynamicLocator(locator, values)));
	element.clear();
	element.sendKeys(keyValue);
    }

    public void selectItemInDropdown(WebDriver driver, String locator, String itemValue) {
	element = getElement(driver, locator);
	select = new Select(element);
	select.selectByVisibleText(itemValue);
    }

    public String getFirstSelectedTextInDropdown(WebDriver driver, String locator) {
	element = getElement(driver, locator);
	select = new Select(element);
	return select.getFirstSelectedOption().getText();
    }

    public boolean isDropdownMultiple(WebDriver driver, String locator) {
	element = getElement(driver, locator);
	select = new Select(element);
	return select.isMultiple();
    }

    public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator,
	    String expectedItem) {
	element = getElement(driver, parentLocator);
	element.click();
	sleepInSecond(1);

	explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
	explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childItemLocator)));

	allItems = getElements(driver, childItemLocator);

	for (WebElement item : allItems) {
	    if (item.getText().trim().equals(expectedItem)) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
		sleepInSecond(1);

		item.click();
		sleepInSecond(1);
		break;
	    }
	}
    }

    public String getElementAttribute(WebDriver driver, String locator, String attributeName) {
	element = getElement(driver, locator);
	return element.getAttribute(attributeName);
    }

    public String getElementText(WebDriver driver, String locator) {
	element = getElement(driver, locator);
	return element.getText();
    }

    public String getElementText(WebDriver driver, String locator, String... values) {
	element = getElement(driver, getDynamicLocator(locator, values));
	return element.getText();
    }
    
    public int getElementSize(WebDriver driver, String locator) {
	allItems = getElements(driver, locator);
	return allItems.size();
    }

    public int getElementSize(WebDriver driver, String locator, String... values) {
	allItems = getElements(driver, getDynamicLocator(locator, values));
	return allItems.size();
    }

    public void checkToCheckbox(WebDriver driver, String locator) {
	element = getElement(driver, locator);
	if (!element.isSelected()) {
	    element.click();
	}
    }

    public void uncheckToCheckbox(WebDriver driver, String locator) {
	element = getElement(driver, locator);
	if (element.isSelected()) {
	    element.click();
	}
    }

    public boolean isElementDisplayed(WebDriver driver, String locator) {
	try {
	    return getElement(driver, locator).isDisplayed();

	} catch (Exception e) {
	    return false;
	}
    }

    public boolean isElementDisplayed(WebDriver driver, String locator, String... values) {
	try {
	    return getElement(driver, getDynamicLocator(locator, values)).isDisplayed();

	} catch (Exception e) {
	    return false;
	}
    }

    public boolean isElementUndisplayed(WebDriver driver, String locator) {
	overideImplicitWait(driver, GlobalConstants.SHORT_TIMEOUT);
	allItems = getElements(driver, locator);
	overideImplicitWait(driver, GlobalConstants.LONG_TIMEOUT);

	if (allItems.size() == 0) {
	    // System.out.println("Element not in DOM + not in UI");
	    return true;
	} else if (allItems.size() > 0 && !allItems.get(0).isDisplayed()) {
	    // System.out.println("Element not in DOM + in UI");
	    return true;
	} else {
	    // System.out.println("Element in DOM and visible");
	    return false;
	}
    }

    public boolean isElementUndisplayed(WebDriver driver, String locator, String... values) {
	overideImplicitWait(driver, GlobalConstants.SHORT_TIMEOUT);
	allItems = getElements(driver, getDynamicLocator(locator, values));
	overideImplicitWait(driver, GlobalConstants.LONG_TIMEOUT);

	if (allItems.size() == 0) {
	    // System.out.println("Element not in DOM + not in UI");
	    return true;
	} else if (allItems.size() > 0 && !allItems.get(0).isDisplayed()) {
	    // System.out.println("Element not in DOM + in UI");
	    return true;
	} else {
	    // System.out.println("Element in DOM and visible");
	    return false;
	}
    }

    public void overideImplicitWait(WebDriver driver, long timeInSecond) {
	driver.manage().timeouts().implicitlyWait(timeInSecond, TimeUnit.SECONDS);
    }

    public boolean isElementEnable(WebDriver driver, String locator) {
	return getElement(driver, locator).isEnabled();
    }

    public boolean isElementSelected(WebDriver driver, String locator) {
	return getElement(driver, locator).isSelected();
    }

    public void switchToFrame(WebDriver driver, String locator) {
	element = getElement(driver, locator);
	driver.switchTo().frame(getElement(driver, locator));
    }

    public void switchToDefaultContent(WebDriver driver) {
	driver.switchTo().defaultContent();
    }

    // ============== USER ACTIONS ===============
    public void doubleClickToElement(WebDriver driver, String locator) {
	actions = new Actions(driver);
	actions.doubleClick(getElement(driver, locator)).perform();
    }

    public void rightClickToElement(WebDriver driver, String locator) {
	actions = new Actions(driver);
	actions.contextClick(getElement(driver, locator)).perform();
    }

    public void hoverMouseToElement(WebDriver driver, String locator) {
	actions = new Actions(driver);
	actions.moveToElement(getElement(driver, locator)).perform();
    }

    public void clickAndHoldToElement(WebDriver driver, String locator) {
	actions = new Actions(driver);
	actions.clickAndHold(getElement(driver, locator)).perform();
    }

    public void dragAndDropToElement(WebDriver driver, String sourceLocator, String targetLocator) {
	actions = new Actions(driver);
	actions.dragAndDrop(getElement(driver, sourceLocator), getElement(driver, targetLocator)).perform();
    }

    public void sendKeyBoardToElement(WebDriver driver, String locator, Keys keyValue) {
	actions = new Actions(driver);
	actions.sendKeys(getElement(driver, locator), keyValue).perform();
    }

    // ====================== JAVASCRIPT EXECUTOR ================

    public Object executeForBrowser(WebDriver driver, String javaScript) {
	jsExecutor = (JavascriptExecutor) driver;
	return jsExecutor.executeScript(javaScript);
    }

    public String getInnerText(WebDriver driver) {
	jsExecutor = (JavascriptExecutor) driver;
	return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
    }

    public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
	jsExecutor = (JavascriptExecutor) driver;
	String textActual = (String) jsExecutor
		.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
	return textActual.equals(textExpected);
    }

    public void scrollToBottomPage(WebDriver driver) {
	jsExecutor = (JavascriptExecutor) driver;
	jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void navigateToUrlByJS(WebDriver driver, String url) {
	jsExecutor = (JavascriptExecutor) driver;
	jsExecutor.executeScript("window.location = '" + url + "'");
    }

    public void highlightElement(WebDriver driver, String locator) {
	jsExecutor = (JavascriptExecutor) driver;
	element = getElement(driver, locator);
	String originalStyle = element.getAttribute("style");
	jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
		"border: 2px solid red; border-style: dashed;");
	sleepInSecond(1);
	jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
		originalStyle);
    }

    public void clickToElementByJS(WebDriver driver, String locator) {
	jsExecutor = (JavascriptExecutor) driver;
	jsExecutor.executeScript("arguments[0].click();", getElement(driver, locator));
    }

    public void clickToElementByJS(WebDriver driver, String locator, String... values) {
	jsExecutor = (JavascriptExecutor) driver;
	jsExecutor.executeScript("arguments[0].click();", getElement(driver, getDynamicLocator(locator, values)));
    }

    public void scrollToElement(WebDriver driver, String locator) {
	jsExecutor = (JavascriptExecutor) driver;
	jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
    }

    public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
	jsExecutor = (JavascriptExecutor) driver;
	jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(driver, locator));
    }

    public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
	jsExecutor = (JavascriptExecutor) driver;
	jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",
		getElement(driver, locator));
    }

    public boolean waitToJQueryAndJSLoadedSuccess(WebDriver driver) {
	explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
	jsExecutor = (JavascriptExecutor) driver;

	ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
	    @Override
	    public Boolean apply(WebDriver driver) {
		try {
		    return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
		} catch (Exception e) {
		    return true;
		}
	    }
	};

	ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
	    @Override
	    public Boolean apply(WebDriver driver) {
		return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
	    }
	};

	return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
    }

    public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
	explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
	jsExecutor = (JavascriptExecutor) driver;

	ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
	    @Override
	    public Boolean apply(WebDriver driver) {
		try {
		    return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
		} catch (Exception e) {
		    return true;
		}
	    }
	};

	ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
	    @Override
	    public Boolean apply(WebDriver driver) {
		return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
	    }
	};

	return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
    }

    public String getElementValidationMessage(WebDriver driver, String locator) {
	jsExecutor = (JavascriptExecutor) driver;
	return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(driver, locator));
    }

    public boolean isImageLoaded(WebDriver driver, String locator) {
	jsExecutor = (JavascriptExecutor) driver;
	boolean status = (boolean) jsExecutor.executeScript(
		"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
		getElement(driver, locator));
	if (status) {
	    return true;
	} else {
	    return false;
	}
    }

    // ====================== WAIT ================

    public void waitToElementVisible(WebDriver driver, String locator) {
	explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
	explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
    }

    public void waitToElementVisible(WebDriver driver, String locator, String... values) {
	explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
	explicitWait
		.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(getDynamicLocator(locator, values))));
    }

    public void waitToAllElementVisible(WebDriver driver, String locator) {
	explicitWait = new WebDriverWait(driver, GlobalConstants.SHORT_TIMEOUT);
	explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(locator)));
    }

    public void waitToAllElementVisible(WebDriver driver, String locator, String... values) {
	explicitWait = new WebDriverWait(driver, GlobalConstants.SHORT_TIMEOUT);
	explicitWait.until(
		ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(getDynamicLocator(locator, values))));
    }

    public void waitToElementInvisible(WebDriver driver, String locator) {
	explicitWait = new WebDriverWait(driver, GlobalConstants.SHORT_TIMEOUT);
	explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
    }

    public void waitToElementInvisible(WebDriver driver, String locator, String... values) {
	explicitWait = new WebDriverWait(driver, GlobalConstants.SHORT_TIMEOUT);
	explicitWait
		.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(getDynamicLocator(locator, values))));
    }

    public void waitToElementClickable(WebDriver driver, String locator) {
	explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
	explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
    }

    public void waitToElementClickable(WebDriver driver, String locator, String... values) {
	explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
	explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(getDynamicLocator(locator, values))));
    }

    // ====================== SHORTING ==================
    public boolean isDataSortedAscending(WebDriver driver, String locator) {
	// khai bao 1 array list
	ArrayList<String> arrayList = new ArrayList<>();

	// tim tat ca element matching vs dieu kien name, price...
	List<WebElement> elementList = driver.findElements(By.xpath(locator));

	// lay text cua tung element add vao array list
	for (WebElement element : elementList) {
	    arrayList.add(element.getText());
	}

	System.out.println("--------------- Du lieu tren UI : ---------------");
	for (String name : arrayList) {
	    System.out.println(name);
	}

	// copy qua 1 array list moi de SORT trong code
	ArrayList<String> sortedList = new ArrayList<>();
	for (String child : arrayList) {
	    sortedList.add(child);
	}

	// thuc hien SORT ASC
	Collections.sort(sortedList);

	System.out.println("-------------- du lieu da SORT ASC trong code: ---------------");
	for (String name : sortedList) {
	    System.out.println(name);
	}

	// verify 2 array bang nhau - neu du lieu sort tren UI ko chinh xac thif ket qua
	// tra ve sai
	return sortedList.equals(arrayList);
    }

    public boolean isDataSortedAscending(WebDriver driver, String locator, String... values) {
	// khai bao 1 array list
	ArrayList<String> arrayList = new ArrayList<>();

	// tim tat ca element matching vs dieu kien name, price...
	List<WebElement> elementList = driver.findElements(By.xpath(getDynamicLocator(locator, values)));

	// lay text cua tung element add vao array list
	for (WebElement element : elementList) {
	    arrayList.add(element.getText());
	}

	System.out.println("--------------- Du lieu tren UI : ---------------");
	for (String name : arrayList) {
	    System.out.println(name);
	}

	// copy qua 1 array list moi de SORT trong code
	ArrayList<String> sortedList = new ArrayList<>();
	for (String child : arrayList) {
	    sortedList.add(child);
	}

	// thuc hien SORT ASC
	Collections.sort(sortedList);

	System.out.println("-------------- du lieu da SORT ASC trong code: ---------------");
	for (String name : sortedList) {
	    System.out.println(name);
	}

	// verify 2 array bang nhau - neu du lieu sort tren UI ko chinh xac thif ket qua
	// tra ve sai
	return sortedList.equals(arrayList);
    }

    public boolean isDataSortedDescending(WebDriver driver, String locator) {
	// khai bao 1 array list
	ArrayList<String> arrayList = new ArrayList<>();

	// tim tat ca element matching vs dieu kien name, price...
	List<WebElement> elementList = driver.findElements(By.xpath(locator));

	// lay text cua tung element add vao array list
	for (WebElement element : elementList) {
	    arrayList.add(element.getText());
	}

	System.out.println("--------------- Du lieu tren UI : ---------------");
	for (String name : arrayList) {
	    System.out.println(name);
	}

	// copy qua 1 array list moi de SORT trong code
	ArrayList<String> sortedList = new ArrayList<>();
	for (String child : arrayList) {
	    sortedList.add(child);
	}

	// thuc hien SORT ASC
	Collections.sort(sortedList);

	System.out.println("-------------- du lieu da SORT ASC trong code: ---------------");
	for (String name : sortedList) {
	    System.out.println(name);
	}

	// Reverse data de SORT DESC (dung 1 trong 2 cach ben duoi)
	Collections.reverse(sortedList);
	// Collections.sort(arrayList, Collections.reverseOrder());

	System.out.println("-------------- du lieu da SORT DESC trong code: ---------------");
	for (String name : sortedList) {
	    System.out.println(name);
	}

	// verify 2 array bang nhau - neu du lieu sort tren UI ko chinh xac thif ket qua
	// tra ve sai
	return sortedList.equals(arrayList);
    }

    public boolean isDataSortedDescending(WebDriver driver, String locator, String... values) {
	// khai bao 1 array list
	ArrayList<String> arrayList = new ArrayList<>();

	// tim tat ca element matching vs dieu kien name, price...
	List<WebElement> elementList = driver.findElements(By.xpath(getDynamicLocator(locator, values)));

	// lay text cua tung element add vao array list
	for (WebElement element : elementList) {
	    arrayList.add(element.getText());
	}

	System.out.println("--------------- Du lieu tren UI : ---------------");
	for (String name : arrayList) {
	    System.out.println(name);
	}

	// copy qua 1 array list moi de SORT trong code
	ArrayList<String> sortedList = new ArrayList<>();
	for (String child : arrayList) {
	    sortedList.add(child);
	}

	// thuc hien SORT ASC
	Collections.sort(sortedList);

	System.out.println("-------------- du lieu da SORT ASC trong code: ---------------");
	for (String name : sortedList) {
	    System.out.println(name);
	}

	// Reverse data de SORT DESC (dung 1 trong 2 cach ben duoi)
	Collections.reverse(sortedList);
	// Collections.sort(arrayList, Collections.reverseOrder());

	System.out.println("-------------- du lieu da SORT DESC trong code: ---------------");
	for (String name : sortedList) {
	    System.out.println(name);
	}

	// verify 2 array bang nhau - neu du lieu sort tren UI ko chinh xac thif ket qua
	// tra ve sai
	return sortedList.equals(arrayList);
    }

    public boolean isDataFloatSortedAscending(WebDriver driver, String locator) {
	// khai bao 1 array
	ArrayList<Float> arrayList = new ArrayList<Float>();

	// tìm tât cả element matching vs điều kiện ( nam, price ..)
	List<WebElement> elementList = driver.findElements(By.xpath(locator));

	// lay text cua tung element add vao array list
	for (WebElement element : elementList) {
	    arrayList.add(Float.parseFloat(element.getText().replace("$", "").replace(",", "").trim()));
	}

	System.out.println("------------ du lieu tren UI: ------------- ");
	for (Float name : arrayList) {
	    System.out.println(name);
	}

	// copy qua 1 array moi de SORT trong code
	ArrayList<Float> sortedList = new ArrayList<Float>();

	for (Float child : arrayList) {
	    sortedList.add(child);
	}

	// thuc hien SORT ASC
	Collections.sort(sortedList);
	System.out.println("------------ du lieu tren UI: ------------- ");
	for (Float name : sortedList) {
	    System.out.println(name);
	}

	return sortedList.equals(arrayList);

    }

    public boolean isDataFloatSortedAscending(WebDriver driver, String locator, String... values) {
	// khai bao 1 array
	ArrayList<Float> arrayList = new ArrayList<Float>();

	// tìm tât cả element matching vs điều kiện ( nam, price ..)
	List<WebElement> elementList = driver.findElements(By.xpath(getDynamicLocator(locator, values)));

	// lay text cua tung element add vao array list
	for (WebElement element : elementList) {
	    arrayList.add(Float.parseFloat(element.getText().replace("$", "").replace(",", "").trim()));
	}

	System.out.println("------------ du lieu tren UI: ------------- ");
	for (Float name : arrayList) {
	    System.out.println(name);
	}

	// copy qua 1 array moi de SORT trong code
	ArrayList<Float> sortedList = new ArrayList<Float>();

	for (Float child : arrayList) {
	    sortedList.add(child);
	}

	// thuc hien SORT ASC
	Collections.sort(sortedList);
	System.out.println("------------ du lieu tren UI: ------------- ");
	for (Float name : sortedList) {
	    System.out.println(name);
	}

	return sortedList.equals(arrayList);

    }

    public boolean isDataFloatSortedDescending(WebDriver driver, String locator) {
	// khai bao 1 array
	ArrayList<Float> arrayList = new ArrayList<Float>();

	// tìm tât cả element matching vs điều kiện ( nam, price ..)
	List<WebElement> elementList = driver.findElements(By.xpath(locator));

	// lay text cua tung element add vao array list
	for (WebElement element : elementList) {
	    arrayList.add(Float.parseFloat(element.getText().replace("$", "").replace(",", "").trim()));
	}

	System.out.println("------------ du lieu tren UI: ------------- ");
	for (Float name : arrayList) {
	    System.out.println(name);
	}

	// copy qua 1 array moi de SORT trong code
	ArrayList<Float> sortedList = new ArrayList<Float>();

	for (Float child : arrayList) {
	    sortedList.add(child);
	}

	// thuc hien SORT ASC
	Collections.sort(sortedList);
	System.out.println("------------ du lieu SORT ASC: ------------- ");
	for (Float name : sortedList) {
	    System.out.println(name);
	}

	// thuc hien SORT DES
	Collections.reverse(sortedList);
	System.out.println("------------ du lieu SORT DES: ------------- ");
	for (Float name : sortedList) {
	    System.out.println(name);
	}

	return sortedList.equals(arrayList);

    }

    public boolean isDataFloatSortedDescending(WebDriver driver, String locator, String... values) {
	// khai bao 1 array
	ArrayList<Float> arrayList = new ArrayList<Float>();

	// tìm tât cả element matching vs điều kiện ( nam, price ..)
	List<WebElement> elementList = driver.findElements(By.xpath(getDynamicLocator(locator, values)));

	// lay text cua tung element add vao array list
	for (WebElement element : elementList) {
	    arrayList.add(Float.parseFloat(element.getText().replace("$", "").replace(",", "").trim()));
	}

	System.out.println("------------ du lieu tren UI: ------------- ");
	for (Float name : arrayList) {
	    System.out.println(name);
	}

	// copy qua 1 array moi de SORT trong code
	ArrayList<Float> sortedList = new ArrayList<Float>();

	for (Float child : arrayList) {
	    sortedList.add(child);
	}

	// thuc hien SORT ASC
	Collections.sort(sortedList);
	System.out.println("------------ du lieu SORT ASC: ------------- ");
	for (Float name : sortedList) {
	    System.out.println(name);
	}

	// thuc hien SORT DES
	Collections.reverse(sortedList);
	System.out.println("------------ du lieu SORT DES: ------------- ");
	for (Float name : sortedList) {
	    System.out.println(name);
	}

	return sortedList.equals(arrayList);

    }

    public boolean isDataDateSortedAscending(WebDriver driver, String locator) {
	ArrayList<Date> arrayList = new ArrayList<Date>();

	List<WebElement> elementList = driver.findElements(By.xpath(locator));

	for (WebElement element : elementList) {
	    arrayList.add(convertStringToDate(element.getText()));
	}

	System.out.println("------------ du lieu tren UI: -------------- ");
	for (Date name : arrayList) {
	    System.out.println(name);
	}

	ArrayList<Date> sortedList = new ArrayList<Date>();
	for (Date child : arrayList) {
	    sortedList.add(child);
	}

	Collections.sort(sortedList);

	System.out.println("------------ du lieu da SORT ASC trong code: -------------- ");
	for (Date name : sortedList) {
	    System.out.println(name);
	}

	return sortedList.equals(arrayList);
    }


    public boolean isDataDateSortedAscending(WebDriver driver, String locator, String... values) {
	ArrayList<Date> arrayList = new ArrayList<Date>();

	List<WebElement> elementList = driver.findElements(By.xpath(getDynamicLocator(locator, values)));

	for (WebElement element : elementList) {
	    arrayList.add(convertStringToDate(element.getText()));
	}

	System.out.println("------------ du lieu tren UI: -------------- ");
	for (Date name : arrayList) {
	    System.out.println(name);
	}

	ArrayList<Date> sortedList = new ArrayList<Date>();
	for (Date child : arrayList) {
	    sortedList.add(child);
	}

	Collections.sort(sortedList);

	System.out.println("------------ du lieu da SORT ASC trong code: -------------- ");
	for (Date name : sortedList) {
	    System.out.println(name);
	}

	return sortedList.equals(arrayList);
    }
    
    public boolean isDataDateSortedDescending(WebDriver driver, String locator) {
	ArrayList<Date> arrayList = new ArrayList<Date>();

	List<WebElement> elementList = driver.findElements(By.xpath(locator));

	for (WebElement element : elementList) {
	    arrayList.add(convertStringToDate(element.getText()));
	}

	System.out.println("------------ du lieu tren UI: -------------- ");
	for (Date name : arrayList) {
	    System.out.println(name);
	}

	ArrayList<Date> sortedList = new ArrayList<Date>();
	for (Date child : arrayList) {
	    sortedList.add(child);
	}

	Collections.sort(sortedList);

	System.out.println("------------ du lieu da SORT ASC trong code: -------------- ");
	for (Date name : sortedList) {
	    System.out.println(name);
	}

	Collections.reverse(sortedList);
	System.out.println("------------ du lieu da SORT DES trong code: -------------- ");
	for (Date name : sortedList) {
	    System.out.println(name);
	}

	return sortedList.equals(arrayList);
    }
    
    public boolean isDataDateSortedDescending(WebDriver driver, String locator, String... values) {
 	ArrayList<Date> arrayList = new ArrayList<Date>();

 	List<WebElement> elementList = driver.findElements(By.xpath(getDynamicLocator(locator, values)));

 	for (WebElement element : elementList) {
 	    arrayList.add(convertStringToDate(element.getText()));
 	}

 	System.out.println("------------ du lieu tren UI: -------------- ");
 	for (Date name : arrayList) {
 	    System.out.println(name);
 	}

 	ArrayList<Date> sortedList = new ArrayList<Date>();
 	for (Date child : arrayList) {
 	    sortedList.add(child);
 	}

 	Collections.sort(sortedList);

 	System.out.println("------------ du lieu da SORT ASC trong code: -------------- ");
 	for (Date name : sortedList) {
 	    System.out.println(name);
 	}

 	Collections.reverse(sortedList);
 	System.out.println("------------ du lieu da SORT DES trong code: -------------- ");
 	for (Date name : sortedList) {
 	    System.out.println(name);
 	}

 	return sortedList.equals(arrayList);
     }

    private Date convertStringToDate(String dateInString) {
	SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss a");
	Date date = null;
	try {
	    date = formatter.parse(dateInString);
	} catch (ParseException e) {
	    e.printStackTrace();
	}
	return date;
    }

    // ====================== COMMON PAGE ================

    public String getSuccessMessage(WebDriver driver) {
	waitToElementVisible(driver, AbstractPageUI.SUCCESS_MESSAGE_TEXT);
	return getElementText(driver, AbstractPageUI.SUCCESS_MESSAGE_TEXT);
    }

    public String getErrorMessage(WebDriver driver) {
	waitToElementVisible(driver, AbstractPageUI.ERROR_MESSAGE_TEXT);
	return getElementText(driver, AbstractPageUI.ERROR_MESSAGE_TEXT);
    }

    public void waittingForAjaxLoadingInvisible(WebDriver driver) {
	waitToElementInvisible(driver, AbstractPageUI.AJAX_LOADING_SPIN_ICON);
    }

    public void adminWaittingForLoadingIconInvisible(WebDriver driver) {
	waitToElementInvisible(driver, AbstractPageUI.ADMIN_LOADING_SPIN_ICON);
    }

    // ====================== SWITCH PAGE ================

    public void clickToAccountLinkAtHeaderMenu(WebDriver driver) {
	waitToElementClickable(driver, AbstractPageUI.ACCOUNT_HEADER_MENU);
	clickToElement(driver, AbstractPageUI.ACCOUNT_HEADER_MENU);
    }

    public AbstractPage clickToSubMenuItemOfAccountLinkAtHeaderMenu(WebDriver driver, String subPageName) {
	waitToElementClickable(driver, AbstractPageUI.DYNAMIC_ACCOUNT_SUB_ITEMS_HEADER_MENU, subPageName);
	clickToElement(driver, AbstractPageUI.DYNAMIC_ACCOUNT_SUB_ITEMS_HEADER_MENU, subPageName);

	switch (subPageName) {
	case "Register":
	    return UserPageGenaratorManager.getRegisterPage(driver);

	case "Log In":
	    return UserPageGenaratorManager.getUserLoginPage(driver);

	case "My Account":
	    return UserPageGenaratorManager.getAccountDashboardPage(driver);

	default:
	    return UserPageGenaratorManager.getUserHomepage(driver);
	}

    }

    public AbstractPage clickToPageNameAtBottomPage(WebDriver driver, String pageName) {
	waitToElementClickable(driver, AbstractPageUI.DYNAMIC_PAGE_NAME_AT_BOTTOM_PAGE, pageName);
	clickToElement(driver, AbstractPageUI.DYNAMIC_PAGE_NAME_AT_BOTTOM_PAGE, pageName);

	switch (pageName) {
	case "Advanced Search":
	    return UserPageGenaratorManager.getAdvancedSearchPage(driver);
	default:
	    return UserPageGenaratorManager.getUserHomepage(driver);
	}

    }

    public AbstractPage openPageNameOfLeftMenuAtMyAccountPage(WebDriver driver, String pageName) {
	waitToElementClickable(driver, AbstractPageUI.DYNAMIC_PAGENAME_OF_LEFT_MENU_AT_MY_ACCOUNT_PAGE, pageName);
	clickToElement(driver, AbstractPageUI.DYNAMIC_PAGENAME_OF_LEFT_MENU_AT_MY_ACCOUNT_PAGE, pageName);

	switch (pageName) {
	case "Account Information":
	    return UserPageGenaratorManager.getAccountInformationPage(driver);

	default:
	    return UserPageGenaratorManager.getAccountInformationPage(driver);
	}

    }

    public UserHomepageObject clickToMagentoLogo(WebDriver driver) {
	waitToElementClickable(driver, AbstractPageUI.MAGENTO_LOGO);
	clickToElement(driver, AbstractPageUI.MAGENTO_LOGO);
	return UserPageGenaratorManager.getUserHomepage(driver);
    }

    public ProductListingPageObject clickToMobileLinkAtHeaderMenu(WebDriver driver) {
	waitToElementClickable(driver, AbstractPageUI.MOBILE_LINK_AT_HEADER_MENU);
	clickToElement(driver, AbstractPageUI.MOBILE_LINK_AT_HEADER_MENU);
	waitToJQueryAndJSLoadedSuccess(driver);
	return UserPageGenaratorManager.getProductListingPage(driver);
    }

    public ProductListingPageObject clickToTVLinkAtHeaderMenu(WebDriver driver) {
	waitToElementClickable(driver, AbstractPageUI.TV_LINK_AT_HEADER_MENU);
	clickToElement(driver, AbstractPageUI.TV_LINK_AT_HEADER_MENU);
	waitToJQueryAndJSLoadedSuccess(driver);
	return UserPageGenaratorManager.getProductListingPage(driver);
    }

    // ====================== USER PAGE =================

    public String getPageTitleAtUserAccountPage(WebDriver driver) {
	waitToElementVisible(driver, AbstractPageUI.PAGE_TITLE_AT_ACCOUNT_PAGE);
	return getElementText(driver, AbstractPageUI.PAGE_TITLE_AT_ACCOUNT_PAGE);
    }

    // ====================== ADMIN PAGE =================

    public void clickToLogOutLink(WebDriver driver) {
	waitToElementClickable(driver, AbstractPageUI.LOG_OUT_LINK);
	clickToElement(driver, AbstractPageUI.LOG_OUT_LINK);
    }

    public void clickToMenuItemAtTheHeaderMenu(WebDriver driver, String menuItem) {
	waitToElementClickable(driver, AbstractPageUI.ADMIN_DYNAMIC_HEADER_MENU_ITEM, menuItem);
	clickToElement(driver, AbstractPageUI.ADMIN_DYNAMIC_HEADER_MENU_ITEM, menuItem);
    }

    public void removeFilesInFolder(String downloadInvoicesDir) {

	File file = new File(downloadInvoicesDir);
	if (!file.exists()) {
	    file.mkdir();
	} else {
	    File[] files = file.listFiles();
	    if (!files.equals(null)) {
		for (File f : files) {
		    if (f.isFile() && f.exists()) {
			f.delete();
		    }
		}
	    }
	}
    }

    public boolean checkInvoicesPDFFileDowloaded(String downloadInvoicesDir) {
	File directory = new File(downloadInvoicesDir);
	boolean isDownloadingFile = false;
	boolean isDownloaded = false;
	final int SLEEP_TIME_SECOND = 3;
	final int timeout = 40;
	int timeElapsed = 0;

	File[] filesList = directory.listFiles();

	for (File file : filesList) {
	    isDownloadingFile = file.getName().endsWith(".crdownload");

	    while (isDownloadingFile && timeElapsed < timeout) {
		timeElapsed += SLEEP_TIME_SECOND;
		sleepInSecond(SLEEP_TIME_SECOND);
		File[] refreshedFiles = directory.listFiles();

		isDownloadingFile = refreshedFiles[0].getName().endsWith(".crdownload");

		System.out.println("========= isDownloadingFile: " + isDownloadingFile);
		System.out.println("======== sleeped: " + timeElapsed);
	    }

	    if (!isDownloadingFile) {
		isDownloaded = true;
	    }
	}
	return isDownloaded;
    }

    // ====================== THE OTHERS ================

    public void sleepInSecond(long timeout) {
	try {
	    Thread.sleep(timeout * 1000);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
    }

}
