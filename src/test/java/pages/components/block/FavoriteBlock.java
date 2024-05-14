package pages.components.block;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class FavoriteBlock {
  
  public final ButtonLike buttonLike = new ButtonLike();
  public final SelenideElement blockCard = $(".favorite-item__container .obj-card");
  
  @Step("Проверяем название добавленного жк")
  public FavoriteBlock shouldHaveName(String name) {
    blockCard.shouldHave(text((name)));
    return this;
  }
  
}
