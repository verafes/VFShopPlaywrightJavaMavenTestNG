package model;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import model.base.FooterPage;

public class HomePage extends FooterPage {
    private final Locator heroMotoBannerIMG = getPage()
            .getByRole(AriaRole.BANNER).locator("img");
    private final Locator heroMotoBannerText = getPage().locator(".sub-heading");
    private final Locator forHerLocator = getPage()
            .getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("For Her"));
    private final Locator forHimLocator = getPage()
            .getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("For Him"));
    private final Locator forAccessoriesLocator = getPage()
            .getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Accessories"));
    private final Locator sliderBestSellingHeading = getPage()
            .getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Best selling"));
    public HomePage(Page page) {
        super(page);
    }

    public Page page() {
        return getPage();
    }

    public Locator getForHerLocator() {
        return forHerLocator;
    }
    public Locator getForHimLocator() {
        return forHimLocator;
    }
    public Locator getAccessoriesLocator() {
        return forAccessoriesLocator;
    }
    public void clickForFerLink() {
        forHerLocator.click();
    }
    public void clickForHimMenu() {
        forHerLocator.click();
    }

}
