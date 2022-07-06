package dit;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ParametrizwWebTest {

    @ValueSource(strings = {"Selenide", "Allure", "JUnit"})
    @ParameterizedTest(name = "Тестирование алгоритма поиска с общими тестовыми данными: {0}")
    void webTest(String testData){
        Selenide.open("https://ya.ru");
        Selenide.$("#text").setValue(testData);
        Selenide.$("button[type='submit']").click();
        Selenide.$$("li.serp-item")
                .first()
                .shouldHave(Condition.text(testData));

    }

    @CsvSource(value = {
            "Selenide,Selenide это фреймворк для автоматизированного тестирования",
            "JUnit, 5 is the next generation of"

    })
    @ParameterizedTest(name = "Тестирование алгоритма поиска с общими тестовыми данными: {0}")
    void webCsvTest(String testData, String expectedResult){
        Selenide.open("https://ya.ru");
        Selenide.$("#text").setValue(testData);
        Selenide.$("button[type='submit']").click();
        Selenide.$$("li.serp-item")
                .first()
                .shouldHave(Condition.text(expectedResult));

    }









}
