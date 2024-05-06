package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static io.qameta.allure.Allure.step;

public class SearchFieldComponent {
  
  private final SelenideElement element;
  private final String description;
  
  public SearchFieldComponent(String description, SelenideElement element) {
    this.element = element;
    this.description = description;
  }
  
  public SearchFieldComponent shouldBeVisible() {
    step("[%s] отображается".formatted(description), () -> element.shouldBe(visible));
    return this;
  }
  
  public SearchFieldComponent click() {
    step("Нажали на [%s]".formatted(description), () -> element.click());
    return this;
  }
  
}