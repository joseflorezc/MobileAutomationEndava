package Adapter.Bases;



import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

import org.apache.logging.log4j.core.config.Configurator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
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
    public void scrollToElementTouchAction(WebElement webElement)
    {
        TouchActions action = new TouchActions(driver);
        action.scroll(webElement, 10 ,100);
        action.perform();
    }

    public void hideKeyBoard (){

        driver.hideKeyboard();
    }

    public void scrollDown(){
        Dimension dimension = driver.manage().window().getSize();

        Double scrollHeightStart = dimension.getHeight()*0.5;
        int scrollStart = scrollHeightStart.intValue();

        Double scrollHeightEnd = dimension.getHeight()*0.2;
        int scrollEnd = scrollHeightEnd.intValue();

        new TouchAction(driver)
                .press(PointOption.point(10,scrollStart))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(10,scrollEnd))
                .release().perform();

    }


}


