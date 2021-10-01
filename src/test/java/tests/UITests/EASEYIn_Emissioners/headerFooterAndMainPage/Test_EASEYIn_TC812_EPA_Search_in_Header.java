package tests.UITests.EASEYIn_Emissioners.headerFooterAndMainPage;

import org.testng.annotations.Test;
import pages.HeaderFooterAndHomePage;
import pages.MonitoringPlansPage;
import pages.SearchResultPage;
import tests.utils.UITestBase;

public class Test_EASEYIn_TC812_EPA_Search_in_Header extends UITestBase {

    @Test
    public void test() {

//        Navigate to EASEY In
//        https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goTo("https://easey-dev.app.cloud.gov/ecmps/monitoring-plans");

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);
        HeaderFooterAndHomePage headerFooterAndHomePage = new HeaderFooterAndHomePage(driver);
        SearchResultPage searchResultPage = new SearchResultPage(driver);

        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        verifyEquals(headerFooterAndHomePage.menuBtn, "Menu");
        click(headerFooterAndHomePage.menuBtn);

        waitFor(headerFooterAndHomePage.searchButton);
        verifyTrue(isDisplayed(headerFooterAndHomePage.searchButton));

        headerFooterAndHomePage.searchBox.sendKeys("Something");

        click(headerFooterAndHomePage.searchButton);

        changeTab();
        verifyTrue(searchResultPage.searchResults.getText().contains("Something"));

    }
}
