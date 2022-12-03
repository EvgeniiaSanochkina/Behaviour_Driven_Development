package page;

import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TransferPage {
    private SelenideElement amount = $("[data-test-id=\"amount\"] input");
    private SelenideElement from = $("[data-test-id=\"from\"] input");
    private SelenideElement transferButton = $("[data-test-id=\"action-transfer\"]");
    private SelenideElement error = $("[data-test-id=\"error-message\"]");
    private SelenideElement transferHead = $(byText("Пополнение карты"));


    public TransferPage() {
        transferHead.shouldBe(visible);
    }

    public void makeTransfer(String amountToTransfer, DataHelper.CardInfo cardInfo) {
        amount.setValue(amountToTransfer);
        from.setValue(cardInfo.getCardNumber());
        transferButton.click();
    }

    public DashboardPage makeValidTransfer(String amountToTransfer, DataHelper.CardInfo cardInfo) {
        makeTransfer(amountToTransfer, cardInfo);
        return new DashboardPage();
    }

}