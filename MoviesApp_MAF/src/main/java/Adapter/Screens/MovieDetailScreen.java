package Adapter.Screens;

import Adapter.Bases.BaseMobileScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import static org.apache.logging.log4j.LogManager.getLogger;

public class MovieDetailScreen extends BaseMobileScreen {

    private final static Logger LOGGER = getLogger(MovieDetailScreen.class.getName());

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").textContains(\"Añadir a la lista de reproducción\")")
    private AndroidElement addToPlaylistButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.imdb.mobile:id/plot_overview\")")
    private AndroidElement moviePlotOverview;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.imdb.mobile:id/title\")")
    private AndroidElement movieTitle;






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
        waitUntilElementPresent(moviePlotOverview);
        return moviePlotOverview.getText();
    }

    public String movieTitleText(){
        waitUntilElementPresent(movieTitle);
        return movieTitle.getText();
    }




}
