package tests;

import data.Language;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.components.HabrSearchWebTestComponents;

public class HabrSearchWebTest extends BaseTest {
    HabrSearchWebTestComponents searchComponents = new HabrSearchWebTestComponents();

    @BeforeEach
    void setUp() {
        searchComponents.openPage();
    }


    @ValueSource(strings = {
            "Java",
            "Postman",
            "QA"
    })
    @ParameterizedTest(name = "Поисковой запрос {0} с выводом карточек > 0")
    void searchFormShouldHaveCardsTest(String testData) {
        searchComponents.searchInput()
                .setValueSearch(testData)

                .checkSearchValue(testData);
    }
    @CsvFileSource(resources = "/csvSource/dataCardsSearch.csv", delimiter = '|')
    @ParameterizedTest (name = "Поисковой запрос {0} с выводом карточек содержащий текст в нём")
    void searchFormShouldHaveCardsWithCorrectlyTextTest(String value, String text) {
        searchComponents.searchInput()
                .setValueSearch(value)
                .checkMainButtonsSite()

                .checkCardsText(text);
    }
    @EnumSource(Language.class)
    @ParameterizedTest(name = "Проверка корректного изменения языка {0} и кнопок на главной странице")
    void changeLanguageSettingsGuestMainSiteTest(Language language) {
        searchComponents.searchInput()
                .menuGuestOpen()
                .settingsLanguageOpen(language)
                .saveSettingsMenu()

                .checkMainButtonsSite(language);
    }
}
