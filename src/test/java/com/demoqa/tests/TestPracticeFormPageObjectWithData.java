package com.demoqa.tests;

import com.demoqa.pages.TestPracticeFormPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.demoqa.tests.TestData.*;

public class TestPracticeFormPageObjectWithData extends TestBase{
    TestPracticeFormPage testPracticeFormPage = new TestPracticeFormPage();

//    String firstName,
//            lastName,
//            email,
//            number,
//            currentAddress;
//
//    @BeforeEach
//    void prepareTestData() {
//        firstName = "Ivan";
//        lastName = "Navi";
//        email = "Ivan@navi.com";
//        number = "8999000881";
//        currentAddress = "currentAddress";
//    }

    @Test
    void practiceFormTest() {
        testPracticeFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGenter("Female")
                .setNumber(number)
                .setBirthDate("5", "June", "1994")
                .setSubjects("Physics")
                .setHobbies("Sports")
                .setPathFile("src/test/resources/JSON_Momoa.jpg")
                .setAddress(currentAddress)
                .setState("Haryana")
                .setCity("Karnal");
        $("#submit").pressEnter();


        testPracticeFormPage.checkResultVisible();
        testPracticeFormPage.checkResult("Student Name", "Ivan Navi")
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
        testPracticeFormPage.openPage()
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
