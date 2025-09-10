package com.ankur;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class NaukriUploader {
    public static void main(String[] args) {
        try {
            // Setup EdgeDriver
            WebDriverManager.edgedriver().setup();

            // Hardcoded profile path (unzipped in workflow)
            String profilePath = "./selenium-profile/myprofile";
            EdgeOptions options = new EdgeOptions();
            options.addArguments("user-data-dir=" + profilePath);

            // Initialize driver
            WebDriver driver = new EdgeDriver(options);

            // Go to Naukri profile page
            driver.get("https://www.naukri.com/mnjuser/profile");
            Thread.sleep(5000); // Wait for page load

            // Upload resume
            WebElement uploadInput = driver.findElement(By.id("attachCV"));
            uploadInput.sendKeys("./resume/AnkurKarna_Resume.pdf");

            System.out.println("Resume uploaded successfully!");
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
