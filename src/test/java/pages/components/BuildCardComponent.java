package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.attribute;
import static io.qameta.allure.Allure.step;

public class BuildCardComponent {
  
  private final SelenideElement element;
  private final String description;
  
  public BuildCardComponent(String description, SelenideElement element) {
    this.element = element;
    this.description = description;
  }
  
  public BuildCardComponent click() {
    step("Нажали на [%s]".formatted(description), () -> element.click());
    return this;
  }
  
  public BuildCardComponent shouldHaveTitle(String title) {
    step("Карточка ЖК содержит текст [%s]".formatted(description), () -> {
      return element.shouldHave(attribute("title", title));
    });
    return this;
  }
  
  
}
