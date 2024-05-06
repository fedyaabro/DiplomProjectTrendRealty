package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static io.qameta.allure.Allure.step;

public class PopupComponent {
  
  private final SelenideElement element;
  private final String description;
  
  public PopupComponent(String description, SelenideElement element) {
    this.element = element;
    this.description = description;
  }
  
  public PopupComponent shouldBeVisible() {
    step("[%s] отображается".formatted(description), () -> element.shouldBe(visible));
    return this;
  }
   public PopupComponent shouldNotBeVisible() {
    step("[%s]  не отображается".formatted(description), () -> element.shouldNot(visible));
    return this;
  }
  public PopupComponent click() {
    step("Нажали на [%s]".formatted(description), () -> element.click());
    return this;
  }
  
}