package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static io.qameta.allure.Allure.step;

public class PlaceHolderComponent {
  
  private final SelenideElement element;
  private final String description;
  
  public PlaceHolderComponent(String description, SelenideElement element) {
    this.element = element;
    this.description = description;
  }
  
  public PlaceHolderComponent shouldHaveText(String text) {
    step("[%s] содержит текст".formatted(description), () -> element.shouldHave(attribute("placeholder", text)));
    return this;
  }
  
  public PlaceHolderComponent click() {
    step("Нажали на [%s]".formatted(description), () -> element.click());
    return this;
  }
  
}