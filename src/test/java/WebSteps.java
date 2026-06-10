import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {
    @Step ("Открываем главную страницу")
    public void openMainpage() {
        open("https://github.com/");
    }
    @Step ("Ищем репозиторий")
    public void searchForRepository (String repo) {
        $("[data-target='qbsearch-input.inputButton']").click();

        $("#query-builder-test").shouldBe(visible).setValue(repo);
        $("#query-builder-test").pressEnter();
    }
    @Step ("Кликаем по ссылке репозитория")
    public void clickOnRepositoryLink(String repo) {
        $(linkText("eroshenkoam/allure-example")).click();
    }
}
