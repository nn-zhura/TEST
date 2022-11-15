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

public class ThirdTest {
    WebDriver driver;
    private static final String baseUrl = "https://idemo.bspb.ru/";

    private final SelenideElement buttonName1 = Selenide.$(By.xpath("//a[@id='bank-overview']"));
    private final SelenideElement buttonName2 = Selenide.$(By.xpath("//a[@id='accounts-index']"));
    private final SelenideElement buttonName3 = Selenide.$(By.xpath("//a[@id='payments-form']"));
    private final SelenideElement buttonName4 = Selenide.$(By.xpath("//a[@id='cards-overview-index']"));
    private final SelenideElement buttonName5 = Selenide.$(By.xpath("//a[@id='deposits-index']"));
    private final SelenideElement buttonName6= Selenide.$(By.xpath("//a[@id='loans-index']"));
    private final SelenideElement buttonName7 = Selenide.$(By.xpath("//a[@id='externaltraderoom-index']"));
    private final SelenideElement buttonName8 = Selenide.$(By.xpath("//a[@id='insurance-travel']"));


    public ThirdTest() {
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
        this.step3();
    }

    @Step("Третий шаг проверки сайта на правильные названия кнопок")
    public void step3() {
        this.buttonName1.should(Condition.text("Обзор"));
        this.buttonName2.should(Condition.text("Счета"));
        this.buttonName3.should(Condition.text("Платежи и Переводы"));
        this.buttonName4.should(Condition.text("Карты"));
        this.buttonName5.should(Condition.text("Вклады"));
        this.buttonName6.should(Condition.text("Кредиты"));
        this.buttonName7.should(Condition.text("Валюта"));
        this.buttonName8.should(Condition.text("Страхование"));
    }

    @AfterEach
    public void after() {
    }
}
