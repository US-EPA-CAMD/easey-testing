package tests.UITests.CAMPD;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.CampdElements;
import tests.utils.UITestBase;
import org.openqa.selenium.JavascriptExecutor;


public class TC_482_FilterToolTip extends UITestBase {
    @Test
    public void test() {
        goTo("https://campd-dev.app.cloud.gov/data/custom-data-download");
        Actions action = new Actions(driver);
        CampdElements campdElements = new CampdElements(driver);

        JavascriptExecutor jse = (JavascriptExecutor) driver;


        waitFor(campdElements.datadropdown);
        click(campdElements.datadropdown);

        waitFor(campdElements.dataoption.get(1));
        click(campdElements.dataoption.get(1));

        waitFor(campdElements.subtypeDropdown);
        click(campdElements.subtypeDropdown);

        waitFor(campdElements.subtypeoption.get(1));
        click(campdElements.subtypeoption.get(1));
//Select HourlyEmissions Subtype

        waitFor(campdElements.subtypeDropdown);
        click(campdElements.subtypeDropdown);

        waitFor(campdElements.subtypeoption.get(1));
        click(campdElements.subtypeoption.get(1));

        jse.executeScript("scroll(0, 500);");
        waitFor(campdElements.applyBtn);
        click(campdElements.applyBtn);


// apply date range
        waitFor(campdElements.previewdata);
        click(campdElements.filtercriteria.get(0));

        waitFor(campdElements.datetooltipIcon);
        action.moveToElement(campdElements.datetooltipIcon);

        waitFor(campdElements.tooltip);


        verifyEquals(campdElements.tooltip.getText() ,"If using the keyboard to navigate the date picker and the escape key does not work, try using the Shift + Tab keys then the escape key.");

        waitFor(campdElements.datestart);
        input(campdElements.datestart, "01/01/2019");

        input(campdElements.dateend, "01/01/2020");
        jse.executeScript("scroll(0, 500);");

//        waitFor(customDataDownloadPage.hourlytooltipIcon);
//        action.moveToElement(customDataDownloadPage.hourlytooltipIcon);
//        verifyEquals(customDataDownloadPage.tooltip.getText() ,"When checked, only hours in a day during which a unit is operational are included in the data output.");

        waitFor(campdElements.applyYear.get(1));
        click(campdElements.applyYear.get(1));

        waitFor(campdElements.previewdata);

// check Program Tool Tip
        click(campdElements.filtercriteria.get(1));

        waitFor(campdElements.tooltipIcon);
        action.moveToElement(campdElements.tooltipIcon);

        waitFor(campdElements.tooltip);

        verifyEquals(campdElements.tooltip.getText() ,"For more information on Programs, visit the Programs area of Clean Air Markets website.");

        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));



//  Check Facility Tip
        click(campdElements.filtercriteria.get(3));

        waitFor(campdElements.tooltipIcon);
        action.moveToElement(campdElements.tooltipIcon);

        waitFor(campdElements.tooltip);

        verifyEquals(campdElements.tooltip.getText() ,"ORIS Code: Facility ID Code assigned by the U.S. Energy Information Administration. Also known as ORISPL or Plant ID Code.");

        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));

// check Fuel Type Tip

        click(campdElements.filtercriteria.get(5));

        waitFor(campdElements.tooltipIcon);
        action.moveToElement(campdElements.tooltipIcon);

        waitFor(campdElements.tooltip);

        verifyEquals(campdElements.tooltip.getText() ,"Selections made will filter on both primary and secondary fuel types.");

        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));

// check Control Tech Tip
        click(campdElements.filtercriteria.get(6));

        waitFor(campdElements.tooltipIcon);
        action.moveToElement(campdElements.tooltipIcon);

        waitFor(campdElements.tooltip);

        verifyEquals(campdElements.tooltip.getText() ,"Units may use one or more methods/equipment to minimize emissions of various pollutants. Methods under the “Other” category may be used to control multiple pollutants.");

        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));

 // Change to Daily Emissions
        click(campdElements.changebutton);

        click(campdElements.subtypeDropdown);
        click(campdElements.subtypeoption.get(2));

        click(campdElements.applyBtn);

