package steps;

import org.junit.Assert;
import pages.GoodsPage;
import ru.yandex.qatools.allure.annotations.Step;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GoodsPageSteps {
    @Step("заголовок страницы равен {0}")
    public void checkPageTitle(String expectedTitle) {
        String actualTitle = new GoodsPage().title.getText();
        Assert.assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
                actualTitle, expectedTitle), actualTitle.contains(expectedTitle));
    }

    @Step("поле {0} заполняется значением {1}")
    public void fillField(String field, String value) {
        new GoodsPage().fillField(field, value);
    }

    @Step("поле {0} заполнено значением {1}")
    public void checkFillField(String field, String value){
        String actual = new GoodsPage().getFillField(field);
        assertTrue(String.format("Значение поля [%s] равно [%s]. Ожидалось - [%s]", field, actual, value),
                actual.equals(value));
    }

    @Step("выполнено нажатие на кнопку \"Применить\"")
    public void clickOnApplyButton() {
        new GoodsPage().clickApplyButton();
    }

    @Step("поле {0} заполнено значением {1}")
    public void checkSearchResultCount(String expectedValue) {
        int actualValue = new GoodsPage().getCountOfSearchResults();
        assertEquals(String.format("Количество найденных результатов на странице равно [%s]. Ожидалось - [%s]", actualValue, expectedValue),
                actualValue, Integer.parseInt(expectedValue));
    }

    @Step("сохранено значение элемента [{1}] из списка с найденными результатами")
    public void saveElement(String numberOfElement) {
        new GoodsPage().saveElementName(numberOfElement);
    }

    @Step("в поисковую строку введено сохраненное значение и нажата кнопка \"Поиск\"")
    public void findElement() {
        new GoodsPage().findElement();
    }

    public void foundElementEqualsSavedElement() {
        new GoodsPage().foundElementEqualsSavedElement();
    }
}
