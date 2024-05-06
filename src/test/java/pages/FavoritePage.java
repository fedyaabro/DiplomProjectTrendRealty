package pages;

import io.qameta.allure.Step;
import pages.components.BuildCardComponent;
import pages.components.HeaderComponent;
import testdata.URLs;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FavoritePage {
  
  public BuildCardComponent buildCard() {
    return new BuildCardComponent("Карточка выбранного жк", $(".favorite-item__container .obj-card"));
  }
  
  public BuildCardComponent removeFromFavoriteBtn() {
    return new BuildCardComponent("Кнопка Убрать из избранного", $(".obj-card-footer__button_like"));
  }
  public HeaderComponent emptyFavoritePlaceholder() {
    return new HeaderComponent("Плейсхолдер 'Вы пока ничего не добавили'", $(".status-loading__empty .h4"));
  }
  
//  public FavoritePage favoritePage(){
//    return new FavoritePage();
//  }
  
  @Step("Открываем страницу Избранное")
  public FavoritePage openFavoritePage() {
    open(URLs.FAVORITE_PAGE.favoritePage);
    return this;
  }
  
  @Step("Убираем из избранного нажатием на кнопку 'Убрать из избранного'")
  public FavoritePage removeFromFavorite() {
    removeFromFavoriteBtn().click();
    return this;
  }
  
  @Step("Проверяем, что в избранном пусто по наличию заглушки 'Вы пока ничего не добавили'")
  public FavoritePage favoritePageIsEmpty() {
    emptyFavoritePlaceholder().shouldHaveText("Вы пока ничего не добавили");
    return this;
  }
   @Step("Проверяем название добавленного жк")
  public FavoritePage addedBuildHaveCorrectName(String buildName) {
    buildCard().shouldHaveTitle(buildName);
    return this;
  }
  
}
