import com.microsoft.playwright.options.LoadState;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {
    @Test
    public void testHomePage_URLAndTitle_AsExpected() {
        String expectedHomeURL = "http://localhost:3000/";
        String expectedHomeTitle = "VF | Elegant Clothing For Her and For Him | Made in USA – VF";

        Assert.assertEquals(getPage().url(), expectedHomeURL);
        Assert.assertEquals(getPage().title(), expectedHomeTitle);
    }

    @Test
    public void testClickLogoNavigatesToHome() {
        String expectedHomeURL = "http://localhost:3000/";
        String expectedHomeTitle = "VF | Elegant Clothing For Her and For Him | Made in USA – VF";

        getPage().locator("nav a[href='/men']").click();
        String menUrl = getPage().url();
        String menTitle = getPage().title();
        getPage().locator("nav .brand-logo").click();

        Assert.assertNotEquals(menUrl, expectedHomeURL);
        Assert.assertNotEquals(menTitle, expectedHomeTitle);
        Assert.assertEquals(getPage().url(), expectedHomeURL);
        Assert.assertEquals(getPage().title(), expectedHomeTitle);
    }

    @Test(dependsOnMethods = "testHomePage_URLAndTitle_AsExpected")
    public void testMenuMen_NavigatesTo_MenPage() {
        String expectedMenUrl = "http://localhost:3000/men";
        String expectedMenTitle = "VF Shop | For Him";

        String homeURL = getPage().url();
        String homeTitle = getPage().title();

        getPage().locator("nav a[href='/men']").click();

        String menUrl = getPage().url();
        String menTitle = getPage().title();

        Assert.assertNotEquals(homeURL, menUrl);
        Assert.assertNotEquals(homeTitle, menTitle);

        Assert.assertEquals(menUrl, expectedMenUrl);
        Assert.assertEquals(menTitle, expectedMenTitle);
    }

    @Test(dependsOnMethods = "testHomePage_URLAndTitle_AsExpected")
    public void testMenuWoman_NavigatesTo_WomenPage() {
        String expectedWomanUrl = "http://localhost:3000/women";
        String expectedWomanTitle = "VF Shop | For Her";

        String homeURL = getPage().url();
        String homeTitle = getPage().title();

        getPage().locator("nav a[href='/women']").click();

        String womanUrl = getPage().url();
        String womanTitle = getPage().title();

        Assert.assertNotEquals(homeURL, womanUrl);
        Assert.assertNotEquals(homeTitle, womanTitle);

        Assert.assertEquals(womanUrl, expectedWomanUrl);
        Assert.assertEquals(womanTitle, expectedWomanTitle);
    }

    @Test(dependsOnMethods = "testHomePage_URLAndTitle_AsExpected")
    public void testMenuAccessories_NavigatesTo_AccessoriesPage() {
        String expectedAccessoriesUrl = "http://localhost:3000/accessories";
        String expectedAccessoriesTitle = "VF Shop | Accessories";

        String homeURL = getPage().url();
        String homeTitle = getPage().title();

        getPage().locator("nav a[href='/accessories']").click();

        String accessoriesUrl = getPage().url();
        String accessoriesTitle = getPage().title();

        Assert.assertNotEquals(homeURL, accessoriesUrl);
        Assert.assertNotEquals(homeTitle, accessoriesTitle);

        Assert.assertEquals(accessoriesUrl, expectedAccessoriesUrl);
        Assert.assertEquals(accessoriesTitle, expectedAccessoriesTitle);
    }

    @Test(dependsOnMethods = "testHomePage_URLAndTitle_AsExpected")
    public void testMenuAbout_ScrollsTo_FooterAboutSection() {
        String expectedFooterAboutTitle = "ABOUT COMPANY:";

        String homeURL = getPage().url();

        // Simulating scrolling to the #footer-about section
        getPage().evaluate("document.querySelector('a[href=\"#footer-about\"]').scrollIntoView();");

        // wait to ensure the page scrolls to the #footer-about section
        getPage().waitForLoadState(LoadState.NETWORKIDLE);

        String footerAboutUrl = getPage().url();
        String footerAboutTitle = getPage().locator("div.about-company > p:nth-child(1)").innerText();

        Assert.assertEquals(homeURL, footerAboutUrl); // URL stays the same (no page reload)
        Assert.assertEquals(footerAboutTitle, expectedFooterAboutTitle);
    }

    @Test(dependsOnMethods = "testHomePage_URLAndTitle_AsExpected")
    public void testCartIcon_NavigatesTo_CartPage() {
        String expectedCartUrl = "http://localhost:3000/cart";
        String expectedCartTitle = "VF Shop | Cart";

        String homeURL = getPage().url();
        String homeTitle = getPage().title();

        getPage().locator("nav a[href='/cart']").click();

        String cartUrl = getPage().url();
        String cartTitle = getPage().title();

        Assert.assertNotEquals(homeURL, cartUrl);
        Assert.assertNotEquals(homeTitle, cartTitle);

        Assert.assertEquals(cartUrl, expectedCartUrl);
        Assert.assertEquals(cartTitle, expectedCartTitle);
    }

    @Test(dependsOnMethods = "testHomePage_URLAndTitle_AsExpected")
    public void testSearchBtn_NavigatesTo_SearchResultsPage() {
        String expectedSearchUrl = "http://localhost:3000/search";
        String expectedSearchTitle = "VF Shop | Search Results";

        String homeURL = getPage().url();
        String homeTitle = getPage().title();

        getPage().locator("nav .search-btn").click();

        String searchUrl = getPage().url();
        String searchTitle = getPage().title();

        Assert.assertNotEquals(homeURL, searchUrl);
        Assert.assertNotEquals(homeTitle, searchTitle);

        Assert.assertEquals(searchUrl, expectedSearchUrl);
        Assert.assertEquals(searchTitle, expectedSearchTitle);
    }

    @Test(dependsOnMethods = "testHomePage_URLAndTitle_AsExpected")
    public void testForHimLink_NavigatesTo_MenPage() {
        String expectedForHimUrl = "http://localhost:3000/men";
        String expectedForHimTitle = "VF Shop | For Him";

        String homeURL = getPage().url();
        String homeTitle = getPage().title();

        getPage().locator("section.collection-container > a[href='/men']" ).click();

        String forHimUrl = getPage().url();
        String forHimTitle = getPage().title();

        Assert.assertNotEquals(homeURL, forHimUrl);
        Assert.assertNotEquals(homeTitle, forHimTitle);

        Assert.assertEquals(forHimUrl, expectedForHimUrl);
        Assert.assertEquals(forHimTitle, expectedForHimTitle);
    }

    @Test(dependsOnMethods = "testHomePage_URLAndTitle_AsExpected")
    public void testForHerLink_NavigatesTo_WomenPage() {
        String expectedForHerUrl = "http://localhost:3000/women";
        String expectedForHerTitle = "VF Shop | For Her";

        String homeURL = getPage().url();
        String homeTitle = getPage().title();

        getPage().locator("section.collection-container > a[href='/women']").click();

        String forHerUrl = getPage().url();
        String forHerTitle = getPage().title();

        Assert.assertNotEquals(homeURL, forHerUrl);
        Assert.assertNotEquals(homeTitle, forHerTitle);

        Assert.assertEquals(forHerUrl, expectedForHerUrl);
        Assert.assertEquals(forHerTitle, expectedForHerTitle);
    }

    @Test(dependsOnMethods = "testHomePage_URLAndTitle_AsExpected")
    public void testAccessoriesLink_NavigatesTo_AccessoriesPage() {
        String expectedAccessoriesUrl = "http://localhost:3000/accessories";
        String expectedAccessoriesTitle = "VF Shop | Accessories";

        String homeURL = getPage().url();
        String homeTitle = getPage().title();

        getPage().locator("section.collection-container > a[href='/accessories']").click();

        String accessoriesUrl = getPage().url();
        String accessoriesTitle = getPage().title();

        Assert.assertNotEquals(homeURL, accessoriesUrl);
        Assert.assertNotEquals(homeTitle, accessoriesTitle);

        Assert.assertEquals(accessoriesUrl, expectedAccessoriesUrl);
        Assert.assertEquals(accessoriesTitle, expectedAccessoriesTitle);
    }

    @Test(dependsOnMethods = "testHomePage_URLAndTitle_AsExpected")
    public void testClickLogoInFooter_NavigatesTo_Home() {
        String expectedLogoInFooterURL = "http://localhost:3000/";
        String expectedLogoInFooterTitle = "VF | Elegant Clothing For Her and For Him | Made in USA – VF";

        getPage().locator("nav a[href='/men']").click();
        String menUrl = getPage().url();
        String menTitle = getPage().title();
        getPage().locator("#footer-about > div > a").click();

        Assert.assertNotEquals(menUrl, expectedLogoInFooterURL);
        Assert.assertNotEquals(menTitle, expectedLogoInFooterTitle);
        Assert.assertEquals(getPage().url(), expectedLogoInFooterURL);
        Assert.assertEquals(getPage().title(), expectedLogoInFooterTitle);
    }

    @Test(dependsOnMethods = "testHomePage_URLAndTitle_AsExpected")
    public void testClickTermsLink_NavigatesTo_TermsPage() {
        String expectedTermsURL = "http://localhost:3000/terms";
        String expectedTermsTitle = "VF Shop | Terms and Conditions";

        String homeUrl = getPage().url();
        String homeTitle = getPage().title();
        getPage().locator("a[href='/terms']").click();

        Assert.assertNotEquals(homeUrl, expectedTermsURL);
        Assert.assertNotEquals(homeTitle, expectedTermsTitle);
        Assert.assertEquals(getPage().url(), expectedTermsURL);
        Assert.assertEquals(getPage().title(), expectedTermsTitle);
    }

    @Test(dependsOnMethods = "testHomePage_URLAndTitle_AsExpected")
    public void testClickPrivacyLink_NavigatesTo_PrivacyPage() {
        String expectedPrivacyURL = "http://localhost:3000/privacy";
        String expectedPrivacyTitle = "VF Shop | Privacy Policy";

        String homeUrl = getPage().url();
        String homeTitle = getPage().title();
        getPage().locator("a[href='/privacy']").click();

        Assert.assertNotEquals(homeUrl, expectedPrivacyURL);
        Assert.assertNotEquals(homeTitle, expectedPrivacyTitle);
        Assert.assertEquals(getPage().url(), expectedPrivacyURL);
        Assert.assertEquals(getPage().title(), expectedPrivacyTitle);
    }
}
