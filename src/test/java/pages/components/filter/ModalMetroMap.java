package pages.components.filter;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ModalMetroMap {
  
  private final SelenideElement metroMapPopup = $(".filter-subways__map");
  private final String description = "[Карта метро]";
  
  @Step(description + "Открылась карта метро")
  public ModalMetroMap shouldBeVisible() {
    metroMapPopup.shouldBe(visible);
    return this;
  }
}
