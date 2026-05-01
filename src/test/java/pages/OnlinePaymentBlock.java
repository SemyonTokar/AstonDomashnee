package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OnlinePaymentBlock {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By blockTitle = By.cssSelector(".pay__wrapper h2");
    private final By paySelectButton = By.cssSelector(".select__header");
    private final By selectOptions = By.cssSelector(".select__item");
    private final By activeOptionSpan = By.cssSelector(".select__now");

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

    public boolean arePartnerLogosVisible() {
        return !driver.findElements(By.cssSelector(".pay__partners img")).isEmpty();
    }

    public String getLinkText() {
        return driver.findElement(By.cssSelector(".pay__wrapper a[href*='poryadok-oplaty']")).getText();
    }

    public void fillConnectionFormAndSubmit(String phoneNumber, String sum, String email) {
        openPaymentForm("Услуги связи");
        WebElement form = driver.findElement(By.id("pay-connection"));
        form.findElement(By.id("connection-phone")).sendKeys(phoneNumber);
        form.findElement(By.id("connection-sum")).sendKeys(sum);
        form.findElement(By.id("connection-email")).sendKeys(email);
        form.findElement(By.cssSelector("button[type='submit']")).click();
    }
}