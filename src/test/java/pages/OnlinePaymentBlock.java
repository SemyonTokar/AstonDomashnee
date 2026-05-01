package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class OnlinePaymentBlock {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By blockTitle = By.cssSelector(".pay__wrapper h2");

    private final By paySelectButton = By.cssSelector(".select__header");
    private final By selectOptions = By.cssSelector(".select__item");
    private final By activeOptionSpan = By.cssSelector(".select__now");

    private final Map<String, String> formMap = new HashMap<>() {{
        put("Услуги связи", "pay-connection");
        put("Домашний интернет", "pay-internet");
        put("Рассрочка", "pay-instalment");
        put("Задолженность", "pay-arrears");
    }};

    private final By partnerLogos = By.cssSelector(".pay__partners img");

    private final By detailsLink = By.cssSelector(".pay__wrapper a[href*='poryadok-oplaty']");

    public OnlinePaymentBlock(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getBlockTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(blockTitle)).getText();
    }

    public void openPaymentForm(String optionName) {
        driver.findElement(paySelectButton).click();
        for (WebElement option : driver.findElements(selectOptions)) {
            if (option.getText().trim().equalsIgnoreCase(optionName)) {
                option.click();
                break;
            }
        }
    }

    public String getSelectedOption() {
        return driver.findElement(activeOptionSpan).getText().trim();
    }

    public boolean isFormDisplayed(String formId) {
        return driver.findElement(By.id(formId)).isDisplayed();
    }

    public String getPlaceholderForField(String formId, String fieldId) {
        WebElement form = driver.findElement(By.id(formId));
        return form.findElement(By.id(fieldId)).getAttribute("placeholder");
    }

    public Map<String, String> getAllPlaceholders(String formId) {
        Map<String, String> placeholders = new HashMap<>();
        WebElement form = driver.findElement(By.id(formId));
        for (WebElement input : form.findElements(By.cssSelector("input:not([type='hidden'])"))) {
            String fieldId = input.getAttribute("id");
            String placeholder = input.getAttribute("placeholder");
            if (fieldId != null && placeholder != null && !placeholder.isEmpty()) {
                placeholders.put(fieldId, placeholder);
            }
        }
        return placeholders;
    }

    public boolean arePartnerLogosVisible() {
        return !driver.findElements(partnerLogos).isEmpty();
    }

    public String getLinkText() {
        return driver.findElement(detailsLink).getText();
    }

    public void clickDetailsLink() {
        driver.findElement(detailsLink).click();
    }

    public PaymentConfirmationWindow fillConnectionFormAndSubmit(String phoneNumber, String sum, String email) {
        openPaymentForm("Услуги связи");

        WebElement form = driver.findElement(By.id("pay-connection"));

        WebElement phoneInput = form.findElement(By.id("connection-phone"));
        phoneInput.click();
        phoneInput.clear();
        phoneInput.sendKeys(phoneNumber);

        WebElement sumInput = form.findElement(By.id("connection-sum"));
        sumInput.click();
        sumInput.clear();
        sumInput.sendKeys(sum);

        WebElement emailInput = form.findElement(By.id("connection-email"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);

        try {
            Thread.sleep(500);
        } catch (InterruptedException ignored) {}

        WebElement submitButton = form.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException ignored) {}

        switchToBepaidIframe();

        return new PaymentConfirmationWindow(driver);
    }

    private void switchToBepaidIframe() {
        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                    By.cssSelector("iframe[src*='bepaid'], iframe[src*='checkout']")
            ));
            System.out.println("=== Переключились в iframe bepaid ===");
        } catch (Exception e) {

            System.out.println("=== Iframe не найден, проверяем окна ===");
            try {
                String mainWindow = driver.getWindowHandle();
                for (String handle : driver.getWindowHandles()) {
                    if (!handle.equals(mainWindow)) {
                        driver.switchTo().window(handle);
                        if (driver.getCurrentUrl().contains("bepaid") || driver.getCurrentUrl().contains("checkout")) {
                            System.out.println("=== Переключились в окно: " + driver.getCurrentUrl() + " ===");
                            break;
                        }
                    }
                }
            } catch (Exception ignored) {}
        }
    }
}