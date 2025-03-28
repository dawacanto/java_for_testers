package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ApplicationManager {//настройки сессии
    public  WebDriver driver;//ссылка на запуск
    private LoginHelper session;//ссылка на объект логина
    public GroupHelper groups;//ссылка на методы работы с группами

    public void initial(String browser) {
        if (driver == null) {
            if ("chrome".equals(browser)) {
                driver = new ChromeDriver();
            } else if ("firefox".equals(browser)){
                driver = new FirefoxDriver();
            }else{
                throw new IllegalArgumentException(String.format("Unknown browser %s",browser));
            }
            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
            driver.get("http://localhost/addressbook/");
            driver.manage().window().setSize(new Dimension(1083, 961));
            driver.findElement(By.name("user")).click();
            session().login("admin", "secret");
        }
    }

    public LoginHelper session(){
        if (session == null){
            session = new LoginHelper(this);
        }return session;
}

public GroupHelper groups(){
        if (groups == null){
            groups = new GroupHelper(this);
        }return groups;
}

    protected boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

}
