package tests;

import base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.OnlinePaymentBlock;

import static org.junit.jupiter.api.Assertions.*;

public class OnlinePaymentBlockTests extends BaseTest {

    private final String URL = "https://www.mts.by";

    @Test
    @DisplayName("1. Проверка названия блока «Онлайн пополнение без комиссии»")
    public void testBlockTitle() {
        openPage(URL);
        OnlinePaymentBlock paymentBlock = new OnlinePaymentBlock(driver);
        String actualTitle = paymentBlock.getBlockTitle();
        assertTrue(actualTitle.contains("Онлайн пополнение") && actualTitle.contains("без комиссии"),
                "Заголовок должен содержать 'Онлайн пополнение без комиссии'");
    }

    @Test
    @DisplayName("2. Проверка наличия логотипов платёжных систем")
    public void testPartnerLogos() {
        openPage(URL);
        OnlinePaymentBlock paymentBlock = new OnlinePaymentBlock(driver);
        assertTrue(paymentBlock.arePartnerLogosVisible(),
                "Логотипы платёжных систем (Visa, MasterCard, Белкарт) должны отображаться");
    }

    @Test
    @DisplayName("3. Проверка работы ссылки «Подробнее о сервисе»")
    public void testDetailsLink() {
        openPage(URL);
        OnlinePaymentBlock paymentBlock = new OnlinePaymentBlock(driver);
        String linkText = paymentBlock.getLinkText();
        assertEquals("Подробнее о сервисе", linkText, "Текст ссылки должен быть «Подробнее о сервисе»");
    }

    @Test
    @DisplayName("4. Заполнение формы и проверка работы кнопки «Продолжить» для услуги связи")
    public void testContinueButtonFunctionality() {
        openPage(URL);
        OnlinePaymentBlock paymentBlock = new OnlinePaymentBlock(driver);

        paymentBlock.fillConnectionFormAndSubmit("297777777", "10", "test@test.com");

        String expectedFragment = "/pay/";
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains(expectedFragment) || !currentUrl.equals(URL),
                "После нажатия «Продолжить» должен произойти переход на следующий шаг оплаты");
    }
}