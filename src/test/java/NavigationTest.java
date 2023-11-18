import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestData;

import static utils.ProjectConstants.*;

public class NavigationTest extends BaseTest {
    @Test
    public void testHomePage_URLAndTitle_AsExpected() {
        Assert.assertEquals(getPage().url(), BASE_URL);
        Assert.assertEquals(getPage().title(), BASE_TITLE);
    }

    @Test(dependsOnMethods = "testHomePage_URLAndTitle_AsExpected")
    public void testClickLogoNavigatesToHome() {
        getPage().getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("men").setExact(true)).click();
        String menUrl = getPage().url();
        String menTitle = getPage().title();
        getPage().locator("nav .brand-logo").click();

        Assert.assertNotEquals(menUrl, BASE_URL);
        Assert.assertNotEquals(menTitle, BASE_TITLE);
        Assert.assertEquals(getPage().url(), BASE_URL);
        Assert.assertEquals(getPage().title(), BASE_TITLE);
    }

    @Test(
            dataProvider =  "NavigationBarAndHomeLinksTestData",
            dataProviderClass = TestData.class,
            dependsOnMethods = "testHomePage_URLAndTitle_AsExpected"
    )
    public void testNavBarMenuAndHomeLinks_NavigateTo_CorrespondingPage(String locator, String expectedURL, String expectedTitle) {
        String logoID = "nav .brand-logo";
        String footerLogoID = "#footer-about > div > a";
        String homeMenu = "nav li a[href='/']";


        getPage().locator(locator).click();

        String actualUrl = getPage().url();
        String actualTitle = getPage().title();

        if (!locator.equals(logoID) || !locator.equals(footerLogoID) || !locator.equals(homeMenu)) {
            Assert.assertNotEquals(BASE_URL, actualUrl);
            Assert.assertNotEquals(BASE_TITLE, actualTitle);
        }

        Assert.assertEquals(actualUrl, expectedURL);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test(dependsOnMethods = "testHomePage_URLAndTitle_AsExpected")
    public void testMenuAbout_ScrollsTo_FooterAboutSection() {

        getPage().getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("about")).click();

        getPage().waitForLoadState(LoadState.NETWORKIDLE);

        String footerAboutTitle = getPage().locator("div.about-company > p:nth-child(1)").innerText();

        Assert.assertEquals(footerAboutTitle, ABOUT_TITLE);
    }
}