// apply date range

        click(campdElements.filtercriteria.get(0));

        waitFor(campdElements.datetooltipIcon);
        action.moveToElement(campdElements.datetooltipIcon);

        waitFor(campdElements.tooltip);


        verifyEquals(campdElements.tooltip.getText() ,"If using the keyboard to navigate the date picker and the escape key does not work, try using the Shift + Tab keys then the escape key.");

        waitFor(campdElements.datestart);
        input(campdElements.datestart, "01/01/2019");

        input(campdElements.dateend, "01/01/2020");
        jse.executeScript("scroll(0, 500);");


        waitFor(campdElements.applyYear.get(1));
        click(campdElements.applyYear.get(1));

        waitFor(campdElements.previewdata);

// check Program Tool Tip
        click(campdElements.filtercriteria.get(1));

        waitFor(campdElements.tooltipIcon);
        action.moveToElement(campdElements.tooltipIcon);

        waitFor(campdElements.tooltip);

        verifyEquals(campdElements.tooltip.getText() ,"For more information on Programs, visit the Programs area of Clean Air Markets website.");

        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));



//  Check Facility Tip
        click(campdElements.filtercriteria.get(3));

        waitFor(campdElements.tooltipIcon);
        action.moveToElement(campdElements.tooltipIcon);

        waitFor(campdElements.tooltip);

        verifyEquals(campdElements.tooltip.getText() ,"ORIS Code: Facility ID Code assigned by the U.S. Energy Information Administration. Also known as ORISPL or Plant ID Code.");

        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));

// check Fuel Type Tip

        click(campdElements.filtercriteria.get(5));

        waitFor(campdElements.tooltipIcon);
        action.moveToElement(campdElements.tooltipIcon);

        waitFor(campdElements.tooltip);

        verifyEquals(campdElements.tooltip.getText() ,"Selections made will filter on both primary and secondary fuel types.");

        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));

// check Control Tech Tip
        click(campdElements.filtercriteria.get(6));

        waitFor(campdElements.tooltipIcon);
        action.moveToElement(campdElements.tooltipIcon);

        waitFor(campdElements.tooltip);

        verifyEquals(campdElements.tooltip.getText() ,"Units may use one or more methods/equipment to minimize emissions of various pollutants. Methods under the “Other” category may be used to control multiple pollutants.");

        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));

// Change to Monthly Emissions
        click(campdElements.changebutton);

        click(campdElements.subtypeDropdown);
        click(campdElements.subtypeoption.get(3));

        click(campdElements.applyBtn);

// apply date range
        waitFor(campdElements.previewdata);

        click(campdElements.filtercriteria.get(0));

        waitFor(campdElements.yearinput);
        input(campdElements.yearinput, "2015-2020");

        waitFor(campdElements.label.get(1));
        click(campdElements.label.get(1));

        waitFor(campdElements.applyYear);
        click(campdElements.applyYear.get(1));

        waitFor(campdElements.previewdata);

// check Program Tool Tip
        click(campdElements.filtercriteria.get(1));

        waitFor(campdElements.tooltipIcon);
        action.moveToElement(campdElements.tooltipIcon);

        waitFor(campdElements.tooltip);

        verifyEquals(campdElements.tooltip.getText() ,"For more information on Programs, visit the Programs area of Clean Air Markets website.");

        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));



//  Check Facility Tip
        click(campdElements.filtercriteria.get(3));

        waitFor(campdElements.tooltipIcon);
        action.moveToElement(campdElements.tooltipIcon);

        waitFor(campdElements.tooltip);

        verifyEquals(campdElements.tooltip.getText() ,"ORIS Code: Facility ID Code assigned by the U.S. Energy Information Administration. Also known as ORISPL or Plant ID Code.");

        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));

// check Fuel Type Tip

        click(campdElements.filtercriteria.get(5));

        waitFor(campdElements.tooltipIcon);
        action.moveToElement(campdElements.tooltipIcon);

        waitFor(campdElements.tooltip);

        verifyEquals(campdElements.tooltip.getText() ,"Selections made will filter on both primary and secondary fuel types.");

        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));

// check Control Tech Tip
        click(campdElements.filtercriteria.get(6));

        waitFor(campdElements.tooltipIcon);
        action.moveToElement(campdElements.tooltipIcon);

        waitFor(campdElements.tooltip);

        verifyEquals(campdElements.tooltip.getText() ,"Units may use one or more methods/equipment to minimize emissions of various pollutants. Methods under the “Other” category may be used to control multiple pollutants.");

        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));
