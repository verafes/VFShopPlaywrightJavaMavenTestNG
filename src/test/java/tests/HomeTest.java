package tests;

import com.microsoft.playwright.Locator;
import model.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static utils.ProjectConstant.*;

public class HomeTest extends BaseTest {
    @Test
    public void testHomePageLogoVisibility() {
        final Locator logoImg = new HomePage(getPage()).getLogoIMGLocator();

        String actualImgSrc = logoImg.getAttribute("src");

        assertThat(logoImg).isVisible();
        Assert.assertEquals(actualImgSrc, LOGO_IMG_SRC);
    }

    @Test
    public void testHomepageLogoLink() {
        Locator logoLinkElement = new HomePage(getPage()).getLogoLocator();

        String actualLogoUrl = logoLinkElement.getAttribute("href");

        Assert.assertEquals( actualLogoUrl, HOME_END_POINT);
    }

    @Test
    public void testSearchBtnTextAndLink() {
        final String expectedUrl = "/search";
        HomePage homePage = new HomePage(getPage());
        final Locator searchBtn = homePage.getSearchBtn();

        String actualSearchBtnURL = searchBtn
                .getAttribute("onclick")
                .split(" = ")[1].replace("'", "");
        System.out.println(actualSearchBtnURL);
        assertThat(searchBtn).isVisible();
        Assert.assertEquals(actualSearchBtnURL, expectedUrl);
    }

    @Test
    public void testPlaceholderInSearchField() {
        HomePage homePage = new HomePage(getPage());

        Locator searchField = homePage.getSearchField();

        assertThat(searchField).isVisible();

        String searchPlaceholder = searchField.getAttribute("placeholder");

        Assert.assertEquals(searchPlaceholder, SEARCH_PLACEHOLDER, "Placeholder value doesn't match");

    }

    @Test
    public void testCartBtnTextAndLink() {
        final String expectedUrl = "/cart";

        HomePage homePage = new HomePage(getPage());
        final Locator cartBtn = homePage.getCartBtn();

        String actualHrefValue = cartBtn
                .getAttribute("onclick")
                .split(" = ")[1].replace("'", "");
        System.out.println(actualHrefValue);
        assertThat(cartBtn).isVisible();
        Assert.assertEquals(actualHrefValue, expectedUrl);
    }

    @Test
    public void testHeroLogoVisibility() {
        final Locator heroLogoImg = new HomePage(getPage()).getHeroLogoIMGLocator();

        assertThat(heroLogoImg).isVisible();
    }

    @Test
    public void testHeroMottoText() {
        final Locator motto = new HomePage(getPage()).getHeroMottoLocator();

        assertThat(motto).isVisible();
        Assert.assertEquals(motto.innerText(), MOTTO);
    }


}
