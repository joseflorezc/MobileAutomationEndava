package Adapter.Bases;


import Adapter.Screens.GlobalNavigationScreen;
import Adapter.Screens.LoginScreen;
import Adapter.Screens.PopUps;
import Core.ConfigCapabilities;
import Core.MobileAppDriver;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.*;


public class BaseMobileTest {

    protected AndroidDriver driver;
    protected PopUps popUps;
    protected LoginScreen loginScreen;
    protected GlobalNavigationScreen globalNavigationScreen;
    protected String titleOfMovieOrTVShowAddedToPlaylist;

    @BeforeMethod(alwaysRun = true)
    public void SetUp() {
        driver = new MobileAppDriver().GetMoviesAppDriver(ConfigCapabilities.GetCapabilities());
        popUps = new PopUps(driver);
        globalNavigationScreen = new GlobalNavigationScreen(driver);

        popUps.lettingApplicationUseLocationWhileInUse();
        loginScreen = popUps.acceptNotificationsIMDb();

        titleOfMovieOrTVShowAddedToPlaylist = "";


    }

    @AfterMethod(alwaysRun = true)
    public void TearDown() {
        driver.quit();
    }
}



