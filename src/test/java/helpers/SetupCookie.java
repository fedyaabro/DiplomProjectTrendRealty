package helpers;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class SetupCookie {
  
  @Step("Пробрасываем куки")
  public SetupCookie addCookie() {
    open("https://trendrealty.ru/images/favicons/favicon.ico");
    getWebDriver().manage().addCookie(new org.openqa.selenium.Cookie("selected_city", "58c665588b6aa52311afa01b"));
    return this;
  }
}
