package pages.components.header;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import testdata.City;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ModalSelectCity {
  private final String description = "[Модалка выбора города] ";
  private final SelenideElement cityPopup = $(".city-select__tooltip");
  
  
  @Step(description + "Открылось модальное окно с городами")
  public ModalSelectCity shouldBeVisible() {
    cityPopup.shouldBe(visible);
    return this;
  }
  
  @Step(description + "Кликаем на город [{city.name}]")
  public ModalSelectCity clickOnChosenCity(City city) {
    cityPopup.$(byText(city.name)).click();
    return this;
  }
  
}
