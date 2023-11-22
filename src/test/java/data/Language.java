package data;

public enum Language {
    English("All streams Development Admin Design Management Marketing PopSci Search Profile"),
    Русский("Все потоки Разработка Администрирование Дизайн Менеджмент Маркетинг Научпоп Поиск Профиль");
    public final String description;
    Language(String description) {
        this.description = description;
    }
}
