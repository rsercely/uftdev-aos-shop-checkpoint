package g1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.hp.lft.sdk.*;
import com.hp.lft.sdk.web.*;
import com.hp.lft.verifications.*;

import unittesting.*;

public class UFTDeveloperTest extends UnitTestClassBase {

    public UFTDeveloperTest() {
        //Change this constructor to private if you supply your own public constructor
    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        instance = new UFTDeveloperTest();
        globalSetup(UFTDeveloperTest.class);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        globalTearDown();
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() throws GeneralLeanFtException {
        Browser browser = BrowserFactory.launch(BrowserType.CHROME);

        browser.navigate("http://advantageonlineshopping.com/");

        Link tabletsCategoryTxtLink = browser.describe(Link.class, new LinkDescription.Builder()
                .innerText("TABLETS")
                .tagName("SPAN").build());
        tabletsCategoryTxtLink.click();

        WebElement hPElitePad1000G2TabletWebElement = browser.describe(WebElement.class, new WebElementDescription.Builder()
                .innerText("HP ElitePad 1000 G2 Tablet")
                .tagName("A").build());
        hPElitePad1000G2TabletWebElement.click();

        EditField quantityEditField = browser.describe(EditField.class, new EditFieldDescription.Builder()
                .name("quantity")
                .tagName("INPUT")
                .type("text").build());
        quantityEditField.setValue("2");

        Button saveToCartButton = browser.describe(Button.class, new ButtonDescription.Builder()
                .buttonType("submit")
                .name("ADD TO CART")
                .tagName("BUTTON").build());
        saveToCartButton.click();

        WebElement menuCartWebElement = browser.describe(WebElement.class, new WebElementDescription.Builder()
                .accessibilityName("")
                .id("menuCart")
                .innerText("")
                .tagName("svg").build());
        menuCartWebElement.hoverTap();


        WebElement webElement1 = browser.describe(WebElement.class, new WebElementDescription.Builder()
                .innerText("2,018.00")
                .index(1)
                .tagName("SPAN").build());


        menuCartWebElement.highlight();

        WebElement webElementrrs = browser.describe(WebElement.class, new XPathDescription("//TOOL-TIP-CART[@id=\"toolTipCart\"]/DIV[1]/TABLE[1]/TFOOT[1]/TR[1]/TD[2]"));
        Verify.areEqual("2,018.00", webElementrrs.getInnerText(), "Verification", "Verify property: innerText");

        WebElement webElement = browser.describe(WebElement.class, new WebElementDescription.Builder()
                .className("removeProduct iconCss iconX")
                .innerText("")
                .tagName("DIV").build());
        webElement.click();

        Link hOMELink = browser.describe(Link.class, new LinkDescription.Builder()
                .innerText("HOME")
                .tagName("A").build());
        hOMELink.click();

    }

}

