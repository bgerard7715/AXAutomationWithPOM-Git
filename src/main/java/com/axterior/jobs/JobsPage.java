package com.axterior.jobs;

import com.axterior.base.WebPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class JobsPage extends WebPage {

    @FindBy(css = "button[type='button']")
    protected WebElement expandSideBarIcon;
    @FindBy(css = "a[href='/jobs']")
    protected WebElement jobsModule;
    @FindBy(css = "a[href='/jobs/new']")
    protected WebElement createButton;
    @FindBy(css = "input[id='Job title']")
    protected WebElement jobTitleDropdown;
    @FindBy(css = "ul[role='listbox-hack'] > li")
    protected List<WebElement> listOfJobTitles;
    @FindBy(css = "div[aria-labelledby='Qualification level']")
    protected WebElement qualificationLevelDropdown;
    @FindBy(css = "ul[role='listbox'] > li")
    protected List<WebElement> listOfQualificationLevel;
    @FindBy(css = "div[aria-labelledby='Type of employment']")
    protected WebElement typeOfEmploymentDropdown;
    @FindBy(css = "ul[role='listbox'] > li")
    protected List<WebElement> listOfEmploymentTypes;
    @FindBy(css = "input[id='Department']")
    protected WebElement departmentDropdown;
    @FindBy(css = "ul[role='listbox-hack'] > li")
    protected List<WebElement> listOfDepartments;
    @FindBy(css = "input[id='Salary']")
    protected WebElement salaryMinRange;
    @FindBy(css = "input[name='salary.maxSalary']")
    protected WebElement salaryMaxRange;
    @FindBy(css = "input[data-cy='officeAutocomplete'] + div > button")
    protected WebElement officeDropdown;
    @FindBy(css = "ul[role='listbox-hack'] > li")
    protected List<WebElement> listOfOffices;
    @FindBy(css = "input[data-cy='projectAutocomplete'] + div > button")
    protected WebElement projectDropdown;
    @FindBy(xpath = "//li[contains(text(), 'Soft Solutions Inc.')]")
    protected WebElement selectProject;
    @FindBy(css = "input[id='Target date']")
    protected WebElement targetDate;
    @FindBy(css = "div[aria-labelledby='Recruiter']")
    protected WebElement recruiterDropdown;
    @FindBy(css = "ul[aria-labelledby='Recruiter'] > li")
    protected List<WebElement> listOfRecruiters;
    @FindBy(css = "div[aria-labelledby='Hiring manager']")
    protected WebElement hiringManagerDropdown;
    @FindBy(xpath = "//li[text()='Sean Testlio']")
    protected WebElement selectHiringManager;
    @FindBy(css = "input[data-cy='locationCountryInput'] + div > button")
    protected WebElement countryDropdown;
    @FindBy(css = "ul[role='listbox-hack'] > li")
    protected List<WebElement> listOfCountries;
    @FindBy(css = "input[data-cy='locationCityInput']")
    protected  WebElement city;
    @FindBy(xpath = "//li[@data-cy='locationCityInputItem0']")
    protected WebElement selectCityFromDropdown;
    @FindBy(css = "input[placeholder='Search skill']")
    protected WebElement addSkillsField;
    @FindBy(css = "label[for='Description'] + div > div > div:nth-child(2) > div > p")
    protected WebElement jobDescription;
    @FindBy(css = "button[type='submit']")
    protected WebElement saveButton;
    @FindBy(css = "div[class='Toastify'] > div > div > div > div > div > div > p")
    protected WebElement toastElement;
    public String toastText;

    public JobsPage(WebDriver driver) {
        super(driver);
    }

    public void createJobPostWithAllAvailableFields(String jobPost, String qualificationLevel, String employmentType, String department,
                                                    String minSalary, String maxSalary, String officeLocation, String date,
                                                    String recruiterName, String country, String cityName, String skill, String sampleText) {
        expandSideBarIcon.click();
        jobsModule.click();
        createButton.click();
        jobTitleDropdown.click();
        chooseFromList(listOfJobTitles, jobPost);
        qualificationLevelDropdown.click();
        waitForVisibilityOfAllElements(listOfQualificationLevel);
        chooseFromList(listOfQualificationLevel, qualificationLevel);
        typeOfEmploymentDropdown.click();
        chooseFromList(listOfEmploymentTypes, employmentType);
        departmentDropdown.click();
        chooseFromList(listOfDepartments, department);
        salaryMinRange.sendKeys(minSalary);
        salaryMaxRange.sendKeys(maxSalary);
        officeDropdown.click();
        chooseFromList(listOfOffices, officeLocation);
        projectDropdown.click();
        selectProject.click();
        targetDate.sendKeys(date);
        ((JavascriptExecutor) driver).executeScript("document.querySelector(\"div[aria-labelledby='Recruiter']\").scrollIntoView();");
        recruiterDropdown.click();
        waitForVisibilityOfAllElements(listOfRecruiters);
        chooseFromList(listOfRecruiters, recruiterName);
        hiringManagerDropdown.click();
        selectHiringManager.click();
        countryDropdown.click();
        chooseFromList(listOfCountries, country);
        city.sendKeys(cityName);
        selectCityFromDropdown.click();
        addSkillsField.sendKeys(skill);
        jobDescription.sendKeys(sampleText);
        saveButton.click();
        waitForVisibilityOfElement(toastElement);
        toastText = toastElement.getText();
        pause(5);

    }


    public void createJobOnlyWithRequiredFields(String jobPost, String employmentType, String department,
                                                String officeLocation, String date, String recruiterName) {
        expandSideBarIcon.click();
        jobsModule.click();
        createButton.click();
        jobTitleDropdown.click();
        chooseFromList(listOfJobTitles, jobPost);
        typeOfEmploymentDropdown.click();
        waitForVisibilityOfAllElements(listOfEmploymentTypes);
        chooseFromList(listOfEmploymentTypes, employmentType);
        departmentDropdown.click();
        chooseFromList(listOfDepartments, department);
        officeDropdown.click();
        chooseFromList(listOfOffices, officeLocation);
        targetDate.sendKeys(date);
        ((JavascriptExecutor) driver).executeScript("document.querySelector(\"div[aria-labelledby='Recruiter']\").scrollIntoView();");
        recruiterDropdown.click();
        waitForVisibilityOfAllElements(listOfRecruiters);
        chooseFromList(listOfRecruiters, recruiterName);
        saveButton.click();
        waitForVisibilityOfElement(toastElement);
        toastText = toastElement.getText();
        pause(5);
    }

    public void chooseFromList(List<WebElement> list, String option) {
        for(WebElement w : list) {
            if(w.getText().equalsIgnoreCase(option)) {
                w.click();
                break;
            }
        }
    }
}
