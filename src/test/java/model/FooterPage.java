package model;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public abstract class FooterPage extends NavPage {

    private final Locator footerLogoLocator = getPage().getByRole(AriaRole.LINK).last();
    private final Locator forAboutLocator = getPage()
            .getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("About Company"));

    private final Locator forContactsLocator = getPage()
            .getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Contacts"));

    public FooterPage(Page page) {
        super(page);
    }

    public Locator getAboutHeading() {
        return forAboutLocator;
    }
}
