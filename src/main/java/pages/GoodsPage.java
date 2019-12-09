package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GoodsPage extends BasePage {
    @FindBy(xpath = "//div[contains(@class, 'headline')]//h1")
    public WebElement title;

    @FindBy(xpath = "//div[contains(@class, 'search-filters')]//div[contains(@class, 'filter-panel-aside__content')]")
    public WebElement searchPanel;

    @FindBy(xpath = "//div[contains(@class, 'search-results')]//div[contains(@class, 'filter-applied-results__content')]")
    public WebElement searchResults;

    @FindBy(xpath = "//input[@name='Цена от']")
    WebElement priceFrom;

    @FindBy(xpath = "//legend[text()='Производитель']/ancestor::div[1]")
    public WebElement fabricator;

    @FindBy(xpath = "//form[contains(@class, 'search')]")
    public WebElement searchString;

    private static String savedElement;
    private static List<WebElement> listOfResults;
    private WebDriverWait webDriverWait = new WebDriverWait(webDriver, 30);

    public GoodsPage() {
        PageFactory.initElements(webDriver, this);
    }

    public void clickApplyButton() {
        searchPanel.findElement(By.xpath("./div[contains(@class, 'controls')]//" +
                "span[text()='Применить']/parent::button[contains(@class, 'button_action')]")).click();
        stopExecuted(2);
    }

    public void fillField(String fieldName, String value) {
        switch (fieldName) {
            case "Цена от":
                fillField(priceFrom, value);
                stopExecuted(5);
                break;
            case "Производитель":
                fabricator.findElement(By.xpath("//button[text()='Показать всё']")).click();
                GoodsPage updatedGoodsPage = new GoodsPage();
                String[] valueList = value.split(",");
                for (int i = 0; i < valueList.length; i++) {
                    fillField(updatedGoodsPage.fabricator.findElement(By.xpath("//input[@type='text']")), valueList[i]);
                    stopExecuted(3);
                    updatedGoodsPage = new GoodsPage();
                    WebElement webElement = updatedGoodsPage.fabricator.findElement(By.xpath("//span[text()='" + valueList[i] + "']"));
                    webElement.click();
                    stopExecuted(10);
                }
                break;
            default:  throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице");
        }
    }

    public String getFillField(String fieldName) {
        switch (fieldName) {
            case  "Цена от":
                return priceFrom.getAttribute("value");
            case  "Производитель":
                fabricator.findElement(By.xpath("//button[text()='Свернуть']")).click();
                stopExecuted(2);
                GoodsPage updatedGoodsPage = new GoodsPage();
                String result = "";
                List<WebElement> listOfWebElements = updatedGoodsPage.fabricator.findElements(By.xpath(".//input[@type='checkbox']"));
                for (WebElement webElement : listOfWebElements) {
                    if (webElement.isSelected()) {
                        result = result + webElement.findElement(By.xpath("./ancestor::label//span")).getText() + ",";
                    }
                }
                result = result.substring(0, result.length() - 1);
                return result;
            default:  throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице");
        }
    }

    public int getCountOfSearchResults() {
        listOfResults = searchResults.findElements(By.xpath("./div[contains(@class, 'n-snippet-list')]" +
                "/div[contains(@class, 'n-snippet-card') or contains(@class, 'n-snippet-cell')]"));
        return listOfResults.size();
    }

    public void saveElementName(String numberOfElement) {
        savedElement = listOfResults.get(Integer.parseInt(numberOfElement)).
                findElement(By.xpath("//h3")).getText();
    }

    public void findElement() {
        fillField(searchString.findElement(By.xpath("//span[contains(@class, 'input')]//input")), savedElement);
        searchString.findElement(By.xpath("//span[contains(@class, 'button')]//button")).click();
    }

    public void foundElementEqualsSavedElement() {
        String foundElementName = searchResults.findElements(By.xpath("./div[contains(@class, 'n-snippet-list')]/div"))
                .get(0).findElement(By.xpath("//h3")).getText();
        Assert.assertTrue(String.format("Найденное значение [%s]. Сохраненное значение [%s]", foundElementName, savedElement),
                foundElementName.equals(savedElement));
    }
}
