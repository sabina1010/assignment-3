package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {

    public static void main(String[] args) {
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.33.0-win64\\geckodriver.exe");

        // Initialize ChromeDriver
        WebDriver driver = new FirefoxDriver();


        // WhatsApp Web URL
        String whatsappUrl = "https://web.whatsapp.com/";

        // Recipient name and message
        String recipientName = "Akbar";
        String message = "salam aleykum brother";

        // Open WhatsApp Web and display QR code
        driver.get(whatsappUrl);

        // Pause the script and wait for the user to scan the QR code manually
        System.out.println("Scan the QR code using your WhatsApp mobile app and press Enter after logging in...");
        new java.util.Scanner(System.in).nextLine();

        try {
            // Locate the search input field
            WebElement searchBox = driver.findElement(By.className("selectable-text copyable-text iq0m558w g0rxnol2"));

            // Type recipient name
            searchBox.sendKeys(recipientName);
            Thread.sleep(2000);  // Wait for the contact to load

            // Press Enter to open the chat
            searchBox.sendKeys(Keys.RETURN);

            // Wait for a while to ensure the chat is opened
            Thread.sleep(2000);

            // Locate the message input field
            WebElement messageBox = driver.findElement(By.className("selectable-text copyable-text iq0m558w g0rxnol2"));

            // Type the message and send
            messageBox.sendKeys(message);
            messageBox.sendKeys(Keys.RETURN);

            System.out.println("Message sent successfully.");

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            // Close the browser window after sending the message
            driver.quit();
        }
    }
}
