package config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.junit5.TextReportExtension;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;

@ExtendWith(TextReportExtension.class)
public class BaseTest {
  
  @BeforeEach
  void beforeEach() {
    SelenideLogger.addListener("allure", new AllureSelenide().includeSelenideSteps(true));
    open("https://trendrealty.ru/images/favicons/favicon.ico");
    WebDriverRunner.getWebDriver().manage().addCookie(new Cookie("selected_city", "58c665588b6aa52311afa01b"));
  }
  
  @BeforeAll
  static void beforeAll() {

//    System.setProperty("environment", System.getProperty("environment", "prod"));
    Configuration.browserSize = "1920x1080";
//    Configuration.baseUrl = "https://demoqa.com";
    Configuration.pageLoadStrategy = "eager";
//    SelenideLogger.addListener("allure", new AllureSelenide());
//    Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
//    Configuration.remote = System.getProperty("browserRemoteUrl");
    
    
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("selenoid:options", Map.<String, Object>of(
      "enableVNC", true,
      "enableVideo", true));
    
    Configuration.browserCapabilities = capabilities;
  }
  
  
  @AfterEach
  void addAttachments() {
    Attach.screenshotAs("Last screenshot");
    Attach.pageSource();
    Attach.browserConsoleLogs();
    Attach.addVideo();
    
    Selenide.closeWebDriver();
  }
}
