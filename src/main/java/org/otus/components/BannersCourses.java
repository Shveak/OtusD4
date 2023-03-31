package org.otus.components;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class BannersCourses extends BaseComponentAbs{
    @FindBy(xpath = "//a[@href and contains(@class, 'lessons')]")
    private List<WebElement> listBanner;
    private final String titleLocator = ".//div[contains(@class, 'title')]";
    private final List<String> dateBlockLocatorList = Arrays.asList(".//div[contains(@class, 'new-item-bottom_spec')]/div[2]",
            ".//div[contains(@class, 'start')]");

    public BannersCourses(WebDriver driver) {
        super(driver);
    }

    private String getTitle(WebElement webElement) {
        List<WebElement> allElements = webElement.findElements(By.xpath(titleLocator));
        if (allElements != null && !allElements.isEmpty()) {
            return allElements.get(0).getText();
        } else {
            throw new NoSuchElementException("Элемент в баннере не найден " + titleLocator);
        }
    }

    private String getDate(WebElement webElement) {
        List<WebElement> allElements = null;
        for (String locator: dateBlockLocatorList) {
            allElements = webElement.findElements(By.xpath(locator));
            if (allElements != null && !allElements.isEmpty()) {
                break;
            }
        }
        if (allElements == null || allElements.isEmpty()) {
            throw new NoSuchElementException("Элемент в баннере не найден " + dateBlockLocatorList);
        }
        String text = allElements.get(0).getText();

        return cleanDateBlock(text);
    }

    private String cleanDateBlock(String str) {
        Pattern pattern = Pattern.compile(" \\d+ месяц");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            str = str.substring(0, matcher.start());
        }
        pattern = Pattern.compile("^[СВ] ");
        matcher = pattern.matcher(str);
        while (matcher.find()) {
            str = str.substring(2);
        }
        pattern = Pattern.compile("^\\D+$");
        matcher = pattern.matcher(str);
        str = matcher.find() ? "" : str;
        if (str.isEmpty()) {
            return str;
        }
        pattern = Pattern.compile("^(\\D+) ([0-9]{4}) года");
        matcher = pattern.matcher(str);
        str = matcher.find() ? "1 " + matcher.group(1) + " " + matcher.group(2) : str + " " + LocalDate.now().getYear();
        return str;
    }
    public void work() {
        listBanner.forEach(x -> {
//            System.out.print(x.findElement(By.xpath(".//div[contains(@class, 'title')]")).getText() + "|");
            System.out.println(getDate(x));
        });
    }

    private enum Month {
        ЯНВАРЬ(1, "январ"),
        ФЕВРАЛЬ(2,"феврал"),
        МАРТ(3,"март"),
        АПРЕЛЬ(4,"апрел"),
        МАЙ(5,"мая"),
        ИЮНЬ(6,"июн"),
        ИЮЛЬ(7,"июл"),
        АВГУСТ(8,"август"),
        СЕНТЯБРЬ(9,"сентябр"),
        ОКТЯБРЬ(10,"октябр"),
        НОЯБРЬ(11,"ноябр"),
        ДЕКАБРЬ(12,"декабр");

        int number;
        String loName;
        Month(int number, String loName) {
            this.number = number;
            this.loName = loName;
        }

        public String getLoName() {
            return this.loName;
        }

        public int getNumber() {
            return this.number;
        }
        public static Month of(String loName) {
            return Stream.of(Month.values())
                    .filter(x -> loName.contains(x.getLoName()))
                    .findFirst()
                    .orElseThrow(() -> new AssertionError(String.format("Не наден месяц по %s", loName)));
        }
    }
}
