package tests;

import config.BaseTest;
import helpers.SetupCookie;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.NotFoundPage;

import static testdata.Cities.MOSCOW;
import static testdata.Cities.SPB;

@Tag("regress")
public class MainPageTests extends BaseTest {
  
  MainPage mp = new MainPage();
  NotFoundPage nfp = new NotFoundPage();
  SetupCookie sc = new SetupCookie();
  
  @Feature("TrendRealty.Главная страница")
  @Story("Смена города на главной странице")
  @DisplayName("Проверяем смену города")
  @Owner("Абросимов Федор")
  @Test
  void cityChangingShouldBeSuccess() {
    mp.openMainPage(SPB);
    mp.openCitySelect();
    mp.chooseCity(MOSCOW);
    mp.urlShouldBeChanged(MOSCOW);
    mp.btnNameShouldBeChange(MOSCOW);
  }
  
  @Feature("TrendRealty.Главная страница")
  @Story("Строка поиска")
  @DisplayName("Проверяем смену плейсхолдера при клике на строку поиска")
  @Owner("Абросимов Федор")
  @Test
  void placeholderShouldBeChangeAfterClick() {
    mp.openMainPage(SPB);
    mp.placeHoldelShouldHaveText("ЖК, улица, застройщик, банк");
    mp.searchField().click();
    mp.placeHoldelShouldHaveText("Поиск по названию ЖК, застройщику, метро, району, улице или банку");
  }
  
  @Feature("TrendRealty.Главная страница")
  @Story("Строка поиска")
  @DisplayName("Проверяем открытие карты метро")
  @Owner("Абросимов Федор")
  @Test
  void metroButtonAreOpenMetroMap() {
    mp.openMainPage(SPB);
    mp.clickOnMetroButton();
    mp.metroButton().shouldBeVisible();
  }
  
  @Feature("TrendRealty.Невалидная страница")
  @Story("404 страница")
  @DisplayName("Проверяем что 404 содержит анимацию и кнопку возврата на главную")
  @Owner("Абросимов Федор")
  @Test
  void notFoundPageHasRedirectButton() {
    nfp.openInvalidPage();
    nfp.returnButton().shouldBeVisible();
    nfp.animationShouldBeVisible();
    nfp.returnToMainPage();
    mp.mainPageTitle().shouldHaveText("Первое цифровое агентство недвижимости");
    
  }
  
  
}
    

