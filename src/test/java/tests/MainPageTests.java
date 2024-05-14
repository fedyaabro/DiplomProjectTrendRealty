package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.NotFoundPage;

import static testdata.City.MOSCOW;
import static testdata.City.SPB;

@Tag("regress")
@Owner("Абросимов Федор")
public class MainPageTests extends BaseTest {
  
  MainPage mainPage = new MainPage();
  NotFoundPage notFoundPage = new NotFoundPage();
  
  @Feature("TrendRealty.Главная страница")
  @Story("Смена города на главной странице")
  @DisplayName("Проверяем смену города c СПБ на МСК")
  @Description("""
    Шаги:
    1. открыть главную
    2. в хедере нажать на текущий город
    3. кликнуть на город из дропдауна
    
    Ожидаемый результат:
    * url изменился согласно выбранному городу
    * текущий город в хедере изменился""")
  @Test
  void cityChangingShouldBeSuccess() {
    mainPage.open();
    mainPage.header.buttonCity
      .shouldHaveCity(SPB)
      .hover()
      .modalSelectCity
      .shouldBeVisible()
      .clickOnChosenCity(MOSCOW);
    mainPage.header.buttonCity
      .shouldHaveCity(MOSCOW);
    mainPage.urlShouldBeChanged(MOSCOW);
  }
  
  @Feature("TrendRealty.Главная страница")
  @Story("Строка поиска")
  @DisplayName("Проверяем смену плейсхолдера при клике на строку поиска")
  @Description("""
    Шаги:
    1. Открыть главную
    2. Строка поиска имеет плейсхолдер 'ЖК, улица, застройщик, банк'
    3. Кликнуть на плейсхолдер
    
    Ожидаемый результат:
    * плейсхолдео сменился на 'Поиск по названию ЖК, застройщику, метро, району, улице или банку'""")
  @Test
  void placeholderShouldBeChangeAfterClick() {
    mainPage.open();
    mainPage.filter.searchField
      .placeholderShouldHaveText("ЖК, улица, застройщик, банк")
      .click()
      .placeholderShouldHaveText("Поиск по названию ЖК, застройщику, метро, району, улице или банку");
  }
  
  
  @Feature("TrendRealty.Главная страница")
  @Story("Строка поиска")
  @DisplayName("Проверяем открытие карты метро")
  @Description("""
    Шаги:
    1. Открыть главную СПБ или МСК
    2. Нажать кнопку 'Метро' в строке поиска
    
    Ожидаемый результат:
    * Открыта модалка с картой метро'""")
  @Test
  void metroButtonAreOpenMetroMap() {
    mainPage.open();
    mainPage.filter.buttonMetro
      .click();
    mainPage.filter.metroMap
      .shouldBeVisible();
  }
  
  @Feature("TrendRealty.Невалидная страница")
  @Story("404 страница")
  @DisplayName("Проверяем что 404 содержит анимацию и кнопку возврата на главную")
  @Description("""
    Шаги:
      Открыть невалидную страницу /invalidPage
      
   
    Ожидаемый результат:
    * Открыта 404 cтраница с анимацией и кнопкой возврата на главную'""")
  @Test
  void notFoundPageHasRedirectButton() {
    notFoundPage.open();
    notFoundPage.animation
      .shouldBeVisible();
    notFoundPage.buttonReturn
      .click();
    mainPage.shouldHaveTitle("Первое цифровое агентство недвижимости");
    
  }
  
}
    

