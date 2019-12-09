package steps;

import org.junit.Assert;
import pages.YandexMarketMainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class YandexMarketMainPageSteps {
    private YandexMarketMainPage yandexMarketMainPage = new YandexMarketMainPage();

    @Step("заголовок страницы равен {0}")
    public void checkPageTitle(String expectedTitle){
        String actualTitle = yandexMarketMainPage.title.getText();
        Assert.assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
                actualTitle, expectedTitle), actualTitle.contains(expectedTitle));
    }

    @Step("открыт пункт меню \"{0}\"")
    public void openMainMenuItem(String menuItem) {
        yandexMarketMainPage.openMenuItem(menuItem);
    }
}
