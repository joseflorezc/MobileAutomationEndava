package Adapter.Screens;

import Adapter.Bases.BaseMobileScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.apache.logging.log4j.LogManager.getLogger;

public class LoginScreen extends BaseMobileScreen {

    private final static Logger LOGGER = getLogger(LoginScreen.class.getName());

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.imdb.mobile:id/google_oauth\")")
    private AndroidElement loginWithGoogleButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.CheckedTextView\").textContains(\"josefloreztestendava@gmail.com\")")
    private AndroidElement emailRadioButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.Button\").textContains(\"ACEPTAR\")")
    private AndroidElement acceptButton;

    @AndroidFindBy(id = "com.imdb.mobile:id/splash_not_now")
    private AndroidElement skipLoginButton;



    public LoginScreen(AndroidDriver driver) {
        super(driver);
        Configurator.setLevel(LOGGER.getName(), Level.ALL);
    }

    private void clickLoginWithGoogleEmail(){
        LOGGER.debug("login with google click");
        loginWithGoogleButton.click();

    }

    private void selectingEmail(){
        LOGGER.debug("Selecting email radio button");
        emailRadioButton.click();
    }

    private void sendLoginWithEmail(){
        LOGGER.debug("Sending log in");
        acceptButton.click();
    }

    public HomeScreen loginWithGoogleEmail(){
        LOGGER.debug("Starting log in process");
        clickLoginWithGoogleEmail();
        selectingEmail();
        sendLoginWithEmail();
        waitImplicit();
        return new HomeScreen(driver);
    }

    public HomeScreen skipLogin(){
        LOGGER.debug("Skipping log in");
        skipLoginButton.click();
        return new HomeScreen(driver);
    }







}
