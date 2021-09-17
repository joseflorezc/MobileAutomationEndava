package Tests;

import Adapter.Bases.BaseMobileTest;
import Adapter.Screens.*;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class SearchTests extends BaseMobileTest {

    @Test(priority = 0)
    public void searchingMovieAndCheckingPlotOverviewMatches (){

        HomeScreen homeScreen = loginScreen.skipLogin();

        SearchScreen searchScreen = globalNavigationScreen.clickingOnSearchIcon();
        popUps.closeAdvicePopUp();
        searchScreen.openingSearchBar();
        searchScreen.sendingSearchQuery("Deadpool 2");

        MovieDetailScreen movieDetailScreen = searchScreen.selectingFirstMovie();

        assertThat("The Movie Overview was not equal to the one expected", movieDetailScreen.movieOverviewText(), equalTo("El mercenario mutante malhablado Wade Wilson (también conocido como Deadpool), reúne a un equipo de compañeros mutantes para proteger a un joven con habilidades sobrenaturales del brutal cíborg Cable, que viaja en el tiempo."));

    }

    @Test(priority = 1)
    public void searchingMovieAddingToPlayListAndCheckingItAddedCorrectly (){

    HomeScreen homeScreen = loginScreen.loginWithGoogleEmail();

    SearchScreen searchScreen = globalNavigationScreen.clickingOnSearchIcon();
    popUps.closeAdvicePopUp();
    searchScreen.openingSearchBar();
    searchScreen.sendingSearchQuery("Deadpool");

    MovieDetailScreen movieDetailScreen = searchScreen.selectingMovieOrTVShowFromResults();
    movieDetailScreen.addMovieToPlayList();
    titleOfMovieOrTVShowAddedToPlaylist = movieDetailScreen.movieTitleText();

    YouScreen youScreen = globalNavigationScreen.clickingOnYouIcon();
    popUps.closeAdvicePopUp();

    assertThat("The Movie Title was not equal to the one expected", youScreen.playListElementTitle(), equalTo(titleOfMovieOrTVShowAddedToPlaylist));




    }

    @Test(priority = 2)
    public void RatingAMovieAndGettingSuccessMessage (){

        HomeScreen homeScreen = loginScreen.loginWithGoogleEmail();

        SearchScreen searchScreen = globalNavigationScreen.clickingOnSearchIcon();
        popUps.closeAdvicePopUp();
        searchScreen.openingSearchBar();
        searchScreen.sendingSearchQuery("Christmas");

        MovieDetailScreen movieDetailScreen = searchScreen.selectingFirstMovie();

        movieDetailScreen.scrollingToMovieOrTVShowRate();
        RateScreen rateScreen = movieDetailScreen.clickOnRate();

        rateScreen.rateMovieOrTVShowWithEightStars();
        rateScreen.sendRate();

        assertThat("The rate success message was not equal to the one expected", movieDetailScreen.rateSuccessMessageText(), equalTo("Rating saved"));



    }



}


