import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MoreMethodsOnElements {
    WebDriver driver;
    WebDriverWait wait;
    By cookieConsentBar = By.cssSelector("a[class*='dismiss-link']");
    By pilatesGroup = By.cssSelector("a[href*='pilates']");
    By product = By.cssSelector("li.post-61");
    By addToCartButton = By.cssSelector("button[name='add-to-cart']");
    By goToCartButton = By.cssSelector("a.cart-contents");

    @BeforeEach
    public void driverSetup(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1295, 760));
        driver.manage().window().setPosition(new Point(10, 40));
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.navigate().to("https://fakestore.testelka.pl");

        wait = new WebDriverWait(driver, 10);
        driver.findElement(addToCartButton).click();
        driver.findElement(goToCartButton).click();
    }

    @AfterEach
    public void driverShut(){
        driver.close();
        driver.quit();
    }

    @Test
    public void infoOnElement(){
        WebElement element = driver.findElement(By.cssSelector("#masthead"));
        String text = element.getText();
        String attribute = element.getAttribute("role");
        String cssValue = element.getCssValue("background-color");
        String tag = element.getTagName();
        Point location = element.getLocation();
        Dimension size = element.getSize();
        Rectangle locationAndSize = element.getRect();
        boolean isDisplayed = element.isDisplayed();
        boolean isSelected = element.isSelected();
        boolean isEnabled = element.isEnabled();

    }
}