// Change to Quarterly Emissions
        click(campdElements.changebutton);

        click(campdElements.subtypeDropdown);
        click(campdElements.subtypeoption.get(4));

        click(campdElements.applyBtn);

// apply date range
        waitFor(campdElements.previewdata);

        click(campdElements.filtercriteria.get(0));

        waitFor(campdElements.yearinput);
        input(campdElements.yearinput, "2015-2020");

        waitFor(campdElements.label.get(1));
        click(campdElements.label.get(1));

        waitFor(campdElements.applyYear);
        click(campdElements.applyYear.get(1));



// check Program Tool Tip
        waitFor(campdElements.previewdata);
        click(campdElements.filtercriteria.get(1));

        waitFor(campdElements.tooltipIcon);
        action.moveToElement(campdElements.tooltipIcon);

        waitFor(campdElements.tooltip);

        verifyEquals(campdElements.tooltip.getText() ,"For more information on Programs, visit the Programs area of Clean Air Markets website.");

        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));



//  Check Facility Tip
        click(campdElements.filtercriteria.get(3));

        waitFor(campdElements.tooltipIcon);
        action.moveToElement(campdElements.tooltipIcon);

        waitFor(campdElements.tooltip);

        verifyEquals(campdElements.tooltip.getText() ,"ORIS Code: Facility ID Code assigned by the U.S. Energy Information Administration. Also known as ORISPL or Plant ID Code.");

        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));

// check Fuel Type Tip

        click(campdElements.filtercriteria.get(5));

        waitFor(campdElements.tooltipIcon);
        action.moveToElement(campdElements.tooltipIcon);

        waitFor(campdElements.tooltip);

        verifyEquals(campdElements.tooltip.getText() ,"Selections made will filter on both primary and secondary fuel types.");

        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));

// check Control Tech Tip
        click(campdElements.filtercriteria.get(6));

        waitFor(campdElements.tooltipIcon);
        action.moveToElement(campdElements.tooltipIcon);

        waitFor(campdElements.tooltip);

        verifyEquals(campdElements.tooltip.getText() ,"Units may use one or more methods/equipment to minimize emissions of various pollutants. Methods under the “Other” category may be used to control multiple pollutants.");

        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));
// Change to Annual Emissions
        click(campdElements.changebutton);

        click(campdElements.subtypeDropdown);
        click(campdElements.subtypeoption.get(6));

        click(campdElements.applyBtn);

// apply date range
        waitFor(campdElements.previewdata);

        click(campdElements.filtercriteria.get(0));

        waitFor(campdElements.yearinput);
        input(campdElements.yearinput, "2015-2020");


        waitFor(campdElements.applyYear);
        click(campdElements.applyYear.get(1));

        waitFor(campdElements.previewdata);

// check Program Tool Tip
        click(campdElements.filtercriteria.get(1));

        waitFor(campdElements.tooltipIcon);
        action.moveToElement(campdElements.tooltipIcon);

        waitFor(campdElements.tooltip);

        verifyEquals(campdElements.tooltip.getText() ,"For more information on Programs, visit the Programs area of Clean Air Markets website.");

        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));



//  Check Facility Tip
        click(campdElements.filtercriteria.get(3));

        waitFor(campdElements.tooltipIcon);
        action.moveToElement(campdElements.tooltipIcon);

        waitFor(campdElements.tooltip);

        verifyEquals(campdElements.tooltip.getText() ,"ORIS Code: Facility ID Code assigned by the U.S. Energy Information Administration. Also known as ORISPL or Plant ID Code.");

        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));

// check Fuel Type Tip

        click(campdElements.filtercriteria.get(5));

        waitFor(campdElements.tooltipIcon);
        action.moveToElement(campdElements.tooltipIcon);

        waitFor(campdElements.tooltip);

        verifyEquals(campdElements.tooltip.getText() ,"Selections made will filter on both primary and secondary fuel types.");

        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));

