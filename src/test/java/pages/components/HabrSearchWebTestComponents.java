package pages.components;

import com.codeborne.selenide.SelenideElement;
import data.Language;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HabrSearchWebTestComponents {
    private final static SelenideElement searchInputText = $("input.tm-input-text-decorated__input"),
            cardsSearchText = $("a.tm-title__link"),
            menuGuest = $("[data-test-id=menu-toggle-guest]"),
            settingsLanguage = $("[class=tm-user-menu__menu-link-text]"),
            languageSelectEn = $(".tm-fieldset__container"),
            buttonSaveSettingsMenu = $(".btn"),
            mainMenuContent = $(".tm-base-layout__header-wrapper"),
            sortButtonContent = $("button.tm-navigation-dropdown__button"),
            selectOptionSort = $(".tm-navigation-dropdown__options_absolute").find(byText("по рейтингу"));

    public HabrSearchWebTestComponents openPage() {
        open("/ru/search/");
        return this;
    }
    public HabrSearchWebTestComponents searchInput() {
        searchInputText.click();
        return this;
    }
    public HabrSearchWebTestComponents setValueSearch(String testData) {
        searchInputText.setValue(testData).pressEnter();
        return this;
    }
    public HabrSearchWebTestComponents checkSearchValue(String value) {
        searchInputText.shouldHave(value(value));
        return this;
    }
    public HabrSearchWebTestComponents checkCardsText(String text) {
        cardsSearchText.shouldHave(text(text));
        return this;
    }
    public HabrSearchWebTestComponents menuGuestOpen() {
        menuGuest.click();
        return this;
    }
    public HabrSearchWebTestComponents settingsLanguageOpen() {
        settingsLanguage.click();
        return this;
    }
    public HabrSearchWebTestComponents selectLanguage(Language language) {
        languageSelectEn.find(byText(language.name())).click();
        return this;
    }
    public HabrSearchWebTestComponents saveSettingsMenu () {
            buttonSaveSettingsMenu.click();
            return this;
    }
    public HabrSearchWebTestComponents checkMainButtonsSite (Language language){
            mainMenuContent.shouldHave(text(language.description));
            return this;
        }
    public HabrSearchWebTestComponents checkMainButtonsSite () {
        sortButtonContent.click();
        selectOptionSort.click();
        return this;
    }
}