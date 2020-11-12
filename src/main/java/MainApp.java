
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MainApp {

    public static void main(String[] args) {
        //nastavte si prosím cestu k svemu driveru
        System.setProperty("webdriver.gecko.driver", "C:\\Java-Training\\Projects\\czechitas-selenium\\seleniumdriver\\geckodriver.exe");

        //muzete pouzit FirefoxOptions pokud chcete nebo jste meli problem s firefox binary
        WebDriver browser = new FirefoxDriver();

        // metody ktere budeme pouzivat muzou vyhodit vyjimku a proto budeme operace delat v bloku try
        try {

            // do toho bloku piste kod
            browser.navigate().to("http://czechitas-shopizer.azurewebsites.net/shop/");

            //cviceni 2
            //search box element
            WebElement searchBox = browser.findElement(By.id("searchField"));
            searchBox.sendKeys("neco");
            Thread.sleep(5000);

            //search button element
            WebElement searchButton = browser.findElement(By.className("searchButton"));
            searchButton.click();
            Thread.sleep(5000);

            //cviceni 3
            searchBox.getAttribute("class");
            System.out.println("Class je:" + searchBox.getAttribute("class"));

            //cviceni 4
            //xpath je v tomto případě sice složitá ale slouží k ukázce jak lze kombinovat různé attributy web elementu pro jeho hledání
            WebElement searchBox2 = browser.findElement(By.xpath("//*[@autocomplete=\"off\" and @spellcheck=\"false\" and @dir=\"auto\"]"));
            // vrati hodnotu atributu id a ulozi ji do promene
            String idValue = searchBox2.getAttribute("id");
            System.out.println("Řešení třetího cvičení je hodnota id, ktere lze taky použít pro hledání tohoto elementu: " + idValue);

        } catch (Exception ex) {
            // catch blok slouzi ke zpracovani vyjimky, v nasem pripade nechame vyjimku byt
            System.out.println("Bohuzel doslo k chybe. Jedna z poslednich informaci by mel byt: (Main.java:**cislo radku kde chyba vznikla**) ");

            ex.printStackTrace();
            
        } finally {
            // blok finally nam v tomto pripade poslouzi k tomu aby se WebDriver ukoncil spravne za kazdych okolnosti

            browser.quit();
        }
    }
}
