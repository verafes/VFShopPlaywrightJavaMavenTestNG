package model.base;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import model.base.MainPage;


public abstract class NavPage extends MainPage {

    private final Locator logoLocator = getPage().getByRole(AriaRole.LINK).first();

     private final Locator logoImgLocator = getPage().getByRole(
            AriaRole.NAVIGATION).getByTitle("VFShop");
    private final Locator heroLogoImgLocator = getPage().getByLabel("VFShop");
    private final Locator heroMottoLocator = getPage().locator(".sub-heading");
    private final Locator aboutMenuLocator = getPage().getByRole(
            AriaRole.LINK, new Page.GetByRoleOptions().setName("About"));
    private final Locator searchBtn = getPage().getByRole(
            AriaRole.BUTTON, new Page.GetByRoleOptions().setName("search"));
    private final Locator searchField = getPage().getByRole(
            AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("search"));

    private final Locator cartBtn = getPage().getByRole(
            AriaRole.BUTTON, new Page.GetByRoleOptions().setName("cart").setExact(true));

    public NavPage(Page page) {
        super(page);
    }

    public Locator getLogoLocator() {
        return logoLocator;
    }

    public Locator getLogoIMGLocator() {
        return logoImgLocator;
    }

    public Locator getHeroLogoIMGLocator() {
        return heroLogoImgLocator;
    }

    public Locator getHeroMottoLocator() {
        return heroMottoLocator;
    }

    public Locator getSearchBtn() {
        return searchBtn;
    }

    public Locator getSearchField() {
        return searchField;
    }

    public Locator getCartBtn() {
        return cartBtn;
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
