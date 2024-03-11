package tests;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.LoggerUtils;
import utils.runner.BrowserManager;
import utils.runner.ConfigProperties;

import static utils.ProjectConstant.BASE_URL;
import static utils.ProjectConstant.HOME_END_POINT;

public abstract class BaseTest {
    private final Playwright playwright = Playwright.create();
    private final Browser browser = BrowserManager.createBrowser(playwright, ConfigProperties.ENVIRONMENT_CHROMIUM);
    private BrowserContext context;
    private Page page;

    @BeforeSuite
    void checkIfPlaywrightCreatedAndBrowserLaunched() {
        if (playwright != null) {
            LoggerUtils.logInfo("Playwright is created");
        } else {
            LoggerUtils.logFatal("FATAL: Playwright is NOT created");
            System.exit(1);
        }

        if(browser.isConnected()) {
            LoggerUtils.logInfo("Browser is created");
        } else {
            LoggerUtils.logFatal("FATAL: Browser is NOT created");
            System.exit(1);
        }
    }

    @BeforeMethod
    void createContextAndPage() {
        context = browser.newContext();
        LoggerUtils.logInfo("Context created");

        page = context.newPage();
        LoggerUtils.logInfo("Page created");

        LoggerUtils.logInfo("Start test");

        page.waitForTimeout(1000);
        page.navigate(BASE_URL);

        if(isOnHomePage()) {
            LoggerUtils.logInfo("Base url is opened and content is not empty.");
        } else {
            LoggerUtils.logInfo("ERROR: Base url is NOT opened OR content is EMPTY.");
        }
    }

    @AfterMethod
    void closeContext() {
        if (page != null) {
            page.close();
            LoggerUtils.logInfo("Page closed");
        }
        if (context != null) {
            context.close();
            LoggerUtils.logInfo("Context closed");
        }
    }

    @AfterSuite
    void closeBrowserAndPlaywright() {
        if (browser != null) {
            browser.close();
            LoggerUtils.logInfo("Browser closed");
        }
        if (playwright != null) {
            playwright.close();
            LoggerUtils.logInfo("Playwright closed");
        }
    }

    public Page getPage() {
        return page;
    }

    private boolean isOnHomePage() {
        getPage().waitForLoadState();

        return getPage().url().equals(BASE_URL + HOME_END_POINT) && !page.content().isEmpty();
    }

    protected boolean getIsOnHomePage() {

        return isOnHomePage();
    }

    public void setTestId(String id) {
        playwright.selectors().setTestIdAttribute(id);
    }

    public Locator getId(String testId) {
        setTestId("id");

        return page.getByTestId(testId);
    }
}

