package Adapter.Screens;

import Adapter.Bases.BaseMobileScreen;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import static org.apache.logging.log4j.LogManager.getLogger;

public class HomeScreen extends BaseMobileScreen {

    private final static Logger LOGGER = getLogger(HomeScreen.class.getName());
    public HomeScreen(AndroidDriver driver) {
        super(driver);

        Configurator.setLevel(LOGGER.getName(), Level.ALL);
    }

}
