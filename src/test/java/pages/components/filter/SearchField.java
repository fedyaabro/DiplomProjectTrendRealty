package pages.components.filter;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.$;

public class SearchField {
  
  private final SelenideElement searchField = $(".field__element input");
  private final String description = "[Строка поиска]";
  
  @Step(description + " Плейсхолдер содержит текст")
  public SearchField placeholderShouldHaveText(String text) {
    searchField.shouldHave(attribute("placeholder", text));
    return this;
  }
  
  @Step(description + "Нажимаем на поле поиска")
  public SearchField click() {
    searchField.click();
    return this;
  }
}