package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MonitoringPlansPage extends HeaderFooterAndHomePage {

    public MonitoringPlansPage(WebDriver driver) { super(driver); }

    @FindBy(css = "table.usa-table.usa-table--borderless")
    public WebElement table;

    @FindBy(css = "h2[epa-testid='monPlansTitle']")
    public WebElement title;

    @FindBy(css = "span[class='font-body-lg']")
    public WebElement titleOfFacilityInConfig;

    @FindBy(css = "div.tabContent > div > div > div > div > header > div > div")
    public WebElement selectConfigurationsLabel;

    @FindBy(css = "button[aria-label='open Select Configurations tab']")
    public WebElement selectConfigurationsButton;

    @FindBy(css = "ul.usa-button-group.usa-button-group--segmented > li")
    public List<WebElement> tabs;

    @FindBy(css = "div.selectedMPTab.padding-top-4 > div > div > h2")
    public WebElement facilityTitle;

    @FindBy(css = "div[data-testid='checkbox']")
    public WebElement showInactiveCheckbox;

    @FindBy(css = "label[for='checkbox']")
    public WebElement showInactiveLabel;

    @FindBy(css = "optgroup > option")
    public List<WebElement> configurationsField;

    @FindBy(css = "div.configurations-container > div > div > select")
    public WebElement configurationsDropdown;

    @FindBy(css = "#\\33")
    public WebElement inactiveConfigurations;

    @FindBy(id = "Locations")
    public WebElement locationsField;

    @FindBy(css = "select[data-testid='Locations'] > option")
    public List<WebElement> location;

    @FindBy (id = "Sections")
    public WebElement sectionsDropdown;

    @FindBy (css = "option[data-testid='Methods']")
    public WebElement monitoringMethods;

    @FindBy (id = "create-method-add-btn")
    public WebElement createMonMethodsButton;

    @FindBy (id = "column-col1")
    public WebElement monMethodsTableParameterLabel;

    // A better locator is needed
    @FindBy (css = "div[data-tag='allowRowEvents'] > div")
    public List<WebElement> monMethodsTableParameterField;

    @FindBy (css = "#Parameter > option")
    public List<WebElement> monMethodsModalParameterDropdown;

    @FindBy (css = "#Methodology > option")
    public List<WebElement> monMethodsModalMethodologyDropdown;

    @FindBy (css = "option[data-testid='Systems']")
    public WebElement monitoringSystems;

    @FindBy (css = "#column-col2")
    public WebElement monitoringSystemTypeTableLabel;

    @FindBy (css = "div[class='sc-jrQzAO fyPxqe rdt_TableRow'] > div:nth-child(2) > div")
    public WebElement monitoringSystemTypeTableField;

    @FindBy (css = "select[epadataname='systemTypeCode']")
    public WebElement monitoringSystemTypeModalField;

    @FindBy (css = "select[epadataname='systemTypeCode'] > option")
    public List<WebElement> monitoringSystemTypeModalDropdown;

    @FindBy (id = "System ID")
    public WebElement createMonSystemsSysIdField;

    @FindBy (id = "create-system-add-btn")
    public WebElement createMonSystemsButton;

    @FindBy (css = "option[data-testid='Defaults']")
    public WebElement monitoringDefaults;

    @FindBy (id = "create-default-add-btn")
    public WebElement createDefaultButton;

    @FindBy (id = "column-col1")
    public WebElement defaultsTableParameterCodeLabel;

    @FindBy (css = "div[role='row']:nth-child(1) > div[data-tag='allowRowEvents'] > div")
    public List<WebElement> defaultsTableParameterCodeField;

    @FindBy (id = "Default Value")
    public WebElement defaultValueModalField;

    @FindBy (css = "option[data-testid='Formulas']")
    public WebElement monitoringFormulas;

    @FindBy (id = "Formula ID")
    public WebElement monitoringFormulasIdField;

    @FindBy (id = "create-formula-add-btn")
    public WebElement createFormulaButton;

    @FindBy (css = "option[data-testid='Loads']")
    public WebElement monitoringLoads;

    @FindBy (css = "option[data-testid='Location Attributes and Relationships']")
    public WebElement monitoringLocationAttributesAndRelationships ;

    @FindBy (css = "option[data-testid='Qualifications']")
    public WebElement monitoringQualifications ;

    @FindBy (css = "option[data-testid='Rectangular Duct WAFs']")
    public WebElement monitoringRectangularDuctWAFs;

    @FindBy (css = "option[data-testid='Spans']")
    public WebElement monitoringSpan;

    @FindBy (css = "option[data-testid='Unit Information']")
    public WebElement monitoringUnitInformation;

    @FindBy (css = "div.modal-header.modal-color > div > h2")
    public WebElement monPlanModalHeaderLabel;

    @FindBy (css = "div.display-inline-flex.padding-top-1.padding-bottom-3 > div > h4")
    public WebElement monPlanModalSysSecondTableHeaderLabel;

    @FindBy (css = "div.methodTable > div > div > div > h4")
    public WebElement monPlanAnalyzerRangesHeaderLabel;

    @FindBy (id = "collapseBTN")
    public WebElement accordionCollapseButtonMonPlan;

    @FindBy (id = "expandBTN")
    public WebElement accordionExpandButtonMonPlan;

    @FindBy (css = "h3[epa-testid='Methods']")
    public WebElement accordionMethodsLabel;

    @FindBy (css = "h3[epa-testid='Systems']")
    public WebElement accordionSystemsLabel;

    @FindBy (css = "h3[epa-testid='Defaults']")
    public WebElement accordionDefaultsLabel;

    @FindBy (css = "h3[epa-testid='Formulas']")
    public WebElement accordionFormulasLabel;

    @FindBy (id = "column-col2")
    public WebElement formulasTableParameterLabel;

    @FindBy (css = "div[role='row']:nth-child(1) > div[data-tag='allowRowEvents']")
    public List<WebElement> formulasTableParameterField;

    @FindBy (css = "h3[epa-testid='Loads']")
    public WebElement accordionLoadsLabel;

    @FindBy (id = "column-col1")
    public WebElement LoadsTableMaxLoadValLabel;

    @FindBy (css = "div[role='row']:nth-child(1) > div[data-tag='allowRowEvents']")
    public List<WebElement> LoadsTableMaxLoadValField;

    @FindBy (id = "Maximum Load Value")
    public WebElement LoadsModalMaxLoadValField;

    @FindBy (css = "div.text-center > p")
    public WebElement monPlansTablesNoDataPresent;

    @FindBy (css = "h3[epa-testid='LocationAttributes']")
    public WebElement accordionLocationAttributesLabel;

    @FindBy (id = "create-location-attribute-add-btn")
    public WebElement createLocationAttributeBTN;

    @FindBy (css = "div[data-tag='allowRowEvents'] > div")
    public List <WebElement> locAttributesGroundElevationTableField;

    @FindBy (id = "Ground Elevation")
    public WebElement locAttributesGroundElevationModalField;

    @FindBy (css = "h3[epa-testid='RelationshipsData']")
    public WebElement accordionRelationshipsDataLabel;

    @FindBy (css = "h3[epa-testid='Qualifications']")
    public WebElement accordionQualificationsLabel;

    @FindBy (id = "create-qualification-add-btn")
    public WebElement createQualificationButton;

    @FindBy (id = "btnOpenQualificationLME")
    public List<WebElement> viewEditQualLmeBtn;

    @FindBy (id = "column-col1")
    public WebElement qualificationTypeCodeLabel;

    @FindBy (css = "div[data-tag='allowRowEvents'] > div")
    public List<WebElement> qualificationTypeCodeField;

    @FindBy (css = "select[epadataname='qualificationTypeCode'] > option")
    public List<WebElement> qualificationTypeCodeModalDropdown;

    @FindBy (css = "h3[class='margin-top-5 text-bold mobile:font-body-xl mobile:text-bold']")
    public List<WebElement> qualificationsHeaders;

    @FindBy (css = "h3[class='text-bold float-left mobile:font-body-md mobile:text-bold']")
    public WebElement qualificationsViewModalHeader;

    @FindBy (css = "div.display-inline-flex.padding-top-1.padding-bottom-3 > div > h3")
    public WebElement qualificationsModalSubHeaders;

    @FindBy (id = "create-qualification-percent-add-btn")
    public WebElement createQualPercentButton;

    @FindBy (id = "btnOpenQualificationPercent")
    public List<WebElement> viewEditQualPercentBtn;

    @FindBy (css = "#Qualification-Year > option")
    public List<WebElement> qualPercentQualYearDropdown;

    @FindBy (id = "addBtn")
    public List<WebElement> createQualLeeButton;

    @FindBy (id = "btnOpenQualificationLEE")
    public List<WebElement> viewEditQualLeeBtn;

    @FindBy (id = "Qualification-Test-Date")
    public WebElement qualLeeQualTestDataField;

    @FindBy (css = "div[aria-label='DataTable for LEE Qualifications'] > div > div > div:nth-child(3) > #column-col2")
    public WebElement qualLeeParameterCodeTableHeader;

    @FindBy (css = "div[aria-label='DataTable for LEE Qualifications'] > div:nth-child(2) > div[role='row'] > div")
    public List<WebElement> qualLeeParameterCodeTableField;

    @FindBy (css = "#Parameter-Code > option")
    public List<WebElement> qualLeeParameterCodeDropdown;

    @FindBy (css = "#Qualification-Test-Type > option")
    public List<WebElement> qualLeeQualTestTypeDropdown;

    @FindBy (css = "h3[epa-testid='WAFsRectangularDuct']")
    public WebElement accordionRectangularDuctWAFsLabel;

    // The XPath was necessary as the CSS was not working for this locator
    @FindBy (xpath = "//button[contains(text(),'Create Rectangular Duct WAF')]")
    public WebElement createRectangularDuctWafBtn;

    @FindBy (id = "column-col2")
    public WebElement wafMethodTableLabel;

    @FindBy (css = "div[data-tag='allowRowEvents'] > div")
    public List<WebElement> wafMethodTableField;

    @FindBy (css = "select[epadataname='wafMethodCode'] > option")
    public List<WebElement> wafMethodModalDropdown;

    @FindBy (css = "input[epadataname='wafValue']")
    public WebElement wafValueModalField;

    @FindBy (css = "h3[epa-testid='Spans']")
    public WebElement accordionSpansLabel;

    @FindBy (id = "create-span-add-btn")
    public WebElement createSpanButton;

    @FindBy (id = "column-col1")
    public WebElement spansTableComponentTypeLabel;

    @FindBy (css = "div[role='gridcell']:nth-child(1)")
    public List<WebElement> spansTableComponentTypeField;

    @FindBy (css = "#Component\\ Type > option")
    public List<WebElement> monMethodsModalComponentTypeDropdown;

    @FindBy (css = "h3[epa-testid='UnitFuels']")
    public WebElement accordionUnitFuelsLabel;

    @FindBy (css = "h3[epa-testid='UnitControls']")
    public WebElement accordionUnitControlsLabel;

    @FindBy (css = "h3[epa-testid='UnitCapacities']")
    public WebElement accordionUnitCapacitiesLabel;

    @FindBy (css = "h3[epa-testid='SupplementalMethods']")
    public WebElement accordionSupplementalMethodsLabel;

    @FindBy (css = "div:nth-child(3) > div > div:nth-child(2) > div.text-bold.font-body-xl.display-block.height-auto")
    public WebElement accordionButtonMATS;

    @FindBy(css = "div[class='cursor-pointer']")
    public List<WebElement> systemTableButtonList;

    @FindBy(id = "closeModalBtn")
    public WebElement xOutModal;

    @FindBy(css = "button[epa-testid='cancelBtn']")
    public WebElement cancelModal;

    @FindBy(id = "saveBtn")
    public WebElement saveCloseModal;

    @FindBy(css = "button[epa-testid='closeBtn']")
    public WebElement closeModal;

    @FindBy (id = "column-col1")
    public WebElement systemIDTitle;

    @FindBy(css = "div.modalDetails > h2")
    public WebElement modalTitle;

    @FindBy (css = "div.grid-col.padding-bottom-2.padding-right-3 > div > label")
    public WebElement modalSystemID;

    @FindBy (css = "label[for='sysdes']")
    public WebElement modalSystemDesignation;

    @FindBy (css = "label[for='systype']")
    public WebElement modalSystemType;

    @FindBy (css = "label[for='fueltype']")
    public WebElement modalFuelType;

    @FindBy (id = "Start Date")
    public WebElement modalStartDateField;

    @FindBy (id = "Start Time")
    public WebElement modalStartTimeField;

    @FindBy (id = "End Date")
    public WebElement modalEndDateField;

    @FindBy (id = "End Time")
    public WebElement modalEndTimeField;

    @FindBy (css = "div.methodTable.react-transition.fade-in > div > div:nth-child(1) > div > div > h4")
    public WebElement systemComponentsHeader;

    @FindBy (css = "#column-col1")
    public List<WebElement> componentIdHeader;

    @FindBy (css = "#column-col2")
    public List<WebElement> componentTypeCodeHeader;

    @FindBy (css = "#column-col3")
    public List<WebElement> componentBeginToEndDateHeader;

    @FindBy (css = "#column-undefined > div")
    public List<WebElement> componentActionsHeader;

    @FindBy (css = "button[epa-testid='btnOpen']")
    public List<WebElement> viewButton;

    @FindBy (id = "btnOpenSystemComponents")
    public List<WebElement> viewButtonSystemComponents;

    @FindBy (id = "btnOpenFuelFlows")
    public List<WebElement> viewButtonFuelFlow;

    @FindBy (css = "div.display-inline-flex.padding-top-1.padding-bottom-3 > div > h4")
    public WebElement systemComponentModal;

    @FindBy (css = "div.sc-jrsJWt.khlPsW.rdt_TableRow > div:nth-child(4)")
    public List<WebElement> componentsViewButton;

    @FindBy (id = "btnOpenAnalyzerRanges")
    public List<WebElement> analyzerRangesViewButton;

    @FindBy (css = "button[class='usa-button addCompBTN align-right']")
    public WebElement addComponentButton;

    @FindBy (css = "label[for='ComponentID']")
    public WebElement componentIdModal;

    @FindBy (css = "label[for='SampleAcquisitionMethod']")
    public WebElement componentSampleAcquisitionMethodModal;

    @FindBy (css = "label[for='ComponentType']")
    public WebElement ComponentTypeModal;

    @FindBy (css = "label[for='BasisDescription']")
    public WebElement componentBasisDescriptionModal;

    @FindBy (css = "label[for='Manufacturer']")
    public WebElement componentManufacturerModal;

    @FindBy (css = "label[for='ModelOrVersion']")
    public WebElement componentModelOrVersionModal;

    @FindBy (css = "label[for='SerialNumber']")
    public WebElement componentSerialNumberModal;

    @FindBy (css = "fieldset[class='usa-fieldset  display-inline-flex'] > legend.usa-legend")
    public WebElement componentHgConverterIndicatorModal;

    @FindBy (id = "StartDateAndTime")
    public WebElement componentStartDateAndTimeModal;

    @FindBy (id = "EndDateAndTime")
    public WebElement componentEndDateAndTimeModal;

    @FindBy (css = "label[for='startTime']")
    public WebElement componentStartDateModal;

    @FindBy (css = "label[for='startHour']")
    public WebElement componentStartHourModal;

    @FindBy (css = "label[for='endDate']")
    public WebElement componentEndDateModal;

    @FindBy (css = "label[for='endHour']")
    public WebElement componentEndHourModal;

    @FindBy (css = "button[aria-label='go back to systems details']")
    public WebElement componentBackButton;

    @FindBy (css = "div.methodTable.react-transition.fade-in > div > div:nth-child(2) > div > div > h4")
    public WebElement systemFuelFlowsHeader;

    @FindBy (css = "div.padding-top-4.padding-left-2 > h2 > button")
    public WebElement addFuelFlowButton;

    // fuelFlowCodeModal, fuelFlowTypeModal and fuelFlowBeginToEndDateHeader are
    // all the same locator differentiated by a different index number with .get()
    @FindBy (css = "div.sc-hKFxyN.sc-eCApnc.sc-iqAclL.dSYVyP.domoiu.ikSTQe.rdt_TableCol")
    public List<WebElement> fuelFlowCodeModal;

    @FindBy (css = "div.sc-hKFxyN.sc-eCApnc.sc-iqAclL.dSYVyP.domoiu.ikSTQe.rdt_TableCol")
    public List<WebElement> fuelFlowTypeModal;

    @FindBy (css = "div.sc-hKFxyN.sc-eCApnc.sc-iqAclL.dSYVyP.domoiu.ikSTQe.rdt_TableCol")
    public List<WebElement> fuelFlowBeginToEndDateHeader;

    @FindBy (css = "#column-undefined")
    public List<WebElement> fuelFlowActionsHeader;

    @FindBy (css = "div.sc-dIvrsQ.gkZcBD.rdt_TableBody > div > div:nth-child(4)")
    public List<WebElement> FuelFlowViewButton;

    @FindBy (css ="button[epa-testid='searchDataTableBTN']")
    public WebElement filterByKeywordButton;

    @FindBy (css ="input[id='txtSearchData']")
    public WebElement filterByKeywordBox;

    @FindBy (css = "#column-col1 > div")
    public List<WebElement> monPlanOrisHeader;

    @FindBy (css = "#column-col2 > div")
    public List<WebElement> monPlanFacilityHeader;

    @FindBy (css = "#column-col3 > div")
    public List<WebElement> monPlanStateHeader;

    @FindBy (css = "div.sc-dIvrsQ.gkZcBD.rdt_TableBody > div > div > button")
    public List<WebElement> openFacilityConfigurations;

    @FindBy (css = "#column-col1 > div")
    public List<WebElement> monPlanConfigHeader;

    @FindBy (css = "#column-col2 > div")
    public List<WebElement> monPlanStatusHeader;

    @FindBy (css = "#column-undefined")
    public WebElement monPlanActionsHeader;

    @FindBy (css = "#btnOpenConfiguration")
    public List<WebElement> monPlanOpenButton;

    @FindBy (css ="button[data-testid='expander-button-undefined']")
    public List<WebElement> facilityCaret;

    @FindBy (css ="button[aria-label='Expand Row']")
    public WebElement facilityCaretFirst;

    @FindBy (css = "button[epa-testid='btnOpen']")
    public List<WebElement> configOpenButton;

    @FindBy (id = "btnOpenAndCheckout")
    public List<WebElement> configOpenAndCheckoutButton;

    @FindBy (id ="tabBtn")
    public List<WebElement> configTabs;

    @FindBy (css ="li[title='Barry (1, 2, CS0AAN) ']")
    public WebElement configTabBarry12CS0AAN;

    @FindBy (id ="closeXBtnTab")
    public List<WebElement> closeConfigTab;

    @FindBy (id ="checkOutBTN")
    public WebElement configcheckOutButton;

    @FindBy (id ="checkInBTN")
    public WebElement configcheckBackInButton;

    @FindBy (id ="showRevertModal")
    public WebElement revertOfficialRecordButton;

    @FindBy (id ="saveBtn")
    public WebElement revertModalYesButton;

}
