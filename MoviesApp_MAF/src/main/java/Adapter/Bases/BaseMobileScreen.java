package Adapter.Bases;



import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

import org.apache.logging.log4j.core.config.Configurator;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.apache.logging.log4j.LogManager.getLogger;

public class BaseMobileScreen {

    protected AndroidDriver driver;
    protected WebDriverWait wait;


    private final static Logger LOGGER = getLogger(BaseMobileScreen.class.getName());


    public BaseMobileScreen(AndroidDriver driver)  {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 30);
        initElements();
        Configurator.setLevel(LOGGER.getName(), Level.ALL);

    }

    private void initElements(){ PageFactory.initElements(new AppiumFieldDecorator(driver), this);}



    public void waitUntilElementPresent(AndroidElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitImplicit(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void Click(AndroidElement androidElement){
        LOGGER.debug("Clicking on :" + androidElement.getTagName());
        androidElement.click();
    }

    public void scrollToText(String text)
    {
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+text+"\").instance(0))"));
    }

    public void scrollToElement(AndroidElement androidElement)
    {
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()."));
//        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().description(\""+parentScrollViewId+"\")).scrollForward()"));
    }
    public void scrollToElementTouchAction(AndroidElement androidElement)
    {
        TouchAction action = new TouchAction(driver);

        action.perform();
    }

    public void hideKeyBoard (){

        driver.hideKeyboard();
    }


}


