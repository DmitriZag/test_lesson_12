package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTest {
@Test
public void testIssueTitleSearch() {
    SelenideLogger.addListener("allure", new AllureSelenide());

    open("https://github.com");

    $(".search-input").click();
    $("[id=query-builder-test]").sendKeys("DmitriZag/test_lesson_12");
    $("[id=query-builder-test]").submit();

    $(linkText("DmitriZag/test_lesson_12")).click();
    $("#issues-tab").click();
    $(withText("My New Issue")).should(Condition.visible);
}

}