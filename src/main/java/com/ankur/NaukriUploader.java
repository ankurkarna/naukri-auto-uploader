package com.ankur;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class NaukriUploader {

    public static void unzip(String zipFilePath, String destDir) throws IOException {
        File dir = new File(destDir);
        if (!dir.exists()) dir.mkdirs();
        byte[] buffer = new byte[1024];
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFilePath))) {
            ZipEntry zipEntry = zis.getNextEntry();
            while (zipEntry != null) {
                File newFile = new File(destDir, zipEntry.getName());
                if (zipEntry.isDirectory()) newFile.mkdirs();
                else {
                    new File(newFile.getParent()).mkdirs();
                    Files.copy(zis, newFile.toPath());
                }
                zipEntry = zis.getNextEntry();
            }
        }
    }

    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();

        String zipPath = "./selenium-profile/myprofile.zip";
        String extractPath = "./selenium-profile/myprofile";

        try {
            unzip(zipPath, extractPath);

            EdgeOptions options = new EdgeOptions();
            options.addArguments("user-data-dir=" + extractPath);

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
