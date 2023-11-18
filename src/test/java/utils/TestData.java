package utils;

import org.testng.annotations.DataProvider;

import static utils.ProjectConstants.ABOUT_TITLE;
import static utils.ProjectConstants.ACCESSORIES_TITLE;
import static utils.ProjectConstants.ACCESSORIES_URL;
import static utils.ProjectConstants.BASE_TITLE;
import static utils.ProjectConstants.BASE_URL;
import static utils.ProjectConstants.CART_TITLE;
import static utils.ProjectConstants.CART_URL;
import static utils.ProjectConstants.MEN_TITLE;
import static utils.ProjectConstants.MEN_URL;
import static utils.ProjectConstants.PRIVACY_TITLE;
import static utils.ProjectConstants.PRIVACY_URL;
import static utils.ProjectConstants.SEARCH_TITLE;
import static utils.ProjectConstants.SEARCH_URL;
import static utils.ProjectConstants.SHOES_TITLE;
import static utils.ProjectConstants.SHOES_URL;
import static utils.ProjectConstants.TERMS_TITLE;
import static utils.ProjectConstants.TERMS_URL;
import static utils.ProjectConstants.WOMEN_TITLE;
import static utils.ProjectConstants.WOMEN_URL;

public class TestData {
    @DataProvider(name="NavigationBarAndHomeLinksTestData")
    public static Object[][] topMenuTestDataProvider() {
        return new Object[][]{
                {"nav a[href='/women']", WOMEN_URL,  WOMEN_TITLE},
                {"nav a[href='/men']", MEN_URL,  MEN_TITLE},
                {"nav a[href='/shoes']", SHOES_URL,  SHOES_TITLE},
                {"nav a[href='/accessories']", ACCESSORIES_URL,  ACCESSORIES_TITLE},
                {"nav .search-btn", SEARCH_URL, SEARCH_TITLE},
                {"nav a[href='/cart']", CART_URL, CART_TITLE},
                {"nav li a[href='/']", BASE_URL, BASE_TITLE},
                {"a[href='/terms']", TERMS_URL, TERMS_TITLE},
                {"a[href='/privacy']", PRIVACY_URL, PRIVACY_TITLE},
                {".collection-container > a[href='/women']", WOMEN_URL, WOMEN_TITLE},
                {".collection-container > a[href='/men']", MEN_URL, MEN_TITLE},
                {".collection-container > a[href='/accessories']", ACCESSORIES_URL, ACCESSORIES_TITLE},
        };
    }
}
