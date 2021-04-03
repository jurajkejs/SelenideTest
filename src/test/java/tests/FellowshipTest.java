package tests;

import base.TestBase;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FellowshipTest extends TestBase {

    @Before
    public void openPage() {
        open("/fellowship.php");
    }

    @Test
    public void itShouldContainNameForEachFellow() {
        ElementsCollection fellowElements = getFellowElements();

        for (WebElement fellowElement : fellowElements) {
            Assert.assertFalse(fellowElement.findElement(By.cssSelector("h1")).getText().isEmpty());
        }
    }

    @Test
    public void itShouldContainSpecifiedFellows() {
        ElementsCollection fellowElements = getFellowElements();
        List<String> fellowNames = new ArrayList<String>();

        for (WebElement fellowElement : fellowElements) {
            System.out.println(fellowElement.findElement(By.cssSelector("h1")).getText());
            fellowNames.add(fellowElement.findElement(By.cssSelector("h1")).getText());
        }
        System.out.println(fellowNames);
        Assert.assertTrue(fellowNames.contains("Gandalf"));
        Assert.assertTrue(fellowNames.contains("Aragorn"));
        Assert.assertTrue(fellowNames.contains("Frodo"));
    }

    @Test
    public void itShouldDisplayMessageComplete() {
        List<String> fellowsToSelect = new ArrayList<String>();
        fellowsToSelect.add("Gandalf");
        fellowsToSelect.add("Aragorn");
        fellowsToSelect.add("Legolas");
        fellowsToSelect.add("Frodo");

        for (String fellowToSelect : fellowsToSelect) {
            selectFellow(fellowToSelect);
        }

        Assert.assertEquals("Complete", $(By.cssSelector("div.points-left h3")).getText());
    }

    @Test
    public void itShouldDisplayPointsForEachFellow() {
        ElementsCollection displayedFellows = getFellowElements();
        for (WebElement displayedFellow : displayedFellows) {

            String actualPoints = displayedFellow.findElement(By.cssSelector("div.fellow-points h2")).getText();

            Assert.assertFalse(actualPoints.isEmpty());
        }
    }

    @Test
    public void itShouldHighlightFellows() {
        List<String> fellowsToSelect = new ArrayList<String>();
        fellowsToSelect.add("Gandalf");
        fellowsToSelect.add("Aragorn");
        fellowsToSelect.add("Legolas");
        fellowsToSelect.add("Frodo");

        for (String fellowToSelect : fellowsToSelect) {
            selectFellow(fellowToSelect);
        }

        $("ul.list-of-fellows")
                .findAll("li > div")
                .filterBy(cssClass("active"))
                .shouldHave(CollectionCondition.textsInAnyOrder(fellowsToSelect));
    }

    private void selectFellow(String fellowName) {
        //   $x("//h1[contains(text(),'" + fellowName + "')]").click();
        $(byText(fellowName)).click();
    }

    private ElementsCollection getFellowElements() {
       return  $("ul.list-of-fellows").findAll("li");
    }
}
