package tests.UITests.EASEYOut_Datateers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.CustomDataDownloadPage;
import tests.utils.UITestBase;
import org.openqa.selenium.JavascriptExecutor;


public class TC_482_FilterToolTip extends UITestBase {
    @Test
    public void test() {
        goTo("https://campd-dev.app.cloud.gov/data/custom-data-download");
        Actions action = new Actions(driver);
        CustomDataDownloadPage customDataDownloadPage = new CustomDataDownloadPage(driver);

        JavascriptExecutor jse = (JavascriptExecutor) driver;


        waitFor(customDataDownloadPage.datadropdown);
        click(customDataDownloadPage.datadropdown);

        waitFor(customDataDownloadPage.dataoption.get(1));
        click(customDataDownloadPage.dataoption.get(1));

        waitFor(customDataDownloadPage.subtypeDropdown);
        click(customDataDownloadPage.subtypeDropdown);

        waitFor(customDataDownloadPage.subtypeoption.get(1));
        click(customDataDownloadPage.subtypeoption.get(1));
//Select HourlyEmissions Subtype

        waitFor(customDataDownloadPage.subtypeDropdown);
        click(customDataDownloadPage.subtypeDropdown);

        waitFor(customDataDownloadPage.subtypeoption.get(1));
        click(customDataDownloadPage.subtypeoption.get(1));

        jse.executeScript("scroll(0, 500);");
        waitFor(customDataDownloadPage.applyBtn);
        click(customDataDownloadPage.applyBtn);


// apply date range
        waitFor(customDataDownloadPage.previewdata);
        click(customDataDownloadPage.filtercriteria.get(0));

        waitFor(customDataDownloadPage.datetooltipIcon);
        action.moveToElement(customDataDownloadPage.datetooltipIcon);

        waitFor(customDataDownloadPage.tooltip);


        verifyEquals(customDataDownloadPage.tooltip.getText() ,"If using the keyboard to navigate the date picker and the escape key does not work, try using the Shift + Tab keys then the escape key.");

        waitFor(customDataDownloadPage.datestart);
        input(customDataDownloadPage.datestart, "01/01/2019");

        input(customDataDownloadPage.dateend, "01/01/2020");
        jse.executeScript("scroll(0, 500);");

//        waitFor(customDataDownloadPage.hourlytooltipIcon);
//        action.moveToElement(customDataDownloadPage.hourlytooltipIcon);
//        verifyEquals(customDataDownloadPage.tooltip.getText() ,"When checked, only hours in a day during which a unit is operational are included in the data output.");

        waitFor(customDataDownloadPage.applyYear.get(1));
        click(customDataDownloadPage.applyYear.get(1));

        waitFor(customDataDownloadPage.previewdata);

// check Program Tool Tip
        click(customDataDownloadPage.filtercriteria.get(1));

        waitFor(customDataDownloadPage.tooltipIcon);
        action.moveToElement(customDataDownloadPage.tooltipIcon);

        waitFor(customDataDownloadPage.tooltip);

        verifyEquals(customDataDownloadPage.tooltip.getText() ,"For more information on Programs, visit the Programs area of Clean Air Markets website.");

        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));



//  Check Facility Tip
        click(customDataDownloadPage.filtercriteria.get(3));

        waitFor(customDataDownloadPage.tooltipIcon);
        action.moveToElement(customDataDownloadPage.tooltipIcon);

        waitFor(customDataDownloadPage.tooltip);

        verifyEquals(customDataDownloadPage.tooltip.getText() ,"ORIS Code: Facility ID Code assigned by the U.S. Energy Information Administration. Also known as ORISPL or Plant ID Code.");

        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

// check Fuel Type Tip

        click(customDataDownloadPage.filtercriteria.get(5));

        waitFor(customDataDownloadPage.tooltipIcon);
        action.moveToElement(customDataDownloadPage.tooltipIcon);

        waitFor(customDataDownloadPage.tooltip);

        verifyEquals(customDataDownloadPage.tooltip.getText() ,"Selections made will filter on both primary and secondary fuel types.");

        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

// check Control Tech Tip
        click(customDataDownloadPage.filtercriteria.get(6));

        waitFor(customDataDownloadPage.tooltipIcon);
        action.moveToElement(customDataDownloadPage.tooltipIcon);

        waitFor(customDataDownloadPage.tooltip);

        verifyEquals(customDataDownloadPage.tooltip.getText() ,"Units may use one or more methods/equipment to minimize emissions of various pollutants. Methods under the “Other” category may be used to control multiple pollutants.");

        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

 // Change to Daily Emissions
        click(customDataDownloadPage.changebutton);

        click(customDataDownloadPage.subtypeDropdown);
        click(customDataDownloadPage.subtypeoption.get(2));

        click(customDataDownloadPage.applyBtn);

