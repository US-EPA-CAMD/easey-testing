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

    @FindBy (css = "option[data-testid='Defaults']")
    public WebElement monitoringDefaults;

    @FindBy (id = "column-col1")
    public WebElement defaultsTableParameterCodeLabel;

    @FindBy (css = "div.sc-dIvrsQ.gkZcBD.rdt_TableBody > div > div:nth-child(1)")
    public List<WebElement> defaultsTableParameterCodeField;

    @FindBy (css = "option[data-testid='Formulas']")
    public WebElement monitoringFormulas;

    @FindBy (css = "option[data-testid='Loads']")
    public WebElement monitoringLoads;

    @FindBy (css = "option[data-testid='Location Attributes and Relationships']")
    public WebElement monitoringLocationAttributesAndRelationships ;

    @FindBy (css = "option[data-testid='Qualifications']")
    public WebElement monitoringQualifications ;

    @FindBy (css = "option[data-testid='Rectangular Duct WAFs']")
    public WebElement monitoringRectangularDuctWAFs;

    @FindBy (css = "option[data-testid='Span']")
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

    @FindBy (css = "span[epa-testid='Methods']")
    public WebElement accordionMethodsLabel;

    @FindBy (css = "span[epa-testid='Systems']")
    public WebElement accordionSystemsLabel;

    @FindBy (css = "span[epa-testid='Defaults']")
    public WebElement accordionDefaultsLabel;

    @FindBy (css = "span[epa-testid='Formulas']")
    public WebElement accordionFormulasLabel;

    @FindBy (id = "column-col2")
    public WebElement formulasTableParameterLabel;

    @FindBy (css = "div.sc-dIvrsQ.gkZcBD.rdt_TableBody > div > div:nth-child(2)")
    public List<WebElement> formulasTableParameterField;

    @FindBy (css = "span[epa-testid='Loads']")
    public WebElement accordionLoadsLabel;

    @FindBy (css = "Place Holder")
    public WebElement accordionLocationAttributesAndRelationshipsLabel;

    @FindBy (css = "span[epa-testid='Qualifications']")
    public WebElement accordionQualificationsLabel;

    @FindBy (css = "h3[class='margin-top-5 text-bold mobile:font-body-xl mobile:text-bold']")
    public List<WebElement> qualificationsHeaders;

    @FindBy (css = "h3[class='text-bold float-left mobile:font-body-md mobile:text-bold']")
    public WebElement qualificationsLeeHeader;

    @FindBy (css = "span[epa-testid='WAFsRectangularDuct']")
    public WebElement accordionRectangularDuctWAFsLabel;

    @FindBy (css = "span[epa-testid='Spans']")
    public WebElement accordionSpansLabel;

    @FindBy (id = "column-col1")
    public WebElement spansTableComponentTypeLabel;

    @FindBy (css = "div.sc-dIvrsQ.gkZcBD.rdt_TableBody > div > div:nth-child(1)")
    public List<WebElement> spansTableComponentTypeField;

    @FindBy (css = "#Component\\ Type > option")
    public List<WebElement> monMethodsModalComponentTypeDropdown;


    @FindBy (css = "span[epa-testid='UnitFuels']")
    public WebElement accordionUnitFuelsLabel;

    @FindBy (css = "span[epa-testid='UnitControls']")
    public WebElement accordionUnitControlsLabel;

    @FindBy (css = "span[epa-testid='UnitCapacities']")
    public WebElement accordionUnitCapacitiesLabel;

    @FindBy (css = "span[epa-testid='SupplementalMethods']")
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

    @FindBy (id = "btnOpenQualificationLEE")
    public List<WebElement> viewButtonbtnOpenQualificationLEE;

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
