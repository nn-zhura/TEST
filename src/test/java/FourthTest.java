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

import static java.lang.Thread.sleep;

public class FourthTest {
    WebDriver driver;
    private static String baseUrl = "https://idemo.bspb.ru/";


    private final SelenideElement loginInput = Selenide.$(By.xpath("//input[@name='username']"));
    private final SelenideElement passwordInput = Selenide.$(By.xpath("//input[@name='password']"));
    private final SelenideElement loginBtn = Selenide.$(By.xpath("//button[@id='login-button']"));


    private final SelenideElement codeInput = Selenide.$(By.xpath("//input[@id='otp-code']"));
    private final SelenideElement codeBtn = Selenide.$(By.xpath("//button[@id='login-otp-button']"));


    private final SelenideElement buttonName5 = Selenide.$(By.xpath("//a[@id='deposits-index']"));
    private final SelenideElement buttonReRegister = Selenide.$(By.xpath("//a[@href='/deposits/10056/reopen/form']"));
    private final SelenideElement conditionDepositReopenCheckBoxInput = Selenide.$(By.xpath("//input[@name='condition.deposit.reopen.conditions']"));
    private final SelenideElement buttonSend = Selenide.$(By.xpath("//button[@id='submit-button']"));
    private final SelenideElement buttonConfirm = Selenide.$(By.xpath("//button[@id='confirm']"));

    public FourthTest() {
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
    public void test() throws InterruptedException {
        step1();
        step2();
        step4();
    }

    @Step("Первый шаг проверки сайта на ввод значения demo")
    public void step1() {
        this.loginInput.should(Condition.visible).val("demo");
        this.passwordInput.should(Condition.visible).val("demo");
        this.loginBtn.should(Condition.visible).click();
    }

    @Step("Второй шаг проверки сайта на ввод значения 0000")
    public void step2() {
        this.codeInput.should(Condition.visible).val("0000");
        this.codeBtn.should(Condition.visible).click();
    }


    @Step("Четвертая проверка сайта. Вкладка СЧЕТА -> Выписка")
    public void step4() throws InterruptedException {
        this.buttonName5.should(Condition.visible).click();
        this.buttonReRegister.should(Condition.visible).click();
        this.conditionDepositReopenCheckBoxInput.should(Condition.visible).click();
        this.buttonSend.should(Condition.visible).click();
        //прости пж
        sleep(6000);
        this.buttonConfirm.should(Condition.visible).click();
    }

    @AfterEach
    public void after() {
    }
}
