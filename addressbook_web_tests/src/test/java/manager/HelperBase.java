package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.nio.file.Paths;

public class HelperBase {
    protected final ApplicationManager manager;

    public HelperBase(ApplicationManager manager) {
        this.manager = manager;
    }

    protected void type(By locator, String text) {
        click(locator);
        manager.driver.findElement(locator).clear();
        manager.driver.findElement(locator).sendKeys(text);
    }

    protected void click(By locator) {
        manager.driver.findElement(locator).click();
    }

    protected void selecter(String pointer, String number){
        WebElement dropdown = manager.driver.findElement(By.name(pointer));
        dropdown.findElement(By.xpath(".//option[. = '" + number + "']")).click();
    }

    protected void attach(By locator, String file){
        manager.driver.findElement(locator).sendKeys(Paths.get(file).toAbsolutePath().toString());
    }

    protected void refresh(){
        manager.driver.navigate().refresh();
    }
}
