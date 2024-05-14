package pages;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import pages.components.notFound.ButtonReturn;
import pages.components.notFound.Content;

public class NotFoundPage {
  
  public final ButtonReturn buttonReturn = new ButtonReturn();
  public final Content animation = new Content();
  
  @Step("Открываем невалидную страницу")
  public NotFoundPage open() {
    Selenide.open("/invalidPage");
    return this;
  }
  
}
