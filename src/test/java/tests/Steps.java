package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
public class Steps {
    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Ищем репозиторий {REPOSITORY}")
    public void searchForRepository(String REPOSITORY) {
        $(".search-input").click();
        $("[id=query-builder-test]").sendKeys(REPOSITORY);
        $("[id=query-builder-test]").submit();
    }

    @Step("Кликаем по ссылке репозитория {REPOSITORY}")
    public void clickOnRepository(String REPOSITORY) {
        $(linkText(REPOSITORY)).click();
    }

    @Step("Открываем вкладку Issues")
    public void openIssuesTab() {
        $("#issues-tab").click();
    }

    @Step("Проверяем наличие Issue с названием {ISSUE}")
    public void shouldSeeIssueWithName(String ISSUE) {
        $(withText(ISSUE)).should(Condition.visible);
    }

}
