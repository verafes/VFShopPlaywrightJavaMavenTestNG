import com.microsoft.playwright.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import static utils.ProjectConstant.BASE_URL;

public class BaseTest {
    private Playwright playwright;
    private Browser browser;
    private BrowserContext context;
    private Page page;

    @BeforeSuite
    protected void beforeSuite() {
        playwright = Playwright.create();
    }

    @BeforeTest
    protected void beforeTest() {
        browser = playwright.chromium()
                .launch(
                        new BrowserType
                                .LaunchOptions()
                                .setHeadless(false)
                );
    }

    @BeforeMethod
    protected void beforeMethod() {
        context = browser.newContext();
        page = context.newPage();
        page.waitForTimeout(1000);
        page.navigate(BASE_URL);
    }

    @AfterMethod
    protected void afterMethod() {
        context.close();
    }

    @AfterSuite
    protected void afterSuits() {
        playwright.close();
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

