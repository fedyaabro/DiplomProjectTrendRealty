package pages.components.header;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import testdata.City;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ButtonCity {
  private final String description = "[Кнопка выбора города] ";
  private final SelenideElement buttonCity = $(".header-layout-desktop .header-city-select button");
  
  public final ModalSelectCity modalSelectCity = new ModalSelectCity();
  
  @Step(description + "Наводим курсор")
  public ButtonCity hover() {
    buttonCity.hover();
    return this;
  }
  
  @Step("Город в кнопке выбора города имеет текст [{city.name}]")
  public ButtonCity shouldHaveCity(City city) {
    buttonCity.shouldHave(text(city.name));
    return this;
  }
  
  
}
