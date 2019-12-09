package steps;

import pages.YandexMainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class YandexMainSteps {
    @Step("на главной странице выбран таб {0}")
    public void selectTabItem(String tabItem){
        new YandexMainPage().selectTabItem(tabItem);
    }
}
