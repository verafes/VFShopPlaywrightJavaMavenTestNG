import model.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestData;

import static utils.ProjectConstant.*;

public class NavigationTest extends BaseTest {
    @Test
    public void testHomePage_URLAndTitle_AsExpected() {
        Assert.assertEquals(getPage().url(), BASE_URL);
        Assert.assertEquals(getPage().title(), BASE_TITLE);
    }

    @Test(
            dataProvider =  "NavigationBarTestData",
            dataProviderClass = TestData.class,
            dependsOnMethods = "testHomePage_URLAndTitle_AsExpected")
    public void testClickLogoNavigatesToHome(String menu, String expectedURL, String expectedTitle) {
        HomePage homePage = new HomePage(getPage());
        homePage.clickMenu(menu);
        homePage.clickLogo();

        if (!menu.equals("Home") && !menu.equals("About")) {
            Assert.assertNotEquals(expectedURL, BASE_URL);
            Assert.assertNotEquals(expectedTitle, BASE_TITLE);
        }
        Assert.assertEquals(getPage().url(), BASE_URL);
        Assert.assertEquals(getPage().title(), BASE_TITLE);
    }

    @Test(
            dataProvider =  "NavigationBarTestData",
            dataProviderClass = TestData.class,
            dependsOnMethods = "testHomePage_URLAndTitle_AsExpected"
    )
    public void testNavBarMenu_NavigateTo_CorrespondingPage(
            String menu, String expectedURL, String expectedTitle) {
        HomePage homePage = new HomePage(getPage());
        homePage.clickMenu(menu);

        String actualUrl = getPage().url();
        String actualTitle = getPage().title();

        if (!menu.equals("Home") && !menu.equals("About")) {
            Assert.assertNotEquals(BASE_URL, actualUrl);
            Assert.assertNotEquals(BASE_TITLE, actualTitle);
        }

        Assert.assertEquals(actualUrl, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test(dependsOnMethods = "testHomePage_URLAndTitle_AsExpected")
    public void testMenuAbout_ScrollsTo_FooterAboutSection() {
        HomePage homePage = new HomePage(getPage());
        homePage.clickAboutMenu();

        String footerAboutTitle = homePage.getAboutHeading().innerText();

        Assert.assertEquals(getPage().url(), ABOUT_URL);
        Assert.assertEquals(footerAboutTitle, ABOUT_HEADING);
    }
    @Test(
            dataProvider =  "NavButtonsTestData",
            dataProviderClass = TestData.class,
            dependsOnMethods = "testHomePage_URLAndTitle_AsExpected")
    public void testNavButtons_NavigateTo_CorrespondingPage(
            String option, String expectedURL, String expectedTitle
    ) {
        HomePage homePage = new HomePage(getPage());
        homePage.clickButton(option);

        String actualUrl = getPage().url();
        String actualTitle = getPage().title();

        Assert.assertNotEquals(BASE_URL, actualUrl);
        Assert.assertNotEquals(BASE_TITLE, actualTitle);
        Assert.assertEquals(actualUrl, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test(
            dataProvider =  "NavAndHomeLinksTestData",
            dataProviderClass = TestData.class,
            dependsOnMethods = "testHomePage_URLAndTitle_AsExpected")
    public void testNavAndHomeLinks_NavigateTo_CorrespondingPage(
            String option, String expectedURL, String expectedTitle
    ) {
        HomePage homePage = new HomePage(getPage());
        homePage.clickLink(option);

        String actualUrl = getPage().url();
        String actualTitle = getPage().title();

        Assert.assertNotEquals(BASE_URL, actualUrl);
        Assert.assertNotEquals(BASE_TITLE, actualTitle);
        Assert.assertEquals(actualUrl, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
