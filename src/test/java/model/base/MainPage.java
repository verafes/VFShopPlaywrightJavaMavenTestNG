package model.base;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import java.util.List;

public abstract class MainPage extends BasePage {

    //Headers
    private final Locator h1Header = getPage().locator("h1");
    private final Locator h2Header = getPage().locator("h2");
    private final Locator h3Header = getPage().locator("h3");
    
    public MainPage(Page page) {
        super(page);
    }

    public String getH1LogoHeaderText() {

        return h1Header.innerText();
    }
}
