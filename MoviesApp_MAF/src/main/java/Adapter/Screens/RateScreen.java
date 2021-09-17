package Adapter.Screens;

import Adapter.Bases.BaseMobileScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import javax.xml.soap.Detail;

import static org.apache.logging.log4j.LogManager.getLogger;

public class RateScreen extends BaseMobileScreen {

    private final static Logger LOGGER = getLogger(RateScreen.class.getName());

    @AndroidFindBy(id = "com.imdb.mobile:id/rate_title_button")
    private AndroidElement rateButton;
    @AndroidFindBy(id = "com.imdb.mobile:id/star_8")
    private AndroidElement eightStarButton;



    public RateScreen(AndroidDriver driver) {
        super(driver);
        Configurator.setLevel(LOGGER.getName(), Level.ALL);
    }

    public void rateMovieOrTVShowWithEightStars(){
        LOGGER.debug("Clicking on the eight star");
        waitUntilElementPresent(eightStarButton);
        eightStarButton.click();
    }
    public void sendRate(){
        LOGGER.debug("Sending Rate");
        waitUntilElementPresent(rateButton);
        rateButton.click();

    }







}
