package com.ankur;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class NaukriUploader {
    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();

        // Use the pre-unzipped profile from workflow
        String profilePath = "./selenium-profile/myprofile";

        try {
            EdgeOptions options = new EdgeOptions();
            options.addArguments("user-data-dir=" + profilePath);

            WebDriver driver = new EdgeDriver(options);

            driver.get("https://www.naukri.com/mnjuser/profile");
            Thread.sleep(5000);

            WebElement uploadInput = driver.findElement(By.id("attachCV"));
            uploadInput.sendKeys("./resume/AnkurKarna_Resume.pdf");

            System.out.println("Resume uploaded successfully!");
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
