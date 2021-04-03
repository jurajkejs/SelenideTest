package tests;

import base.TestBase;
import com.codeborne.selenide.ElementsCollection;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.*;

public class RandomTableTest extends TestBase {
    @Before
    public void openPage() {
        //1.otvorit stranku
        open("/tabulka.php");
    }

    @Test
    public void itShouldContainDataForEachRow() {
        for (WebElement tableRow : getRows()) {
            Assert.assertFalse(tableRow.getText().isEmpty());
        }
    }

    @Test
    public void itShouldContainNameForEachRow() {
        ElementsCollection tableRows = getRows();
        for (WebElement tableRow : tableRows) {
            tableRow.findElement(By.cssSelector("td:nth-child(2)"));
            WebElement rowName = tableRow.findElement(By.xpath("./td[2]"));
            Assert.assertFalse(rowName.getText().isEmpty());
        }
    }

    @Test
    public void itShouldDisplaySecondRow() {

        System.out.println($("table > tbody >tr",1).find("td",3).getText());
    }

    @Test
    public void itShouldScrollToLastElement() {
        $(By.cssSelector("table > tbody >tr:last-child")).scrollIntoView(false);
    }

    private ElementsCollection getRows() {
        return $$("table tbody tr");
    }
}
