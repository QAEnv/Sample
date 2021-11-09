package com.test.webstaurantstore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchBar {
    WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hamza\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.webstaurantstore.com/");
        driver.findElement(By.id("searchval")).sendKeys("stainless work table");
        driver.findElement(By.xpath("//button[@value='Search']")).click();
        List<WebElement> list = driver.findElements(By.xpath("//*[@id='product_listing']"));
        for (int i = 0; i < list.size(); i++) {
            String name = list.get(i).getText();
            if (name.contains("Table"))
                System.out.println(name);
            driver.findElement(By.xpath("//div[@data-item-number='600t2496g']//div[@class='add-to-cart']")).click();
            driver.findElement(By.xpath("//*[text()='View Cart']")).click();
            driver.findElement(By.xpath("//*[text()='Empty Cart']")).click();
            driver.findElement(By.xpath("//button[contains(text(),'Empty Cart')]")).click();
            driver.close();

        }

    }
}