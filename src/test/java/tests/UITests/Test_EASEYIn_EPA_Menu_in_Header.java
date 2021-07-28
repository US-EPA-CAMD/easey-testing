package tests.UITests;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.UITestBase;

public class Test_EASEYIn_EPA_Menu_in_Header extends UITestBase {

    @Test
    public void test() {

//        Navigate to EASEY In
//        https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
        goTo("https://easey-dev.app.cloud.gov/ecmps/monitoring-plans");

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);

        verifyEquals(monitoringPlansPage.title, "Monitoring Plans");

//        Click on the menu option that is available on the header.
        click(monitoringPlansPage.menuBtn);
//        Menu opens
        verifyTrue(monitoringPlansPage.menuNav.isDisplayed());
//
//
//        Confirm that the following links including their sub topics are in accordance with the wireframes and acceptance criteria and are able to be selected.
//
//        Environmental Topics
//        click(monitoringPlansPage.environmentalTopicsMenuDropDown);

        Actions action = new Actions(driver);

        waitFor(monitoringPlansPage.environmentalTopicsMenuDropDown);
        action.moveToElement(monitoringPlansPage.environmentalTopicsMenuDropDown, 100, 0).click().perform();

//        Air
        verifyEquals(monitoringPlansPage.environmentalTopics.get(0), "Air");
//        Bed Bugs
        verifyEquals(monitoringPlansPage.environmentalTopics.get(1), "Bed Bugs");
//        Chemicals and Toxics
        verifyEquals(monitoringPlansPage.environmentalTopics.get(2), "Chemicals and Toxics");
//        Environmental Information by Location
        verifyEquals(monitoringPlansPage.environmentalTopics.get(3), "Environmental Information by Location");
//        Greener Living
        verifyEquals(monitoringPlansPage.environmentalTopics.get(4), "Greener Living");
//        Health
        verifyEquals(monitoringPlansPage.environmentalTopics.get(5), "Health");
//        Land, Waste, and Cleanup
        verifyEquals(monitoringPlansPage.environmentalTopics.get(6), "Land, Waste, and Cleanup");
//        Lead
        verifyEquals(monitoringPlansPage.environmentalTopics.get(7), "Lead");
//        Mold
        verifyEquals(monitoringPlansPage.environmentalTopics.get(8), "Mold");
//        Pesticides
        verifyEquals(monitoringPlansPage.environmentalTopics.get(9), "Pesticides");
//        Radon
        verifyEquals(monitoringPlansPage.environmentalTopics.get(10), "Radon");
//        Science
        verifyEquals(monitoringPlansPage.environmentalTopics.get(11), "Science");
//        Water
        verifyEquals(monitoringPlansPage.environmentalTopics.get(12), "Water");
//        A-Z Topic Index
        verifyEquals(monitoringPlansPage.environmentalTopics.get(13), "A-Z Topic Index");

        action.moveToElement(monitoringPlansPage.environmentalTopicsMenuDropDown, 100, 0).click().perform();


//        Laws & Regulations
        waitFor(monitoringPlansPage.lawsAndRegulationsMenuDropDown);
        action.moveToElement(monitoringPlansPage.lawsAndRegulationsMenuDropDown, 100, 0).click().perform();

//        By Business Sector
        verifyEquals(monitoringPlansPage.lawsAndRegulations.get(0), "By Business Sector");
//        By Topic
        verifyEquals(monitoringPlansPage.lawsAndRegulations.get(1), "By Topics");
//        Compliance
        verifyEquals(monitoringPlansPage.lawsAndRegulations.get(2), "Compliance");
//        Enforcement
        verifyEquals(monitoringPlansPage.lawsAndRegulations.get(3), "Enforcement");
//        Laws and Executive Orders
        verifyEquals(monitoringPlansPage.lawsAndRegulations.get(4), "Laws and Executive Orders");
//        Guidance
        verifyEquals(monitoringPlansPage.lawsAndRegulations.get(5), "Guidance");
//        Regulations
        verifyEquals(monitoringPlansPage.lawsAndRegulations.get(6), "Regulations");

        action.moveToElement(monitoringPlansPage.lawsAndRegulationsMenuDropDown, 100, 0).click().perform();


//        About EPA
        waitFor(monitoringPlansPage.aboutEPAMenuDropDown);
        action.moveToElement(monitoringPlansPage.aboutEPAMenuDropDown, 100, 0).click().perform();

//        Organization Chart
        verifyEquals(monitoringPlansPage.aboutEPA.get(0), "Organization Chart");
//        Staff Directory
        verifyEquals(monitoringPlansPage.aboutEPA.get(1), "Staff Directory");
//        Planning, Budget, and Results
        verifyEquals(monitoringPlansPage.aboutEPA.get(2), "Planning, Budget, and Results");
//        Jobs and Internships
        verifyEquals(monitoringPlansPage.aboutEPA.get(3), "Jobs and Internships");
//        Headquarters and Office
        verifyEquals(monitoringPlansPage.aboutEPA.get(4), "Headquarters Offices");
//        Regional and Offices
        verifyEquals(monitoringPlansPage.aboutEPA.get(5), "Regional Offices");
//        Labs and Research Centers
        verifyEquals(monitoringPlansPage.aboutEPA.get(6), "Labs and Research Centers");

    }
}