// apply date range

        click(customDataDownloadPage.filtercriteria.get(0));

        waitFor(customDataDownloadPage.datetooltipIcon);
        action.moveToElement(customDataDownloadPage.datetooltipIcon);

        waitFor(customDataDownloadPage.tooltip);


        verifyEquals(customDataDownloadPage.tooltip.getText() ,"If using the keyboard to navigate the date picker and the escape key does not work, try using the Shift + Tab keys then the escape key.");

        waitFor(customDataDownloadPage.datestart);
        input(customDataDownloadPage.datestart, "01/01/2019");

        input(customDataDownloadPage.dateend, "01/01/2020");
        jse.executeScript("scroll(0, 500);");


        waitFor(customDataDownloadPage.applyYear.get(1));
        click(customDataDownloadPage.applyYear.get(1));

        waitFor(customDataDownloadPage.previewdata);

// check Program Tool Tip
        click(customDataDownloadPage.filtercriteria.get(1));

        waitFor(customDataDownloadPage.tooltipIcon);
        action.moveToElement(customDataDownloadPage.tooltipIcon);

        waitFor(customDataDownloadPage.tooltip);

        verifyEquals(customDataDownloadPage.tooltip.getText() ,"For more information on Programs, visit the Programs area of Clean Air Markets website.");

        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));



//  Check Facility Tip
        click(customDataDownloadPage.filtercriteria.get(3));

        waitFor(customDataDownloadPage.tooltipIcon);
        action.moveToElement(customDataDownloadPage.tooltipIcon);

        waitFor(customDataDownloadPage.tooltip);

        verifyEquals(customDataDownloadPage.tooltip.getText() ,"ORIS Code: Facility ID Code assigned by the U.S. Energy Information Administration. Also known as ORISPL or Plant ID Code.");

        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

// check Fuel Type Tip

        click(customDataDownloadPage.filtercriteria.get(5));

        waitFor(customDataDownloadPage.tooltipIcon);
        action.moveToElement(customDataDownloadPage.tooltipIcon);

        waitFor(customDataDownloadPage.tooltip);

        verifyEquals(customDataDownloadPage.tooltip.getText() ,"Selections made will filter on both primary and secondary fuel types.");

        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

// check Control Tech Tip
        click(customDataDownloadPage.filtercriteria.get(6));

        waitFor(customDataDownloadPage.tooltipIcon);
        action.moveToElement(customDataDownloadPage.tooltipIcon);

        waitFor(customDataDownloadPage.tooltip);

        verifyEquals(customDataDownloadPage.tooltip.getText() ,"Units may use one or more methods/equipment to minimize emissions of various pollutants. Methods under the “Other” category may be used to control multiple pollutants.");

        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

// Change to Monthly Emissions
        click(customDataDownloadPage.changebutton);

        click(customDataDownloadPage.subtypeDropdown);
        click(customDataDownloadPage.subtypeoption.get(3));

        click(customDataDownloadPage.applyBtn);

// apply date range
        waitFor(customDataDownloadPage.previewdata);

        click(customDataDownloadPage.filtercriteria.get(0));

        waitFor(customDataDownloadPage.yearinput);
        input(customDataDownloadPage.yearinput, "2015-2020");

        waitFor(customDataDownloadPage.label.get(1));
        click(customDataDownloadPage.label.get(1));

        waitFor(customDataDownloadPage.applyYear);
        click(customDataDownloadPage.applyYear.get(1));

        waitFor(customDataDownloadPage.previewdata);

// check Program Tool Tip
        click(customDataDownloadPage.filtercriteria.get(1));

        waitFor(customDataDownloadPage.tooltipIcon);
        action.moveToElement(customDataDownloadPage.tooltipIcon);

        waitFor(customDataDownloadPage.tooltip);

        verifyEquals(customDataDownloadPage.tooltip.getText() ,"For more information on Programs, visit the Programs area of Clean Air Markets website.");

        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));



