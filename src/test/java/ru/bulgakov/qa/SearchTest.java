package ru.bulgakov.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class SearchTest {
@Test
void mentoringPriceShouldBe47000Test() {
    /*
    *Тест-кейс - проверить, что предоплата по обучению 47000 рублей
    * 1. Открыть поисковик (Яндекс)
    * 2. Вести данные сайта (bulgakov qa)
    * 3. Нажать кнопку поиск
    * 4. В поисковой выдаче найти нужный сайт, кликнуть на него
    * 5. Нажать кнопку "Стоимость"
    * 6. Нажать на кнопку "Хочу вкатиться в QA"
    * 7. Нажать кнопку "Бегу оплачивать"
    * 8.Проверить, что к оплате 47000 р
    *
     */

    Configuration.holdBrowserOpen = false;

    open("https://ya.ru");
    $("#text").setValue("bulgakov qa");
    $("[type=submit]").click();
    if ($(".DistributionButtonClose").exists()) {
        $(".DistributionButtonClose").click();
    }

    $(byText("ivanbulgakovqa.ru")).click();
    switchTo().window(1);

  $$(".t-menu__list li").last().click(); //xpath
    $(byText("Хочу вкатиться в QA")).click();
    $(byText("Бегу оплачивать")).click();

    switchTo().window(2);

    sleep(3000);

    $$("h3").first().shouldHave(text("₽ 47 000.00"));
}

    @Test
    void monsteraSearchTest() {
        /*
         1. Открыть страницу Википедии
         2. Найти поисковую строку
         3. Ввести "Монстера деликатесная"
         4. Нажать кнопку "Найти"
         5. Проверить, что в результатах поиска есть нужная статья
         */

        Configuration.holdBrowserOpen = true;

        open("https://ru.wikipedia.org/");
        $("[name=search]").setValue("Монстера деликатесная");
        $(".cdx-search-input__end-button").click();
        $$("h1").first().shouldHave(text("Монстера деликатесная"));

}
}