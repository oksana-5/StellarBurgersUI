import builder.UserBuilder;
import data.TestData;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.ForgotPasswordPage;
import page.LoginPage;
import page.MainPage;
import page.SignUpPage;

import static data.TestData.EMAIL;
import static data.TestData.PASSWORD;
import static java.net.HttpURLConnection.HTTP_OK;
import static steps.UserSteps.deleteUser;
import static steps.UserSteps.loginUser;

public class BaseTest {
    WebDriver driver;
    MainPage mainPage;
    ForgotPasswordPage forgotPasswordPage;
    LoginPage loginPage;
    SignUpPage signUpPage;

    @Before
    public void startUp() {
        String browser = System.getProperty("browser", "chrome");

        switch (browser) {
            case "chrome":
                startBrowserChrome();
                break;
            case "yandex":
                startBrowserYandex();
                break;
            default:
                throw new IllegalArgumentException("Неподдерживаемый браузер:" + browser);
        }

        mainPage = new MainPage(driver);
        forgotPasswordPage = new ForgotPasswordPage(driver);
        loginPage = new LoginPage(driver);
        signUpPage = new SignUpPage(driver);
        RestAssured.baseURI = TestData.BASE_URI;
    }

    private void startBrowserChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    private void startBrowserYandex() {
        System.setProperty("webdriver.chrome.driver", "C:/YandexDriver/yandexdriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        cleanupTestData();
        driver.quit();
        driver.quit();
    }

    private void cleanupTestData() {
        try {
            Response loginResponse = loginUser(new UserBuilder.Builder()
                    .withEmail(EMAIL)
                    .withPassword(PASSWORD)
                    .build()
            );

            if (loginResponse.getStatusCode() == HTTP_OK) {
                String accessToken = loginResponse.jsonPath().getString("accessToken");
                if (accessToken != null) {
                    deleteUser(accessToken);
                }
            }
        } catch (Exception ignored) {
        }
    }
}