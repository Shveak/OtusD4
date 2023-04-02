package org.otus.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.otus.actions.Action;

public abstract class BaseComponentAbs extends Action {

    protected Actions action;

    public BaseComponentAbs(WebDriver driver) {
        super(driver);
        this.action = new Actions(driver);
    }

    public void scrollTo(WebElement element) {
        action.moveToElement(element).build().perform();
    }

    public void click(WebElement element) {
        action.click(element).build().perform();
    }
}
