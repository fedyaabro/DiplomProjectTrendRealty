package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverConditions;
import config.ProjectConfig;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;
import pages.components.filter.Filter;
import pages.components.header.Header;
import testdata.City;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;

public class MainPage {
  
  private final SelenideElement
    
    mainPageTitle = $(".main-top__title .d-md-block");
  
  public final Header header = new Header();
  public final Filter filter = new Filter();
  
  @Step("Открываем главную страницу")
  public MainPage open() {
    Selenide.open("/");
    return this;
  }
  
  @Step("Проверяем, что URl сменился")
  public MainPage urlShouldBeChanged(City city) {
    String prefixCity = city.urlPrefix.isEmpty() ? "" : city.urlPrefix + ".";
    String expectedUrl = ConfigFactory.create(ProjectConfig.class).baseUrl().replace("{city}.", prefixCity);
    webdriver().shouldHave(WebDriverConditions.url(expectedUrl + "/"));
    return this;
  }
  
  @Step("Заголовок главной страницы содержит текст")
  public void shouldHaveTitle(String text) {
    mainPageTitle.shouldHave(text(text));
  }
  
}
