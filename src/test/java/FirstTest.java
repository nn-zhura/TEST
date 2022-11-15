import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class FirstTest {
    WebDriver driver;
    private static final String baseUrl = "https://idemo.bspb.ru/";
    private final SelenideElement loginInput = Selenide.$(By.xpath("//input[@name='username']"));
    private final SelenideElement passwordInput = Selenide.$(By.xpath("//input[@name='password']"));
    private final SelenideElement loginBtn = Selenide.$(By.xpath("//button[@id='login-button']"));


    public FirstTest() {
    }

    @BeforeAll
    static void beforeConfig() {
        WebDriverManager.edgedriver().setup();
        Configuration.browser = "edge";
        Configuration.browserSize = "1920x1080";
    }

    public void setUp() {
        this.driver = new EdgeDriver();
        this.driver.get("url");
        this.driver.manage().window().maximize();
    }

    @BeforeEach
    public void before() {
        Selenide.open(baseUrl);
    }

    @Test
    public void test() {
        this.step1();
    }

    @Step("Первый шаг проверки сайта на ввод значения demo")
    public void step1() {
        this.loginInput.should(Condition.visible).val("demo");
        this.passwordInput.should(Condition.visible).val("demo");
        this.loginBtn.should(Condition.visible).click();
    }

    @AfterEach
    public void after() {
    }
}
