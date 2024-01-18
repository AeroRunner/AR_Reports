package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.FunPayDota2Page;
import pages.FunPayHomePage;
import pages.FunpayHelpPage;
import utils.FunPayData;
import utils.ServersNameData;

import static io.qameta.allure.Allure.step;


public class FunPayTests extends BaseTest {
    FunPayHomePage fpHome = new FunPayHomePage();
    ServersNameData data = new ServersNameData();
    FunPayData game = new FunPayData();
    FunPayDota2Page d2Page = new FunPayDota2Page();
    FunpayHelpPage fpHelp = new FunpayHelpPage();

    @Test
    @Tag("smoke")
    @DisplayName("Check games in FunPay home page")
    public void checkGamesInFunPayHomePage() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("open FunPay home page ", () -> {
            fpHome.openHomePage();
        });
        step(" check game 'AFK ARENA'", () -> {
            fpHome.checkGames(game.afkArena);
        });

    }

    @Test
    @Tag("smoke")
    @DisplayName("Choice game server AionClassic")
    public void checkGameServerInAionClassic() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        fpHome.openHomePage();
        fpHome.checkServers(data.serverEuNa);
        fpHome.checkServers(data.serverFree);
    }

    @Test
    @Tag("smoke")
    @DisplayName("Check Dota2 Page after search 'Dota2' ")
    void searchFunpayTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        fpHome.openHomePage();
        fpHome.searchGame(game.dota2);
        fpHome.gameCLick();
        d2Page.checkTitle(game.d2Title);
    }

    @Test
    @Tag("smoke")
    @DisplayName("Check Calibration page in page 'Dota2' ")
    void checkDota2PageWithCalibration() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        fpHome.openHomePage();
        fpHome.searchGame(game.dota2);
        fpHome.gameCLick();
        d2Page.choiceCalibration();
        d2Page.checkCalibrationPage(game.d2CalibrTitle);
    }

    @Test
    @Tag("smoke")
    @DisplayName("Check Range page in Dota2")
    void checkRangeInDota2Page() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        fpHome.openHomePage();
        fpHome.searchGame(game.dota2);
        fpHome.gameCLick();
        d2Page.checkRange();
    }

    @Test
    @Tag("smoke")
    @DisplayName("Check payment method in Lot page")
    void checkPaymentMethod() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        fpHome.openHomePage();
        fpHome.searchGame(game.dota2);
        fpHome.gameCLick();

    }

    @Test
    @Tag("situation")
    @DisplayName("Switch currentcy in FunPay home page")
    void switchcurrencyInHomePage() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        fpHome.openHomePage();
        fpHome.switchCurr();
    }

    @Test
    @Tag("situation")
    @DisplayName("Check 'Rules' page FunPay")
    void checkRulesPageFunPay() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        fpHome.openHomePage();
        fpHome.clickRulesPage();
        fpHelp.checkRulesTitle(game.rulesTitle);
    }

}