//  Check Facility Tip
        click(customDataDownloadPage.filtercriteria.get(3));

        waitFor(customDataDownloadPage.tooltipIcon);
        action.moveToElement(customDataDownloadPage.tooltipIcon);

        waitFor(customDataDownloadPage.tooltip);

        verifyEquals(customDataDownloadPage.tooltip.getText() ,"ORIS Code: Facility ID Code assigned by the U.S. Energy Information Administration. Also known as ORISPL or Plant ID Code.");

        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

// check Fuel Type Tip

        click(customDataDownloadPage.filtercriteria.get(5));

        waitFor(customDataDownloadPage.tooltipIcon);
        action.moveToElement(customDataDownloadPage.tooltipIcon);

        waitFor(customDataDownloadPage.tooltip);

        verifyEquals(customDataDownloadPage.tooltip.getText() ,"Selections made will filter on both primary and secondary fuel types.");

        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

// check Control Tech Tip
        click(customDataDownloadPage.filtercriteria.get(6));

        waitFor(customDataDownloadPage.tooltipIcon);
        action.moveToElement(customDataDownloadPage.tooltipIcon);

        waitFor(customDataDownloadPage.tooltip);

        verifyEquals(customDataDownloadPage.tooltip.getText() ,"Units may use one or more methods/equipment to minimize emissions of various pollutants. Methods under the “Other” category may be used to control multiple pollutants.");

        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));
// Change to Quarterly Emissions
        click(customDataDownloadPage.changebutton);

        click(customDataDownloadPage.subtypeDropdown);
        click(customDataDownloadPage.subtypeoption.get(4));

        click(customDataDownloadPage.applyBtn);

// apply date range
        waitFor(customDataDownloadPage.previewdata);

        click(customDataDownloadPage.filtercriteria.get(0));

        waitFor(customDataDownloadPage.yearinput);
        input(customDataDownloadPage.yearinput, "2015-2020");

        waitFor(customDataDownloadPage.label.get(1));
        click(customDataDownloadPage.label.get(1));

        waitFor(customDataDownloadPage.applyYear);
        click(customDataDownloadPage.applyYear.get(1));



// check Program Tool Tip
        waitFor(customDataDownloadPage.previewdata);
        click(customDataDownloadPage.filtercriteria.get(1));

        waitFor(customDataDownloadPage.tooltipIcon);
        action.moveToElement(customDataDownloadPage.tooltipIcon);

        waitFor(customDataDownloadPage.tooltip);

        verifyEquals(customDataDownloadPage.tooltip.getText() ,"For more information on Programs, visit the Programs area of Clean Air Markets website.");

        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));



//  Check Facility Tip
        click(customDataDownloadPage.filtercriteria.get(3));

        waitFor(customDataDownloadPage.tooltipIcon);
        action.moveToElement(customDataDownloadPage.tooltipIcon);

        waitFor(customDataDownloadPage.tooltip);

        verifyEquals(customDataDownloadPage.tooltip.getText() ,"ORIS Code: Facility ID Code assigned by the U.S. Energy Information Administration. Also known as ORISPL or Plant ID Code.");

        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

// check Fuel Type Tip

        click(customDataDownloadPage.filtercriteria.get(5));

        waitFor(customDataDownloadPage.tooltipIcon);
        action.moveToElement(customDataDownloadPage.tooltipIcon);

        waitFor(customDataDownloadPage.tooltip);

        verifyEquals(customDataDownloadPage.tooltip.getText() ,"Selections made will filter on both primary and secondary fuel types.");

        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

// check Control Tech Tip
        click(customDataDownloadPage.filtercriteria.get(6));

        waitFor(customDataDownloadPage.tooltipIcon);
        action.moveToElement(customDataDownloadPage.tooltipIcon);

        waitFor(customDataDownloadPage.tooltip);

        verifyEquals(customDataDownloadPage.tooltip.getText() ,"Units may use one or more methods/equipment to minimize emissions of various pollutants. Methods under the “Other” category may be used to control multiple pollutants.");

        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));
// Change to Annual Emissions
        click(customDataDownloadPage.changebutton);

        click(customDataDownloadPage.subtypeDropdown);
        click(customDataDownloadPage.subtypeoption.get(6));

        click(customDataDownloadPage.applyBtn);

// apply date range
        waitFor(customDataDownloadPage.previewdata);

        click(customDataDownloadPage.filtercriteria.get(0));

        waitFor(customDataDownloadPage.yearinput);
        input(customDataDownloadPage.yearinput, "2015-2020");


        waitFor(customDataDownloadPage.applyYear);
        click(customDataDownloadPage.applyYear.get(1));

        waitFor(customDataDownloadPage.previewdata);

