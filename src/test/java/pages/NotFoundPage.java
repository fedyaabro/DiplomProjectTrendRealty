package pages;

import io.qameta.allure.Step;
import pages.components.NotFoundPluginComponent;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class NotFoundPage {
  
  public NotFoundPluginComponent returnButton() {
    return new NotFoundPluginComponent("Кнопка возврата на главную", $(".not-found__button"));
  }
  
  public NotFoundPluginComponent animation() {
    return new NotFoundPluginComponent("Анимация", $(".not-found__animated img"));
  }
  
  @Step("Открываем невалидную страницу")
  public NotFoundPage openInvalidPage() {
    open("https://trendrealty.ru/invalidPage");
    return this;
  }
  
  @Step("Кликаем на кнопку 'На главную'")
  public NotFoundPage returnToMainPage() {
    returnButton().click();
    return this;
  }
  
  @Step("Смотрим, что анимация есть на странице")
  public NotFoundPage animationShouldBeVisible() {
    animation().shouldBeVisible();
    animation().shouldHaveElement("src", "https://trendrealty.ru/images/49dc34d43b83e4739e4c.png");
    return this;
  }
  
}
