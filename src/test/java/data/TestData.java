package data;

import com.github.javafaker.Faker;

public class TestData {
    public static final String BASE_URI = "https://stellarburgers.nomoreparties.site/";
    //Генерируем фейковые данные для пользователя
    public static final Faker user = new Faker();
    public static final String EMAIL = "email" + System.currentTimeMillis() + "@mail.ru";
    public static final String PASSWORD = user.regexify("[0-9]{6}");
    public static final String NAME = user.name().firstName() + System.currentTimeMillis();
}