// check Program Tool Tip
        click(customDataDownloadPage.filtercriteria.get(1));

        waitFor(customDataDownloadPage.tooltipIcon);
        action.moveToElement(customDataDownloadPage.tooltipIcon);

        waitFor(customDataDownloadPage.tooltip);

        verifyEquals(customDataDownloadPage.tooltip.getText() ,"For more information on Programs, visit the Programs area of Clean Air Markets website.");

        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));



//  Check Facility Tip
        click(customDataDownloadPage.filtercriteria.get(3));

        waitFor(customDataDownloadPage.tooltipIcon);
        action.moveToElement(customDataDownloadPage.tooltipIcon);

        waitFor(customDataDownloadPage.tooltip);

        verifyEquals(customDataDownloadPage.tooltip.getText() ,"ORIS Code: Facility ID Code assigned by the U.S. Energy Information Administration. Also known as ORISPL or Plant ID Code.");

        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

// check Fuel Type Tip

        click(customDataDownloadPage.filtercriteria.get(5));

        waitFor(customDataDownloadPage.tooltipIcon);
        action.moveToElement(customDataDownloadPage.tooltipIcon);

        waitFor(customDataDownloadPage.tooltip);

        verifyEquals(customDataDownloadPage.tooltip.getText() ,"Selections made will filter on both primary and secondary fuel types.");

        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

// check Control Tech Tip
        click(customDataDownloadPage.filtercriteria.get(6));

        waitFor(customDataDownloadPage.tooltipIcon);
        action.moveToElement(customDataDownloadPage.tooltipIcon);

        waitFor(customDataDownloadPage.tooltip);

        verifyEquals(customDataDownloadPage.tooltip.getText() ,"Units may use one or more methods/equipment to minimize emissions of various pollutants. Methods under the “Other” category may be used to control multiple pollutants.");

        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));
// Change to Ozone Season Emissions
        click(customDataDownloadPage.changebutton);

        click(customDataDownloadPage.subtypeDropdown);
        click(customDataDownloadPage.subtypeoption.get(5));

        click(customDataDownloadPage.applyBtn);

// apply date range
        waitFor(customDataDownloadPage.previewdata);

        click(customDataDownloadPage.filtercriteria.get(0));

        waitFor(customDataDownloadPage.datetooltipIcon);
        action.moveToElement(customDataDownloadPage.datetooltipIcon);

        waitFor(customDataDownloadPage.tooltip);

        verifyEquals(customDataDownloadPage.tooltip.getText() ,"The Ozone Season is from May 1st – September 30th.");


        waitFor(customDataDownloadPage.yearinput);
        input(customDataDownloadPage.yearinput, "2015-2020");


        waitFor(customDataDownloadPage.applyYear);
        click(customDataDownloadPage.applyYear.get(1));

        waitFor(customDataDownloadPage.previewdata);

// check Program Tool Tip
        click(customDataDownloadPage.filtercriteria.get(1));

        waitFor(customDataDownloadPage.tooltipIcon);
        action.moveToElement(customDataDownloadPage.tooltipIcon);

        waitFor(customDataDownloadPage.tooltip);

        verifyEquals(customDataDownloadPage.tooltip.getText() ,"For more information on Programs, visit the Programs area of Clean Air Markets website.");

        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

//  Check Facility Tip
        click(customDataDownloadPage.filtercriteria.get(3));

        waitFor(customDataDownloadPage.tooltipIcon);
        action.moveToElement(customDataDownloadPage.tooltipIcon);

        waitFor(customDataDownloadPage.tooltip);

        verifyEquals(customDataDownloadPage.tooltip.getText() ,"ORIS Code: Facility ID Code assigned by the U.S. Energy Information Administration. Also known as ORISPL or Plant ID Code.");

        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

// check Fuel Type Tip

        click(customDataDownloadPage.filtercriteria.get(5));

        waitFor(customDataDownloadPage.tooltipIcon);
        action.moveToElement(customDataDownloadPage.tooltipIcon);

        waitFor(customDataDownloadPage.tooltip);

        verifyEquals(customDataDownloadPage.tooltip.getText() ,"Selections made will filter on both primary and secondary fuel types.");

        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

