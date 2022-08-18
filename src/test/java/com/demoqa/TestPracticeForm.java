package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestPracticeForm {

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void practiceFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Navi");
        $("#userEmail").setValue("Ivan@navi.com");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("8999000881");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(5);
        $(".react-datepicker__year-select").selectOption("1994");
        $(".react-datepicker__day--023").click();
        $("#subjectsInput").setValue("Physics");
        $("#subjectsInput").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/JSON_Momoa.jpg"));
        $("#currentAddress").setValue("currentAddress");
        $("#state").scrollTo().click();
        $("#state").$(byText("Haryana")).click();
        $("#city").click();
        $("#city").$(byText("Karnal")).click();
        $("#submit").pressEnter();

        $(".modal-dialog").should(appear);
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                text("Ivan Navi"),
                text("Ivan@navi.com"),
                text("Female"),
                text("8999000881"),
                text("23 June,1994"),
                text("Physics"),
                text("Sports"),
                text("JSON_Momoa.jpg"),
                text("currentAddress"),
                text("Haryana Karnal"));
    }
}
