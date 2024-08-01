package com.axterior.jobs;

import com.axterior.base.BaseTest;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class JobsPageTest extends BaseTest {

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


    @DataProvider
    private Object[][] createJobWithOnlyRequiredFieldsTestDataProvider() {
        Object[][] data = {{"Quality Analyst", "Full-time employment", "Quality Assurance", "Toronto",
                "05/07/2025", "Sylvester Stallone"}};
        return data;
    }
    @Test(priority = 2, dataProvider = "createJobWithOnlyRequiredFieldsTestDataProvider")
    public void createJobWithOnlyRequiredFields(String jobPost, String employmentType, String department,
                                                String officeLocation, String date, String recruiterName) {
        JobsPage jobsPage = PageFactory.initElements(driver, JobsPage.class);
        jobsPage.createJobOnlyWithRequiredFields(jobPost, employmentType, department, officeLocation, date, recruiterName);
        Assert.assertEquals(jobsPage.toastText, "Done! Job is created");
        System.out.println("\nResult for Test(createJobTestWithOnlyRequiredFields): " + jobsPage.toastText + "\n");
    }


    @DataProvider
    private Object[][] dataForDeleteJobTest() {
        Object[][] data = {{"Accountant"}};
        return data;
    }
    @Test(priority = 3, dataProvider = "dataForDeleteJobTest")
    public void deleteJobTest(String jobName) {
        JobsPage jobsPage = PageFactory.initElements(driver, JobsPage.class);
        jobsPage.deleteJob(jobName);
        Assert.assertTrue(jobsPage.toastText.contains("Job is deleted"));
        System.out.println("\nResult for Test(deleteJobTest): " + jobName
                + jobsPage.toastText +"\n");
    }


    @DataProvider
    private Object[][] doNotCreateJobWithMissingRequiredFieldsTestDataProvider() {
        Object[][] data = {{"Quality Analyst", "Full-time employment", "Quality Assurance", "Toronto",
                "05/07/2025"}};
        return data;
    }
    @Test(priority = 4, dataProvider = "doNotCreateJobWithMissingRequiredFieldsTestDataProvider")
    public void doNotCreateJobWithMissingRequiredFieldsTest(String jobPost, String employmentType, String department,
                                                            String officeLocation, String date) {
        JobsPage jobsPage = PageFactory.initElements(driver, JobsPage.class);
        jobsPage.doNotCreateJobWithMissingRequiredFields(jobPost, employmentType, department, officeLocation, date);
        Assert.assertTrue(jobsPage.toastText.contains("form cannot be completed"));
        System.out.println("\nResult for Test(doNotCreateJobWithMissingRequiredFieldsTest): "
                + jobsPage.toastText +"(Missing required fields)\n");
    }


    @DataProvider
    private Object[][] dataForSearchJobByStatusTest(){
        Object[][] data = {{"Draft"}, {"Open"}, {"Closed"}, {"Archived"}};
        return data;
    }
    @Test(priority = 5, dataProvider = "dataForSearchJobByStatusTest")
    public void searchJobByStatusTest(String status) {
        JobsPage jobsPage = PageFactory.initElements(driver, JobsPage.class);
        jobsPage.searchJobByStatus(status);
        Assert.assertTrue(jobsPage.totalNumberOfJobsFound.getText().contains("according to filters"));
    }


    @DataProvider
    private Object[][] dataForSearchJobByDepartmentTest() {
        Object[][] data = {{"Accounting"}, {"Human Resources"}, {"Legal"}, {"Devops"}, {"Quality Assurance"}};
        return data;
    }
    @Test(priority = 6, dataProvider = "dataForSearchJobByDepartmentTest")
    public void searchJobByDepartment(String department) {
        JobsPage jobsPage = PageFactory.initElements(driver, JobsPage.class);
        jobsPage.searchJobByDepartment(department);
        Assert.assertTrue(jobsPage.totalNumberOfJobsFound.getText().contains("according to filters"));
    }


    @DataProvider
    private Object[][] dataForSearchJobByProjectNameTest() {
        Object[][] data = {{"Soft Solutions Inc."}};
        return data;
    }
    @Test(priority = 7, dataProvider = "dataForSearchJobByProjectNameTest")
    public void searchJobByProjectNameTest(String projectName) {
        JobsPage jobsPage = PageFactory.initElements(driver, JobsPage.class);
        jobsPage.searchJobByProjectName(projectName);
        Assert.assertTrue(jobsPage.totalNumberOfJobsFound.getText().contains("according to filters"));
    }


    @DataProvider
    private Object[][] dataForSearchJobByRecruiterNameTest() {
        Object[][] data = {{"Sandra Bullocks"}, {"John Mird"}, {"Sylvester Stallone"}};
        return data;
    }
    @Test(priority = 8, dataProvider = "dataForSearchJobByRecruiterNameTest")
    public void searchJobByRecruiterNameTest(String recruiterName) {
        JobsPage jobsPage = PageFactory.initElements(driver, JobsPage.class);
        jobsPage.searchJobByRecruiterName(recruiterName);
        Assert.assertTrue(jobsPage.totalNumberOfJobsFound.getText().contains("according to filters"));
    }
}
