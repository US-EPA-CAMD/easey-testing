package tests.UITests;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.MonitoringPlansPage;
import tests.utils.CSVParser;
import tests.utils.UITestBase;

import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class TS26_View_facilities_and_MP_data extends UITestBase {
    @DataProvider(name = "csv")
    public Object[] dp() {
        System.out.println("Current Directory: " + Paths.get(".").toAbsolutePath().normalize().toString());
        String filePath = filePathBase +
                "UITestData/TS26_View_facilities_and_MP_data.csv";
        CSVParser csv = new CSVParser(filePath);
        List data = csv.getData();
        return data.toArray();
    }

//    @Test(dataProvider = "csv")
    public void TC52_398_View_facilities_and_MP_data(Map<String, String> map) {
        // Step 1: Navigate to EASY In
        goTo(map.get("URL"));

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);

        // Expected result 1: A list of facilities is displayed in a table (no default filtering)
        assertTrue(isDisplayed(monitoringPlansPage.table), "Facilities table is not displayed");
    }

    @Test(dataProvider = "csv")
    public void TC53_398_Pagination(Map<String, String> map) {
        // Step 1: Navigate to EASY In
        goTo(map.get("URL"));

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);

        // Expected result 1: A list of facilities is displayed in a table (no default filtering)
        assertTrue(isDisplayed(monitoringPlansPage.table), "Facilities table is not displayed");

        // Step 2: Check that the number of results that is displayed in pagination is defaulted at 100.
        waitFor(driver -> monitoringPlansPage.tableResults.size() > 1);

        // Expected result 2: Page is limited to only 100 facilities as a default.
        Select paginationDropdown = new Select(monitoringPlansPage.paginationDropdown);
        assertTrue(paginationDropdown.getFirstSelectedOption().getText().equals("100"), "Pagination not set to 100");
        assertTrue(monitoringPlansPage.tableResults.size() <= 100, "Table showing more than 100 results");
        assertTrue(contains(monitoringPlansPage.total, "100"), "Message does not indicate 100 results shown");

		// Step 2.5: Verify contents in dropdown list named 'Rows per table'
        // Expected result 2.5: Dropdown list contains the following values:
			// 100
			// 250
			// 500
			// All

			// Alongside the dropdown list the 'Update' button will initiate the selected number.
        assertTrue(contains(monitoringPlansPage.paginationDropdown, "100"), "Pagination dropdown does not contain value: 100");
        assertTrue(contains(monitoringPlansPage.paginationDropdown, "250"), "Pagination dropdown does not contain value: 250");
        assertTrue(contains(monitoringPlansPage.paginationDropdown, "500"), "Pagination dropdown does not contain value: 500");
        assertTrue(contains(monitoringPlansPage.paginationDropdown, "All"), "Pagination dropdown does not contain value: All");
        assertTrue(isDisplayed(monitoringPlansPage.updatePaginationButton), "Pagination update button is not displayed");

        // Step 3: Change pagination limit to 250 facilities and push 'Update'
        click(paginationDropdown.getOptions().get(1));
        click(monitoringPlansPage.updatePaginationButton);
        waitFor(driver -> monitoringPlansPage.tableResults.size() <= 250);

        // Expected result 3: Page is limited to 250 facilities
        assertTrue(paginationDropdown.getFirstSelectedOption().getText().equals("250"), "Pagination not set to 250");
        assertTrue(monitoringPlansPage.tableResults.size() <= 250, "Table showing more than 250 results");
        assertTrue(contains(monitoringPlansPage.total, "250"), "Message does not indicate 250 results shown");

		// Step 4: Change pagination limit to 500 facilities and push 'Update'
        click(paginationDropdown.getOptions().get(2));
        click(monitoringPlansPage.updatePaginationButton);
        waitFor(driver -> monitoringPlansPage.tableResults.size() <= 500);

        // Expected result 4: Page is limited to 500 facilities
        assertTrue(paginationDropdown.getFirstSelectedOption().getText().equals("500"), "Pagination not set to 500");
        assertTrue(monitoringPlansPage.tableResults.size() <= 500, "Table showing more than 500 results");
        assertTrue(contains(monitoringPlansPage.total, "500"), "Message does not indicate 500 results shown");

		// Step 5: Change pagination limit to All facilities and push 'Update'
        String total = monitoringPlansPage.total.getText();
        total = total.substring(total.indexOf("of ") + 3, total.indexOf(" rows"));
        int totalInt = Integer.parseInt(total);
        
        click(paginationDropdown.getOptions().get(3));
        click(monitoringPlansPage.updatePaginationButton);
        waitFor(driver -> monitoringPlansPage.tableResults.size() <= totalInt);

        // Expected result 5: All facilities are displayed
        assertTrue(paginationDropdown.getFirstSelectedOption().getText().equals("All"), "Pagination not set to All");
        assertTrue(monitoringPlansPage.tableResults.size() <= totalInt, String.format("Table showing more than %d results", totalInt));
        assertTrue(contains(monitoringPlansPage.total, total), String.format("Message does not indicate %d results shown", totalInt));

        // Step 5.5: Return back to 100 results
        click(paginationDropdown.getOptions().get(0));
        click(monitoringPlansPage.updatePaginationButton);
        waitFor(driver -> monitoringPlansPage.tableResults.size() <= 100);

        // Expected result 5.5: Page is limited to 100 facilities
        assertTrue(paginationDropdown.getFirstSelectedOption().getText().equals("100"), "Pagination not set to 100");
        assertTrue(monitoringPlansPage.tableResults.size() <= 100, "Table showing more than 100 results");
        assertTrue(contains(monitoringPlansPage.total, "100"), "Message does not indicate 100 results shown");

        int totalPages = totalInt / 100;
        if (totalInt % 100 != 0) totalPages++;

        while(Integer.parseInt(monitoringPlansPage.currentPage.getText()) != totalPages) {
            // Expected result 6: Each table page displays the number of entries selected (100, 250, 500, etc)
            assertTrue(paginationDropdown.getFirstSelectedOption().getText().equals("100"), "Pagination not set to 100");
            assertTrue(monitoringPlansPage.tableResults.size() <= 100, "Table showing more than 100 results");
            assertTrue(contains(monitoringPlansPage.total, "100"), "Message does not indicate 100 results shown");

            // Step 6: Navigate through each page by clicking the next page button
            click(monitoringPlansPage.nextPageButton);
        }
		// Step 7: The system will display the total number of records returned and the number of records on the current page.

        // Expected result 7: The number of felicities that is showing on screen currently and the total number that are available should show below the facilities section.
        assertTrue(paginationDropdown.getFirstSelectedOption().getText().equals("100"), "Pagination not set to 100");
        assertTrue(monitoringPlansPage.tableResults.size() <= 100, "Table showing more than 100 results");

    }

//    @Test(dataProvider = "csv")
    public void TC54_398_Search(Map<String, String> map) {
        // Step 1: Navigate to EASY In
        goTo(map.get("URL"));

        MonitoringPlansPage monitoringPlansPage = new MonitoringPlansPage(driver);

        // Expected result 1: A list of facilities is displayed in a table (no default filtering)
        assertTrue(isDisplayed(monitoringPlansPage.table), "Facilities table is not displayed");

        // Step 2: Click on search box

        // Expected Result 2: Search box should indicate that the user can start typing desired search criteria

        // Step 3: Search for facility data by using ORIS Code

        // Expected Result 3: Matching facilities are dynamically displayed as you type

        // Step 4: Search for facility data by using Facility Name

        // Expected Result 4: Matching facilities are dynamically displayed as you type

        // Step 5: Search for facilities data by using State

        // Expected Result 5: Matching facilities are dynamically displayed as you type

        // Step 6: View results and navigate through the list of facilities (e.g. scrolling)

        // Expected Result 6: User should be able to see view and navigate through the search results

        // Step 7: Search for a facility that does not exist

        // Expected Result 7: A message should appear:
            // "No results match that search criteria. Please change the criteria and try again."
    }
}
