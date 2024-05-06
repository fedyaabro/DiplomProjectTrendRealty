package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static io.qameta.allure.Allure.step;

public class NotFoundPluginComponent {
  
  private final SelenideElement element;
  private final String description;
  
  public NotFoundPluginComponent(String description, SelenideElement element) {
    this.element = element;
    this.description = description;
  }
  
  public NotFoundPluginComponent shouldHaveElement(String attributeName, String attributeValue) {
    step("[%s] содержит элемент".formatted(description), () -> element.shouldHave(attribute(attributeName, attributeValue)));
    return this;
  }
  
  public NotFoundPluginComponent shouldBeVisible() {
    step("[%s] отображается".formatted(description), () -> element.shouldBe(visible));
    return this;
  }
  
  
  public NotFoundPluginComponent click() {
    step("Нажали на [%s]".formatted(description), () -> element.click());
    return this;
  }
  
}