package org.otus.waiters;

import org.openqa.selenium.support.ui.ExpectedCondition;

public interface IWaiter {
    boolean waitForCondition(ExpectedCondition expectedCondition);

    long IMPLICITLY_WAIT_SECOND = Long.parseLong(System.getProperty("webdriver.timeouts.implicitlywait", "5000")) / 1000;
}
