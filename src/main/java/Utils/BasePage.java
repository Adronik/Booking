package Utils;

import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class BasePage extends PageFactory {

    public BasePage() {
        initElements(WebDriverManager.driver, this);
    }

    public void waitForPageLoad(){
        WebDriverManager.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

}