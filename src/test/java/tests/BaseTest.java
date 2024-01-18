package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    @BeforeAll
    public static void setUP() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.baseUrl = "https://funpay.com/";
        Configuration.browserSize = "1920x1060";
        Configuration.pageLoadStrategy = "eager";
        Configuration.pageLoadTimeout = 10000;

    }
@AfterEach
    void afterEach(){
    Selenide.closeWebDriver();
}

}
