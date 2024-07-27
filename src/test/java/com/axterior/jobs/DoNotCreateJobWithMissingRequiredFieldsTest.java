package com.axterior.jobs;

import com.axterior.base.BaseTest;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DoNotCreateJobWithMissingRequiredFieldsTest extends BaseTest {

    @DataProvider
    private Object[][] doNotCreateJobWithMissingRequiredFieldsTestDataProvider() {
        Object[][] data = {{"Quality Analyst", "Full-time employment", "Quality Assurance", "Toronto",
                "05/07/2025"}};
        return data;
    }
    @Test(priority = 1, dataProvider = "doNotCreateJobWithMissingRequiredFieldsTestDataProvider")
    public void doNotCreateJobWithMissingRequiredFieldsTest(String jobPost, String employmentType, String department,
                                                            String officeLocation, String date) {
        JobsPage jobsPage = PageFactory.initElements(driver, JobsPage.class);
        jobsPage.doNotCreateJobWithMissingRequiredFields(jobPost, employmentType, department, officeLocation, date);
        Assert.assertTrue(jobsPage.toastText.contains("form cannot be completed"));
        System.out.println("\nResult for Test(doNotCreateJobWithMissingRequiredFieldsTest): "
                + jobsPage.toastText +"(Missing required fields)\n");
    }
}
