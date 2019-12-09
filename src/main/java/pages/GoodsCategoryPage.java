package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoodsCategoryPage extends BasePage {
    @FindBy(xpath = "//div[@data-apiary-widget-name='@MarketNode/CatalogHeader']//h1")
    public WebElement title;

    @FindBy(xpath = "//div[@data-apiary-widget-name='@MarketNode/NavigationTree']")
    public WebElement navigationTree;

    public GoodsCategoryPage() {
        PageFactory.initElements(webDriver, this);
    }

    public void openNavigationMenuItem(String menuItem) {
        WebElement navigationTreeItem = navigationTree.findElement(By.xpath(".//ul//li//a[text()='" + menuItem + "']"));
        navigationTreeItem.click();
    }
}
