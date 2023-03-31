package org.otus.components;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.interactions.Actions;
import org.otus.actions.Action;

public abstract class BaseComponentAbs extends Action {

    protected Actions action;
    public BaseComponentAbs(WebDriver driver) {
        super(driver);
        this.action = new Actions(driver);
    }
}
