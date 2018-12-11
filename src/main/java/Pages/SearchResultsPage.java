package Pages;

import Utils.BasePage;
import Utils.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//div[@class=\"c2-button c2-button-further\"]/child::span")
    private WebElement nextMonthBtn;

    @FindBy(xpath = "//td[@data-id=\"1551052800000\"]/child::span")
    private WebElement date;

    @FindBy(xpath = "//button[@data-sb-id=\"main\"]")
    private WebElement findBtn;

    @FindBy(xpath = "//a[@data-id=\"pri-1\"]")
    private WebElement cheapestRoomsCheckbox;

    @FindBy(xpath = "//div[starts-with(@class, 'js_rackrate_animation_anchor')]/preceding::b[21]")
    private WebElement firstHotelValueFromList;

    @FindBy(xpath = "//div[starts-with(@class, 'js_rackrate_animation_anchor')]/following::strong")
    private WebElement secondHotelValueFromList;


    public void selectNextMonth() {
        new WebDriverWait(WebDriverManager.driver, 20).until(ExpectedConditions.elementToBeClickable(nextMonthBtn));
        nextMonthBtn.click();
    }

    public void selectDate() {
        new WebDriverWait(WebDriverManager.driver, 20).until(ExpectedConditions.elementToBeClickable(date));
        date.click();
    }

    public void selectOnePerson() {
        Select select = new Select(WebDriverManager.driver.findElement(By.id("group_adults")));
        select.selectByVisibleText("1 взрослый");
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
            new WebDriverWait(WebDriverManager.driver, 20).until(ExpectedConditions.elementToBeClickable(firstHotelValueFromList));
            firstHotelValueFromList.click();
        } else {
            waitForPageLoad();
            new WebDriverWait(WebDriverManager.driver, 20).until(ExpectedConditions.elementToBeClickable(secondHotelValueFromList));
            secondHotelValueFromList.click();
        }

    }

    
}
