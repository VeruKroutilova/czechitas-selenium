import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SearchTest {

    WebDriver browser;

    @Before
    public void SetUp() {
        //nastavte si prosím cestu k svemu driveru
        System.setProperty("webdriver.gecko.driver", "C:\\Java-Training\\Projects\\czechitas-selenium\\seleniumdriver\\geckodriver.exe");

        //muzete pouzit FirefoxOptions pokud chcete nebo jste meli problem s firefox binary
        browser = new FirefoxDriver();
    }

    @Test
    public void NejakyTest() throws InterruptedException {
        System.out.println("Jdu na homepage eshopu");
        browser.navigate().to("http://czechitas-shopizer.azurewebsites.net/shop/");

        System.out.println("Vypisuji urciteNeexistujiciKabelka do search pole");
        WebElement searchBox = browser.findElement(By.id("searchField"));
        searchBox.sendKeys("urciteNeexistujiciKabelka");

        Thread.sleep(2000);

        System.out.println("Klikam na Search button");
        WebElement searchButton = browser.findElement(By.className("searchButton"));
        searchButton.click();

        Thread.sleep(2000);

        System.out.println("Kontroluji presmerovani stranky");
        String currentUrl = browser.getCurrentUrl();
        Assert.assertEquals("Po klinuti na search button dojde k presmerovani na jinou url", "http://czechitas-shopizer.azurewebsites.net/shop/search/search.html", currentUrl);

        System.out.println("Kontroluji, ze bylo nalezeno 0 produktu");
        WebElement noItems = browser.findElement(By.id("products-qty"));
        Assert.assertEquals("Nalezeno 0 produktu", "0 item(s) found", noItems.getText());

    }

    @After
    public void CleanUp() {
        browser.quit();
    }
}

