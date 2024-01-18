package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class FunPayHomePage {
    SelenideElement promoGames = $(".promo-game-list"),
     serchField = $("[name='query']"),
     gameChoice =  $("[href='https://funpay.com/en/lots/81/']"),
    langMenu = $("[href='javascript:void(0)']"),
    enLang = $("[href='https://funpay.com/?setlocale=en']"),
    rulesPage = $("[href='https://funpay.com/en/trade/info']"),
    currencyDropDown =  $(".dropdown-toggle.menu-item-currencies"),
    choiseRUB = $(".user-cy-switcher.menu-item-currency");

    public FunPayHomePage openHomePage(){
        Selenide.open("");
        return this;
    }
    public FunPayHomePage checkGames( String game){
        $(promoGames.shouldNotBe(Condition.empty));
        promoGames.shouldHave(Condition.text(game));
        return this;
    }
    public FunPayHomePage checkServers(String server ){
        $(".btn-group").shouldHave(text(server));
        $(".btn-group").shouldHave(text(server));
        $(".btn-group").shouldHave(text(server));
        $(".btn-group").shouldHave(text(server));
        return this;
    }
    public FunPayHomePage searchGame(String game){
        serchField.setValue(game);
        return this;
    }
    public FunPayHomePage gameCLick(){
        gameChoice.click();
        return this;
    }
    public FunPayHomePage switchToEn(){
        langMenu.click();
        enLang.click();
        return this;
    }
    public FunPayHomePage clickRulesPage(){
        rulesPage.click();
        return this;
    }
    public FunPayHomePage switchCurr(){
        currencyDropDown.click();
        choiseRUB.click();
        return this;
    }

}
