package stepdefinitions;

import driver.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class SearchFlights extends Driver {
    private String departureInput ="//input[@class='originName']";
    private String destinationInput ="//input[@class='destinationName']";
    private String showFlightBtn ="//button[text()='Show flight status'][contains(@class,'SearchSubmit')]";
    private String dateSelectInput ="//div[@class='input-field cmsc-date-picker']//input[@name='date']";
    private String dateSelectContainer ="//div[@class='input-field cmsc-date-picker']";
    private String resultHeaderDate ="//td[@class='date-head']";
    private String updateStatusBtn ="//button[@class='btn-refresh'][1]";
    private String timeStamp ="//p[@class='refresh-date'][1]";
    private String trackFlightBtn ="//button[text()='Track flight'][1]";
    private String trackedFlightTable = "//div[@class='flightstatus-result flightstatus-watched']//table//tr[contains(@class,'toggle-head')]";
    private String timeStampBeforeUpdate = null,timeStampAfterUpdate = null;

    @Given("^user opens flight status page in \"(.*)\"$")
    public void openApp(String browser) { launchUrl(browser); }

    @Then("^user verifies the flight status page title - \"(.*)\"$")
    public void verifyPageTitle(String title){
        Assert.assertEquals(title,getTitle());
    }

    @Then("^user verifies departure, destination, travel date and show flight status webelements$")
    public void verifyFilterSectionWebElements(){
        Assert.assertTrue(isElementDisplayed(getClickableElement(departureInput)));
        Assert.assertTrue(isElementDisplayed(getClickableElement(destinationInput)));
        Assert.assertTrue(isElementDisplayed(getElement(dateSelectContainer)));
        Assert.assertTrue(isElementDisplayed(getClickableElement(showFlightBtn)));
    }

    @When("^user enters departure \"(.*)\" and destination \"(.*)\"$")
    public void enterDeptDest(String depLoc, String desLoc){
        enterText(getClickableElement(departureInput),depLoc);
        enterText(getClickableElement(destinationInput),desLoc);
    }
    @When("^user selects travel date - \"(.*)\"$")
    public void selectDate(String date){
        selectDropDownByValue(getElement(dateSelectInput),date);
    }

    @And("^user clicks search flight status$")
    public void searchFlightstatus(){
        clickWebElement(getClickableElement(showFlightBtn));
    }

    @Then("^user verifies the search results for user entered date \"(.*)\"$")
    public void searchResultDateVerification(String date){
        Assert.assertEquals(getDateValue(date),getText(getElement(resultHeaderDate)));
    }
    @Then("^user closes the browser")
    public void closeApp(){ closeAllBrowserTab(); }

    @Then("^user updates flight status$")
    public void clickUpdateStatus(){
        timeStampBeforeUpdate = getText(getElement(timeStamp));
        waitSeconds(61);
        clickWebElement(getClickableElement(updateStatusBtn));
        waitSeconds(2);
        timeStampAfterUpdate = getText(getElement(timeStamp));
    }

    @Then("^user verifies the updated status$")
    public void updateStatusVerification(){
        Assert.assertNotEquals(timeStampBeforeUpdate,timeStampAfterUpdate);
    }

    @Then("^user clicks track flight button of the first search result$")
    public void clickTrackFlightButton(){
        clickWebElement(getClickableElement(trackFlightBtn));
    }

    @Then("^user verifies the tracked flights section$")
    public void verifyTrackedFlightTable(){
        Assert.assertTrue(isElementDisplayed(getClickableElement(trackedFlightTable)));
    }
}