// check Control Tech Tip
        click(customDataDownloadPage.filtercriteria.get(6));

        waitFor(customDataDownloadPage.tooltipIcon);
        action.moveToElement(customDataDownloadPage.tooltipIcon);

        waitFor(customDataDownloadPage.tooltip);

        verifyEquals(customDataDownloadPage.tooltip.getText() ,"Units may use one or more methods/equipment to minimize emissions of various pollutants. Methods under the “Other” category may be used to control multiple pollutants.");

        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));
// Change to Facility/Attribute  Emissions
        click(customDataDownloadPage.changebutton);

        click(customDataDownloadPage.subtypeDropdown);
        click(customDataDownloadPage.subtypeoption.get(7));

        click(customDataDownloadPage.applyBtn);

// apply date range
        waitFor(customDataDownloadPage.previewdata);

        click(customDataDownloadPage.filtercriteria.get(0));


        waitFor(customDataDownloadPage.yearinput);
        input(customDataDownloadPage.yearinput, "2015-2020");


        waitFor(customDataDownloadPage.applyYear);
        click(customDataDownloadPage.applyYear.get(1));

        waitFor(customDataDownloadPage.previewdata);

// check Program Tool Tip
        click(customDataDownloadPage.filtercriteria.get(1));

        waitFor(customDataDownloadPage.tooltipIcon);
        action.moveToElement(customDataDownloadPage.tooltipIcon);

        waitFor(customDataDownloadPage.tooltip);

        verifyEquals(customDataDownloadPage.tooltip.getText() ,"For more information on Programs, visit the Programs area of Clean Air Markets website.");

        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

//  Check Facility Tip
        click(customDataDownloadPage.filtercriteria.get(3));

        waitFor(customDataDownloadPage.tooltipIcon);
        action.moveToElement(customDataDownloadPage.tooltipIcon);

        waitFor(customDataDownloadPage.tooltip);

        verifyEquals(customDataDownloadPage.tooltip.getText() ,"ORIS Code: Facility ID Code assigned by the U.S. Energy Information Administration. Also known as ORISPL or Plant ID Code.");

        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

// check Fuel Type Tip

        click(customDataDownloadPage.filtercriteria.get(5));

        waitFor(customDataDownloadPage.tooltipIcon);
        action.moveToElement(customDataDownloadPage.tooltipIcon);

        waitFor(customDataDownloadPage.tooltip);

        verifyEquals(customDataDownloadPage.tooltip.getText() ,"Selections made will filter on both primary and secondary fuel types.");

        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

// check Control Tech Tip
        click(customDataDownloadPage.filtercriteria.get(6));

        waitFor(customDataDownloadPage.tooltipIcon);
        action.moveToElement(customDataDownloadPage.tooltipIcon);

        waitFor(customDataDownloadPage.tooltip);

        verifyEquals(customDataDownloadPage.tooltip.getText() ,"Units may use one or more methods/equipment to minimize emissions of various pollutants. Methods under the “Other” category may be used to control multiple pollutants.");

        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));
//   // Change Allowance Data Type
        click(customDataDownloadPage.changebutton);
        waitFor(customDataDownloadPage.datadropdown);

        click(customDataDownloadPage.datadropdown);
        click(customDataDownloadPage.dataoption.get(2));

        click(customDataDownloadPage.subtypeDropdown);
        click(customDataDownloadPage.subtypeoption.get(1));

        jse.executeScript("scroll(0, 250);");

        click(customDataDownloadPage.applyBtn);

// check Program Tool Tip
        waitFor(customDataDownloadPage.previewdata);
        click(customDataDownloadPage.filtercriteria.get(0));

        waitFor(customDataDownloadPage.tooltipIcon);
        action.moveToElement(customDataDownloadPage.tooltipIcon);

        waitFor(customDataDownloadPage.tooltip);

        verifyEquals(customDataDownloadPage.tooltip.getText() ,"For more information on Programs, visit the Programs area of Clean Air Markets website.");

        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

//  Check Account Type Tip
        click(customDataDownloadPage.filtercriteria.get(1));

        waitFor(customDataDownloadPage.tooltipIcon);
        action.moveToElement(customDataDownloadPage.tooltipIcon);

        waitFor(customDataDownloadPage.tooltip);

        verifyEquals(customDataDownloadPage.tooltip.getText() ,"For more information on account types, use the Allowance Data Guide in the Tutorials section.");

        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

