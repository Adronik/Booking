package Pages;

import Utils.BasePage;
import Utils.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BookingHomePage extends BasePage {

    Actions searchFieldFocus = new Actions(WebDriverManager.driver);
    WebElement searchField = WebDriverManager.driver.findElement(By.id("ss"));

    public SearchResultsPage searchForLosAngelesCity(String search) {
        waitForPageLoad();
        searchFieldFocus.moveToElement(searchField).build().perform();
        searchField.click();
        searchField.sendKeys(search);
        searchField.sendKeys(Keys.RETURN);
        return new SearchResultsPage();
    }

}