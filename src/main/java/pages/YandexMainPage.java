package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YandexMainPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'i-bem')]")
    WebElement tabItems;

    public void selectTabItem(String tabName) {
        tabItems.findElement(By.xpath("//div[contains(@class, 'home-tabs')]//a[text()='" + tabName + "']")).click();
    }
}
