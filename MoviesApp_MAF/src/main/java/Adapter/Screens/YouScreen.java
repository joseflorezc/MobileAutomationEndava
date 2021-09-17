package Adapter.Screens;

import Adapter.Bases.BaseMobileScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class YouScreen extends BaseMobileScreen {

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.imdb.mobile:id/main_line\").index(1)")
    private AndroidElement playListElement;


    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").textContains(\"En seguimiento\")")
    private AndroidElement watchTextElement;

    public YouScreen(AndroidDriver driver) {
        super(driver);
    }

    public String playListElementTitle(){
        waitUntilElementPresent(watchTextElement);
        scrollDown();
        waitUntilElementPresent(playListElement);
        return playListElement.getText();
    }



}
