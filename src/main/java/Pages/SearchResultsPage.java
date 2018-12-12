package Pages;

import Utils.BasePage;
import Utils.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.interactions.internal.Locatable;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//div[@class=\"c2-button c2-button-further\"]/child::span")
    private WebElement nextMonthBtn;

    @FindBy(xpath = "//td[@data-id=\"1551052800000\"]/child::span")
    private WebElement date;

    @FindBy(xpath = "//button[@data-sb-id=\"main\"]")
    private WebElement findBtn;

    @FindBy(xpath = "//a[@data-id=\"pri-1\"]")
    private WebElement cheapestRoomsCheckbox;

    @FindBy(id = "group_adults")
    private WebElement adultsDropdown;

    @FindBy(xpath = "//div[starts-with(@class, 'js_rackrate_animation_anchor')]/preceding::b[21]")
    private WebElement firstHotelValueFromList;

    @FindBy(xpath = "//div[starts-with(@class, 'js_rackrate_animation_anchor')]/following::strong")
    private WebElement secondHotelValueFromList;

    @FindBy(xpath = "//*[@id=\"hotellist_inner\"]/descendant::a[@data-click-store-id=\"sr-compset-182480\"]")
    private WebElement searchForOurLastRoomsBtn;

    @FindBy(xpath = "//*[@id=\"hotellist_inner\"]/descendant::a[@data-click-store-id=\"sr-compset-4044082\"]")
    private WebElement selectAppartmentsBtn;

    @FindBy(xpath = "//select[@name=\"nr_rooms_18248007_95441499_0_2_0\"]")
    private WebElement roomsCountDropdown;

    @FindBy(xpath = "//div[@class=\"hprt-reservation-cta\"]/button")
    private WebElement bookRoomBtn;

    @FindBy(xpath = "//div[starts-with(@class, 'av-summary-section')]/descendant::span[@class=\"b-button__text\"]")
    private WebElement scrollElement;

    public void selectNextMonth() {
        new WebDriverWait(WebDriverManager.driver, 20).until(ExpectedConditions.elementToBeClickable(nextMonthBtn));
        nextMonthBtn.click();
    }

    public void selectDate() {
        new WebDriverWait(WebDriverManager.driver, 20).until(ExpectedConditions.elementToBeClickable(date));
        date.click();
    }

    public void selectOnePerson() {
        Select selectPersonCount = new Select(adultsDropdown);
        selectPersonCount.selectByValue("1");
    }

    public void clickFindButton() {
        new WebDriverWait(WebDriverManager.driver, 20).until(ExpectedConditions.elementToBeClickable(findBtn));
        findBtn.click();
    }

    public void selectCheapestHotel() {
        String firstHotelValue = firstHotelValueFromList.getText();
        String secondHotelValue = secondHotelValueFromList.getText();

        int firstHotelPrice = Integer.parseInt(firstHotelValue.replaceAll("\\s", "").substring(3));
        int secondHotelPrice = Integer.parseInt(secondHotelValue.replaceAll("\\s", "").substring(3));

        if (firstHotelPrice < secondHotelPrice) {
            waitForPageLoad();
            new WebDriverWait(WebDriverManager.driver, 20).until(ExpectedConditions.elementToBeClickable(searchForOurLastRoomsBtn));
            searchForOurLastRoomsBtn.click();
        } else {
            waitForPageLoad();
            new WebDriverWait(WebDriverManager.driver, 20).until(ExpectedConditions.elementToBeClickable(selectAppartmentsBtn));
            selectAppartmentsBtn.click();
        }

        ArrayList<String> tabs = new ArrayList<String>(WebDriverManager.driver.getWindowHandles());
        WebDriverManager.driver.switchTo().window(tabs.get(0));
        new WebDriverWait(WebDriverManager.driver, 20).until(ExpectedConditions.elementToBeClickable(findBtn));
        waitForPageLoad();
        WebDriverManager.driver.switchTo().window(tabs.get(1));

    }

    public void selectRoom(){

        ((JavascriptExecutor) WebDriverManager.driver).executeScript("arguments[0].scrollIntoView();", scrollElement);
        new WebDriverWait(WebDriverManager.driver, 20).until(ExpectedConditions.elementToBeClickable(roomsCountDropdown));
        roomsCountDropdown.click();
        Select selectPersonCount = new Select(roomsCountDropdown);
        selectPersonCount.selectByValue("1");
    }

    public void clickOnBookRoomButton() {
        waitForPageLoad();
        bookRoomBtn.click();
    }

    
}