// check Account Number Tip

        click(customDataDownloadPage.filtercriteria.get(2));

        waitFor(customDataDownloadPage.tooltipIcon);
        action.moveToElement(customDataDownloadPage.tooltipIcon);

        waitFor(customDataDownloadPage.tooltip);

        verifyEquals(customDataDownloadPage.tooltip.getText() ,"For more information on account numbers, use the Allowance Data Guide in the Tutorials section.");

        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));
//  Check Facility Tip
        click(customDataDownloadPage.filtercriteria.get(3));

        waitFor(customDataDownloadPage.tooltipIcon);
        action.moveToElement(customDataDownloadPage.tooltipIcon);

        waitFor(customDataDownloadPage.tooltip);

        verifyEquals(customDataDownloadPage.tooltip.getText() ,"ORIS Code: Facility ID Code assigned by the U.S. Energy Information Administration. Also known as ORISPL or Plant ID Code.");

        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));


// check Owner Operator Tech Tip
        click(customDataDownloadPage.filtercriteria.get(4));

        waitFor(customDataDownloadPage.tooltipIcon);
        action.moveToElement(customDataDownloadPage.tooltipIcon);

        waitFor(customDataDownloadPage.tooltip);

        verifyEquals(customDataDownloadPage.tooltip.getText() ,"Search for one or more individuals/companies that own an allowance account.");

        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

// Change to Allownce - Holdings

        click(customDataDownloadPage.changebutton);


        click(customDataDownloadPage.subtypeDropdown);
        click(customDataDownloadPage.subtypeoption.get(2));

        click(customDataDownloadPage.applyBtn);

// check Program Tool Tip
        waitFor(customDataDownloadPage.previewdata);
        click(customDataDownloadPage.filtercriteria.get(0));

        waitFor(customDataDownloadPage.tooltipIcon);
        action.moveToElement(customDataDownloadPage.tooltipIcon);

        waitFor(customDataDownloadPage.tooltip);

        verifyEquals(customDataDownloadPage.tooltip.getText() ,"For more information on Programs, visit the Programs area of Clean Air Markets website.");

        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

//  Check Account Type Tip
        click(customDataDownloadPage.filtercriteria.get(1));

        waitFor(customDataDownloadPage.tooltipIcon);
        action.moveToElement(customDataDownloadPage.tooltipIcon);

        waitFor(customDataDownloadPage.tooltip);

        verifyEquals(customDataDownloadPage.tooltip.getText() ,"For more information on account types, use the Allowance Data Guide in the Tutorials section.");

        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

// check Account Number Tip

        click(customDataDownloadPage.filtercriteria.get(2));

        waitFor(customDataDownloadPage.tooltipIcon);
        action.moveToElement(customDataDownloadPage.tooltipIcon);

        waitFor(customDataDownloadPage.tooltip);

        verifyEquals(customDataDownloadPage.tooltip.getText() ,"For more information on account numbers, use the Allowance Data Guide in the Tutorials section.");

        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));
//  Check Facility Tip
        jse.executeScript("scroll(0, 250);");

        click(customDataDownloadPage.filtercriteria.get(3));

        waitFor(customDataDownloadPage.tooltipIcon);
        action.moveToElement(customDataDownloadPage.tooltipIcon);

        waitFor(customDataDownloadPage.tooltip);

        verifyEquals(customDataDownloadPage.tooltip.getText() ,"ORIS Code: Facility ID Code assigned by the U.S. Energy Information Administration. Also known as ORISPL or Plant ID Code.");

        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));


// check Owner Operator Tech Tip
        jse.executeScript("scroll(0, 250);");
        click(customDataDownloadPage.filtercriteria.get(4));

        waitFor(customDataDownloadPage.tooltipIcon);
        action.moveToElement(customDataDownloadPage.tooltipIcon);

        waitFor(customDataDownloadPage.tooltip);

        verifyEquals(customDataDownloadPage.tooltip.getText() ,"Search for one or more individuals/companies that own an allowance account.");

        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));
// check Vintage Tech Tip
        jse.executeScript("scroll(0, 500);");
        click(customDataDownloadPage.filtercriteria.get(6));

        waitFor(customDataDownloadPage.tooltipIcon);
        action.moveToElement(customDataDownloadPage.tooltipIcon);

        waitFor(customDataDownloadPage.tooltip);

        verifyEquals(customDataDownloadPage.tooltip.getText() ,"All allowances have an associated vintage year. This is the first year an allowance may be used in compliance. For more information on vintage years, use the Allowance Data Guide in the Tutorials section.");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

