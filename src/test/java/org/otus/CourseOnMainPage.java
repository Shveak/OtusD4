package org.otus;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.otus.annotations.Driver;
import org.otus.components.BannersCourses;
import org.otus.extensions.MyExtension;
import org.otus.pages.MainPage;

@ExtendWith(MyExtension.class)
public class CourseOnMainPage {

    @Driver
    private WebDriver driver;

    @Test
    public void findCourse() {
        new MainPage(driver).open(System.getProperty("webdriver.base.url", "https://otus.ru"));

        new BannersCourses(driver).work();
    }
}
