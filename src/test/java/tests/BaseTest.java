package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static io.qameta.allure.Allure.step;

public class BaseTest {
    @BeforeAll
    public static void setUP() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Setup configurations before all tests", () -> {
            Configuration.remote
                    = System.getProperty("selenoid", "https://user1:1234@selenoid.autotests.cloud/wd/hub");
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true));
            Configuration.browserSize = System.getProperty("size", "1920x1080");
            Configuration.baseUrl = System.getProperty("baseUrl", "https://funpay.com/");
            Configuration.pageLoadStrategy = "eager";
            Configuration.browserVersion = System.getProperty("version", "100");
            Configuration.browser = System.getProperty("browser", "chrome");
            Configuration.browserCapabilities = capabilities;
            Configuration.webdriverLogsEnabled = false;

        });
    }

    @AfterEach
    void afterEach() {
        Attach.screenshotAs("Last Screen");
        Attach.pageSource();
        if (!Configuration.browser.equalsIgnoreCase("firefox")) {
            Attach.browserConsoleLogs();
        }
        Attach.addVideo();
        step("Close Browser", () -> {
                    Selenide.closeWebDriver();
                }
        );
    }
}
