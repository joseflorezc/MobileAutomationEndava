package Adapter.Screens;

import Adapter.Bases.BaseMobileScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.apache.logging.log4j.LogManager.getLogger;

public class MovieDetailScreen extends BaseMobileScreen {

    private final static Logger LOGGER = getLogger(MovieDetailScreen.class.getName());

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").textContains(\"Añadir a la lista de reproducción\")")
    private AndroidElement addToPlaylistButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.imdb.mobile:id/plot_overview\")")
    private AndroidElement moviePlotOverview;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.imdb.mobile:id/title\")")
    private AndroidElement movieTitle;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.imdb.mobile:id/title\").textContains(\"Rating saved\")")
    private AndroidElement ratingSuccessMessage;

    @AndroidFindBy(id = "com.imdb.mobile:id/empty_user_rating")
    private AndroidElement ratingButton;
//
//    By addingAReviewButtonBy = By.id("com.imdb.mobile:id/add_a_review");

    By ratingButtonBy = By.id("com.imdb.mobile:id/empty_user_rating");

    public MovieDetailScreen(AndroidDriver driver) {
        super(driver);
        Configurator.setLevel(LOGGER.getName(), Level.ALL);
    }

    public void addMovieToPlayList(){
        LOGGER.debug("Adding Movie To playlist");
        waitUntilElementPresent(addToPlaylistButton);
        addToPlaylistButton.click();
    }

    public String movieOverviewText(){
        LOGGER.debug("Getting movie overview");
        waitUntilElementPresent(moviePlotOverview);
        return moviePlotOverview.getText();
    }

    public String movieTitleText(){

        waitUntilElementPresent(movieTitle);
        LOGGER.debug("Getting movie Title");
        return movieTitle.getText();
    }





    public void scrollingToMovieOrTVShowRate(){
        Boolean flagElementNotFound = true;
        while (flagElementNotFound){
            LOGGER.debug("Scrolling to element Rate");
            scrollDown();

            try {

                driver.findElement(ratingButtonBy);
                flagElementNotFound = false;


            }catch(NoSuchElementException ex){
                LOGGER.debug("Rating button was not found");
            }

        }
    }



    public RateScreen clickOnRate(){
        ratingButton.click();

        return new RateScreen(driver);
    }


    public String rateSuccessMessageText(){
        LOGGER.debug("Checking rate success message");
        waitUntilElementPresent(ratingSuccessMessage);
        return ratingSuccessMessage.getText();
    }








}
