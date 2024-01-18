package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class FunpayHelpPage {
    SelenideElement rulesContent = $(".page-content-full");
    public FunpayHelpPage checkRulesTitle(String title){
        rulesContent.shouldHave(text(title));
        return this;
    }
}
