import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class Example {

    @BeforeClass
    public void precondition() {
//        Configuration.browser = Browsers.FIREFOX;
        Configuration.browser = Browsers.CHROME;
//        Configuration.browser = Browsers.IE;
//        Configuration.browser = Browsers.OPERA;
    }

    @Test
    public void firstTest() {
        open("https://www.google.com/");
        $(By.name("q"))
                .setValue("selenide")
                .pressEnter();
        $(".iUh30").shouldHave(Condition.text("selenide.org"));
    }

    @Test
    public void secondTest() {

    }
}
