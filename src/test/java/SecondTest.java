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


public class SecondTest {
    WebDriver driver;
    private static final String baseUrl = "https://idemo.bspb.ru/";
    private final SelenideElement codeInput = Selenide.$(By.xpath("//input[@id='otp-code']"));
    private final SelenideElement codeBtn = Selenide.$(By.xpath("//button[@id='login-otp-button']"));


    public SecondTest() {
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
        this.step2();
    }

    @Step("Второй шаг проверки сайта на ввод значения 0000")
    public void step2() {
        this.codeInput.should(Condition.visible).val("0000");
        this.codeBtn.should(Condition.visible).click();
    }

    @AfterEach
    public void after() {
    }
}
