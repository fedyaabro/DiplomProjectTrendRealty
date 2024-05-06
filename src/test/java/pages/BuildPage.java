package pages;

import helpers.SetupCookie;
import io.qameta.allure.Step;
import pages.components.HeaderComponent;
import testdata.Builds;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BuildPage {
  
  public HeaderComponent like() {
    return new HeaderComponent("Кнопка [Добавить в избранное]]", $(".object-header__favorites-distribute-desktop .like"));
  }
  
  public HeaderComponent likeActive() {
    return new HeaderComponent("Кнопка [В избранном]]", $(".object-header__favorites-distribute-desktop .like_active"));
  }
  
  @Step("Открываем главную страницу с тестовым застройщиком")
  public BuildPage openBuildPage(Builds builderUrl) {
    open(builderUrl.buildNameUrl);
    return this;
  }
  
  @Step("Добавляем в избранное")
  public BuildPage addToFavorite() {
    like().click();
    return this;
  }
  @Step("Смотрим, что кнопка [Добавить в избранное сменилась на [В избранном]")
  public BuildPage addToFavoriteBtnShouldChange() {
    likeActive().shouldBeVisible();
    return this;
  }
  
}