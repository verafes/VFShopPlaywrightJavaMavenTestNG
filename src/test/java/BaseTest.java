import com.microsoft.playwright.*;
import org.testng.annotations.*;


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
        page.navigate("http://localhost:3000/");
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
}

