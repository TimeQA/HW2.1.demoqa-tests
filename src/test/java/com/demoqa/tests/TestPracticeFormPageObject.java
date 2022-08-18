package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.TestPracticeFormPage;
import com.demoqa.pages.components.ResultComponent;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestPracticeFormPageObject {
    TestPracticeFormPage testPracticFormPage = new TestPracticeFormPage();

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void practiceFormTest() {
        testPracticFormPage.openPage()
                .setFirstName("Ivan")
                .setLastName("Navi")
                .setEmail("Ivan@navi.com")
                .setGenter("Female")
                .setNumber("8999000881")
                .setBirthDate("5", "June", "1994")
                .setSubjects("Physics")
                .setHobbies("Sports")
                .setPathFile("src/test/resources/JSON_Momoa.jpg")
                .setAddress("currentAddress")
                .setState("Haryana")
                .setCity("Karnal");
        $("#submit").pressEnter();


        testPracticFormPage.checkResultVisible();
        testPracticFormPage.checkResult("Student Name", "Ivan Navi")
                .checkResult("Student Email", "Ivan@navi.com")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "8999000881")
                .checkResult("Date of Birth", "05 June,1994")
                .checkResult("Subjects", "Physics")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "JSON_Momoa.jpg")
                .checkResult("Address", "currentAddress")
                .checkResult("State and City", "Haryana Karnal");

    }

    @Test
    void practiceFormTestMini() {
        testPracticFormPage.openPage()
                .setFirstName("Ivan")
                .setLastName("Navi")
                .setGenter("Female")
                .setNumber("8999000881");

        $("#dateOfBirthInput").click();
        $("#submit").pressEnter();


        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                text("Ivan Navi"),
                text("Female"),
                text("8999000881"));
    }
}


//        $(".table-responsive table").$(byText("Date of Birth"))
//                .parent().shouldHave((text("05 June,1994")));
