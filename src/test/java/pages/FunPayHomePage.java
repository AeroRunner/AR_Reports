package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class FunPayHomePage {
   private final  SelenideElement promoGames = $(".promo-game-list"),
            searchField = $("[name='query']"),
            gameChoice = $("[href='https://funpay.com/en/lots/81/']"),
            currencyDropDown = $(".dropdown-toggle.menu-item-currencies"),
            choiceRUB = $(".user-cy-switcher.menu-item-currency"),
            currencyTable = $(".dropdown-toggle.menu-item-currencies");

    public FunPayHomePage openHomePage() {
        Selenide.open("");
        return this;
    }

    public FunPayHomePage checkGames(String game) {
        $(promoGames.shouldNotBe(Condition.empty));
        promoGames.shouldHave(Condition.text(game));
        return this;
    }

    public FunPayHomePage checkServers(String server) {
        $(".btn-group").shouldHave(text(server));
        $(".btn-group").shouldHave(text(server));
        $(".btn-group").shouldHave(text(server));
        $(".btn-group").shouldHave(text(server));
        return this;
    }

    public FunPayHomePage searchGame(String game) {
        searchField.setValue(game);
        return this;
    }

    public FunPayHomePage gameCLick() {
        gameChoice.click();
        return this;
    }

    public FunPayHomePage switchCurr() {
        currencyDropDown.click();
        choiceRUB.click();
        return this;
    }
    public FunPayHomePage checkCurr(String currency){
        currencyTable.shouldHave(text(currency));
        return this;
    }

}
