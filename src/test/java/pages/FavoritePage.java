package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.block.FavoriteBlock;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class FavoritePage {
  
  public final FavoriteBlock addedBlock = new FavoriteBlock();
  
  private final SelenideElement emptyStatusTitle = $(".status-loading__empty .h4");
  
  
  @Step("Открываем страницу Избранное")
  public void open() {
    Selenide.open("/favorites");
  }
  
  @Step("Проверяем, что в избранном пусто по наличию заглушки 'Вы пока ничего не добавили'")
  public void emptyFavoritePageHasTitle(String text) {
    emptyStatusTitle.shouldHave(text(text));
    
  }
  
}
