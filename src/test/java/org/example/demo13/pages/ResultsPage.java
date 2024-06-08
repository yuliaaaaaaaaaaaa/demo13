package org.example.demo13.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ResultsPage {
    private WebDriver driver;

    @FindBy(css = "#sb_form_q")
    private WebElement searchField;

    @FindBy(css = ":not(ad_url) > cite")
    private List<WebElement> results;

    public void clickElement(int num) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.and(
                ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(":not(.b_adurl) > cite"), "selenium"),
                ExpectedConditions.elementToBeClickable(By.cssSelector(":not(.b_adurl) > cite"))));
        results.get(num).click();
        ArrayList tabs = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0).toString());

        System.out.println("Нажатие на результат под номером: " + num);

    }

    public String getTextFromSearchField() {
        String val = searchField.getAttribute("value");
        System.out.println("В строке поиска текст: " + val);
        return val;
    }

    public ResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
