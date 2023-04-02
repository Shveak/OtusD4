package org.otus.pages;

import org.openqa.selenium.WebDriver;

public class CoursePage extends BasePageAbs {
    public CoursePage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

}
