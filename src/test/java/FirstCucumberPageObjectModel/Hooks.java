package FirstCucumberPageObjectModel;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.util.concurrent.TimeUnit;

public class Hooks extends BasePage {
    BrowserSelector browserSelector = new BrowserSelector();
    LoadProps props = new LoadProps();
    Utils utils = new Utils();

    @Before
    public void setupBrowser() {
        browserSelector.setUpBrowser();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.manage().window().fullscreen();
        driver.get(props.getProperty("url"));
    }

    @After
    public void closeBrowser(Scenario scenario) {
        if (scenario.isFailed()) {
            utils.takeScreenshot(scenario.getName());
        }
        driver.close();
    }
}
