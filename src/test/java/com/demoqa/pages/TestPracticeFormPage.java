package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ResultComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestPracticeFormPage {

    // Elements

    private final CalendarComponent calendarComponent = new CalendarComponent();
    private final ResultComponent resultComponent = new ResultComponent();
    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genterInput = $("#genterWrapper"),
            numberInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            pathToFileInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city");

    private final static String FIRST_TITLE_TEXT = "Student Registration Form";

    //Actions

    public TestPracticeFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(FIRST_TITLE_TEXT));

        return this;
    }

    public TestPracticeFormPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public TestPracticeFormPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public TestPracticeFormPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public TestPracticeFormPage setGenter(String value) {
        genterInput.$(byText(value)).click();

        return this;
    }

    public TestPracticeFormPage setNumber(String value) {
        numberInput.setValue(value);

        return this;
    }

    public TestPracticeFormPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public TestPracticeFormPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public TestPracticeFormPage setHobbies(String value) {
        hobbiesInput.$(byText(value)).click();

        return this;
    }

    public TestPracticeFormPage setPathFile(String value) {
        pathToFileInput.uploadFile(new File(value));

        return this;
    }

    public TestPracticeFormPage setAddress(String value) {
        addressInput.setValue(value);

        return this;
    }

    public TestPracticeFormPage setState(String value) {
        $("#state").scrollTo().click();
        stateInput.$(byText(value)).click();

        return this;
    }

    public TestPracticeFormPage setCity(String value) {
        $("#city").click();
        cityInput.$(byText(value)).click();

        return this;
    }

                        // CHECK
    public TestPracticeFormPage checkResultVisible() {
        resultComponent.checkVisible();

        return this;
    }
    public TestPracticeFormPage checkResult(String key, String value) {
        resultComponent.checkResult(key, value);

        return this;
    }
}
