package pages.components.notFound;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class ButtonReturn {
  
  private final SelenideElement buttonReturn = $(".not-found__button");
  
  @Step("Кликаем на кнопку 'На главную'")
  public ButtonReturn click() {
    buttonReturn.click();
    return this;
  }
  
}