// check Control Tech Tip
        click(campdElements.filtercriteria.get(6));

        waitFor(campdElements.tooltipIcon);
        action.moveToElement(campdElements.tooltipIcon);

        waitFor(campdElements.tooltip);

        verifyEquals(campdElements.tooltip.getText() ,"Units may use one or more methods/equipment to minimize emissions of various pollutants. Methods under the “Other” category may be used to control multiple pollutants.");

        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));
// Change to Ozone Season Emissions
        click(campdElements.changebutton);

        click(campdElements.subtypeDropdown);
        click(campdElements.subtypeoption.get(5));

        click(campdElements.applyBtn);

// apply date range
        waitFor(campdElements.previewdata);

        click(campdElements.filtercriteria.get(0));

        waitFor(campdElements.datetooltipIcon);
        action.moveToElement(campdElements.datetooltipIcon);

        waitFor(campdElements.tooltip);

        verifyEquals(campdElements.tooltip.getText() ,"The Ozone Season is from May 1st – September 30th.");


        waitFor(campdElements.yearinput);
        input(campdElements.yearinput, "2015-2020");


        waitFor(campdElements.applyYear);
        click(campdElements.applyYear.get(1));

        waitFor(campdElements.previewdata);

// check Program Tool Tip
        click(campdElements.filtercriteria.get(1));

        waitFor(campdElements.tooltipIcon);
        action.moveToElement(campdElements.tooltipIcon);

        waitFor(campdElements.tooltip);

        verifyEquals(campdElements.tooltip.getText() ,"For more information on Programs, visit the Programs area of Clean Air Markets website.");

        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));

//  Check Facility Tip
        click(campdElements.filtercriteria.get(3));

        waitFor(campdElements.tooltipIcon);
        action.moveToElement(campdElements.tooltipIcon);

        waitFor(campdElements.tooltip);

        verifyEquals(campdElements.tooltip.getText() ,"ORIS Code: Facility ID Code assigned by the U.S. Energy Information Administration. Also known as ORISPL or Plant ID Code.");

        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));

// check Fuel Type Tip

        click(campdElements.filtercriteria.get(5));

        waitFor(campdElements.tooltipIcon);
        action.moveToElement(campdElements.tooltipIcon);

        waitFor(campdElements.tooltip);

        verifyEquals(campdElements.tooltip.getText() ,"Selections made will filter on both primary and secondary fuel types.");

        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));

// check Control Tech Tip
        click(campdElements.filtercriteria.get(6));

        waitFor(campdElements.tooltipIcon);
        action.moveToElement(campdElements.tooltipIcon);

        waitFor(campdElements.tooltip);

        verifyEquals(campdElements.tooltip.getText() ,"Units may use one or more methods/equipment to minimize emissions of various pollutants. Methods under the “Other” category may be used to control multiple pollutants.");

        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));
// Change to Facility/Attribute  Emissions
        click(campdElements.changebutton);

        click(campdElements.subtypeDropdown);
        click(campdElements.subtypeoption.get(7));

        click(campdElements.applyBtn);

// apply date range
        waitFor(campdElements.previewdata);

        click(campdElements.filtercriteria.get(0));


        waitFor(campdElements.yearinput);
        input(campdElements.yearinput, "2015-2020");


        waitFor(campdElements.applyYear);
        click(campdElements.applyYear.get(1));

        waitFor(campdElements.previewdata);

// check Program Tool Tip
        click(campdElements.filtercriteria.get(1));

        waitFor(campdElements.tooltipIcon);
        action.moveToElement(campdElements.tooltipIcon);

        waitFor(campdElements.tooltip);

        verifyEquals(campdElements.tooltip.getText() ,"For more information on Programs, visit the Programs area of Clean Air Markets website.");

        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));

//  Check Facility Tip
        click(campdElements.filtercriteria.get(3));

        waitFor(campdElements.tooltipIcon);
        action.moveToElement(campdElements.tooltipIcon);

        waitFor(campdElements.tooltip);

        verifyEquals(campdElements.tooltip.getText() ,"ORIS Code: Facility ID Code assigned by the U.S. Energy Information Administration. Also known as ORISPL or Plant ID Code.");

        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));

// check Fuel Type Tip

        click(campdElements.filtercriteria.get(5));

        waitFor(campdElements.tooltipIcon);
        action.moveToElement(campdElements.tooltipIcon);

        waitFor(campdElements.tooltip);

        verifyEquals(campdElements.tooltip.getText() ,"Selections made will filter on both primary and secondary fuel types.");

        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));

