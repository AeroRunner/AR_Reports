package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.FunPayDota2Page;
import pages.FunPayHomePage;
import utils.FunPayData;
import utils.ServersNameData;

import static io.qameta.allure.Allure.step;


public class FunPayTests extends BaseTest {
    FunPayHomePage fpHome = new FunPayHomePage();
    ServersNameData data = new ServersNameData();
    FunPayData game = new FunPayData();
    FunPayDota2Page d2Page = new FunPayDota2Page();

    @Test
    @Tag("smoke")
    @DisplayName("Check games in FunPay home page")
    public void checkGamesInFunPayHomePage() {

        step("Open FunPay home page ", () -> {
            fpHome.openHomePage();
        });
        step(" Check game 'AFK ARENA'", () -> {
            fpHome.checkGames(game.afkArena);
        });
    }

    @Test
    @Tag("smoke")
    @DisplayName("Choice game server AionClassic")
    public void checkGameServerInAionClassic() {

        step("Open FunPay home page ", () -> {
            fpHome.openHomePage();
        });
        step("Checking server availability (EU,NA)", () -> {
            fpHome.checkServers(data.serverEuNa);
        });
        step("Checking server availability (Free)", () -> {
            fpHome.checkServers(data.serverFree);
        });
    }

    @Test
    @Tag("smoke")
    @DisplayName("Check Dota2 Page after search 'Dota2' ")
    void searchFunpayTest() {

        step("Open FunPay home page", () -> {
            fpHome.openHomePage();
        });
        step("Writing a query(Dota2) in the search field", () -> {
            fpHome.searchGame(game.dota2);
        });
        step("Select a game from the drop-down list", () -> {
            fpHome.gameCLick();
        });
        step("Check Dota 2 first page", ()->{
            d2Page.checkTitlePage(game.d2FirstPage);
        });

    }

    @Test
    @Tag("smoke")
    @DisplayName("Check Calibration page in page 'Dota2' ")
    void checkDota2PageWithCalibration() {

        step("Open FunPay home page ", () -> {
            fpHome.openHomePage();
        });
        step("Writing a query(Dota2) in the search field", () -> {
            fpHome.searchGame(game.dota2);
        });
        step("Select a game from the drop-down list", () -> {
            fpHome.gameCLick();
        });
        step("Select the 'Calibration' section on the game page", () -> {
            d2Page.choiceCalibration();
        });
        step("Check the section name (Calibration)", () -> {
            d2Page.checkTitlePage(game.d2CalibrTitle);
        });
    }

    @Test
    @Tag("smoke")
    @DisplayName("The product field on the game page should not be empty")
    void checkRangeInDota2Page() {

        step("Open FunPay home page ", () -> {
            fpHome.openHomePage();
        });
        step("Writing a query(Dota2) in the search field", () -> {
            fpHome.searchGame(game.dota2);
        });
        step("Select a game from the drop-down list", () -> {
            fpHome.gameCLick();
        });
        step("Checking the product field", () -> {
            d2Page.checkRange();
        });
    }

    @Test
    @Tag("smoke")
    @DisplayName("Switch currentcy in FunPay home page")
    void switchcurrencyInHomePage() {

        step("Open FunPay home page ", () -> {
            fpHome.openHomePage();
        });
        step("Switch currently in home page", () -> {
            fpHome.switchCurr();
        });
        step("Check USD currency", ()-> {
            fpHome.checkCurr(game.currencyName);
        });
    }
}