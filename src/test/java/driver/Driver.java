package driver;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Driver {
    private final int WAITSECS = 60;
    private WebDriverWait wait;
    public WebDriver driver;
    private EventFiringWebDriver e_driver;
    private WebEventListener eventListener;
    private String url ="https://www.eurowings.com/en/information/at-the-airport/flight-status.html";

    //Method to Browser initialization
    public void launchUrl(String browser) {
        String folderOS,chromepath,firefoxpath;
        if(System.getProperty("os.name").contains("Windows")){
            folderOS ="driver_windows\\";
            chromepath=folderOS+"chromedriver.exe";
            firefoxpath=folderOS+"geckodriver.exe";
        }else{
            folderOS ="driver_linux/";
            chromepath=folderOS+"chromedriver";
            firefoxpath=folderOS+"geckodriver";
        }
        if (browser.equalsIgnoreCase("Chrome")) {
            ChromeOptions option = new ChromeOptions();
            option.addArguments("--disable-notifications");
            option.setExperimentalOption("useAutomationExtension", false);
            System.setProperty("webdriver.chrome.driver", chromepath);
            driver = new ChromeDriver(option);
        } else if (browser.equalsIgnoreCase("Firefox")) {
            FirefoxOptions option = new FirefoxOptions();
            option.addArguments("--disable-notifications");
            System.setProperty("webdriver.gecko.driver", firefoxpath);
            driver = new FirefoxDriver(option);
        } else {
            Assert.fail("Browser not found");
        }
        e_driver = new EventFiringWebDriver(driver);
        eventListener = new WebEventListener();
        e_driver.register(eventListener);
        driver = e_driver;
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(WAITSECS, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(WAITSECS, TimeUnit.SECONDS);
        driver.get(url);
    }

    // Method to Quit the whole browser session along with all the associated browser windows, tabs and pop-ups.
    public void closeAllBrowserTab() {driver.quit();}

    // Method to return clickable webelement with first matching xpath
    public WebElement getClickableElement(String xpath) {
        List<WebElement> webElements = driver.findElements(By.xpath(xpath));
        if (!webElements.isEmpty()) {
            for (WebElement webElement : webElements) {
                if (waitForElementToBeClickable(webElement) != null)
                    return webElement;
            }
        }
        takeScreenshot();
        Assert.fail("Element not found");
        return null;
    }

    // Method to return webelement with matching xpath
    public WebElement getElement(String xpath) {
        try {
            return (driver.findElement(By.xpath(xpath)));
        }catch (ElementNotVisibleException elemexception){
            takeScreenshot();
            Assert.fail("Element not found");
            return null;
        }
    }

    // Method to get the Title of Page
    public String getTitle() {
        System.out.println(driver.getCurrentUrl());
        return driver.getTitle();
    }

    // Method to wait for element to be clickable and click element
    public void clickWebElement(WebElement element) {
        if (waitForElementToBeClickable(element) != null) {
            scrolltoView(element);
            element.click();
        }
    }

    // Method to enter text in any Text field
    public void enterText(WebElement element, String textToEnter) {
        if (waitForElementToBeClickable(element) != null) {
            scrolltoView(element);
            element.sendKeys(textToEnter,Keys.TAB);
        }
    }

    // Method to Select the value in the dropdown Menu
    // Please note: Used JavaScript - The selected dropdown value willnot be displayed while execution
    public void selectDropDownByValue(WebElement element, String dropdownValue){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].setAttribute('value','"+getDropdownValue(dropdownValue)+"');",element);
    }

    // Method to get the value using Hashmap key
    private String getDropdownValue(String dropdownValue) {
        HashMap<String,String> hm = new HashMap<String, String>();
        hm.put("Today","date_today");
        hm.put("Tomorrow","date_tomorrow");
        hm.put("Tomorrow +1","date_day_after_tomorrow");
        hm.put("Last 7 days","date_last_week");
        return hm.get(dropdownValue);
    }

    // Method to scroll to the element
    private void scrolltoView(WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

    // Method to wait and click webElement
    public String getText(WebElement element) {
        if (waitForElementToBeClickable(element) != null) {
            scrolltoView(element);
            return element.getText();
        }
        return null;
    }

    // Method to verify if webElement is displayed and returns boolean
    public boolean isElementDisplayed(WebElement element) {
        scrolltoView(element);
        return element.isDisplayed();
    }

    // Method to verify if webElement is selected and returns boolean
    public boolean isElementSelected(WebElement element) {
        scrolltoView(element);
        return element.isSelected();
    }

    // Method to wait for an element to be clickable and return the webelement
    private WebElement waitForElementToBeClickable(WebElement element) {
        try {
            wait = new WebDriverWait(driver, WAITSECS);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return element;
        } catch (ElementNotInteractableException | NoSuchElementException elementnotvisible) {
            takeScreenshot();
            Assert.fail(element + "Element not Interactable or visible");
            return null;
        }
    }

    // Method to take screen capture
    public void takeScreenshot() {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            String filepath = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".jpeg";
            FileUtils.copyFile(scrFile, new File(filepath));
            System.out.println("Screenshot File Created : " + filepath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to get system date
    public String getDateValue(String date){
        if(date.equals("Today")){
            return (returnFormatedDate(0));
        }
        else if(date.equals("Tomorrow")){
            return (returnFormatedDate(1));
        }
        else if(date.equals("Tomorrow +1")){
            return (returnFormatedDate(2));
        }
        else if(date.equals("Last 7 days")){
            return (returnFormatedDate(-1));
        }
        else{
            return null;
        }
    }

    // Method to format the date
    private String returnFormatedDate(int noOfDays){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR,noOfDays);
        Date sysdate = calendar.getTime();
        DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        return (dateformat.format(sysdate));
    }

    // Method for hard wait
    public void waitSeconds(int seconds){
        try{
            Thread.sleep(seconds*1000);
        }catch (InterruptedException ie){
            System.out.println(ie);
        }
    }

}

