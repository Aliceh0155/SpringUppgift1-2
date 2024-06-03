package com.example.springuppgift12;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class titleTest {

    ChromeDriver driver;
    @BeforeAll
    public static void init(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
    }

    @AfterEach
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }

    @Test
    public void testHello(){
        driver.get("http://localhost:8080/hello");
        WebElement element = driver.findElement(By.tagName("h1"));
        assertEquals("Hello World", element.getText());
    }

    @Test
    public void testProducts(){
        driver.get("http://localhost:8080/products");
        List<WebElement> products = driver.findElements(By.tagName("div"));

        WebElement firstProduct = products.get(0);
        assertTrue(firstProduct.getText().contains("TV Samsung"), "Product name should be present");

    }


    @Test
    public void testWebsiteTitle() {

        driver.get("https://www.slao.se/");

        assertEquals("Startsida – Svenska Skidanläggningar", driver.getTitle(), "titeln stämmer");
    }
}
