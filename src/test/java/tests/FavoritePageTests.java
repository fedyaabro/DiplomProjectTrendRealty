package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.BuildPage;
import pages.FavoritePage;
import pages.MainPage;

import static testdata.Builds.SPB_BUILDER;
import static testdata.Cities.SPB;


public class FavoritePageTests {
  
  MainPage mp = new MainPage();
  FavoritePage fp = new FavoritePage();
  BuildPage bp = new BuildPage();
  
  //
  @Feature("TrendRealty.Страница избранного")
  @Story("Добавление в избранное")
  @DisplayName("Проверяем добавление жк в избранное")
  @Owner("Абросимов Федор")
  @Test
  void favoriteAddingIsSuccess() {
    
    mp.openMainPage(SPB);
    bp.openBuildPage(SPB_BUILDER);
    bp.addToFavorite();
    bp.addToFavoriteBtnShouldChange();
    fp.openFavoritePage();
    fp.addedBuildHaveCorrectName(SPB_BUILDER.buildNameTitle);
  }
  
  @Feature("TrendRealty.Страница избранного")
  @Story("Удаление из избранного")
  @DisplayName("Проверяем добавление жк в избранное")
  @Owner("Абросимов Федор")
  @Test
  void removeFromFavoriteIsSuccess() {
    bp.openBuildPage(SPB_BUILDER);
    bp.addToFavorite();
    bp.addToFavoriteBtnShouldChange();
    fp.openFavoritePage();
    fp.addedBuildHaveCorrectName(SPB_BUILDER.buildNameTitle);
    fp.removeFromFavorite();
    fp.favoritePageIsEmpty();
    
  }
}