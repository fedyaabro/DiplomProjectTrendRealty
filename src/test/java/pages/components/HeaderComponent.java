package pages.components;

import com.codeborne.selenide.SelenideElement;
import testdata.Cities;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static io.qameta.allure.Allure.step;

public class HeaderComponent {
  
  private final SelenideElement element;
  private final String description;
  
  public HeaderComponent(String description, SelenideElement element) {
    this.element = element;
    this.description = description;
  }
  
  public HeaderComponent shouldBeVisible() {
    step("[%s] отображается".formatted(description), () -> element.shouldBe(visible));
    return this;
  }

  public HeaderComponent click() {
    step("Нажали на [%s]".formatted(description), () -> element.click());
    return this;
  }
  
  public HeaderComponent shouldHaveText(String text) {
    step("[%s] содержит текст".formatted(description), () -> element.shouldHave(text(text)));
    return this;
  }
  
  public HeaderComponent hover() {
    step("Открылся список при наведении на [%s]".formatted(description), () -> element.hover());
    return this;
  }
  
  public HeaderComponent clickOnChosenCity(Cities cityName) {
    step("Кликаем на выбранный город из [%s]".formatted(description), () -> element.$(byText(cityName.cityName)).click());
    return this;
  }
  
}