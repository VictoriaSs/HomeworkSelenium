package steps;

import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.GoodsCategoryPage;
import ru.yandex.qatools.allure.annotations.Step;

public class GoodsCategoryPageSteps {
    @Step("заголовок страницы равен {0}")
    public void checkPageTitle(String expectedTitle) {
        String actualTitle = new GoodsCategoryPage().title.getText();
        Assert.assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
                actualTitle, expectedTitle), actualTitle.contains(expectedTitle));
    }

    @When("^выполнено нажатие на пункт вертикального меню \"(.+)\"$")
    public void openNavigationMenuItem(String menuItem) {
        new GoodsCategoryPage().openNavigationMenuItem(menuItem);
    }
}
