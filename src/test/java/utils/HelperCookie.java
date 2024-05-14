package utils;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Cookie;
import testdata.City;

import static com.codeborne.selenide.Selenide.open;

public class HelperCookie {
  
  public static void setSelectedCity(City city) {
    WebDriverRunner.getWebDriver().manage().addCookie(new Cookie("selected_city", city.id));
  }
  
  public static void openAndSetDefaultCity(City city) {
    open("/images/favicons/favicon.ico");
    HelperCookie.setSelectedCity(city);
  }
  
}
