package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.OnlinePaymentBlock;
import pages.PaymentConfirmationWindow;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@Epic("MTS.BY — Онлайн оплата")
@Feature("Блок «Онлайн пополнение без комиссии»")
public class OnlinePaymentBlockTests extends BaseTest {

    private final String URL = "https://www.mts.by";

    @Test
    @Story("Отображение блока")
    @DisplayName("1. Проверка названия блока «Онлайн пополнение без комиссии»")
    @Description("Убеждаемся, что заголовок блока содержит текст «Онлайн пополнение без комиссии»")
    @Severity(SeverityLevel.BLOCKER)
    public void testBlockTitle() {
        openPage(URL);
        OnlinePaymentBlock paymentBlock = new OnlinePaymentBlock(driver);
        String actualTitle = paymentBlock.getBlockTitle();
        assertTrue(actualTitle.contains("Онлайн пополнение") && actualTitle.contains("без комиссии"),
                "Заголовок должен содержать 'Онлайн пополнение без комиссии'");
    }

    @Test
    @Story("Отображение блока")
    @DisplayName("2. Проверка наличия логотипов платёжных систем")
    @Description("Проверяем, что логотипы Visa, MasterCard, Белкарт отображаются в блоке")
    @Severity(SeverityLevel.NORMAL)
    public void testPartnerLogos() {
        openPage(URL);
        OnlinePaymentBlock paymentBlock = new OnlinePaymentBlock(driver);
        assertTrue(paymentBlock.arePartnerLogosVisible(),
                "Логотипы платёжных систем (Visa, MasterCard, Белкарт) должны отображаться");
    }

    @Test
    @Story("Навигация")
    @DisplayName("3. Проверка работы ссылки «Подробнее о сервисе»")
    @Description("Проверяем текст ссылки «Подробнее о сервисе»")
    @Severity(SeverityLevel.MINOR)
    public void testDetailsLink() {
        openPage(URL);
        OnlinePaymentBlock paymentBlock = new OnlinePaymentBlock(driver);
        String linkText = paymentBlock.getLinkText();
        assertEquals("Подробнее о сервисе", linkText,
                "Текст ссылки должен быть «Подробнее о сервисе»");
    }

    @ParameterizedTest
    @Story("Формы оплаты")
    @DisplayName("4. Проверка надписей в незаполненных полях для каждого варианта оплаты")
    @Description("Параметризованная проверка placeholder-ов для всех форм оплаты")
    @Severity(SeverityLevel.NORMAL)
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
                "Placeholder для поля " + fieldId + " в форме \"" + optionName
                        + "\" должен быть \"" + expectedPlaceholder + "\"");
    }

    @Test
    @Story("Окно подтверждения оплаты")
    @DisplayName("5. Заполнение формы «Услуги связи» и проверка окна подтверждения")
    @Description("Заполняем форму, нажимаем «Продолжить» и проверяем сумму, номер и поля карты в iframe bepaid")
    @Severity(SeverityLevel.CRITICAL)
    public void testConnectionPaymentConfirmationWindow() {
        openPage(URL);
        OnlinePaymentBlock paymentBlock = new OnlinePaymentBlock(driver);

        PaymentConfirmationWindow confirmation = paymentBlock.fillConnectionFormAndSubmit(
                "297777777", "10", "test@test.com");

        Allure.addAttachment("Текущий URL", driver.getCurrentUrl());
        Allure.addAttachment("Заголовок страницы", driver.getTitle());

        String costText = confirmation.getAmountFromCost();
        Allure.step("Сумма в описании: " + costText);
        assertFalse(costText.isEmpty(), "Сумма в описании не должна быть пустой");
        assertTrue(costText.contains("10"), "Ожидается 10 BYN, получено: " + costText);

        String buttonText = confirmation.getAmountFromButton();
        Allure.step("Надпись на кнопке: " + buttonText);
        assertTrue(buttonText.contains("10"), "На кнопке ожидается 10 BYN, получено: " + buttonText);

        String descText = confirmation.getDescriptionText();
        Allure.step("Описание заказа: " + descText);
        assertTrue(descText.contains("297777777"),
                "В описании ожидается номер 297777777, получено: " + descText);

        assertTrue(confirmation.areCardFieldsEmpty(), "Поля карты должны быть пустыми");

        Map<String, String> labels = confirmation.getCardFieldLabels();
        Allure.addAttachment("Надписи полей карты", labels.toString());
        assertFalse(labels.isEmpty(), "Должны быть найдены надписи полей карты");

        assertTrue(confirmation.arePaymentIconsVisible(),
                "Иконки платёжных систем должны отображаться");

        takeScreenshot();
    }
}