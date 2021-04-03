package tests;

import base.TestBase;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WaitForItTest extends TestBase {

    @Before
    public void openPage() {
        open( "/waitforit.php");
    }

    @Test
    public void waitForValue() {
        String expectedText = "dary !!!";
        $(By.id("startWaitForText")).click();
        $(By.id("waitForTextInput")).shouldHave(value(expectedText));
    }

    @Test
    public void waitForClass() {
        $(By.id("startWaitForProperty")).click();

        $(byId("waitForProperty")).shouldHave(cssClass("error"));
    }

    @Test
    public void itShouldDisplayResponseTimeMessageSelenide() {
        $(By.id("startWaitForText")).click();

        $("div.current-wait-time").shouldHave(text("Response time was"));
        }
}
