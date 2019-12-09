package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ScenarioSteps {
    YandexMainSteps yandexMainSteps = new YandexMainSteps();
    YandexMarketMainPageSteps yandexMarketMainPageSteps = new YandexMarketMainPageSteps();
    GoodsPageSteps goodsPageSteps = new GoodsPageSteps();
    GoodsCategoryPageSteps goodsCategoryPageSteps = new GoodsCategoryPageSteps();

    @When("^на главной странице выбран таб \"(.+)\"$")
    public void selectTabItem(String tabName) {
        yandexMainSteps.selectTabItem(tabName);
    }

    @Then("^заголовок страницы \"(.+)\" равен \"(.+)\"$")
    public void checkTitleYandexMarketMainPage(String page, String title) {
        switch (page) {
            case "ЯндексМаркет":
                yandexMarketMainPageSteps.checkPageTitle(title);
                break;
            case "Электроника":
                goodsCategoryPageSteps.checkPageTitle(title);
                break;
            case "Телевизоры":
            case "Наушники и Bluetooth-гарнитуры":
                goodsPageSteps.checkPageTitle(title);
                break;
            default: throw new AssertionError("Страница '" + page + "' не описана");
        }
    }

    @When("^выполнено нажатие на пункт меню \"(.+)\"$")
    public void openMenuClickSubmenu(String menuItem) {
        yandexMarketMainPageSteps.openMainMenuItem(menuItem);
    }

    @When("^заполняются поля:$")
    public void fillForm(DataTable fields){
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> goodsPageSteps.fillField(field, value));
    }

    @Then("^значения полей равны:$")
    public void checkFillForm(DataTable fields){
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> goodsPageSteps.checkFillField(field, value));
    }

    @When("выполнено нажатие на кнопку \"Применить\"")
    public void clickOnCheckoutButton() {
        goodsPageSteps.clickOnApplyButton();
    }

    @Then("^количество результатов поиска на странице равно \"(.+)\"$")
    public void checkSearchResultCount(String expectedValue) {
        goodsPageSteps.checkSearchResultCount(expectedValue);
    }

    @When("сохранено название элемента с номером \"(.+)\" из списка с найденными результатами")
    public void saveElement(String number) {
                goodsPageSteps.saveElement(number);
    }

    @When("в поисковую строку введено сохраненное значение и нажата кнопка \"Поиск\"")
    public void findElement() {
        goodsPageSteps.findElement();
    }

    @Then("сохраненное значение и найденный результат совпадают")
    public void foundElementEqualsSavedElement() {
        goodsPageSteps.foundElementEqualsSavedElement();
    }
}
