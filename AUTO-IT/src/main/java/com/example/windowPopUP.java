package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class windowPopUP {

    public static void main(String[] args) {

        // Handle browser-level popups (alerts, confirms, prompts) using Selenium's Alert interface
        // Window popups can't be handled by Selenium alone - need AutoIT for OS-level dialogs
        // Alternative: Bypass auth popups by embedding credentials in URL: https://username:password@domain.com
        // This method avoids popup handling but works only for basic authentication
       
        WebDriver driver = new ChromeDriver();
        driver.get("https://admin:admin@the-internet.herokuapp.com");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Basic Auth")).click();



    }

}