// check Control Tech Tip
        click(campdElements.filtercriteria.get(6));

        waitFor(campdElements.tooltipIcon);
        action.moveToElement(campdElements.tooltipIcon);

        waitFor(campdElements.tooltip);

        verifyEquals(campdElements.tooltip.getText() ,"Units may use one or more methods/equipment to minimize emissions of various pollutants. Methods under the “Other” category may be used to control multiple pollutants.");

        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));
//   // Change Allowance Data Type
        click(campdElements.changebutton);
        waitFor(campdElements.datadropdown);

        click(campdElements.datadropdown);
        click(campdElements.dataoption.get(2));

        click(campdElements.subtypeDropdown);
        click(campdElements.subtypeoption.get(1));

        jse.executeScript("scroll(0, 250);");

        click(campdElements.applyBtn);

// check Program Tool Tip
        waitFor(campdElements.previewdata);
        click(campdElements.filtercriteria.get(0));

        waitFor(campdElements.tooltipIcon);
        action.moveToElement(campdElements.tooltipIcon);

        waitFor(campdElements.tooltip);

        verifyEquals(campdElements.tooltip.getText() ,"For more information on Programs, visit the Programs area of Clean Air Markets website.");

        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));

//  Check Account Type Tip
        click(campdElements.filtercriteria.get(1));

        waitFor(campdElements.tooltipIcon);
        action.moveToElement(campdElements.tooltipIcon);

        waitFor(campdElements.tooltip);

        verifyEquals(campdElements.tooltip.getText() ,"For more information on account types, use the Allowance Data Guide in the Tutorials section.");

        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));

// check Account Number Tip

        click(campdElements.filtercriteria.get(2));

        waitFor(campdElements.tooltipIcon);
        action.moveToElement(campdElements.tooltipIcon);

        waitFor(campdElements.tooltip);

        verifyEquals(campdElements.tooltip.getText() ,"For more information on account numbers, use the Allowance Data Guide in the Tutorials section.");

        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));
//  Check Facility Tip
        click(campdElements.filtercriteria.get(3));

        waitFor(campdElements.tooltipIcon);
        action.moveToElement(campdElements.tooltipIcon);

        waitFor(campdElements.tooltip);

        verifyEquals(campdElements.tooltip.getText() ,"ORIS Code: Facility ID Code assigned by the U.S. Energy Information Administration. Also known as ORISPL or Plant ID Code.");

        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));


// check Owner Operator Tech Tip
        click(campdElements.filtercriteria.get(4));

        waitFor(campdElements.tooltipIcon);
        action.moveToElement(campdElements.tooltipIcon);

        waitFor(campdElements.tooltip);

        verifyEquals(campdElements.tooltip.getText() ,"Search for one or more individuals/companies that own an allowance account.");

        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));

// Change to Allownce - Holdings

        click(campdElements.changebutton);


        click(campdElements.subtypeDropdown);
        click(campdElements.subtypeoption.get(2));

        click(campdElements.applyBtn);

// check Program Tool Tip
        waitFor(campdElements.previewdata);
        click(campdElements.filtercriteria.get(0));

        waitFor(campdElements.tooltipIcon);
        action.moveToElement(campdElements.tooltipIcon);

        waitFor(campdElements.tooltip);

        verifyEquals(campdElements.tooltip.getText() ,"For more information on Programs, visit the Programs area of Clean Air Markets website.");

        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));

//  Check Account Type Tip
        click(campdElements.filtercriteria.get(1));

        waitFor(campdElements.tooltipIcon);
        action.moveToElement(campdElements.tooltipIcon);

        waitFor(campdElements.tooltip);

        verifyEquals(campdElements.tooltip.getText() ,"For more information on account types, use the Allowance Data Guide in the Tutorials section.");

        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));

// check Account Number Tip

        click(campdElements.filtercriteria.get(2));

        waitFor(campdElements.tooltipIcon);
        action.moveToElement(campdElements.tooltipIcon);

        waitFor(campdElements.tooltip);

        verifyEquals(campdElements.tooltip.getText() ,"For more information on account numbers, use the Allowance Data Guide in the Tutorials section.");

        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));
