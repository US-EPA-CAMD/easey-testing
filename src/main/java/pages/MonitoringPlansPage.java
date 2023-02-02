package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MonitoringPlansPage extends HeaderFooterAndHomePage {

    public MonitoringPlansPage(WebDriver driver) { super(driver); }

    @FindBy(css = "table.usa-table.usa-table--borderless")
    public WebElement table;

    @FindBy(css = "h2[epa-testid='MonitoringPlansTitle']")
    public WebElement title;

    @FindBy(id = "MonitoringPlans_wks")
    public WebElement monPlanWorkSpaceBtn;

    @FindBy(css = "h3[class='margin-y-auto font-body-lg margin-right-2']")
    public WebElement titleOfFacilityInConfig;

    @FindBy(css = "div.tabContent > div > div > div > div > header > div")
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

    @FindBy (css = "select[id='Formula Code'] > option")
    public List<WebElement> monMethodsModalFormulaCodeDropdown;

    @FindBy (css = "#Methodology > option")
    public List<WebElement> monMethodsModalMethodologyDropdown;

    @FindBy (css = "option[data-testid='Systems']")
    public WebElement monitoringSystems;

    @FindBy (css = "#column-col2")
    public WebElement monitoringSystemTypeTableLabel;

    @FindBy (css = "div[data-tag='allowRowEvents']:nth-child(3)")
    public List<WebElement> monitoringSystemTypeTableField;

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

    @FindBy (id = "Maximum Load Value")
    public WebElement monitoringFormulasMaxLoadValField;

    @FindBy (css = "select[epadataname='maximumLoadUnitsOfMeasureCode'] > option")
    public List<WebElement> monMethodsModalMaxLoadUnitMeasureDropdown;

    @FindBy (id = "create-load-add-btn")
    public WebElement createLoadButton;

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

    @FindBy (css = "div.display-inline-flex.padding-top-1.padding-bottom-3 > div > h3")
    public WebElement monPlanModalSysSecondTableHeaderLabel;

    @FindBy (css = "div.methodTable > div > div > div > h4")
    public WebElement monPlanAnalyzerRangesHeaderLabel;

    @FindBy (id = "collapseBTN")
    public WebElement accordionCollapseButtonMonPlan;

    @FindBy (id = "expandBTN")
    public WebElement accordionExpandButtonMonPlan;

    @FindBy (css = "h4[epa-testid='Methods']")
    public WebElement accordionMethodsLabel;

    @FindBy (css = "h4[epa-testid='Systems']")
    public WebElement accordionSystemsLabel;

    @FindBy (css = "h4[epa-testid='Defaults']")
    public WebElement accordionDefaultsLabel;

    @FindBy (css = "h4[epa-testid='Formulas']")
    public WebElement accordionFormulasLabel;

    @FindBy (id = "column-col2")
    public WebElement formulasTableParameterLabel;

    @FindBy (css = "div[role='row']:nth-child(1) > div[data-tag='allowRowEvents']")
    public List<WebElement> formulasTableParameterField;

    @FindBy (css = "h4[epa-testid='Loads']")
    public WebElement accordionLoadsLabel;

    @FindBy (id = "column-col1")
    public WebElement LoadsTableMaxLoadValLabel;

    @FindBy (css = "div[role='row']:nth-child(1) > div[data-tag='allowRowEvents']")
    public List<WebElement> LoadsTableMaxLoadValField;

    @FindBy (id = "Maximum Load Value")
    public WebElement LoadsModalMaxLoadValField;

    @FindBy (css = "div.text-center > p")
    public WebElement monPlansTablesNoDataPresent;

    @FindBy (css = "h4[epa-testid='LocationAttributes']")
    public WebElement accordionLocationAttributesLabel;

    @FindBy (id = "create-location-attribute-add-btn")
    public WebElement createLocationAttributeBTN;

    @FindBy (css = "div[data-tag='allowRowEvents'] > div")
    public List <WebElement> locAttributesGroundElevationTableField;

    @FindBy (id = "Ground Elevation")
    public WebElement locAttributesGroundElevationModalField;

    @FindBy (css = "h4[epa-testid='RelationshipsData']")
    public WebElement accordionRelationshipsDataLabel;

    @FindBy (css = "h4[epa-testid='Qualifications']")
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

    @FindBy (css = "#backBtn + h3")
    public WebElement createModalSubHeader;

    @FindBy (css = "div.display-inline-flex.padding-top-1.padding-bottom-3 > div > h3")
    public WebElement qualificationsModalSubHeaders;

    @FindBy (css = "div[aria-label='DataTable for LME Qualifications'] > div:nth-child(1) > div > div:nth-child(2)")
    public WebElement qualDataYearTableHeader;

    @FindBy (css = "div[aria-label='DataTable for LME Qualifications'] > div:nth-child(2) > div > div:nth-child(2)")
    public List<WebElement> qualDataYearTableField;

    @FindBy (id = "addBtn")
    public List<WebElement> createQualLmeButton;

    @FindBy (css = "#Qualification-Data-Year > option")
    public List<WebElement> qualDataYearDropdown;

    @FindBy (id = "create-qualification-percent-add-btn")
    public WebElement createQualPercentButton;

    @FindBy (id = "btnOpenQualificationPercent")
    public List<WebElement> viewEditQualPercentBtn;

    @FindBy (css = "div[aria-label='DataTable for PCT Qualifications'] > div > div > div:nth-child(2)")
    public List<WebElement> qualPercentQualYearTableHeader;

    @FindBy (css = "div[aria-label='DataTable for PCT Qualifications'] > div > div > div:nth-child(2)")
    public List<WebElement> qualPercentQualYearTableField;

    @FindBy (css = "#Qualification-Year > option")
    public List<WebElement> qualPercentQualYearDropdown;

    @FindBy (id = "addBtn")
    public List<WebElement> createQualLeeButton;

    @FindBy (css = "div[aria-label='DataTable for LEE Qualifications'] > div > div > div > div > button[epa-testid='btnOpen']")
    public List<WebElement> viewEditQualLeeBtn;

    @FindBy (id = "Qualification-Test-Date")
    public WebElement qualLeeQualTestDataField;

    @FindBy (css = "div[aria-label='DataTable for LEE Qualifications'] > div > div > div:nth-child(3) > #column-col2")
    public WebElement qualLeeParameterCodeTableHeader;

    @FindBy (css = "div[aria-label='DataTable for LEE Qualifications'] > div:nth-child(2) > div[role='row'] > div")
    public List<WebElement> qualLeeParameterCodeTableField;

    @FindBy (css = "select[epadataname='parameterCode'] > option")
    public List<WebElement> qualLeeParameterCodeDropdown;

    @FindBy (css = "#Qualification-Test-Type > option")
    public List<WebElement> qualLeeQualTestTypeDropdown;

    @FindBy (css = "h4[epa-testid='WAFsRectangularDuct']")
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

    @FindBy (id = "WAF Determination Date")
    public WebElement wafDeterminationDateField;

    @FindBy (css = "h4[epa-testid='Spans']")
    public WebElement accordionSpansLabel;

    @FindBy (id = "create-span-add-btn")
    public WebElement createSpanButton;

    @FindBy (id = "column-col1")
    public WebElement spansTableComponentTypeLabel;

    @FindBy (css = "div[role='rowgroup'] > div[role='row'] > div[role='cell']:nth-child(2)")
    public List<WebElement> spansTableComponentTypeField;

    @FindBy (css = "#Component\\ Type > option")
    public List<WebElement> monMethodsModalComponentTypeDropdown;

    @FindBy (css = "h4[epa-testid='UnitFuels']")
    public WebElement accordionUnitFuelsLabel;

    @FindBy (id = "column-col2")
    public List<WebElement> indicatorCodeUnitFuelsHeader;

    @FindBy (css = "div[role='gridcell']:nth-child(3)")
    public List<WebElement> indicatorCodeUnitFuelsTableField;

    @FindBy (css = "select[id='Indicator Code'] > option")
    public List<WebElement> indicatorCodeUnitFuelsDropdown;

    @FindBy (css = "h4[epa-testid='UnitControls']")
    public WebElement accordionUnitControlsLabel;

    @FindBy (id = "column-col2")
    public List<WebElement> controlCodeUnitControlsHeader;

    @FindBy (css = "div[role='gridcell']:nth-child(3)")
    public List<WebElement> controlCodeUnitControlsTableField;

    @FindBy (css = "select[id='Control Code'] > option")
    public List<WebElement> controlCodeUnitControlsDropdown;

    @FindBy (css = "h4[epa-testid='UnitCapacities']")
    public WebElement accordionUnitCapacitiesLabel;

    @FindBy (id = "create-unit-capacity-add-btn")
    public WebElement createUnitCapacityButton;

    @FindBy (id = "Maximum Hourly Heat Input Capacity")
    public WebElement maxHourlyHeatInputCapacityField;

    @FindBy (id = "column-col6")
    public List<WebElement> maxHourlyHeatInputCapacityHeader;

    @FindBy (css = "div[role='cell']:nth-child(7)")
    public List<WebElement> maxHourlyHeatInputCapacityTableField;

    @FindBy (id = "create-unit-control-add-btn")
    public WebElement createUnitControlButton;

    @FindBy (css = "select[id='Parameter Code'] > option")
    public List<WebElement> paramCodeUnitControlDropdown;

    @FindBy (css = "select[id='Control Code'] > option")
    public List<WebElement> controlCodeUnitControlDropdown;

    @FindBy (id = "Install Date")
    public WebElement installDateUnitControl;

    @FindBy (id = "Optimization Date")
    public WebElement optimizationDateUnitControl;

    @FindBy (id = "create-unit-fuel-add-btn")
    public WebElement createUnitFuelsButton;

    @FindBy(css = "select[id='Fuel Type'] > option")
    public List<WebElement> fuelTypeUnitFuelDropdown;

    @FindBy (id = "Start Date")
    public WebElement modalStartDateFieldUnitFuel;

    @FindBy (css = "h4[epa-testid='SupplementalMethods']")
    public WebElement accordionSupplementalMethodsLabel;

    @FindBy (xpath = "//button[contains(text(),'Create MATS')]")
    public WebElement createMatsMethodsButton;

    @FindBy(css = "div[class='cursor-pointer']")
    public List<WebElement> systemTableButtonList;

    @FindBy (xpath = "//button[contains(text(),'Evaluate')]")
    public WebElement evaluateButton;

    @FindBy (xpath = "//p[contains(text(),'In Queue')]")
    public WebElement evalStatusInQueue;

    @FindBy (xpath = "//p[contains(text(),'In Progress')]")
    public WebElement evalStatusInProgress;

    @FindBy (xpath = "//button[contains(text(),'Passed')]")
    public WebElement evalStatusPassed;

    @FindBy (xpath = "//button[contains(text(),'Critical Errors')]")
    public WebElement evalStatusCriticalErrors;

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

    @FindBy (css = "div.methodTable.react-transition.fade-in > div > div:nth-child(1) > div > div > h3")
    public WebElement systemComponentsHeader;

    @FindBy (id = "column-col2")
    public List<WebElement> systemComponentsTypeLabel;

    @FindBy (css = "div[class='systemsCompTable'] > div > div > div > div > div > div > div > div[role='gridcell']:nth-child(3)")
    public List<WebElement> systemComponentsTypeTableField;

    @FindBy (css = "label[for='Component Type']")
    public WebElement systemComponentsTypeModalLabel;

    @FindBy (css = "#Component-Type > option")
    public List<WebElement> systemComponentsTypeDropdown;

    @FindBy (id = "add-component-add-btn")
    public WebElement addComponentBtn;

    @FindBy (id = "saveExtraBtn")
    public WebElement createNewComponentBtn;

    @FindBy (css = "#column-col1")
    public List<WebElement> componentIdHeader;

    @FindBy (css = "#column-col2")
    public List<WebElement> componentTypeCodeHeader;

    @FindBy (css = "#column-col3")
    public List<WebElement> componentBeginToEndDateHeader;

    @FindBy (css = "#column-undefined > div")
    public List<WebElement> componentActionsHeader;

    @FindBy (id = "Component-ID")
    public WebElement componentIdFieldModal;

    @FindBy (css = "#Sample-Acquistion-Method > option")
    public List<WebElement> componentSamDropdown;

    @FindBy (css = "#Component-Type > option")
    public List<WebElement> componentTypeDropdown;

    @FindBy (css = "#Basis-Description > option")
    public List<WebElement> componentBasisDescriptionDropdown;

    @FindBy (id = "Manufacturer")
    public WebElement componentManufacturerFieldModal;

    @FindBy (id = "Model-or-Version")
    public WebElement componentModelVersionFieldModal;

    @FindBy (id = "Serial-Number")
    public WebElement serialNumberFieldModal;

    @FindBy (css = "button[epa-testid='btnOpen']")
    public List<WebElement> viewButton;

    @FindBy (css = "button[epa-testid='btnOpen']")
    public List<WebElement> viewButtonSystemComponents;

    @FindBy (css = "div.display-inline-flex.padding-top-1.padding-bottom-3 > div > h4")
    public WebElement systemComponentModal;

    @FindBy (css = "div.sc-jrsJWt.khlPsW.rdt_TableRow > div:nth-child(4)")
    public List<WebElement> componentsViewButton;

    @FindBy (css = "div[id='datatableContainer'] > div > h3")
    public WebElement analyzerRangesHeader;

    // Shorter Locator is needed
    @FindBy (css = "div[class='systemsCompTable'] > div:nth-child(2) > div > div > div > div > div:nth-child(2) > div > div > div > button[epa-testid='btnOpen']")
    public List<WebElement> analyzerRangesViewButton;

    @FindBy (id = "create-new-analyzer-range-add-btn")
    public WebElement createAnalyzerRangeButton;

    @FindBy (css = "div[aria-label='DataTable for Analyzer Ranges'] > div:nth-child(2) > div > div:nth-child(2) > div")
    public List<WebElement> analyzerRangesRangeTableField;

    @FindBy (css = "div[class='usa-form-group margin-top-0'] > h3")
    public List<WebElement> analyzerRangesLabelsGlobal;

    @FindBy (css = "label[for='Range']")
    public WebElement analyzerRangesRangeLabelLoggedIn;

    @FindBy (css = "#Range > option")
    public List<WebElement> analyzerRangesRangeDropdown;

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

    @FindBy (css = "h3[class='margin-top-5 text-bold mobile:font-body-xl mobile:text-bold']")
    public List<WebElement> systemFuelFlowsHeader;

    @FindBy (css = "div[role='row'] > div[role='gridcell']> div >  button[epa-testid='btnOpen']")
    public List<WebElement> viewButtonFuelFlow;

    @FindBy (css = "div[role='row'] > div[role='gridcell']:nth-child(4)")
    public List<WebElement> dateAndTimeFuelFlow;

    @FindBy (id = "create-new-fuel-flow-add-btn")
    public WebElement createFuelFlowButton;

    @FindBy (css = "label[for='Max Fuel Flow Rate']")
    public WebElement matFuelFlowRateHeader;

    @FindBy (id = "Max-Fuel-Flow-Rate")
    public WebElement matFuelFlowRateField;

    @FindBy (css = "#Units-of-Measure-Code > option")
    public List<WebElement> fuelFlowUnitsOfMeasureCodeDropdown;

    @FindBy (xpath = "//label[contains(text(),'Units of Measure Code')]//following::div[1]")
    public WebElement unitsOfMeasureCodeField;

    @FindBy (id = "Units-of-Measure-Code > option")
    public List<WebElement> unitsOfMeasureCodeDropdown;

    @FindBy (id = "Max-Fuel-Flow-Rate")
    public WebElement maxFuelFlowRateField;

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

    @FindBy (xpath ="//tbody/tr[1]/td[3]/button[1]")
    public WebElement filterByKeywordButton;

    @FindBy (xpath ="//tbody/tr[1]/td[2]/input[1]")
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

    //Facilities to pick from
    @FindBy (css ="li[title='Barry (1, 2, CS0AAN) ']")
    public WebElement configTabBarry12CS0AAN;

    @FindBy (css ="li[title='Gadsden (1, 2, CS0BAN) ']")
    public WebElement configTabGadsden12CS0BAN;

    @FindBy (css ="li[title='Harvey Couch 1']")
    public WebElement configTabHarvey;

    @FindBy (css ="svg[id^='closeXBtnTab']")
    public List<WebElement> closeConfigTab;

    @FindBy (id ="checkOutBTN")
    public WebElement configcheckOutButton;

    @FindBy (id ="checkInBTN")
    public WebElement configcheckBackInButton;

    @FindBy (id ="showRevertModal")
    public WebElement revertOfficialRecordButton;

    @FindBy (id ="saveBtn")
    public WebElement revertModalYesButton;

    @FindBy (id ="btnStopAnimation")
    public WebElement stopAnimationButton;

    @FindBy (css ="img[title='Content loading']")
    public WebElement stopAnimationImage;

    @FindBy (css ="li[title='Smith Generating Facility (SCT5) ']")
    public WebElement configTabSmith;

    @FindBy (css ="//div[@id='tabBtn']")
    public WebElement configTabLocalSmith;

    @FindBy (xpath ="//div[@id='tabBtn']")
    public WebElement configTab1;

    @FindBy(id = "Export")
    public WebElement export;

    @FindBy (xpath ="//a[@id='Export']")
    public WebElement exportTab ;

    @FindBy (xpath ="//a[@id='Export_wks']")
    public WebElement exportTabLocal ;

    @FindBy (xpath = "//button[@id='importBtn']")
    public WebElement importButton ;

    @FindBy (xpath = "//input[@id='file-input-single']")
    public WebElement uploadFileChoiceButton ;

    @FindBy (xpath = "//button[@id='checkOutBTN']")
    public WebElement checkOutBTN ;

    @FindBy (xpath = "//button[@id='checkInBTN']")
    public WebElement checkInBTN ;

    @FindBy (xpath = "//button[@id='okBtn']")
    public WebElement okBTN ;

    //TODO replace with something better
    @FindBy (xpath = "//body/div[@id='portal']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/button[1]")
    public WebElement importSubmitBTN ;
    //#importBtn

    @FindBy (xpath = "//h4[contains(text(),'Success')]")
    public WebElement successMessage ;

}
