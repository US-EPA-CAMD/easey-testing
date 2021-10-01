package tests.UITests.EASEYIn_Emissioners.headerFooterAndMainPage;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.HeaderFooterAndHomePage;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

public class Test_EASEYIn_TC811_EPA_Menu_in_Header extends UITestBase {

    @Test
    public void test() {

//        Navigate to EASEY In
//        https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goTo("https://easey-dev.app.cloud.gov/ecmps/monitoring-plans");

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);
        HeaderFooterAndHomePage headerFooterAndHomePage = new HeaderFooterAndHomePage(driver);

        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

//        Click on the menu option that is available on the header.
        click(headerFooterAndHomePage.menuBtn);
//        Menu opens
        verifyTrue(isDisplayed(headerFooterAndHomePage.menuNav));
//
//
//        Confirm that the following links including their sub topics are in accordance with the wireframes and acceptance criteria and are able to be selected.
//
//        Environmental Topics
//        click(monitoringPlansPage.environmentalTopicsMenuDropDown);

        Actions action = new Actions(driver);

        waitFor(headerFooterAndHomePage.environmentalTopicsMenuDropDown);
        action.moveToElement(headerFooterAndHomePage.environmentalTopicsMenuDropDown, 100, 0).click().perform();

//        Air
        verifyEquals(headerFooterAndHomePage.environmentalTopics.get(0), "Air");
//        Bed Bugs
        verifyEquals(headerFooterAndHomePage.environmentalTopics.get(1), "Bed Bugs");
//        Chemicals and Toxics
        verifyEquals(headerFooterAndHomePage.environmentalTopics.get(2), "Chemicals and Toxics");
//        Environmental Information by Location
        verifyEquals(headerFooterAndHomePage.environmentalTopics.get(3), "Environmental Information by Location");
//        Greener Living
        verifyEquals(headerFooterAndHomePage.environmentalTopics.get(4), "Greener Living");
//        Health
        verifyEquals(headerFooterAndHomePage.environmentalTopics.get(5), "Health");
//        Land, Waste, and Cleanup
        verifyEquals(headerFooterAndHomePage.environmentalTopics.get(6), "Land, Waste, and Cleanup");
//        Lead
        verifyEquals(headerFooterAndHomePage.environmentalTopics.get(7), "Lead");
//        Mold
        verifyEquals(headerFooterAndHomePage.environmentalTopics.get(8), "Mold");
//        Pesticides
        verifyEquals(headerFooterAndHomePage.environmentalTopics.get(9), "Pesticides");
//        Radon
        verifyEquals(headerFooterAndHomePage.environmentalTopics.get(10), "Radon");
//        Science
        verifyEquals(headerFooterAndHomePage.environmentalTopics.get(11), "Science");
//        Water
        verifyEquals(headerFooterAndHomePage.environmentalTopics.get(12), "Water");
//        A-Z Topic Index
        verifyEquals(headerFooterAndHomePage.environmentalTopics.get(13), "A-Z Topic Index");

        action.moveToElement(headerFooterAndHomePage.environmentalTopicsMenuDropDown, 100, 0).click().perform();


//        Laws & Regulations
        waitFor(headerFooterAndHomePage.lawsAndRegulationsMenuDropDown);
        action.moveToElement(headerFooterAndHomePage.lawsAndRegulationsMenuDropDown, 100, 0).click().perform();

//        By Business Sector
        verifyEquals(headerFooterAndHomePage.lawsAndRegulations.get(0), "By Business Sector");
//        By Topic
        verifyEquals(headerFooterAndHomePage.lawsAndRegulations.get(1), "By Topics");
//        Compliance
        verifyEquals(headerFooterAndHomePage.lawsAndRegulations.get(2), "Compliance");
//        Enforcement
        verifyEquals(headerFooterAndHomePage.lawsAndRegulations.get(3), "Enforcement");
//        Laws and Executive Orders
        verifyEquals(headerFooterAndHomePage.lawsAndRegulations.get(4), "Laws and Executive Orders");
//        Guidance
        verifyEquals(headerFooterAndHomePage.lawsAndRegulations.get(5), "Guidance");
//        Regulations
        verifyEquals(headerFooterAndHomePage.lawsAndRegulations.get(6), "Regulations");

        action.moveToElement(headerFooterAndHomePage.lawsAndRegulationsMenuDropDown, 100, 0).click().perform();


//        About EPA
        waitFor(headerFooterAndHomePage.aboutEPAMenuDropDown);
        action.moveToElement(headerFooterAndHomePage.aboutEPAMenuDropDown, 100, 0).click().perform();

//        Organization Chart
        verifyEquals(headerFooterAndHomePage.aboutEPA.get(0), "Organization Chart");
//        Staff Directory
        verifyEquals(headerFooterAndHomePage.aboutEPA.get(1), "Staff Directory");
//        Planning, Budget, and Results
        verifyEquals(headerFooterAndHomePage.aboutEPA.get(2), "Planning, Budget, and Results");
//        Jobs and Internships
        verifyEquals(headerFooterAndHomePage.aboutEPA.get(3), "Jobs and Internships");
//        Headquarters and Office
        verifyEquals(headerFooterAndHomePage.aboutEPA.get(4), "Headquarters Offices");
//        Regional and Offices
        verifyEquals(headerFooterAndHomePage.aboutEPA.get(5), "Regional Offices");
//        Labs and Research Centers
        verifyEquals(headerFooterAndHomePage.aboutEPA.get(6), "Labs and Research Centers");

    }
}
