package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.BlockPage;
import pages.FavoritePage;

import static testdata.Blocks.TSVETNOY_GOROD;

@Tag("regress")
public class FavoritePageTests extends BaseTest {
  
  FavoritePage favoritePage = new FavoritePage();
  BlockPage blockPage = new BlockPage();
  
  @Feature("TrendRealty.Страница избранного")
  @Story("Добавление в избранное")
  @DisplayName("Проверяем добавление жк в избранное")
  @Owner("Абросимов Федор")
  @Description("""
    Шаги:
    1. Открыть страницу ЖК Цветной город
    2. Нажать кнопку 'Добавить в избранное'
    
    Ожидаемый результат:
    * Кнопка изменилась на 'В избранном'
    * На странице избранного отображается ЖК Цветной город""")
  @Test
  void favoriteAddingIsSuccess() {
    blockPage.open(TSVETNOY_GOROD);
    blockPage.header.buttonLike
      .click();
    blockPage.header.buttonLikeActive
      .shouldBeVisible();
    favoritePage.open();
    favoritePage.addedBlock
      .shouldHaveName(TSVETNOY_GOROD.name);
  }
  
  @Feature("TrendRealty.Страница избранного")
  @Story("Удаление из избранного")
  @DisplayName("Проверяем удаление жк из избранного")
  @Owner("Абросимов Федор")
  @Description("""
    Шаги:
    1. Открыть страницу ЖК Цветной город
    2. Нажать кнопку 'Добавить в избранное'
    3. Открыть страницу избранного
    4. Нажать кнопку 'Убрать из избранного'
    
    Ожидаемый результат:
    * Выбраный жк убран из избранного
    * На странице избранного отображается плейсхолдер 'Вы пока ничего не добавили'""")
  @Test
  void removeFromFavoriteIsSuccess() {
    blockPage.open(TSVETNOY_GOROD);
    blockPage.header.buttonLike
      .click();
    blockPage.header.buttonLikeActive
      .shouldBeVisible();
    favoritePage.open();
    favoritePage.addedBlock
      .shouldHaveName(TSVETNOY_GOROD.name);
    favoritePage.addedBlock.buttonLike
      .clickForRemove();
    favoritePage.emptyFavoritePageHasTitle("Вы пока ничего не добавили");
  }
}