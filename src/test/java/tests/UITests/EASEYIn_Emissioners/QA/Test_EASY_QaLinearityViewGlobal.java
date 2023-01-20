package tests.UITests.EASEYIn_Emissioners.QA;

import org.testng.annotations.Test;
import pages.QaCertificationPage;
import tests.UITests.EASEYIn_Emissioners.monPlan.exportimport.CommonExport;

public class Test_EASY_QaLinearityViewGlobal extends CommonExport {
    @Test
    public void test() throws InterruptedException {
        //        Navigate to EASEY In
        //        https://easey-dev.app.cloud.gov/ecmps/monitoring-plans
    goToo("ecmps","/qa-test");

    QaCertificationPage qaCertificationPage = new QaCertificationPage(driver);

    verifyEquals(qaCertificationPage.title, "QA Certifications Test Data");


    }


}