// Change to Allownce - Transactions

        click(customDataDownloadPage.changebutton);


        click(customDataDownloadPage.subtypeDropdown);
        click(customDataDownloadPage.subtypeoption.get(3));

        click(customDataDownloadPage.applyBtn);
        waitFor(customDataDownloadPage.previewdata);
        click(customDataDownloadPage.filtercriteria.get(0));

        waitFor(customDataDownloadPage.datetooltipIcon);
        action.moveToElement(customDataDownloadPage.datetooltipIcon);

        waitFor(customDataDownloadPage.tooltip);


        verifyEquals(customDataDownloadPage.tooltip.getText() ,"If using the keyboard to navigate the date picker and the escape key does not work, try using the Shift + Tab keys then the escape key.");

        waitFor(customDataDownloadPage.datestart);
        input(customDataDownloadPage.datestart, "01/01/2019");

        input(customDataDownloadPage.dateend, "01/01/2020");
        jse.executeScript("scroll(0, 500);");

        waitFor(customDataDownloadPage.applyYear);
        click(customDataDownloadPage.applyYear.get(1));


// check Program Tool Tip
        waitFor(customDataDownloadPage.previewdata);
        click(customDataDownloadPage.filtercriteria.get(1));

        waitFor(customDataDownloadPage.tooltipIcon);
        action.moveToElement(customDataDownloadPage.tooltipIcon);

        waitFor(customDataDownloadPage.tooltip);

        verifyEquals(customDataDownloadPage.tooltip.getText() ,"For more information on Programs, visit the Programs area of Clean Air Markets website.");
        jse.executeScript("scroll(0, 500);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

//  Check Account Type Tip
        click(customDataDownloadPage.filtercriteria.get(2));

        waitFor(customDataDownloadPage.tooltipIcon);
        action.moveToElement(customDataDownloadPage.tooltipIcon);

        waitFor(customDataDownloadPage.tooltip);

        verifyEquals(customDataDownloadPage.tooltip.getText() ,"For more information on account types, use the Allowance Data Guide in the Tutorials section.");

        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));

// check Account Number Tip

        click(customDataDownloadPage.filtercriteria.get(3));

        waitFor(customDataDownloadPage.tooltipIcon);
        action.moveToElement(customDataDownloadPage.tooltipIcon);

        waitFor(customDataDownloadPage.tooltip);

        verifyEquals(customDataDownloadPage.tooltip.getText() ,"For more information on account numbers, use the Allowance Data Guide in the Tutorials section.");

        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));
//  Check Facility Tip
        click(customDataDownloadPage.filtercriteria.get(4));

        waitFor(customDataDownloadPage.tooltipIcon);
        action.moveToElement(customDataDownloadPage.tooltipIcon);

        waitFor(customDataDownloadPage.tooltip);

        verifyEquals(customDataDownloadPage.tooltip.getText() ,"ORIS Code: Facility ID Code assigned by the U.S. Energy Information Administration. Also known as ORISPL or Plant ID Code.");

        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));


// check Owner Operator Tech Tip
        click(customDataDownloadPage.filtercriteria.get(5));

        waitFor(customDataDownloadPage.tooltipIcon);
        action.moveToElement(customDataDownloadPage.tooltipIcon);

        waitFor(customDataDownloadPage.tooltip);

        verifyEquals(customDataDownloadPage.tooltip.getText() ,"Search for one or more individuals/companies that own an allowance account.");

        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));
// check Vintage Tech Tip
        jse.executeScript("scroll(0, 500);");
        click(customDataDownloadPage.filtercriteria.get(7));

        waitFor(customDataDownloadPage.tooltipIcon);
        action.moveToElement(customDataDownloadPage.tooltipIcon);

        waitFor(customDataDownloadPage.tooltip);

        verifyEquals(customDataDownloadPage.tooltip.getText() ,"All allowances have an associated vintage year. This is the first year an allowance may be used in compliance. For more information on vintage years, use the Allowance Data Guide in the Tutorials section.");
        jse.executeScript("scroll(0, 500);");
        waitFor(customDataDownloadPage.cancelApply.get(0));
