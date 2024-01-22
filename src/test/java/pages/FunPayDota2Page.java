package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class FunPayDota2Page {

    SelenideElement title = $(".content-with-cd"),
            calibrationPage = $("[href='https://funpay.com/en/lots/500/']"),
            calibrationTitle = $(".content-with-cd"),
            rangePageDota2 = $(".with-tbl-footer");

    public FunPayDota2Page choiceCalibration() {
        calibrationPage.click();
        return this;
    }

    public FunPayDota2Page checkCalibrationPage(String title) {
        calibrationTitle.shouldHave(text(title));
        return this;
    }

    public FunPayDota2Page checkRange() {
        rangePageDota2.shouldNotBe(empty);
        return this;
    }
}
