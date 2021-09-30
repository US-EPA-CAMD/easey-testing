package tests.UITests.EASEYIn_Emissioners.headerAndFooterAndMainPage;

import org.testng.annotations.Test;
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
        SearchResultPage searchResultPage = new SearchResultPage(driver);

        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

        verifyEquals(monitoringPlansPage.menuBtn, "Menu");
        click(monitoringPlansPage.menuBtn);

        waitFor(monitoringPlansPage.searchButton);
        verifyTrue(isDisplayed(monitoringPlansPage.searchButton));

        monitoringPlansPage.searchBox.sendKeys("Something");

        click(monitoringPlansPage.searchButton);

        changeTab();
        verifyTrue(searchResultPage.searchResults.getText().contains("Something"));

    }
}
