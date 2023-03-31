package org.otus.waiters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiter implements IWaiter {

    private WebDriver driver;

    public Waiter(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public boolean waitForCondition(ExpectedCondition expectedCondition) {
        WebDriverWait wait = new WebDriverWait(driver, IMPLICITLY_WAIT_SECOND);
        try {
            wait.until(expectedCondition);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
