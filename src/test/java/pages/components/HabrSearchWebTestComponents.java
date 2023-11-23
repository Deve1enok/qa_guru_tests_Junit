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
            menuGuest = $(".tm-header-user-menu__toggle"),
            settingsSelectLanguage = $(".tm-fieldset__container"),
            buttonSaveSettingsMenu = $(".tm-page-settings-form__submit"),
            mainMenuContent = $("[class=tm-base-layout__header-wrapper]"),
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
    public HabrSearchWebTestComponents settingsLanguageOpen(Language language) {
        settingsSelectLanguage.find(byText(language.name().substring(0,1).toUpperCase() +
                language.name().substring(1).toLowerCase())).click();
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