// check Transaction Type  Tip
//        jse.executeScript("scroll(0, 500);");
//        click(customDataDownloadPage.filtercriteria.get(8));
//
//        waitFor(customDataDownloadPage.tooltipIcon);
//        action.moveToElement(customDataDownloadPage.tooltipIcon);
//
//        waitFor(customDataDownloadPage.tooltip);
//
//        verifyEquals(customDataDownloadPage.tooltip.getText() ,"For more information on transaction types, use the Allowance Data Guide in the Tutorials section.");
//
//        waitFor(customDataDownloadPage.cancelApply.get(0));

 //Change to Compliance Data
        click(customDataDownloadPage.changebutton);
        waitFor(customDataDownloadPage.datadropdown);

        click(customDataDownloadPage.datadropdown);
        click(customDataDownloadPage.dataoption.get(3));

        click(customDataDownloadPage.subtypeDropdown);
        click(customDataDownloadPage.subtypeoption.get(1));

        jse.executeScript("scroll(0, 250);");

        click(customDataDownloadPage.applyBtn);
// Check Program tool Tip
        waitFor(customDataDownloadPage.previewdata);
        click(customDataDownloadPage.filtercriteria.get(0));

        waitFor(customDataDownloadPage.tooltipIcon);
        action.moveToElement(customDataDownloadPage.tooltipIcon);

        waitFor(customDataDownloadPage.tooltip);

        verifyEquals(customDataDownloadPage.tooltip.getText() ,"For more information on Programs, visit the Programs area of Clean Air Markets website.");

        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));
// Check Facility
        waitFor(customDataDownloadPage.previewdata);

        click(customDataDownloadPage.filtercriteria.get(1));

        waitFor(customDataDownloadPage.tooltipIcon);
        action.moveToElement(customDataDownloadPage.tooltipIcon);

        waitFor(customDataDownloadPage.tooltip);

        verifyEquals(customDataDownloadPage.tooltip.getText() ,"ORIS Code: Facility ID Code assigned by the U.S. Energy Information Administration. Also known as ORISPL or Plant ID Code.");

        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));
// Check Owner Op
        waitFor(customDataDownloadPage.previewdata);
        click(customDataDownloadPage.filtercriteria.get(2));

        waitFor(customDataDownloadPage.tooltipIcon);
        action.moveToElement(customDataDownloadPage.tooltipIcon);

        waitFor(customDataDownloadPage.tooltip);

        verifyEquals(customDataDownloadPage.tooltip.getText() ,"Select one or more companies that own and/or operate a unit using the drop down.");

        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));
// Check Year

        click(customDataDownloadPage.filtercriteria.get(4));

        waitFor(customDataDownloadPage.tooltipIcon);
        action.moveToElement(customDataDownloadPage.tooltipIcon);

        waitFor(customDataDownloadPage.tooltip);

        verifyEquals(customDataDownloadPage.tooltip.getText() ,"Compliance is assessed on an annual basis.");

        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));
// Change to Compliance Emissions Data
        click(customDataDownloadPage.changebutton);
        waitFor(customDataDownloadPage.datadropdown);

        click(customDataDownloadPage.subtypeDropdown);
        click(customDataDownloadPage.subtypeoption.get(2));

        jse.executeScript("scroll(0, 250);");

        click(customDataDownloadPage.applyBtn);


// Check Facility
        waitFor(customDataDownloadPage.previewdata);

        waitFor(customDataDownloadPage.filtercriteria.get(0));
        click(customDataDownloadPage.filtercriteria.get(0));

        waitFor(customDataDownloadPage.tooltipIcon);
        action.moveToElement(customDataDownloadPage.tooltipIcon);

        waitFor(customDataDownloadPage.tooltip);

        verifyEquals(customDataDownloadPage.tooltip.getText() ,"ORIS Code: Facility ID Code assigned by the U.S. Energy Information Administration. Also known as ORISPL or Plant ID Code.");

        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));
// Check Owner Op

        click(customDataDownloadPage.filtercriteria.get(1));

        waitFor(customDataDownloadPage.tooltipIcon);
        action.moveToElement(customDataDownloadPage.tooltipIcon);

        waitFor(customDataDownloadPage.tooltip);

        verifyEquals(customDataDownloadPage.tooltip.getText() ,"Select one or more companies that own and/or operate a unit using the drop down.");

        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));
// Check Year

        click(customDataDownloadPage.filtercriteria.get(3));

        waitFor(customDataDownloadPage.tooltipIcon);
        action.moveToElement(customDataDownloadPage.tooltipIcon);

        waitFor(customDataDownloadPage.tooltip);

        verifyEquals(customDataDownloadPage.tooltip.getText() ,"Compliance is assessed on an annual basis.");

        waitFor(customDataDownloadPage.cancelApply.get(0));
        click(customDataDownloadPage.cancelApply.get(0));
    }
}

