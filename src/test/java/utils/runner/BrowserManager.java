package utils.runner;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import utils.LoggerUtils;

public final class BrowserManager {

    public static Browser createBrowser(
            Playwright playwright, String browserName, boolean isHeadless, int slowMo
    ) {
        switch(browserName) {
            case "chromium" -> {
                return playwright.chromium()
                        .launch(new BrowserType.LaunchOptions()
                                .setHeadless(isHeadless)
                                .setSlowMo(slowMo));
            }
            case "firefox" -> {
                return playwright.firefox()
                        .launch(new BrowserType.LaunchOptions()
                                .setHeadless(isHeadless)
                                .setSlowMo(slowMo));
            }
            case "webkit" -> {
                return playwright.webkit()
                        .launch(new BrowserType.LaunchOptions()
                                .setHeadless(isHeadless)
                                .setSlowMo(slowMo));
            }
            default -> {
                LoggerUtils.logWarning("ERROR: " + browserName + "is NOT matched any options. Chromium is launched.");
                return playwright.chromium()
                        .launch(new BrowserType.LaunchOptions()
                                .setHeadless(isHeadless)
                                .setSlowMo(slowMo));
            }
        }
    }
}