//  Check Facility Tip
        jse.executeScript("scroll(0, 250);");

        click(campdElements.filtercriteria.get(3));

        waitFor(campdElements.tooltipIcon);
        action.moveToElement(campdElements.tooltipIcon);

        waitFor(campdElements.tooltip);

        verifyEquals(campdElements.tooltip.getText() ,"ORIS Code: Facility ID Code assigned by the U.S. Energy Information Administration. Also known as ORISPL or Plant ID Code.");

        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));


// check Owner Operator Tech Tip
        jse.executeScript("scroll(0, 250);");
        click(campdElements.filtercriteria.get(4));

        waitFor(campdElements.tooltipIcon);
        action.moveToElement(campdElements.tooltipIcon);

        waitFor(campdElements.tooltip);

        verifyEquals(campdElements.tooltip.getText() ,"Search for one or more individuals/companies that own an allowance account.");

        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));
// check Vintage Tech Tip
        jse.executeScript("scroll(0, 500);");
        click(campdElements.filtercriteria.get(6));

        waitFor(campdElements.tooltipIcon);
        action.moveToElement(campdElements.tooltipIcon);

        waitFor(campdElements.tooltip);

        verifyEquals(campdElements.tooltip.getText() ,"All allowances have an associated vintage year. This is the first year an allowance may be used in compliance. For more information on vintage years, use the Allowance Data Guide in the Tutorials section.");
        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));

// Change to Allownce - Transactions

        click(campdElements.changebutton);


        click(campdElements.subtypeDropdown);
        click(campdElements.subtypeoption.get(3));

        click(campdElements.applyBtn);
        waitFor(campdElements.previewdata);
        click(campdElements.filtercriteria.get(0));

        waitFor(campdElements.datetooltipIcon);
        action.moveToElement(campdElements.datetooltipIcon);

        waitFor(campdElements.tooltip);


        verifyEquals(campdElements.tooltip.getText() ,"If using the keyboard to navigate the date picker and the escape key does not work, try using the Shift + Tab keys then the escape key.");

        waitFor(campdElements.datestart);
        input(campdElements.datestart, "01/01/2019");

        input(campdElements.dateend, "01/01/2020");
        jse.executeScript("scroll(0, 500);");

        waitFor(campdElements.applyYear);
        click(campdElements.applyYear.get(1));


// check Program Tool Tip
        waitFor(campdElements.previewdata);
        click(campdElements.filtercriteria.get(1));

        waitFor(campdElements.tooltipIcon);
        action.moveToElement(campdElements.tooltipIcon);

        waitFor(campdElements.tooltip);

        verifyEquals(campdElements.tooltip.getText() ,"For more information on Programs, visit the Programs area of Clean Air Markets website.");
        jse.executeScript("scroll(0, 500);");
        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));

//  Check Account Type Tip
        click(campdElements.filtercriteria.get(2));

        waitFor(campdElements.tooltipIcon);
        action.moveToElement(campdElements.tooltipIcon);

        waitFor(campdElements.tooltip);

        verifyEquals(campdElements.tooltip.getText() ,"For more information on account types, use the Allowance Data Guide in the Tutorials section.");

        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));

// check Account Number Tip

        click(campdElements.filtercriteria.get(3));

        waitFor(campdElements.tooltipIcon);
        action.moveToElement(campdElements.tooltipIcon);

        waitFor(campdElements.tooltip);

        verifyEquals(campdElements.tooltip.getText() ,"For more information on account numbers, use the Allowance Data Guide in the Tutorials section.");

        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));
//  Check Facility Tip
        click(campdElements.filtercriteria.get(4));

        waitFor(campdElements.tooltipIcon);
        action.moveToElement(campdElements.tooltipIcon);

        waitFor(campdElements.tooltip);

        verifyEquals(campdElements.tooltip.getText() ,"ORIS Code: Facility ID Code assigned by the U.S. Energy Information Administration. Also known as ORISPL or Plant ID Code.");

        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));


// check Owner Operator Tech Tip
        click(campdElements.filtercriteria.get(5));

        waitFor(campdElements.tooltipIcon);
        action.moveToElement(campdElements.tooltipIcon);

        waitFor(campdElements.tooltip);

        verifyEquals(campdElements.tooltip.getText() ,"Search for one or more individuals/companies that own an allowance account.");

        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));
