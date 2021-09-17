package Adapter.Screens;

import Adapter.Bases.BaseMobileScreen;
import Utils.CommonSteps;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import java.util.List;

import static org.apache.logging.log4j.LogManager.getLogger;

public class SearchScreen extends BaseMobileScreen {


    private final static Logger LOGGER = getLogger(SearchScreen.class.getName());

    @AndroidFindBy(id = "com.imdb.mobile:id/search_src_text")
    private AndroidElement searchBar;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.imdb.mobile:id/holder\").index(0)")
    private AndroidElement firstResultElement;

    By resultsInSearch = By.id("com.imdb.mobile:id/holder");



    public SearchScreen(AndroidDriver driver) {
        super(driver);
    }

    public void openingSearchBar(){
        LOGGER.debug("Opening Search Bar");
        searchBar.click();

    }

    public void sendingSearchQuery(String query){
        LOGGER.debug("Sending search query");
        searchBar.sendKeys(query);
        hideKeyBoard();
    }

    public MovieDetailScreen selectingFirstMovie(){
        LOGGER.debug("Selecting first movie");
        waitUntilElementPresent(firstResultElement);
        firstResultElement.click();
        waitImplicit();
        return new MovieDetailScreen(driver);

    }

    public MovieDetailScreen selectingMovieOrTVShowFromResults(){
        getMovieOrTVShowFromResults().click();

        return new MovieDetailScreen(driver);
    }

    private AndroidElement getMovieOrTVShowFromResults(){
        List<AndroidElement> listResults = driver.findElements(resultsInSearch);
;
        int elementPicked = CommonSteps.getRandomNumberInRange(0, 7);
        return listResults.get(elementPicked);
    }











}
