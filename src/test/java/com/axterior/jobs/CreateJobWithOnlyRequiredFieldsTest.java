package com.axterior.jobs;

import com.axterior.base.BaseTest;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateJobWithOnlyRequiredFieldsTest extends BaseTest {

    @DataProvider
    private Object[][] createJobWithOnlyRequiredFieldsTestDataProvider() {
        Object[][] data = {{"Quality Analyst", "Full-time employment", "Quality Assurance", "Toronto",
                            "05/07/2025", "Sylvester Stallone"}};
        return data;
    }
    @Test(priority = 1, dataProvider = "createJobWithOnlyRequiredFieldsTestDataProvider")
    public void createJobWithOnlyRequiredFields(String jobPost, String employmentType, String department,
                                                String officeLocation, String date, String recruiterName) {
        JobsPage jobsPage = PageFactory.initElements(driver, JobsPage.class);
        jobsPage.createJobOnlyWithRequiredFields(jobPost, employmentType, department, officeLocation, date, recruiterName);
        Assert.assertEquals(jobsPage.toastText, "Done! Job is created");
        System.out.println("\nResult for Test(createJobTestWithOnlyRequiredFields): " + jobsPage.toastText + "\n");
    }
}
