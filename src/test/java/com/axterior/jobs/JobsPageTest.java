package com.axterior.jobs;

import com.axterior.base.BaseTest;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class JobsPageTest extends BaseTest {

    @DataProvider
    private Object[][] createJobTestDataProvider() {
        Object[][] data = {{"Accountant", "Middle", "Full-time employment", "Accounting",
                            "3000", "4000", "Montreal", "01/01/2025", "Sandra Bullocks",
                            "Canada", "Montreal", "Problem-solving", "Sample Text"}};
        return data;
    }
    @Test(priority = 1, dataProvider = "createJobTestDataProvider")
    public void createJobTest(String jobPost, String qualificationLevel, String employmentType, String department,
                              String minSalary, String maxSalary, String officeLocation, String date,
                              String recruiterName, String country, String city, String skill, String sampleText) {
        JobsPage jobsPage = PageFactory.initElements(driver, JobsPage.class);
        jobsPage.createJobPost(jobPost, qualificationLevel, employmentType, department, minSalary, maxSalary,
                officeLocation, date, recruiterName, country, city, skill, sampleText);
        Assert.assertEquals(jobsPage.getToastText(), "Done! Job is created");
        System.out.println("Result for Test1(createJobTest): " + jobsPage.getToastText());
    }
}
