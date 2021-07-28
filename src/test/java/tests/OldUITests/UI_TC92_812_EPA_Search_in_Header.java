package tests.OldUITests;

import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import pages.SearchResultPage;
import tests.utils.UITestBase;

public class UI_TC92_812_EPA_Search_in_Header extends UITestBase {

    @Test
    public void test() {
//        Navigate to EASEY In
//        https://easey-dev.app.cloud.gov/monitoring-plans
        goTo("https://easey-dev.app.cloud.gov/monitoring-plans");

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);
        SearchResultPage searchResultPage = new SearchResultPage(driver);

        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");


//        Click on the menu option that is available on the header.
        click(monitoringPlansPage.menuBtn);
//        Menu opens
        verifyTrue(monitoringPlansPage.menuNav.isDisplayed());

//        Confirm that the search box is available at the top of the menu option and is in accordance with the wireframes and acceptance criteria
//
//        Search box is visible
        verifyTrue(monitoringPlansPage.searchBox.isDisplayed());

//        Enter something into the search box field and click on the magnifying glass to initiate the search.
        input(monitoringPlansPage.searchBox, "something");
        waitFor(monitoringPlansPage.searchButton);
        click(monitoringPlansPage.searchButton);
//                Then the system opens the link on the EPA website in a new tab to view the results
        changeTab();
        verifyTrue(searchResultPage.searchResults.getText().contains("something"));

    }
}
