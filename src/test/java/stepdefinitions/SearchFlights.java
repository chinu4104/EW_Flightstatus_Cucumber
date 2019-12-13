package stepdefinitions;

import driver.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;


public class SearchFlights extends Driver {
    private String departureInput ="//input[@class='originName']";
    private String destinationInput ="//input[@class='destinationName']";
    private String showFlightBtn ="//button[text()='Show flight status'][contains(@class,'SearchSubmit')]";
    private String dateSelectInput ="//div[@class='input-field cmsc-date-picker']//input[@name='date']";
    private String resultHeaderDate ="//td[@class='date-head']";
    private String updateStatusButton ="//button[@class='btn-refresh'][1]";
    private String timeStamp ="//p[@class='refresh-date'][1]";
    private String timeStampBeforeUpdate = null,timeStampAfterUpdate = null;

    @Given("^user open flight status page with browser \"(.*)\"$")
    public void openApp(String browser) { launchUrl(browser); }

    @When("^user enters departure \"(.*)\" and destination \"(.*)\"$")
    public void enterDeptDest(String depLoc, String desLoc){
        enterText(getClickableElement(departureInput),depLoc);
        enterText(getClickableElement(destinationInput),desLoc);
    }
    @When("^user selects \"(.*)\"$")
    public void selectDate(String date){
        selectDropDownByValue(getElement(dateSelectInput),date);
    }

    @And("^user clicks search flight status$")
    public void searchFlightstatus(){
        clickWebElement(getClickableElement(showFlightBtn));
    }

    @Then("^user flights status should be displayed accordingly and date \"(.*)\" verification should be done$")
    public void searchResultDateVerification(String date){
        Assert.assertEquals(getDateValue(date),getText(getElement(resultHeaderDate)));
    }
    @Then("^user closes the App")
    public void closeApp(){ closeAllBrowserTab(); }

    @Then("^user updates flight status$")
    public void clickUpdateStatus(){
        timeStampBeforeUpdate = getText(getElement(timeStamp));
        waitSeconds(61);
        clickWebElement(getClickableElement(updateStatusButton));
        waitSeconds(2);
        timeStampAfterUpdate = getText(getElement(timeStamp));
    }

    @Then("^user verifies the updated status$")
    public void updateStatusVerification(){
        Assert.assertNotEquals(timeStampBeforeUpdate,timeStampAfterUpdate);
    }
}
