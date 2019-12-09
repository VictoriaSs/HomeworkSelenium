package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YandexMarketMainPage extends BasePage {
    @FindBy(xpath = "//a[contains(@class, 'logo_part_market')]/span")
    public WebElement title;

    @FindBy(xpath = "//div[contains(@class, 'horizontal-tabs-container')]")
    public WebElement menuList;

//    @FindBy(xpath = "//div[@class='popup2__content']//span[text()='Да, спасибо']/parent::span[contains(@class, 'button2')]/parent::div")
//    public WebElement closeNotification;

    public YandexMarketMainPage() {
        PageFactory.initElements(webDriver, this);
    }

//    public void openMenuClickSubmenu(String menuItem, String submenuItem) {
//        closeNotification.click(); // закрыто окно с выбором города
//        //WebElement webElement = menuList.findElement(By.xpath("./li[@data-department='" + menuItem + "']"));
//        WebElement menuItemWebElement = menuList.findElement(By.xpath(".//span[text()='" + menuItem + "']/parent::a"));
//        menuItemWebElement.click();
//        //stopExecuted(1);
//
//        // проверка заголовка
//        WebElement navigationTreeItem = navigationTree.findElement(By.xpath(".//ul//li//a[text()=" + submenuItem + "]"));
//        navigationTreeItem.click();
//        //stopExecuted(1);
//    }

    public void openMenuItem(String menuItem) {
        //closeNotification.click(); // закрыто окно с выбором города
        //WebElement webElement = menuList.findElement(By.xpath("./li[@data-department='" + menuItem + "']"));
        WebElement menuItemWebElement = menuList.findElement(By.xpath(".//span[text()='" + menuItem + "']/parent::a"));
        menuItemWebElement.click();
    }
}
