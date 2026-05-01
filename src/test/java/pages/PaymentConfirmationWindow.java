package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;

public class PaymentConfirmationWindow {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By amountInCost = By.cssSelector(".pay-description__cost span");

    private final By descriptionText = By.cssSelector(".pay-description__text span");

    private final By payButton = By.cssSelector("button.colored span, button[type='submit'] span, .card-page__container button span");

    private final By cardNumberInput = By.cssSelector("input#cc-number, input[formcontrolname='creditCard']");
    private final By expiryInput = By.cssSelector("input[formcontrolname='expirationDate']");
    private final By cvcInput = By.cssSelector("input[formcontrolname='cvc']");
    private final By holderInput = By.cssSelector("input[formcontrolname='holder']");

    private final By cardIcons = By.cssSelector(".cards-brands__container img");

    private final By footerIcons = By.cssSelector(".footer-security svg-icon, .footer__secure svg-icon");

    public PaymentConfirmationWindow(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(amountInCost),
                ExpectedConditions.visibilityOfElementLocated(payButton)
        ));
    }

    public String getAmountFromCost() {
        try {
            return driver.findElement(amountInCost).getText().trim();
        } catch (Exception e) {
            return "";
        }
    }

    public String getAmountFromButton() {
        try {
            return driver.findElement(payButton).getText().trim();
        } catch (Exception e) {
            return "";
        }
    }

    public String getDescriptionText() {
        try {
            return driver.findElement(descriptionText).getText().trim();
        } catch (Exception e) {
            return "";
        }
    }

    public boolean areCardFieldsEmpty() {
        By[] fields = {cardNumberInput, expiryInput, cvcInput, holderInput};
        for (By locator : fields) {
            try {
                WebElement field = driver.findElement(locator);
                String value = field.getAttribute("value");
                if (value != null && !value.isEmpty()) {
                    return false;
                }
            } catch (Exception ignored) {}
        }
        return true;
    }

    public Map<String, String> getCardFieldLabels() {
        Map<String, String> labels = new LinkedHashMap<>();
        try {
            for (WebElement label : driver.findElements(By.cssSelector("label"))) {
                String text = label.getText().trim();
                if (!text.isEmpty()) {
                    labels.putIfAbsent(text, text);
                }
            }
        } catch (Exception ignored) {}
        return labels;
    }

    public boolean arePaymentIconsVisible() {
        try {
            int count = driver.findElements(cardIcons).size() + driver.findElements(footerIcons).size();
            return count > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public String getSecureText() {
        try {
            return driver.findElement(By.cssSelector(".footer__secure span, .footer__secure")).getText();
        } catch (Exception e) {
            return "";
        }
    }
}