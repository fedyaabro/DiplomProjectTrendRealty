package pages.components.filter;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class ButtonMetro {
  
  
  private final String description = "[Кнопка 'Метро']";
  private final SelenideElement metroButton = $(".location-controls").lastChild();
  
  @Step(description + "Клик на кнопку")
  public ButtonMetro click() {
    metroButton.click();
    return this;
  }
  
}
