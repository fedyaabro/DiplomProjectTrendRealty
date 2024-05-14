package pages.components.block;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ButtonLike {
  
  private final SelenideElement
    like = $(".object-header__favorites-distribute-desktop .like"),
    likeActive = $(".object-header__favorites-distribute-desktop .like_active"),
    likeActiveInFavorite = $(".obj-card-footer__button_like");
  
  @Step("Нажали [Добавить в избранное]")
  public ButtonLike click() {
    like.click();
    return this;
  }
  
  @Step("Кнопка [Добавить в избранное] сменилась на [В избранном]")
  public ButtonLike shouldBeVisible() {
    likeActive.shouldBe(visible);
    return this;
  }
  
  @Step("Убираем из избранного нажатием на кнопку [Сердце]")
  public ButtonLike clickForRemove() {
    likeActiveInFavorite.click();
    return this;
  }
  
  
}
