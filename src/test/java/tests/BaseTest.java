package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.junit5.TextReportExtension;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.ProjectConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.HelperCookie;

import java.util.Map;

import static testdata.City.SPB;

@ExtendWith(TextReportExtension.class)
public class BaseTest {
  
  @BeforeEach
  void setupDefaultCity() {
    HelperCookie.openAndSetDefaultCity(SPB);
  }
  
  @BeforeAll
  static void beforeAll() {
    System.setProperty("environment", System.getProperty("environment", "prod"));
    ProjectConfig config = ConfigFactory.create(ProjectConfig.class);
    Configuration.browserSize = "1920x1080";
    Configuration.baseUrl = config.baseUrl().replace("{city}.", "");
    Configuration.pageLoadStrategy = "eager";
    SelenideLogger.addListener("allure", new AllureSelenide().includeSelenideSteps(true));
    Configuration.remote = System.getProperty("browserRemoteUrl");
    
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