// check Vintage Tech Tip
        jse.executeScript("scroll(0, 500);");
        click(campdElements.filtercriteria.get(7));

        waitFor(campdElements.tooltipIcon);
        action.moveToElement(campdElements.tooltipIcon);

        waitFor(campdElements.tooltip);

        verifyEquals(campdElements.tooltip.getText() ,"All allowances have an associated vintage year. This is the first year an allowance may be used in compliance. For more information on vintage years, use the Allowance Data Guide in the Tutorials section.");
        jse.executeScript("scroll(0, 500);");
        waitFor(campdElements.cancelApply.get(0));
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
        click(campdElements.changebutton);
        waitFor(campdElements.datadropdown);

        click(campdElements.datadropdown);
        click(campdElements.dataoption.get(3));

        click(campdElements.subtypeDropdown);
        click(campdElements.subtypeoption.get(1));

        jse.executeScript("scroll(0, 250);");

        click(campdElements.applyBtn);
// Check Program tool Tip
        waitFor(campdElements.previewdata);
        click(campdElements.filtercriteria.get(0));

        waitFor(campdElements.tooltipIcon);
        action.moveToElement(campdElements.tooltipIcon);

        waitFor(campdElements.tooltip);

        verifyEquals(campdElements.tooltip.getText() ,"For more information on Programs, visit the Programs area of Clean Air Markets website.");

        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));
// Check Facility
        waitFor(campdElements.previewdata);

        click(campdElements.filtercriteria.get(1));

        waitFor(campdElements.tooltipIcon);
        action.moveToElement(campdElements.tooltipIcon);

        waitFor(campdElements.tooltip);

        verifyEquals(campdElements.tooltip.getText() ,"ORIS Code: Facility ID Code assigned by the U.S. Energy Information Administration. Also known as ORISPL or Plant ID Code.");

        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));
// Check Owner Op
        waitFor(campdElements.previewdata);
        click(campdElements.filtercriteria.get(2));

        waitFor(campdElements.tooltipIcon);
        action.moveToElement(campdElements.tooltipIcon);

        waitFor(campdElements.tooltip);

        verifyEquals(campdElements.tooltip.getText() ,"Select one or more companies that own and/or operate a unit using the drop down.");

        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));
// Check Year

        click(campdElements.filtercriteria.get(4));

        waitFor(campdElements.tooltipIcon);
        action.moveToElement(campdElements.tooltipIcon);

        waitFor(campdElements.tooltip);

        verifyEquals(campdElements.tooltip.getText() ,"Compliance is assessed on an annual basis.");

        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));
// Change to Compliance Emissions Data
        click(campdElements.changebutton);
        waitFor(campdElements.datadropdown);

        click(campdElements.subtypeDropdown);
        click(campdElements.subtypeoption.get(2));

        jse.executeScript("scroll(0, 250);");

        click(campdElements.applyBtn);


// Check Facility
        waitFor(campdElements.previewdata);

        waitFor(campdElements.filtercriteria.get(0));
        click(campdElements.filtercriteria.get(0));

        waitFor(campdElements.tooltipIcon);
        action.moveToElement(campdElements.tooltipIcon);

        waitFor(campdElements.tooltip);

        verifyEquals(campdElements.tooltip.getText() ,"ORIS Code: Facility ID Code assigned by the U.S. Energy Information Administration. Also known as ORISPL or Plant ID Code.");

        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));
// Check Owner Op

        click(campdElements.filtercriteria.get(1));

        waitFor(campdElements.tooltipIcon);
        action.moveToElement(campdElements.tooltipIcon);

        waitFor(campdElements.tooltip);

        verifyEquals(campdElements.tooltip.getText() ,"Select one or more companies that own and/or operate a unit using the drop down.");

        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));
// Check Year

        click(campdElements.filtercriteria.get(3));

        waitFor(campdElements.tooltipIcon);
        action.moveToElement(campdElements.tooltipIcon);

        waitFor(campdElements.tooltip);

        verifyEquals(campdElements.tooltip.getText() ,"Compliance is assessed on an annual basis.");

        waitFor(campdElements.cancelApply.get(0));
        click(campdElements.cancelApply.get(0));
    }
}

