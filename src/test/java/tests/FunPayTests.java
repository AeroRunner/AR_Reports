package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.FunPayDota2Page;
import pages.FunPayHomePage;
import pages.FunpayHelpPage;
import utils.FunPayData;
import utils.ServersNameData;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


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
        fpHome.openHomePage();
        fpHome.checkGames(game.afkArena);
    }

    @Test
    @Tag("smoke")
    @DisplayName("Choice game server AionClassic")
    public void checkGameServerInAionClassic() {
        fpHome.openHomePage();
        fpHome.checkServers(data.serverRU);
        fpHome.checkServers(data.serverEuNa);
        fpHome.checkServers(data.serverFree);
    }

    @Test
    @Tag("smoke")
    @DisplayName("Check Dota2 Page after search 'Dota2' ")
    void searchFunpayTest() {
        fpHome.openHomePage();
        fpHome.switchToEn();
        fpHome.searchGame(game.dota2);
        fpHome.gameCLick();
        d2Page.checkTitle(game.d2Title);
    }

    @Test
    @Tag("smoke")
    @DisplayName("Check Calibration page in page 'Dota2' ")
    void checkDota2PageWithCalibration() {
        fpHome.openHomePage();
        fpHome.switchToEn();
        fpHome.searchGame(game.dota2);
        fpHome.gameCLick();
        d2Page.choiceCalibration();
        d2Page.checkCalibrationPage(game.d2CalibrTitle);
    }

    @Test
    @Tag("smoke")
    @DisplayName("Check Range page in Dota2")
    void checkRangeInDota2Page() {
        fpHome.openHomePage();
        fpHome.switchToEn();
        fpHome.searchGame(game.dota2);
        fpHome.gameCLick();
        d2Page.checkRange();
    }

    @Test
    @Tag("smoke")
    @DisplayName("Check payment method in Lot page")
    void checkPaymentMethod() {
        fpHome.openHomePage();
        fpHome.switchToEn();
        fpHome.searchGame(game.dota2);
        fpHome.gameCLick();

    }
    @Test
    @Tag("situation")
    @DisplayName("Switch currentcy in FunPay home page")
    void switch—urrencyInHomePage(){
        fpHome.openHomePage();
        fpHome.switchToEn();
        fpHome.switchCurr();
    }
    @Test
    @Tag("situation")
    @DisplayName("Check 'Rules' page FunPay")
    void checkRulesPageFunPay(){
        fpHome.openHomePage();
        fpHome.clickRulesPage();
        fpHelp.checkRulesTitle(game.rulesTitle);
    }

}