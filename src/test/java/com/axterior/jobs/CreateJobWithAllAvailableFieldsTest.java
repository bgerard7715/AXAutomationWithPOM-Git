package com.axterior.jobs;

import com.axterior.base.BaseTest;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateJobWithAllAvailableFieldsTest extends BaseTest {

    @DataProvider
    private Object[][] createJobWithAllAvailableFieldsTestDataProvider() {
        Object[][] data = {{"Accountant", "Middle", "Full-time employment", "Accounting",
                            "3000", "4000", "Montreal", "01/01/2025", "Sandra Bullocks",
                            "Canada", "Montreal", "Problem-solving", "Sample Text"}};
        return data;
    }
    @Test(priority = 1, dataProvider = "createJobWithAllAvailableFieldsTestDataProvider")
    public void createJobWitAllAvailableFieldsTest(String jobPost, String qualificationLevel, String employmentType, String department,
                              String minSalary, String maxSalary, String officeLocation, String date,
                              String recruiterName, String country, String city, String skill, String sampleText) {
        JobsPage jobsPage = PageFactory.initElements(driver, JobsPage.class);
        jobsPage.createJobPostWithAllAvailableFields(jobPost, qualificationLevel, employmentType, department, minSalary, maxSalary,
                                officeLocation, date, recruiterName, country, city, skill, sampleText);
        Assert.assertEquals(jobsPage.toastText, "Done! Job is created");
        System.out.println("\nResult for Test(createJobTestWithAllAvailableFields): " + jobsPage.toastText + "\n");
    }
}
