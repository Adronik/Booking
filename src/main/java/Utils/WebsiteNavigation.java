package Utils;

import Pages.BookingHomePage;

import java.util.concurrent.TimeUnit;

public class WebsiteNavigation {

    public static BookingHomePage openBookingHomePage() {
        WebDriverManager.driver.get("https://booking.com");
        WebDriverManager.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        return new BookingHomePage();
    }

}
