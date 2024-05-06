package pages;

import com.codeborne.selenide.WebDriverConditions;
import helpers.SetupCookie;
import io.qameta.allure.Step;
import pages.components.HeaderComponent;
import pages.components.PlaceHolderComponent;
import pages.components.PopupComponent;
import pages.components.SearchFieldComponent;
import testdata.Cities;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {
  
  public HeaderComponent locationButton() {
    return new HeaderComponent("Кнопка смены города", $(".header-layout-desktop .header-city-select button"));
  }
  
  public HeaderComponent locationSelect() {
    return new HeaderComponent("Список городов", $(".city-select__tooltip"));
  }
  
  public PopupComponent metroMapPopup() {
    return new PopupComponent("Попап с картой метро", $(".filter-subways__map"));
  }
  
  public SearchFieldComponent metroButton() {
    return new SearchFieldComponent("Кнопка Метро", $(".location-controls").lastChild());
  }
  
  public PlaceHolderComponent searchField() {
    return new PlaceHolderComponent("Строка поиска", $(".field__element input"));
  }
  
  public HeaderComponent mainPageTitle() {
    return new HeaderComponent("Загаловок главной страницы", $(".main-top__title .d-md-block"));
  }
  
  @Step("Открываем главную страницу")
  public MainPage openMainPage(Cities city) {
    open(city.cityUrl);
    return this;
  }
  
  @Step("Открываем выбор города")
  public MainPage openCitySelect() {
    locationButton().hover();
    return this;
  }
  
  @Step("Выбираем город из списка")
  public MainPage chooseCity(Cities cityName) {
    locationSelect().clickOnChosenCity(cityName);
    return this;
  }
  
  @Step("Проверяем, что URl сменился")
  public MainPage urlShouldBeChanged(Cities cityUrl) {
    webdriver().shouldHave(WebDriverConditions.url(cityUrl.cityUrl));
    return this;
  }
  
  @Step("Проверяем, что название кнопки выбора города сменилось")
  public MainPage btnNameShouldBeChange(Cities cityName) {
    locationButton().shouldHaveText(cityName.cityName);
    return this;
  }
  
 @Step("Проверяем, что в плейсхолдере содежится текст")
  public MainPage placeHoldelShouldHaveText(String text) {
    searchField().shouldHaveText(text);
    return this;
  }
  
 @Step("Кликаем на плейсхолдер")
  public MainPage clickOnSearchField() {
    searchField().click();
    return this;
  }
  
@Step("Кликаем на кнопку Mетро")
  public MainPage clickOnMetroButton() {
    metroButton().click();
    return this;
  }
  
@Step("Смотрим, что открылась карта Mетро")
  public MainPage metroMApShouldBeVisible() {
    metroMapPopup().shouldBeVisible();
    return this;
  }


//  @Step("Открываем главную страницу с тестовым застройщиком")
//  public MainPage openBuildPage(Builds builderUrl) {
//    open(builderUrl.buildNameUrl);
//    return this;
//  }


}
