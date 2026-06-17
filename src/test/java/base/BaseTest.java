package base;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.ConfigReader;

public class BaseTest {

    protected WebDriver driver;
    protected String baseUrl;
    protected String validUsername;
    protected String validPassword;

    @BeforeMethod
    public void setUp() {
        baseUrl = ConfigReader.get("baseUrl");
        validUsername = ConfigReader.get("username");
        validPassword = ConfigReader.get("password");

        String browser = ConfigReader.get("browser");
        if (!"chrome".equalsIgnoreCase(browser)) {
            throw new IllegalArgumentException("Only chrome is configured right now. Found: " + browser);
        }

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    } 

    public String captureScreenshot(String testName) {
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String folderPath = System.getProperty("user.dir") + File.separator + "test-output" + File.separator + "screenshots";
        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        String screenshotPath = folderPath + File.separator + testName + ".png";

        try {
            Files.copy(source.toPath(), new File(screenshotPath).toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save screenshot: " + screenshotPath, e);
        }

        return screenshotPath;
    }
}
