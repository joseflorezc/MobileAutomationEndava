package Adapter.Screens;

import Adapter.Bases.BaseMobileScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import static org.apache.logging.log4j.LogManager.getLogger;

public class GlobalNavigationScreen extends BaseMobileScreen {

    private final static Logger LOGGER = getLogger(GlobalNavigationScreen.class.getName());

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Search\"]/android.widget.ImageView")
    private AndroidElement searchButton;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Usted\"]/android.widget.ImageView")
    private AndroidElement youButton;

    public GlobalNavigationScreen(AndroidDriver driver) {
        super(driver);
        Configurator.setLevel(LOGGER.getName(), Level.ALL);
    }


    public SearchScreen clickingOnSearchIcon(){
        waitImplicit();
        LOGGER.debug("Clicking on search Icon");
        searchButton.click();
        return new SearchScreen(driver);
    }

    public YouScreen clickingOnYouIcon(){
        waitUntilElementPresent(youButton);
        LOGGER.debug("Clicking on you Icon");
        youButton.click();
        return new YouScreen(driver);
    }





}
