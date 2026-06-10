import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class AttachmentsTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example\"";

    @Test
    public void testLambdaAttachments() {
        SelenideLogger.addListener("allure", new AllureSelenide());
         step("Открываем главную страницу", () -> {
        open("https://github.com/");
        attachment("Source", Objects.requireNonNull(webdriver().driver().source()));
         });
         step("Ищем репозиторий " + REPOSITORY, () -> {
             $("[data-target='qbsearch-input.inputButton']").click();

             $("#query-builder-test").shouldBe(visible).setValue(REPOSITORY);
             $("#query-builder-test").pressEnter();
         });
        step("Кликаем по ссылке репозитория " + REPOSITORY, () -> {
            $(linkText("eroshenkoam/allure-example")).click();
        });


        // Проверяем результат
        //$("[data-testid='results-list']").shouldBe(visible);
    }

    @Test
    public void testAnnotatedAttachments() {
        WebSteps steps = new WebSteps();
        steps.openMainpage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
    }
}
