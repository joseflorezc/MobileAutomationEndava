package Adapter.Screens;

import Adapter.Bases.BaseMobileScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import static org.apache.logging.log4j.LogManager.getLogger;

public class PopUps extends BaseMobileScreen {


    private final static Logger LOGGER = getLogger(PopUps.class.getName());

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.Button\").textContains(\"Solo si la aplicación está en uso\")")
    private AndroidElement whileAppInUseButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.Button\").textContains(\"DE ACUERDO.\")")
    private AndroidElement agreeButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.imdb.mobile:id/exit\")")
    private AndroidElement exitButton;



    public PopUps(AndroidDriver driver) {
        super(driver);
        Configurator.setLevel(LOGGER.getName(), Level.ALL);
    }

    public void lettingApplicationUseLocationWhileInUse() {
        waitImplicit();
        whileAppInUseButton.click();
    }

    public LoginScreen acceptNotificationsIMDb() {
        waitUntilElementPresent(agreeButton);
        agreeButton.click();
        return new LoginScreen(driver);
    }

    public void closeAdvicePopUp (){
        waitUntilElementPresent(exitButton);
        exitButton.click();
    }




}
