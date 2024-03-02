package utils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProjectConstant {

    public static final String BASE_URL = "http://localhost:3000";
    public static final String HOME_END_POINT = "/";
    public static final String WOMEN_URL = BASE_URL + "/women";
    public static final String MEN_URL = BASE_URL + "/men";
    public static final String SHOES_URL = BASE_URL + "/shoes";
    public static final String ACCESSORIES_URL = BASE_URL + "/accessories";
    public static final String SEARCH_URL = BASE_URL + "/search/";
    public static final String CART_URL = BASE_URL + "/cart";
    public static final String ABOUT_URL = BASE_URL + HOME_END_POINT + "#footer-about";
    public static final String TERMS_URL = BASE_URL + "/terms";
    public static final String PRIVACY_URL = BASE_URL + "/privacy";

    public static final String BASE_TITLE = "VF | Elegant Clothing For Her and For Him";
    public static final String LOGO_IMG_SRC = "../img/logo-green.png";
    public static final String MOTTO = "Where Style Meets Elegance\nAnd Fashion Knows No Bounds";
    public static final String WOMEN_TITLE = "VF Shop | For Her";
    public static final String MEN_TITLE = "VF Shop | For Him";
    public static final String SHOES_TITLE = "VF Shop | Shoes";
    public static final String ACCESSORIES_TITLE = "VF Shop | Accessories";
    public static final String SEARCH_TITLE = "VF Shop | Search Results";
    public static final String SEARCH_PLACEHOLDER = "search brand product";
    public static final String CART_TITLE = "VF Shop | Cart";
    public static final String FOR_HER_COLLECTION_TITLE = "For Her";
    public static final String FOR_HIM_COLLECTION_TITLE = "For Him";
    public static final String ACCESSORIES_COLLECTION_TITLE = "Accessories";

    /* sliders */
    public static final List<String> HOME_SLIDERS_HEADINGS = List.of(
            "Best Selling", "New Arrivals", "Women Hot Specials", "Shoes", "Men T-Shirt", "Cozy Winter Deals"
    );

    /* footer */
    public static final String ABOUT_HEADING = "ABOUT COMPANY:";
    public static final String TERMS_TITLE = "VF Shop | Terms and Conditions";
    public static final String PRIVACY_TITLE = "VF Shop | Privacy Policy";

}
