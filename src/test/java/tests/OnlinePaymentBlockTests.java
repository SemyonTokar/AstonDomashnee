package tests;

import base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.OnlinePaymentBlock;
import pages.PaymentConfirmationWindow;

import java.util.Map;

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
        assertEquals("Подробнее о сервисе", linkText,
                "Текст ссылки должен быть «Подробнее о сервисе»");
    }

    @ParameterizedTest
    @DisplayName("4. Проверка надписей в незаполненных полях для каждого варианта оплаты")
    @CsvSource({
            "Услуги связи, pay-connection, connection-phone, Номер телефона",
            "Услуги связи, pay-connection, connection-sum, Сумма",
            "Услуги связи, pay-connection, connection-email, E-mail для отправки чека",
            "Домашний интернет, pay-internet, internet-phone, Номер абонента",
            "Домашний интернет, pay-internet, internet-sum, Сумма",
            "Домашний интернет, pay-internet, internet-email, E-mail для отправки чека",
            "Рассрочка, pay-instalment, score-instalment, Номер счета на 44",
            "Рассрочка, pay-instalment, instalment-sum, Сумма",
            "Рассрочка, pay-instalment, instalment-email, E-mail для отправки чека",
            "Задолженность, pay-arrears, score-arrears, Номер счета на 2073",
            "Задолженность, pay-arrears, arrears-sum, Сумма",
            "Задолженность, pay-arrears, arrears-email, E-mail для отправки чека"
    })
    public void testPlaceholdersForEachPaymentOption(String optionName, String formId,
                                                     String fieldId, String expectedPlaceholder) {
        openPage(URL);
        OnlinePaymentBlock paymentBlock = new OnlinePaymentBlock(driver);
        paymentBlock.openPaymentForm(optionName);
        String actualPlaceholder = paymentBlock.getPlaceholderForField(formId, fieldId);
        assertEquals(expectedPlaceholder, actualPlaceholder,
                "Placeholder для поля " + fieldId + " в форме \"" + optionName + "\" должен быть \"" + expectedPlaceholder + "\"");
    }

    @Test
    @DisplayName("5. Заполнение формы «Услуги связи», нажатие «Продолжить» и проверка окна подтверждения")
    public void testConnectionPaymentConfirmationWindow() {
        openPage(URL);
        OnlinePaymentBlock paymentBlock = new OnlinePaymentBlock(driver);

        PaymentConfirmationWindow confirmation = paymentBlock.fillConnectionFormAndSubmit(
                "297777777", "10", "test@test.com");

        System.out.println("=== Текущий URL: " + driver.getCurrentUrl() + " ===");
        System.out.println("=== Заголовок страницы: " + driver.getTitle() + " ===");

        String costText = confirmation.getAmountFromCost();
        System.out.println("Сумма в описании: " + costText);
        assertFalse(costText.isEmpty(), "Сумма в описании не должна быть пустой");
        assertTrue(costText.contains("10"), "Ожидается 10 BYN, получено: " + costText);

        String buttonText = confirmation.getAmountFromButton();
        System.out.println("Надпись на кнопке: " + buttonText);
        assertTrue(buttonText.contains("10"), "На кнопке ожидается 10 BYN, получено: " + buttonText);

        String descText = confirmation.getDescriptionText();
        System.out.println("Описание заказа: " + descText);
        assertTrue(descText.contains("297777777"), "В описании ожидается номер 297777777, получено: " + descText);

        assertTrue(confirmation.areCardFieldsEmpty(), "Поля карты должны быть пустыми");

        Map<String, String> labels = confirmation.getCardFieldLabels();
        System.out.println("Надписи полей карты: " + labels);
        assertFalse(labels.isEmpty(), "Должны быть найдены надписи полей карты");

        assertTrue(confirmation.arePaymentIconsVisible(), "Иконки платёжных систем должны отображаться");

        System.out.println("=== Итоги ===");
        System.out.println("Сумма: " + costText);
        System.out.println("Кнопка: " + buttonText);
        System.out.println("Описание: " + descText);
        System.out.println("Поля пустые: OK");
        System.out.println("Иконки: OK");
    }
}