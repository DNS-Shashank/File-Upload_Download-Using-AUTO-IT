package com.example;

import java.io.File;
import java.util.*;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AutoIT {

/*
 * AutoIT - Windows Automation Tool for File Upload Handling
 * 
 * CONCEPT: AutoIT automates Windows GUI interactions that Selenium cannot handle (OS-level dialogs)
 * PRIMARY USE: File upload dialogs, Windows authentication popups, system notifications
 * 
 * WORKFLOW:
 * 1. Selenium clicks upload button → Windows file dialog opens
 * 2. Selenium stops working (cannot interact with OS dialogs)
 * 3. AutoIT script takes control → selects file → clicks Open
 * 4. Control returns to Selenium for further web interactions
 * 
 * AUTOIT SCITE EDITOR SETUP:
 * 1. Download AutoIT from https://www.autoitscript.com/site/autoit/downloads/
 * 2. Install AutoIT (includes SciTE editor)
 * 3. Navigate: Start Menu → AutoIT v3 → SciTE Script Editor
 * 4. Write script → Save as .au3 → Press F7 to compile to .exe
 * 5. Use Window Info tool (Start Menu → AutoIT v3 → Au3Info) to identify controls

 * AUTOIT SCRIPT STEPS (.au3 file):
 * 1. ControlFocus("Open","","Edit1")                    // Focus on file path field
 * 2. ControlSetText("Open","","Edit1","C:\\file.txt")   // Set file path
 * 3. ControlClick("Open","","Button1")                  // Click Open button
 * 4. Save as .au3 → Compile to .exe → Call from Java

 * 
 * JAVA INTEGRATION:
 * Runtime.getRuntime().exec("path\\to\\script.exe");   // Execute AutoIT script
 * 
 * LIMITATIONS: Windows-only, requires script compilation, timing-dependent
 */


    public static void main(String[] args) throws IOException, InterruptedException {
        
        // Get current project directory
        String userDirPath = System.getProperty("user.dir");

        // Configure Chrome options for file download
       HashMap<String, Object> chromePrefs =  new HashMap<String, Object>() {{
            put("download.default_directory", userDirPath); // Set download directory
            put("profile.default_content_settings.popups", 0); // Disable download prompt
            put("safebrowsing.enabled", true); // Enable safe browsing
        }};

        // Set Chrome preferences for automatic download
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);

        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Navigate to file conversion site
        driver.get("https://smallpdf.com/png-to-pdf");
        driver.manage().window().maximize();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='l3tlg0-0 ggoliT']")));
        driver.findElement(By.cssSelector("button[class='l3tlg0-0 ggoliT']")).click();
        
        //uploading file using AutoIT script
        // Wait for file dialog to appear before executing AutoIT script
        Thread.sleep(2000);
        Runtime.getRuntime().exec("C:\\Users\\n" + //
                        "durthu\\OneDrive - Infor\\Documents\\WindSurf\\AUTO-IT\\AUTO-IT\\Auto-IT.exe");


        //Download the file
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Finish']")));
        driver.findElement(By.xpath("//span[text()='Finish']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Download']")));
        driver.findElement(By.xpath("//span[text()='Download']")).click();

        Thread.sleep(3000);

        //verify file downloaded

        File file = new File(userDirPath+"\\ima.pdf");
        if(file.exists()) {
            Assert.assertTrue(file.exists());
            System.out.println("File downloaded successfully");
            file.delete(); //cleanup - delete the file after verification
        } else {
            System.out.println("File not downloaded");
        }

        System.out.println(userDirPath+"\\ima.pdf");
        driver.quit();

        
    }

}
