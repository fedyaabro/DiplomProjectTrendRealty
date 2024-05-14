package pages.components.notFound;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class Content {
  
  private final SelenideElement image = $(".not-found__animated img");
  
  @Step("Смотрим, что анимация есть на странице")
  public Content shouldBeVisible() {
    image.shouldBe(visible);
    return this;
  }
}
