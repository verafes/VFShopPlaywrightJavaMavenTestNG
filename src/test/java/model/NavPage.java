package model;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;


public abstract class NavPage extends BasePage {

    private final Locator logoLocator = getPage().getByRole(AriaRole.LINK).first();

     private final Locator logoImgLocator = getPage().getByRole(
            AriaRole.NAVIGATION).getByTitle("VFShop");
    private final Locator aboutMenuLocator = getPage().getByRole(
            AriaRole.LINK, new Page.GetByRoleOptions().setName("About"));
    private final Locator searchBtn = getPage().getByRole(
            AriaRole.BUTTON, new Page.GetByRoleOptions().setName("search"));
    private final Locator searchField = getPage().getByRole(
            AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("search"));

    private final Locator cartBtn = getPage().getByRole(
            AriaRole.BUTTON, new Page.GetByRoleOptions().setName("cart"));

    public NavPage(Page page) {
        super(page);
    }

    public Locator getLogoLocator() {
        return logoLocator;
    }

    public Locator getLogoIMGLocator() {
        return logoImgLocator;
    }
    public Locator getSearchBtn() {
        return searchBtn;
    }
    public Locator getSearchField() {
        return searchField;
    }
    public void clickLogo() {
        logoLocator.click();
    }
    public void clickMenu(String name) {
        getPage().getByRole(AriaRole.LIST).getByRole(
                AriaRole.LINK,
                new Locator.GetByRoleOptions().setName(name.toLowerCase()).setExact(true)
        ).click();
    }
    public void clickNav(String name) {
        getPage().getByRole(AriaRole.NAVIGATION).getByRole(
                AriaRole.LINK,
                new Locator.GetByRoleOptions().setName(name).setExact(true)
        ).click();
    }

    public void clickButton(String name) {
        getPage().getByRole(
                AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName(name).setExact(true)
        ).click();
    }

    public void clickLink(String name) {
        getPage().getByRole(
                AriaRole.LINK,
                new Page.GetByRoleOptions().setName(name)
        ).click();
    }
    public Locator getAboutMenu() {
        return aboutMenuLocator;
    }

    public void clickAboutMenu() {
        aboutMenuLocator.click();
    }
}
