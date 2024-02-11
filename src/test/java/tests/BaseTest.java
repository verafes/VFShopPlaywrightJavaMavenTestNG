package tests;

import com.microsoft.playwright.*;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import utils.LoggerUtils;

import static utils.ProjectConstant.BASE_URL;

public class BaseTest {
    private final Playwright playwright = Playwright.create();;
    private final Browser browser = playwright.chromium()
            .launch(
                    new BrowserType
                            .LaunchOptions()
                            .setHeadless(false)
                            .setSlowMo(1500)

            );
    private BrowserContext context;
    private Page page;

    @BeforeSuite
    protected void beforeSuite() {
        if (playwright != null) {
            Reporter.log("-------Playwright is created", true);
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
    protected void beforeMethod() {
        context = browser.newContext();
        LoggerUtils.logInfo("Context created");

        page = context.newPage();
        LoggerUtils.logInfo("Page created");

        page.waitForTimeout(1000);
        page.navigate(BASE_URL);
    }

    @AfterMethod
    protected void closeContext() {
        if (page != null) {
            page.close();
            System.out.println("Page closed");
        }
        if (context != null) {
            context.close();
            System.out.println("Context closed");
        }
    }

    @AfterSuite
    protected void closeBrowserAndPlaywright() {
        if (browser != null) {
            browser.close();
            System.out.println("Browser closed");
        }
        if (playwright != null) {
            playwright.close();
            System.out.println("Playwright closed");
        }
    }

    public Page getPage() {
        return page;
    }

    public void setTestId(String id) {
        playwright.selectors().setTestIdAttribute(id);
    }

    public Locator getId(String testId) {
        setTestId("id");
        return page.getByTestId(testId);
    }
}

