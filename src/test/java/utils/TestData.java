package utils;

import org.testng.annotations.DataProvider;

import static utils.ProjectConstant.ABOUT_URL;
import static utils.ProjectConstant.ACCESSORIES_TITLE;
import static utils.ProjectConstant.ACCESSORIES_URL;
import static utils.ProjectConstant.BASE_TITLE;
import static utils.ProjectConstant.BASE_URL;
import static utils.ProjectConstant.CART_TITLE;
import static utils.ProjectConstant.CART_URL;
import static utils.ProjectConstant.MEN_TITLE;
import static utils.ProjectConstant.MEN_URL;
import static utils.ProjectConstant.PRIVACY_TITLE;
import static utils.ProjectConstant.PRIVACY_URL;
import static utils.ProjectConstant.SEARCH_TITLE;
import static utils.ProjectConstant.SEARCH_URL;
import static utils.ProjectConstant.SHOES_TITLE;
import static utils.ProjectConstant.SHOES_URL;
import static utils.ProjectConstant.TERMS_TITLE;
import static utils.ProjectConstant.TERMS_URL;
import static utils.ProjectConstant.WOMEN_TITLE;
import static utils.ProjectConstant.WOMEN_URL;

public class TestData {
    @DataProvider(name="NavigationBarTestData")
    public static Object[][] topMenuTestDataProvider() {

        return new Object[][]{
                {"Home", BASE_URL, BASE_TITLE},
                {"Women", WOMEN_URL,  WOMEN_TITLE},
                {"Men", MEN_URL, MEN_TITLE},
                {"Shoes", SHOES_URL, SHOES_TITLE},
                {"Accessories", ACCESSORIES_URL, ACCESSORIES_TITLE},
                {"About", ABOUT_URL, BASE_TITLE},
        };
    }

    @DataProvider(name="LogoTestData")
    public static Object[][] logoTestDataProvider() {
        return new Object[][]{
                {"Home", BASE_URL},
                {"Women", WOMEN_URL},
                {"Men", MEN_URL},
                {"Shoes", SHOES_URL},
                {"Accessories", ACCESSORIES_URL},
                {"For Her", WOMEN_URL},
                {"For Him", MEN_URL},
                {"Search", "nav .search-btn", SEARCH_URL, SEARCH_TITLE},
        };
    }

    @DataProvider(name="NavButtonsTestData")
    public static Object[][]NavButtonsDataProvider() {
        // String option, String expectedURL, String expectedTitle
        return new Object[][]{
                {"submit search", SEARCH_URL, SEARCH_TITLE},
                {"Cart", CART_URL, CART_TITLE},
                {"Wishlist", CART_URL, CART_TITLE},
        };
    }

    @DataProvider(name="NavAndHomeLinksTestData")
    public static Object[][] homeLinksDataProvider() {
        // String option, String expectedURL, String expectedTitle
        return new Object[][]{
                {"For Her", WOMEN_URL, WOMEN_TITLE},
                {"For Him", MEN_URL, MEN_TITLE},
                {"accessories collection accessories", ACCESSORIES_URL, ACCESSORIES_TITLE},
                {"Terms And Conditions", TERMS_URL, TERMS_TITLE},
                {"Privacy Policy", PRIVACY_URL, PRIVACY_TITLE}
        };
    }
}
