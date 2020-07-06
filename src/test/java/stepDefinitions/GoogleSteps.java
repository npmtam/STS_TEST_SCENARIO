package stepDefinitions;

import commons.AbstractTest;
import commons.Constants;
import commons.PageGeneratorManager;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import org.openqa.selenium.WebDriver;
import pageObjects.GooglePageObject;
import pageObjects.YoutubePageObject;

public class GoogleSteps extends AbstractTest {
    WebDriver driver;
    GooglePageObject googlePage;
    YoutubePageObject youtubePage;

    String keyword, videoTitle;

    public GoogleSteps(){
        driver = Hooks.openBrowser();
        googlePage = PageGeneratorManager.getGooglePage(driver);
        youtubePage = PageGeneratorManager.getYoutubePage(driver);
    }

    @Given("^I open the Google website$")
    public void i_open_the_Google_website() {
        log.info("Step 01: Open the website");
        googlePage.openURL(Constants.GOOGLE_URL);
    }

    @When("^I search for the \"([^\"]*)\" keyword$")
    public void i_search_for_the_keyword(String keyword){
        log.info("Step 02: Input keyword to the search text box");
        googlePage.inputToSearchTextbox(keyword);
        this.keyword = keyword.substring(4);
        log.info("Step 03: Click on Google search button");
        googlePage.clickToSearch();
    }

    @Then("^I verify all the main results contains the keyword$")
    public void i_verify_all_the_main_results_contains_the_keyword() {
        log.info("Step 04: Check the results list contains the keyword");
        verifyTrue(googlePage.isTheResultsContainsKeyword(keyword));
    }

    @Then("^I verify all the results in People also ask section contains the keyword$")
    public void i_verify_all_the_results_in_People_also_ask_section_contains_the_keyword() {
        log.info("Step 05: Check the result at People also ask section contains the keyword");
        verifyTrue(googlePage.isResultsAtPeopleAlsoAskContainsKeyword(keyword));
    }

    @Then("^I verify all the results in the Top Stories section contains the keyword$")
    public void i_verify_all_the_results_in_the_Top_Stories_section_contains_the_keyword() {
        log.info("Step 06: Check the results at Top Stories section contains the keyword");
        verifyTrue(googlePage.isResultsAtTopStoriesContainsKeyword(keyword));
    }

    @Then("^I verify all the results in the Videos section contains the keyword$")
    public void i_verify_all_the_results_in_the_Videos_section_contains_the_keyword(){
        log.info("Step 07: Check the result at Video section contains the keyword");
        verifyTrue(googlePage.isResultsAtVideosContainsKeyword(keyword));
    }

    @Then("^I verify the inputted string remained on the search box$")
    public void i_verify_the_inputted_string_remained_on_the_search_box() {
        log.info("Step 08: Verify the inputted keyword remained on the search box");
        verifyTrue(googlePage.isInputtedStringRemained(keyword));
    }

    @When("^I open the first Youtube video result on Google search$")
    public void i_open_the_first_Youtube_video_result_on_Google_search(){
        log.info("Step 09: Open the 1st Youtube video in the result page");
        videoTitle = googlePage.getFirstVideoTitle();
        googlePage.clickTo1stVideo();
    }

    @When("^I pause the video after (\\d+) seconds$")
    public void i_pause_the_video_after_seconds(int timeout){
        log.info("Step 10: Wait for 10 seconds");
        youtubePage.checkAdsAndWaitForSeconds(timeout);

        log.info("Step 11: Pause the video");
        youtubePage.clickToPauseBtn();
    }

    @Then("^I verify the video tittle is same to Google result$")
    public void i_verify_the_video_tittle_is_same_to_Google_result(){
        youtubePage.isVideoTitleSameResult(videoTitle);
    }

    @After
    public void closeBrowser(){
        closeBrowserAndDriver(driver);
    }
}
